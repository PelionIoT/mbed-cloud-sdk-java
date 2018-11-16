# AggregatorAccountAdminApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAccountApiKeyToGroups**](AggregatorAccountAdminApi.md#addAccountApiKeyToGroups) | **POST** v3/accounts/{accountID}/api-keys/{apiKey}/groups | Add API key to a list of groups.
[**addAccountCertificate**](AggregatorAccountAdminApi.md#addAccountCertificate) | **POST** v3/accounts/{accountID}/trusted-certificates | Upload new trusted certificate.
[**addAccountUserToGroups**](AggregatorAccountAdminApi.md#addAccountUserToGroups) | **POST** v3/accounts/{accountID}/users/{user-id}/groups | Add user to a list of groups.
[**addSubjectsToAccountGroup**](AggregatorAccountAdminApi.md#addSubjectsToAccountGroup) | **POST** v3/accounts/{accountID}/policy-groups/{groupID} | Add members to a group.
[**checkAccountApiKey**](AggregatorAccountAdminApi.md#checkAccountApiKey) | **POST** v3/accounts/{accountID}/api-keys/{apiKey} | Check the API key.
[**createAccount**](AggregatorAccountAdminApi.md#createAccount) | **POST** v3/accounts | Create a new account.
[**createAccountApiKey**](AggregatorAccountAdminApi.md#createAccountApiKey) | **POST** v3/accounts/{accountID}/api-keys | Create a new API key.
[**createAccountGroup**](AggregatorAccountAdminApi.md#createAccountGroup) | **POST** v3/accounts/{accountID}/policy-groups | Create a new group.
[**createAccountInvitation**](AggregatorAccountAdminApi.md#createAccountInvitation) | **POST** v3/accounts/{account-id}/user-invitations | Create a user invitation.
[**createAccountUser**](AggregatorAccountAdminApi.md#createAccountUser) | **POST** v3/accounts/{accountID}/users | Create a new user.
[**deleteAccountApiKey**](AggregatorAccountAdminApi.md#deleteAccountApiKey) | **DELETE** v3/accounts/{accountID}/api-keys/{apiKey} | Delete the API key.
[**deleteAccountCertificate**](AggregatorAccountAdminApi.md#deleteAccountCertificate) | **DELETE** v3/accounts/{accountID}/trusted-certificates/{cert-id} | Delete trusted certificate by ID.
[**deleteAccountGroup**](AggregatorAccountAdminApi.md#deleteAccountGroup) | **DELETE** v3/accounts/{accountID}/policy-groups/{groupID} | Delete a group.
[**deleteAccountInvitation**](AggregatorAccountAdminApi.md#deleteAccountInvitation) | **DELETE** v3/accounts/{account-id}/user-invitations/{invitation-id} | Delete a user invitation.
[**deleteAccountUser**](AggregatorAccountAdminApi.md#deleteAccountUser) | **DELETE** v3/accounts/{accountID}/users/{user-id} | Delete a user.
[**getAccountApiKey**](AggregatorAccountAdminApi.md#getAccountApiKey) | **GET** v3/accounts/{accountID}/api-keys/{apiKey} | Get API key details.
[**getAccountCertificate**](AggregatorAccountAdminApi.md#getAccountCertificate) | **GET** v3/accounts/{accountID}/trusted-certificates/{cert-id} | Get trusted certificate by ID.
[**getAccountGroupSummary**](AggregatorAccountAdminApi.md#getAccountGroupSummary) | **GET** v3/accounts/{accountID}/policy-groups/{groupID} | Get group information.
[**getAccountInfo**](AggregatorAccountAdminApi.md#getAccountInfo) | **GET** v3/accounts/{accountID} | Get account info.
[**getAccountInvitation**](AggregatorAccountAdminApi.md#getAccountInvitation) | **GET** v3/accounts/{account-id}/user-invitations/{invitation-id} | Details of a user invitation.
[**getAccountUser**](AggregatorAccountAdminApi.md#getAccountUser) | **GET** v3/accounts/{accountID}/users/{user-id} | Details of the user.
[**getAllAccountApiKeys**](AggregatorAccountAdminApi.md#getAllAccountApiKeys) | **GET** v3/accounts/{accountID}/api-keys | Get all API keys.
[**getAllAccountCertificates**](AggregatorAccountAdminApi.md#getAllAccountCertificates) | **GET** v3/accounts/{accountID}/trusted-certificates | Get all trusted certificates.
[**getAllAccountGroups**](AggregatorAccountAdminApi.md#getAllAccountGroups) | **GET** v3/accounts/{accountID}/policy-groups | Get all group information.
[**getAllAccountInvitations**](AggregatorAccountAdminApi.md#getAllAccountInvitations) | **GET** v3/accounts/{account-id}/user-invitations | Get the details of all the user invitations.
[**getAllAccountUsers**](AggregatorAccountAdminApi.md#getAllAccountUsers) | **GET** v3/accounts/{accountID}/users | Get all user details.
[**getAllAccounts**](AggregatorAccountAdminApi.md#getAllAccounts) | **GET** v3/accounts | Get all accounts.
[**getApiKeysOfAccountGroup**](AggregatorAccountAdminApi.md#getApiKeysOfAccountGroup) | **GET** v3/accounts/{accountID}/policy-groups/{groupID}/api-keys | Get API keys of a group.
[**getGroupsOfAccountApikey**](AggregatorAccountAdminApi.md#getGroupsOfAccountApikey) | **GET** v3/accounts/{accountID}/api-keys/{apiKey}/groups | Get groups of the API key.
[**getGroupsOfAccountUser**](AggregatorAccountAdminApi.md#getGroupsOfAccountUser) | **GET** v3/accounts/{accountID}/users/{user-id}/groups | Get groups of the user.
[**getUsersOfAccountGroup**](AggregatorAccountAdminApi.md#getUsersOfAccountGroup) | **GET** v3/accounts/{accountID}/policy-groups/{groupID}/users | Get users of a group.
[**removeAccountApiKeyFromGroups**](AggregatorAccountAdminApi.md#removeAccountApiKeyFromGroups) | **DELETE** v3/accounts/{accountID}/api-keys/{apiKey}/groups | Remove API key from groups.
[**removeAccountUserFromGroups**](AggregatorAccountAdminApi.md#removeAccountUserFromGroups) | **DELETE** v3/accounts/{accountID}/users/{user-id}/groups | Remove user from groups.
[**removeApiKeysFromAccountGroup**](AggregatorAccountAdminApi.md#removeApiKeysFromAccountGroup) | **DELETE** v3/accounts/{accountID}/policy-groups/{groupID}/api-keys | Remove API keys from a group.
[**removeUsersFromAccountGroup**](AggregatorAccountAdminApi.md#removeUsersFromAccountGroup) | **DELETE** v3/accounts/{accountID}/policy-groups/{groupID}/users | Remove users from a group.
[**resetAccountApiKeySecret**](AggregatorAccountAdminApi.md#resetAccountApiKeySecret) | **POST** v3/accounts/{accountID}/api-keys/{apiKey}/reset-secret | Reset the secret key.
[**updateAccount**](AggregatorAccountAdminApi.md#updateAccount) | **PUT** v3/accounts/{accountID} | Update attributes of an existing account.
[**updateAccountApiKey**](AggregatorAccountAdminApi.md#updateAccountApiKey) | **PUT** v3/accounts/{accountID}/api-keys/{apiKey} | Update API key details.
[**updateAccountCertificate**](AggregatorAccountAdminApi.md#updateAccountCertificate) | **PUT** v3/accounts/{accountID}/trusted-certificates/{cert-id} | Update trusted certificate.
[**updateAccountGroupName**](AggregatorAccountAdminApi.md#updateAccountGroupName) | **PUT** v3/accounts/{accountID}/policy-groups/{groupID} | Update the group name.
[**updateAccountUser**](AggregatorAccountAdminApi.md#updateAccountUser) | **PUT** v3/accounts/{accountID}/users/{user-id} | Update user details.
[**validateAccountUserEmail**](AggregatorAccountAdminApi.md#validateAccountUserEmail) | **POST** v3/accounts/{accountID}/users/{user-id}/validate-email | Validate the user email.


<a name="addAccountApiKeyToGroups"></a>
# **addAccountApiKeyToGroups**
> UpdatedResponse addAccountApiKeyToGroups(accountID, apiKey, body)

Add API key to a list of groups.

An endpoint for adding API key to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apikey}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String apiKey = "apiKey_example"; // String | The ID of the API key to be added to the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.addAccountApiKeyToGroups(accountID, apiKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#addAccountApiKeyToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **apiKey** | **String**| The ID of the API key to be added to the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addAccountCertificate"></a>
# **addAccountCertificate**
> TrustedCertificateResp addAccountCertificate(accountID, body)

Upload new trusted certificate.

An endpoint for uploading new trusted certificates.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/trusted-certificates -d {\&quot;name\&quot;: \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;: \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
TrustedCertificateRootReq body = new TrustedCertificateRootReq(); // TrustedCertificateRootReq | A trusted certificate object with attributes, signature is optional.
try {
    TrustedCertificateResp result = apiInstance.addAccountCertificate(accountID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#addAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **body** | [**TrustedCertificateRootReq**](TrustedCertificateRootReq.md)| A trusted certificate object with attributes, signature is optional. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addAccountUserToGroups"></a>
# **addAccountUserToGroups**
> UpdatedResponse addAccountUserToGroups(accountID, userId, body)

Add user to a list of groups.

An endpoint for adding user to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be added to the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.addAccountUserToGroups(accountID, userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#addAccountUserToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be added to the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addSubjectsToAccountGroup"></a>
# **addSubjectsToAccountGroup**
> UpdatedResponse addSubjectsToAccountGroup(accountID, groupID, body)

Add members to a group.

An endpoint for adding users and API keys to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID} -d &#39;{\&quot;users\&quot;: [0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String groupID = "groupID_example"; // String | The ID of the group to be updated.
SubjectList body = new SubjectList(); // SubjectList | A list of users and API keys to be added to the group.
try {
    UpdatedResponse result = apiInstance.addSubjectsToAccountGroup(accountID, groupID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#addSubjectsToAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **groupID** | **String**| The ID of the group to be updated. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users and API keys to be added to the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="checkAccountApiKey"></a>
# **checkAccountApiKey**
> Void checkAccountApiKey(accountID, apiKey)

Check the API key.

An endpoint for checking API key.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String apiKey = "apiKey_example"; // String | The API key to be checked.
try {
    Void result = apiInstance.checkAccountApiKey(accountID, apiKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#checkAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **apiKey** | **String**| The API key to be checked. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createAccount"></a>
# **createAccount**
> AccountCreationResp createAccount(body, action)

Create a new account.

An endpoint for creating a new account.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts -d &#39;{\&quot;display_name\&quot;: \&quot;MyAccount1\&quot;, \&quot;admin_name\&quot;: \&quot;accountAdmin1\&quot;, \&quot;email\&quot;: \&quot;example_admin@myaccount.info\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
AccountCreationReq body = new AccountCreationReq(); // AccountCreationReq | Details of the account to be created.
String action = "create"; // String | Action, either 'create' or 'enroll'. <ul><li>'create' creates the account where its admin user has ACTIVE status if admin_password was defined in the request, or RESET status if no admin_password was defined. If the user already exists, its status is not modified. </li><li>'enroll' creates the account where its admin user has ENROLLING status. If the user already exists, its status is not modified. Email to finish the enrollment or to notify the existing user about the new account is sent to the admin_email defined in the request. </li></ul>
try {
    AccountCreationResp result = apiInstance.createAccount(body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AccountCreationReq**](AccountCreationReq.md)| Details of the account to be created. |
 **action** | **String**| Action, either &#39;create&#39; or &#39;enroll&#39;. &lt;ul&gt;&lt;li&gt;&#39;create&#39; creates the account where its admin user has ACTIVE status if admin_password was defined in the request, or RESET status if no admin_password was defined. If the user already exists, its status is not modified. &lt;/li&gt;&lt;li&gt;&#39;enroll&#39; creates the account where its admin user has ENROLLING status. If the user already exists, its status is not modified. Email to finish the enrollment or to notify the existing user about the new account is sent to the admin_email defined in the request. &lt;/li&gt;&lt;/ul&gt; | [optional] [default to create]

### Return type

[**AccountCreationResp**](AccountCreationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountApiKey"></a>
# **createAccountApiKey**
> ApiKeyInfoResp createAccountApiKey(accountID, body)

Create a new API key.

An endpoint for creating a new API key. There is no default value for the owner ID and it must be from the same account where the new API key is created.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
ApiKeyInfoReq body = new ApiKeyInfoReq(); // ApiKeyInfoReq | Details of the API key to be created.
try {
    ApiKeyInfoResp result = apiInstance.createAccountApiKey(accountID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **body** | [**ApiKeyInfoReq**](ApiKeyInfoReq.md)| Details of the API key to be created. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountGroup"></a>
# **createAccountGroup**
> GroupSummary createAccountGroup(accountID, body)

Create a new group.

An endpoint for creating a new group.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
GroupCreationInfo body = new GroupCreationInfo(); // GroupCreationInfo | Details of the group to be created.
try {
    GroupSummary result = apiInstance.createAccountGroup(accountID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **body** | [**GroupCreationInfo**](GroupCreationInfo.md)| Details of the group to be created. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountInvitation"></a>
# **createAccountInvitation**
> UserInvitationResp createAccountInvitation(accountId, body)

Create a user invitation.

An endpoint for inviting a new or an existing user to join the account.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accouns/{account-id}/user-invitations -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
UserInvitationReq body = new UserInvitationReq(); // UserInvitationReq | A user invitation object with attributes.
try {
    UserInvitationResp result = apiInstance.createAccountInvitation(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountInvitation");
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

<a name="createAccountUser"></a>
# **createAccountUser**
> UserInfoResp createAccountUser(accountID, body, action)

Create a new user.

An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
UserInfoReq body = new UserInfoReq(); // UserInfoReq | A user object with attributes.
String action = "create"; // String | Create or invite user.
try {
    UserInfoResp result = apiInstance.createAccountUser(accountID, body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **body** | [**UserInfoReq**](UserInfoReq.md)| A user object with attributes. |
 **action** | **String**| Create or invite user. | [optional] [default to create]

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccountApiKey"></a>
# **deleteAccountApiKey**
> Void deleteAccountApiKey(accountID, apiKey)

Delete the API key.

An endpoint for deleting an API key.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apikey} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String apiKey = "apiKey_example"; // String | The ID of the API key to be deleted.
try {
    Void result = apiInstance.deleteAccountApiKey(accountID, apiKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **apiKey** | **String**| The ID of the API key to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountCertificate"></a>
# **deleteAccountCertificate**
> Void deleteAccountCertificate(accountID, certId)

Delete trusted certificate by ID.

An endpoint for deleting the trusted certificate.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/trusted-certificates/{cert-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to be deleted.
try {
    Void result = apiInstance.deleteAccountCertificate(accountID, certId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountGroup"></a>
# **deleteAccountGroup**
> Void deleteAccountGroup(accountID, groupID)

Delete a group.

An endpoint for deleting a group.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String groupID = "groupID_example"; // String | The ID of the group to be deleted.
try {
    Void result = apiInstance.deleteAccountGroup(accountID, groupID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **groupID** | **String**| The ID of the group to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountInvitation"></a>
# **deleteAccountInvitation**
> Void deleteAccountInvitation(accountId, invitationId)

Delete a user invitation.

An endpoint for deleting an active user invitation which has been sent for a new or an existing user to join the account.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account-id}/user-invitations/{invitation-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String invitationId = "invitationId_example"; // String | The ID of the invitation to be deleted.
try {
    Void result = apiInstance.deleteAccountInvitation(accountId, invitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **invitationId** | **String**| The ID of the invitation to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountUser"></a>
# **deleteAccountUser**
> Void deleteAccountUser(accountID, userId)

Delete a user.

An endpoint for deleting a user.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be deleted.
try {
    Void result = apiInstance.deleteAccountUser(accountID, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountApiKey"></a>
# **getAccountApiKey**
> ApiKeyInfoResp getAccountApiKey(accountID, apiKey)

Get API key details.

An endpoint for retrieving API key details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String apiKey = "apiKey_example"; // String | The ID of the API key to be retrieved.
try {
    ApiKeyInfoResp result = apiInstance.getAccountApiKey(accountID, apiKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **apiKey** | **String**| The ID of the API key to be retrieved. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountCertificate"></a>
# **getAccountCertificate**
> TrustedCertificateInternalResp getAccountCertificate(accountID, certId)

Get trusted certificate by ID.

An endpoint for retrieving a trusted certificate by ID.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/trusted-certificates/{cert-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to be retrieved.
try {
    TrustedCertificateInternalResp result = apiInstance.getAccountCertificate(accountID, certId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to be retrieved. |

### Return type

[**TrustedCertificateInternalResp**](TrustedCertificateInternalResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountGroupSummary"></a>
# **getAccountGroupSummary**
> GroupSummary getAccountGroupSummary(accountID, groupID)

Get group information.

An endpoint for getting general information about the group.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String groupID = "groupID_example"; // String | The ID of the group to be retrieved.
try {
    GroupSummary result = apiInstance.getAccountGroupSummary(accountID, groupID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountGroupSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **groupID** | **String**| The ID of the group to be retrieved. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountInfo"></a>
# **getAccountInfo**
> AccountInfo getAccountInfo(accountID, include, properties)

Get account info.

Returns detailed information about the account.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | The ID of the account to be fetched.
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: limits, policies, sub_accounts
String properties = "properties_example"; // String | Property name to be returned from account specific properties.
try {
    AccountInfo result = apiInstance.getAccountInfo(accountID, include, properties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| The ID of the account to be fetched. |
 **include** | **String**| Comma separated additional data to return. Currently supported: limits, policies, sub_accounts | [optional]
 **properties** | **String**| Property name to be returned from account specific properties. | [optional]

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountInvitation"></a>
# **getAccountInvitation**
> UserInvitationResp getAccountInvitation(accountId, invitationId)

Details of a user invitation.

An endpoint for retrieving the details of an active user invitation sent for a new or an existing user to join the account.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account-id}/user-invitations/{invitation-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String invitationId = "invitationId_example"; // String | The ID of the invitation to be retrieved.
try {
    UserInvitationResp result = apiInstance.getAccountInvitation(accountId, invitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **invitationId** | **String**| The ID of the invitation to be retrieved. |

### Return type

[**UserInvitationResp**](UserInvitationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountUser"></a>
# **getAccountUser**
> UserInfoResp getAccountUser(accountID, userId)

Details of the user.

An endpoint for retrieving details of the user.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{userID} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be retrieved.
try {
    UserInfoResp result = apiInstance.getAccountUser(accountID, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be retrieved. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountApiKeys"></a>
# **getAllAccountApiKeys**
> ApiKeyInfoRespList getAllAccountApiKeys(accountID, limit, after, order, include, keyEq, ownerEq)

Get all API keys.

An endpoint for retrieving the API keys in an array, optionally filtered by the owner.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String keyEq = "keyEq_example"; // String | API key filter.
String ownerEq = "ownerEq_example"; // String | Owner name filter.
try {
    ApiKeyInfoRespList result = apiInstance.getAllAccountApiKeys(accountID, limit, after, order, include, keyEq, ownerEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountApiKeys");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **keyEq** | **String**| API key filter. | [optional]
 **ownerEq** | **String**| Owner name filter. | [optional]

### Return type

[**ApiKeyInfoRespList**](ApiKeyInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountCertificates"></a>
# **getAllAccountCertificates**
> TrustedCertificateInternalRespList getAllAccountCertificates(accountID, limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, issuerLike, subjectLike)

Get all trusted certificates.

An endpoint for retrieving trusted certificates in an array.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/trusted-certificates -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String nameEq = "nameEq_example"; // String | Filter for certificate name
String serviceEq = "serviceEq_example"; // String | Filter for service
Integer expireEq = 56; // Integer | Filter for expire
Integer deviceExecutionModeEq = 56; // Integer | Filter for developer certificates
Integer deviceExecutionModeNeq = 56; // Integer | Filter for not developer certificates
String ownerEq = "ownerEq_example"; // String | Owner name filter
Boolean enrollmentModeEq = true; // Boolean | Enrollment mode filter
String issuerLike = "issuerLike_example"; // String | Filter for issuer. Finds all matches where the filter value is a case insensitive substring of the result. Example: issuer__like=cn=iss matches CN=issuer.
String subjectLike = "subjectLike_example"; // String | Filter for subject. Finds all matches where the filter value is a case insensitive substring of the result. Example: subject__like=cn=su matches CN=subject.
try {
    TrustedCertificateInternalRespList result = apiInstance.getAllAccountCertificates(accountID, limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, issuerLike, subjectLike);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountCertificates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **nameEq** | **String**| Filter for certificate name | [optional]
 **serviceEq** | **String**| Filter for service | [optional]
 **expireEq** | **Integer**| Filter for expire | [optional]
 **deviceExecutionModeEq** | **Integer**| Filter for developer certificates | [optional]
 **deviceExecutionModeNeq** | **Integer**| Filter for not developer certificates | [optional]
 **ownerEq** | **String**| Owner name filter | [optional]
 **enrollmentModeEq** | **Boolean**| Enrollment mode filter | [optional]
 **issuerLike** | **String**| Filter for issuer. Finds all matches where the filter value is a case insensitive substring of the result. Example: issuer__like&#x3D;cn&#x3D;iss matches CN&#x3D;issuer. | [optional]
 **subjectLike** | **String**| Filter for subject. Finds all matches where the filter value is a case insensitive substring of the result. Example: subject__like&#x3D;cn&#x3D;su matches CN&#x3D;subject. | [optional]

### Return type

[**TrustedCertificateInternalRespList**](TrustedCertificateInternalRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountGroups"></a>
# **getAllAccountGroups**
> GroupSummaryList getAllAccountGroups(accountID, limit, after, order, include, nameEq)

Get all group information.

An endpoint for retrieving all group information.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String nameEq = "nameEq_example"; // String | Filter for group name
try {
    GroupSummaryList result = apiInstance.getAllAccountGroups(accountID, limit, after, order, include, nameEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **nameEq** | **String**| Filter for group name | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountInvitations"></a>
# **getAllAccountInvitations**
> UserInvitationRespList getAllAccountInvitations(accountId, limit, after, order)

Get the details of all the user invitations.

An endpoint for retrieving the details of all the active user invitations sent for new or existing users to join the account.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account-id}/user-invitations -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
try {
    UserInvitationRespList result = apiInstance.getAllAccountInvitations(accountId, limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountInvitations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]

### Return type

[**UserInvitationRespList**](UserInvitationRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountUsers"></a>
# **getAllAccountUsers**
> UserInfoRespList getAllAccountUsers(accountID, limit, after, order, include, emailEq, statusEq, statusIn, statusNin)

Get all user details.

An endpoint for retrieving details of all users.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String emailEq = "emailEq_example"; // String | Filter for email address
String statusEq = "statusEq_example"; // String | Filter for status
String statusIn = "statusIn_example"; // String | An optional filter for getting users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter for excluding users with a specified set of statuses.
try {
    UserInfoRespList result = apiInstance.getAllAccountUsers(accountID, limit, after, order, include, emailEq, statusEq, statusIn, statusNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **emailEq** | **String**| Filter for email address | [optional]
 **statusEq** | **String**| Filter for status | [optional]
 **statusIn** | **String**| An optional filter for getting users with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter for excluding users with a specified set of statuses. | [optional]

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccounts"></a>
# **getAllAccounts**
> AccountInfoList getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties)

Get all accounts.

Returns an array of account objects, optionally filtered by status and tier level.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String statusEq = "statusEq_example"; // String | An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED.
String statusIn = "statusIn_example"; // String | An optional filter for getting accounts with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter for excluding accounts with a specified set of statuses.
String tierEq = "tierEq_example"; // String | An optional filter for tier level, must be 0, 1, 2, 98, 99 or omitted.
String parentEq = "parentEq_example"; // String | An optional filter for parent account ID.
String endMarketEq = "endMarketEq_example"; // String | An optional filter for account end market.
String countryLike = "countryLike_example"; // String | An optional filter for account country. Finds all matches where the filter value is a case insensitive substring of the result. Example: country__like=LAND matches Ireland.
Integer limit = 1000; // Integer | The number of results to return (2-1000), default is 1000.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC. Default value is ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: limits, policies, sub_accounts
String format = "format_example"; // String | Format information for the response to the query, supported: format=breakdown.
String properties = "properties_example"; // String | Property name to be returned from account specific properties.
try {
    AccountInfoList result = apiInstance.getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **statusEq** | **String**| An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED. | [optional]
 **statusIn** | **String**| An optional filter for getting accounts with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter for excluding accounts with a specified set of statuses. | [optional]
 **tierEq** | **String**| An optional filter for tier level, must be 0, 1, 2, 98, 99 or omitted. | [optional]
 **parentEq** | **String**| An optional filter for parent account ID. | [optional]
 **endMarketEq** | **String**| An optional filter for account end market. | [optional]
 **countryLike** | **String**| An optional filter for account country. Finds all matches where the filter value is a case insensitive substring of the result. Example: country__like&#x3D;LAND matches Ireland. | [optional]
 **limit** | **Integer**| The number of results to return (2-1000), default is 1000. | [optional] [default to 1000]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC. Default value is ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: limits, policies, sub_accounts | [optional]
 **format** | **String**| Format information for the response to the query, supported: format&#x3D;breakdown. | [optional]
 **properties** | **String**| Property name to be returned from account specific properties. | [optional]

### Return type

[**AccountInfoList**](AccountInfoList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getApiKeysOfAccountGroup"></a>
# **getApiKeysOfAccountGroup**
> ApiKeyInfoRespList getApiKeysOfAccountGroup(accountID, groupID, limit, after, order, include)

Get API keys of a group.

An endpoint for listing the API keys of the group with details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String groupID = "groupID_example"; // String | The ID of the group whose API keys are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    ApiKeyInfoRespList result = apiInstance.getApiKeysOfAccountGroup(accountID, groupID, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getApiKeysOfAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **groupID** | **String**| The ID of the group whose API keys are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]

### Return type

[**ApiKeyInfoRespList**](ApiKeyInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfAccountApikey"></a>
# **getGroupsOfAccountApikey**
> GroupSummaryList getGroupsOfAccountApikey(accountID, apiKey, limit, after, order, include)

Get groups of the API key.

An endpoint for retrieving groups of the API key.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String apiKey = "apiKey_example"; // String | The ID of the API key whose details are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    GroupSummaryList result = apiInstance.getGroupsOfAccountApikey(accountID, apiKey, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getGroupsOfAccountApikey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **apiKey** | **String**| The ID of the API key whose details are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfAccountUser"></a>
# **getGroupsOfAccountUser**
> GroupSummaryList getGroupsOfAccountUser(accountID, userId, limit, after, order, include)

Get groups of the user.

An endpoint for retrieving groups of the user.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user whose details are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    GroupSummaryList result = apiInstance.getGroupsOfAccountUser(accountID, userId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getGroupsOfAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **userId** | **String**| The ID of the user whose details are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsersOfAccountGroup"></a>
# **getUsersOfAccountGroup**
> UserInfoRespList getUsersOfAccountGroup(accountID, groupID, limit, after, order, include, statusEq, statusIn, statusNin)

Get users of a group.

An endpoint for listing users of the group with details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String groupID = "groupID_example"; // String | The ID of the group whose users are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String statusEq = "statusEq_example"; // String | An optional filter for getting users by status.
String statusIn = "statusIn_example"; // String | An optional filter for getting users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter for excluding users with a specified set of statuses.
try {
    UserInfoRespList result = apiInstance.getUsersOfAccountGroup(accountID, groupID, limit, after, order, include, statusEq, statusIn, statusNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getUsersOfAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **groupID** | **String**| The ID of the group whose users are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **statusEq** | **String**| An optional filter for getting users by status. | [optional]
 **statusIn** | **String**| An optional filter for getting users with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter for excluding users with a specified set of statuses. | [optional]

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeAccountApiKeyFromGroups"></a>
# **removeAccountApiKeyFromGroups**
> UpdatedResponse removeAccountApiKeyFromGroups(accountID, apiKey, body)

Remove API key from groups.

An endpoint for removing API key from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String apiKey = "apiKey_example"; // String | The ID of the API key to be removed from the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.removeAccountApiKeyFromGroups(accountID, apiKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#removeAccountApiKeyFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **apiKey** | **String**| The ID of the API key to be removed from the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeAccountUserFromGroups"></a>
# **removeAccountUserFromGroups**
> UpdatedResponse removeAccountUserFromGroups(accountID, userId, body)

Remove user from groups.

An endpoint for removing user from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be removed from the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.removeAccountUserFromGroups(accountID, userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#removeAccountUserFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be removed from the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeApiKeysFromAccountGroup"></a>
# **removeApiKeysFromAccountGroup**
> UpdatedResponse removeApiKeysFromAccountGroup(accountID, groupID, body)

Remove API keys from a group.

An endpoint for removing API keys from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/api-keys -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String groupID = "groupID_example"; // String | A list of API keys to be removed from the group.
SubjectList body = new SubjectList(); // SubjectList | 
try {
    UpdatedResponse result = apiInstance.removeApiKeysFromAccountGroup(accountID, groupID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#removeApiKeysFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **groupID** | **String**| A list of API keys to be removed from the group. |
 **body** | [**SubjectList**](SubjectList.md)|  | [optional]

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUsersFromAccountGroup"></a>
# **removeUsersFromAccountGroup**
> UpdatedResponse removeUsersFromAccountGroup(accountID, groupID, body)

Remove users from a group.

An endpoint for removing users from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/users -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String groupID = "groupID_example"; // String | 
SubjectList body = new SubjectList(); // SubjectList | 
try {
    UpdatedResponse result = apiInstance.removeUsersFromAccountGroup(accountID, groupID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#removeUsersFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **groupID** | **String**|  |
 **body** | [**SubjectList**](SubjectList.md)|  | [optional]

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="resetAccountApiKeySecret"></a>
# **resetAccountApiKeySecret**
> ApiKeyInfoResp resetAccountApiKeySecret(accountID, apiKey)

Reset the secret key.

An endpoint for resetting the secret key of the API key.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey}/reset-secret -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String apiKey = "apiKey_example"; // String | The ID of the API key to be reset.
try {
    ApiKeyInfoResp result = apiInstance.resetAccountApiKeySecret(accountID, apiKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#resetAccountApiKeySecret");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **apiKey** | **String**| The ID of the API key to be reset. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAccount"></a>
# **updateAccount**
> AccountInfo updateAccount(accountID, body)

Update attributes of an existing account.

An endpoint for updating an account.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account-id} -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | The ID of the account to be updated.
AccountUpdateRootReq body = new AccountUpdateRootReq(); // AccountUpdateRootReq | Details of the account to be updated.
try {
    AccountInfo result = apiInstance.updateAccount(accountID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| The ID of the account to be updated. |
 **body** | [**AccountUpdateRootReq**](AccountUpdateRootReq.md)| Details of the account to be updated. |

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountApiKey"></a>
# **updateAccountApiKey**
> ApiKeyInfoResp updateAccountApiKey(accountID, apiKey, body)

Update API key details.

An endpoint for updating API key details.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey} -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String apiKey = "apiKey_example"; // String | The ID of the API key to be updated.
ApiKeyUpdateReq body = new ApiKeyUpdateReq(); // ApiKeyUpdateReq | New API key attributes to be stored.
try {
    ApiKeyInfoResp result = apiInstance.updateAccountApiKey(accountID, apiKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **apiKey** | **String**| The ID of the API key to be updated. |
 **body** | [**ApiKeyUpdateReq**](ApiKeyUpdateReq.md)| New API key attributes to be stored. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAccountCertificate"></a>
# **updateAccountCertificate**
> TrustedCertificateInternalResp updateAccountCertificate(accountID, certId, body)

Update trusted certificate.

An endpoint for updating existing trusted certificates.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to be updated.
TrustedCertificateUpdateReq body = new TrustedCertificateUpdateReq(); // TrustedCertificateUpdateReq | A trusted certificate object with attributes.
try {
    TrustedCertificateInternalResp result = apiInstance.updateAccountCertificate(accountID, certId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to be updated. |
 **body** | [**TrustedCertificateUpdateReq**](TrustedCertificateUpdateReq.md)| A trusted certificate object with attributes. |

### Return type

[**TrustedCertificateInternalResp**](TrustedCertificateInternalResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountGroupName"></a>
# **updateAccountGroupName**
> UpdatedResponse updateAccountGroupName(accountID, groupID, body)

Update the group name.

An endpoint for updating a group name.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/ -d &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String groupID = "groupID_example"; // String | The ID of the group to be updated.
GroupUpdateInfo body = new GroupUpdateInfo(); // GroupUpdateInfo | Details of the group to be created.
try {
    UpdatedResponse result = apiInstance.updateAccountGroupName(accountID, groupID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountGroupName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **groupID** | **String**| The ID of the group to be updated. |
 **body** | [**GroupUpdateInfo**](GroupUpdateInfo.md)| Details of the group to be created. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountUser"></a>
# **updateAccountUser**
> UserInfoResp updateAccountUser(accountID, userId, body)

Update user details.

An endpoint for updating user details.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id} -d &#39;{\&quot;username\&quot;: \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be updated.
UserUpdateReq body = new UserUpdateReq(); // UserUpdateReq | A user object with attributes.
try {
    UserInfoResp result = apiInstance.updateAccountUser(accountID, userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be updated. |
 **body** | [**UserUpdateReq**](UserUpdateReq.md)| A user object with attributes. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="validateAccountUserEmail"></a>
# **validateAccountUserEmail**
> Void validateAccountUserEmail(accountID, userId)

Validate the user email.

An endpoint for validating the user email.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id}/validate-email -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.iam.ApiException;
//import com.arm.mbed.cloud.sdk.internal.iam.Configuration;
//import com.arm.mbed.cloud.sdk.internal.iam.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountID = "accountID_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user whose email is validated.
try {
    Void result = apiInstance.validateAccountUserEmail(accountID, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#validateAccountUserEmail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| Account ID. |
 **userId** | **String**| The ID of the user whose email is validated. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

