package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Data access object (<a href="https://en.wikipedia.org/wiki/Data_access_object">DAO</a>) definition for delete
 * persistence actions.
 *
 * @param <T>
 *            Data model type
 */
@Preamble(description = "Data Access Object definition for deleting")
public interface DeleteDao<T extends SdkModel> extends ModelDao<T> {

    /**
     * Deletes a model on the Cloud.
     *
     * @param id
     *            identifier of the model as defined by {@link SdkModel#getId()}.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void delete(String id) throws MbedCloudException;

    /**
     * Deletes a model on the Cloud.
     * <p>
     * Note: Similar to {@link #delete(String)}.
     *
     * @param modelToDelete
     *            data model to delete.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void delete(T modelToDelete) throws MbedCloudException;

    /**
     * Deletes a model on the Cloud.
     * <p>
     * Note: Similar to {@link #delete(String)} but the underlying data model is deleted instead.
     *
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void delete() throws MbedCloudException;

}
