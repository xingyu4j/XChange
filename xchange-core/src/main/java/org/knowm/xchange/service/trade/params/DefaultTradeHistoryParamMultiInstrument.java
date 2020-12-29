package org.knowm.xchange.service.trade.params;

import org.knowm.xchange.instrument.Instrument;

import java.util.Collection;
import java.util.Collections;

public class DefaultTradeHistoryParamMultiInstrument implements TradeHistoryParamMultiInstrument {

    private Collection<Instrument> instruments = Collections.emptySet();

    public DefaultTradeHistoryParamMultiInstrument() {
    }

    public DefaultTradeHistoryParamMultiInstrument(final Collection<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    @Override
    public void setInstruments(final Collection<Instrument> instruments) {
        this.instruments = instruments;
    }
}
