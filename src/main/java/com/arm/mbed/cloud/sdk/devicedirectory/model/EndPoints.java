package com.arm.mbed.cloud.sdk.devicedirectory.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

@Preamble(description = "Endpoint for Device Directory API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DefaultApi directory;

    /**
     * Constructor.
     * 
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super(wrapper);
        this.directory = initialiseDirectory(wrapper);

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

    private DefaultApi initialiseDirectory(ApiClientWrapper wrapper) {
        return wrapper.createService(DefaultApi.class);
    }

    public DefaultApi getDirectory() {
        return directory;
    }

}
