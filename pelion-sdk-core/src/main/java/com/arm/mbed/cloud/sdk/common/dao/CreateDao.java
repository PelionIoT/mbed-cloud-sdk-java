package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Data access object (<a href="https://en.wikipedia.org/wiki/Data_access_object">DAO</a>) definition for create
 * persistence actions.
 *
 * @param <T>
 *            Data model type
 */
@Preamble(description = "Data Access Object definition for creation")
public interface CreateDao<T extends SdkModel> extends ModelDao<T> {
    String METHOD_NAME_CREATE = "create";

    /**
     * Creates a model on the Cloud.
     *
     * @param modelToCreate
     *            data to store. The underlying data model is replaced by {@code modelToCreate}.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void create(T modelToCreate) throws MbedCloudException;

    /**
     * Creates a model on the Cloud.
     * <p>
     * Note: Similar to {@link #create(SdkModel)} but the underlying data model is stored on the Cloud.
     *
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void create() throws MbedCloudException;

}
