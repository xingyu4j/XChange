package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.binance.dto.account.WithdrawList.BinanceWithdraw;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 提币
 *
 * @author xingyu
 */
public final class WithdrawList extends WapiResponse<List<BinanceWithdraw>> {

    private final BinanceWithdraw[] withdrawList;

    public WithdrawList(
            @JsonProperty("withdrawList") BinanceWithdraw[] withdrawList,
            @JsonProperty("success") boolean success,
            @JsonProperty("msg") String msg) {
        super(success, msg);
        this.withdrawList = withdrawList;
    }

    @Override
    public List<BinanceWithdraw> getData() {
        return Arrays.asList(withdrawList);
    }

    @Override
    public String toString() {
        return "WithdrawList [withdrawList="
                + Arrays.toString(withdrawList)
                + ", success="
                + success
                + ", msg="
                + msg
                + "]";
    }

    @Data
    public static final class BinanceWithdraw {
        /**
         * 该笔提现在币安的id
         */
        private String id;
        /**
         * 提现转出金额
         */
        private BigDecimal amount;
        /**
         * 提现手续费
         */
        private BigDecimal transactionFee;
        /**
         * 提现目的地址
         */
        private String address;
        /**
         * 提现备注 只对某些币种存在
         */
        private String addressTag;
        /**
         * 時間
         */
        private long successTime;
        /**
         * 提现交易id
         */
        private String txId;

        /**
         * 资产
         */
        private String asset;
        /**
         * 时间
         */
        private long applyTime;
        /**
         * (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6Completed)
         */
        private int status;
    }
}
