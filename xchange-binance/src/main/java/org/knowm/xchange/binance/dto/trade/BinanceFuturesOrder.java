package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @author xingyu
 */
public final class BinanceFuturesOrder {
    /**
     * 交易对
     */
    public final String symbol;
    /**
     * 平均成交价
     */
    public final BigDecimal avgPrice;
    /**
     * 客户自己设置的ID
     */
    public final String clientOrderId;
    /**
     * 成交金额
     */
    public final BigDecimal cumQuote;
    /**
     * 交易的订单数量
     */
    public final BigDecimal executedQty;
    /**
     * 系统的订单ID
     */
    public final long orderId;
    /**
     * 用户设置的原始订单数量
     */
    public final BigDecimal origQty;

    /**
     * 触发前订单类型
     */
    public final OrderType origType;

    /**
     * 订单价格
     */
    public final BigDecimal price;
    /**
     * 仅减仓
     */
    public final boolean reduceOnly;
    /**
     * 订单方向，买还是卖
     */
    public final OrderSide side;
    /**
     * 持仓方向
     */
    public final PositionSide positionSide;
    /**
     * 订单状态
     */
    public final OrderStatus status;
    /**
     * 止损价格
     */
    public final BigDecimal stopPrice;
    /**
     * 订单时间
     */
    public final long time;
    /**
     * 订单的时效方式
     */
    public final TimeInForce timeInForce;
    /**
     * 订单类型
     */
    public final OrderType type;


    public BinanceFuturesOrder(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("avgPrice") BigDecimal avgPrice,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("clientOrderId") String clientOrderId,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("origQty") BigDecimal origQty,
            @JsonProperty("executedQty") BigDecimal executedQty,
            @JsonProperty("cumQuote") BigDecimal cumQuote,
            @JsonProperty("origType") OrderType origType,
            @JsonProperty("reduceOnly") boolean reduceOnly,
            @JsonProperty("status") OrderStatus status,
            @JsonProperty("timeInForce") TimeInForce timeInForce,
            @JsonProperty("type") OrderType type,
            @JsonProperty("side") OrderSide side,
            @JsonProperty("stopPrice") BigDecimal stopPrice,
            @JsonProperty("positionSide") PositionSide positionSide,
            @JsonProperty("time") long time) {
        this.symbol = symbol;
        this.avgPrice = avgPrice;
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.price = price;
        this.origQty = origQty;
        this.executedQty = executedQty;
        this.cumQuote = cumQuote;
        this.origType = origType;
        this.reduceOnly = reduceOnly;
        this.positionSide = positionSide;
        this.status = status;
        this.timeInForce = timeInForce;
        this.type = type;
        this.side = side;
        this.stopPrice = stopPrice;
        this.time = time;
    }
}
