package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.Currency;

import java.math.BigDecimal;

/**
 * 资产信息
 * @author xingyu
 */
public final class BinanceBalance {
    /**
     * 交易对
     */
    private final Currency currency;
    /**
     * 账户余额
     */
    private final BigDecimal free;
    /**
     * 锁定中
     */
    private final BigDecimal locked;

    public BinanceBalance(
            @JsonProperty("asset") String asset,
            @JsonProperty("free") BigDecimal free,
            @JsonProperty("locked") BigDecimal locked) {
        this.currency = Currency.getInstance(asset);
        this.locked = locked;
        this.free = free;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getTotal() {
        return free.add(locked);
    }

    public BigDecimal getAvailable() {
        return free;
    }

    public BigDecimal getLocked() {
        return locked;
    }

    public String toString() {
        return "[" + currency + ", free=" + free + ", locked=" + locked + "]";
    }
}
