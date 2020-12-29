package org.knowm.xchange.binance.dto.trade;

import org.knowm.xchange.dto.Order.IOrderFlags;

/**
 * 订单 标识
 * @author xingyu
 */

public enum BinanceOrderFlags implements IOrderFlags {
    LIMIT_MAKER;
}
