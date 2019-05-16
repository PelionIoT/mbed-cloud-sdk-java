# TenantAccountsUserInvitationsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAccountInvitation**](TenantAccountsUserInvitationsApi.md#createAccountInvitation) | **POST** v3/accounts/{account_id}/user-invitations | Create a user invitation.
[**deleteAccountInvitation**](TenantAccountsUserInvitationsApi.md#deleteAccountInvitation) | **DELETE** v3/accounts/{account_id}/user-invitations/{invitation_id} | Delete a user invitation.
[**getAccountInvitation**](TenantAccountsUserInvitationsApi.md#getAccountInvitation) | **GET** v3/accounts/{account_id}/user-invitations/{invitation_id} | Details of a user invitation.
[**getAllAccountInvitations**](TenantAccountsUserInvitationsApi.md#getAllAccountInvitations) | **GET** v3/accounts/{account_id}/user-invitations | Get the details of all user invitations.


<a name="createAccountInvitation"></a>
# **createAccountInvitation**
> UserInvitationResp createAccountInvitation(accountId, body)

Create a user invitation.

Invite a new or existing user.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accouns/{account_id}/user-invitations \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsUserInvitationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsUserInvitationsApi apiInstance = new TenantAccountsUserInvitationsApi();
String accountId = "accountId_example"; // String | Account ID.
UserInvitationReq body = new UserInvitationReq(); // UserInvitationReq | A user invitation object with attributes.
try {
    UserInvitationResp result = apiInstance.createAccountInvitation(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsUserInvitationsApi#createAccountInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**UserInvitationReq**](UserInvitationReq.md)| A user invitation object with attributes. |

### Return type

[**UserInvitationResp**](UserInvitationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccountInvitation"></a>
# **deleteAccountInvitation**
> Void deleteAccountInvitation(accountId, invitationId)

Delete a user invitation.

Delete an active user invitation sent to a new or existing user.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsUserInvitationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsUserInvitationsApi apiInstance = new TenantAccountsUserInvitationsApi();
String accountId = "accountId_example"; // String | Account ID.
String invitationId = "invitationId_example"; // String | The ID of the invitation to delete.
try {
    Void result = apiInstance.deleteAccountInvitation(accountId, invitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsUserInvitationsApi#deleteAccountInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **invitationId** | **String**| The ID of the invitation to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountInvitation"></a>
# **getAccountInvitation**
> UserInvitationResp getAccountInvitation(accountId, invitationId)

Details of a user invitation.

Retrieve details of an active user invitation sent for a new or existing user.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsUserInvitationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsUserInvitationsApi apiInstance = new TenantAccountsUserInvitationsApi();
String accountId = "accountId_example"; // String | Account ID.
String invitationId = "invitationId_example"; // String | The ID of the invitation to retrieve.
try {
    UserInvitationResp result = apiInstance.getAccountInvitation(accountId, invitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsUserInvitationsApi#getAccountInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **invitationId** | **String**| The ID of the invitation to retrieve. |

### Return type

[**UserInvitationResp**](UserInvitationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountInvitations"></a>
# **getAllAccountInvitations**
> UserInvitationRespList getAllAccountInvitations(accountId, limit, after, order, loginProfilesEq)

Get the details of all user invitations.

Retrieve details of all active user invitations sent for new or existing users.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsUserInvitationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsUserInvitationsApi apiInstance = new TenantAccountsUserInvitationsApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String loginProfilesEq = "loginProfilesEq_example"; // String | Filter to retrieve user invitations by a specified login profile.
try {
    UserInvitationRespList result = apiInstance.getAllAccountInvitations(accountId, limit, after, order, loginProfilesEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsUserInvitationsApi#getAllAccountInvitations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **loginProfilesEq** | **String**| Filter to retrieve user invitations by a specified login profile. | [optional]

### Return type

[**UserInvitationRespList**](UserInvitationRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

