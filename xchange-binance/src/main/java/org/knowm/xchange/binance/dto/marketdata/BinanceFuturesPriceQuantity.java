package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * 当前最优挂单
 *
 * @author xingyu
 */
public final class BinanceFuturesPriceQuantity {
    /**
     * 交易对
     */
    public final String symbol;
    /**
     * 最高买单 价格
     */
    public final BigDecimal bidPrice;
    /**
     * 最高买单 数量
     */
    public final BigDecimal bidQty;
    /**
     * 最低卖单 价格
     */
    public final BigDecimal askPrice;
    /**
     * 最低卖单 数量
     */
    public final BigDecimal askQty;

    public final long time;

    public BinanceFuturesPriceQuantity(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("bidPrice") BigDecimal bidPrice,
            @JsonProperty("bidQty") BigDecimal bidQty,
            @JsonProperty("askPrice") BigDecimal askPrice,
            @JsonProperty("askQty") BigDecimal askQty,
            @JsonProperty("time") long time) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
        this.time = time;
    }
}
