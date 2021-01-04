package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * 撤销订单
 *
 * @author xingyu
 */
public final class BinanceFuturesCancelledOrder {
    /**
     * 用户自定义的订单号
     */
    public final String clientOrderId;
    /**
     *
     */
    public final String cummQty;
    /**
     * 成交金额
     */
    public final BigDecimal cumQuote;

    /**
     * 成交量
     */
    public String executedQty;
    /**
     * 订单号
     */
    public final long orderId;
    /**
     * 原始委托数量
     */
    public String origQty;
    /**
     * 委托价格
     */
    public String price;
    /**
     * 买卖方向
     */
    public String side;
    /**
     * 持仓方向
     */
    public final String positionSide;
    /**
     * 订单状态
     */
    public String status;
    /**
     * 交易对
     */
    public final String symbol;
    /**
     * 有效方法
     */
    public String timeInForce;
    /**
     * 订单类型
     */
    public String type;


    public BinanceFuturesCancelledOrder(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("clientOrderId") String clientOrderId,
            @JsonProperty("cummQty") String cummQty,
            @JsonProperty("cumQuote") BigDecimal cumQuote,
            @JsonProperty("price") String price,
            @JsonProperty("origQty") String origQty,
            @JsonProperty("executedQty") String executedQty,
            @JsonProperty("clientOrderId") String positionSide,
            @JsonProperty("status") String status,
            @JsonProperty("timeInForce") String timeInForce,
            @JsonProperty("type") String type,
            @JsonProperty("side") String side) {
        super();
        this.symbol = symbol;
        this.cummQty = cummQty;
        this.cumQuote = cumQuote;
        this.positionSide = positionSide;
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.price = price;
        this.origQty = origQty;
        this.executedQty = executedQty;
        this.status = status;
        this.timeInForce = timeInForce;
        this.type = type;
        this.side = side;
    }
}
