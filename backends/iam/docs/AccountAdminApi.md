# AccountAdminApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCertificate**](AccountAdminApi.md#addCertificate) | **POST** v3/trusted-certificates | Upload a new trusted certificate.
[**addSubjectsToGroup**](AccountAdminApi.md#addSubjectsToGroup) | **POST** v3/policy-groups/{groupID} | Add members to a group.
[**createAccount**](AccountAdminApi.md#createAccount) | **POST** v3/accounts | Create a new account.
[**createUser**](AccountAdminApi.md#createUser) | **POST** v3/users | Create a new user.
[**deleteUser**](AccountAdminApi.md#deleteUser) | **DELETE** v3/users/{user-id} | Delete a user.
[**getAccountInfo**](AccountAdminApi.md#getAccountInfo) | **GET** v3/accounts/{accountID} | Get account info.
[**getAllAccounts**](AccountAdminApi.md#getAllAccounts) | **GET** v3/accounts | Get all accounts.
[**getAllUsers**](AccountAdminApi.md#getAllUsers) | **GET** v3/users | Get the details of all users.
[**getUser**](AccountAdminApi.md#getUser) | **GET** v3/users/{user-id} | Details of a user.
[**getUsersOfGroup**](AccountAdminApi.md#getUsersOfGroup) | **GET** v3/policy-groups/{groupID}/users | Get users of a group.
[**removeUsersFromGroup**](AccountAdminApi.md#removeUsersFromGroup) | **DELETE** v3/policy-groups/{groupID}/users | Remove users from a group.
[**updateAccount**](AccountAdminApi.md#updateAccount) | **PUT** v3/accounts/{accountID} | Update attributes of an existing account.
[**updateMyAccount**](AccountAdminApi.md#updateMyAccount) | **PUT** v3/accounts/me | Updates attributes of the account.
[**updateUser**](AccountAdminApi.md#updateUser) | **PUT** v3/users/{user-id} | Update user details.


<a name="addCertificate"></a>
# **addCertificate**
> TrustedCertificateResp addCertificate(body)

Upload a new trusted certificate.

An endpoint for uploading new trusted certificates.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
TrustedCertificateReq body = new TrustedCertificateReq(); // TrustedCertificateReq | A trusted certificate object with attributes.
try {
    TrustedCertificateResp result = apiInstance.addCertificate(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#addCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TrustedCertificateReq**](TrustedCertificateReq.md)| A trusted certificate object with attributes. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addSubjectsToGroup"></a>
# **addSubjectsToGroup**
> UpdatedResponse addSubjectsToGroup(groupID, body)

Add members to a group.

An endpoint for adding users and API keys to groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String groupID = "groupID_example"; // String | The ID of the group to be updated.
SubjectList body = new SubjectList(); // SubjectList | A list of users and API keys to be added to the group.
try {
    UpdatedResponse result = apiInstance.addSubjectsToGroup(groupID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#addSubjectsToGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupID** | **String**| The ID of the group to be updated. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users and API keys to be added to the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
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
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
AccountCreationReq body = new AccountCreationReq(); // AccountCreationReq | Details of the account to be created.
String action = "create"; // String | Action, either 'create' or 'enroll'.
try {
    AccountCreationResp result = apiInstance.createAccount(body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#createAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AccountCreationReq**](AccountCreationReq.md)| Details of the account to be created. |
 **action** | **String**| Action, either &#39;create&#39; or &#39;enroll&#39;. | [optional] [default to create]

### Return type

[**AccountCreationResp**](AccountCreationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createUser"></a>
# **createUser**
> UserInfoResp createUser(body, action)

Create a new user.

An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
UserCreationReq body = new UserCreationReq(); // UserCreationReq | A user object with attributes.
String action = "create"; // String | Action, either 'create' or 'invite'.
try {
    UserInfoResp result = apiInstance.createUser(body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserCreationReq**](UserCreationReq.md)| A user object with attributes. |
 **action** | **String**| Action, either &#39;create&#39; or &#39;invite&#39;. | [optional] [default to create]

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteUser"></a>
# **deleteUser**
> Void deleteUser(userId)

Delete a user.

An endpoint for deleting a user.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID of the user to be deleted.
try {
    Void result = apiInstance.deleteUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountInfo"></a>
# **getAccountInfo**
> AccountInfo getAccountInfo(accountID, include)

Get account info.

Returns detailed information about the account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String accountID = "accountID_example"; // String | The ID or alias of the account to be fetched.
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: limits, policies, sub_accounts
try {
    AccountInfo result = apiInstance.getAccountInfo(accountID, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getAccountInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountID** | **String**| The ID or alias of the account to be fetched. |
 **include** | **String**| Comma separated additional data to return. Currently supported: limits, policies, sub_accounts | [optional]

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccounts"></a>
# **getAllAccounts**
> AccountInfoList getAllAccounts(statusEq, tierEq, parentEq, endMarketEq, limit, after, include, format)

Get all accounts.

Returns an array of account objects, optionally filtered by status and tier level.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String statusEq = "statusEq_example"; // String | An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED.
String tierEq = "tierEq_example"; // String | An optional filter for tier level, must be 0, 1 or omitted.
String parentEq = "parentEq_example"; // String | An optional filter for parent account ID.
String endMarketEq = "endMarketEq_example"; // String | An optional filter for account end market.
Integer limit = 1000; // Integer | The number of results to return (2-1000), default is 1000.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count,limits
String format = "format_example"; // String | Format information for the response to the query, supported: format=breakdown.
try {
    AccountInfoList result = apiInstance.getAllAccounts(statusEq, tierEq, parentEq, endMarketEq, limit, after, include, format);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getAllAccounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **statusEq** | **String**| An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED. | [optional]
 **tierEq** | **String**| An optional filter for tier level, must be 0, 1 or omitted. | [optional]
 **parentEq** | **String**| An optional filter for parent account ID. | [optional]
 **endMarketEq** | **String**| An optional filter for account end market. | [optional]
 **limit** | **Integer**| The number of results to return (2-1000), default is 1000. | [optional] [default to 1000]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count,limits | [optional]
 **format** | **String**| Format information for the response to the query, supported: format&#x3D;breakdown. | [optional]

### Return type

[**AccountInfoList**](AccountInfoList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllUsers"></a>
# **getAllUsers**
> UserInfoRespList getAllUsers(limit, after, order, include, statusEq)

Get the details of all users.

An endpoint for retrieving the details of all users.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String statusEq = "statusEq_example"; // String | Filter for status, for example active or reset
try {
    UserInfoRespList result = apiInstance.getAllUsers(limit, after, order, include, statusEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getAllUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **statusEq** | **String**| Filter for status, for example active or reset | [optional]

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUser"></a>
# **getUser**
> UserInfoResp getUser(userId)

Details of a user.

An endpoint for retrieving the details of a user.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID or name of the user whose details are retrieved.
try {
    UserInfoResp result = apiInstance.getUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID or name of the user whose details are retrieved. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsersOfGroup"></a>
# **getUsersOfGroup**
> UserInfoRespList getUsersOfGroup(groupID, limit, after, order, include)

Get users of a group.

An endpoint for listing the users of a group with details.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String groupID = "groupID_example"; // String | The ID of the group whose users are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    UserInfoRespList result = apiInstance.getUsersOfGroup(groupID, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getUsersOfGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupID** | **String**| The ID of the group whose users are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeUsersFromGroup"></a>
# **removeUsersFromGroup**
> UpdatedResponse removeUsersFromGroup(groupID, body)

Remove users from a group.

An endpoint for removing users from groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String groupID = "groupID_example"; // String | The ID of the group whose users are removed.
SubjectList body = new SubjectList(); // SubjectList | A list of users to be removed from the group.
try {
    UpdatedResponse result = apiInstance.removeUsersFromGroup(groupID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#removeUsersFromGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupID** | **String**| The ID of the group whose users are removed. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users to be removed from the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
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
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String accountID = "accountID_example"; // String | The ID of the account to be updated.
AccountUpdateRootReq body = new AccountUpdateRootReq(); // AccountUpdateRootReq | Details of the account to be updated.
try {
    AccountInfo result = apiInstance.updateAccount(accountID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#updateAccount");
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

<a name="updateMyAccount"></a>
# **updateMyAccount**
> AccountInfo updateMyAccount(body)

Updates attributes of the account.

An endpoint for updating the account. Example usage: curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/me -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer AUTH_TOKEN&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
AccountUpdateReq body = new AccountUpdateReq(); // AccountUpdateReq | Details of the account to be updated.
try {
    AccountInfo result = apiInstance.updateMyAccount(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#updateMyAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AccountUpdateReq**](AccountUpdateReq.md)| Details of the account to be updated. |

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUser"></a>
# **updateUser**
> UserInfoResp updateUser(userId, body)

Update user details.

An endpoint for updating user details.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID of the user whose details are updated.
UserUpdateReq body = new UserUpdateReq(); // UserUpdateReq | A user object with attributes.
try {
    UserInfoResp result = apiInstance.updateUser(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user whose details are updated. |
 **body** | [**UserUpdateReq**](UserUpdateReq.md)| A user object with attributes. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

