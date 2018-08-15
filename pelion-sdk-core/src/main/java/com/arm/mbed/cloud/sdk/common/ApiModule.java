package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

/**
 *
 * An API Module is a set of Cloud APIs (i.e. endpoints) which can be called to perform some actions towards the Cloud.
 *
 */
@Preamble(description = "Definition of a Pelion Cloud API module")
public interface ApiModule {

    /**
     * Gets SDK logger.
     *
     * @see SdkLogger
     * @return the logger.
     */
    SdkLogger getLogger();

    /**
     * Gets the underlying HTTP client.
     *
     * @return the client
     */
    ApiClientWrapper getClient();

    /**
     * Gets meta data for the last Arm Mbed Cloud API call.
     *
     * @see ApiMetadata
     * @return metadata
     */
    ApiMetadata getLastApiMetadata();

    /**
     * Gets the SDK module name.
     *
     * @return module name.
     */
    String getModuleName();

}
