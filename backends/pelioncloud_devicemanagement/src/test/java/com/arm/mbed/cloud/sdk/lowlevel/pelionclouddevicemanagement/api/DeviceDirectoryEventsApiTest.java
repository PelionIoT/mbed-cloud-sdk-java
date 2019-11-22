package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceDirectoryEventsApi
 */
public class DeviceDirectoryEventsApiTest {

    private DeviceDirectoryEventsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceDirectoryEventsApi.class);
    }

    /**
     * List all device events.
     *
     * List all device events for an account. **Example:** Following example gets device-events limiting returned
     * results to max 5 events &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/device-events?limit&#x3D;5 \\ -H &#39;Authorization: Bearer &lt;API
     * key&gt;&#39; &#x60;&#x60;&#x60; or to get events for certain device filter based on device_id: &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/device-events?device_id&#x3D;&lt;device_id&gt; \\ -H
     * &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deviceEventListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String dateTimeIn = null;
        String dateTimeNin = null;
        DateTime dateTimeLte = null;
        DateTime dateTimeGte = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String deviceIdEq = null;
        String deviceIdNeq = null;
        String deviceIdIn = null;
        String deviceIdNin = null;
        String eventTypeEq = null;
        String eventTypeNeq = null;
        String eventTypeIn = null;
        String eventTypeNin = null;
        Boolean stateChangeEq = null;
        Boolean stateChangeNeq = null;
        // DeviceEventPage response = api.deviceEventList(limit, order, after, include, filter, dateTimeIn, dateTimeNin,
        // dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn,
        // idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn,
        // eventTypeNin, stateChangeEq, stateChangeNeq);

        // TODO: test validations
    }

    /**
     * Retrieve a device event.
     *
     * Retrieve a specific device event. **Example:** To fetch a specific event you can use the &#39;id&#39; field form
     * the &#39;/v3/device-events&#39;. Form of &#39;016c03d40a4e000000000001001003b4&#39; &#x60;&#x60;&#x60; curl -X
     * GET https://api.us-east-1.mbedcloud.com/v3/device-events/&lt;device_event_id&gt; \\ -H &#39;Authorization: Bearer
     * &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deviceEventRetrieveTest() {
        String deviceEventId = null;
        // DeviceEventData response = api.deviceEventRetrieve(deviceEventId);

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
        String dateTimeIn = null;
        String dateTimeNin = null;
        DateTime dateTimeLte = null;
        DateTime dateTimeGte = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String deviceIdEq = null;
        String deviceIdNeq = null;
        String deviceIdIn = null;
        String deviceIdNin = null;
        String eventTypeEq = null;
        String eventTypeNeq = null;
        String eventTypeIn = null;
        String eventTypeNin = null;
        Boolean stateChangeEq = null;
        Boolean stateChangeNeq = null;
        String stateChangeIn = null;
        String stateChangeNin = null;
        // DeviceEventPage response = api.deviceLogList(limit, order, after, include, filter, dateTimeIn, dateTimeNin,
        // dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn,
        // idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn,
        // eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin);

        // TODO: test validations
    }

    /**
     * DEPRECATED: Retrieve a device event.
     *
     * Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/ instead).
     */
    @Test
    public void deviceLogRetrieveTest() {
        String deviceEventId = null;
        // DeviceEventData response = api.deviceLogRetrieve(deviceEventId);

        // TODO: test validations
    }
}
