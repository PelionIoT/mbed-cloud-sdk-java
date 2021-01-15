# TenantAccountsApplicationsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAccountApplicationToGroups**](TenantAccountsApplicationsApi.md#addAccountApplicationToGroups) | **POST** v3/accounts/{account_id}/applications/{application_id}/groups/add | Add application to a list of groups.
[**createAccountApplication**](TenantAccountsApplicationsApi.md#createAccountApplication) | **POST** v3/accounts/{account_id}/applications | Create a new application.
[**createAccountApplicationAccessKey**](TenantAccountsApplicationsApi.md#createAccountApplicationAccessKey) | **POST** v3/accounts/{account_id}/applications/{application_id}/access-keys | Create a new application access key.
[**deleteAccountApplication**](TenantAccountsApplicationsApi.md#deleteAccountApplication) | **DELETE** v3/accounts/{account_id}/applications/{application_id} | Delete application.
[**deleteAccountApplicationAccessKey**](TenantAccountsApplicationsApi.md#deleteAccountApplicationAccessKey) | **DELETE** v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id} | Delete access key associated with the application.
[**getAccountApplication**](TenantAccountsApplicationsApi.md#getAccountApplication) | **GET** v3/accounts/{account_id}/applications/{application_id} | Get application.
[**getAccountApplicationAccessKey**](TenantAccountsApplicationsApi.md#getAccountApplicationAccessKey) | **GET** v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id} | Get access key.
[**getAllAccountApplicationAccessKeys**](TenantAccountsApplicationsApi.md#getAllAccountApplicationAccessKeys) | **GET** v3/accounts/{account_id}/applications/{application_id}/access-keys | Get all access keys associated with the application.
[**getAllAccountApplications**](TenantAccountsApplicationsApi.md#getAllAccountApplications) | **GET** v3/accounts/{account_id}/applications | Get all applications.
[**getGroupsOfAccountApplication**](TenantAccountsApplicationsApi.md#getGroupsOfAccountApplication) | **GET** v3/accounts/{account_id}/applications/{application_id}/groups | Get policy groups of an application.
[**removeAccountApplicationFromGroups**](TenantAccountsApplicationsApi.md#removeAccountApplicationFromGroups) | **POST** v3/accounts/{account_id}/applications/{application_id}/groups/remove | Remove application from groups.
[**updateAccountApplication**](TenantAccountsApplicationsApi.md#updateAccountApplication) | **PUT** v3/accounts/{account_id}/applications/{application_id} | Update application details.
[**updateAccountApplicationAccessKey**](TenantAccountsApplicationsApi.md#updateAccountApplicationAccessKey) | **PUT** v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id} | Update access key details.


<a name="addAccountApplicationToGroups"></a>
# **addAccountApplicationToGroups**
> Void addAccountApplicationToGroups(accountId, applicationId, body)

Add application to a list of groups.

Add application to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/groups/add \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application to add to the group.
GroupIdList body = new GroupIdList(); // GroupIdList | A list of IDs of the groups to update.
try {
    Void result = apiInstance.addAccountApplicationToGroups(accountId, applicationId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#addAccountApplicationToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application to add to the group. |
 **body** | [**GroupIdList**](GroupIdList.md)| A list of IDs of the groups to update. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountApplication"></a>
# **createAccountApplication**
> Application createAccountApplication(accountId, body)

Create a new application.

Create a new application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications -d &#39;{\&quot;name\&quot;: \&quot;MyApplication1\&quot;}&#39; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
Application body = new Application(); // Application | The details of the application to create.
try {
    Application result = apiInstance.createAccountApplication(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#createAccountApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **body** | [**Application**](Application.md)| The details of the application to create. |

### Return type

[**Application**](Application.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountApplicationAccessKey"></a>
# **createAccountApplicationAccessKey**
> AccessKey createAccountApplicationAccessKey(accountId, applicationId, body)

Create a new application access key.

Create a new access key for the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application.
AccessKey body = new AccessKey(); // AccessKey | The details of the access key to create.
try {
    AccessKey result = apiInstance.createAccountApplicationAccessKey(accountId, applicationId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#createAccountApplicationAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application. |
 **body** | [**AccessKey**](AccessKey.md)| The details of the access key to create. |

### Return type

[**AccessKey**](AccessKey.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccountApplication"></a>
# **deleteAccountApplication**
> Void deleteAccountApplication(accountId, applicationId)

Delete application.

Delete the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application to delete.
try {
    Void result = apiInstance.deleteAccountApplication(accountId, applicationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#deleteAccountApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountApplicationAccessKey"></a>
# **deleteAccountApplicationAccessKey**
> Void deleteAccountApplicationAccessKey(accountId, applicationId, accessKeyId)

Delete access key associated with the application.

Delete the access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application.
String accessKeyId = "accessKeyId_example"; // String | The ID of the access key to delete.
try {
    Void result = apiInstance.deleteAccountApplicationAccessKey(accountId, applicationId, accessKeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#deleteAccountApplicationAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application. |
 **accessKeyId** | **String**| The ID of the access key to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountApplication"></a>
# **getAccountApplication**
> Application getAccountApplication(accountId, applicationId)

Get application.

Retrieve details of an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application to retrieve.
try {
    Application result = apiInstance.getAccountApplication(accountId, applicationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#getAccountApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application to retrieve. |

### Return type

[**Application**](Application.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountApplicationAccessKey"></a>
# **getAccountApplicationAccessKey**
> AccessKey getAccountApplicationAccessKey(accountId, applicationId, accessKeyId)

Get access key.

Retrieve details of an access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application.
String accessKeyId = "accessKeyId_example"; // String | The ID of the access key to retrieve.
try {
    AccessKey result = apiInstance.getAccountApplicationAccessKey(accountId, applicationId, accessKeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#getAccountApplicationAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application. |
 **accessKeyId** | **String**| The ID of the access key to retrieve. |

### Return type

[**AccessKey**](AccessKey.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountApplicationAccessKeys"></a>
# **getAllAccountApplicationAccessKeys**
> AccessKeyList getAllAccountApplicationAccessKeys(accountId, applicationId, limit, after, order, include, statusEq)

Get all access keys associated with the application.

Retrieve an array of access keys associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String statusEq = "statusEq_example"; // String | Status filter.
try {
    AccessKeyList result = apiInstance.getAllAccountApplicationAccessKeys(accountId, applicationId, limit, after, order, include, statusEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#getAllAccountApplicationAccessKeys");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]
 **statusEq** | **String**| Status filter. | [optional]

### Return type

[**AccessKeyList**](AccessKeyList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountApplications"></a>
# **getAllAccountApplications**
> ApplicationList getAllAccountApplications(accountId, limit, after, order, include, statusEq)

Get all applications.

Retrieve an array of applications. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String statusEq = "statusEq_example"; // String | Status filter.
try {
    ApplicationList result = apiInstance.getAllAccountApplications(accountId, limit, after, order, include, statusEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#getAllAccountApplications");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]
 **statusEq** | **String**| Status filter. | [optional]

### Return type

[**ApplicationList**](ApplicationList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfAccountApplication"></a>
# **getGroupsOfAccountApplication**
> GroupSummaryList getGroupsOfAccountApplication(accountId, applicationId, limit, after, order, include)

Get policy groups of an application.

Retrieve an array of policy groups associated with an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/groups \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    GroupSummaryList result = apiInstance.getGroupsOfAccountApplication(accountId, applicationId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#getGroupsOfAccountApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeAccountApplicationFromGroups"></a>
# **removeAccountApplicationFromGroups**
> Void removeAccountApplicationFromGroups(accountId, applicationId, body)

Remove application from groups.

Remove application from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/groups/remove \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application to remove from the group.
GroupIdList body = new GroupIdList(); // GroupIdList | A list of IDs of the groups to update.
try {
    Void result = apiInstance.removeAccountApplicationFromGroups(accountId, applicationId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#removeAccountApplicationFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application to remove from the group. |
 **body** | [**GroupIdList**](GroupIdList.md)| A list of IDs of the groups to update. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountApplication"></a>
# **updateAccountApplication**
> ApiKeyInfoResp updateAccountApplication(accountId, applicationId, body)

Update application details.

Update application details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestApplication25\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application to update.
Application body = new Application(); // Application | New applicationattributes to store.
try {
    ApiKeyInfoResp result = apiInstance.updateAccountApplication(accountId, applicationId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#updateAccountApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application to update. |
 **body** | [**Application**](Application.md)| New applicationattributes to store. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAccountApplicationAccessKey"></a>
# **updateAccountApplicationAccessKey**
> AccessKey updateAccountApplicationAccessKey(accountId, applicationId, accessKeyId, body)

Update access key details.

Update access key details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestAccessKey\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsApplicationsApi apiInstance = new TenantAccountsApplicationsApi();
String accountId = "accountId_example"; // String | The ID of the account to retrieve.
String applicationId = "applicationId_example"; // String | The ID of the application.
String accessKeyId = "accessKeyId_example"; // String | The ID of the access key to update.
AccessKey body = new AccessKey(); // AccessKey | New access key attributes to store.
try {
    AccessKey result = apiInstance.updateAccountApplicationAccessKey(accountId, applicationId, accessKeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsApplicationsApi#updateAccountApplicationAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to retrieve. |
 **applicationId** | **String**| The ID of the application. |
 **accessKeyId** | **String**| The ID of the access key to update. |
 **body** | [**AccessKey**](AccessKey.md)| New access key attributes to store. |

### Return type

[**AccessKey**](AccessKey.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

