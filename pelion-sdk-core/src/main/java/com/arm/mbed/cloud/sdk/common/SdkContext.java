package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

/**
 *
 * Sdk context: all necessary context information to share within an Sdk session.
 *
 */
@Preamble(description = "Definition of a Pelion SDK's context")
public interface SdkContext {

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
     * Gets the SDK module name in use.
     *
     * @return module name.
     */
    String getModuleName();

    /**
     * Gets the Sdk service registry.
     * 
     * @return the service registry in use.
     */
    ServiceRegistry getServiceRegistry();

}
