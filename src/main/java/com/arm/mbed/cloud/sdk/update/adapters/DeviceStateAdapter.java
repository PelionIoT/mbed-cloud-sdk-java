package com.arm.mbed.cloud.sdk.update.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.ListResponse;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata.DeploymentStateEnum;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.update.model.DeviceState;
import com.arm.mbed.cloud.sdk.update.model.DeviceStatus;

@Preamble(description = "Adapter for device state model")
@Internal
public class DeviceStateAdapter {

    public static DeviceState map(CampaignDeviceMetadata metadata) {
        if (metadata == null) {
            return null;
        }
        DeviceState state = new DeviceState(metadata.getId(), metadata.getDeviceId(), metadata.getCampaign(),
                toDeviceState(metadata.getDeploymentState()), metadata.getName(), metadata.getDescription(),
                TranslationUtils.toDate(metadata.getCreatedAt()), TranslationUtils.toDate(metadata.getUpdatedAt()),
                metadata.getMechanism(), TranslationUtils.toUrl(metadata.getMechanismUrl()));
        return state;
    }

    public static Mapper<CampaignDeviceMetadata, DeviceState> getMapper() {
        return new Mapper<CampaignDeviceMetadata, DeviceState>() {

            @Override
            public DeviceState map(CampaignDeviceMetadata toBeMapped) {
                return DeviceStateAdapter.map(toBeMapped);
            }

        };
    }

    public static ListResponse<DeviceState> mapList(CampaignDeviceMetadataPage list) {
        final CampaignDeviceMetadataPage deviceList = list;
        RespList<CampaignDeviceMetadata> respList = new RespList<CampaignDeviceMetadata>() {

            @Override
            public Boolean getHasMore() {
                return (deviceList == null) ? null : deviceList.getHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (deviceList == null) ? null : deviceList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (deviceList == null) ? null : deviceList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (deviceList == null) ? null : deviceList.getLimit();
            }

            @Override
            public String getOrder() {
                return null;// TODO
            }

            @Override
            public List<CampaignDeviceMetadata> getData() {
                return (deviceList == null) ? null : deviceList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    public static Mapper<CampaignDeviceMetadataPage, ListResponse<DeviceState>> getListMapper() {
        return new Mapper<CampaignDeviceMetadataPage, ListResponse<DeviceState>>() {

            @Override
            public ListResponse<DeviceState> map(CampaignDeviceMetadataPage toBeMapped) {
                return DeviceStateAdapter.mapList(toBeMapped);
            }

        };
    }

    private static DeviceStatus toDeviceState(DeploymentStateEnum state) {
        if (state == null) {
            return DeviceStatus.getDefault();
        }
        switch (state) {
            case DEPLOYED:
                return DeviceStatus.DEPLOYED;
            case FAILED_CONNECTOR_CHANNEL_UPDATE:
                break;
            case MANIFESTREMOVED:
                return DeviceStatus.MANIFEST_REMOVED;

            case PENDING:
                return DeviceStatus.PENDING;
            case UPDATED_CONNECTOR_CHANNEL:
                return DeviceStatus.UPDATED_CONNECTOR_CHANNEL;
            default:
                break;
        }
        return DeviceStatus.getDefault();
    }
}
