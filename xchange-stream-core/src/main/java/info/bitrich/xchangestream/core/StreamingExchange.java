package info.bitrich.xchangestream.core;

import info.bitrich.xchangestream.service.ConnectableService;
import info.bitrich.xchangestream.service.netty.ConnectionStateModel.State;
import info.bitrich.xchangestream.service.netty.NettyStreamingService;
import io.netty.channel.ChannelHandlerContext;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;

/**
 * @author 99121
 */
public interface StreamingExchange extends Exchange {
    String USE_SANDBOX = "Use_Sandbox";
    String ACCEPT_ALL_CERITICATES = "Accept_All_Ceriticates";
    String ENABLE_LOGGING_HANDLER = "Enable_Logging_Handler";
    String SOCKS_PROXY_HOST = "SOCKS_Proxy_Host";
    String SOCKS_PROXY_PORT = "SOCKS_Proxy_Port";
    String AUTO_RECONNECT = "Auto_Reconnect";
    String L3_ORDERBOOK = "L3_Orderbook";

    /**
     * 连接到交换的WebSocket API。
     *
     * @param args 产品订阅仅在某些交换中使用，您需要在连接阶段指定订阅。
     * @return {@link Completable} 成功连接后完成。
     */
    Completable connect(ProductSubscription... args);

    /**
     * 断开与WebSocket API的连接。
     *
     * @return {@link Completable} 成功断开连接后完成。
     */
    Completable disconnect();

    /**
     * 检查与交换机的连接是否有效。
     *
     * @return 如果连接已打开，则为true，否则为false。
     */
    boolean isAlive();

    /**
     * 可观察到重新连接失败事件。 发生这种情况时，通常表明服务器或网络已关闭。
     *
     * @return 在重新连接期间可以观察到异常。
     */
    default Observable<Throwable> reconnectFailure() {
        throw new NotYetImplementedForExchangeException("reconnectFailure");
    }

    /**
     * 可观察到连接成功事件。 发生这种情况时，通常表明服务器或网络已关闭。
     *
     * @return 在重新连接期间可以观察到异常。
     */
    default Observable<Object> connectionSuccess() {
        throw new NotYetImplementedForExchangeException("connectionSuccess");
    }

    /**
     * 可观察到断开事件。
     *
     * @return 可通过ChannelHandlerContext观察到
     */
    default Observable<ChannelHandlerContext> disconnectObservable() {
        throw new NotYetImplementedForExchangeException("disconnectObservable");
    }

    /**
     * 对于connectionState可观察到。 设计用于替换连接成功重新连接失败断开连接可观察
     *
     * @return Observable
     */
    default Observable<State> connectionStateObservable() {
        throw new NotYetImplementedForExchangeException("connectionState");
    }

    /**
     * 可观察消息延迟度量。 每次客户端收到带有时间戳的消息时，都会计算延迟时间并将其推送给订户。
     *
     * @return Observable with the message delay measure.
     */
    default Observable<Long> messageDelay() {
        throw new NotYetImplementedForExchangeException("messageDelay");
    }

    default void resubscribeChannels() {
        throw new NotYetImplementedForExchangeException("resubscribeChannels");
    }

    default Observable<Object> connectionIdle() {
        throw new NotYetImplementedForExchangeException("connectionIdle");
    }

    /**
     * 退货服务，可用于访问流式市场数据.
     */
    StreamingMarketDataService getStreamingMarketDataService();

    /**
     * 返回可用于访问流式帐户数据的服务.
     */
    default StreamingAccountService getStreamingAccountService() {
        throw new NotYetImplementedForExchangeException("getStreamingAccountService");
    }

    /**
     * 退货服务，可用于访问流式交易数据.
     */
    default StreamingTradeService getStreamingTradeService() {
        throw new NotYetImplementedForExchangeException("getStreamingTradeService");
    }

    /**
     * 设置是否启用压缩处理程序。
     *
     * @param compressedMessages Defaults to false
     */
    void useCompressedMessages(boolean compressedMessages);

    default void applyStreamingSpecification(
            ExchangeSpecification exchangeSpec, NettyStreamingService<?> streamingService) {
        streamingService.setSocksProxyHost(
                (String) exchangeSpec.getExchangeSpecificParametersItem(SOCKS_PROXY_HOST));
        streamingService.setSocksProxyPort(
                (Integer) exchangeSpec.getExchangeSpecificParametersItem(SOCKS_PROXY_PORT));
        streamingService.setBeforeConnectionHandler(
                (Runnable)
                        exchangeSpec.getExchangeSpecificParametersItem(
                                ConnectableService.BEFORE_CONNECTION_HANDLER));

        Boolean accept_all_ceriticates =
                (Boolean) exchangeSpec.getExchangeSpecificParametersItem(ACCEPT_ALL_CERITICATES);
        if (accept_all_ceriticates != null && accept_all_ceriticates) {
            streamingService.setAcceptAllCertificates(true);
        }

        Boolean enable_logging_handler =
                (Boolean) exchangeSpec.getExchangeSpecificParametersItem(ENABLE_LOGGING_HANDLER);
        if (enable_logging_handler != null && enable_logging_handler) {
            streamingService.setEnableLoggingHandler(true);
        }
        Boolean autoReconnect =
                (Boolean) exchangeSpec.getExchangeSpecificParametersItem(AUTO_RECONNECT);
        if (autoReconnect != null) streamingService.setAutoReconnect(autoReconnect);
    }
}
