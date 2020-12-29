package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.binance.dto.account.DepositList.BinanceDeposit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 充值
 * @author xingyu
 */
public final class DepositList extends WapiResponse<List<BinanceDeposit>> {

    private final BinanceDeposit[] depositList;

    public DepositList(
            @JsonProperty("depositList") BinanceDeposit[] depositList,
            @JsonProperty("success") boolean success,
            @JsonProperty("msg") String msg) {
        super(success, msg);
        this.depositList = depositList;
    }

    @Override
    public List<BinanceDeposit> getData() {
        return Arrays.asList(depositList);
    }

    @Override
    public String toString() {
        return "DepositList [depositList=" + Arrays.toString(depositList) + "]";
    }

    @Data
    public static final class BinanceDeposit {
    /*
    {
             "insertTime":1509505623000,
             "amount":32.000000000000000000,
             "asset":"BTC",
             "status":1
                   }
             */

        /**
         * 币安系统记录该笔充值的时间
         */
        private long insertTime;
        /**
         * 充值金额
         */
        private BigDecimal amount;
        /**
         * 充值资产
         */
        private String asset;
        /**
         * 充值交易id
         */
        private String txId;
        /**
         * 充值地址
         */
        private String address;
        /**
         * 充值地址
         */
        private String addressTag;

        /**
         * (0:pending,1:success)
         */
        private int status;
    }
}
