# AccountApplicationsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addApplicationToGroups**](AccountApplicationsApi.md#addApplicationToGroups) | **POST** v3/applications/{application_id}/groups/add | Add application to a list of groups.
[**createApplication**](AccountApplicationsApi.md#createApplication) | **POST** v3/applications | Create a new application.
[**createApplicationAccessKey**](AccountApplicationsApi.md#createApplicationAccessKey) | **POST** v3/applications/{application_id}/access-keys | Create a new applicationaccess key.
[**deleteApplication**](AccountApplicationsApi.md#deleteApplication) | **DELETE** v3/applications/{application_id} | Delete application.
[**deleteApplicationAccessKey**](AccountApplicationsApi.md#deleteApplicationAccessKey) | **DELETE** v3/applications/{application_id}/access-keys/{access_key_id} | Delete access key associated with the application.
[**getAllApplicationAccessKeys**](AccountApplicationsApi.md#getAllApplicationAccessKeys) | **GET** v3/applications/{application_id}/access-keys | Get all access keys associated with the application.
[**getAllApplications**](AccountApplicationsApi.md#getAllApplications) | **GET** v3/applications | Get all applications.
[**getApplication**](AccountApplicationsApi.md#getApplication) | **GET** v3/applications/{application_id} | Get application.
[**getApplicationAccessKey**](AccountApplicationsApi.md#getApplicationAccessKey) | **GET** v3/applications/{application_id}/access-keys/{access_key_id} | Get access key.
[**getGroupsOfApplication**](AccountApplicationsApi.md#getGroupsOfApplication) | **GET** v3/applications/{application_id}/groups | Get policy groups of an application.
[**removeApplicationFromGroups**](AccountApplicationsApi.md#removeApplicationFromGroups) | **POST** v3/applications/{application_id}/groups/remove | Remove application from groups.
[**updateApplication**](AccountApplicationsApi.md#updateApplication) | **PUT** v3/applications/{application_id} | Update applicationdetails.
[**updateApplicationAccessKey**](AccountApplicationsApi.md#updateApplicationAccessKey) | **PUT** v3/applications/{application_id}/access-keys/{access_key_id} | Update access key details.


<a name="addApplicationToGroups"></a>
# **addApplicationToGroups**
> Void addApplicationToGroups(applicationId, body)

Add application to a list of groups.

Add application to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups/add \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application to add to the group.
GroupIdList body = new GroupIdList(); // GroupIdList | A list of IDs of the groups to update.
try {
    Void result = apiInstance.addApplicationToGroups(applicationId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#addApplicationToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| The ID of the application to add to the group. |
 **body** | [**GroupIdList**](GroupIdList.md)| A list of IDs of the groups to update. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createApplication"></a>
# **createApplication**
> Application createApplication(body)

Create a new application.

Create a new application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/applications -d &#39;{\&quot;name\&quot;: \&quot;MyApplication1\&quot;}&#39; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
Application body = new Application(); // Application | The details of the application to create.
try {
    Application result = apiInstance.createApplication(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#createApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Application**](Application.md)| The details of the application to create. |

### Return type

[**Application**](Application.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createApplicationAccessKey"></a>
# **createApplicationAccessKey**
> AccessKey createApplicationAccessKey(applicationId, body)

Create a new applicationaccess key.

Create a new access key for the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application.
AccessKey body = new AccessKey(); // AccessKey | The details of the access key to create.
try {
    AccessKey result = apiInstance.createApplicationAccessKey(applicationId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#createApplicationAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| The ID of the application. |
 **body** | [**AccessKey**](AccessKey.md)| The details of the access key to create. |

### Return type

[**AccessKey**](AccessKey.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteApplication"></a>
# **deleteApplication**
> Void deleteApplication(applicationId)

Delete application.

Delete the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/applications/{application_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application to delete.
try {
    Void result = apiInstance.deleteApplication(applicationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#deleteApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| The ID of the application to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteApplicationAccessKey"></a>
# **deleteApplicationAccessKey**
> Void deleteApplicationAccessKey(applicationId, accessKeyId)

Delete access key associated with the application.

Delete the access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application.
String accessKeyId = "accessKeyId_example"; // String | The ID of the access key to delete.
try {
    Void result = apiInstance.deleteApplicationAccessKey(applicationId, accessKeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#deleteApplicationAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| The ID of the application. |
 **accessKeyId** | **String**| The ID of the access key to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllApplicationAccessKeys"></a>
# **getAllApplicationAccessKeys**
> AccessKeyList getAllApplicationAccessKeys(applicationId, limit, after, order, include, statusEq)

Get all access keys associated with the application.

Retrieve an array of access keys associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String statusEq = "statusEq_example"; // String | Status filter.
try {
    AccessKeyList result = apiInstance.getAllApplicationAccessKeys(applicationId, limit, after, order, include, statusEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#getAllApplicationAccessKeys");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getAllApplications"></a>
# **getAllApplications**
> ApplicationList getAllApplications(limit, after, order, include, statusEq)

Get all applications.

Retrieve an array of applications. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String statusEq = "statusEq_example"; // String | Status filter.
try {
    ApplicationList result = apiInstance.getAllApplications(limit, after, order, include, statusEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#getAllApplications");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getApplication"></a>
# **getApplication**
> Application getApplication(applicationId)

Get application.

Retrieve details of an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications/{application_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application to retrieve.
try {
    Application result = apiInstance.getApplication(applicationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#getApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| The ID of the application to retrieve. |

### Return type

[**Application**](Application.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getApplicationAccessKey"></a>
# **getApplicationAccessKey**
> AccessKey getApplicationAccessKey(applicationId, accessKeyId)

Get access key.

Retrieve details of an access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application.
String accessKeyId = "accessKeyId_example"; // String | The ID of the access key to retrieve.
try {
    AccessKey result = apiInstance.getApplicationAccessKey(applicationId, accessKeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#getApplicationAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| The ID of the application. |
 **accessKeyId** | **String**| The ID of the access key to retrieve. |

### Return type

[**AccessKey**](AccessKey.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfApplication"></a>
# **getGroupsOfApplication**
> GroupSummaryList getGroupsOfApplication(applicationId, limit, after, order, include)

Get policy groups of an application.

Retrieve an array of policy groups associated with an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    GroupSummaryList result = apiInstance.getGroupsOfApplication(applicationId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#getGroupsOfApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="removeApplicationFromGroups"></a>
# **removeApplicationFromGroups**
> Void removeApplicationFromGroups(applicationId, body)

Remove application from groups.

Remove application from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups/remove \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application to remove from the group.
GroupIdList body = new GroupIdList(); // GroupIdList | A list of IDs of the groups to update.
try {
    Void result = apiInstance.removeApplicationFromGroups(applicationId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#removeApplicationFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| The ID of the application to remove from the group. |
 **body** | [**GroupIdList**](GroupIdList.md)| A list of IDs of the groups to update. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateApplication"></a>
# **updateApplication**
> ApiKeyInfoResp updateApplication(applicationId, body)

Update applicationdetails.

Update application details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/applications/{application_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestApplication25\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application to update.
Application body = new Application(); // Application | New applicationattributes to store.
try {
    ApiKeyInfoResp result = apiInstance.updateApplication(applicationId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#updateApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| The ID of the application to update. |
 **body** | [**Application**](Application.md)| New applicationattributes to store. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateApplicationAccessKey"></a>
# **updateApplicationAccessKey**
> AccessKey updateApplicationAccessKey(applicationId, accessKeyId, body)

Update access key details.

Update access key details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestAccessKey\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApplicationsApi apiInstance = new AccountApplicationsApi();
String applicationId = "applicationId_example"; // String | The ID of the application.
String accessKeyId = "accessKeyId_example"; // String | The ID of the access key to update.
AccessKey body = new AccessKey(); // AccessKey | New access key attributes to store.
try {
    AccessKey result = apiInstance.updateApplicationAccessKey(applicationId, accessKeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApplicationsApi#updateApplicationAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

