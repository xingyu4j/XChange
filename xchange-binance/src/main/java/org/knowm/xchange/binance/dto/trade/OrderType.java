package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 订单类型， 比如市价单，现价单等
 *
 * @author 99121
 */

public enum OrderType {
    /**
     * 限价单
     */
    LIMIT,
    /**
     * 市价单
     */
    MARKET,
    /**
     * 限价止盈单
     */
    TAKE_PROFIT_LIMIT,
    /**
     * 限价止损单
     */
    STOP_LOSS_LIMIT,
    /**
     * 止损单
     */
    STOP_LOSS,
    /**
     * 止盈单
     */
    TAKE_PROFIT,
    LIMIT_MAKER;

    @JsonCreator
    public static OrderType getOrderType(String s) {
        try {
            return OrderType.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown order type " + s + ".");
        }
    }
}
