package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 撤销订单
 *
 * @author xingyu
 */
public final class BinanceCancelledOrder {
    /**
     * 交易对
     */
    public final String symbol;
    /**
     * 用户自定义的订单号
     */
    public final String origClientOrderId;
    /**
     * 订单号
     */
    public final long orderId;
    /**
     * 用户自定义的订单号
     */
    public final String clientOrderId;
    /**
     * 委托价格
     */
    public String price;
    /**
     * 原始委托数量
     */
    public String origQty;
    /**
     * 成交量
     */
    public String executedQty;
    /**
     * 累计交易的金额
     */
    public String cummulativeQuoteQty;
    /**
     * 订单状态
     */
    public String status;
    /**
     * 有效方法
     */
    public String timeInForce;
    /**
     * 订单类型
     */
    public String type;
    /**
     * 买卖方向
     */
    public String side;

    public BinanceCancelledOrder(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("origClientOrderId") String origClientOrderId,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("clientOrderId") String clientOrderId,
            @JsonProperty("price") String price,
            @JsonProperty("origQty") String origQty,
            @JsonProperty("executedQty") String executedQty,
            @JsonProperty("cummulativeQuoteQty") String cummulativeQuoteQty,
            @JsonProperty("status") String status,
            @JsonProperty("timeInForce") String timeInForce,
            @JsonProperty("type") String type,
            @JsonProperty("side") String side) {
        super();
        this.symbol = symbol;
        this.origClientOrderId = origClientOrderId;
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.price = price;
        this.origQty = origQty;
        this.executedQty = executedQty;
        this.cummulativeQuoteQty = cummulativeQuoteQty;
        this.status = status;
        this.timeInForce = timeInForce;
        this.type = type;
        this.side = side;
    }
}
