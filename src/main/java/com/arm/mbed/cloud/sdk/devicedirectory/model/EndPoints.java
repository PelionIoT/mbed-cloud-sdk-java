package com.arm.mbed.cloud.sdk.devicedirectory.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

@Preamble(description = "Endpoint for Device Directory API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DefaultApi directory;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}.
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.directory = initialiseService(DefaultApi.class);

    }

    public DefaultApi getDirectory() {
        return directory;
    }

    @Override
    public EndPoints clone() {
        return new EndPoints(getRegistryClone());
    }

}
