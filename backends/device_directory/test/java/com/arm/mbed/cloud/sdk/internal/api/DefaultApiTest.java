package com.arm.mbed.cloud.sdk.internal.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.model.DeviceData;
import com.arm.mbed.cloud.sdk.internal.model.DeviceDataPatchRequest;
import com.arm.mbed.cloud.sdk.internal.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.internal.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.internal.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.internal.model.DeviceEventPage;
import com.arm.mbed.cloud.sdk.internal.model.DevicePage;
import com.arm.mbed.cloud.sdk.internal.model.DeviceQuery;
import com.arm.mbed.cloud.sdk.internal.model.DeviceQueryPage;
import com.arm.mbed.cloud.sdk.internal.model.DeviceQueryPatchRequest;
import com.arm.mbed.cloud.sdk.internal.model.DeviceQueryPostPutRequest;
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
     * 
     *
     * Create device
     */
    @Test
    public void deviceCreateTest() {
        DeviceDataPostRequest device = null;
        // DeviceData response = api.deviceCreate(device);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Delete device
     */
    @Test
    public void deviceDestroyTest() {
        String id = null;
        // Void response = api.deviceDestroy(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * List all device events.
     */
    @Test
    public void deviceEventListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String filter = null;
        String include = null;
        // DeviceEventPage response = api.deviceEventList(limit, order, after, filter, include);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Retrieve device event
     */
    @Test
    public void deviceEventRetrieveTest() {
        String deviceEventId = null;
        // DeviceEventData response = api.deviceEventRetrieve(deviceEventId);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * List all devices.
     */
    @Test
    public void deviceListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String filter = null;
        String include = null;
        // DevicePage response = api.deviceList(limit, order, after, filter, include);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * List all device events (deprecated, use /v3/device-events/ instead).
     */
    @Test
    public void deviceLogListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String filter = null;
        String include = null;
        // DeviceEventPage response = api.deviceLogList(limit, order, after, filter, include);

        // TODO: test validations
    }
    
    /**
     * 
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
     * 
     *
     * Update device fields
     */
    @Test
    public void devicePartialUpdateTest() {
        String id = null;
        DeviceDataPatchRequest device = null;
        // DeviceData response = api.devicePartialUpdate(id, device);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Create device query.
     */
    @Test
    public void deviceQueryCreateTest() {
        DeviceQueryPostPutRequest device = null;
        // DeviceQuery response = api.deviceQueryCreate(device);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Delete device query.
     */
    @Test
    public void deviceQueryDestroyTest() {
        String queryId = null;
        // Void response = api.deviceQueryDestroy(queryId);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * List all device queries. The result will be paged into pages of 100.
     */
    @Test
    public void deviceQueryListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String filter = null;
        String include = null;
        // DeviceQueryPage response = api.deviceQueryList(limit, order, after, filter, include);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Update device query fields.
     */
    @Test
    public void deviceQueryPartialUpdateTest() {
        String queryId = null;
        DeviceQueryPatchRequest deviceQuery = null;
        // DeviceQuery response = api.deviceQueryPartialUpdate(queryId, deviceQuery);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Retrieve device query.
     */
    @Test
    public void deviceQueryRetrieveTest() {
        String queryId = null;
        // DeviceQuery response = api.deviceQueryRetrieve(queryId);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Update device query.
     */
    @Test
    public void deviceQueryUpdateTest() {
        String queryId = null;
        DeviceQueryPostPutRequest body = null;
        // DeviceQuery response = api.deviceQueryUpdate(queryId, body);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Retrieve device
     */
    @Test
    public void deviceRetrieveTest() {
        String id = null;
        // DeviceData response = api.deviceRetrieve(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Update device
     */
    @Test
    public void deviceUpdateTest() {
        String id = null;
        DeviceDataPutRequest device = null;
        // DeviceData response = api.deviceUpdate(id, device);

        // TODO: test validations
    }
    
}
