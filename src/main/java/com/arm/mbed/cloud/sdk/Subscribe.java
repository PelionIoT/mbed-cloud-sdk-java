package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.Experimental;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

@Preamble(description = "Specifies Subscribe API")
@Module
/**
 * API exposing functionality for dealing with subscription
 */
@Experimental
public class Subscribe extends AbstractApi {

    /**
     * Subscribe module constructor.
     * 
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Subscribe(@NonNull ConnectionOptions options) {
        super(options);
        // endpoint = new EndPoints(this.client);
    }

    /**
     * Retrieves module name.
     * 
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Subscribe";
    }
}
