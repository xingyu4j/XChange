package org.knowm.xchange.deribit.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserTrades {

  private List<Trade> trades;

  @JsonProperty("has_more")
  private boolean hasMore;
}
