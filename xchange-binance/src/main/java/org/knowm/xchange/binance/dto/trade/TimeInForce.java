package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.knowm.xchange.dto.Order.IOrderFlags;

/**
 * 订单的时效方式
 *
 * @author xingyu
 */
public enum TimeInForce implements IOrderFlags {
    /**
     *成交为止
     * 订单会一直有效，直到被成交或者取消。
     */
    GTC,
    /**
     *	无法立即成交的部分就撤销
     * 订单在失效前会尽量多的成交
     */
    FOK,
    /**
     *无法全部立即成交就撤销
     * 如果无法全部成交，订单会失效。
     */
    IOC;

    @JsonCreator
    public static TimeInForce getTimeInForce(String s) {
        try {
            return TimeInForce.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown ordtime in force " + s + ".");
        }
    }
}
