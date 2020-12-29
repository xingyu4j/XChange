package org.knowm.xchange.binance.dto.meta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 系统状态
 *
 * @author xingyu
 */
public class BinanceSystemStatus {

    /**
     * 0: 正常，1：系统维护
     */
    @JsonProperty
    private String status;
    /**
     * normal or system maintenance
     */
    @JsonProperty
    private String msg;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
