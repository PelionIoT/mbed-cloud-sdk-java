package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceRequest;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceRequestsApi
 */
public class DeviceRequestsApiTest {

    private DeviceRequestsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceRequestsApi.class);
    }

    /**
     * Send an async request to device
     *
     * This API provides an interface to asynchronously call methods on a device. The &#x60;async-id&#x60; is provided
     * by the client, enabling the client to track the end-to-end flow with an identifier that is relevant to the end
     * application. For example, a web application&#39;s session ID along with the device ID and the resource path could
     * be used as the &#x60;async-id&#x60;. This also avoids any race conditions with [the notification
     * channel](/docs/current/integrate-web-app/event-notification.html). All responses are sent through the currently
     * configured notification channel as an **AsyncIDResponse**. For &#x60;GET&#x60; methods, values may be fetched
     * from an internal cache, instead of contacting the device. See also /v2/endpoints/{device-id}/{resourcePath}. You
     * can write [Notification Rules](../connecting/resource-change-webapp.html#notification-rules) for a resource with
     * PUT command. Please see example of the payload below. &#x60;&#x60;&#x60; { \&quot;method\&quot;:
     * \&quot;PUT\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1?lt&#x3D;10&amp;gt&#x3D;60&amp;pmax&#x3D;120\&quot; }
     * &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; Example URI: POST
     * /v2/device-requests/015f2fa34d310000000000010030036c?async-id&#x3D;123e4567-e89b-12d3-a456-426655440000 Example
     * payload to read value from resource /5/0/1: { \&quot;method\&quot;: \&quot;GET\&quot;, \&quot;uri\&quot;:
     * \&quot;/5/0/1\&quot; } Example payload to set notification rules for resource /5/0/1: { \&quot;method\&quot;:
     * \&quot;PUT\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1?lt&#x3D;10&amp;gt&#x3D;60&amp;pmax&#x3D;120\&quot; } Example
     * payload to write value \&quot;value1\&quot; to resource /5/0/1: { \&quot;method\&quot;: \&quot;PUT\&quot;,
     * \&quot;uri\&quot;: \&quot;/5/0/1%20?k1&#x3D;v1&amp;k2&#x3D;v2%22\&quot;, \&quot;accept\&quot;:
     * \&quot;text/plain\&quot;, \&quot;content-type\&quot;: \&quot;text/plain\&quot;, \&quot;payload-b64\&quot;:
     * \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot; } Immediate response: 202 Accepted Example AsyncIDResponse, delivered via
     * the notification channel: { \&quot;async-responses\&quot;: [ { \&quot;id\&quot;:
     * \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 200, \&quot;payload\&quot;:
     * \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot;, \&quot;ct\&quot;: \&quot;text/plain\&quot;, \&quot;max-age\&quot;: 600 } ]
     * } &#x60;&#x60;&#x60;
     */
    @Test
    public void createAsyncRequestTest() {
        String deviceId = null;
        String asyncId = null;
        DeviceRequest body = null;
        // Void response = api.createAsyncRequest(deviceId, asyncId, body);

        // TODO: test validations
    }
}
