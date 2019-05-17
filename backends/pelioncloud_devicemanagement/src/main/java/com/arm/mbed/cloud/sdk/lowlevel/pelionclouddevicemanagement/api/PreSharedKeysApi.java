package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ListOfPreSharedKeysWithoutSecret;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PreSharedKey;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PreSharedKeyWithoutSecret;

public interface PreSharedKeysApi {
    /**
     * Remove a PSK. Remove a PSK. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     * 
     * @param endpointName
     *            The unique endpoint identifier that this PSK applies to. [Reserved
     *            characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must
     *            be percent-encoded. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v2/device-shared-keys/{endpoint_name}")
    Call<Void> deletePreSharedKey(@retrofit2.http.Path(value = "endpoint_name", encoded = true) String endpointName);

    /**
     * Get a PSK. Check if a PSK for an endpoint exists or not. The response does not contain the secret itself.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     * 
     * @param endpointName
     *            The unique endpoint identifier that this PSK applies to. [Reserved
     *            characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must
     *            be percent-encoded. (required)
     * @return Call&lt;PreSharedKeyWithoutSecret&gt;
     */
    @GET("v2/device-shared-keys/{endpoint_name}")
    Call<PreSharedKeyWithoutSecret>
        getPreSharedKey(@retrofit2.http.Path(value = "endpoint_name", encoded = true) String endpointName);

    /**
     * List PSKs. Retrieve pre-shared keys (PSKs) with pagination. Default page size of 50 entries. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v2/device-shared-keys \\ -H
     * \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            The number of entries per page. (optional)
     * @param after
     *            An offset token for fetching a specific page. Provided by the server. (optional)
     * @return Call&lt;ListOfPreSharedKeysWithoutSecret&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @GET("v2/device-shared-keys")
    Call<ListOfPreSharedKeysWithoutSecret> listPreSharedKeys(@retrofit2.http.Query("limit") Integer limit,
                                                             @retrofit2.http.Query("after") String after);

    /**
     * Upload a PSK to Pelion Device Management. Upload a PSK for an endpoint to allow it to bootstrap. The existing key
     * cannot be overwritten, but needs to be deleted first in the case of re-setting a PSK for an endpoint. **Note**:
     * The PSK APIs are available only to accounts that have this feature enabled. **Example:** &#x60;&#x60;&#x60; curl
     * -X POST https://api.us-east-1.mbedcloud.com/v2/device-shared-keys \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; \\ -H \&quot;content-type: application/json\&quot; \\ -d &#39;{
     * \&quot;endpoint_name\&quot;: \&quot;my-endpoint-0001\&quot;, \&quot;secret_hex\&quot;:
     * \&quot;4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param body
     *            PSK to upload. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v2/device-shared-keys")
    Call<Void> uploadPreSharedKey(@retrofit2.http.Body PreSharedKey body);

}
