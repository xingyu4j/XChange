package org.knowm.xchange.deribit.v2.dto.trade;

import lombok.Data;

import java.util.List;

@Data
public class UserSettlements {

  private List<Settlement> settlements;

  /** Continuation token for pagination. */
  private String continuation;
}
