# TenantUserInterfaceConfigurationImagesApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clearAccountDarkImage**](TenantUserInterfaceConfigurationImagesApi.md#clearAccountDarkImage) | **POST** v3/accounts/{account_id}/branding-images/dark/{reference}/clear | Revert an image to dark theme default.
[**clearAccountLightImage**](TenantUserInterfaceConfigurationImagesApi.md#clearAccountLightImage) | **POST** v3/accounts/{account_id}/branding-images/light/{reference}/clear | Revert an image to light theme default.
[**deleteAllAccountDarkImages**](TenantUserInterfaceConfigurationImagesApi.md#deleteAllAccountDarkImages) | **DELETE** v3/accounts/{account_id}/branding-images/dark | Delete images in the dark theme.
[**deleteAllAccountImages**](TenantUserInterfaceConfigurationImagesApi.md#deleteAllAccountImages) | **DELETE** v3/accounts/{account_id}/branding-images | Delete all images.
[**deleteAllAccountLightImages**](TenantUserInterfaceConfigurationImagesApi.md#deleteAllAccountLightImages) | **DELETE** v3/accounts/{account_id}/branding-images/light | Delete images in the light theme.
[**getAccountDarkImageData**](TenantUserInterfaceConfigurationImagesApi.md#getAccountDarkImageData) | **GET** v3/accounts/{account_id}/branding-images/dark/{reference} | Get metadata of a dark theme image.
[**getAccountLightImageData**](TenantUserInterfaceConfigurationImagesApi.md#getAccountLightImageData) | **GET** v3/accounts/{account_id}/branding-images/light/{reference} | Get metadata of a light theme image.
[**getAllAccountDarkImageData**](TenantUserInterfaceConfigurationImagesApi.md#getAllAccountDarkImageData) | **GET** v3/accounts/{account_id}/branding-images/dark | Get metadata of all dark theme images.
[**getAllAccountLightImageData**](TenantUserInterfaceConfigurationImagesApi.md#getAllAccountLightImageData) | **GET** v3/accounts/{account_id}/branding-images/light | Get metadata of all light theme images.
[**uploadAccountDarkImage**](TenantUserInterfaceConfigurationImagesApi.md#uploadAccountDarkImage) | **POST** v3/accounts/{account_id}/branding-images/dark/{reference}/upload | Upload a dark theme image.
[**uploadAccountDarkImageMultipart**](TenantUserInterfaceConfigurationImagesApi.md#uploadAccountDarkImageMultipart) | **POST** v3/accounts/{account_id}/branding-images/dark/{reference}/upload-multipart | Upload a dark theme image.
[**uploadAccountLightImage**](TenantUserInterfaceConfigurationImagesApi.md#uploadAccountLightImage) | **POST** v3/accounts/{account_id}/branding-images/light/{reference}/upload | Upload a light theme image.
[**uploadAccountLightImageMultipart**](TenantUserInterfaceConfigurationImagesApi.md#uploadAccountLightImageMultipart) | **POST** v3/accounts/{account_id}/branding-images/light/{reference}/upload-multipart | Upload a light theme image.


<a name="clearAccountDarkImage"></a>
# **clearAccountDarkImage**
> Void clearAccountDarkImage(accountId, reference)

Revert an image to dark theme default.

Revert an account branding image to dark theme default. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/clear \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    Void result = apiInstance.clearAccountDarkImage(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#clearAccountDarkImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, app_logo_landscape, app_logo_portrait, app_logo_square, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clearAccountLightImage"></a>
# **clearAccountLightImage**
> Void clearAccountLightImage(accountId, reference)

Revert an image to light theme default.

Revert an account branding image to light theme default. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/clear \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    Void result = apiInstance.clearAccountLightImage(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#clearAccountLightImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, app_logo_landscape, app_logo_portrait, app_logo_square, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAllAccountDarkImages"></a>
# **deleteAllAccountDarkImages**
> Void deleteAllAccountDarkImages(accountId)

Delete images in the dark theme.

Delete account dark theme branding images. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    Void result = apiInstance.deleteAllAccountDarkImages(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#deleteAllAccountDarkImages");
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

<a name="deleteAllAccountImages"></a>
# **deleteAllAccountImages**
> Void deleteAllAccountImages(accountId)

Delete all images.

Delete account branding images for all themes. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    Void result = apiInstance.deleteAllAccountImages(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#deleteAllAccountImages");
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

<a name="deleteAllAccountLightImages"></a>
# **deleteAllAccountLightImages**
> Void deleteAllAccountLightImages(accountId)

Delete images in the light theme.

Delete account light theme branding images. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    Void result = apiInstance.deleteAllAccountLightImages(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#deleteAllAccountLightImages");
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

<a name="getAccountDarkImageData"></a>
# **getAccountDarkImageData**
> BrandingImage getAccountDarkImageData(accountId, reference)

Get metadata of a dark theme image.

Retrieve metadata of one account dark theme branding image. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    BrandingImage result = apiInstance.getAccountDarkImageData(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#getAccountDarkImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, app_logo_landscape, app_logo_portrait, app_logo_square, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountLightImageData"></a>
# **getAccountLightImageData**
> BrandingImage getAccountLightImageData(accountId, reference)

Get metadata of a light theme image.

Retrieve metadata for one account light theme branding image. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    BrandingImage result = apiInstance.getAccountLightImageData(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#getAccountLightImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, app_logo_landscape, app_logo_portrait, app_logo_square, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountDarkImageData"></a>
# **getAllAccountDarkImageData**
> BrandingImageList getAllAccountDarkImageData(accountId)

Get metadata of all dark theme images.

Retrieve the metadata of all dark theme branding images. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    BrandingImageList result = apiInstance.getAllAccountDarkImageData(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#getAllAccountDarkImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |

### Return type

[**BrandingImageList**](BrandingImageList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountLightImageData"></a>
# **getAllAccountLightImageData**
> BrandingImageList getAllAccountLightImageData(accountId)

Get metadata of all light theme images.

Retrieve the metadata of all light theme branding images. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
try {
    BrandingImageList result = apiInstance.getAllAccountLightImageData(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#getAllAccountLightImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |

### Return type

[**BrandingImageList**](BrandingImageList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="uploadAccountDarkImage"></a>
# **uploadAccountDarkImage**
> BrandingImage uploadAccountDarkImage(accountId, reference, body)

Upload a dark theme image.

Upload a new account dark theme branding image in PNG or JPEG format. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/upload \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; -H &#39;content-type: image/png&#39;  --data-binary &#39;@myimage.png&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
String body = "body_example"; // String | The image in PNG or JPEG format.
try {
    BrandingImage result = apiInstance.uploadAccountDarkImage(accountId, reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#uploadAccountDarkImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, app_logo_landscape, app_logo_portrait, app_logo_square, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **body** | [**String**](String.md)| The image in PNG or JPEG format. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: image/png, image/jpeg
 - **Accept**: application/json

<a name="uploadAccountDarkImageMultipart"></a>
# **uploadAccountDarkImageMultipart**
> BrandingImage uploadAccountDarkImageMultipart(accountId, reference, image)

Upload a dark theme image.

Upload a new account dark theme branding image as form data in PNG or JPEG format. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
File image = new File("/path/to/file.txt"); // File | The image in PNG or JPEG format as multipart form data.
try {
    BrandingImage result = apiInstance.uploadAccountDarkImageMultipart(accountId, reference, image);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#uploadAccountDarkImageMultipart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, app_logo_landscape, app_logo_portrait, app_logo_square, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **image** | **File**| The image in PNG or JPEG format as multipart form data. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="uploadAccountLightImage"></a>
# **uploadAccountLightImage**
> BrandingImage uploadAccountLightImage(accountId, reference, body)

Upload a light theme image.

Upload a new account light theme branding image in PNG or JPEG format. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/upload \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: image/png&#39; --data-binary &#39;@myimage.png&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
String body = "body_example"; // String | The image in PNG or JPEG format.
try {
    BrandingImage result = apiInstance.uploadAccountLightImage(accountId, reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#uploadAccountLightImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, app_logo_landscape, app_logo_portrait, app_logo_square, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **body** | [**String**](String.md)| The image in PNG or JPEG format. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: image/png, image/jpeg
 - **Accept**: application/json

<a name="uploadAccountLightImageMultipart"></a>
# **uploadAccountLightImageMultipart**
> BrandingImage uploadAccountLightImageMultipart(accountId, reference, image)

Upload a light theme image.

Upload a new account branding image as form data in PNG or JPEG format. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantUserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantUserInterfaceConfigurationImagesApi apiInstance = new TenantUserInterfaceConfigurationImagesApi();
String accountId = "accountId_example"; // String | The ID of the account.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
File image = new File("/path/to/file.txt"); // File | The image in PNG or JPEG format as multipart form data.
try {
    BrandingImage result = apiInstance.uploadAccountLightImageMultipart(accountId, reference, image);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantUserInterfaceConfigurationImagesApi#uploadAccountLightImageMultipart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, app_logo_landscape, app_logo_portrait, app_logo_square, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **image** | **File**| The image in PNG or JPEG format as multipart form data. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

