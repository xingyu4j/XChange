package org.knowm.xchange.okcoin.v3.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OkexFundingAccountRecord {
    private BigDecimal balance;
    private BigDecimal available;
    private String currency;
    private BigDecimal hold;
}
