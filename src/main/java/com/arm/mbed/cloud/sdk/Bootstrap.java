package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.bootstrap.model.EndPoints;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

@Preamble(description = "Specifies Bootstrap API")
@Module
/**
 * API exposing functionality for dealing with bootstrap.
 */
public class Bootstrap extends AbstractApi {

    private final EndPoints endpoint;

    /**
     * Bootstrap module constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Bootstrap(@NonNull ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    /**
     * Retrieves module name.
     *
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Bootstrap";
    }
}
