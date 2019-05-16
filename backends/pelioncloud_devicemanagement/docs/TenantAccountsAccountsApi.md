# TenantAccountsAccountsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAccount**](TenantAccountsAccountsApi.md#createAccount) | **POST** v3/accounts | Create a new account.
[**getAccountInfo**](TenantAccountsAccountsApi.md#getAccountInfo) | **GET** v3/accounts/{account_id} | Get account info.
[**getAllAccounts**](TenantAccountsAccountsApi.md#getAllAccounts) | **GET** v3/accounts | Get all accounts.
[**updateAccount**](TenantAccountsAccountsApi.md#updateAccount) | **PUT** v3/accounts/{account_id} | Update attributes of an existing account.


<a name="createAccount"></a>
# **createAccount**
> AccountInfo createAccount(body, action)

Create a new account.

Create a new account.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;display_name\&quot;: \&quot;MyAccount1\&quot;, \&quot;admin_name\&quot;: \&quot;accountAdmin1\&quot;, \&quot;email\&quot;: \&quot;example_admin@myaccount.info\&quot;, \&quot;country\&quot;: \&quot;United Kingdom\&quot;, \&quot;end_market\&quot;: \&quot;Smart City\&quot;, \&quot;address_line1\&quot;: \&quot;110 Fulbourn Rd\&quot;, \&quot;city\&quot;: \&quot;Cambridge\&quot;, \&quot;contact\&quot;: \&quot;J. Doe\&quot;, \&quot;company\&quot;: \&quot;Arm\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsAccountsApi apiInstance = new TenantAccountsAccountsApi();
AccountCreationReq body = new AccountCreationReq(); // AccountCreationReq | Details of the account to create.
String action = "create"; // String | Action, either `create` or `enroll`. <ul> <li>`create` creates the account where its admin user has ACTIVE status if `admin_password` was defined in the request, or RESET status if no `admin_password` was defined. If the user already exists, its status is not modified. </li> <li>`enroll` creates the account where its admin user has ENROLLING status. If the user already exists, its status is not modified. Email to finish enrollment or notify the existing user about the new account is sent to the `admin_email` defined in the request. </li></ul>
try {
    AccountInfo result = apiInstance.createAccount(body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsAccountsApi#createAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AccountCreationReq**](AccountCreationReq.md)| Details of the account to create. |
 **action** | **String**| Action, either &#x60;create&#x60; or &#x60;enroll&#x60;. &lt;ul&gt; &lt;li&gt;&#x60;create&#x60; creates the account where its admin user has ACTIVE status if &#x60;admin_password&#x60; was defined in the request, or RESET status if no &#x60;admin_password&#x60; was defined. If the user already exists, its status is not modified. &lt;/li&gt; &lt;li&gt;&#x60;enroll&#x60; creates the account where its admin user has ENROLLING status. If the user already exists, its status is not modified. Email to finish enrollment or notify the existing user about the new account is sent to the &#x60;admin_email&#x60; defined in the request. &lt;/li&gt;&lt;/ul&gt; | [optional] [default to create]

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAccountInfo"></a>
# **getAccountInfo**
> AccountInfo getAccountInfo(accountId, include, properties)

Get account info.

Retrieve detailed information about an account.  **Example:**  &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsAccountsApi apiInstance = new TenantAccountsAccountsApi();
String accountId = "accountId_example"; // String | The ID of the account to fetch.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts.
String properties = "properties_example"; // String | Property name to return from account-specific properties.
try {
    AccountInfo result = apiInstance.getAccountInfo(accountId, include, properties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsAccountsApi#getAccountInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to fetch. |
 **include** | **String**| Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts. | [optional]
 **properties** | **String**| Property name to return from account-specific properties. | [optional]

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccounts"></a>
# **getAllAccounts**
> AccountInfoList getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties)

Get all accounts.

Returns an array of account objects, optionally filtered by status and tier level.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsAccountsApi apiInstance = new TenantAccountsAccountsApi();
String statusEq = "statusEq_example"; // String | An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED, or SUSPENDED.
String statusIn = "statusIn_example"; // String | An optional filter to retrieve accounts with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter to exclude accounts with a specified set of statuses.
String tierEq = "tierEq_example"; // String | An optional filter for tier level. Must be 0, 1, 2, 98, 99, or omitted.
String parentEq = "parentEq_example"; // String | An optional filter for parent account ID.
String endMarketEq = "endMarketEq_example"; // String | An optional filter for account end market.
String countryLike = "countryLike_example"; // String | An optional filter for account country. Finds all matches where the filter value is a case-insensitive substring of the result. Example: country__like=LAND matches Ireland.
Integer limit = 1000; // Integer | The number of results to return (2-1000). Default 1000.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts.
String format = "format_example"; // String | Format information for the query response. Supported: format=breakdown.
String properties = "properties_example"; // String | Property name returned from account-specific properties.
try {
    AccountInfoList result = apiInstance.getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsAccountsApi#getAllAccounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **statusEq** | **String**| An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED, or SUSPENDED. | [optional]
 **statusIn** | **String**| An optional filter to retrieve accounts with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter to exclude accounts with a specified set of statuses. | [optional]
 **tierEq** | **String**| An optional filter for tier level. Must be 0, 1, 2, 98, 99, or omitted. | [optional]
 **parentEq** | **String**| An optional filter for parent account ID. | [optional]
 **endMarketEq** | **String**| An optional filter for account end market. | [optional]
 **countryLike** | **String**| An optional filter for account country. Finds all matches where the filter value is a case-insensitive substring of the result. Example: country__like&#x3D;LAND matches Ireland. | [optional]
 **limit** | **Integer**| The number of results to return (2-1000). Default 1000. | [optional] [default to 1000]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts. | [optional]
 **format** | **String**| Format information for the query response. Supported: format&#x3D;breakdown. | [optional]
 **properties** | **String**| Property name returned from account-specific properties. | [optional]

### Return type

[**AccountInfoList**](AccountInfoList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAccount"></a>
# **updateAccount**
> AccountInfo updateAccount(accountId, body)

Update attributes of an existing account.

Update an account.  **Example:**  &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsAccountsApi apiInstance = new TenantAccountsAccountsApi();
String accountId = "accountId_example"; // String | The ID of the account to update.
AccountUpdateRootReq body = new AccountUpdateRootReq(); // AccountUpdateRootReq | Details of the account to update.
try {
    AccountInfo result = apiInstance.updateAccount(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsAccountsApi#updateAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to update. |
 **body** | [**AccountUpdateRootReq**](AccountUpdateRootReq.md)| Details of the account to update. |

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

