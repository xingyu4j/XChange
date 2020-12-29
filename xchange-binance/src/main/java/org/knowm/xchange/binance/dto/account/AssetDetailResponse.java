package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * 上架资产详情 返回
 * @author xingyu
 */
public class AssetDetailResponse {

    private final boolean success;
    private final Map<String, AssetDetail> assetDetail;

    public AssetDetailResponse(
            @JsonProperty("success") boolean success,
            @JsonProperty("assetDetail") Map<String, AssetDetail> assetDetail) {
        this.success = success;
        this.assetDetail = assetDetail;
    }

    public boolean isSuccess() {
        return success;
    }

    public Map<String, AssetDetail> getAssetDetail() {
        return assetDetail;
    }

    @Override
    public String toString() {
        return "AssetDetailResponse{"
                + "success = '"
                + success
                + '\''
                + ",assetDetail = '"
                + assetDetail
                + '\''
                + "}";
    }
}
