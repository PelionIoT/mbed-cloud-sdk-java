package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Data access object (<a href="https://en.wikipedia.org/wiki/Data_access_object">DAO</a>) definition for read
 * persistence actions.
 *
 * @param <T>
 *            Data model type
 */
@Preamble(description = "Data Access Object definition for reading")
public interface ReadDao<T extends SdkModel> extends ModelDao<T> {
    String METHOD_NAME_READ = "read";
    String METHOD_NAME_ME = "me";

    /**
     * Fetches data from the Cloud.
     *
     * @param id
     *            identifier of the model as defined by {@link SdkModel#getId()}.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     * @throws UnsupportedOperationException
     *             if it is not possible to read a model by just setting the identifier.
     */
    void read(String id) throws MbedCloudException, UnsupportedOperationException;

    /**
     * Fetches data from the Cloud.
     * <p>
     * Note: Similar to {@link #read(String)} but the underlying identifier value set using
     * {@link ModelDao#setId(String)} is used.
     *
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    void read() throws MbedCloudException;

}
