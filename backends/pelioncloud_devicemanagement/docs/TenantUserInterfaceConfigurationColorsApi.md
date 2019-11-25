# TenantUserInterfaceConfigurationColorsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkSetAccountDarkColors**](TenantUserInterfaceConfigurationColorsApi.md#bulkSetAccountDarkColors) | **PUT** v3/accounts/{account_id}/branding-colors/dark | Updates an array of dark theme branding colors.
[**bulkSetAccountLightColors**](TenantUserInterfaceConfigurationColorsApi.md#bulkSetAccountLightColors) | **PUT** v3/accounts/{account_id}/branding-colors/light | Updates an array of light theme branding colors.
[**deleteAllAccountColors**](TenantUserInterfaceConfigurationColorsApi.md#deleteAllAccountColors) | **DELETE** v3/accounts/{account_id}/branding-colors | Delete all colors.
[**deleteAllAccountDarkColors**](TenantUserInterfaceConfigurationColorsApi.md#deleteAllAccountDarkColors) | **DELETE** v3/accounts/{account_id}/branding-colors/dark | Delete colors in the dark theme.
[**deleteAllAccountLightColors**](TenantUserInterfaceConfigurationColorsApi.md#deleteAllAccountLightColors) | **DELETE** v3/accounts/{account_id}/branding-colors/light | Delete colors in the light theme.
[**getAccountDarkColor**](TenantUserInterfaceConfigurationColorsApi.md#getAccountDarkColor) | **GET** v3/accounts/{account_id}/branding-colors/dark/{reference} | Get dark theme branding color.
[**getAccountDarkColors**](TenantUserInterfaceConfigurationColorsApi.md#getAccountDarkColors) | **GET** v3/accounts/{account_id}/branding-colors/dark | Get dark theme branding colors.
[**getAccountLightColor**](TenantUserInterfaceConfigurationColorsApi.md#getAccountLightColor) | **GET** v3/accounts/{account_id}/branding-colors/light/{reference} | Get light theme branding color.
[**getAccountLightColors**](TenantUserInterfaceConfigurationColorsApi.md#getAccountLightColors) | **GET** v3/accounts/{account_id}/branding-colors/light | Get light theme branding colors.
[**resetAccountDarkColor**](TenantUserInterfaceConfigurationColorsApi.md#resetAccountDarkColor) | **DELETE** v3/accounts/{account_id}/branding-colors/dark/{reference} | Reset branding color to default.
[**resetAccountLightColor**](TenantUserInterfaceConfigurationColorsApi.md#resetAccountLightColor) | **DELETE** v3/accounts/{account_id}/branding-colors/light/{reference} | Reset branding color to default.
[**setAccountDarkColor**](TenantUserInterfaceConfigurationColorsApi.md#setAccountDarkColor) | **PUT** v3/accounts/{account_id}/branding-colors/dark/{reference} | Updates a dark theme branding color.
[**setAccountLightColor**](TenantUserInterfaceConfigurationColorsApi.md#setAccountLightColor) | **PUT** v3/accounts/{account_id}/branding-colors/light/{reference} | Updates light theme branding color.


<a name="bulkSetAccountDarkColors"></a>
# **bulkSetAccountDarkColors**
> Void bulkSetAccountDarkColors(accountId, body)

Updates an array of dark theme branding colors.

Update an array of dark theme branding colors of a tenant account.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,    \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
List<BrandingColor> body = Arrays.asList(new BrandingColor()); // List<BrandingColor> | List of branding colors.
try {
    Void result = apiInstance.bulkSetAccountDarkColors(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#bulkSetAccountDarkColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **body** | [**List&lt;BrandingColor&gt;**](BrandingColor.md)| List of branding colors. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="bulkSetAccountLightColors"></a>
# **bulkSetAccountLightColors**
> Void bulkSetAccountLightColors(accountId, body)

Updates an array of light theme branding colors.

Update an array of light theme branding colors of a tenant account.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,    \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
List<BrandingColor> body = Arrays.asList(new BrandingColor()); // List<BrandingColor> | List of branding colors.
try {
    Void result = apiInstance.bulkSetAccountLightColors(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#bulkSetAccountLightColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **body** | [**List&lt;BrandingColor&gt;**](BrandingColor.md)| List of branding colors. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAllAccountColors"></a>
# **deleteAllAccountColors**
> Void deleteAllAccountColors(accountId)

Delete all colors.

Delete account branding colors for all themes.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    Void result = apiInstance.deleteAllAccountColors(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#deleteAllAccountColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAllAccountDarkColors"></a>
# **deleteAllAccountDarkColors**
> Void deleteAllAccountDarkColors(accountId)

Delete colors in the dark theme.

Delete account dark theme branding colors.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    Void result = apiInstance.deleteAllAccountDarkColors(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#deleteAllAccountDarkColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAllAccountLightColors"></a>
# **deleteAllAccountLightColors**
> Void deleteAllAccountLightColors(accountId)

Delete colors in the light theme.

Delete account light theme branding colors.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    Void result = apiInstance.deleteAllAccountLightColors(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#deleteAllAccountLightColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountDarkColor"></a>
# **getAccountDarkColor**
> BrandingColor getAccountDarkColor(accountId, reference)

Get dark theme branding color.

Retrieve the requested dark theme branding color.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.getAccountDarkColor(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#getAccountDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountDarkColors"></a>
# **getAccountDarkColors**
> BrandingColorList getAccountDarkColors(accountId)

Get dark theme branding colors.

Retrieve dark theme branding colors for an account.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    BrandingColorList result = apiInstance.getAccountDarkColors(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#getAccountDarkColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |

### Return type

[**BrandingColorList**](BrandingColorList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountLightColor"></a>
# **getAccountLightColor**
> BrandingColor getAccountLightColor(accountId, reference)

Get light theme branding color.

Retrieve the requested light theme branding color.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.getAccountLightColor(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#getAccountLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountLightColors"></a>
# **getAccountLightColors**
> BrandingColorList getAccountLightColors(accountId)

Get light theme branding colors.

Retrieve light theme branding colors for an account.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    BrandingColorList result = apiInstance.getAccountLightColors(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#getAccountLightColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |

### Return type

[**BrandingColorList**](BrandingColorList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetAccountDarkColor"></a>
# **resetAccountDarkColor**
> Void resetAccountDarkColor(accountId, reference)

Reset branding color to default.

Resets the branding color of a tenant account to its dark theme default.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | The name of the branding color.
try {
    Void result = apiInstance.resetAccountDarkColor(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#resetAccountDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetAccountLightColor"></a>
# **resetAccountLightColor**
> Void resetAccountLightColor(accountId, reference)

Reset branding color to default.

Resets the branding color of a tenant account to its light theme default.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | The name of the branding color.
try {
    Void result = apiInstance.resetAccountLightColor(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#resetAccountLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="setAccountDarkColor"></a>
# **setAccountDarkColor**
> BrandingColor setAccountDarkColor(accountId, reference, body)

Updates a dark theme branding color.

Update a dark theme branding color of a tenant account.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark/primary \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | The name of the branding color.
BrandingColor body = new BrandingColor(); // BrandingColor | The branding color.
try {
    BrandingColor result = apiInstance.setAccountDarkColor(accountId, reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#setAccountDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]
 **body** | [**BrandingColor**](BrandingColor.md)| The branding color. |

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setAccountLightColor"></a>
# **setAccountLightColor**
> BrandingColor setAccountLightColor(accountId, reference, body)

Updates light theme branding color.

Update a light theme branding color of a tenant account.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light/primary \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;color\&quot;: \&quot;purple\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationColorsApi apiInstance = new TenantUserInterfaceConfigurationColorsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | The name of the branding color.
BrandingColor body = new BrandingColor(); // BrandingColor | The branding color.
try {
    BrandingColor result = apiInstance.setAccountLightColor(accountId, reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationColorsApi#setAccountLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]
 **body** | [**BrandingColor**](BrandingColor.md)| The branding color. |

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

