package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.SubjectList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateReq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountAdminApi {
  /**
   * Add API key to a list of groups.
   * An endpoint for adding API key to groups.
   * @param apiKey The ID of the API key to be added to the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/api-keys/{apiKey}/groups")
  Call<UpdatedResponse> addApiKeyToGroups(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Body List<String> body
  );

  /**
   * Upload a new trusted certificate.
   * An endpoint for uploading new trusted certificates.
   * @param body A trusted certificate object with attributes. (required)
   * @return Call&lt;TrustedCertificateResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/trusted-certificates")
  Call<TrustedCertificateResp> addCertificate(
    @retrofit2.http.Body TrustedCertificateReq body
  );

  /**
   * Add members to a group.
   * An endpoint for adding users and API keys to groups.
   * @param groupID The ID of the group to be updated. (required)
   * @param body A list of users and API keys to be added to the group. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/policy-groups/{groupID}")
  Call<UpdatedResponse> addSubjectsToGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body SubjectList body
  );

  /**
   * Add user to a list of groups.
   * An endpoint for adding user to groups.
   * @param userId The ID of the user to be added to the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/users/{user-id}/groups")
  Call<UpdatedResponse> addUserToGroups(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body List<String> body
  );

  /**
   * Create a new group.
   * An endpoint for creating a new group.
   * @param body Details of the group to be created. (required)
   * @return Call&lt;GroupSummary&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/policy-groups")
  Call<GroupSummary> createGroup(
    @retrofit2.http.Body GroupCreationInfo body
  );

  /**
   * Create a new user.
   * An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.
   * @param body A user object with attributes. (required)
   * @param action Action, either &#39;create&#39; or &#39;invite&#39;. (optional, default to create)
   * @return Call&lt;UserInfoResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/users")
  Call<UserInfoResp> createUser(
    @retrofit2.http.Body UserInfoReq body, @retrofit2.http.Query("action") String action
  );

  /**
   * Delete a group.
   * An endpoint for deleting a group.
   * @param groupID The ID of the group to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/policy-groups/{groupID}")
  Call<Void> deleteGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID
  );

  /**
   * Delete a user.
   * An endpoint for deleting a user.
   * @param userId The ID of the user to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/users/{user-id}")
  Call<Void> deleteUser(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId
  );

  /**
   * Get the details of all users.
   * An endpoint for retrieving the details of all users.
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param emailEq Filter for email address (optional)
   * @param statusEq Filter for status, for example active or reset (optional)
   * @return Call&lt;UserInfoRespList&gt;
   */
  @GET("v3/users")
  Call<UserInfoRespList> getAllUsers(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("email__eq") String emailEq, @retrofit2.http.Query("status__eq") String statusEq
  );

  /**
   * Get groups of the API key.
   * An endpoint for retrieving groups of the API key.
   * @param apiKey The ID of the API key whose details are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;GroupSummaryList&gt;
   */
  @GET("v3/api-keys/{apiKey}/groups")
  Call<GroupSummaryList> getGroupsOfApikey(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Get groups of the user.
   * An endpoint for retrieving groups of the user.
   * @param userId The ID of the user whose details are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;GroupSummaryList&gt;
   */
  @GET("v3/users/{user-id}/groups")
  Call<GroupSummaryList> getGroupsOfUser(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Details of a user.
   * An endpoint for retrieving the details of a user.
   * @param userId The ID of the user whose details are retrieved. (required)
   * @param properties Request to return account specific user property values according to the given property name. (optional)
   * @return Call&lt;UserInfoResp&gt;
   */
  @GET("v3/users/{user-id}")
  Call<UserInfoResp> getUser(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Query("properties") String properties
  );

  /**
   * Get users of a group.
   * An endpoint for listing the users of a group with details.
   * @param groupID The ID of the group whose users are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;UserInfoRespList&gt;
   */
  @GET("v3/policy-groups/{groupID}/users")
  Call<UserInfoRespList> getUsersOfGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Remove API key from groups.
   * An endpoint for removing API key from groups.
   * @param apiKey The ID of the API key to be removed from the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/api-keys/{apiKey}/groups")
  Call<UpdatedResponse> removeApiKeyFromGroups(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Body List<String> body
  );

  /**
   * Remove user from groups.
   * An endpoint for removing user from groups.
   * @param userId The ID of the user to be removed from the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/users/{user-id}/groups")
  Call<UpdatedResponse> removeUserFromGroups(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body List<String> body
  );

  /**
   * Remove users from a group.
   * An endpoint for removing users from groups.
   * @param groupID The ID of the group whose users are removed. (required)
   * @param body A list of users to be removed from the group. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/policy-groups/{groupID}/users")
  Call<UpdatedResponse> removeUsersFromGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body SubjectList body
  );

  /**
   * Update the group name.
   * An endpoint for updating a group name.
   * @param groupID The ID of the group to be updated. (required)
   * @param body Details of the group to be created. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/policy-groups/{groupID}")
  Call<UpdatedResponse> updateGroupName(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body GroupUpdateInfo body
  );

  /**
   * Updates attributes of the account.
   * An endpoint for updating the account.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/me -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param body Details of the account to be updated. (required)
   * @return Call&lt;AccountInfo&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/accounts/me")
  Call<AccountInfo> updateMyAccount(
    @retrofit2.http.Body AccountUpdateReq body
  );

  /**
   * Update user details.
   * An endpoint for updating user details.
   * @param userId The ID of the user whose details are updated. (required)
   * @param body A user object with attributes. (required)
   * @return Call&lt;UserInfoResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/users/{user-id}")
  Call<UserInfoResp> updateUser(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body UserUpdateReq body
  );

}
