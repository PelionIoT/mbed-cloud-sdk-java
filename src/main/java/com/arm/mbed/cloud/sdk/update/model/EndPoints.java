package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceStore;
import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

@Preamble(description = "Endpoint for Update API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DefaultApi update;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceStore}.
     */
    public EndPoints(ServiceStore services) {
        super(services);
        this.update = initialiseService(DefaultApi.class);
    }

    public DefaultApi getUpdate() {
        return update;
    }

    @Override
    public EndPoints clone() {
        return new EndPoints(getServicesClone());
    }
}
