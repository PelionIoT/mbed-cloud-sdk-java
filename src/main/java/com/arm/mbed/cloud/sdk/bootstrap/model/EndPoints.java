package com.arm.mbed.cloud.sdk.bootstrap.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.api.PreSharedKeysApi;

@Preamble(description = "Endpoint for bootstrap API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final PreSharedKeysApi presharedKeys;

    /**
     * Constructor.
     *
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super(wrapper);
        this.presharedKeys = initialisePreSharedKeys(wrapper);

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

    private PreSharedKeysApi initialisePreSharedKeys(ApiClientWrapper wrapper) {
        return wrapper.createService(PreSharedKeysApi.class);
    }

    public PreSharedKeysApi getPresharedKeys() {
        return presharedKeys;
    }

}
