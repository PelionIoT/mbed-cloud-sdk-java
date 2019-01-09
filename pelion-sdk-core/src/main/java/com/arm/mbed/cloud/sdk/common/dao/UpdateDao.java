package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Data access object (<a href="https://en.wikipedia.org/wiki/Data_access_object">DAO</a>) definition for update
 * persistence actions.
 *
 * @param <T>
 *            Data model type
 */
@Preamble(description = "Data Access Object definition for updating")
public interface UpdateDao<T extends SdkModel> extends ModelDao<T> {
    String METHOD_NAME_UPDATE = "update";

    /**
     * Updates a model on the Cloud.
     *
     * @param modelToUpdate
     *            data to update on the Cloud. The underlying data model is replaced by {@code modelToUpdate}.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void update(T modelToUpdate) throws MbedCloudException;

    /**
     * Updates a model on the Cloud.
     * <p>
     * Note: Similar to {@link #update(SdkModel)} but the underlying data model is used instead.
     *
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void update() throws MbedCloudException;

}
