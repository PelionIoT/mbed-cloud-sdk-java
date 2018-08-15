package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Data access object definition of create, read, update, and delete
 * (<a href="https://en.wikipedia.org/wiki/Create,_read,_update_and_delete">CRUD</a>) persistence actions in the Cloud.
 *
 * @param <T>
 *            Data model type
 */
@Preamble(description = "Data Access Object definition for CRUD")
public interface CrudDao<T extends SdkModel> extends ModelDao<T> {

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

    /**
     * Fetches data from the Cloud.
     *
     * @param id
     *            identifier of the model as defined by {@link SdkModel#getId()}.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void read(String id) throws MbedCloudException;

    /**
     * Fetches data from the Cloud.
     * <p>
     * Note: Similar to {@link #read(String)} but the underlying identifier value set
     * using{@link ModelDao#setId(String)} is used.
     *
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void read() throws MbedCloudException;

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
