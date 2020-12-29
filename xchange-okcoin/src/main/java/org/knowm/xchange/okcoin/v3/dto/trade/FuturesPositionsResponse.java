package org.knowm.xchange.okcoin.v3.dto.trade;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.knowm.xchange.okcoin.v3.dto.account.FuturesPosition;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class FuturesPositionsResponse extends OkexResponse {

    private List<List<FuturesPosition>> holding;
}
