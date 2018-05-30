package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.iam.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.iam.model.AccountCreationReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountCreationResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfoList;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateRootReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.SubjectList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateInternalResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateInternalRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateRootReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateResp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AggregatorAccountAdminApi {
  /**
   * Add API key to a list of groups.
   * An endpoint for adding API key to groups.
   * @param accountID Account ID. (required)
   * @param apiKey The ID of the API key to be added to the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/accounts/{accountID}/api-keys/{apiKey}/groups")
  Call<UpdatedResponse> addAccountApiKeyToGroups(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Body List<String> body
  );

  /**
   * Upload new trusted certificate.
   * An endpoint for uploading new trusted certificates.
   * @param accountID Account ID. (required)
   * @param body A trusted certificate object with attributes, signature is optional. (required)
   * @return Call&lt;TrustedCertificateResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/accounts/{accountID}/trusted-certificates")
  Call<TrustedCertificateResp> addAccountCertificate(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Body TrustedCertificateRootReq body
  );

  /**
   * Add user to a list of groups.
   * An endpoint for adding user to groups.
   * @param accountID Account ID. (required)
   * @param userId The ID of the user to be added to the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/accounts/{accountID}/users/{user-id}/groups")
  Call<UpdatedResponse> addAccountUserToGroups(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body List<String> body
  );

  /**
   * Add members to a group.
   * An endpoint for adding users and API keys to groups.
   * @param accountID Account ID. (required)
   * @param groupID The ID of the group to be updated. (required)
   * @param body A list of users and API keys to be added to the group. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/accounts/{accountID}/policy-groups/{groupID}")
  Call<UpdatedResponse> addSubjectsToAccountGroup(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body SubjectList body
  );

  /**
   * Check the API key.
   * An endpoint for checking API key.
   * @param accountID Account ID. (required)
   * @param apiKey The API key to be checked. (required)
   * @return Call&lt;Void&gt;
   */
  @POST("v3/accounts/{accountID}/api-keys/{apiKey}")
  Call<Void> checkAccountApiKey(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey
  );

  /**
   * Create a new account.
   * An endpoint for creating a new account.
   * @param body Details of the account to be created. (required)
   * @param action Action, either &#39;create&#39; or &#39;enroll&#39;. &lt;ul&gt;&lt;li&gt;&#39;create&#39; creates the account where its admin user has ACTIVE status if admin_password was defined in the request, or RESET status if no admin_password was defined. If the user already exists, its status is not modified. &lt;/li&gt;&lt;li&gt;&#39;enroll&#39; creates the account where its admin user has ENROLLING status. If the user already exists, its status is not modified. Email to finish the enrollment or to notify the existing user about the new account is sent to the admin_email defined in the request. &lt;/li&gt;&lt;/ul&gt; (optional, default to create)
   * @return Call&lt;AccountCreationResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/accounts")
  Call<AccountCreationResp> createAccount(
    @retrofit2.http.Body AccountCreationReq body, @retrofit2.http.Query("action") String action
  );

  /**
   * Create a new API key.
   * An endpoint for creating a new API key. There is no default value for the owner ID and it must be from the same account where the new API key is created.
   * @param accountID Account ID. (required)
   * @param body Details of the API key to be created. (required)
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/accounts/{accountID}/api-keys")
  Call<ApiKeyInfoResp> createAccountApiKey(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Body ApiKeyInfoReq body
  );

  /**
   * Create a new group.
   * An endpoint for creating a new group.
   * @param accountID Account ID. (required)
   * @param body Details of the group to be created. (required)
   * @return Call&lt;GroupSummary&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/accounts/{accountID}/policy-groups")
  Call<GroupSummary> createAccountGroup(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Body GroupCreationInfo body
  );

  /**
   * Create a new user.
   * An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.
   * @param accountID Account ID. (required)
   * @param body A user object with attributes. (required)
   * @param action Create or invite user. (optional, default to create)
   * @return Call&lt;UserInfoResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/accounts/{accountID}/users")
  Call<UserInfoResp> createAccountUser(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Body UserInfoReq body, @retrofit2.http.Query("action") String action
  );

  /**
   * Delete the API key.
   * An endpoint for deleting an API key.
   * @param accountID Account ID. (required)
   * @param apiKey The ID of the API key to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/accounts/{accountID}/api-keys/{apiKey}")
  Call<Void> deleteAccountApiKey(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey
  );

  /**
   * Delete trusted certificate by ID.
   * An endpoint for deleting the trusted certificate.
   * @param accountID Account ID. (required)
   * @param certId The ID of the trusted certificate to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/accounts/{accountID}/trusted-certificates/{cert-id}")
  Call<Void> deleteAccountCertificate(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "cert-id", encoded = true) String certId
  );

  /**
   * Delete a group.
   * An endpoint for deleting a group.
   * @param accountID Account ID. (required)
   * @param groupID The ID of the group to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/accounts/{accountID}/policy-groups/{groupID}")
  Call<Void> deleteAccountGroup(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "groupID", encoded = true) String groupID
  );

  /**
   * Delete a user.
   * An endpoint for deleting a user.
   * @param accountID Account ID. (required)
   * @param userId The ID of the user to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/accounts/{accountID}/users/{user-id}")
  Call<Void> deleteAccountUser(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "user-id", encoded = true) String userId
  );

  /**
   * Get API key details.
   * An endpoint for retrieving API key details.
   * @param accountID Account ID. (required)
   * @param apiKey The ID of the API key to be retrieved. (required)
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @GET("v3/accounts/{accountID}/api-keys/{apiKey}")
  Call<ApiKeyInfoResp> getAccountApiKey(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey
  );

  /**
   * Get trusted certificate by ID.
   * An endpoint for retrieving a trusted certificate by ID.
   * @param accountID Account ID. (required)
   * @param certId The ID of the trusted certificate to be retrieved. (required)
   * @return Call&lt;TrustedCertificateInternalResp&gt;
   */
  @GET("v3/accounts/{accountID}/trusted-certificates/{cert-id}")
  Call<TrustedCertificateInternalResp> getAccountCertificate(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "cert-id", encoded = true) String certId
  );

  /**
   * Get group information.
   * An endpoint for getting general information about the group.
   * @param accountID Account ID. (required)
   * @param groupID The ID of the group to be retrieved. (required)
   * @return Call&lt;GroupSummary&gt;
   */
  @GET("v3/accounts/{accountID}/policy-groups/{groupID}")
  Call<GroupSummary> getAccountGroupSummary(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "groupID", encoded = true) String groupID
  );

  /**
   * Get account info.
   * Returns detailed information about the account.
   * @param accountID The ID of the account to be fetched. (required)
   * @param include Comma separated additional data to return. Currently supported: limits, policies, sub_accounts (optional)
   * @param properties Property name to be returned from account specific properties. (optional)
   * @return Call&lt;AccountInfo&gt;
   */
  @GET("v3/accounts/{accountID}")
  Call<AccountInfo> getAccountInfo(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("properties") String properties
  );

  /**
   * Details of the user.
   * An endpoint for retrieving details of the user.
   * @param accountID Account ID. (required)
   * @param userId The ID of the user to be retrieved. (required)
   * @param properties Request to return account specific user property values according to the given property name. (optional)
   * @return Call&lt;UserInfoResp&gt;
   */
  @GET("v3/accounts/{accountID}/users/{user-id}")
  Call<UserInfoResp> getAccountUser(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Query("properties") String properties
  );

  /**
   * Get all API keys.
   * An endpoint for retrieving the API keys in an array, optionally filtered by the owner.
   * @param accountID Account ID. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param keyEq API key filter. (optional)
   * @param ownerEq Owner name filter. (optional)
   * @return Call&lt;ApiKeyInfoRespList&gt;
   */
  @GET("v3/accounts/{accountID}/api-keys")
  Call<ApiKeyInfoRespList> getAllAccountApiKeys(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("key__eq") String keyEq, @retrofit2.http.Query("owner__eq") String ownerEq
  );

  /**
   * Get all trusted certificates.
   * An endpoint for retrieving trusted certificates in an array.
   * @param accountID Account ID. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param nameEq Filter for certificate name (optional)
   * @param serviceEq Filter for service (optional)
   * @param expireEq Filter for expire (optional)
   * @param deviceExecutionModeEq Filter for developer certificates (optional)
   * @param deviceExecutionModeNeq Filter for not developer certificates (optional)
   * @param ownerEq Owner name filter (optional)
   * @param enrollmentModeEq Enrollment mode filter (optional)
   * @param issuerLike Filter for issuer. Finds all matches where the filter value is a case insensitive substring of the result. Example: issuer__like&#x3D;cn&#x3D;iss matches CN&#x3D;issuer. (optional)
   * @param subjectLike Filter for subject. Finds all matches where the filter value is a case insensitive substring of the result. Example: subject__like&#x3D;cn&#x3D;su matches CN&#x3D;subject. (optional)
   * @return Call&lt;TrustedCertificateInternalRespList&gt;
   */
  @GET("v3/accounts/{accountID}/trusted-certificates")
  Call<TrustedCertificateInternalRespList> getAllAccountCertificates(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("name__eq") String nameEq, @retrofit2.http.Query("service__eq") String serviceEq, @retrofit2.http.Query("expire__eq") Integer expireEq, @retrofit2.http.Query("device_execution_mode__eq") Integer deviceExecutionModeEq, @retrofit2.http.Query("device_execution_mode__neq") Integer deviceExecutionModeNeq, @retrofit2.http.Query("owner__eq") String ownerEq, @retrofit2.http.Query("enrollment_mode__eq") Boolean enrollmentModeEq, @retrofit2.http.Query("issuer__like") String issuerLike, @retrofit2.http.Query("subject__like") String subjectLike
  );

  /**
   * Get all group information.
   * An endpoint for retrieving all group information.
   * @param accountID Account ID. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param nameEq Filter for group name (optional)
   * @return Call&lt;GroupSummaryList&gt;
   */
  @GET("v3/accounts/{accountID}/policy-groups")
  Call<GroupSummaryList> getAllAccountGroups(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("name__eq") String nameEq
  );

  /**
   * Get all user details.
   * An endpoint for retrieving details of all users.
   * @param accountID Account ID. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param emailEq Filter for email address (optional)
   * @param statusEq Filter for status (optional)
   * @param statusIn An optional filter for getting users with a specified set of statuses. (optional)
   * @param statusNin An optional filter for excluding users with a specified set of statuses. (optional)
   * @return Call&lt;UserInfoRespList&gt;
   */
  @GET("v3/accounts/{accountID}/users")
  Call<UserInfoRespList> getAllAccountUsers(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("email__eq") String emailEq, @retrofit2.http.Query("status__eq") String statusEq, @retrofit2.http.Query("status__in") String statusIn, @retrofit2.http.Query("status__nin") String statusNin
  );

  /**
   * Get all accounts.
   * Returns an array of account objects, optionally filtered by status and tier level.
   * @param statusEq An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED. (optional)
   * @param statusIn An optional filter for getting accounts with a specified set of statuses. (optional)
   * @param statusNin An optional filter for excluding accounts with a specified set of statuses. (optional)
   * @param tierEq An optional filter for tier level, must be 0, 1, 2, 98, 99 or omitted. (optional)
   * @param parentEq An optional filter for parent account ID. (optional)
   * @param endMarketEq An optional filter for account end market. (optional)
   * @param countryLike An optional filter for account country. Finds all matches where the filter value is a case insensitive substring of the result. Example: country__like&#x3D;LAND matches Ireland. (optional)
   * @param limit The number of results to return (2-1000), default is 1000. (optional, default to 1000)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC. Default value is ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: limits, policies, sub_accounts (optional)
   * @param format Format information for the response to the query, supported: format&#x3D;breakdown. (optional)
   * @param properties Property name to be returned from account specific properties. (optional)
   * @return Call&lt;AccountInfoList&gt;
   */
  @GET("v3/accounts")
  Call<AccountInfoList> getAllAccounts(
    @retrofit2.http.Query("status__eq") String statusEq, @retrofit2.http.Query("status__in") String statusIn, @retrofit2.http.Query("status__nin") String statusNin, @retrofit2.http.Query("tier__eq") String tierEq, @retrofit2.http.Query("parent__eq") String parentEq, @retrofit2.http.Query("end_market__eq") String endMarketEq, @retrofit2.http.Query("country__like") String countryLike, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("format") String format, @retrofit2.http.Query("properties") String properties
  );

  /**
   * Get API keys of a group.
   * An endpoint for listing the API keys of the group with details.
   * @param accountID Account ID. (required)
   * @param groupID The ID of the group whose API keys are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;ApiKeyInfoRespList&gt;
   */
  @GET("v3/accounts/{accountID}/policy-groups/{groupID}/api-keys")
  Call<ApiKeyInfoRespList> getApiKeysOfAccountGroup(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Get groups of the API key.
   * An endpoint for retrieving groups of the API key.
   * @param accountID Account ID. (required)
   * @param apiKey The ID of the API key whose details are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;GroupSummaryList&gt;
   */
  @GET("v3/accounts/{accountID}/api-keys/{apiKey}/groups")
  Call<GroupSummaryList> getGroupsOfAccountApikey(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Get groups of the user.
   * An endpoint for retrieving groups of the user.
   * @param accountID Account ID. (required)
   * @param userId The ID of the user whose details are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;GroupSummaryList&gt;
   */
  @GET("v3/accounts/{accountID}/users/{user-id}/groups")
  Call<GroupSummaryList> getGroupsOfAccountUser(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Get users of a group.
   * An endpoint for listing users of the group with details.
   * @param accountID Account ID. (required)
   * @param groupID The ID of the group whose users are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param statusEq An optional filter for getting users by status. (optional)
   * @param statusIn An optional filter for getting users with a specified set of statuses. (optional)
   * @param statusNin An optional filter for excluding users with a specified set of statuses. (optional)
   * @return Call&lt;UserInfoRespList&gt;
   */
  @GET("v3/accounts/{accountID}/policy-groups/{groupID}/users")
  Call<UserInfoRespList> getUsersOfAccountGroup(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("status__eq") String statusEq, @retrofit2.http.Query("status__in") String statusIn, @retrofit2.http.Query("status__nin") String statusNin
  );

  /**
   * Remove API key from groups.
   * An endpoint for removing API key from groups.
   * @param accountID Account ID. (required)
   * @param apiKey The ID of the API key to be removed from the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/accounts/{accountID}/api-keys/{apiKey}/groups")
  Call<UpdatedResponse> removeAccountApiKeyFromGroups(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Body List<String> body
  );

  /**
   * Remove user from groups.
   * An endpoint for removing user from groups.
   * @param accountID Account ID. (required)
   * @param userId The ID of the user to be removed from the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/accounts/{accountID}/users/{user-id}/groups")
  Call<UpdatedResponse> removeAccountUserFromGroups(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body List<String> body
  );

  /**
   * Remove API keys from a group.
   * An endpoint for removing API keys from groups.
   * @param accountID Account ID. (required)
   * @param groupID A list of API keys to be removed from the group. (required)
   * @param body  (optional)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/accounts/{accountID}/policy-groups/{groupID}/api-keys")
  Call<UpdatedResponse> removeApiKeysFromAccountGroup(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body SubjectList body
  );

  /**
   * Remove users from a group.
   * An endpoint for removing users from groups.
   * @param accountID Account ID. (required)
   * @param groupID  (required)
   * @param body  (optional)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/accounts/{accountID}/policy-groups/{groupID}/users")
  Call<UpdatedResponse> removeUsersFromAccountGroup(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body SubjectList body
  );

  /**
   * Reset the secret key.
   * An endpoint for resetting the secret key of the API key.
   * @param accountID Account ID. (required)
   * @param apiKey The ID of the API key to be reset. (required)
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @POST("v3/accounts/{accountID}/api-keys/{apiKey}/reset-secret")
  Call<ApiKeyInfoResp> resetAccountApiKeySecret(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey
  );

  /**
   * Update attributes of an existing account.
   * An endpoint for updating an account.
   * @param accountID The ID of the account to be updated. (required)
   * @param body Details of the account to be updated. (required)
   * @return Call&lt;AccountInfo&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/accounts/{accountID}")
  Call<AccountInfo> updateAccount(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Body AccountUpdateRootReq body
  );

  /**
   * Update API key details.
   * An endpoint for updating API key details.
   * @param accountID Account ID. (required)
   * @param apiKey The ID of the API key to be updated. (required)
   * @param body New API key attributes to be stored. (required)
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @PUT("v3/accounts/{accountID}/api-keys/{apiKey}")
  Call<ApiKeyInfoResp> updateAccountApiKey(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Body ApiKeyUpdateReq body
  );

  /**
   * Update trusted certificate.
   * An endpoint for updating existing trusted certificates.
   * @param accountID Account ID. (required)
   * @param certId The ID of the trusted certificate to be updated. (required)
   * @param body A trusted certificate object with attributes. (required)
   * @return Call&lt;TrustedCertificateInternalResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/accounts/{accountID}/trusted-certificates/{cert-id}")
  Call<TrustedCertificateInternalResp> updateAccountCertificate(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "cert-id", encoded = true) String certId, @retrofit2.http.Body TrustedCertificateUpdateReq body
  );

  /**
   * Update the group name.
   * An endpoint for updating a group name.
   * @param accountID Account ID. (required)
   * @param groupID The ID of the group to be updated. (required)
   * @param body Details of the group to be created. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/accounts/{accountID}/policy-groups/{groupID}")
  Call<UpdatedResponse> updateAccountGroupName(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body GroupUpdateInfo body
  );

  /**
   * Update user details.
   * An endpoint for updating user details.
   * @param accountID Account ID. (required)
   * @param userId The ID of the user to be updated. (required)
   * @param body A user object with attributes. (required)
   * @return Call&lt;UserUpdateResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/accounts/{accountID}/users/{user-id}")
  Call<UserUpdateResp> updateAccountUser(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body UserUpdateReq body
  );

  /**
   * Validate the user email.
   * An endpoint for validating the user email.
   * @param accountID Account ID. (required)
   * @param userId The ID of the user whose email is validated. (required)
   * @return Call&lt;Void&gt;
   */
  @POST("v3/accounts/{accountID}/users/{user-id}/validate-email")
  Call<Void> validateAccountUserEmail(
    @retrofit2.http.Path(value = "accountID", encoded = true) String accountID, @retrofit2.http.Path(value = "user-id", encoded = true) String userId
  );

}
