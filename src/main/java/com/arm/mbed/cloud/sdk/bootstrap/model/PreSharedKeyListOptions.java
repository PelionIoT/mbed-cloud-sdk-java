package com.arm.mbed.cloud.sdk.bootstrap.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing pre-shared keys")
public class PreSharedKeyListOptions extends ListOptions {

    /**
     * Constructor.
     */
    public PreSharedKeyListOptions() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public PreSharedKeyListOptions clone() {
        final PreSharedKeyListOptions opt = new PreSharedKeyListOptions();
        opt.setOptions(this);
        return opt;
    }

}
