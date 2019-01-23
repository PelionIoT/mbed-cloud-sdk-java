package com.arm.mbed.cloud.sdk.common;

import java.io.Closeable;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

/**
 *
 * Sdk context: all necessary context information to share within an Sdk session.
 *
 */
@Preamble(description = "Definition of a Pelion SDK's context")
public interface SdkContext extends Closeable, Cloneable {
    public static final String METHOD_GET_MODULE_NAME = "getModuleName";
    public static final String METHOD_GET_API_METADATA = "getLastApiMetadata";

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
     * Gets the options used for connection to the Cloud.
     * 
     * @return connection options.
     */
    ConnectionOptions getConnectionOption();

    /**
     * Gets meta data for the last Pelion Cloud API call.
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

    /**
     * Clones this instance.
     * 
     * @return a cloned context.
     */
    SdkContext clone();

}
