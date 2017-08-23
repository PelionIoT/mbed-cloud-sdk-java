package com.arm.mbed.cloud.sdk.update.adapters;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Filters;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.ListResponse;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign.StateEnum;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPutRequest;
import com.arm.mbed.cloud.sdk.update.model.Campaign;
import com.arm.mbed.cloud.sdk.update.model.CampaignState;

@Preamble(description = "Adapter for campaign model")
@Internal
public class CampaignAdapter {

    public static Campaign map(UpdateCampaign campaign) {
        if (campaign == null) {
            return null;
        }
        Campaign updateCampaign = new Campaign(campaign.getId(), TranslationUtils.toUrl(campaign.getRootManifestUrl()),
                TranslationUtils.convertTimestamp(campaign.getCreatedAt(), new Date()),
                TranslationUtils.toDate(campaign.getStartedAt()),
                TranslationUtils.convertTimestamp(campaign.getFinished(), new Date()));
        updateCampaign.setDescription(campaign.getDescription());
        updateCampaign.setManifestId(campaign.getRootManifestId());
        updateCampaign.setName(campaign.getName());
        updateCampaign.setScheduledAt(TranslationUtils.convertTimestamp(campaign.getFinished(), new Date()));
        updateCampaign.setState(toState(campaign.getState()));
        updateCampaign.setFilters(Filters.decodeFilters(campaign.getDeviceFilter()));
        return updateCampaign;
    }

    public static Mapper<UpdateCampaign, Campaign> getMapper() {
        return new Mapper<UpdateCampaign, Campaign>() {

            @Override
            public Campaign map(UpdateCampaign toBeMapped) {
                return CampaignAdapter.map(toBeMapped);
            }

        };
    }

    public static UpdateCampaignPostRequest reverseMapAdd(Campaign campaign) {
        return null;
    }

    public static UpdateCampaignPutRequest reverseMapUpdate(Campaign campaign) {
        return null;
    }

    private static CampaignState toState(StateEnum state) {
        if (state == null) {
            return CampaignState.getDefault();
        }
        switch (state) {
            case DEPLOYED:
                return CampaignState.DEPLOYED;
            case DEPLOYING:
                return CampaignState.DEPLOYING;
            case DEVICECOPY:
                return CampaignState.DEVICE_COPY;
            case DEVICEFETCH:
                return CampaignState.DEVICE_FETCH;
            case DRAFT:
                return CampaignState.DRAFT;
            case EXPIRED:
                return CampaignState.EXPIRED;
            case MANIFESTREMOVED:
                return CampaignState.MANIFEST_REMOVED;
            case PUBLISHING:
                return CampaignState.PUBLISHING;
            case SCHEDULED:
                return CampaignState.SCHEDULED;
            default:
                break;

        }
        return CampaignState.getDefault();
    }

    public static Mapper<UpdateCampaignPage, ListResponse<Campaign>> getListMapper() {
        // TODO Auto-generated method stub
        return null;
    }

}
