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
[**createAccountUser**](AggregatorAccountAdminApi.md#createAccountUser) | **POST** v3/accounts/{accountID}/users | Create a new user.
[**deleteAccountApiKey**](AggregatorAccountAdminApi.md#deleteAccountApiKey) | **DELETE** v3/accounts/{accountID}/api-keys/{apiKey} | Delete the API key.
[**deleteAccountCertificate**](AggregatorAccountAdminApi.md#deleteAccountCertificate) | **DELETE** v3/accounts/{accountID}/trusted-certificates/{cert-id} | Delete trusted certificate by ID.
[**deleteAccountUser**](AggregatorAccountAdminApi.md#deleteAccountUser) | **DELETE** v3/accounts/{accountID}/users/{user-id} | Delete a user.
[**getAccountApiKey**](AggregatorAccountAdminApi.md#getAccountApiKey) | **GET** v3/accounts/{accountID}/api-keys/{apiKey} | Get API key details.
[**getAccountCertificate**](AggregatorAccountAdminApi.md#getAccountCertificate) | **GET** v3/accounts/{accountID}/trusted-certificates/{cert-id} | Get trusted certificate by ID.
[**getAccountGroupSummary**](AggregatorAccountAdminApi.md#getAccountGroupSummary) | **GET** v3/accounts/{accountID}/policy-groups/{groupID} | Get group information.
[**getAccountInfo**](AggregatorAccountAdminApi.md#getAccountInfo) | **GET** v3/accounts/{accountID} | Get account info.
[**getAccountUser**](AggregatorAccountAdminApi.md#getAccountUser) | **GET** v3/accounts/{accountID}/users/{user-id} | Details of the user.
[**getAllAccountApiKeys**](AggregatorAccountAdminApi.md#getAllAccountApiKeys) | **GET** v3/accounts/{accountID}/api-keys | Get all API keys.
[**getAllAccountCertificates**](AggregatorAccountAdminApi.md#getAllAccountCertificates) | **GET** v3/accounts/{accountID}/trusted-certificates | Get all trusted certificates.
[**getAllAccountGroups**](AggregatorAccountAdminApi.md#getAllAccountGroups) | **GET** v3/accounts/{accountID}/policy-groups | Get all group information.
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
[**updateAccountUser**](AggregatorAccountAdminApi.md#updateAccountUser) | **PUT** v3/accounts/{accountID}/users/{user-id} | Update user details.
[**validateAccountUserEmail**](AggregatorAccountAdminApi.md#validateAccountUserEmail) | **POST** v3/accounts/{accountID}/users/{user-id}/validate-email | Validate the user email.


<a name="addAccountApiKeyToGroups"></a>
# **addAccountApiKeyToGroups**
> UpdatedResponse addAccountApiKeyToGroups(accountID, apiKey, body)

Add API key to a list of groups.

An endpoint for adding API key to groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for uploading new trusted certificates.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for adding user to groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for adding users and API keys to groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for checking API key.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for creating a new account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
AccountCreationReq body = new AccountCreationReq(); // AccountCreationReq | Details of the account to be created.
String action = "create"; // String | Action, either 'create', 'enroll' or 'enrollment_link'.
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
 **action** | **String**| Action, either &#39;create&#39;, &#39;enroll&#39; or &#39;enrollment_link&#39;. | [optional] [default to create]

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

An endpoint for creating a new API key. There is no default value for the owner ID and it must be from the same account where the new API key is created.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

<a name="createAccountUser"></a>
# **createAccountUser**
> UserInfoResp createAccountUser(accountID, body, action)

Create a new user.

An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for deleting an API key.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for deleting the trusted certificate.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

<a name="deleteAccountUser"></a>
# **deleteAccountUser**
> Void deleteAccountUser(accountID, userId)

Delete a user.

An endpoint for deleting a user.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for retrieving API key details.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for retrieving a trusted certificate by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for getting general information about the group.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

Returns detailed information about the account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

<a name="getAccountUser"></a>
# **getAccountUser**
> MyUserInfoResp getAccountUser(accountID, userId, scratchCodes, properties)

Details of the user.

An endpoint for retrieving details of the user.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
String scratchCodes = "scratchCodes_example"; // String | Request to regenerate new emergency scratch codes.
String properties = "properties_example"; // String | Request to return account specific user property values according to the given property name.
try {
    MyUserInfoResp result = apiInstance.getAccountUser(accountID, userId, scratchCodes, properties);
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
 **scratchCodes** | **String**| Request to regenerate new emergency scratch codes. | [optional]
 **properties** | **String**| Request to return account specific user property values according to the given property name. | [optional]

### Return type

[**MyUserInfoResp**](MyUserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountApiKeys"></a>
# **getAllAccountApiKeys**
> ApiKeyInfoRespList getAllAccountApiKeys(accountID, limit, after, order, include, keyEq, ownerEq)

Get all API keys.

An endpoint for retrieving the API keys in an array, optionally filtered by the owner.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for retrieving trusted certificates in an array.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
String issuerLike = "issuerLike_example"; // String | Filter for issuer
String subjectLike = "subjectLike_example"; // String | Filter for subject
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
 **issuerLike** | **String**| Filter for issuer | [optional]
 **subjectLike** | **String**| Filter for subject | [optional]

### Return type

[**TrustedCertificateInternalRespList**](TrustedCertificateInternalRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountGroups"></a>
# **getAllAccountGroups**
> List&lt;GroupSummary&gt; getAllAccountGroups(accountID, limit, after, order, include, nameEq)

Get all group information.

An endpoint for retrieving all group information.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
    List<GroupSummary> result = apiInstance.getAllAccountGroups(accountID, limit, after, order, include, nameEq);
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

[**List&lt;GroupSummary&gt;**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountUsers"></a>
# **getAllAccountUsers**
> UserInfoRespList getAllAccountUsers(accountID, limit, after, order, include, emailEq, statusEq)

Get all user details.

An endpoint for retrieving details of all users.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
try {
    UserInfoRespList result = apiInstance.getAllAccountUsers(accountID, limit, after, order, include, emailEq, statusEq);
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

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccounts"></a>
# **getAllAccounts**
> AccountInfoList getAllAccounts(statusEq, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties)

Get all accounts.

Returns an array of account objects, optionally filtered by status and tier level.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String statusEq = "statusEq_example"; // String | An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED.
String tierEq = "tierEq_example"; // String | An optional filter for tier level, must be 0, 1, 2, 98, 99 or omitted.
String parentEq = "parentEq_example"; // String | An optional filter for parent account ID.
String endMarketEq = "endMarketEq_example"; // String | An optional filter for account end market.
String countryLike = "countryLike_example"; // String | An optional filter for account country.
Integer limit = 1000; // Integer | The number of results to return (2-1000), default is 1000.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC. Default value is ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: limits, policies, sub_accounts
String format = "format_example"; // String | Format information for the response to the query, supported: format=breakdown.
String properties = "properties_example"; // String | Property name to be returned from account specific properties.
try {
    AccountInfoList result = apiInstance.getAllAccounts(statusEq, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties);
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
 **tierEq** | **String**| An optional filter for tier level, must be 0, 1, 2, 98, 99 or omitted. | [optional]
 **parentEq** | **String**| An optional filter for parent account ID. | [optional]
 **endMarketEq** | **String**| An optional filter for account end market. | [optional]
 **countryLike** | **String**| An optional filter for account country. | [optional]
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

An endpoint for listing the API keys of the group with details.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for retrieving groups of the API key.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for retrieving groups of the user.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
> UserInfoRespList getUsersOfAccountGroup(accountID, groupID, limit, after, order, include)

Get users of a group.

An endpoint for listing users of the group with details.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
try {
    UserInfoRespList result = apiInstance.getUsersOfAccountGroup(accountID, groupID, limit, after, order, include);
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

An endpoint for removing API key from groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for removing user from groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for removing API keys from groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for removing users from groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for resetting the secret key of the API key.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for updating an account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

An endpoint for updating API key details.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

<a name="updateAccountUser"></a>
# **updateAccountUser**
> UserUpdateResp updateAccountUser(accountID, userId, body)

Update user details.

An endpoint for updating user details.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
AdminUserUpdateReq body = new AdminUserUpdateReq(); // AdminUserUpdateReq | A user object with attributes.
try {
    UserUpdateResp result = apiInstance.updateAccountUser(accountID, userId, body);
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
 **body** | [**AdminUserUpdateReq**](AdminUserUpdateReq.md)| A user object with attributes. |

### Return type

[**UserUpdateResp**](UserUpdateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="validateAccountUserEmail"></a>
# **validateAccountUserEmail**
> Void validateAccountUserEmail(accountID, userId)

Validate the user email.

An endpoint for validating the user email.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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

