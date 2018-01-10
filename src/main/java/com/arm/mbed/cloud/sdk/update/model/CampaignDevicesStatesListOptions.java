package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing devise states")
public class CampaignDevicesStatesListOptions extends ListOptions {
    /**
     * Constructor.
     */
    public CampaignDevicesStatesListOptions() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public CampaignDevicesStatesListOptions clone() {
        final CampaignDevicesStatesListOptions opt = new CampaignDevicesStatesListOptions();
        opt.setOptions(this);
        return opt;
    }
}
