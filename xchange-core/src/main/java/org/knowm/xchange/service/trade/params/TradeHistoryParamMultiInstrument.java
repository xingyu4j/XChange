package org.knowm.xchange.service.trade.params;

import org.knowm.xchange.instrument.Instrument;

import java.util.Collection;

public interface TradeHistoryParamMultiInstrument extends TradeHistoryParams {

    Collection<Instrument> getInstruments();

    void setInstruments(Collection<Instrument> instruments);
}
