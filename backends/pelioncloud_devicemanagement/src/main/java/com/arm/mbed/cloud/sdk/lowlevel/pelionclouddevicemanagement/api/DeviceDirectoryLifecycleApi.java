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
     * a device was suspended or returned to service. **Example:** Get all defined categories of why device is blocked
     * from the device management &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/device-block-categories \\ -H &#39;Authorization: Bearer &lt;API
     * key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            This endpoint doesn&#39;t support paging. Parameter is accepted for API compatibility. Value is
     *            ignored (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. Default: ASC. (optional)
     * @param after
     *            This endpoint doesn&#39;t support paging. Parameter is accepted for API compatibility. Value is
     *            ignored (optional)
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
     * Return a device to service. Returning a device to service restores connectivity to the device. All API
     * functionality is restored. **Example:** Following example enables device to connect again to Pelion Device
     * Management. Note that the category must match the reason why device was suspended. This device was reported
     * stolen but was now found. &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_id&gt;/resume \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;category\&quot;:
     * \&quot;lost_or_stolen\&quot;, \&quot;description\&quot;: \&quot;Was found, was not stolen but miss
     * placed\&quot;}&#39; &#x60;&#x60;&#x60;
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
     * Suspend a device. Suspending a device prevents it from connecting to Device Management. If a device is currently
     * connected, it will be disconnected. Some API operations will fail while a device is suspended. ***Example:*
     * Following example suspends a device with category \&quot;Lost or stolen\&quot;. You can see available categories
     * with &#39;/v3/device-block-categories/&#39;. &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_id&gt;/suspend \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;category\&quot;:
     * \&quot;lost_or_stolen\&quot;, \&quot;description\&quot;: \&quot;EXAMPLE: Customer contacted via phone and
     * reported device being stolen. Specific time of the theft was not know. Device last used in May/2019\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param id
     *            The ID of the device. (required)
     * @param block
     *            The device block. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/devices/{id}/suspend")
    Call<Void> deviceSuspend(@retrofit2.http.Path(value = "id", encoded = true) String id,
                             @retrofit2.http.Body Block1 block);

}
