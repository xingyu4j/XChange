package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * 账户信息
 *
 * @author xingyu
 */
public final class BinanceFuturesAccountInformation {
    /**
     * 手续费等级
     */
    public final long feeTier;
    /**
     * 是否可以交易
     */
    public final boolean canTrade;
    /**
     * 是否可以入金
     */
    public final boolean canDeposit;
    /**
     * 是否可以出金
     */
    public final boolean canWithdraw;
    /**
     * 但前所需起始保证金总额(存在逐仓请忽略)
     */
    public final BigDecimal totalInitialMargin;
    /**
     * 维持保证金总额
     */
    public final BigDecimal totalMaintMargin;
    /**
     * 账户总余额
     */
    public final BigDecimal totalWalletBalance;
    /**
     * 持仓未实现盈亏总额
     */
    public final BigDecimal totalUnrealizedProfit;
    /**
     * 保证金总余额
     */
    public final BigDecimal totalMarginBalance;
    /**
     * 持仓所需起始保证金(基于最新标记价格)
     */
    public final BigDecimal totalPositionInitialMargin;
    /**
     * 当前挂单所需起始保证金(基于最新标记价格)
     */
    public final BigDecimal totalOpenOrderInitialMargin;
    /**
     * 全仓账户余额
     */
    public final BigDecimal totalCrossWalletBalance;
    /**
     * 全仓持仓未实现盈亏总额
     */
    public final BigDecimal totalCrossUnPnl;
    /**
     * 可用余额
     */
    public final BigDecimal availableBalance;
    /**
     * 最大可转出余额
     */
    public final BigDecimal maxWithdrawAmount;
    /**
     * 更新时间
     */
    public final long updateTime;
    /**
     * 是否可以出金
     */
    public List<BinanceFuturesBalance> balances;
    /**
     * 头寸，将返回所有市场symbol
     */
    public List<String> permissions;

    public BinanceFuturesAccountInformation(
            @JsonProperty("feeTier") long feeTier,
            @JsonProperty("canTrade") boolean canTrade,
            @JsonProperty("canWithdraw") boolean canWithdraw,
            @JsonProperty("canDeposit") boolean canDeposit,
            @JsonProperty("totalInitialMargin") BigDecimal totalInitialMargin,
            @JsonProperty("totalMaintMargin") BigDecimal totalMaintMargin,
            @JsonProperty("totalWalletBalance") BigDecimal totalWalletBalance,
            @JsonProperty("totalUnrealizedProfit") BigDecimal totalUnrealizedProfit,
            @JsonProperty("totalMarginBalance") BigDecimal totalMarginBalance,
            @JsonProperty("totalPositionInitialMargin") BigDecimal totalPositionInitialMargin,
            @JsonProperty("totalOpenOrderInitialMargin") BigDecimal totalOpenOrderInitialMargin,
            @JsonProperty("totalCrossWalletBalance") BigDecimal totalCrossWalletBalance,
            @JsonProperty("totalCrossUnPnl") BigDecimal totalCrossUnPnl,
            @JsonProperty("availableBalance") BigDecimal availableBalance,
            @JsonProperty("maxWithdrawAmount") BigDecimal maxWithdrawAmount,
            @JsonProperty("updateTime") long updateTime,
            @JsonProperty("balances") List<BinanceFuturesBalance> balances,
            @JsonProperty("permissions") List<String> permissions) {
        this.feeTier = feeTier;
        this.totalInitialMargin = totalInitialMargin;
        this.totalMaintMargin = totalMaintMargin;
        this.totalWalletBalance = totalWalletBalance;
        this.totalUnrealizedProfit = totalUnrealizedProfit;
        this.totalMarginBalance = totalMarginBalance;
        this.totalPositionInitialMargin = totalPositionInitialMargin;
        this.totalOpenOrderInitialMargin = totalOpenOrderInitialMargin;
        this.totalCrossWalletBalance = totalCrossWalletBalance;
        this.totalCrossUnPnl = totalCrossUnPnl;
        this.availableBalance = availableBalance;
        this.maxWithdrawAmount = maxWithdrawAmount;
        this.canTrade = canTrade;
        this.canWithdraw = canWithdraw;
        this.canDeposit = canDeposit;
        this.updateTime = updateTime;
        this.balances = balances;
        this.permissions = permissions;
    }
}
