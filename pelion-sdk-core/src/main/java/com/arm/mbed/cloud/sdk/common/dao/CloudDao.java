package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;

/**
 *
 * Generic <a href="https://www.oracle.com/technetwork/java/dataaccessobject-138824.html">Data Access Object</a> (DAO)
 * definition for interacting with the Cloud.
 *
 */
@Preamble(description = "Generic DAO definition")
public interface CloudDao extends Cloneable {
    /**
     * Initialises the Cloud connection using default/environment values as described in {@link ConnectionOptions}.
     *
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void configure() throws MbedCloudException;

    /**
     * Sets cloud connection configuration.
     * <p>
     * Defines how to access the Cloud.
     *
     * @param options
     *            connection configuration
     *
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void configure(@Nullable ConnectionOptions options) throws MbedCloudException;

    /**
     * Sets cloud client.
     * <p>
     * Defines how to access the Cloud using a specific client.
     * 
     * @param client
     *            client to use
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void configure(@NonNull ApiClientWrapper client) throws MbedCloudException;

    /**
     * Configures the Cloud connection by actually providing directly the context to use.
     *
     * @param context
     *            an instance of the context.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void configure(@NonNull SdkContext context) throws MbedCloudException;

    /**
     * Configures the Cloud connection by actually providing directly the context to use.
     * <p>
     * Similar to {@link #configure(SdkContext)}
     * 
     * @param context
     *            an instance of the context.
     * @param <T>
     *            type of the Cloud DAO.
     * @return the configured DAO
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    <T extends CloudDao> T configureAndGet(@NonNull SdkContext context) throws MbedCloudException;

    /**
     * Gets the Sdk context {@link SdkContext} in use.
     *
     * @return the module in use by this DAO.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    SdkContext getContext() throws MbedCloudException;

    /**
     * Gets a Data Access Object Provider.
     * <p>
     * See {@link DaoProvider}
     * 
     * @return a DAO provider.
     */
    DaoProvider getDaoProvider();

    /**
     * Clones this instance.
     * 
     * @return a cloned instance.
     * @throws MbedCloudException
     *             if an error occurs during configuration
     */
    CloudDao clone();
}
