package com.arm.mbed.cloud.sdk.billing.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing service package quota history")
public class ServicePackageQuotaListOptions extends ListOptions {

    public ServicePackageQuotaListOptions() {
        super();
        setPageSize(new Integer(2));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public ServicePackageQuotaListOptions clone() {
        final ServicePackageQuotaListOptions opt = new ServicePackageQuotaListOptions();
        opt.setOptions(this);
        return opt;
    }

}
