package org.knowm.xchange.okcoin.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.okcoin.v3.dto.MarginMode;
import org.knowm.xchange.okcoin.v3.dto.account.SwapPosition;

import java.util.List;

@Data
public class SwapPositionsEntry {

  @JsonProperty("margin_mode")
  private MarginMode marginMode;

  private List<SwapPosition> holding;
}
