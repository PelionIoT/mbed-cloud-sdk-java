package com.arm.mbed.cloud.sdk.bootstrap.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.bootstrap.model.PreSharedKey;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.ListOfPreSharedKeysWithoutSecret;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKeyWithoutSecret;

@Preamble(description = "Adapter for psk model")
@Internal
public final class PreSharedKeyAdapter {

    private PreSharedKeyAdapter() {
        super();

    }

    /**
     * Maps a pre-shared key without secrets into a psk.
     *
     * @param key
     *            key
     * @return corresponding psk
     */
    public static PreSharedKey map(PreSharedKeyWithoutSecret key) {
        if (key == null) {
            return null;
        }
        return new PreSharedKey(key.getEndpointName(), null, TranslationUtils.toDate(key.getCreatedAt()));
    }

    /**
     * Get PSK mapper.
     *
     * @return the psk mapper.
     */
    public static Mapper<PreSharedKeyWithoutSecret, PreSharedKey> getMapper() {
        return new Mapper<PreSharedKeyWithoutSecret, PreSharedKey>() {

            @Override
            public PreSharedKey map(PreSharedKeyWithoutSecret toBeMapped) {
                return PreSharedKeyAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Reverses mapping.
     *
     * @param key
     *            key.
     * @return a preshared key
     */
    public static com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKey reverseMap(PreSharedKey key) {
        if (key == null) {
            return null;
        }
        final com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKey sharedKey = new com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKey();
        sharedKey.setEndpointName(key.getId());
        sharedKey.setSecretHex(key.getSecret());
        return sharedKey;
    }

    /**
     * Maps a list of PSKs.
     *
     * @param list
     *            list of PSKs.
     * @return list of PSKs.
     */
    public static ListResponse<PreSharedKey> mapList(ListOfPreSharedKeysWithoutSecret list) {

        final ListOfPreSharedKeysWithoutSecret pskList = list;
        final RespList<PreSharedKeyWithoutSecret> respList = new RespList<PreSharedKeyWithoutSecret>() {

            @Override
            public Boolean getHasMore() {
                return (pskList == null) ? null : pskList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return null;
            }

            @Override
            public String getAfter() {
                return (pskList == null) ? null : pskList.getAfter();
            }

            @Override
            public String getContinuationMarker() {
                return (pskList == null) ? null : pskList.getContinuationMarker();
            }

            @Override
            public Integer getLimit() {
                return (pskList == null) ? null : pskList.getLimit();
            }

            @Override
            public String getOrder() {
                return (pskList == null) ? null : pskList.getOrder().toString();
            }

            @Override
            public List<PreSharedKeyWithoutSecret> getData() {
                return (pskList == null) ? null : pskList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     *
     * @return a list mapper.
     */
    public static Mapper<ListOfPreSharedKeysWithoutSecret, ListResponse<PreSharedKey>> getListMapper() {
        return new Mapper<ListOfPreSharedKeysWithoutSecret, ListResponse<PreSharedKey>>() {

            @Override
            public ListResponse<PreSharedKey> map(ListOfPreSharedKeysWithoutSecret toBeMapped) {
                return PreSharedKeyAdapter.mapList(toBeMapped);
            }

        };
    }

}
