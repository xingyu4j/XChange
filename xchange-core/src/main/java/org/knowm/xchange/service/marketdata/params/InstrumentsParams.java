package org.knowm.xchange.service.marketdata.params;

import org.knowm.xchange.instrument.Instrument;

import java.util.Collection;

public interface InstrumentsParams {
    Collection<Instrument> getInstruments();
}
