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

public interface AccountApiKeysApi {
    /**
     * Add API key to a list of groups. Add API key to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to add to the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys/{apikey_id}/groups")
    Call<ApiKeyInfoResp> addApiKeyToGroups(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                           @retrofit2.http.Body List<String> body);

    /**
     * Add API key to a list of groups. Add API key to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups/add \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to add to the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys/{apikey_id}/groups/add")
    Call<ApiKeyInfoResp>
        addApiKeyToListedGroups(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                @retrofit2.http.Body GroupIdList body);

    /**
     * Add API key to a list of groups. Add API key to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys/me/groups")
    Call<ApiKeyInfoResp> addMyApiKeyToGroups(@retrofit2.http.Body List<String> body);

    /**
     * Add API key to a list of groups. Add API key to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups/add/ \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys/me/groups/add")
    Call<ApiKeyInfoResp> addMyApiKeyToListedGroups(@retrofit2.http.Body GroupIdList body);

    /**
     * Create a new API key. Create a new API key. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            The details of the API key to create. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys")
    Call<ApiKeyInfoResp> createApiKey(@retrofit2.http.Body ApiKeyInfoReq body);

    /**
     * Delete API key. Delete the API key. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/api-keys/{apikey_id}")
    Call<Void> deleteApiKey(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Get all API keys. Retrieve an array of API keys, optionally filtered by the owner. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
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
     *            Owner name filter. &lt;b&gt;Note:&lt;/b&gt; This parameter is restricted to administrators. (optional)
     * @return Call&lt;ApiKeyInfoRespList&gt;
     */
    @GET("v3/api-keys")
    Call<ApiKeyInfoRespList>
        getAllApiKeys(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                      @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                      @retrofit2.http.Query("key__eq") String keyEq, @retrofit2.http.Query("owner__eq") String ownerEq);

    /**
     * Get API key. Retrieve details of an API key. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to retrieve. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @GET("v3/api-keys/{apikey_id}")
    Call<ApiKeyInfoResp> getApiKey(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Get policy groups of an API key. Retrieve an array of policy groups associated with an API key.
     * &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X
     * GET https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
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
    @GET("v3/api-keys/{apikey_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfApikey(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                          @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                          @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include);

    /**
     * Get policy groups of the current API key. Retrieve an array of policy groups associated with the current API key.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
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
    @GET("v3/api-keys/me/groups")
    Call<GroupSummaryList> getGroupsOfMyApiKey(@retrofit2.http.Query("limit") Integer limit,
                                               @retrofit2.http.Query("after") String after,
                                               @retrofit2.http.Query("order") String order,
                                               @retrofit2.http.Query("include") String include);

    /**
     * Get current API key. Retrieve details of current API key. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @GET("v3/api-keys/me")
    Call<ApiKeyInfoResp> getMyApiKey();

    /**
     * Remove API key from groups. Remove API key from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to remove from the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/api-keys/{apikey_id}/groups")
    Call<ApiKeyInfoResp>
        removeApiKeyFromGroups(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                               @retrofit2.http.Body List<String> body);

    /**
     * Remove API key from groups. Remove API key from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups/remove \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to remove from the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys/{apikey_id}/groups/remove")
    Call<ApiKeyInfoResp>
        removeApiKeyFromListedGroups(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                     @retrofit2.http.Body GroupIdList body);

    /**
     * Remove API key from groups. Remove API key from groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups/remove \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            A list of IDs of groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys/me/groups/remove")
    Call<ApiKeyInfoResp> removeMyApiKeyFromListedGroups(@retrofit2.http.Body GroupIdList body);

    /**
     * Remove API key from groups. Remove API key from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            A list of IDs of groups to update. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/api-keys/me/groups")
    Call<ApiKeyInfoResp> removeMyApiKeyListedGroups(@retrofit2.http.Body GroupIdList body);

    /**
     * Reset the secret key. Reset the secret key of the API key. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/reset-secret \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to reset. (required)
     * @param body
     *            New API key attributes to be stored. (optional)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @POST("v3/api-keys/{apikey_id}/reset-secret")
    Call<ApiKeyInfoResp> resetSecret(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                     @retrofit2.http.Body ApiKeyUpdateReq body);

    /**
     * Update API key details. Update API key details. **Example:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApiKey25\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to update. (required)
     * @param body
     *            New API key attributes to store. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @PUT("v3/api-keys/{apikey_id}")
    Call<ApiKeyInfoResp> updateApiKey(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                      @retrofit2.http.Body ApiKeyUpdateReq body);

    /**
     * Update API key details. Update API key details. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            New API key attributes to store. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @PUT("v3/api-keys/me")
    Call<ApiKeyInfoResp> updateMyApiKey(@retrofit2.http.Body ApiKeyUpdateReq body);

}
