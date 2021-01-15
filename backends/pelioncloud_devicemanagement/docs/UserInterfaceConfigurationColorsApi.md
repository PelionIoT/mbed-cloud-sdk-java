# UserInterfaceConfigurationColorsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkSetDarkColors**](UserInterfaceConfigurationColorsApi.md#bulkSetDarkColors) | **PUT** v3/branding-colors/dark | Updates an array of dark theme branding colors.
[**bulkSetLightColors**](UserInterfaceConfigurationColorsApi.md#bulkSetLightColors) | **PUT** v3/branding-colors/light | Updates an array of light theme branding colors.
[**deleteAllColors**](UserInterfaceConfigurationColorsApi.md#deleteAllColors) | **DELETE** v3/branding-colors | Delete all colors.
[**deleteAllDarkColors**](UserInterfaceConfigurationColorsApi.md#deleteAllDarkColors) | **DELETE** v3/branding-colors/dark | Delete colors in the dark theme.
[**deleteAllLightColors**](UserInterfaceConfigurationColorsApi.md#deleteAllLightColors) | **DELETE** v3/branding-colors/light | Delete colors in the light theme.
[**getDarkColor**](UserInterfaceConfigurationColorsApi.md#getDarkColor) | **GET** v3/branding-colors/dark/{reference} | Get dark theme branding color.
[**getDarkColors**](UserInterfaceConfigurationColorsApi.md#getDarkColors) | **GET** v3/branding-colors/dark | Get dark theme branding colors.
[**getLightColor**](UserInterfaceConfigurationColorsApi.md#getLightColor) | **GET** v3/branding-colors/light/{reference} | Get light theme branding color.
[**getLightColors**](UserInterfaceConfigurationColorsApi.md#getLightColors) | **GET** v3/branding-colors/light | Get light theme branding colors.
[**resetDarkColor**](UserInterfaceConfigurationColorsApi.md#resetDarkColor) | **DELETE** v3/branding-colors/dark/{reference} | Reset branding color to default.
[**resetLightColor**](UserInterfaceConfigurationColorsApi.md#resetLightColor) | **DELETE** v3/branding-colors/light/{reference} | Reset branding color to default.
[**setDarkColor**](UserInterfaceConfigurationColorsApi.md#setDarkColor) | **PUT** v3/branding-colors/dark/{reference} | Updates a dark theme branding color.
[**setLightColor**](UserInterfaceConfigurationColorsApi.md#setLightColor) | **PUT** v3/branding-colors/light/{reference} | Updates light theme branding color.


<a name="bulkSetDarkColors"></a>
# **bulkSetDarkColors**
> Void bulkSetDarkColors(body)

Updates an array of dark theme branding colors.

Update an array of dark theme branding colors. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,    \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
List<BrandingColorUpdate> body = Arrays.asList(new BrandingColorUpdate()); // List<BrandingColorUpdate> | List of branding colors.
try {
    Void result = apiInstance.bulkSetDarkColors(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#bulkSetDarkColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;BrandingColorUpdate&gt;**](BrandingColorUpdate.md)| List of branding colors. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="bulkSetLightColors"></a>
# **bulkSetLightColors**
> Void bulkSetLightColors(body)

Updates an array of light theme branding colors.

Update an array of light theme branding colors. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/light \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,    \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
List<BrandingColorUpdate> body = Arrays.asList(new BrandingColorUpdate()); // List<BrandingColorUpdate> | List of branding colors.
try {
    Void result = apiInstance.bulkSetLightColors(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#bulkSetLightColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;BrandingColorUpdate&gt;**](BrandingColorUpdate.md)| List of branding colors. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAllColors"></a>
# **deleteAllColors**
> Void deleteAllColors()

Delete all colors.

Delete account branding colors for all themes. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
try {
    Void result = apiInstance.deleteAllColors();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#deleteAllColors");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAllDarkColors"></a>
# **deleteAllDarkColors**
> Void deleteAllDarkColors()

Delete colors in the dark theme.

Delete account dark theme branding colors. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
try {
    Void result = apiInstance.deleteAllDarkColors();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#deleteAllDarkColors");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAllLightColors"></a>
# **deleteAllLightColors**
> Void deleteAllLightColors()

Delete colors in the light theme.

Delete account light theme branding colors. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
try {
    Void result = apiInstance.deleteAllLightColors();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#deleteAllLightColors");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDarkColor"></a>
# **getDarkColor**
> BrandingColor getDarkColor(reference)

Get dark theme branding color.

Retrieve the requested dark theme branding color.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/{reference} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.getDarkColor(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#getDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color, menu_background_color, menu_text_color, nav_menu_background, nav_menu_background_font_color, nav_menu_active_background, nav_menu_active_background_font_color, nav_menu_highlight, nav_menu_highlight_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDarkColors"></a>
# **getDarkColors**
> BrandingColorList getDarkColors()

Get dark theme branding colors.

Retrieve the dark theme branding colors.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
try {
    BrandingColorList result = apiInstance.getDarkColors();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#getDarkColors");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BrandingColorList**](BrandingColorList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLightColor"></a>
# **getLightColor**
> BrandingColor getLightColor(reference)

Get light theme branding color.

Retrieve the requested light theme branding color.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.getLightColor(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#getLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color, menu_background_color, menu_text_color, nav_menu_background, nav_menu_background_font_color, nav_menu_active_background, nav_menu_active_background_font_color, nav_menu_highlight, nav_menu_highlight_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLightColors"></a>
# **getLightColors**
> BrandingColorList getLightColors()

Get light theme branding colors.

Retrieve the light theme branding colors.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-colors/light \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
try {
    BrandingColorList result = apiInstance.getLightColors();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#getLightColors");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BrandingColorList**](BrandingColorList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetDarkColor"></a>
# **resetDarkColor**
> Void resetDarkColor(reference)

Reset branding color to default.

Resets the branding color to its dark theme default. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
String reference = "reference_example"; // String | The name of the branding color.
try {
    Void result = apiInstance.resetDarkColor(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#resetDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color, menu_background_color, menu_text_color, nav_menu_background, nav_menu_background_font_color, nav_menu_active_background, nav_menu_active_background_font_color, nav_menu_highlight, nav_menu_highlight_font_color]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetLightColor"></a>
# **resetLightColor**
> Void resetLightColor(reference)

Reset branding color to default.

Resets the branding color to its light theme default. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
String reference = "reference_example"; // String | The name of the branding color.
try {
    Void result = apiInstance.resetLightColor(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#resetLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color, menu_background_color, menu_text_color, nav_menu_background, nav_menu_background_font_color, nav_menu_active_background, nav_menu_active_background_font_color, nav_menu_highlight, nav_menu_highlight_font_color]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="setDarkColor"></a>
# **setDarkColor**
> BrandingColor setDarkColor(reference, body)

Updates a dark theme branding color.

Update a dark theme branding color. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/primary \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
String reference = "reference_example"; // String | The name of the branding color.
BrandingColor body = new BrandingColor(); // BrandingColor | The branding color.
try {
    BrandingColor result = apiInstance.setDarkColor(reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#setDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color, menu_background_color, menu_text_color, nav_menu_background, nav_menu_background_font_color, nav_menu_active_background, nav_menu_active_background_font_color, nav_menu_highlight, nav_menu_highlight_font_color]
 **body** | [**BrandingColor**](BrandingColor.md)| The branding color. |

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setLightColor"></a>
# **setLightColor**
> BrandingColor setLightColor(reference, body)

Updates light theme branding color.

Update light theme branding color. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/primary \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;color\&quot;: \&quot;purple\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationColorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationColorsApi apiInstance = new UserInterfaceConfigurationColorsApi();
String reference = "reference_example"; // String | The name of the branding color.
BrandingColor body = new BrandingColor(); // BrandingColor | The branding color.
try {
    BrandingColor result = apiInstance.setLightColor(reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationColorsApi#setLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color, menu_background_color, menu_text_color, nav_menu_background, nav_menu_background_font_color, nav_menu_active_background, nav_menu_active_background_font_color, nav_menu_highlight, nav_menu_highlight_font_color]
 **body** | [**BrandingColor**](BrandingColor.md)| The branding color. |

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

