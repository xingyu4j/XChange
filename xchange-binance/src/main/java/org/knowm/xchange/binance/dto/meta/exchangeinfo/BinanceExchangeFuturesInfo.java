package org.knowm.xchange.binance.dto.meta.exchangeinfo;


import lombok.Data;

/**
 * 合约交易规则和交易对
 *
 * @author xingyu
 */
@Data
public class BinanceExchangeFuturesInfo {
    /**
     * 服务器所用的时间区域
     */
    private String timezone;
    /**
     * 交易对
     */
    private FuturesSymbol[] symbols;
    /**
     * 服务器时间
     */
    private String serverTime;
    /**
     * API访问的限制
     */
    private FuturesRateLimit[] rateLimits;
    /**
     * 这些是"过滤器"部分中定义的过滤器
     *  所有限制都是可选的
     */
    private String[] exchangeFilters;
    /**
     * 权限
     */
    private String[] permissions;
}
