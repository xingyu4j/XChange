package org.knowm.xchange.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import si.mazi.rescu.HttpResponseAware;
import si.mazi.rescu.HttpStatusExceptionSupport;

import java.util.List;
import java.util.Map;

/**
 * 币安异常
 * @author xingyu
 */
public class BinanceException extends HttpStatusExceptionSupport implements HttpResponseAware {

    private final int code;

    private Map<String, List<String>> headers;

    public BinanceException(@JsonProperty("code") int code, @JsonProperty("msg") String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public void setResponseHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    @Override
    public Map<String, List<String>> getResponseHeaders() {
        return headers;
    }
}
