package info.bitrich.xchangestream.core;

import io.reactivex.Observable;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.exceptions.ExchangeSecurityException;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.service.account.AccountService;

/**
 * @author 99121
 */
public interface StreamingAccountService {

    /**
     * 获取已登录用户的帐户余额更改。
     *
     * <p> <strong>警告</ strong>：目前无法保证邮件会到达
     * 命令，将不跳过消息，或将发送任何初始状态消息
     * 连接。 大多数交易所都有推荐的管理方法，包括时间戳，
     * 出现不一致时，将使用序列号和单独的REST API进行重新同步。 你应该
     * 如果需要，可以通过将对此方法的调用与 {@link AccountService#getAccountInfo()}.
     *
     * <p><strong>Emits</strong> {@link
     * info.bitrich.xchangestream.service.exception.NotConnectedException} 未连接到WebSocket API时。
     *
     * <p><strong>Immediately throws</strong> {@link ExchangeSecurityException} 如果在没有身份验证详细信息的情况下调用
     *
     * @param currency 要监视的货币。
     * @return {@link Observable} that emits {@link Balance} when exchange sends the update.
     */
    default Observable<Balance> getBalanceChanges(Currency currency, Object... args) {
        throw new NotYetImplementedForExchangeException("getBalanceChanges");
    }
}
