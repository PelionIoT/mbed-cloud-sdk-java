package com.arm.mbed.cloud.sdk.update.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadata.DeploymentStateEnum;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.update.model.CampaignDeviceState;
import com.arm.mbed.cloud.sdk.update.model.DeviceState;

@Preamble(description = "Adapter for campaign device state model")
@Internal
public final class CampaignDeviceStateAdapter {

    private CampaignDeviceStateAdapter() {
        super();
    }

    /**
     * Maps metadata.
     *
     * @param metadata
     *            campaign metadata
     * @return campaign state
     */
    public static CampaignDeviceState map(CampaignDeviceMetadata metadata) {
        if (metadata == null) {
            return null;
        }
        return new CampaignDeviceState(metadata.getId(), metadata.getDeviceId(), metadata.getCampaign(),
                                       toDeviceState(metadata.getDeploymentState()), metadata.getName(),
                                       metadata.getDescription(), TranslationUtils.toDate(metadata.getCreatedAt()),
                                       TranslationUtils.toDate(metadata.getUpdatedAt()), metadata.getMechanism(),
                                       TranslationUtils.toUrl(metadata.getMechanismUrl()));
    }

    /**
     * Gets mapper.
     *
     * @return mapper.
     */
    public static Mapper<CampaignDeviceMetadata, CampaignDeviceState> getMapper() {
        return new Mapper<CampaignDeviceMetadata, CampaignDeviceState>() {

            @Override
            public CampaignDeviceState map(CampaignDeviceMetadata toBeMapped) {
                return CampaignDeviceStateAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Maps list of campaign metadata.
     *
     * @param list
     *            metadata page
     * @return list of campaign metadata
     */
    public static ListResponse<CampaignDeviceState> mapList(CampaignDeviceMetadataPage list) {
        final CampaignDeviceMetadataPage deviceList = list;
        final RespList<CampaignDeviceMetadata> respList = new RespList<CampaignDeviceMetadata>() {

            @Override
            public Boolean getHasMore() {
                return (deviceList == null) ? null : deviceList.isHasMore();
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
            public String getContinuationMarker() {
                return null;
            }

            @Override
            public List<CampaignDeviceMetadata> getData() {
                return (deviceList == null) ? null : deviceList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     *
     * @return list mapper
     */
    public static Mapper<CampaignDeviceMetadataPage, ListResponse<CampaignDeviceState>> getListMapper() {
        return new Mapper<CampaignDeviceMetadataPage, ListResponse<CampaignDeviceState>>() {

            @Override
            public ListResponse<CampaignDeviceState> map(CampaignDeviceMetadataPage toBeMapped) {
                return CampaignDeviceStateAdapter.mapList(toBeMapped);
            }

        };
    }

    private static DeviceState toDeviceState(DeploymentStateEnum state) {
        if (state == null) {
            return DeviceState.getUnknownEnum();
        }

        switch (state) {
            case DEPLOYED:
                return DeviceState.DEPLOYED;
            case FAILED_CONNECTOR_CHANNEL_UPDATE:
                return DeviceState.FAILED_CONNECTOR_CHANNEL_UPDATE;
            case MANIFESTREMOVED:
                return DeviceState.MANIFEST_REMOVED;
            case PENDING:
                return DeviceState.PENDING;
            case UPDATED_CONNECTOR_CHANNEL:
                return DeviceState.UPDATED_CONNECTOR_CHANNEL;
            case DEREGISTERED:
                return DeviceState.DEREGISTERED;
            default:
                break;

        }
        return DeviceState.getUnknownEnum();
    }
}
