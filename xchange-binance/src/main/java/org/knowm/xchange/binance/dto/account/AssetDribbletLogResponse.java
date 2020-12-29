package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * 小额资产转换BNB历史 (USER_DATA)
 *
 * @author xingyu
 */
public final class AssetDribbletLogResponse
        extends WapiResponse<AssetDribbletLogResponse.AssetDribbletLogResults> {

    private final AssetDribbletLogResults results;

    public AssetDribbletLogResponse(
            @JsonProperty("results") AssetDribbletLogResults results,
            @JsonProperty("success") boolean success,
            @JsonProperty("msg") String msg) {
        super(success, msg);
        this.results = results;
    }

    @Override
    public AssetDribbletLogResults getData() {
        return results;
    }

    @Override
    public String toString() {
        return "AssetDribbletLogResult [results="
                + results
                + ", success="
                + success
                + ", msg="
                + msg
                + "]";
    }

    @Data
    @NoArgsConstructor
    public static class AssetDribbletLogResults {
        /**
         * 共计发生过的转换笔数
         */
        private BigDecimal total;
        private BnbExchange[] rows;

        public List<BnbExchange> getData() {
            return Arrays.asList(rows);
        }
    }

    @Data
    @NoArgsConstructor
    public static class BnbExchange {
        /**
         * 本次转换所得BNB
         */
        private String transfered_total;
        /**
         * 本次转换手续费(BNB)
         */
        private String service_charge_total;
        /**
         * 交易ID
         */
        private BigInteger tran_id;
        /**
         * 本次转换的细节
         */
        private BnbExchangeLog[] logs;
        /**
         * The time of this exchange.
         */
        private String operate_time;

        public List<BnbExchangeLog> getData() {
            return Arrays.asList(logs);
        }

        public LocalDateTime getOperateTime() {
            return LocalDateTime.parse(operate_time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

    @Data
    @NoArgsConstructor
    public static class BnbExchangeLog {
        private BigInteger tranId;
        private String serviceChargeAmount;
        private String uid;
        private String amount;
        private String operateTime;
        private String transferedAmount;
        private String fromAsset;

        public LocalDateTime getOperateTime() {
            return LocalDateTime.parse(operateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }
}
