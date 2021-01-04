package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.currency.Currency;

import java.math.BigDecimal;

/**
 * 资产信息
 * @author xingyu
 */
@Data
public final class BinanceFuturesBalance {
    /**
     * 交易对
     */
    private final Currency currency;
    /**
     * 账户余额
     */
    private final BigDecimal walletBalance;
    /**
     * 未实现盈亏
     */
    private final BigDecimal unrealizedProfit;
    /**
     * 保证金余额
     */
    private final BigDecimal marginBalance;
    /**
     * 维持保证金
     */
    private final BigDecimal maintMargin;
    /**
     * 当前所需起始保证金
     */
    private final BigDecimal initialMargin;
    /**
     * 持仓所需起始保证金(基于最新标记价格)
     */
    private final BigDecimal positionInitialMargin;
    /**
     * 当前挂单所需起始保证金(基于最新标记价格)
     */
    private final BigDecimal openOrderInitialMargin;
    /**
     * 全仓账户余额
     */
    private final BigDecimal crossWalletBalance;
    /**
     * 全仓持仓未实现盈亏
     */
    private final BigDecimal crossUnPnl;
    /**
     * 可用余额
     */
    private final BigDecimal availableBalance;
    /**
     * 最大可转出余额
     */
    private final BigDecimal maxWithdrawAmount;

    public BinanceFuturesBalance(
            @JsonProperty("asset") String asset,
            @JsonProperty("walletBalance") BigDecimal walletBalance,
            @JsonProperty("unrealizedProfit") BigDecimal unrealizedProfit,
            @JsonProperty("marginBalance") BigDecimal marginBalance,
            @JsonProperty("maintMargin") BigDecimal maintMargin,
            @JsonProperty("initialMargin") BigDecimal initialMargin,
            @JsonProperty("positionInitialMargin") BigDecimal positionInitialMargin,
            @JsonProperty("openOrderInitialMargin") BigDecimal openOrderInitialMargin,
            @JsonProperty("crossWalletBalance") BigDecimal crossWalletBalance,
            @JsonProperty("crossUnPnl") BigDecimal crossUnPnl,
            @JsonProperty("availableBalance") BigDecimal availableBalance,
            @JsonProperty("maxWithdrawAmount") BigDecimal maxWithdrawAmount) {
        this.currency = Currency.getInstance(asset);
        this.walletBalance = walletBalance;
        this.unrealizedProfit = unrealizedProfit;
        this.marginBalance = marginBalance;
        this.maintMargin = maintMargin;
        this.initialMargin = initialMargin;
        this.positionInitialMargin = positionInitialMargin;
        this.openOrderInitialMargin = openOrderInitialMargin;
        this.crossWalletBalance = crossWalletBalance;
        this.crossUnPnl = crossUnPnl;
        this.availableBalance = availableBalance;
        this.maxWithdrawAmount = maxWithdrawAmount;
    }
}
