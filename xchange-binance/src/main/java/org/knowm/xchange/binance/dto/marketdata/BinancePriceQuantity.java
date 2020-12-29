package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * 当前最优挂单
 *
 * @author xingyu
 */
public final class BinancePriceQuantity {
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

    public BinancePriceQuantity(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("bidPrice") BigDecimal bidPrice,
            @JsonProperty("bidQty") BigDecimal bidQty,
            @JsonProperty("askPrice") BigDecimal askPrice,
            @JsonProperty("askQty") BigDecimal askQty) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
    }
}
