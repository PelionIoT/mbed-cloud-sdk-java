package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

@Preamble(description = "Endpoint for Update API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DefaultApi update;

    /**
     * Constructor.
     * 
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super(wrapper);
        this.update = initialiseUpdate(wrapper);

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

    private DefaultApi initialiseUpdate(ApiClientWrapper wrapper) {
        return wrapper.createService(DefaultApi.class);
    }

    public DefaultApi getUpdate() {
        return update;
    }

}
