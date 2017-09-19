package com.arm.mbed.cloud.sdk.update.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.update.model.FirmwareManifest;

@Preamble(description = "Adapter for firmware manifest model")
@Internal
public final class FirmwareManifestAdapter {

    private FirmwareManifestAdapter() {
        super();
    }

    /**
     * Maps firmware manifest.
     * 
     * @param manifest
     *            manifest
     * @return manifest
     */
    public static FirmwareManifest map(com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest manifest) {
        if (manifest == null) {
            return null;
        }
        final FirmwareManifest firmwareManifest = new FirmwareManifest(manifest.getId(),
                TranslationUtils.toUrl(manifest.getDatafile()), manifest.getDeviceClass(),
                manifest.getDatafileChecksum(), TranslationUtils.toLong(manifest.getDatafileSize()),
                TranslationUtils.toDate(manifest.getCreatedAt()), TranslationUtils.toDate(manifest.getUpdatedAt()),
                TranslationUtils.toDate(manifest.getTimestamp()));
        firmwareManifest.setDataFile(null);
        firmwareManifest.setDescription(manifest.getDescription());
        firmwareManifest.setName(manifest.getName());
        return firmwareManifest;
    }

    /**
     * Gets mapper.
     * 
     * @return mapper
     */
    public static Mapper<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest, FirmwareManifest> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest, FirmwareManifest>() {

            @Override
            public FirmwareManifest map(
                    com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest toBeMapped) {
                return FirmwareManifestAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Maps list of manifests.
     * 
     * @param list
     *            manifest page
     * @return list of manifest
     */
    public static ListResponse<FirmwareManifest> mapList(FirmwareManifestPage list) {

        final FirmwareManifestPage imageList = list;
        final RespList<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest> respList = new RespList<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest>() {

            @Override
            public Boolean getHasMore() {
                return (imageList == null) ? null : imageList.getHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (imageList == null) ? null : imageList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (imageList == null) ? null : imageList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (imageList == null) ? null : imageList.getLimit();
            }

            @Override
            public String getOrder() {
                return (imageList == null) ? null : imageList.getOrder().toString();
            }

            @Override
            public List<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest> getData() {
                return (imageList == null) ? null : imageList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     * 
     * @return list mapper
     */
    public static Mapper<FirmwareManifestPage, ListResponse<FirmwareManifest>> getListMapper() {
        return new Mapper<FirmwareManifestPage, ListResponse<FirmwareManifest>>() {

            @Override
            public ListResponse<FirmwareManifest> map(FirmwareManifestPage toBeMapped) {
                return FirmwareManifestAdapter.mapList(toBeMapped);
            }

        };
    }

}
