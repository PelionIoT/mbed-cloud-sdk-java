package com.arm.mbed.cloud.sdk.enrollment.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.internal.enrollment.api.PublicApiApi;

@Preamble(description = "Endpoint for Enrollment API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final PublicApiApi enrollment;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}.
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.enrollment = initialiseService(PublicApiApi.class);

    }

    public PublicApiApi getEnrollment() {
        return enrollment;
    }

    @Override
    public EndPoints clone() {
        return new EndPoints(getRegistryClone());
    }
}
