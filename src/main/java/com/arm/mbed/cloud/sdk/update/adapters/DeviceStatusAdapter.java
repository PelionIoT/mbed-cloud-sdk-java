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

@Preamble(description = "Adapter for device status model")
@Internal
public class DeviceStatusAdapter {

    public static DeviceStatus map(CampaignDeviceMetadata metadata) {
        if (metadata == null) {
            return null;
        }
        DeviceStatus state = new DeviceStatus(metadata.getId(), metadata.getDeviceId(), metadata.getCampaign(),
                toDeviceState(metadata.getDeploymentState()), metadata.getName(), metadata.getDescription(),
                TranslationUtils.toDate(metadata.getCreatedAt()), TranslationUtils.toDate(metadata.getUpdatedAt()),
                metadata.getMechanism(), TranslationUtils.toUrl(metadata.getMechanismUrl()));
        return state;
    }

    public static Mapper<CampaignDeviceMetadata, DeviceStatus> getMapper() {
        return new Mapper<CampaignDeviceMetadata, DeviceStatus>() {

            @Override
            public DeviceStatus map(CampaignDeviceMetadata toBeMapped) {
                return DeviceStatusAdapter.map(toBeMapped);
            }

        };
    }

    public static ListResponse<DeviceStatus> mapList(CampaignDeviceMetadataPage list) {
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

    public static Mapper<CampaignDeviceMetadataPage, ListResponse<DeviceStatus>> getListMapper() {
        return new Mapper<CampaignDeviceMetadataPage, ListResponse<DeviceStatus>>() {

            @Override
            public ListResponse<DeviceStatus> map(CampaignDeviceMetadataPage toBeMapped) {
                return DeviceStatusAdapter.mapList(toBeMapped);
            }

        };
    }

    private static DeviceState toDeviceState(DeploymentStateEnum state) {
        if (state == null) {
            return DeviceState.getDefault();
        }
        switch (state) {
            case DEPLOYED:
                return DeviceState.DEPLOYED;
            case FAILED_CONNECTOR_CHANNEL_UPDATE:
                break;
            case MANIFESTREMOVED:
                return DeviceState.MANIFEST_REMOVED;

            case PENDING:
                return DeviceState.PENDING;
            case UPDATED_CONNECTOR_CHANNEL:
                return DeviceState.UPDATED_CONNECTOR_CHANNEL;
            default:
                break;
        }
        return DeviceState.getDefault();
    }
}
