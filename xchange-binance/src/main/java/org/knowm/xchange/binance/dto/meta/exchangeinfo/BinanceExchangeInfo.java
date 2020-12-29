package org.knowm.xchange.binance.dto.meta.exchangeinfo;

/**
 * 交易规范信息
 *
 * @author xingyu
 */
public class BinanceExchangeInfo {
    /**
     * 时区
     */
    private String timezone;
    /**
     * 交易对
     */
    private Symbol[] symbols;
    /**
     * 服务器时间
     */
    private String serverTime;
    /**
     * 这些在"限制种类 (rateLimitType)"下的"枚举定义"部分中定义
     *  所有限制都是可选的
     */
    private RateLimit[] rateLimits;
    /**
     * 这些是"过滤器"部分中定义的过滤器
     *  所有限制都是可选的
     */
    private String[] exchangeFilters;
    /**
     * 权限
     */
    private String[] permissions;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Symbol[] getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbol[] symbols) {
        this.symbols = symbols;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public RateLimit[] getRateLimits() {
        return rateLimits;
    }

    public void setRateLimits(RateLimit[] rateLimits) {
        this.rateLimits = rateLimits;
    }

    public String[] getExchangeFilters() {
        return exchangeFilters;
    }

    public void setExchangeFilters(String[] exchangeFilters) {
        this.exchangeFilters = exchangeFilters;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "ClassPojo [timezone = "
                + timezone
                + ", symbols = "
                + symbols
                + ", serverTime = "
                + serverTime
                + ", rateLimits = "
                + rateLimits
                + ", exchangeFilters = "
                + exchangeFilters
                + ", permissions = "
                + permissions
                + "]";
    }
}
