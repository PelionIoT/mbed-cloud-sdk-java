package com.arm.mbed.cloud.sdk.devicedirectory.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

@Preamble(description = "Endpoint for Device Directory API")
@Internal
public class EndPoints {

    private final DefaultApi directory;

    public EndPoints(ApiClientWrapper wrapper) {
        super();
        this.directory = initialiseDirectory(wrapper);

    }

    public EndPoints(ConnectionOptions options) {
        this(new ApiClientWrapper(options));

    }

    private DefaultApi initialiseDirectory(ApiClientWrapper wrapper) {
        return wrapper.createService(DefaultApi.class);
    }

    /**
     * @return the update
     */
    public DefaultApi getDirectory() {
        return directory;
    }

}
