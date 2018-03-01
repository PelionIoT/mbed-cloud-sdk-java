package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.mds.model.DeviceRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * This API provides an interface to asynchronously call methods on a device.  The &#x60;async-id&#x60; is provided by the client, enabling the client to track the end-to-end flow with an identifier that is relevant to the end application. For example, a web application&#39;s session ID along with the device ID and the resource path could be used as the &#x60;async-id&#x60;. This also avoids any race conditions with [the notification channel](/docs/v1.2/connecting/event-notification.html). All responses are sent through the currently configured notification channel as [AsyncIDResponse](/docs/v1.2/service-api-references/connect-api.html#AsyncIDResponse).  For &#x60;GET&#x60; methods, values may be fetched from an internal cache, instead of contacting the device.  See also: [/v2/endpoints/{device-id}/{resourcePath}](/docs/v1.2/service-api-references/connect-api.html#v2EndpointsDeviceIdResourcePathGet)  &#x60;&#x60;&#x60; Example URI: POST /v2/device-requests/015f2fa34d310000000000010030036c?async-id&#x3D;123e4567-e89b-12d3-a456-426655440000  Example payloads: { \&quot;method\&quot;: \&quot;GET\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1\&quot; } { \&quot;method\&quot;: \&quot;PUT\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1%20?k1&#x3D;v1&amp;k2&#x3D;v2%22\&quot;, \&quot;accept\&quot;: \&quot;text/plain\&quot;, \&quot;content-type\&quot;: \&quot;text/plain\&quot;, \&quot;payload-b64\&quot;: \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot; }  Immediate response: 202 Accepted  Example AsyncIDResponse, delivered via the notification channel: { \&quot;async-responses\&quot;: [ { \&quot;id\&quot;: \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 200, \&quot;payload\&quot;: \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot;, \&quot;ct\&quot;: \&quot;text/plain\&quot;, \&quot;max-age\&quot;: 600 } ] } &#x60;&#x60;&#x60; 
     */
    @Test
    public void v2DeviceRequestsDeviceIdPostTest() {
        String deviceId = null;
        String asyncId = null;
        DeviceRequest body = null;
        // Void response = api.v2DeviceRequestsDeviceIdPost(deviceId, asyncId, body);

        // TODO: test validations
    }
}
