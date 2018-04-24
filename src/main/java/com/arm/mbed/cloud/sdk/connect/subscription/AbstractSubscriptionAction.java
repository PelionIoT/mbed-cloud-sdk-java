package com.arm.mbed.cloud.sdk.connect.subscription;

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;

@Preamble(description = "")
public abstract class AbstractSubscriptionAction implements CallbackWithException<FilterOptions, MbedCloudException> {

    private final Connect api;

    public AbstractSubscriptionAction(Connect api) {
        super();
        this.api = api;
    }

}
