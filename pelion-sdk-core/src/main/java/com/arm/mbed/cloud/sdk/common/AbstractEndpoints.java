package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic endpoints")
@Internal
public class AbstractEndpoints {

    private final ApiClientWrapper client;

    /**
     * Constructor.
     * 
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public AbstractEndpoints(ApiClientWrapper wrapper) {
        super();
        client = wrapper;
    }

    /**
     * Constructor.
     * 
     * @param options
     *            connection options {@link ConnectionOptions}
     */
    public AbstractEndpoints(ConnectionOptions options) {
        this(new ApiClientWrapper(options));
    }

    /**
     * Gets Mbed Cloud client.
     * 
     * @return the client
     */
    public ApiClientWrapper getClient() {
        return client;
    }

}
