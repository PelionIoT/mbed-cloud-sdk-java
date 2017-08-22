package com.arm.mbed.cloud.sdk.update.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.update.model.FirmwareManifest;

@Preamble(description = "Adapter for firmware manifest model")
@Internal
public class FirmwareManifestAdapter {

    public static FirmwareManifest map(com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest manifest) {
        if (manifest == null) {
            return null;
        }
        FirmwareManifest firmwareManifest = new FirmwareManifest(manifest.getId(), TranslationUtils.toUrl("//TODO"),
                manifest.getDeviceClass(), ManifestContentsAdapter.map(manifest.getManifestContents()),
                TranslationUtils.toDate(manifest.getCreatedAt()), TranslationUtils.toDate(manifest.getUpdatedAt()),
                TranslationUtils.toDate(manifest.getTimestamp()));
        firmwareManifest.setDataFile(null);// TODO
        firmwareManifest.setDescription(manifest.getDescription());
        firmwareManifest.setName(manifest.getName());
        return firmwareManifest;
    }

    public static Mapper<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest, FirmwareManifest> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest, FirmwareManifest>() {

            @Override
            public FirmwareManifest map(
                    com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest toBeMapped) {
                return map(toBeMapped);
            }

        };
    }

}
