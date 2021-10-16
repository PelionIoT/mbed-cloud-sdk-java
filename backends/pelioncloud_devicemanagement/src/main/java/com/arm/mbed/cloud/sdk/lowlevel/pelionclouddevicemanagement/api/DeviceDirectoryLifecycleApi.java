package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Block;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Block1;
import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceBlockCategory;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceBlockCategoryPage;

public interface DeviceDirectoryLifecycleApi {
    /**
     * List all device block categories List all device block categories. A block category is a short description of why
     * a device was suspended or returned to service. **Example:** Get all defined device suspension categories:
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/device-block-categories \\ -H
     * &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            This endpoint doesn&#39;t support paging. Parameter is accepted for API compatibility. Value is
     *            ignored. (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. Default: ASC. (optional)
     * @param after
     *            This endpoint doesn&#39;t support paging. Parameter is accepted for API compatibility. Value is
     *            ignored. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @param referenceEq
     *            eq filter for the \&quot;reference\&quot; field (optional)
     * @param referenceNeq
     *            neq filter for the \&quot;reference\&quot; field (optional)
     * @param referenceIn
     *            in filter for the \&quot;reference\&quot; field (optional)
     * @param referenceNin
     *            nin filter for the \&quot;reference\&quot; field (optional)
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @return Call&lt;DeviceBlockCategoryPage&gt;
     */
    @GET("v3/device-block-categories/")
    Call<DeviceBlockCategoryPage> blockCategoriesList(@retrofit2.http.Query("limit") Integer limit,
                                                      @retrofit2.http.Query("order") String order,
                                                      @retrofit2.http.Query("after") String after,
                                                      @retrofit2.http.Query("include") String include,
                                                      @retrofit2.http.Query("reference__eq") String referenceEq,
                                                      @retrofit2.http.Query("reference__neq") String referenceNeq,
                                                      @retrofit2.http.Query("reference__in") String referenceIn,
                                                      @retrofit2.http.Query("reference__nin") String referenceNin,
                                                      @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                                                      @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                                                      @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                                                      @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte);

    /**
     * Get a device block category. Retrieve a device block category. A block category is a short description of why a
     * device was suspended or returned to service.
     * 
     * @param blockCategoryReference
     *            The reference of the block category. (required)
     * @return Call&lt;DeviceBlockCategory&gt;
     */
    @GET("v3/device-block-categories/{block_category_reference}")
    Call<DeviceBlockCategory>
        blockCategoriesRetrieve(@retrofit2.http.Path(value = "block_category_reference",
                                                     encoded = true) String blockCategoryReference);

    /**
     * Return a device to service. [Returning a device to
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
     * 
     * @param id
     *            The ID of the device. (required)
     * @param block
     *            The device block. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/devices/{id}/resume")
    Call<Void> deviceResume(@retrofit2.http.Path(value = "id", encoded = true) String id,
                            @retrofit2.http.Body Block block);

    /**
     * Suspend a device. [Suspending a
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
     * 
     * @param id
     *            The [Device
     *            ID](https://developer.pelion.com/docs/device-management/current/connecting/device-identity.html)
     *            created by Device Management. (required)
     * @param block
     *            The device block. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/devices/{id}/suspend")
    Call<Void> deviceSuspend(@retrofit2.http.Path(value = "id", encoded = true) String id,
                             @retrofit2.http.Body Block1 block);

}
