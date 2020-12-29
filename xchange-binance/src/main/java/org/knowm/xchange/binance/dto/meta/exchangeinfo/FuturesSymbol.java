package org.knowm.xchange.binance.dto.meta.exchangeinfo;

import lombok.Data;

import java.util.List;

/**
 * 交易对信息
 *
 * @author xingyu
 */
@Data
public class FuturesSymbol {
    /**
     * 交易对名称
     */
    private String symbol;
    /**
     * 标的交易对
     */
    private String pair;
    /**
     * 交割日期
     */
    private Long deliveryDate;
    /**
     * 上线日期
     */
    private Long onboardDate;
    /**
     * 状态
     */
    private String status;
    /**
     * 交易对基础名称
     */
    private String baseAsset;
    /**
     * 报价资产
     */
    private String quoteAsset;
    /**
     * 价格小数点位数
     */
    private String pricePrecision;

    /**
     * 数量小数点位数
     */
    private String quantityPrecision;
    /**
     * 标的资产精度
     */
    private String baseAssetPrecision;

    /**
     * 报价资产精度
     */
    private String quotePrecision;
    /**
     * 订单类型
     */
    private String[] orderTypes;
    /**
     * 有效方式
     * "GTC", // 成交为止, 一直有效
     * "IOC", // 无法立即成交(吃单)的部分就撤销
     * "FOK", // 无法全部立即成交就撤销
     * "GTX" // 无法成为挂单方就撤销
     */
    private String[] timeInForce;
    /**
     * 交易限制
     */
    private FuturesFilter[] filters;
    /**
     * 权限
     */
    private String[] permissions;

}
