package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 近期成交
 *
 * @author xingyu
 */
public final class BinanceAggTrades {
    /**
     * 归集成交ID
     */
    public final long aggregateTradeId;
    /**
     * 成交价
     */
    public final BigDecimal price;
    /**
     * 成交量
     */
    public final BigDecimal quantity;
    /**
     * 被归集的首个成交ID
     */
    public final long firstTradeId;
    /**
     * 被归集的末个成交ID
     */
    public final long lastTradeId;
    /**
     * 成交时间
     */
    public final long timestamp;
    /**
     * 是否为主动卖出单
     */
    public final boolean buyerMaker;
    /**
     * 是否为最优撮合单(可忽略，目前总为最优撮合)
     */
    public final boolean bestPriceMatch;

    public BinanceAggTrades(
            @JsonProperty("a") long aggregateTradeId,
            @JsonProperty("p") BigDecimal price,
            @JsonProperty("q") BigDecimal quantity,
            @JsonProperty("f") long firstTradeId,
            @JsonProperty("l") long lastTradeId,
            @JsonProperty("T") long timestamp,
            @JsonProperty("m") boolean buyerMaker,
            @JsonProperty("M") boolean bestPriceMatch) {
        this.aggregateTradeId = aggregateTradeId;
        this.price = price;
        this.quantity = quantity;
        this.firstTradeId = firstTradeId;
        this.lastTradeId = lastTradeId;
        this.timestamp = timestamp;
        this.buyerMaker = buyerMaker;
        this.bestPriceMatch = bestPriceMatch;
    }

    public Date getTimestamp() {
        return new Date(timestamp);
    }
}
