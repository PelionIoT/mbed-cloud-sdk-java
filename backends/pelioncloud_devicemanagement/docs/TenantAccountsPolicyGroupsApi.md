# TenantAccountsPolicyGroupsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addApiKeysToAccountGroup**](TenantAccountsPolicyGroupsApi.md#addApiKeysToAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id}/api-keys | Add API keys to Account group.
[**addListedApiKeysToAccountGroup**](TenantAccountsPolicyGroupsApi.md#addListedApiKeysToAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id}/api-keys/add | Add API keys to account group.
[**addListedApplicationsToAccountGroup**](TenantAccountsPolicyGroupsApi.md#addListedApplicationsToAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id}/applications/add | Add applications to account group.
[**addListedUsersToAccountGroup**](TenantAccountsPolicyGroupsApi.md#addListedUsersToAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id}/users/add | Add users to account group.
[**addSubjectsToAccountGroup**](TenantAccountsPolicyGroupsApi.md#addSubjectsToAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id} | Add members to a group.
[**addUsersToAccountGroup**](TenantAccountsPolicyGroupsApi.md#addUsersToAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id}/users | Add users to account group.
[**createAccountGroup**](TenantAccountsPolicyGroupsApi.md#createAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups | Create a new group.
[**deleteAccountGroup**](TenantAccountsPolicyGroupsApi.md#deleteAccountGroup) | **DELETE** v3/accounts/{account_id}/policy-groups/{group_id} | Delete a group.
[**getAccountGroupSummary**](TenantAccountsPolicyGroupsApi.md#getAccountGroupSummary) | **GET** v3/accounts/{account_id}/policy-groups/{group_id} | Get policy group.
[**getAllAccountGroups**](TenantAccountsPolicyGroupsApi.md#getAllAccountGroups) | **GET** v3/accounts/{account_id}/policy-groups | Get policy groups.
[**getApiKeysOfAccountGroup**](TenantAccountsPolicyGroupsApi.md#getApiKeysOfAccountGroup) | **GET** v3/accounts/{account_id}/policy-groups/{group_id}/api-keys | Get API keys in a group.
[**getApplicationsOfAccountGroup**](TenantAccountsPolicyGroupsApi.md#getApplicationsOfAccountGroup) | **GET** v3/accounts/{account_id}/policy-groups/{group_id}/applications | Get applications in a group.
[**getUsersOfAccountGroup**](TenantAccountsPolicyGroupsApi.md#getUsersOfAccountGroup) | **GET** v3/accounts/{account_id}/policy-groups/{group_id}/users | Get users in a policy group.
[**removeApiKeysFromAccountGroup**](TenantAccountsPolicyGroupsApi.md#removeApiKeysFromAccountGroup) | **DELETE** v3/accounts/{account_id}/policy-groups/{group_id}/api-keys | Remove API keys from a group.
[**removeListedApiKeysFromAccountGroup**](TenantAccountsPolicyGroupsApi.md#removeListedApiKeysFromAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id}/api-keys/remove | Remove API keys from a group.
[**removeListedApplicationsFromAccountGroup**](TenantAccountsPolicyGroupsApi.md#removeListedApplicationsFromAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id}/applications/remove | Remove applications from a group.
[**removeListedUsersFromAccountGroup**](TenantAccountsPolicyGroupsApi.md#removeListedUsersFromAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id}/users/remove | Remove users from a group.
[**removeUsersFromAccountGroup**](TenantAccountsPolicyGroupsApi.md#removeUsersFromAccountGroup) | **DELETE** v3/accounts/{account_id}/policy-groups/{group_id}/users | Remove users from a group.
[**updateAccountGroupName**](TenantAccountsPolicyGroupsApi.md#updateAccountGroupName) | **PUT** v3/accounts/{account_id}/policy-groups/{group_id} | Update the group name.


<a name="addApiKeysToAccountGroup"></a>
# **addApiKeysToAccountGroup**
> GroupSummary addApiKeysToAccountGroup(accountId, groupId, body)

Add API keys to Account group.

Add API keys to account groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to retrieve API keys for.
SubjectList body = new SubjectList(); // SubjectList | A list of API keys to add to the group.
try {
    GroupSummary result = apiInstance.addApiKeysToAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#addApiKeysToAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to retrieve API keys for. |
 **body** | [**SubjectList**](SubjectList.md)| A list of API keys to add to the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="addListedApiKeysToAccountGroup"></a>
# **addListedApiKeysToAccountGroup**
> GroupSummary addListedApiKeysToAccountGroup(accountId, groupId, body)

Add API keys to account group.

Add API keys to account groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys/add \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;apikeys\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to remove API keys from.
SubjectList body = new SubjectList(); // SubjectList | A list of API keys to add to the group.
try {
    GroupSummary result = apiInstance.addListedApiKeysToAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#addListedApiKeysToAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to remove API keys from. |
 **body** | [**SubjectList**](SubjectList.md)| A list of API keys to add to the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="addListedApplicationsToAccountGroup"></a>
# **addListedApplicationsToAccountGroup**
> GroupSummary addListedApplicationsToAccountGroup(accountId, groupId, body)

Add applications to account group.

Add applications to account groups.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/applications/add \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;applications\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to add applications to.
SubjectList body = new SubjectList(); // SubjectList | A list of applications to add to the group.
try {
    GroupSummary result = apiInstance.addListedApplicationsToAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#addListedApplicationsToAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to add applications to. |
 **body** | [**SubjectList**](SubjectList.md)| A list of applications to add to the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="addListedUsersToAccountGroup"></a>
# **addListedUsersToAccountGroup**
> GroupSummary addListedUsersToAccountGroup(accountId, groupId, body)

Add users to account group.

Add users to account group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users/add \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to retrieve users for.
SubjectList body = new SubjectList(); // SubjectList | A list of users to add to the group.
try {
    GroupSummary result = apiInstance.addListedUsersToAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#addListedUsersToAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to retrieve users for. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users to add to the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="addSubjectsToAccountGroup"></a>
# **addSubjectsToAccountGroup**
> GroupSummary addSubjectsToAccountGroup(accountId, groupId, body)

Add members to a group.

Add users and API keys to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;users\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to update.
SubjectList body = new SubjectList(); // SubjectList | A list of users and API keys to add to the group.
try {
    GroupSummary result = apiInstance.addSubjectsToAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#addSubjectsToAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to update. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users and API keys to add to the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addUsersToAccountGroup"></a>
# **addUsersToAccountGroup**
> GroupSummary addUsersToAccountGroup(accountId, groupId, body)

Add users to account group.

Add users to account group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to add users to.
SubjectList body = new SubjectList(); // SubjectList | A list of user IDs to add to the group.
try {
    GroupSummary result = apiInstance.addUsersToAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#addUsersToAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to add users to. |
 **body** | [**SubjectList**](SubjectList.md)| A list of user IDs to add to the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createAccountGroup"></a>
# **createAccountGroup**
> GroupSummary createAccountGroup(accountId, body)

Create a new group.

Create a new group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
GroupCreationInfo body = new GroupCreationInfo(); // GroupCreationInfo | Details of the group to create.
try {
    GroupSummary result = apiInstance.createAccountGroup(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#createAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**GroupCreationInfo**](GroupCreationInfo.md)| Details of the group to create. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccountGroup"></a>
# **deleteAccountGroup**
> Void deleteAccountGroup(accountId, groupId)

Delete a group.

Delete a group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to delete.
try {
    Void result = apiInstance.deleteAccountGroup(accountId, groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#deleteAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountGroupSummary"></a>
# **getAccountGroupSummary**
> GroupSummary getAccountGroupSummary(accountId, groupId)

Get policy group.

Retrieve policy group details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to retrieve.
try {
    GroupSummary result = apiInstance.getAccountGroupSummary(accountId, groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#getAccountGroupSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to retrieve. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountGroups"></a>
# **getAllAccountGroups**
> GroupSummaryList getAllAccountGroups(accountId, limit, after, order, include, nameEq)

Get policy groups.

Retrieve an array of policy groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String nameEq = "nameEq_example"; // String | Filter for group name.
try {
    GroupSummaryList result = apiInstance.getAllAccountGroups(accountId, limit, after, order, include, nameEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#getAllAccountGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]
 **nameEq** | **String**| Filter for group name. | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getApiKeysOfAccountGroup"></a>
# **getApiKeysOfAccountGroup**
> ApiKeyInfoRespList getApiKeysOfAccountGroup(accountId, groupId, limit, after, order, include)

Get API keys in a group.

Retrieve an array of API keys associated with a policy group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to retrieve API keys for.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    ApiKeyInfoRespList result = apiInstance.getApiKeysOfAccountGroup(accountId, groupId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#getApiKeysOfAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to retrieve API keys for. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]

### Return type

[**ApiKeyInfoRespList**](ApiKeyInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getApplicationsOfAccountGroup"></a>
# **getApplicationsOfAccountGroup**
> ApplicationList getApplicationsOfAccountGroup(accountId, groupId, limit, after, order, include)

Get applications in a group.

Retrieve an array of applications associated with a policy group.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/applications \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to retrieve applications for.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    ApplicationList result = apiInstance.getApplicationsOfAccountGroup(accountId, groupId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#getApplicationsOfAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to retrieve applications for. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]

### Return type

[**ApplicationList**](ApplicationList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsersOfAccountGroup"></a>
# **getUsersOfAccountGroup**
> UserInfoRespList getUsersOfAccountGroup(accountId, groupId, limit, after, order, include, statusEq, statusIn, statusNin)

Get users in a policy group.

Retrieve an array of users associated with a policy group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to retrieve users for.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String statusEq = "statusEq_example"; // String | An optional filter to retrieve users by status.
String statusIn = "statusIn_example"; // String | An optional filter to retrieve users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter to exclude users with a specified set of statuses.
try {
    UserInfoRespList result = apiInstance.getUsersOfAccountGroup(accountId, groupId, limit, after, order, include, statusEq, statusIn, statusNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#getUsersOfAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to retrieve users for. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
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

<a name="removeApiKeysFromAccountGroup"></a>
# **removeApiKeysFromAccountGroup**
> GroupSummary removeApiKeysFromAccountGroup(accountId, groupId, body)

Remove API keys from a group.

Remove API keys from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;apikeys\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to remove API keys from.
SubjectList body = new SubjectList(); // SubjectList | A list of API keys to remove from the group.
try {
    GroupSummary result = apiInstance.removeApiKeysFromAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#removeApiKeysFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to remove API keys from. |
 **body** | [**SubjectList**](SubjectList.md)| A list of API keys to remove from the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeListedApiKeysFromAccountGroup"></a>
# **removeListedApiKeysFromAccountGroup**
> GroupSummary removeListedApiKeysFromAccountGroup(accountId, groupId, body)

Remove API keys from a group.

Remove API keys from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys/remove \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;apikeys\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to remove API keys from.
SubjectList body = new SubjectList(); // SubjectList | A list of API keys to remove from the group.
try {
    GroupSummary result = apiInstance.removeListedApiKeysFromAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#removeListedApiKeysFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to remove API keys from. |
 **body** | [**SubjectList**](SubjectList.md)| A list of API keys to remove from the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeListedApplicationsFromAccountGroup"></a>
# **removeListedApplicationsFromAccountGroup**
> GroupSummary removeListedApplicationsFromAccountGroup(accountId, groupId, body)

Remove applications from a group.

Remove applications from groups.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/applications/remove \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;applications\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to remove applications from.
SubjectList body = new SubjectList(); // SubjectList | A list of applications to remove from the group.
try {
    GroupSummary result = apiInstance.removeListedApplicationsFromAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#removeListedApplicationsFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to remove applications from. |
 **body** | [**SubjectList**](SubjectList.md)| A list of applications to remove from the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeListedUsersFromAccountGroup"></a>
# **removeListedUsersFromAccountGroup**
> GroupSummary removeListedUsersFromAccountGroup(accountId, groupId, body)

Remove users from a group.

Remove users from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users/remove \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\  -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;users\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String groupId = "groupId_example"; // String | The ID of the group to remove users from.
SubjectList body = new SubjectList(); // SubjectList | A list of users to remove from the group.
try {
    GroupSummary result = apiInstance.removeListedUsersFromAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#removeListedUsersFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **groupId** | **String**| The ID of the group to remove users from. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users to remove from the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUsersFromAccountGroup"></a>
# **removeUsersFromAccountGroup**
> GroupSummary removeUsersFromAccountGroup(accountId, groupId, body)

Remove users from a group.

Remove users from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\  -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;users\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to remove users from.
SubjectList body = new SubjectList(); // SubjectList | A list of users to remove from the group.
try {
    GroupSummary result = apiInstance.removeUsersFromAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#removeUsersFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to remove users from. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users to remove from the group. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountGroupName"></a>
# **updateAccountGroupName**
> GroupSummary updateAccountGroupName(accountId, groupId, body)

Update the group name.

Update a group name. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/ \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsPolicyGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsPolicyGroupsApi apiInstance = new TenantAccountsPolicyGroupsApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to update.
GroupUpdateInfo body = new GroupUpdateInfo(); // GroupUpdateInfo | Details of the group to create.
try {
    GroupSummary result = apiInstance.updateAccountGroupName(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsPolicyGroupsApi#updateAccountGroupName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to update. |
 **body** | [**GroupUpdateInfo**](GroupUpdateInfo.md)| Details of the group to create. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

