# UserInterfaceConfigurationImagesApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clearDarkImage**](UserInterfaceConfigurationImagesApi.md#clearDarkImage) | **POST** v3/branding-images/dark/{reference}/clear | Revert an image to dark theme default.
[**clearLightImage**](UserInterfaceConfigurationImagesApi.md#clearLightImage) | **POST** v3/branding-images/light/{reference}/clear | Revert an image to light theme default.
[**deleteAllDarkImages**](UserInterfaceConfigurationImagesApi.md#deleteAllDarkImages) | **DELETE** v3/branding-images/dark | Delete images in the dark theme.
[**deleteAllImages**](UserInterfaceConfigurationImagesApi.md#deleteAllImages) | **DELETE** v3/branding-images | Delete all images.
[**deleteAllLightImages**](UserInterfaceConfigurationImagesApi.md#deleteAllLightImages) | **DELETE** v3/branding-images/light | Delete images in the light theme.
[**getAllDarkImageData**](UserInterfaceConfigurationImagesApi.md#getAllDarkImageData) | **GET** v3/branding-images/dark | Get metadata of all dark theme images.
[**getAllLightImageData**](UserInterfaceConfigurationImagesApi.md#getAllLightImageData) | **GET** v3/branding-images/light | Get metadata of all light theme images.
[**getDarkImageData**](UserInterfaceConfigurationImagesApi.md#getDarkImageData) | **GET** v3/branding-images/dark/{reference} | Get metadata of a dark theme image.
[**getLightImageData**](UserInterfaceConfigurationImagesApi.md#getLightImageData) | **GET** v3/branding-images/light/{reference} | Get metadata of a light theme image.
[**uploadDarkImage**](UserInterfaceConfigurationImagesApi.md#uploadDarkImage) | **POST** v3/branding-images/dark/{reference}/upload | Upload a dark theme image.
[**uploadDarkImageMultipart**](UserInterfaceConfigurationImagesApi.md#uploadDarkImageMultipart) | **POST** v3/branding-images/dark/{reference}/upload-multipart | Upload a dark theme image.
[**uploadLightImage**](UserInterfaceConfigurationImagesApi.md#uploadLightImage) | **POST** v3/branding-images/light/{reference}/upload | Upload a light theme image.
[**uploadLightImageMultipart**](UserInterfaceConfigurationImagesApi.md#uploadLightImageMultipart) | **POST** v3/branding-images/light/{reference}/upload-multipart | Upload a light theme image.


<a name="clearDarkImage"></a>
# **clearDarkImage**
> Void clearDarkImage(reference)

Revert an image to dark theme default.

Revert an account branding image to dark theme default.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/clear \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    Void result = apiInstance.clearDarkImage(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#clearDarkImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clearLightImage"></a>
# **clearLightImage**
> Void clearLightImage(reference)

Revert an image to light theme default.

Revert an account branding image to light theme default.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/clear \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    Void result = apiInstance.clearLightImage(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#clearLightImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAllDarkImages"></a>
# **deleteAllDarkImages**
> Void deleteAllDarkImages()

Delete images in the dark theme.

Delete account dark theme branding images.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-images/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
try {
    Void result = apiInstance.deleteAllDarkImages();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#deleteAllDarkImages");
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

<a name="deleteAllImages"></a>
# **deleteAllImages**
> Void deleteAllImages()

Delete all images.

Delete account branding images for all themes.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-images -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
try {
    Void result = apiInstance.deleteAllImages();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#deleteAllImages");
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

<a name="deleteAllLightImages"></a>
# **deleteAllLightImages**
> Void deleteAllLightImages()

Delete images in the light theme.

Delete account light theme branding images.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-images/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
try {
    Void result = apiInstance.deleteAllLightImages();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#deleteAllLightImages");
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

<a name="getAllDarkImageData"></a>
# **getAllDarkImageData**
> BrandingImageList getAllDarkImageData()

Get metadata of all dark theme images.

Retrieve metadata for all dark theme branding images.  **Example:** &#x60;curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-images/dark \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
try {
    BrandingImageList result = apiInstance.getAllDarkImageData();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#getAllDarkImageData");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BrandingImageList**](BrandingImageList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllLightImageData"></a>
# **getAllLightImageData**
> BrandingImageList getAllLightImageData()

Get metadata of all light theme images.

Retrieve the metadata of all light theme branding images.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-images/light \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
try {
    BrandingImageList result = apiInstance.getAllLightImageData();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#getAllLightImageData");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BrandingImageList**](BrandingImageList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDarkImageData"></a>
# **getDarkImageData**
> BrandingImage getDarkImageData(reference)

Get metadata of a dark theme image.

Retrieve metadata for one account dark theme branding image.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    BrandingImage result = apiInstance.getDarkImageData(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#getDarkImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLightImageData"></a>
# **getLightImageData**
> BrandingImage getLightImageData(reference)

Get metadata of a light theme image.

Retrieve metadata for one account light theme branding image.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    BrandingImage result = apiInstance.getLightImageData(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#getLightImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="uploadDarkImage"></a>
# **uploadDarkImage**
> BrandingImage uploadDarkImage(reference, body)

Upload a dark theme image.

Upload a new account branding image in the dark theme in PNG or JPEG format.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/upload \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: image/png&#39;  --data-binary &#39;@myimage.png&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
String body = "body_example"; // String | The image in PNG or JPEG format.
try {
    BrandingImage result = apiInstance.uploadDarkImage(reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#uploadDarkImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **body** | [**String**](String.md)| The image in PNG or JPEG format. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: image/png, image/jpeg
 - **Accept**: application/json

<a name="uploadDarkImageMultipart"></a>
# **uploadDarkImageMultipart**
> BrandingImage uploadDarkImageMultipart(reference, image)

Upload a dark theme image.

Upload a new account branding image as form data in the dark theme in PNG or JPEG format.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
File image = new File("/path/to/file.txt"); // File | The image in PNG or JPEG format as multipart form data.
try {
    BrandingImage result = apiInstance.uploadDarkImageMultipart(reference, image);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#uploadDarkImageMultipart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **image** | **File**| The image in PNG or JPEG format as multipart form data. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="uploadLightImage"></a>
# **uploadLightImage**
> BrandingImage uploadLightImage(reference, body)

Upload a light theme image.

Upload a new account light theme branding image in PNG or JPEG format.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/upload \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: image/png&#39; --data-binary &#39;@myimage.png&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
String body = "body_example"; // String | The image in PNG or JPEG format.
try {
    BrandingImage result = apiInstance.uploadLightImage(reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#uploadLightImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **body** | [**String**](String.md)| The image in PNG or JPEG format. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: image/png, image/jpeg
 - **Accept**: application/json

<a name="uploadLightImageMultipart"></a>
# **uploadLightImageMultipart**
> BrandingImage uploadLightImageMultipart(reference, image)

Upload a light theme image.

Upload a new account branding image as form data in the light theme in PNG or JPEG format.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UserInterfaceConfigurationImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UserInterfaceConfigurationImagesApi apiInstance = new UserInterfaceConfigurationImagesApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
File image = new File("/path/to/file.txt"); // File | The image in PNG or JPEG format as multipart form data.
try {
    BrandingImage result = apiInstance.uploadLightImageMultipart(reference, image);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserInterfaceConfigurationImagesApi#uploadLightImageMultipart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **image** | **File**| The image in PNG or JPEG format as multipart form data. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

