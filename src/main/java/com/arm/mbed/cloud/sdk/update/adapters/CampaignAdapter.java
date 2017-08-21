package com.arm.mbed.cloud.sdk.update.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPutRequest;
import com.arm.mbed.cloud.sdk.update.model.Campaign;

@Preamble(description = "Adapter for campaign model")
@Internal
public class CampaignAdapter {

    public static Mapper<UpdateCampaign, Campaign> getMapper() {
        // TODO Auto-generated method stub
        return null;
    }

    public static UpdateCampaignPostRequest mapAdd(Campaign campaign) {
        return null;
    }

    public static UpdateCampaignPutRequest mapUpdate(Campaign campaign) {
        return null;
    }

}
