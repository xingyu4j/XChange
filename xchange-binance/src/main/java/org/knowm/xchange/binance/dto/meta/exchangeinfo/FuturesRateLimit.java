package org.knowm.xchange.binance.dto.meta.exchangeinfo;

/**
 * API访问的限制
 *
 * @author xingyu
 */
public class FuturesRateLimit {
    /**
     * 上限次数
     */
    private String limit;
    /**
     * MINUTE 按照分钟计算
     */
    private long intervalNum;
    /**
     * 上限次数
     */
    private String interval;
    /**
     * REQUEST_WEIGHT 按照访问权重来计算
     * ORDERS  按照订单数量来计算
     */
    private String rateLimitType;

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public long getIntervalNum() {
        return intervalNum;
    }

    public void setIntervalNum(long intervalNum) {
        this.intervalNum = intervalNum;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getRateLimitType() {
        return rateLimitType;
    }

    public void setRateLimitType(String rateLimitType) {
        this.rateLimitType = rateLimitType;
    }

    @Override
    public String toString() {
        return "ClassPojo [limit = "
                + limit
                + ", interval = "
                + interval
                + ", intervalNum = "
                + intervalNum
                + ", rateLimitType = "
                + rateLimitType
                + "]";
    }
}
