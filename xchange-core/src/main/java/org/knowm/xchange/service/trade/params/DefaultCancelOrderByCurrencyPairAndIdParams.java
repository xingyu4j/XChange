package org.knowm.xchange.service.trade.params;

import org.knowm.xchange.currency.CurrencyPair;

public class DefaultCancelOrderByCurrencyPairAndIdParams
        implements CancelOrderByIdParams, CancelOrderByCurrencyPair {

    private CurrencyPair currencyPair;
    private String orderId;

    public DefaultCancelOrderByCurrencyPairAndIdParams(CurrencyPair currencyPair, String orderId) {
        this.currencyPair = currencyPair;
        this.orderId = orderId;
    }

    @Override
    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(CurrencyPair pair) {
        this.currencyPair = pair;
    }

    @Override
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
