package com.arm.mbed.cloud.sdk.billing.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.billing.api.DefaultApi;

@Preamble(description = "Endpoint for Billing API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DefaultApi billing;

    /**
     * Constructor.
     *
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super(wrapper);
        this.billing = initialiseBilling(wrapper);

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

    private DefaultApi initialiseBilling(ApiClientWrapper wrapper) {
        return wrapper.createService(DefaultApi.class);
    }

    public DefaultApi getBilling() {
        return billing;
    }

}
