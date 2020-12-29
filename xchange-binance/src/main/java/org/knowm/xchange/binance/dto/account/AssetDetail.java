package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * 上架资产详情 (USER_DATA)
 *
 * @author xingyu
 */
public class AssetDetail {
    /**
     * 最小提现数量
     */
    private final String minWithdrawAmount;
    /**
     * 是否可以充值(只有所有网络都关闭充值才为false)
     */
    private final boolean depositStatus;
    /**
     * 提现手续费
     */
    private final BigDecimal withdrawFee;
    /**
     * 是否开放提现(只有所有网络都关闭提币才为false)
     */
    private final boolean withdrawStatus;

    public AssetDetail(
            @JsonProperty("minWithdrawAmount") String minWithdrawAmount,
            @JsonProperty("depositStatus") boolean depositStatus,
            @JsonProperty("withdrawFee") BigDecimal withdrawFee,
            @JsonProperty("withdrawStatus") boolean withdrawStatus) {
        this.minWithdrawAmount = minWithdrawAmount;
        this.depositStatus = depositStatus;
        this.withdrawFee = withdrawFee;
        this.withdrawStatus = withdrawStatus;
    }

    public String getMinWithdrawAmount() {
        return minWithdrawAmount;
    }

    public boolean isDepositStatus() {
        return depositStatus;
    }

    public BigDecimal getWithdrawFee() {
        return withdrawFee;
    }

    public boolean isWithdrawStatus() {
        return withdrawStatus;
    }

    @Override
    public String toString() {
        return "AssetDetail{"
                + "minWithdrawAmount = '"
                + minWithdrawAmount
                + '\''
                + ",depositStatus = '"
                + depositStatus
                + '\''
                + ",withdrawFee = '"
                + withdrawFee
                + '\''
                + ",withdrawStatus = '"
                + withdrawStatus
                + '\''
                + "}";
    }
}
