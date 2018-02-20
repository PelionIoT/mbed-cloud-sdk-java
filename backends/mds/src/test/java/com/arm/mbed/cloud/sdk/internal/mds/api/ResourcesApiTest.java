package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ResourcesApi
 */
public class ResourcesApiTest {

    private ResourcesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ResourcesApi.class);
    }

    /**
     * Delete a resource
     *
     * A request to delete a resource must be handled by both Mbed Cloud Client and Mbed Cloud Connect. The resource is not deleted from Mbed Cloud Connect until the request is handled by Mbed Cloud Client.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**      curl -X DELETE \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\       -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void v2EndpointsDeviceIdResourcePathDeleteTest() {
        String deviceId = null;
        String resourcePath = null;
        Boolean noResp = null;
        // AsyncID response = api.v2EndpointsDeviceIdResourcePathDelete(deviceId, resourcePath, noResp);

        // TODO: test validations
    }
    /**
     * Read from a resource
     *
     * Requests the resource value and when the response is available, an &#x60;AsyncIDResponse&#x60; json object is received in the notification channel. The preferred way to get resource values is to use [subscribe](/docs/v1.2/service-api-references/connect-api.html#v2-notification-callback) and [callback](/docs/v1.2/service-api-references/connect-api.html#v2-notification-callback) methods. See more about [reading from a resource](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-read-operation).  All resource APIs are asynchronous. These APIs only respond if the device is turned on and connected to Mbed Cloud Connect.  Please refer to [Lightweigth Machine to Machine Technical specification](http://www.openmobilealliance.org/release/LightweightM2M/V1_0-20170208-A/OMA-TS-LightweightM2M-V1_0-20170208-A.pdf) for more inforamtion.  **Example usage:**      curl -X GET \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\       -H &#39;authorization: Bearer {api-key}&#39;        
     */
    @Test
    public void v2EndpointsDeviceIdResourcePathGetTest() {
        String deviceId = null;
        String resourcePath = null;
        Boolean cacheOnly = null;
        Boolean noResp = null;
        // Void response = api.v2EndpointsDeviceIdResourcePathGet(deviceId, resourcePath, cacheOnly, noResp);

        // TODO: test validations
    }
    /**
     * Execute a function on a Resource or create new Object instance
     *
     * With this API, you can [execute a function](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-execute-operation)  on an existing resource and create new Object instance to the device. The resource-path does not have to exist - it can be  created by the call. The maximum length of resource-path is 255 characters.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**  This example resets the min and max values of the [temperature sensor](http://www.openmobilealliance.org/tech/profiles/lwm2m/3303.xml) instance 0 by executing the Resource 5605 &#39;Reset Min and Max Measured Values&#39;.          curl -X POST \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3303/0/5605 \\       -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void v2EndpointsDeviceIdResourcePathPostTest() {
        String deviceId = null;
        String resourcePath = null;
        String resourceFunction = null;
        Boolean noResp = null;
        // AsyncID response = api.v2EndpointsDeviceIdResourcePathPost(deviceId, resourcePath, resourceFunction, noResp);

        // TODO: test validations
    }
    /**
     * Write to a resource or use write-attributes for a resource
     *
     * With this API, you can [write a new value to existing resources](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-write-operation) or [use the write-attributes](/docs/v1.2/collecting/subscribing-to-resource-changes-from-a-web-application.html#notification-rules) for a resource.  This API can also be used to transfer files to the device. Mbed Cloud Connect LwM2M server implements the Option 1 from RFC7959. The maximum block size is 1024 bytes. The block size versus transferred file size is something to note in low quality networks. The customer application needs to know what type of file is transferred (for example txt) and the payload can be encrypted by the customer. The maximum size of payload is 1048576 bytes.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**  This example sets the alarm on a buzzer. The command writes the [Buzzer](http://www.openmobilealliance.org/tech/profiles/lwm2m/3338.xml) instance 0, \&quot;On/Off\&quot; boolean resource to &#39;1&#39;.      curl -X PUT \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3338/0/5850 -H \&quot;content-type: text/plain\&quot; \\       -H &#39;authorization: Bearer {api-key}&#39; -d &#39;1&#39; 
     */
    @Test
    public void v2EndpointsDeviceIdResourcePathPutTest() {
        String deviceId = null;
        String resourcePath = null;
        String resourceValue = null;
        Boolean noResp = null;
        // AsyncID response = api.v2EndpointsDeviceIdResourcePathPut(deviceId, resourcePath, resourceValue, noResp);

        // TODO: test validations
    }
}
