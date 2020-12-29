package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.utils.Assert;
import org.knowm.xchange.utils.jackson.CurrencyPairDeserializer;

import java.math.BigDecimal;

/**
 * 价格
 *
 * @author xingyu
 */
public final class BinanceFuturesPrice implements Comparable<BinanceFuturesPrice> {
    /**
     * 交易对
     */
    private final CurrencyPair pair;
    /**
     * 价格
     */
    private final BigDecimal price;
    /**
     * 撮合引擎时间
     */
    private final long time;

    public BinanceFuturesPrice(
            @JsonProperty("symbol") String symbol, @JsonProperty("price") BigDecimal price, @JsonProperty("time") long time) {
        this(CurrencyPairDeserializer.getCurrencyPairFromString(symbol), price, time);
    }

    public BinanceFuturesPrice(CurrencyPair pair, BigDecimal price, long time) {
        Assert.notNull(price, "Null price");
        Assert.notNull(pair, "Null pair");
        this.pair = pair;
        this.price = price;
        this.time = time;
    }

    public CurrencyPair getCurrencyPair() {
        return pair;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(BinanceFuturesPrice o) {
        if (pair.compareTo(o.pair) == 0) {
            return price.compareTo(o.price);
        }
        return pair.compareTo(o.pair);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((pair == null) ? 0 : pair.hashCode());
        result = 31 * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinanceFuturesPrice)) {
            return false;
        }
        BinanceFuturesPrice other = (BinanceFuturesPrice) obj;
        return pair.equals(other.pair) && price.equals(other.price);
    }

    @Override
    public String toString() {
        return "[" + pair + "] => " + price;
    }
}
