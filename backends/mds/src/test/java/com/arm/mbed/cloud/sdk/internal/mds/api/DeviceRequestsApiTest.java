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
     * This API enables you to receive asyncronous responses with asyncId defined by you. Another major difference to the  existing [/v2/endpoints/{device-id}/{resourcePath}](/docs/v1.2/service-api-references/connect-api.html#v2EndpointsDeviceIdResourcePathGet) API is that the data is always provided (also cached resource values) via the [event notification channel](/docs/v1.2/connecting/event-notification.html)  instead of the request response.  This can help you to streamline your application as you can use existing indentifiers as the asyncID. For example, you can use the  web application&#39;s session ID along the device ID combined with the resource path as asyncID. You do not need to have a separate  mapping from asyncID to your application data model. Also as the data is always provided via the event notification channel, you can  implement only one data handling logic for resource read.  The provided async-id is present in the [AsyncIDResponse](/docs/v1.2/service-api-references/connect-api.html#AsyncIDResponse).   &#x60;&#x60;&#x60; Example URI: POST /v2/device-requests/015f2fa34d310000000000010030036c?async-id&#x3D;123e4567-e89b-12d3-a456-426655440000  Example payloads: { \&quot;method\&quot;: \&quot;GET\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1\&quot; } { \&quot;method\&quot;: \&quot;PUT\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1%20?k1&#x3D;v1&amp;k2&#x3D;v2%22\&quot;, \&quot;accept\&quot;: \&quot;text/plain\&quot;, \&quot;content-type\&quot;: \&quot;text/plain\&quot;, \&quot;payload-b64\&quot;: \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot; }  Example notification payload (AsyncIDResponse): { \&quot;async-responses\&quot;: [ { \&quot;id\&quot;: \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 200, \&quot;payload\&quot;: \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot;, \&quot;ct\&quot;: \&quot;text/plain\&quot;, \&quot;max-age\&quot;: 600 } ] } &#x60;&#x60;&#x60; 
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
