package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for GatewayLogsPublicApiApi
 */
public class GatewayLogsPublicApiApiTest {

    private GatewayLogsPublicApiApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(GatewayLogsPublicApiApi.class);
    }

    /**
     * Retrieve a device log by ID.
     *
     * Retrieve a device log from a device by log ID. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H
     * &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/device-logs/(device_log_id) &#x60;&#x60;&#x60;
     */
    @Test
    public void getDeviceLogBasedOnLogIDTest() {
        String deviceLogId = null;
        // Log response = api.getDeviceLogBasedOnLogID(deviceLogId);

        // TODO: test validations
    }

    /**
     * List all device logs based on filters
     *
     * List logs for all devices based on a combination of filters. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\
     * -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/device-logs &#x60;&#x60;&#x60;
     */
    @Test
    public void listGatewayDeviceLogsTest() {
        String deviceIdIn = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        DateTime timestampLte = null;
        DateTime timestampGte = null;
        String appNameEq = null;
        String typeEq = null;
        String messageEq = null;
        String levelGte = null;
        // LogsPage response = api.listGatewayDeviceLogs(deviceIdIn, limit, after, order, include, timestampLte,
        // timestampGte, appNameEq, typeEq, messageEq, levelGte);

        // TODO: test validations
    }

    /**
     * Return the logs for a specific device.
     *
     * Retrieve logs for a given device based on a combination of filters. **Example usage:** &#x60;&#x60;&#x60; curl -X
     * GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/devices/{device_id}/logs &#x60;&#x60;&#x60;
     */
    @Test
    public void listSingleGatewayDeviceLogsTest() {
        String deviceId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        DateTime timestampLte = null;
        DateTime timestampGte = null;
        String appNameEq = null;
        String typeEq = null;
        String messageEq = null;
        String levelGte = null;
        // LogsPage response = api.listSingleGatewayDeviceLogs(deviceId, limit, after, order, include, timestampLte,
        // timestampGte, appNameEq, typeEq, messageEq, levelGte);

        // TODO: test validations
    }
}
