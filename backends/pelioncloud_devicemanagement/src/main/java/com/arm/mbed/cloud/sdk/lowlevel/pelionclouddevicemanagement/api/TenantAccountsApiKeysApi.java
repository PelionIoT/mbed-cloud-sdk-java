package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupIdList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummaryList;

import java.util.List;

public interface TenantAccountsApiKeysApi {
    /**
     * Add API key to a list of groups. Add API key to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to add to the group. (required)
     * @param body
     *            A list of IDs of groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/api-keys/{apikey_id}/groups")
    Call<ApiKeyInfoResp>
        addAccountApiKeyToGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                 @retrofit2.http.Body List<String> body);

    /**
     * Add API key to a list of groups. Add an API key to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted
     * to administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups/add \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            The ID of the Account. (required)
     * @param apikeyId
     *            The ID of the API key to add to the group. (required)
     * @param body
     *            A list of IDs of groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/api-keys/{apikey_id}/groups/add")
    Call<ApiKeyInfoResp>
        addAccountApiKeyToListedGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                       @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                       @retrofit2.http.Body GroupIdList body);

    /**
     * Create a new API key. Create a new API key. There is no default value for the owner ID, and it must be from the
     * same account where the new API key is created. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;MyKey1\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            Details of the API key to create. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/api-keys")
    Call<ApiKeyInfoResp>
        createAccountApiKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                            @retrofit2.http.Body ApiKeyInfoReq body);

    /**
     * Delete the API key. Delete an API key. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/api-keys/{apikey_id}")
    Call<Void> deleteAccountApiKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                   @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Get API key details. Retrieve details of an API key. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to retrieve. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @GET("v3/accounts/{account_id}/api-keys/{apikey_id}")
    Call<ApiKeyInfoResp> getAccountApiKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                          @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Get all API keys. Retrieve an array of API keys, optionally filtered by the owner. &lt;b&gt;Note:&lt;/b&gt; This
     * endpoint is restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to retrieve after the given one. (optional)
     * @param order
     *            Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. (optional, default to ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @param keyEq
     *            API key filter. Do not include the private portion of the API key (the last 32 characters). (optional)
     * @param ownerEq
     *            Owner name filter. (optional)
     * @return Call&lt;ApiKeyInfoRespList&gt;
     */
    @GET("v3/accounts/{account_id}/api-keys")
    Call<ApiKeyInfoRespList>
        getAllAccountApiKeys(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                             @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                             @retrofit2.http.Query("order") String order,
                             @retrofit2.http.Query("include") String include,
                             @retrofit2.http.Query("key__eq") String keyEq,
                             @retrofit2.http.Query("owner__eq") String ownerEq);

    /**
     * Get policy groups of an API key. Retrieve an array of policy groups associated with an API key.
     * &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X
     * GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to retrieve after the given one. (optional)
     * @param order
     *            Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. (optional, default to ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @return Call&lt;GroupSummaryList&gt;
     */
    @GET("v3/accounts/{account_id}/api-keys/{apikey_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfAccountApikey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                 @retrofit2.http.Query("limit") Integer limit,
                                 @retrofit2.http.Query("after") String after,
                                 @retrofit2.http.Query("order") String order,
                                 @retrofit2.http.Query("include") String include);

    /**
     * Remove API key from groups. Remove API key from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to remove from the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/accounts/{account_id}/api-keys/{apikey_id}/groups")
    Call<ApiKeyInfoResp>
        removeAccountApiKeyFromGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                      @retrofit2.http.Body List<String> body);

    /**
     * Remove API key from groups. Remove an API key from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted
     * to administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups/remove \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            The ID of the account. (required)
     * @param apikeyId
     *            The ID of the API key to remove from the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/api-keys/{apikey_id}/groups/remove")
    Call<ApiKeyInfoResp>
        removeAccountApiKeyFromListedGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                            @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                            @retrofit2.http.Body GroupIdList body);

    /**
     * Reset the secret key. Reset the secret key of the API key. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted
     * to administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to reset. (required)
     * @param body
     *            New API key attributes to be stored. (optional)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @POST("v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret")
    Call<ApiKeyInfoResp>
        resetAccountApiKeySecret(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                 @retrofit2.http.Body ApiKeyUpdateReq body);

    /**
     * Update API key details. Update API key details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApiKey25\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to update. (required)
     * @param body
     *            New API key attributes to be stored. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @PUT("v3/accounts/{account_id}/api-keys/{apikey_id}")
    Call<ApiKeyInfoResp>
        updateAccountApiKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                            @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                            @retrofit2.http.Body ApiKeyUpdateReq body);

}
