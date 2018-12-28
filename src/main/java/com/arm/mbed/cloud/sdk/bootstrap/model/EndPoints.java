package com.arm.mbed.cloud.sdk.bootstrap.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.api.PreSharedKeysApi;

@Preamble(description = "Endpoint for bootstrap API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final PreSharedKeysApi presharedKeys;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}.
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.presharedKeys = initialiseService(PreSharedKeysApi.class);
    }

    public PreSharedKeysApi getPresharedKeys() {
        return presharedKeys;
    }

    @Override
    public EndPoints clone() {
        return new EndPoints(getRegistryClone());
    }
}
