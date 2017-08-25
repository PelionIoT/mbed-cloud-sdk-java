package com.arm.mbed.cloud.sdk.update.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.update.model.FirmwareImage;

@Preamble(description = "Adapter for firmware image model")
@Internal
public class FirmwareImageAdapter {

    public static com.arm.mbed.cloud.sdk.update.model.FirmwareImage map(
            com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage firmwareImage) {
        if (firmwareImage == null) {
            return null;
        }
        com.arm.mbed.cloud.sdk.update.model.FirmwareImage image = new FirmwareImage(firmwareImage.getId(),
                TranslationUtils.toUrl(firmwareImage.getDatafile()), firmwareImage.getDatafileChecksum(),
                TranslationUtils.toLong(firmwareImage.getDatafileSize()),
                TranslationUtils.toDate(firmwareImage.getCreatedAt()),
                TranslationUtils.toDate(firmwareImage.getUpdatedAt()));
        image.setDataFile(null);
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

    public static ListResponse<FirmwareImage> mapList(FirmwareImagePage list) {

        final FirmwareImagePage imageList = list;
        RespList<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage> respList = new RespList<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage>() {

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
            public List<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage> getData() {
                return (imageList == null) ? null : imageList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    public static Mapper<FirmwareImagePage, ListResponse<FirmwareImage>> getListMapper() {
        return new Mapper<FirmwareImagePage, ListResponse<FirmwareImage>>() {

            @Override
            public ListResponse<FirmwareImage> map(FirmwareImagePage toBeMapped) {
                return FirmwareImageAdapter.mapList(toBeMapped);
            }

        };
    }

}
