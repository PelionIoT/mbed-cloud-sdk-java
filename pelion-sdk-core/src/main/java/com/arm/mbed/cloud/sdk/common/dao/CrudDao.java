package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Data access object definition of create, read, update, and delete
 * (<a href="https://en.wikipedia.org/wiki/Create,_read,_update_and_delete">CRUD</a>) persistence actions in the Cloud.
 *
 * @param <T>
 *            Data model type
 */
@Preamble(description = "Data Access Object definition for CRUD")
public interface CrudDao<T extends SdkModel> extends CreateDao<T>, ReadDao<T>, UpdateDao<T>, DeleteDao<T> {
    // Nothing to define

}
