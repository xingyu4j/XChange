package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author xingyu
 * @description 持仓方向
 * @date 2020-12-29 16:44
 **/

public enum PositionSide {
    /**
     * 双向
     */
    BOTH,
    /**
     * 空
     */
    SHORT,
    /**
     * 多
     */
    LONG;

    @JsonCreator
    public static PositionSide getPositionSide(String s) {
        try {
            return PositionSide.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown PositionSide" + s + ".");
        }
    }
}
