package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupIdList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;

import java.util.List;

public interface AccountUsersApi {
    /**
     * Add user to a list of groups. Add user to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user to add to the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/users/{user_id}/groups")
    Call<UserInfoResp> addUserToGroups(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                       @retrofit2.http.Body List<String> body);

    /**
     * Add user to a list of groups. Add user to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups/add \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user to add to the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/users/{user_id}/groups/add")
    Call<UserInfoResp> addUserToListedGroups(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                             @retrofit2.http.Body GroupIdList body);

    /**
     * Create a new user. Create or invite a new user to the account. The invited user has to accept the invitation by
     * clicking the link in the invitation email. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users?action&#x3D;invite \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} &#x60;&#x60;&#x60;
     * 
     * @param body
     *            A user object with attributes. (required)
     * @param action
     *            Action, either &#x60;create&#x60; or &#x60;invite&#x60;. (optional, default to create)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/users")
    Call<UserInfoResp> createUser(@retrofit2.http.Body UserInfoReq body, @retrofit2.http.Query("action") String action);

    /**
     * Delete a user. Delete a user. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/users/{user_id}")
    Call<Void> deleteUser(@retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Get users. Retrieve an array of users. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/users \\ -H
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
     * @param emailEq
     *            Filter for email address (optional)
     * @param statusEq
     *            Filter for status, for example, active or reset. (optional)
     * @param statusIn
     *            An optional filter to retrieve users with a specified set of statuses. (optional)
     * @param statusNin
     *            An optional filter to exclude users with a specified set of statuses. (optional)
     * @param loginProfilesEq
     *            An optional filter to retrieve users with a specified login profile. (optional)
     * @return Call&lt;UserInfoRespList&gt;
     */
    @GET("v3/users")
    Call<UserInfoRespList>
        getAllUsers(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                    @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                    @retrofit2.http.Query("email__eq") String emailEq,
                    @retrofit2.http.Query("status__eq") String statusEq,
                    @retrofit2.http.Query("status__in") String statusIn,
                    @retrofit2.http.Query("status__nin") String statusNin,
                    @retrofit2.http.Query("login_profiles__eq") String loginProfilesEq);

    /**
     * Get policy groups for a user. Retrieve an array of policy groups associated with a user. &lt;b&gt;Note:&lt;/b&gt;
     * This endpoint is restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user. (required)
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
    @GET("v3/users/{user_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfUser(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                        @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                        @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include);

    /**
     * Details of a user. Retrieve the details of a user. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @GET("v3/users/{user_id}")
    Call<UserInfoResp> getUser(@retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Remove user from the account. Remove user from the account. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted
     * to administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/remove \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user to remove from the account. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/users/{user_id}/remove")
    Call<Void> removeUserFromAccount(@retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Remove user from groups. Remove user from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user to remove from the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/users/{user_id}/groups")
    Call<UserInfoResp> removeUserFromGroups(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                            @retrofit2.http.Body List<String> body);

    /**
     * Remove user from groups. Remove user from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups/remove \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user to remove from the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/users/{user_id}/groups/remove")
    Call<UserInfoResp> removeUserFromListedGroups(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                                  @retrofit2.http.Body GroupIdList body);

    /**
     * Update user details. Update user details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;username\&quot;: \&quot;myusername\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param userId
     *            The ID of the user. (required)
     * @param body
     *            A user object with attributes. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/users/{user_id}")
    Call<UserInfoResp> updateUser(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                  @retrofit2.http.Body UserUpdateReq body);

}
