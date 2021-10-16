package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccessKey;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccessKeyList;

public interface TenantAccountsAccessKeysApi {
    /**
     * Get access key. Retrieve details of an access key. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/access-keys/{access_key_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            The ID of the account to retrieve. (required)
     * @param accessKeyId
     *            The ID of the access key to retrieve. (required)
     * @return Call&lt;AccessKey&gt;
     */
    @GET("v3/accounts/{account_id}/access-keys/{access_key_id}")
    Call<AccessKey>
        getAccountAccessKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                            @retrofit2.http.Path(value = "access_key_id", encoded = true) String accessKeyId);

    /**
     * Get all access keys. Retrieve an array of access keys. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/access-keys \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            The ID of the account to retrieve. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to retrieve after the given one. (optional)
     * @param order
     *            Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. (optional, default to ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @param statusEq
     *            Status filter. (optional)
     * @param applicationIdEq
     *            Application filter. (optional)
     * @return Call&lt;AccessKeyList&gt;
     */
    @GET("v3/accounts/{account_id}/access-keys")
    Call<AccessKeyList>
        getAllAccountAccessKeys(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                @retrofit2.http.Query("limit") Integer limit,
                                @retrofit2.http.Query("after") String after,
                                @retrofit2.http.Query("order") String order,
                                @retrofit2.http.Query("include") String include,
                                @retrofit2.http.Query("status__eq") String statusEq,
                                @retrofit2.http.Query("application_id__eq") String applicationIdEq);

}
