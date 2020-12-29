package org.knowm.xchange.service.trade.params;

import org.knowm.xchange.currency.Currency;

import javax.annotation.Nullable;
import java.math.BigDecimal;

public class MoneroWithdrawFundsParams extends DefaultWithdrawFundsParams {
    @Nullable
    public final String paymentId; // optional

    public MoneroWithdrawFundsParams(String address, Currency currency, BigDecimal amount) {
        this(address, currency, amount, null);
    }

    public MoneroWithdrawFundsParams(
            String address, Currency currency, BigDecimal amount, String paymentId) {
        super(address, currency, amount);
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "MoneroWithdrawFundsParams{"
                + "address='"
                + getAddress()
                + '\''
                + ", paymentId='"
                + getPaymentId()
                + '\''
                + ", currency="
                + getCurrency()
                + ", amount="
                + getAmount()
                + ", commission="
                + getCommission()
                + '}';
    }

    @Nullable
    public String getPaymentId() {
        return paymentId;
    }
}
