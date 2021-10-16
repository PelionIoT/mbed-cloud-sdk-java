# AccountUsersApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUserToGroups**](AccountUsersApi.md#addUserToGroups) | **POST** v3/users/{user_id}/groups | Add user to a list of groups.
[**addUserToListedGroups**](AccountUsersApi.md#addUserToListedGroups) | **POST** v3/users/{user_id}/groups/add | Add user to a list of groups.
[**createUser**](AccountUsersApi.md#createUser) | **POST** v3/users | Create a new user.
[**deleteUser**](AccountUsersApi.md#deleteUser) | **DELETE** v3/users/{user_id} | Delete a user.
[**getAllUsers**](AccountUsersApi.md#getAllUsers) | **GET** v3/users | Get users.
[**getGroupsOfUser**](AccountUsersApi.md#getGroupsOfUser) | **GET** v3/users/{user_id}/groups | Get policy groups for a user.
[**getUser**](AccountUsersApi.md#getUser) | **GET** v3/users/{user_id} | Details of a user.
[**removeUserFromAccount**](AccountUsersApi.md#removeUserFromAccount) | **POST** v3/users/{user_id}/remove | Remove user from the account.
[**removeUserFromGroups**](AccountUsersApi.md#removeUserFromGroups) | **DELETE** v3/users/{user_id}/groups | Remove user from groups.
[**removeUserFromListedGroups**](AccountUsersApi.md#removeUserFromListedGroups) | **POST** v3/users/{user_id}/groups/remove | Remove user from groups.
[**updateUser**](AccountUsersApi.md#updateUser) | **PUT** v3/users/{user_id} | Update user details.


<a name="addUserToGroups"></a>
# **addUserToGroups**
> UserInfoResp addUserToGroups(userId, body)

Add user to a list of groups.

Add user to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user to add to the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to update.
try {
    UserInfoResp result = apiInstance.addUserToGroups(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#addUserToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to add to the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to update. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addUserToListedGroups"></a>
# **addUserToListedGroups**
> UserInfoResp addUserToListedGroups(userId, body)

Add user to a list of groups.

Add user to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups/add \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user to add to the group.
GroupIdList body = new GroupIdList(); // GroupIdList | A list of IDs of the groups to update.
try {
    UserInfoResp result = apiInstance.addUserToListedGroups(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#addUserToListedGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to add to the group. |
 **body** | [**GroupIdList**](GroupIdList.md)| A list of IDs of the groups to update. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createUser"></a>
# **createUser**
> UserInfoResp createUser(body, action)

Create a new user.

Create or invite a new user to the account. The invited user has to accept the invitation by clicking the link in the invitation email. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/users?action&#x3D;invite \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
UserInfoReq body = new UserInfoReq(); // UserInfoReq | A user object with attributes.
String action = "create"; // String | Action, either `create` or `invite`.
try {
    UserInfoResp result = apiInstance.createUser(body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserInfoReq**](UserInfoReq.md)| A user object with attributes. |
 **action** | **String**| Action, either &#x60;create&#x60; or &#x60;invite&#x60;. | [optional] [default to create]

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

Delete a user. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user to delete.
try {
    Void result = apiInstance.deleteUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllUsers"></a>
# **getAllUsers**
> UserInfoRespList getAllUsers(limit, after, order, include, emailEq, statusEq, statusIn, statusNin, loginProfilesEq)

Get users.

Retrieve an array of users. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/users \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String emailEq = "emailEq_example"; // String | Filter for email address
String statusEq = "statusEq_example"; // String | Filter for status, for example, active or reset.
String statusIn = "statusIn_example"; // String | An optional filter to retrieve users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter to exclude users with a specified set of statuses.
String loginProfilesEq = "loginProfilesEq_example"; // String | An optional filter to retrieve users with a specified login profile.
try {
    UserInfoRespList result = apiInstance.getAllUsers(limit, after, order, include, emailEq, statusEq, statusIn, statusNin, loginProfilesEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#getAllUsers");
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
 **emailEq** | **String**| Filter for email address | [optional]
 **statusEq** | **String**| Filter for status, for example, active or reset. | [optional]
 **statusIn** | **String**| An optional filter to retrieve users with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter to exclude users with a specified set of statuses. | [optional]
 **loginProfilesEq** | **String**| An optional filter to retrieve users with a specified login profile. | [optional]

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfUser"></a>
# **getGroupsOfUser**
> GroupSummaryList getGroupsOfUser(userId, limit, after, order, include)

Get policy groups for a user.

Retrieve an array of policy groups associated with a user. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    GroupSummaryList result = apiInstance.getGroupsOfUser(userId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#getGroupsOfUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user. |
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

<a name="getUser"></a>
# **getUser**
> UserInfoResp getUser(userId)

Details of a user.

Retrieve the details of a user. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user.
try {
    UserInfoResp result = apiInstance.getUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeUserFromAccount"></a>
# **removeUserFromAccount**
> Void removeUserFromAccount(userId)

Remove user from the account.

Remove user from the account.  &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/remove \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user to remove from the account.
try {
    Void result = apiInstance.removeUserFromAccount(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#removeUserFromAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to remove from the account. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeUserFromGroups"></a>
# **removeUserFromGroups**
> UserInfoResp removeUserFromGroups(userId, body)

Remove user from groups.

Remove user from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user to remove from the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to update.
try {
    UserInfoResp result = apiInstance.removeUserFromGroups(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#removeUserFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to remove from the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to update. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUserFromListedGroups"></a>
# **removeUserFromListedGroups**
> UserInfoResp removeUserFromListedGroups(userId, body)

Remove user from groups.

Remove user from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups/remove \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user to remove from the group.
GroupIdList body = new GroupIdList(); // GroupIdList | A list of IDs of the groups to update.
try {
    UserInfoResp result = apiInstance.removeUserFromListedGroups(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#removeUserFromListedGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to remove from the group. |
 **body** | [**GroupIdList**](GroupIdList.md)| A list of IDs of the groups to update. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUser"></a>
# **updateUser**
> UserInfoResp updateUser(userId, body)

Update user details.

Update user details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;username\&quot;: \&quot;myusername\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountUsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountUsersApi apiInstance = new AccountUsersApi();
String userId = "userId_example"; // String | The ID of the user.
UserUpdateReq body = new UserUpdateReq(); // UserUpdateReq | A user object with attributes.
try {
    UserInfoResp result = apiInstance.updateUser(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountUsersApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user. |
 **body** | [**UserUpdateReq**](UserUpdateReq.md)| A user object with attributes. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

