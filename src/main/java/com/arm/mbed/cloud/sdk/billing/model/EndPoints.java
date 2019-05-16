package com.arm.mbed.cloud.sdk.billing.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DefaultApi;

@Preamble(description = "Endpoint for Billing API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DefaultApi billing;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.billing = initialiseService(DefaultApi.class);
    }

    public DefaultApi getBilling() {
        return billing;
    }

    @Override
    public EndPoints clone() {
        return new EndPoints(getRegistryClone());
    }
}
