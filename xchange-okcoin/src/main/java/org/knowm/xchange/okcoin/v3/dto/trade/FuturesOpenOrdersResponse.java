package org.knowm.xchange.okcoin.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class FuturesOpenOrdersResponse extends OkexResponse {

    @JsonProperty("order_info")
    private List<OkexFuturesOpenOrder> orders;
}
