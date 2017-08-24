package com.arm.mbed.cloud.sdk.update.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata.DeploymentStateEnum;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.update.model.DeviceState;
import com.arm.mbed.cloud.sdk.update.model.CampaignDeviceStatus;

@Preamble(description = "Adapter for device status model")
@Internal
public class DeviceStatusAdapter {

    public static CampaignDeviceStatus map(CampaignDeviceMetadata metadata) {
        if (metadata == null) {
            return null;
        }
        CampaignDeviceStatus state = new CampaignDeviceStatus(metadata.getId(), metadata.getDeviceId(), metadata.getCampaign(),
                toDeviceState(metadata.getDeploymentState()), metadata.getName(), metadata.getDescription(),
                TranslationUtils.toDate(metadata.getCreatedAt()), TranslationUtils.toDate(metadata.getUpdatedAt()),
                metadata.getMechanism(), TranslationUtils.toUrl(metadata.getMechanismUrl()));
        return state;
    }

    public static Mapper<CampaignDeviceMetadata, CampaignDeviceStatus> getMapper() {
        return new Mapper<CampaignDeviceMetadata, CampaignDeviceStatus>() {

            @Override
            public CampaignDeviceStatus map(CampaignDeviceMetadata toBeMapped) {
                return DeviceStatusAdapter.map(toBeMapped);
            }

        };
    }

    public static ListResponse<CampaignDeviceStatus> mapList(CampaignDeviceMetadataPage list) {
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
                return (deviceList == null) ? null : deviceList.getOrder().toString();
            }

            @Override
            public List<CampaignDeviceMetadata> getData() {
                return (deviceList == null) ? null : deviceList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    public static Mapper<CampaignDeviceMetadataPage, ListResponse<CampaignDeviceStatus>> getListMapper() {
        return new Mapper<CampaignDeviceMetadataPage, ListResponse<CampaignDeviceStatus>>() {

            @Override
            public ListResponse<CampaignDeviceStatus> map(CampaignDeviceMetadataPage toBeMapped) {
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
