package org.knowm.xchange.deribit.v2.dto.trade;

import lombok.Data;

import java.util.List;

@Data
public class OrderPlacement {

  private List<Trade> trades;
  private Order order;
}
