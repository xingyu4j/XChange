package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * 订单
 * @author 99121
 */
public final class BinanceNewOrder {
    /**
     * 交易对
     */
    public final String symbol;
    /**
     * 系统的订单ID
     */
    public final long orderId;
    /**
     * 客户自己设置的ID
     */
    public final String clientOrderId;
    /**
     * 交易的时间戳
     */
    public final long transactTime;
    /**
     * 订单价格
     */
    public final BigDecimal price;
    /**
     * 用户设置的原始订单数量
     */
    public final BigDecimal origQty;
    /**
     * 交易的订单数量
     */
    public final BigDecimal executedQty;
    /**
     * 订单状态
     */
    public final OrderStatus status;
    /**
     * 订单的时效方式
     */
    public final TimeInForce timeInForce;
    /**
     * 订单类型， 比如市价单，现价单等
     */
    public final OrderType type;
    /**
     * 订单方向，买还是卖
     */
    public final OrderSide side;

    public BinanceNewOrder(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("clientOrderId") String clientOrderId,
            @JsonProperty("transactTime") long transactTime,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("origQty") BigDecimal origQty,
            @JsonProperty("executedQty") BigDecimal executedQty,
            @JsonProperty("status") OrderStatus status,
            @JsonProperty("timeInForce") TimeInForce timeInForce,
            @JsonProperty("type") OrderType type,
            @JsonProperty("side") OrderSide side) {
        super();
        this.symbol = symbol;
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.transactTime = transactTime;
        this.price = price;
        this.origQty = origQty;
        this.executedQty = executedQty;
        this.status = status;
        this.timeInForce = timeInForce;
        this.type = type;
        this.side = side;
    }
}
