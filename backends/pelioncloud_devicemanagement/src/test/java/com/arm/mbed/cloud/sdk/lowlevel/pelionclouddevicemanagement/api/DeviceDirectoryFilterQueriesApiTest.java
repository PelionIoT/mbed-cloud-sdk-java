package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQueryPostPutRequest;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceDirectoryFilterQueriesApi
 */
public class DeviceDirectoryFilterQueriesApiTest {

    private DeviceDirectoryFilterQueriesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceDirectoryFilterQueriesApi.class);
    }

    /**
     * Create a device query.
     *
     * Create a new device query.
     */
    @Test
    public void deviceQueryCreateTest() {
        DeviceQueryPostPutRequest device = null;
        // DeviceQuery response = api.deviceQueryCreate(device);

        // TODO: test validations
    }

    /**
     * Delete a device query.
     *
     * Delete a device query.
     */
    @Test
    public void deviceQueryDestroyTest() {
        String queryId = null;
        // Void response = api.deviceQueryDestroy(queryId);

        // TODO: test validations
    }

    /**
     * List device queries.
     *
     * List all device queries.
     */
    @Test
    public void deviceQueryListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String queryEq = null;
        String queryNeq = null;
        String queryIn = null;
        String queryNin = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // DeviceQueryPage response = api.deviceQueryList(limit, order, after, include, filter, createdAtIn,
        // createdAtNin, createdAtLte, createdAtGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin,
        // queryEq, queryNeq, queryIn, queryNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Retrieve a device query.
     *
     * Retrieve a specific device query.
     */
    @Test
    public void deviceQueryRetrieveTest() {
        String queryId = null;
        // DeviceQuery response = api.deviceQueryRetrieve(queryId);

        // TODO: test validations
    }

    /**
     * Update a device query.
     *
     * Update a specifc device query.
     */
    @Test
    public void deviceQueryUpdateTest() {
        String queryId = null;
        DeviceQueryPostPutRequest body = null;
        // DeviceQuery response = api.deviceQueryUpdate(queryId, body);

        // TODO: test validations
    }
}
