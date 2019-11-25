package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummary;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SubjectList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoRespList;

public interface AccountPolicyGroupsApi {
    /**
     * Add API keys to the group. Add API keys to the group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param body
     *            A list of API keys to add to the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @POST("v3/policy-groups/{group_id}/api-keys")
    Call<GroupSummary> addApiKeysToGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                         @retrofit2.http.Body SubjectList body);

    /**
     * Add API Keys to the group. Add API keys to the group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param body
     *            A list of API keys to add to the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @POST("v3/policy-groups/{group_id}/api-keys/add")
    Call<GroupSummary> addListedApiKeysToGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                               @retrofit2.http.Body SubjectList body);

    /**
     * Add users to the group. Add users to the group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users/add \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param body
     *            A list of API keys to add to the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @POST("v3/policy-groups/{group_id}/users/add")
    Call<GroupSummary> addListedUsersToGroup_(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                              @retrofit2.http.Body SubjectList body);

    /**
     * Add members to a group. Add users and API keys to a group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group to update. (required)
     * @param body
     *            A list of users and API keys to add to the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/policy-groups/{group_id}")
    Call<GroupSummary> addSubjectsToGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                          @retrofit2.http.Body SubjectList body);

    /**
     * Add users to the group. Add users to the group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param body
     *            A list of API keys to add to the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @POST("v3/policy-groups/{group_id}/users")
    Call<GroupSummary> addUsersToGroup_(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                        @retrofit2.http.Body SubjectList body);

    /**
     * Create a new group. Create a new group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            Details of the group to create. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/policy-groups")
    Call<GroupSummary> createGroup(@retrofit2.http.Body GroupCreationInfo body);

    /**
     * Delete a group. Delete a group. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/policy-groups/{group_id}")
    Call<Void> deleteGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId);

    /**
     * Get all group information. Retrieve all group information. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @param nameEq
     *            Filter for group name. (optional)
     * @return Call&lt;GroupSummaryList&gt;
     */
    @GET("v3/policy-groups")
    Call<GroupSummaryList>
        getAllGroups(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                     @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                     @retrofit2.http.Query("name__eq") String nameEq);

    /**
     * Get the API keys of a group. Manage policy groups. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @return Call&lt;ApiKeyInfoRespList&gt;
     */
    @GET("v3/policy-groups/{group_id}/api-keys")
    Call<ApiKeyInfoRespList>
        getApiKeysOfGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                          @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                          @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include);

    /**
     * Get group information. Retrieve general information about a group. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group to retrieve. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @GET("v3/policy-groups/{group_id}")
    Call<GroupSummary> getGroupSummary(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId);

    /**
     * Get users of a group. Retrieve users of a group with details. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @param statusEq
     *            An optional filter to retrieve users by status. (optional)
     * @param statusIn
     *            An optional filter to retrieve users with a specified set of statuses. (optional)
     * @param statusNin
     *            An optional filter to exclude users with a specified set of statuses. (optional)
     * @return Call&lt;UserInfoRespList&gt;
     */
    @GET("v3/policy-groups/{group_id}/users")
    Call<UserInfoRespList>
        getUsersOfGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                        @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                        @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                        @retrofit2.http.Query("status__eq") String statusEq,
                        @retrofit2.http.Query("status__in") String statusIn,
                        @retrofit2.http.Query("status__nin") String statusNin);

    /**
     * Remove API keys from a group. Remove API keys from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param body
     *            A list of API keys to remove from the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/policy-groups/{group_id}/api-keys")
    Call<GroupSummary> removeApiKeysFromGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                              @retrofit2.http.Body SubjectList body);

    /**
     * Remove API keys from a group. Remove API keys from groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys/remove \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param body
     *            A list of API keys to remove from the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/policy-groups/{group_id}/api-keys/remove")
    Call<GroupSummary>
        removeListedApiKeysFromGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                     @retrofit2.http.Body SubjectList body);

    /**
     * Remove users from a group. Manage policy groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users/remove \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param body
     *            A list of users to remove from the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/policy-groups/{group_id}/users/remove")
    Call<GroupSummary>
        removeListedUsersFromGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                   @retrofit2.http.Body SubjectList body);

    /**
     * Remove users from a group. Manage policy groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group. (required)
     * @param body
     *            A list of users to remove from the group. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/policy-groups/{group_id}/users")
    Call<GroupSummary> removeUsersFromGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                            @retrofit2.http.Body SubjectList body);

    /**
     * Update the group name. Update a group name. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;TestGroup2\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param groupId
     *            The ID of the group to update. (required)
     * @param body
     *            Details of the group to create. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/policy-groups/{group_id}")
    Call<GroupSummary> updateGroupName(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                       @retrofit2.http.Body GroupUpdateInfo body);

}
