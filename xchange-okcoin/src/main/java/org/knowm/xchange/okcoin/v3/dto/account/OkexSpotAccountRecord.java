package org.knowm.xchange.okcoin.v3.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OkexSpotAccountRecord {
    private BigDecimal frozen;
    /**
     * amount on hold(not available)
     */
    private BigDecimal hold;
    /**
     * account ID
     */
    private String id;

    private String currency;
    private BigDecimal balance;
    /**
     * available amount
     */
    private BigDecimal available;

    private BigDecimal holds;
}
