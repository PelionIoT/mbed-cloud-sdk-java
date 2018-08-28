package com.arm.mbed.cloud.sdk.internal.devicedirectory.api;

import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceGroup;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceGroupManipulation;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceGroupPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DevicePage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQuery;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPostPutRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.Group;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.Group1;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private DefaultApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DefaultApi.class);
    }

    /**
     * Create a device
     *
     * Create a new device.
     */
    @Test
    public void deviceCreateTest() {
        DeviceDataPostRequest device = null;
        // DeviceData response = api.deviceCreate(device);

        // TODO: test validations
    }
    /**
     * Delete a device.
     *
     * Delete device. Only available for devices with a developer certificate. Attempts to delete a device with a production certicate will return a 400 response.
     */
    @Test
    public void deviceDestroyTest() {
        String id = null;
        // Void response = api.deviceDestroy(id);

        // TODO: test validations
    }
    /**
     * List all device events.
     *
     * List all device events for an account.
     */
    @Test
    public void deviceEventListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        // DeviceEventPage response = api.deviceEventList(limit, order, after, include, filter);

        // TODO: test validations
    }
    /**
     * Retrieve a device event.
     *
     * Retrieve a specific device event.
     */
    @Test
    public void deviceEventRetrieveTest() {
        String deviceEventId = null;
        // DeviceEventData response = api.deviceEventRetrieve(deviceEventId);

        // TODO: test validations
    }
    /**
     * List all devices.
     *
     * List all devices.
     */
    @Test
    public void deviceListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        // DevicePage response = api.deviceList(limit, order, after, include, filter);

        // TODO: test validations
    }
    /**
     * DEPRECATED: List all device events.
     *
     * DEPRECATED: List all device events. Use &#x60;/v3/device-events/&#x60; instead.
     */
    @Test
    public void deviceLogListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        // DeviceEventPage response = api.deviceLogList(limit, order, after, include, filter);

        // TODO: test validations
    }
    /**
     * DEPRECATED: Retrieve a device event.
     *
     * Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/ instead)
     */
    @Test
    public void deviceLogRetrieveTest() {
        String deviceEventId = null;
        // DeviceEventData response = api.deviceLogRetrieve(deviceEventId);

        // TODO: test validations
    }
    /**
     * Create a device query
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
     * Delete a device query
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
     * List all device queries. The result will be paged into pages of 100.
     */
    @Test
    public void deviceQueryListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        // DeviceQueryPage response = api.deviceQueryList(limit, order, after, include, filter);

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
     * Update a device query
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
    /**
     * Get a devices
     *
     * Retrieve information about a specific device.
     */
    @Test
    public void deviceRetrieveTest() {
        String id = null;
        // DeviceData response = api.deviceRetrieve(id);

        // TODO: test validations
    }
    /**
     * Update a device
     *
     * Update a specific device.
     */
    @Test
    public void deviceUpdateTest() {
        String id = null;
        DeviceDataPutRequest device = null;
        // DeviceData response = api.deviceUpdate(id, device);

        // TODO: test validations
    }
    /**
     * Create a group
     *
     * Create a group
     */
    @Test
    public void groupCreateTest() {
        Group group = null;
        // DeviceGroup response = api.groupCreate(group);

        // TODO: test validations
    }
    /**
     * Delete a group
     *
     * Delete a group.
     */
    @Test
    public void groupDeleteTest() {
        String deviceGroupId = null;
        // Void response = api.groupDelete(deviceGroupId);

        // TODO: test validations
    }
    /**
     * List all groups.
     *
     * List all groups.
     */
    @Test
    public void groupListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        // DeviceGroupPage response = api.groupList(limit, order, after, include, filter);

        // TODO: test validations
    }
    /**
     * Add a device to a group
     *
     * Add one device to a group
     */
    @Test
    public void groupMembersAddTest() {
        String deviceGroupId = null;
        DeviceGroupManipulation body = null;
        // DevicePage response = api.groupMembersAdd(deviceGroupId, body);

        // TODO: test validations
    }
    /**
     * Remove a device from a group
     *
     * Remove one device from a group
     */
    @Test
    public void groupMembersRemoveTest() {
        String deviceGroupId = null;
        DeviceGroupManipulation body = null;
        // DevicePage response = api.groupMembersRemove(deviceGroupId, body);

        // TODO: test validations
    }
    /**
     * Get a page of devices
     *
     * Get a page of device
     */
    @Test
    public void groupMembersRetrieveTest() {
        String deviceGroupId = null;
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        // DevicePage response = api.groupMembersRetrieve(deviceGroupId, limit, order, after, include, filter);

        // TODO: test validations
    }
    /**
     * Get a group.
     *
     * Get a group.
     */
    @Test
    public void groupRetrieveTest() {
        String deviceGroupId = null;
        // DeviceGroup response = api.groupRetrieve(deviceGroupId);

        // TODO: test validations
    }
    /**
     * Modify the attributes of a group.
     *
     * Modify the attributes of a group.
     */
    @Test
    public void groupUpdateTest() {
        String deviceGroupId = null;
        Group1 group = null;
        // DeviceGroup response = api.groupUpdate(deviceGroupId, group);

        // TODO: test validations
    }
}
