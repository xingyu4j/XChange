package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @author xingyu
 */
public final class BinanceOrder {
    /**
     * 交易对
     */
    public final String symbol;
    /**
     * 系统的订单ID
     */
    public final long orderId;
    /**
     *  客户自己设置的ID
     */
    public final String clientOrderId;
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
     * 累计交易的金额
     */
    public final BigDecimal cummulativeQuoteQty;
    /**
     * 订单状态
     */
    public final OrderStatus status;
    /**
     * 订单的时效方式
     */
    public final TimeInForce timeInForce;
    /**
     * 订单类型
     */
    public final OrderType type;
    /**
     * 订单方向，买还是卖
     */
    public final OrderSide side;
    /**
     * 止损价格
     */
    public final BigDecimal stopPrice;
    /**
     * 冰山数量
     */
    public final BigDecimal icebergQty;
    /**
     * 订单时间
     */
    public final long time;

    public BinanceOrder(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("orderId") long orderId,
            @JsonProperty("clientOrderId") String clientOrderId,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("origQty") BigDecimal origQty,
            @JsonProperty("executedQty") BigDecimal executedQty,
            @JsonProperty("cummulativeQuoteQty") BigDecimal cummulativeQuoteQty,
            @JsonProperty("status") OrderStatus status,
            @JsonProperty("timeInForce") TimeInForce timeInForce,
            @JsonProperty("type") OrderType type,
            @JsonProperty("side") OrderSide side,
            @JsonProperty("stopPrice") BigDecimal stopPrice,
            @JsonProperty("icebergQty") BigDecimal icebergQty,
            @JsonProperty("time") long time) {
        this.symbol = symbol;
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
        this.stopPrice = stopPrice;
        this.icebergQty = icebergQty;
        this.time = time;
    }

    public Date getTime() {
        return new Date(time);
    }
}
