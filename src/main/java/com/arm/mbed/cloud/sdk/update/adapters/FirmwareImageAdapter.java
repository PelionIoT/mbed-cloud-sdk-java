package com.arm.mbed.cloud.sdk.update.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.update.model.FirmwareImage;

@Preamble(description = "Adapter for firmware image model")
@Internal
public class FirmwareImageAdapter {

    // TODO
    public static com.arm.mbed.cloud.sdk.update.model.FirmwareImage map(
            com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage firmwareImage) {
        if (firmwareImage == null) {
            return null;
        }
        com.arm.mbed.cloud.sdk.update.model.FirmwareImage image = new FirmwareImage(firmwareImage.getId(),
                TranslationUtils.toUrl("//TODO"), firmwareImage.getDatafileChecksum(),
                TranslationUtils.toDate(firmwareImage.getCreatedAt()),
                TranslationUtils.toDate(firmwareImage.getUpdatedAt()));
        image.setDescription(image.getDescription());
        image.setName(firmwareImage.getName());
        return image;
    }

    public static Mapper<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage, com.arm.mbed.cloud.sdk.update.model.FirmwareImage> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage, com.arm.mbed.cloud.sdk.update.model.FirmwareImage>() {

            @Override
            public com.arm.mbed.cloud.sdk.update.model.FirmwareImage map(
                    com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage toBeMapped) {
                return FirmwareImageAdapter.map(toBeMapped);
            }
        };
    }

}
