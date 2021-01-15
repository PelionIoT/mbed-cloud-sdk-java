package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Block;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Block1;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceDirectoryLifecycleApi
 */
public class DeviceDirectoryLifecycleApiTest {

    private DeviceDirectoryLifecycleApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceDirectoryLifecycleApi.class);
    }

    /**
     * List all device block categories
     *
     * List all device block categories. A block category is a short description of why a device was suspended or
     * returned to service. **Example:** Get all defined device suspension categories: &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/device-block-categories \\ -H &#39;Authorization: Bearer &lt;API
     * key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void blockCategoriesListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String referenceEq = null;
        String referenceNeq = null;
        String referenceIn = null;
        String referenceNin = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // DeviceBlockCategoryPage response = api.blockCategoriesList(limit, order, after, include, referenceEq,
        // referenceNeq, referenceIn, referenceNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Get a device block category.
     *
     * Retrieve a device block category. A block category is a short description of why a device was suspended or
     * returned to service.
     */
    @Test
    public void blockCategoriesRetrieveTest() {
        String blockCategoryReference = null;
        // DeviceBlockCategory response = api.blockCategoriesRetrieve(blockCategoryReference);

        // TODO: test validations
    }

    /**
     * Return a device to service.
     *
     * [Returning a device to
     * service](https://developer.pelion.com/docs/device-management/current/device-management/managing-devices-in-your-account.html#using-the-api-suspending-and-resuming-devices)
     * allows the device to connect to Device Management again. The connection is established according to the
     * device&#39;s reconnection logic. The device reports a [registration
     * event](https://developer.pelion.com/docs/device-management-api/connect/) through a [notification
     * channel](https://developer.pelion.com/docs/device-management/current/integrate-web-app/event-notification.html).
     * The default reconnection logic is a progressive back-off for 2, 4, 8, or 16 seconds, up to one week. All API
     * functionality is restored. **Example:** The following example enables a device to reconnect to Pelion Device
     * Management. The category must match the reason device was suspended. This device was reported stolen, but was
     * found: &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_id&gt;/resume \\
     * -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{
     * \&quot;category\&quot;: \&quot;lost_or_stolen\&quot;, \&quot;description\&quot;: \&quot;Was found, was not stolen
     * but miss placed\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deviceResumeTest() {
        String id = null;
        Block block = null;
        // Void response = api.deviceResume(id, block);

        // TODO: test validations
    }

    /**
     * Suspend a device.
     *
     * [Suspending a
     * device](https://developer.pelion.com/docs/device-management/current/device-management/managing-devices-in-your-account.html#suspending-and-resuming-devices)
     * prevents it from connecting to Device Management. If a device is currently connected, it disconnects and shows as
     * deregistered. You can also receive [deregistration
     * events](https://developer.pelion.com/docs/device-management-api/connect/) in [notification
     * channels](https://developer.pelion.com/docs/device-management/current/integrate-web-app/event-notification.html).
     * API operations needing device transactions fail while a device is suspended. Example use case to use suspending
     * is that device is reported lost or stolen. You can block the device to connect and this way prevent device to
     * cause unreliable data to your system. ***Example:* The following example suspends a device with category
     * \&quot;Lost or stolen\&quot;. You can see available categories with &#39;/v3/device-block-categories/&#39;.
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_id&gt;/suspend \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{
     * \&quot;category\&quot;: \&quot;lost_or_stolen\&quot;, \&quot;description\&quot;: \&quot;EXAMPLE: Customer
     * contacted via phone and reported device being stolen. Specific time of the theft was not know. Device last used
     * in May/2019\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deviceSuspendTest() {
        String id = null;
        Block1 block = null;
        // Void response = api.deviceSuspend(id, block);

        // TODO: test validations
    }
}
