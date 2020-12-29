package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 交易
 *
 * @author xingyu
 */
public final class BinanceTrade {
    /**
     * trade ID
     */
    public final long id;
    /**
     * 订单ID
     */
    public final long orderId;
    /**
     * 成交价格
     */
    public final BigDecimal price;
    /**
     * 成交量
     */
    public final BigDecimal qty;
    /**
     * 交易费金额
     */
    public final BigDecimal commission;
    /**
     * 交易费资产类型
     */
    public final String commissionAsset;
    /**
     * 交易时间
     */
    public final long time;
    /**
     * 是否是买家
     */
    public final boolean isBuyer;
    /**
     * 是否是挂单方
     */
    public final boolean isMaker;
    /**
     * isBestMatch
     */
    public final boolean isBestMatch;

    public BinanceTrade(
            @JsonProperty("id") long id,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("qty") BigDecimal qty,
            @JsonProperty("commission") BigDecimal commission,
            @JsonProperty("commissionAsset") String commissionAsset,
            @JsonProperty("time") long time,
            @JsonProperty("isBuyer") boolean isBuyer,
            @JsonProperty("isMaker") boolean isMaker,
            @JsonProperty("isBestMatch") boolean isBestMatch) {
        this.id = id;
        this.orderId = orderId;
        this.price = price;
        this.qty = qty;
        this.commission = commission;
        this.commissionAsset = commissionAsset;
        this.time = time;
        this.isBuyer = isBuyer;
        this.isMaker = isMaker;
        this.isBestMatch = isBestMatch;
    }

    public Date getTime() {
        return new Date(time);
    }
}
