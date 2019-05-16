package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DefaultApi;

@Preamble(description = "Endpoint for Update API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DefaultApi update;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}.
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.update = initialiseService(DefaultApi.class);
    }

    public DefaultApi getUpdate() {
        return update;
    }

    @Override
    public EndPoints clone() {
        return new EndPoints(getRegistryClone());
    }
}
