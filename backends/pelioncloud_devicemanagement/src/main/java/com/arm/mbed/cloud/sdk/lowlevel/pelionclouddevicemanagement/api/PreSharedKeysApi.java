package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ListOfPreSharedKeysWithoutSecret;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PreSharedKey;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PreSharedKeyWithoutSecret;

public interface PreSharedKeysApi {
    /**
     * Remove a pre-shared key. Remove a pre-shared key. **Example usage:** &#x60;&#x60;&#x60; curl -H
     * \&quot;authorization: Bearer ${API_TOKEN}\&quot; -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 &#x60;&#x60;&#x60;
     * 
     * @param endpointName
     *            The unique endpoint identifier that this pre-shared key applies to. [Reserved
     *            characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must
     *            be percent-encoded. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v2/device-shared-keys/{endpoint_name}")
    Call<Void> deletePreSharedKey(@retrofit2.http.Path(value = "endpoint_name", encoded = true) String endpointName);

    /**
     * Get a pre-shared key. Check if a pre-shared key for an endpoint exists or not. The response does not contain the
     * secret itself. **Example usage:** &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot;
     * https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 &#x60;&#x60;&#x60;
     * 
     * @param endpointName
     *            The unique endpoint identifier that this pre-shared key applies to. [Reserved
     *            characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must
     *            be percent-encoded. (required)
     * @return Call&lt;PreSharedKeyWithoutSecret&gt;
     */
    @GET("v2/device-shared-keys/{endpoint_name}")
    Call<PreSharedKeyWithoutSecret>
        getPreSharedKey(@retrofit2.http.Path(value = "endpoint_name", encoded = true) String endpointName);

    /**
     * List pre-shared keys. List pre-shared keys with pagination and default page size of 50 entries. **Example
     * usage:** &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot;
     * https://api.us-east-1.mbedcloud.com/v2/device-shared-keys &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            The number of entries per page (optional)
     * @param after
     *            An offset token for fetching a specific page. Provided by the server. (optional)
     * @return Call&lt;ListOfPreSharedKeysWithoutSecret&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @GET("v2/device-shared-keys")
    Call<ListOfPreSharedKeysWithoutSecret> listPreSharedKeys(@retrofit2.http.Query("limit") Integer limit,
                                                             @retrofit2.http.Query("after") String after);

    /**
     * Upload a pre-shared key to Pelion Device Management. Upload a pre-shared key (PSK) for an endpoint to allow it to
     * bootstrap. The existing key will not be overwritten but needs to be deleted first in case of re-setting PSK for
     * an endpoint. **Note**: The PSK APIs are available only to accounts that have this feature enabled. **Example
     * usage:** &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot; -H \&quot;content-type:
     * application/json\&quot; -X POST https://api.us-east-1.mbedcloud.com/v2/device-shared-keys \\ -d
     * &#39;{\&quot;endpoint_name\&quot;: \&quot;my-endpoint-0001\&quot;, \&quot;secret_hex\&quot;:
     * \&quot;4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param body
     *            Pre-shared key to be uploaded. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v2/device-shared-keys")
    Call<Void> uploadPreSharedKey(@retrofit2.http.Body PreSharedKey body);

}
