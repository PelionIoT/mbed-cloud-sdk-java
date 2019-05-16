# AccountPolicyGroupsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addSubjectsToGroup**](AccountPolicyGroupsApi.md#addSubjectsToGroup) | **POST** v3/policy-groups/{group_id} | Add members to a group.
[**createGroup**](AccountPolicyGroupsApi.md#createGroup) | **POST** v3/policy-groups | Create a new group.
[**deleteGroup**](AccountPolicyGroupsApi.md#deleteGroup) | **DELETE** v3/policy-groups/{group_id} | Delete a group.
[**getAllGroups**](AccountPolicyGroupsApi.md#getAllGroups) | **GET** v3/policy-groups | Get all group information.
[**getApiKeysOfGroup**](AccountPolicyGroupsApi.md#getApiKeysOfGroup) | **GET** v3/policy-groups/{group_id}/api-keys | Get the API keys of a group.
[**getGroupSummary**](AccountPolicyGroupsApi.md#getGroupSummary) | **GET** v3/policy-groups/{group_id} | Get group information.
[**getUsersOfGroup**](AccountPolicyGroupsApi.md#getUsersOfGroup) | **GET** v3/policy-groups/{group_id}/users | Get users of a group.
[**removeApiKeysFromGroup**](AccountPolicyGroupsApi.md#removeApiKeysFromGroup) | **DELETE** v3/policy-groups/{group_id}/api-keys | Remove API keys from a group.
[**removeUsersFromGroup**](AccountPolicyGroupsApi.md#removeUsersFromGroup) | **DELETE** v3/policy-groups/{group_id}/users | Remove users from a group.
[**updateGroupName**](AccountPolicyGroupsApi.md#updateGroupName) | **PUT** v3/policy-groups/{group_id} | Update the group name.


<a name="addSubjectsToGroup"></a>
# **addSubjectsToGroup**
> UpdatedResponse addSubjectsToGroup(groupId, body)

Add members to a group.

Add users and API keys to a group.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;users\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
String groupId = "groupId_example"; // String | The ID of the group to update.
SubjectList body = new SubjectList(); // SubjectList | A list of users and API keys to add to the group.
try {
    UpdatedResponse result = apiInstance.addSubjectsToGroup(groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#addSubjectsToGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group to update. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users and API keys to add to the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGroup"></a>
# **createGroup**
> GroupSummary createGroup(body)

Create a new group.

Create a new group.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/policy-groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
GroupCreationInfo body = new GroupCreationInfo(); // GroupCreationInfo | Details of the group to create.
try {
    GroupSummary result = apiInstance.createGroup(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#createGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GroupCreationInfo**](GroupCreationInfo.md)| Details of the group to create. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteGroup"></a>
# **deleteGroup**
> Void deleteGroup(groupId)

Delete a group.

Delete a group.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
String groupId = "groupId_example"; // String | The ID of the group to delete.
try {
    Void result = apiInstance.deleteGroup(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#deleteGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllGroups"></a>
# **getAllGroups**
> GroupSummaryList getAllGroups(limit, after, order, include, nameEq)

Get all group information.

Retrieve all group information.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/policy-groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String nameEq = "nameEq_example"; // String | Filter for group name.
try {
    GroupSummaryList result = apiInstance.getAllGroups(limit, after, order, include, nameEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#getAllGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]
 **nameEq** | **String**| Filter for group name. | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getApiKeysOfGroup"></a>
# **getApiKeysOfGroup**
> ApiKeyInfoRespList getApiKeysOfGroup(groupId, limit, after, order, include)

Get the API keys of a group.

Manage policy groups.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
String groupId = "groupId_example"; // String | The ID of the group.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    ApiKeyInfoRespList result = apiInstance.getApiKeysOfGroup(groupId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#getApiKeysOfGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]

### Return type

[**ApiKeyInfoRespList**](ApiKeyInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupSummary"></a>
# **getGroupSummary**
> GroupSummary getGroupSummary(groupId)

Get group information.

Retrieve general information about a group.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
String groupId = "groupId_example"; // String | The ID of the group to retrieve.
try {
    GroupSummary result = apiInstance.getGroupSummary(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#getGroupSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group to retrieve. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsersOfGroup"></a>
# **getUsersOfGroup**
> UserInfoRespList getUsersOfGroup(groupId, limit, after, order, include, statusEq, statusIn, statusNin)

Get users of a group.

Retrieve users of a group with details.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
String groupId = "groupId_example"; // String | The ID of the group.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String statusEq = "statusEq_example"; // String | An optional filter to retrieve users by status.
String statusIn = "statusIn_example"; // String | An optional filter to retrieve users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter to exclude users with a specified set of statuses.
try {
    UserInfoRespList result = apiInstance.getUsersOfGroup(groupId, limit, after, order, include, statusEq, statusIn, statusNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#getUsersOfGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]
 **statusEq** | **String**| An optional filter to retrieve users by status. | [optional]
 **statusIn** | **String**| An optional filter to retrieve users with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter to exclude users with a specified set of statuses. | [optional]

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeApiKeysFromGroup"></a>
# **removeApiKeysFromGroup**
> UpdatedResponse removeApiKeysFromGroup(groupId, body)

Remove API keys from a group.

Remove API keys from groups.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
String groupId = "groupId_example"; // String | The ID of the group.
SubjectList body = new SubjectList(); // SubjectList | A list of API keys to remove from the group.
try {
    UpdatedResponse result = apiInstance.removeApiKeysFromGroup(groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#removeApiKeysFromGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group. |
 **body** | [**SubjectList**](SubjectList.md)| A list of API keys to remove from the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUsersFromGroup"></a>
# **removeUsersFromGroup**
> UpdatedResponse removeUsersFromGroup(groupId, body)

Remove users from a group.

Manage policy groups.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
String groupId = "groupId_example"; // String | The ID of the group.
SubjectList body = new SubjectList(); // SubjectList | A list of users to remove from the group.
try {
    UpdatedResponse result = apiInstance.removeUsersFromGroup(groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#removeUsersFromGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users to remove from the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGroupName"></a>
# **updateGroupName**
> UpdatedResponse updateGroupName(groupId, body)

Update the group name.

Update a group name.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountPolicyGroupsApi apiInstance = new AccountPolicyGroupsApi();
String groupId = "groupId_example"; // String | The ID of the group to update.
GroupUpdateInfo body = new GroupUpdateInfo(); // GroupUpdateInfo | Details of the group to create.
try {
    UpdatedResponse result = apiInstance.updateGroupName(groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountPolicyGroupsApi#updateGroupName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group to update. |
 **body** | [**GroupUpdateInfo**](GroupUpdateInfo.md)| Details of the group to create. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

