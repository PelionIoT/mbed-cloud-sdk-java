// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.deviceupdate.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifestPage;
import java.util.List;

/**
 * Adapter for firmware manifests.
 */
@Preamble(description = "Adapter for firmware manifests.")
@Internal
@SuppressWarnings("checkstyle:LineLength")
public final class FirmwareManifestAdapter {
    /**
     * Constructor.
     */
    private FirmwareManifestAdapter() {
        super();
        // Nothing to do;
    }

    /**
     * Maps a firmware manifest into a firmware manifest.
     * 
     * @param toBeMapped
     *            a firmware manifest.
     * @return mapped a firmware manifest
     */
    @Internal
    public static FirmwareManifest
           map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final FirmwareManifest firmwareManifest = new FirmwareManifest(TranslationUtils.toDate(toBeMapped.getCreatedAt()),
                                                                       TranslationUtils.toLong(toBeMapped.getDatafileSize()),
                                                                       toBeMapped.getDatafile(),
                                                                       toBeMapped.getDeviceClass(),
                                                                       toBeMapped.getKeyTable(),
                                                                       TranslationUtils.toDate(toBeMapped.getTimestamp()),
                                                                       TranslationUtils.toDate(toBeMapped.getUpdatedAt()));
        firmwareManifest.setDescription(toBeMapped.getDescription());
        firmwareManifest.setId(toBeMapped.getId());
        firmwareManifest.setName(toBeMapped.getName());
        return firmwareManifest;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static
           GenericAdapter.Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest,
                                 FirmwareManifest>
           getMapper() {
        return new GenericAdapter.Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest,
                                         FirmwareManifest>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public FirmwareManifest
                   map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest toBeMapped) {
                return FirmwareManifestAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a firmware manifest page into a firmware manifest.
     * 
     * @param toBeMapped
     *            a firmware manifest page.
     * @return mapped list response
     */
    @Internal
    public static ListResponse<FirmwareManifest> mapList(FirmwareManifestPage toBeMapped) {
        final FirmwareManifestPage finalList = toBeMapped;
        final GenericAdapter.RespList<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest> respList = new GenericAdapter.RespList<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest>() {
            /**
             * Executes getAfter.
             * 
             * @return something
             */
            @Override
            public String getAfter() {
                return (finalList == null) ? null : finalList.getAfter();
            }

            /**
             * Executes getContinuationMarker.
             * 
             * @return something
             */
            @Override
            public String getContinuationMarker() {
                return null;
            }

            /**
             * Executes getData.
             * 
             * @return something
             */
            @Override
            public List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest> getData() {
                return (finalList == null) ? null : finalList.getData();
            }

            /**
             * Executes getHasMore.
             * 
             * @return something
             */
            @Override
            public Boolean getHasMore() {
                return (finalList == null) ? null : finalList.isHasMore();
            }

            /**
             * Executes getLimit.
             * 
             * @return something
             */
            @Override
            public Integer getLimit() {
                return (finalList == null) ? null : finalList.getLimit();
            }

            /**
             * Executes getOrder.
             * 
             * @return something
             */
            @Override
            public String getOrder() {
                return (finalList == null) ? null : finalList.getOrder().toString();
            }

            /**
             * Executes getTotalCount.
             * 
             * @return something
             */
            @Override
            public Integer getTotalCount() {
                return (finalList == null) ? null : finalList.getTotalCount();
            }
        };
        return GenericAdapter.mapList(respList, FirmwareManifestAdapter.getMapper());
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<FirmwareManifestPage, ListResponse<FirmwareManifest>> getListMapper() {
        return new GenericAdapter.Mapper<FirmwareManifestPage, ListResponse<FirmwareManifest>>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public ListResponse<FirmwareManifest> map(FirmwareManifestPage toBeMapped) {
                return FirmwareManifestAdapter.mapList(toBeMapped);
            }
        };
    }
}
