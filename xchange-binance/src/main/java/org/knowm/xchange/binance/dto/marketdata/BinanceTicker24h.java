package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xingyu
 */
public final class BinanceTicker24h {
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
    private final BigDecimal prevClosePrice;
    /**
     * 最近一次成交价
     */
    private final BigDecimal lastPrice;
    /**
     * 最近一次成交额
     */
    private final BigDecimal lastQty;
    private final BigDecimal bidPrice;
    private final BigDecimal bidQty;
    private final BigDecimal askPrice;
    private final BigDecimal askQty;
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

    /**
     * 交易对
     */
    private CurrencyPair pair;

    /**
     * 行情
     */
    private Ticker ticker;

    public BinanceTicker24h(
            @JsonProperty("priceChange") BigDecimal priceChange,
            @JsonProperty("priceChangePercent") BigDecimal priceChangePercent,
            @JsonProperty("weightedAvgPrice") BigDecimal weightedAvgPrice,
            @JsonProperty("prevClosePrice") BigDecimal prevClosePrice,
            @JsonProperty("lastPrice") BigDecimal lastPrice,
            @JsonProperty("lastQty") BigDecimal lastQty,
            @JsonProperty("bidPrice") BigDecimal bidPrice,
            @JsonProperty("bidQty") BigDecimal bidQty,
            @JsonProperty("askPrice") BigDecimal askPrice,
            @JsonProperty("askQty") BigDecimal askQty,
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
        this.prevClosePrice = prevClosePrice;
        this.lastPrice = lastPrice;
        this.lastQty = lastQty;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
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

    public String getSymbol() {
        return symbol;
    }

    public CurrencyPair getCurrencyPair() {
        return pair;
    }

    public void setCurrencyPair(CurrencyPair pair) {
        this.pair = pair;
    }

    public BigDecimal getPriceChange() {
        return priceChange;
    }

    public BigDecimal getPriceChangePercent() {
        return priceChangePercent;
    }

    public BigDecimal getWeightedAvgPrice() {
        return weightedAvgPrice;
    }

    public BigDecimal getPrevClosePrice() {
        return prevClosePrice;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public BigDecimal getLastQty() {
        return lastQty;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public BigDecimal getBidQty() {
        return bidQty;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
    }

    public BigDecimal getAskQty() {
        return askQty;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getQuoteVolume() {
        return quoteVolume;
    }

    public long getFirstTradeId() {
        return firstId;
    }

    public long getLastTradeId() {
        return lastId;
    }

    public long getTradeCount() {
        return count;
    }

    public Date getOpenTime() {
        return new Date(openTime);
    }

    public Date getCloseTime() {
        return new Date(closeTime);
    }

    public synchronized Ticker toTicker() {
        CurrencyPair currencyPair = pair;
        if (currencyPair == null) {
            currencyPair = BinanceAdapters.adaptSymbol(symbol);
        }
        if (ticker == null) {
            ticker =
                    new Ticker.Builder()
                            .currencyPair(currencyPair)
                            .open(openPrice)
                            .ask(askPrice)
                            .bid(bidPrice)
                            .last(lastPrice)
                            .high(highPrice)
                            .low(lowPrice)
                            .volume(volume)
                            .vwap(weightedAvgPrice)
                            .askSize(askQty)
                            .bidSize(bidQty)
                            .quoteVolume(quoteVolume)
                            .build();
        }
        return ticker;
    }
}
