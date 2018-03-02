package com.arm.mbed.cloud.sdk.enrollment.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.enrollment.api.PublicApiApi;

@Preamble(description = "Endpoint for Enrollment API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final PublicApiApi enrollment;

    /**
     * Constructor.
     * 
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super(wrapper);
        this.enrollment = initialiseEnrollment(wrapper);

    }

    /**
     * Constructor.
     * 
     * @param options
     *            connection options {@link ConnectionOptions}.
     */
    public EndPoints(ConnectionOptions options) {
        this(new ApiClientWrapper(options));

    }

    private PublicApiApi initialiseEnrollment(ApiClientWrapper wrapper) {
        return wrapper.createService(PublicApiApi.class);
    }

    public PublicApiApi getEnrollment() {
        return enrollment;
    }

}
