package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 24hr价格变动情况
 *
 * @author xingyu
 */
@Data
public final class BinanceFuturesTicker24h {
    /**
     * 24小时价格变动
     */
    private final BigDecimal priceChange;
    /**
     * 24小时价格变动百分比
     */
    private final BigDecimal priceChangePercent;
    /**
     * 加权平均价
     */
    private final BigDecimal weightedAvgPrice;
    /**
     * 最近一次成交价
     */
    private final BigDecimal lastPrice;
    /**
     * 最近一次成交额
     */
    private final BigDecimal lastQty;
    /**
     * 24小时内第一次成交的价格
     */
    private final BigDecimal openPrice;
    /**
     * 24小时最高价
     */
    private final BigDecimal highPrice;
    /**
     * 24小时最低价
     */
    private final BigDecimal lowPrice;
    /**
     * 24小时成交量
     */
    private final BigDecimal volume;
    /**
     * 24小时成交额
     */
    private final BigDecimal quoteVolume;
    /**
     * 24小时内，第一笔交易的发生时间
     */
    private final long openTime;
    /**
     * 24小时内，最后一笔交易的发生时间
     */
    private final long closeTime;
    /**
     * 首笔成交id
     */
    private final long firstId;
    /**
     * 末笔成交id
     */
    private final long lastId;
    /**
     * 成交笔数
     */
    private final long count;
    /**
     * 交易对
     */
    private final String symbol;

    public BinanceFuturesTicker24h(
            @JsonProperty("priceChange") BigDecimal priceChange,
            @JsonProperty("priceChangePercent") BigDecimal priceChangePercent,
            @JsonProperty("weightedAvgPrice") BigDecimal weightedAvgPrice,
            @JsonProperty("lastPrice") BigDecimal lastPrice,
            @JsonProperty("lastQty") BigDecimal lastQty,
            @JsonProperty("openPrice") BigDecimal openPrice,
            @JsonProperty("highPrice") BigDecimal highPrice,
            @JsonProperty("lowPrice") BigDecimal lowPrice,
            @JsonProperty("volume") BigDecimal volume,
            @JsonProperty("quoteVolume") BigDecimal quoteVolume,
            @JsonProperty("openTime") long openTime,
            @JsonProperty("closeTime") long closeTime,
            @JsonProperty("firstId") long firstId,
            @JsonProperty("lastId") long lastId,
            @JsonProperty("count") long count,
            @JsonProperty("symbol") String symbol) {
        this.priceChange = priceChange;
        this.priceChangePercent = priceChangePercent;
        this.weightedAvgPrice = weightedAvgPrice;
        this.lastPrice = lastPrice;
        this.lastQty = lastQty;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.volume = volume;
        this.quoteVolume = quoteVolume;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.firstId = firstId;
        this.lastId = lastId;
        this.count = count;
        this.symbol = symbol;
    }


}
