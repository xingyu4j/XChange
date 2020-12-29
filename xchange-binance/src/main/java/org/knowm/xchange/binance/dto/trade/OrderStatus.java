package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 订单的当前状态
 *
 * @author 99121
 */

public enum OrderStatus {
    NEW,
    PARTIALLY_FILLED,
    FILLED,
    CANCELED,
    PENDING_CANCEL,
    REJECTED,
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
