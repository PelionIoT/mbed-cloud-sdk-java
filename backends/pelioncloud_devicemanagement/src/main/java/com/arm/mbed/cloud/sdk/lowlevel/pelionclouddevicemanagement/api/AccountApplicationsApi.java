package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccessKey;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccessKeyList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Application;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApplicationList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupIdList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummaryList;

public interface AccountApplicationsApi {
    /**
     * Add application to a list of groups. Add application to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups/add \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application to add to the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/applications/{application_id}/groups/add")
    Call<Void>
        addApplicationToGroups(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                               @retrofit2.http.Body GroupIdList body);

    /**
     * Create a new application. Create a new application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/applications
     * -d &#39;{\&quot;name\&quot;: \&quot;MyApplication1\&quot;}&#39; \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;
     * 
     * @param body
     *            The details of the application to create. (required)
     * @return Call&lt;Application&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/applications")
    Call<Application> createApplication(@retrofit2.http.Body Application body);

    /**
     * Create a new applicationaccess key. Create a new access key for the application. &lt;b&gt;Note:&lt;/b&gt; This
     * endpoint is restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys -d &#39;{\&quot;name\&quot;:
     * \&quot;MyKey1\&quot;}&#39; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type:
     * application/json&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application. (required)
     * @param body
     *            The details of the access key to create. (required)
     * @return Call&lt;AccessKey&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/applications/{application_id}/access-keys")
    Call<AccessKey>
        createApplicationAccessKey(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                                   @retrofit2.http.Body AccessKey body);

    /**
     * Delete application. Delete the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/applications/{application_id}")
    Call<Void> deleteApplication(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId);

    /**
     * Delete access key associated with the application. Delete the access key associated with the application.
     * &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application. (required)
     * @param accessKeyId
     *            The ID of the access key to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/applications/{application_id}/access-keys/{access_key_id}")
    Call<Void>
        deleteApplicationAccessKey(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                                   @retrofit2.http.Path(value = "access_key_id", encoded = true) String accessKeyId);

    /**
     * Get all access keys associated with the application. Retrieve an array of access keys associated with the
     * application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application. (required)
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
     * @return Call&lt;AccessKeyList&gt;
     */
    @GET("v3/applications/{application_id}/access-keys")
    Call<AccessKeyList>
        getAllApplicationAccessKeys(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                                    @retrofit2.http.Query("limit") Integer limit,
                                    @retrofit2.http.Query("after") String after,
                                    @retrofit2.http.Query("order") String order,
                                    @retrofit2.http.Query("include") String include,
                                    @retrofit2.http.Query("status__eq") String statusEq);

    /**
     * Get all applications. Retrieve an array of applications. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
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
     * @return Call&lt;ApplicationList&gt;
     */
    @GET("v3/applications")
    Call<ApplicationList>
        getAllApplications(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                           @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                           @retrofit2.http.Query("status__eq") String statusEq);

    /**
     * Get application. Retrieve details of an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application to retrieve. (required)
     * @return Call&lt;Application&gt;
     */
    @GET("v3/applications/{application_id}")
    Call<Application>
        getApplication(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId);

    /**
     * Get access key. Retrieve details of an access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This
     * endpoint is restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application. (required)
     * @param accessKeyId
     *            The ID of the access key to retrieve. (required)
     * @return Call&lt;AccessKey&gt;
     */
    @GET("v3/applications/{application_id}/access-keys/{access_key_id}")
    Call<AccessKey>
        getApplicationAccessKey(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                                @retrofit2.http.Path(value = "access_key_id", encoded = true) String accessKeyId);

    /**
     * Get policy groups of an application. Retrieve an array of policy groups associated with an application.
     * &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X
     * GET https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application. (required)
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
    @GET("v3/applications/{application_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfApplication(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                               @retrofit2.http.Query("limit") Integer limit,
                               @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order,
                               @retrofit2.http.Query("include") String include);

    /**
     * Remove application from groups. Remove application from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups/remove \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application to remove from the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/applications/{application_id}/groups/remove")
    Call<Void>
        removeApplicationFromGroups(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                                    @retrofit2.http.Body GroupIdList body);

    /**
     * Update applicationdetails. Update application details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApplication25\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application to update. (required)
     * @param body
     *            New applicationattributes to store. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @PUT("v3/applications/{application_id}")
    Call<ApiKeyInfoResp>
        updateApplication(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                          @retrofit2.http.Body Application body);

    /**
     * Update access key details. Update access key details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;name\&quot;: \&quot;TestAccessKey\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param applicationId
     *            The ID of the application. (required)
     * @param accessKeyId
     *            The ID of the access key to update. (required)
     * @param body
     *            New access key attributes to store. (required)
     * @return Call&lt;AccessKey&gt;
     */
    @PUT("v3/applications/{application_id}/access-keys/{access_key_id}")
    Call<AccessKey>
        updateApplicationAccessKey(@retrofit2.http.Path(value = "application_id", encoded = true) String applicationId,
                                   @retrofit2.http.Path(value = "access_key_id", encoded = true) String accessKeyId,
                                   @retrofit2.http.Body AccessKey body);

}
