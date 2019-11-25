# TenantAccountsApiKeysApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAccountApiKeyToGroups**](TenantAccountsApiKeysApi.md#addAccountApiKeyToGroups) | **POST** v3/accounts/{account_id}/api-keys/{apikey_id}/groups | Add API key to a list of groups.
[**addAccountApiKeyToListedGroups**](TenantAccountsApiKeysApi.md#addAccountApiKeyToListedGroups) | **POST** v3/accounts/{account_id}/api-keys/{apikey_id}/groups/add | Add API key to a list of groups.
[**createAccountApiKey**](TenantAccountsApiKeysApi.md#createAccountApiKey) | **POST** v3/accounts/{account_id}/api-keys | Create a new API key.
[**deleteAccountApiKey**](TenantAccountsApiKeysApi.md#deleteAccountApiKey) | **DELETE** v3/accounts/{account_id}/api-keys/{apikey_id} | Delete the API key.
[**getAccountApiKey**](TenantAccountsApiKeysApi.md#getAccountApiKey) | **GET** v3/accounts/{account_id}/api-keys/{apikey_id} | Get API key details.
[**getAllAccountApiKeys**](TenantAccountsApiKeysApi.md#getAllAccountApiKeys) | **GET** v3/accounts/{account_id}/api-keys | Get all API keys.
[**getGroupsOfAccountApikey**](TenantAccountsApiKeysApi.md#getGroupsOfAccountApikey) | **GET** v3/accounts/{account_id}/api-keys/{apikey_id}/groups | Get groups associated with the API key.
[**removeAccountApiKeyFromGroups**](TenantAccountsApiKeysApi.md#removeAccountApiKeyFromGroups) | **DELETE** v3/accounts/{account_id}/api-keys/{apikey_id}/groups | Remove API key from groups.
[**removeAccountApiKeyFromListedGroups**](TenantAccountsApiKeysApi.md#removeAccountApiKeyFromListedGroups) | **POST** v3/accounts/{account_id}/api-keys/{apikey_id}/groups/remove | Remove API key from groups.
[**resetAccountApiKeySecret**](TenantAccountsApiKeysApi.md#resetAccountApiKeySecret) | **POST** v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret | Reset the secret key.
[**updateAccountApiKey**](TenantAccountsApiKeysApi.md#updateAccountApiKey) | **PUT** v3/accounts/{account_id}/api-keys/{apikey_id} | Update API key details.


<a name="addAccountApiKeyToGroups"></a>
# **addAccountApiKeyToGroups**
> ApiKeyInfoResp addAccountApiKeyToGroups(accountId, apikeyId, body)

Add API key to a list of groups.

Add API key to groups.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to add to the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of groups to update.
try {
    ApiKeyInfoResp result = apiInstance.addAccountApiKeyToGroups(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#addAccountApiKeyToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to add to the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of groups to update. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addAccountApiKeyToListedGroups"></a>
# **addAccountApiKeyToListedGroups**
> ApiKeyInfoResp addAccountApiKeyToListedGroups(accountId, apikeyId, body)

Add API key to a list of groups.

Add an API key to groups.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups/add \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | The ID of the Account.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to add to the group.
GroupIdList body = new GroupIdList(); // GroupIdList | A list of IDs of groups to update.
try {
    ApiKeyInfoResp result = apiInstance.addAccountApiKeyToListedGroups(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#addAccountApiKeyToListedGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the Account. |
 **apikeyId** | **String**| The ID of the API key to add to the group. |
 **body** | [**GroupIdList**](GroupIdList.md)| A list of IDs of groups to update. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountApiKey"></a>
# **createAccountApiKey**
> ApiKeyInfoResp createAccountApiKey(accountId, body)

Create a new API key.

Create a new API key. There is no default value for the owner ID, and it must be from the same account where the new API key is created.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
ApiKeyInfoReq body = new ApiKeyInfoReq(); // ApiKeyInfoReq | Details of the API key to create.
try {
    ApiKeyInfoResp result = apiInstance.createAccountApiKey(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#createAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**ApiKeyInfoReq**](ApiKeyInfoReq.md)| Details of the API key to create. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccountApiKey"></a>
# **deleteAccountApiKey**
> Void deleteAccountApiKey(accountId, apikeyId)

Delete the API key.

Delete an API key.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to delete.
try {
    Void result = apiInstance.deleteAccountApiKey(accountId, apikeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#deleteAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountApiKey"></a>
# **getAccountApiKey**
> ApiKeyInfoResp getAccountApiKey(accountId, apikeyId)

Get API key details.

Retrieve API key details.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\  -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to retrieve.
try {
    ApiKeyInfoResp result = apiInstance.getAccountApiKey(accountId, apikeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#getAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to retrieve. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountApiKeys"></a>
# **getAllAccountApiKeys**
> ApiKeyInfoRespList getAllAccountApiKeys(accountId, limit, after, order, include, keyEq, ownerEq)

Get all API keys.

Retrieve API keys in an array, optionally filtered by the owner.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String keyEq = "keyEq_example"; // String | API key filter. Do not include the private portion of the API key (the last 32 characters).
String ownerEq = "ownerEq_example"; // String | Owner name filter.
try {
    ApiKeyInfoRespList result = apiInstance.getAllAccountApiKeys(accountId, limit, after, order, include, keyEq, ownerEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#getAllAccountApiKeys");
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
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]
 **keyEq** | **String**| API key filter. Do not include the private portion of the API key (the last 32 characters). | [optional]
 **ownerEq** | **String**| Owner name filter. | [optional]

### Return type

[**ApiKeyInfoRespList**](ApiKeyInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfAccountApikey"></a>
# **getGroupsOfAccountApikey**
> GroupSummaryList getGroupsOfAccountApikey(accountId, apikeyId, limit, after, order, include)

Get groups associated with the API key.

Retrieve groups associated with the API key.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    GroupSummaryList result = apiInstance.getGroupsOfAccountApikey(accountId, apikeyId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#getGroupsOfAccountApikey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeAccountApiKeyFromGroups"></a>
# **removeAccountApiKeyFromGroups**
> ApiKeyInfoResp removeAccountApiKeyFromGroups(accountId, apikeyId, body)

Remove API key from groups.

Remove API key from groups.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to remove from the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to update.
try {
    ApiKeyInfoResp result = apiInstance.removeAccountApiKeyFromGroups(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#removeAccountApiKeyFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to remove from the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to update. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeAccountApiKeyFromListedGroups"></a>
# **removeAccountApiKeyFromListedGroups**
> ApiKeyInfoResp removeAccountApiKeyFromListedGroups(accountId, apikeyId, body)

Remove API key from groups.

Remove an API key from groups.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups/remove \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | The ID of the account.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to remove from the group.
GroupIdList body = new GroupIdList(); // GroupIdList | A list of IDs of the groups to update.
try {
    ApiKeyInfoResp result = apiInstance.removeAccountApiKeyFromListedGroups(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#removeAccountApiKeyFromListedGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **apikeyId** | **String**| The ID of the API key to remove from the group. |
 **body** | [**GroupIdList**](GroupIdList.md)| A list of IDs of the groups to update. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="resetAccountApiKeySecret"></a>
# **resetAccountApiKeySecret**
> ApiKeyInfoResp resetAccountApiKeySecret(accountId, apikeyId, body)

Reset the secret key.

Reset the secret key of the API key.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to reset.
ApiKeyUpdateReq body = new ApiKeyUpdateReq(); // ApiKeyUpdateReq | New API key attributes to be stored.
try {
    ApiKeyInfoResp result = apiInstance.resetAccountApiKeySecret(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#resetAccountApiKeySecret");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to reset. |
 **body** | [**ApiKeyUpdateReq**](ApiKeyUpdateReq.md)| New API key attributes to be stored. | [optional]

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAccountApiKey"></a>
# **updateAccountApiKey**
> ApiKeyInfoResp updateAccountApiKey(accountId, apikeyId, body)

Update API key details.

Update API key details.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApiKeysApi apiInstance = new TenantAccountsApiKeysApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to update.
ApiKeyUpdateReq body = new ApiKeyUpdateReq(); // ApiKeyUpdateReq | New API key attributes to be stored.
try {
    ApiKeyInfoResp result = apiInstance.updateAccountApiKey(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApiKeysApi#updateAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to update. |
 **body** | [**ApiKeyUpdateReq**](ApiKeyUpdateReq.md)| New API key attributes to be stored. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

