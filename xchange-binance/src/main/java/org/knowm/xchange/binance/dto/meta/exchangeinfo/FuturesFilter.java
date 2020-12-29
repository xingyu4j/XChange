package org.knowm.xchange.binance.dto.meta.exchangeinfo;

/**
 * 合约交易限制
 *
 * @author xingyu
 */
public class FuturesFilter {
    /**
     * 价格上限, 最大价格
     */
    private String maxPrice;
    /**
     * 限制类型
     * PRICE_FILTER 价格限制
     * LOT_SIZE 数量限制
     * MARKET_LOT_SIZE 市价订单数量限制
     * MAX_NUM_ORDERS 最多订单数限制
     * MAX_NUM_ALGO_ORDERS 最多条件订单数限制
     * PERCENT_PRICE 价格比限制
     */
    private String filterType;
    /**
     * 步进间隔
     */
    private String tickSize;
    /**
     * 价格下限, 最小价格
     */
    private String minPrice;
    /**
     * 数量下限, 最小数量
     */
    private String minQty;
    /**
     * 数量上限, 最大数量
     */
    private String maxQty;
    /**
     * 允许的步进值
     */
    private String stepSize;
    /**
     * 价格上限, 最大价格
     */
    private String minNotional;

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getTickSize() {
        return tickSize;
    }

    public void setTickSize(String tickSize) {
        this.tickSize = tickSize;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMinQty() {
        return minQty;
    }

    public void setMinQty(String minQty) {
        this.minQty = minQty;
    }

    public String getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(String maxQty) {
        this.maxQty = maxQty;
    }

    public String getStepSize() {
        return stepSize;
    }

    public void setStepSize(String stepSize) {
        this.stepSize = stepSize;
    }

    public String getMinNotional() {
        return minNotional;
    }

    public void setMinNotional(String minNotional) {
        this.minNotional = minNotional;
    }

    @Override
    public String toString() {
        return "Filter{"
                + "maxPrice='"
                + maxPrice
                + '\''
                + ", filterType='"
                + filterType
                + '\''
                + ", tickSize='"
                + tickSize
                + '\''
                + ", minPrice='"
                + minPrice
                + '\''
                + ", minQty='"
                + minQty
                + '\''
                + ", maxQty='"
                + maxQty
                + '\''
                + ", stepSize='"
                + stepSize
                + '\''
                + ", minNotional='"
                + minNotional
                + '\''
                + '}';
    }
}
