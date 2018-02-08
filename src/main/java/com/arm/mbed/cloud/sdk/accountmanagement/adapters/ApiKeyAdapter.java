package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.ApiKey;
import com.arm.mbed.cloud.sdk.accountmanagement.model.ApiKeyStatus;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp.StatusEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyUpdateReq;

@Preamble(description = "Adapter for API key model")
@Internal
public final class ApiKeyAdapter {

    private ApiKeyAdapter() {
        super();
    }

    /**
     * Maps API keys.
     * 
     * @param apiKeyInfo
     *            an API key.
     * @return an API Key.
     */
    public static ApiKey map(ApiKeyInfoResp apiKeyInfo) {
        if (apiKeyInfo == null) {
            return null;
        }
        final ApiKey apiKey = new ApiKey(apiKeyInfo.getId(), apiKeyInfo.getKey(),
                TranslationUtils.toDate(apiKeyInfo.getCreatedAt()),
                TranslationUtils.toTimeStamp(apiKeyInfo.getCreationTime()),
                TranslationUtils.toTimeStamp(apiKeyInfo.getLastLoginTime()));
        apiKey.setName(apiKeyInfo.getName());
        apiKey.setOwnerId(apiKeyInfo.getOwner());
        apiKey.setGroup(apiKeyInfo.getGroups());
        apiKey.setStatus(toStatus(apiKeyInfo.getStatus()));
        return apiKey;
    }

    /**
     * Gets mapper.
     * 
     * @return a mapper.
     */
    public static Mapper<ApiKeyInfoResp, ApiKey> getMapper() {
        return new Mapper<ApiKeyInfoResp, ApiKey>() {
            @Override
            public ApiKey map(ApiKeyInfoResp toBeMapped) {
                return ApiKeyAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Reverses mapping for new API keys.
     * 
     * @param apiKey
     *            an API key.
     * @return API key addition request.
     */
    public static ApiKeyInfoReq reverseMapAdd(ApiKey apiKey) {
        if (apiKey == null) {
            return null;
        }
        final ApiKeyInfoReq apiKeyInfo = new ApiKeyInfoReq();
        apiKeyInfo.setName(apiKey.getName());
        apiKeyInfo.setOwner(apiKey.getOwnerId());
        apiKeyInfo.setStatus(reverseAddRequestStatus(apiKey.getStatus()));
        apiKeyInfo.setGroups(apiKey.getGroups());
        return apiKeyInfo;
    }

    /**
     * Reverses mapping for updated API keys.
     * 
     * @param apiKey
     *            an API key.
     * @return API key update request.
     */
    public static ApiKeyUpdateReq reverseMapUpdate(ApiKey apiKey) {
        if (apiKey == null) {
            return null;
        }
        final ApiKeyUpdateReq apiKeyUpdate = new ApiKeyUpdateReq();
        apiKeyUpdate.setName(apiKey.getName());
        apiKeyUpdate.setOwner(apiKey.getOwnerId());
        apiKeyUpdate.setStatus(reverseUpdateRequestStatus(apiKey.getStatus()));
        return apiKeyUpdate;
    }

    private static ApiKeyStatus toStatus(StatusEnum userStatus) {
        if (userStatus == null) {
            return ApiKeyStatus.getUnknownEnum();
        }
        switch (userStatus) {
            case ACTIVE:
                return ApiKeyStatus.ACTIVE;
            case INACTIVE:
                return ApiKeyStatus.INACTIVE;
            default:
                return ApiKeyStatus.getUnknownEnum();
        }
    }

    private static ApiKeyInfoReq.StatusEnum reverseAddRequestStatus(ApiKeyStatus userStatus) {
        if (userStatus == null) {
            return null;
        }
        switch (userStatus) {
            case ACTIVE:
                return ApiKeyInfoReq.StatusEnum.ACTIVE;
            case INACTIVE:
                return ApiKeyInfoReq.StatusEnum.INACTIVE;
            default:
                return null;
        }
    }

    private static ApiKeyUpdateReq.StatusEnum reverseUpdateRequestStatus(ApiKeyStatus userStatus) {
        if (userStatus == null) {
            return null;
        }
        switch (userStatus) {
            case ACTIVE:
                return ApiKeyUpdateReq.StatusEnum.ACTIVE;
            case INACTIVE:
                return ApiKeyUpdateReq.StatusEnum.INACTIVE;
            default:
                return null;
        }
    }

    /**
     * Maps a list of API keys.
     * 
     * @param list
     *            list of API keys.
     * @return list of API keys.
     */
    public static ListResponse<ApiKey> mapList(ApiKeyInfoRespList list) {

        final ApiKeyInfoRespList apiKeyList = list;
        final RespList<ApiKeyInfoResp> respList = new RespList<ApiKeyInfoResp>() {

            @Override
            public Boolean getHasMore() {
                return (apiKeyList == null) ? null : apiKeyList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (apiKeyList == null) ? null : apiKeyList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (apiKeyList == null) ? null : apiKeyList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (apiKeyList == null) ? null : apiKeyList.getLimit();
            }

            @Override
            public String getOrder() {
                return (apiKeyList == null) ? null : apiKeyList.getOrder().toString();
            }

            @Override
            public List<ApiKeyInfoResp> getData() {
                return (apiKeyList == null) ? null : apiKeyList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     * 
     * @return a list mapper.
     */
    public static Mapper<ApiKeyInfoRespList, ListResponse<ApiKey>> getListMapper() {
        return new Mapper<ApiKeyInfoRespList, ListResponse<ApiKey>>() {

            @Override
            public ListResponse<ApiKey> map(ApiKeyInfoRespList toBeMapped) {
                return ApiKeyAdapter.mapList(toBeMapped);
            }

        };
    }
}
