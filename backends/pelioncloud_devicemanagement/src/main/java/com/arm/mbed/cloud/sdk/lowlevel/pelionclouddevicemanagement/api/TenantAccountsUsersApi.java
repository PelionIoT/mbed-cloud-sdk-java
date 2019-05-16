package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;

import java.util.List;

public interface TenantAccountsUsersApi {
    /**
     * Add user to a list of groups. Add user to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to add to the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/users/{user_id}/groups")
    Call<UpdatedResponse>
        addAccountUserToGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                               @retrofit2.http.Body List<String> body);

    /**
     * Create a new user. Create or invite a new user to the account. Only email address is used; other attributes are
     * set in the second step. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            A user object with attributes. (required)
     * @param action
     *            Create or invite user. (optional, default to create)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/users")
    Call<UserInfoResp> createAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                         @retrofit2.http.Body UserInfoReq body,
                                         @retrofit2.http.Query("action") String action);

    /**
     * Delete a user. Delete a user. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/users/{user_id}")
    Call<Void> deleteAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Details of the user. Retrieve user details. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to retrieve. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @GET("v3/accounts/{account_id}/users/{user_id}")
    Call<UserInfoResp> getAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Get the details of all users. Retrieve details of all users. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @param emailEq
     *            Filter for email address. (optional)
     * @param statusEq
     *            Filter for status. (optional)
     * @param statusIn
     *            An optional filter to retrieve users with a specified set of statuses. (optional)
     * @param statusNin
     *            An optional filter to exclude users with a specified set of statuses. (optional)
     * @param loginProfilesEq
     *            An optional filter to retrieve users with a specified login profile. (optional)
     * @return Call&lt;UserInfoRespList&gt;
     */
    @GET("v3/accounts/{account_id}/users")
    Call<UserInfoRespList>
        getAllAccountUsers(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                           @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                           @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                           @retrofit2.http.Query("email__eq") String emailEq,
                           @retrofit2.http.Query("status__eq") String statusEq,
                           @retrofit2.http.Query("status__in") String statusIn,
                           @retrofit2.http.Query("status__nin") String statusNin,
                           @retrofit2.http.Query("login_profiles__eq") String loginProfilesEq);

    /**
     * Get user&#39;s groups. Retrieve user&#39;s groups. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @return Call&lt;GroupSummaryList&gt;
     */
    @GET("v3/accounts/{account_id}/users/{user_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                               @retrofit2.http.Query("limit") Integer limit,
                               @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order,
                               @retrofit2.http.Query("include") String include);

    /**
     * Remove user from groups. Remove user from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to remove from the group. (required)
     * @param body
     *            A list of IDs of the groups to update. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/accounts/{account_id}/users/{user_id}/groups")
    Call<UpdatedResponse>
        removeAccountUserFromGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                    @retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                    @retrofit2.http.Body List<String> body);

    /**
     * Update user details. Update user details. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;username\&quot;:
     * \&quot;myusername\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to update. (required)
     * @param body
     *            A user object with attributes. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/users/{user_id}")
    Call<UserInfoResp> updateAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                         @retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                         @retrofit2.http.Body UserUpdateReq body);

    /**
     * Validate the user email. Validate user email. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/validate-email \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/accounts/{account_id}/users/{user_id}/validate-email")
    Call<Void> validateAccountUserEmail(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                        @retrofit2.http.Path(value = "user_id", encoded = true) String userId);

}
