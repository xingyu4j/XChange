package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 订单方向，买还是卖
 * @author xingyu
 */

public enum OrderSide {
    /**
     * 买入
     */
    BUY,
    /**
     * 卖出
     */
    SELL;

    @JsonCreator
    public static OrderSide getOrderSide(String s) {
        try {
            return OrderSide.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown order side " + s + ".");
        }
    }
}
