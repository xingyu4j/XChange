package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 订单的当前状态
 *
 * @author xingyu
 */

public enum OrderStatus {
    /**
     * 订单被交易引擎接受
     */
    NEW,
    /**
     * 部分订单被成交
     */
    PARTIALLY_FILLED,
    /**
     * 订单完全成交
     */
    FILLED,
    /**
     * 用户撤销了订单
     */
    CANCELED,
    /**
     * 撤销中(目前并未使用)
     */
    PENDING_CANCEL,
    /**
     * 订单没有被交易引擎接受，也没被处理
     */
    REJECTED,
    /**
     * 订单被交易引擎取消, 比如
     * LIMIT FOK 订单没有成交
     * 市价单没有完全成交
     * 强平期间被取消的订单
     * 交易所维护期间被取消的订单
     */
    EXPIRED;

    @JsonCreator
    public static OrderStatus getOrderStatus(String s) {
        try {
            return OrderStatus.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown order status " + s + ".");
        }
    }
}
