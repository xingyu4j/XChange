package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * 订单
 *
 * @author xingyu
 */
public final class BinanceFuturesNewOrder {
    /**
     * 用户自定义的订单号
     */
    public final String clientOrderId;
    /**
     *
     */
    public final BigDecimal cumQty;
    /**
     * 成交金额
     */
    public final BigDecimal cumQuote;
    /**
     * 成交量
     */
    public final BigDecimal executedQty;
    /**
     * 系统的订单ID
     */
    public final long orderId;
    /**
     * 平均成交价
     */
    public final BigDecimal avgPrice;
    /**
     * 原始委托数量
     */
    public final BigDecimal origQty;
    /**
     * 委托价格
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
     * 交易对
     */
    public final String symbol;
    /**
     * 持仓方向
     */
    public final PositionSide positionSide;
    /**
     * 订单状态
     */
    public final OrderStatus status;
    /**
     * 交易的时间戳
     */
    public final long transactTime;


    /**
     * 订单的时效方式
     */
    public final TimeInForce timeInForce;
    /**
     * 订单类型， 比如市价单，现价单等
     */
    public final OrderType type;


    public BinanceFuturesNewOrder(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("clientOrderId") String clientOrderId,
            @JsonProperty("cumQty") BigDecimal cumQty,
            @JsonProperty("cumQuote") BigDecimal cumQuote,
            @JsonProperty("avgPrice") BigDecimal avgPrice,
            @JsonProperty("transactTime") long transactTime,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("origQty") BigDecimal origQty,
            @JsonProperty("executedQty") BigDecimal executedQty,
            @JsonProperty("reduceOnly") boolean reduceOnly,
            @JsonProperty("status") OrderStatus status,
            @JsonProperty("timeInForce") TimeInForce timeInForce,
            @JsonProperty("type") OrderType type,
            @JsonProperty("side") OrderSide side,
            @JsonProperty("positionSide") PositionSide positionSide) {
        super();
        this.symbol = symbol;
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.cumQty = cumQty;
        this.cumQuote = cumQuote;
        this.avgPrice = avgPrice;
        this.transactTime = transactTime;
        this.price = price;
        this.origQty = origQty;
        this.executedQty = executedQty;
        this.reduceOnly = reduceOnly;
        this.status = status;
        this.timeInForce = timeInForce;
        this.type = type;
        this.side = side;
        this.positionSide = positionSide;
    }
}
