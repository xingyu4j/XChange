package info.bitrich.xchangestream.binance;

import static java.util.concurrent.TimeUnit.SECONDS;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.knowm.xchange.binance.BinanceAuthenticated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 必须首先通过经过身份验证的REST API请求唯一的“侦听密钥”来建立Binance用户数据流，
 * 然后将其用于创建模糊的WS URI（而不是对Web套接字进行身份验证）。
 * 此类处理最初对侦听键的请求，但也处理保持套接字打开所必需的30分钟的keepalive REST调用。
 * 它还考虑到延长的停机时间可能导致侦听密钥过期而无法更新它的可能性。
 * 在这种情况下，将请求一个新的侦听键，并且可以通过异步回调向调用者发出警报，以使用新的侦听键重新建立套接字。
 *
 * @author Graham Crockford
 */
class BinanceUserDataChannel implements AutoCloseable {

  private static final Logger LOG = LoggerFactory.getLogger(BinanceUserDataChannel.class);

  private final BinanceAuthenticated binance;
  private final String apiKey;
  private final Runnable onApiCall;
  private final Disposable keepAlive;

  private String listenKey;
  private Consumer<String> onChangeListenKey;

  /**
   * Creates the channel, establishing a listen key (immediately available from {@link
   * #getListenKey()}) and starting timers to ensure the channel is kept alive.
   *
   * @param binance Access to binance services.
   * @param apiKey The API key.
   * @param onApiCall A callback to perform prior to any service calls.
   */
  BinanceUserDataChannel(BinanceAuthenticated binance, String apiKey, Runnable onApiCall) {
    this.binance = binance;
    this.apiKey = apiKey;
    this.onApiCall = onApiCall;
    openChannel();
    // Send a keepalive every 30 minutes as recommended by Binance
    this.keepAlive = Observable.interval(30, TimeUnit.MINUTES).subscribe(x -> keepAlive());
  }

  /**
   * Set this callback to get notified if the current listen key is revoked.
   *
   * @param onChangeListenKey The callback.
   */
  void onChangeListenKey(Consumer<String> onChangeListenKey) {
    this.onChangeListenKey = onChangeListenKey;
  }

  private void keepAlive() {
    if (listenKey == null) return;
    try {
      LOG.debug("Keeping user data channel alive");
      onApiCall.run();
      binance.keepAliveUserDataStream(apiKey, listenKey);
      LOG.debug("User data channel keepalive sent successfully");
    } catch (Exception e) {
      LOG.error("User data channel keepalive failed.", e);
      this.listenKey = null;
      reconnect();
    }
  }

  private void reconnect() {
    try {
      openChannel();
      if (onChangeListenKey != null) {
        onChangeListenKey.accept(this.listenKey);
      }
    } catch (Exception e) {
      LOG.error("Failed to reconnect. Will retry in 15 seconds.", e);
      Observable.timer(15, SECONDS).subscribe(x -> reconnect());
    }
  }

  private void openChannel() {
    try {
      LOG.debug("Opening new user data channel");
      onApiCall.run();
      this.listenKey = binance.startUserDataStream(apiKey).getListenKey();
      LOG.debug("Opened new user data channel");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * @return The current listen key.
   * @throws NoActiveChannelException If no listen key is currently available.
   */
  String getListenKey() throws NoActiveChannelException {
    if (listenKey == null) throw new NoActiveChannelException();
    return listenKey;
  }

  @Override
  public void close() {
    keepAlive.dispose();
  }

  /**
   * Thrown on calls to {@link BinanceUserDataChannel#getListenKey()} if no channel is currently
   * open.
   *
   * @author Graham Crockford
   */
  static final class NoActiveChannelException extends Exception {

    private static final long serialVersionUID = -8161003286845820286L;

    NoActiveChannelException() {
      super();
    }
  }
}
