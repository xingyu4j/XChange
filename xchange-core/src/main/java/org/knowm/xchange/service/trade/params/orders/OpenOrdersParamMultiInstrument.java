package org.knowm.xchange.service.trade.params.orders;

import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.instrument.Instrument;

import java.util.Collection;

public interface OpenOrdersParamMultiInstrument extends OpenOrdersParams {
    @Override
    default boolean accept(LimitOrder order) {
        return order != null
                && getInstruments() != null
                && getInstruments().contains(order.getCurrencyPair());
    }

    Collection<Instrument> getInstruments();

    void setInstruments(Collection<Instrument> instruments);
}
