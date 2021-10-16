package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceDataResourcesApi
 */
public class DeviceDataResourcesApiTest {

    private DeviceDataResourcesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceDataResourcesApi.class);
    }

    /**
     * (DEPRECATED) Delete a resource path.
     *
     * (DEPRECATED) A request to delete a resource path must be handled by both Device Management Client and Device
     * Management Connect. All resource APIs are asynchronous. These APIs respond only if the device is on and connected
     * to Device Management Connect, and there is an active notification channel. **Example:** &#x60;&#x60;&#x60; curl
     * -X DELETE https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteResourcePathTest() {
        String deviceId = null;
        String resourcePath = null;
        Boolean noResp = null;
        // AsyncID response = api.deleteResourcePath(deviceId, resourcePath, noResp);

        // TODO: test validations
    }

    /**
     * (DEPRECATED) Execute a function on a Resource or create new Object instance.
     *
     * (DEPRECATED) [Execute a
     * function](https://developer.pelion.com/docs/device-management/current/resources/handle-resource-webapp.html#the-execute-operation)
     * on an existing resource and create a new Object instance on the device. The resource path does not have to exist;
     * you can set it with the call. The maximum length of the resource path is 255 characters. All resource APIs are
     * asynchronous. These APIs respond only if the device is on and connected to Device Management Connect, and there
     * is an active notification channel. Supported content types depend on the device and its resource. Device
     * Management translates HTTP to the equivalent CoAP content type. **Example:** This example resets the min and max
     * values of the [temperature sensor](http://www.openmobilealliance.org/tech/profiles/lwm2m/3303.xml) instance 0 by
     * executing Resource 5605 &#39;Reset Min and Max Measured Values&#39;. &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3303/0/5605 \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void executeOrCreateResourceTest() {
        String deviceId = null;
        String resourcePath = null;
        String resourceFunction = null;
        Boolean noResp = null;
        // AsyncID response = api.executeOrCreateResource(deviceId, resourcePath, resourceFunction, noResp);

        // TODO: test validations
    }

    /**
     * List the resources on a device.
     *
     * Retrieves information about the resource structure for a device from Device Management. This call does not reach
     * the device. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getEndpointResourcesTest() {
        String deviceId = null;
        // ResourceArray response = api.getEndpointResources(deviceId);

        // TODO: test validations
    }

    /**
     * (DEPRECATED) Read from a resource.
     *
     * (DEPRECATED) Requests the resource value either from the device or cache. If the value is not in the cache, the
     * request goes all the way to the device. When the response is available, an &#x60;AsyncIDResponse&#x60; JSON
     * object is received in the notification channel. The resource values can also be in cache based on
     * &#x60;max_age&#x60; defined by the device. The value found from the cache is returned immediately in the
     * response. The preferred way to get resource values is to use the **subscribe** and **callback** methods. All
     * resource APIs are asynchronous. These APIs only respond if the device is on and connected to Device Management.
     * See also how [resource
     * caching](https://developer.pelion.com/docs/device-management/current/connecting/device-guidelines.html#resource-cache)
     * works. Please see the [Lightweight Machine to Machine Technical
     * specification](http://www.openmobilealliance.org/release/LightweightM2M/V1_0-20170208-A/OMA-TS-LightweightM2M-V1_0-20170208-A.pdf)
     * for more information. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getResourceValueTest() {
        String deviceId = null;
        String resourcePath = null;
        Boolean cacheOnly = null;
        Boolean noResp = null;
        // Void response = api.getResourceValue(deviceId, resourcePath, cacheOnly, noResp);

        // TODO: test validations
    }

    /**
     * (DEPRECATED) Write to a Resource or use write-attributes (notification rules) for a Resource.
     *
     * (DEPRECATED) With this API, you can [write a new value to existing
     * Resources](https://developer.pelion.com/docs/device-management/current/resources/handle-resource-webapp.html) or
     * use the **write** attribute to set [notification
     * rules](https://developer.pelion.com/docs/device-management/current/resources/resource-change-webapp.html) for the
     * Resources. The notification rules only work on the device client side and may not be supported by all clients.
     * This API can also be used to transfer files to the device. Device Management Connect LwM2M server implements
     * Option 1 from RFC7959. The maximum block size is 1024 bytes. Note block size versus transferred file size in
     * low-quality networks. The customer application needs to know what type of file is transferred (for example, TXT)
     * and the customer can encrypt the payload. The maximum payload size is 1048576 bytes. All resource APIs are
     * asynchronous. These APIs respond only if the device is on and connected to Device Management Connect, and there
     * is an active notification channel. Supported content types depend on the device and its resource. Device
     * Management translates HTTP to equivalent CoAP content type. **Example:** This example sets the alarm on a buzzer.
     * The command writes the [Buzzer](http://www.openmobilealliance.org/tech/profiles/lwm2m/3338.xml) instance 0,
     * \&quot;On/Off\&quot; boolean resource to &#39;1&#39;. &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3338/0/5850 \\ -H \&quot;content-type:
     * text/plain\&quot; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -d &#39;1&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateResourceValueTest() {
        String deviceId = null;
        String resourcePath = null;
        String resourceValue = null;
        Boolean noResp = null;
        // AsyncID response = api.updateResourceValue(deviceId, resourcePath, resourceValue, noResp);

        // TODO: test validations
    }
}
