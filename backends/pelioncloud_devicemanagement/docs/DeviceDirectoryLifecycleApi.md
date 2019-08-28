# DeviceDirectoryLifecycleApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**blockCategoriesList**](DeviceDirectoryLifecycleApi.md#blockCategoriesList) | **GET** v3/device-block-categories/ | List all device block categories
[**blockCategoriesRetrieve**](DeviceDirectoryLifecycleApi.md#blockCategoriesRetrieve) | **GET** v3/device-block-categories/{block_category_reference} | Get a device block category.
[**deviceResume**](DeviceDirectoryLifecycleApi.md#deviceResume) | **POST** v3/devices/{id}/resume | Return a device to service.
[**deviceSuspend**](DeviceDirectoryLifecycleApi.md#deviceSuspend) | **POST** v3/devices/{id}/suspend | Suspend a device.


<a name="blockCategoriesList"></a>
# **blockCategoriesList**
> DeviceBlockCategoryPage blockCategoriesList(limit, order, after, include, referenceEq, referenceNeq, referenceIn, referenceNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte)

List all device block categories

List all device block categories. A block category is a short description of why a device was suspended or returned to service.  **Example:** Get all defined categories of why device is blocked from the device management &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/device-block-categories \\ -H &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryLifecycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryLifecycleApi apiInstance = new DeviceDirectoryLifecycleApi();
Integer limit = 56; // Integer | This endpoint doesn't support paging. Parameter is accepted for API compatibility. Value is ignored
String order = "order_example"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
String after = "after_example"; // String | This endpoint doesn't support paging. Parameter is accepted for API compatibility. Value is ignored
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String referenceEq = "referenceEq_example"; // String | eq filter for the \"reference\" field
String referenceNeq = "referenceNeq_example"; // String | neq filter for the \"reference\" field
String referenceIn = "referenceIn_example"; // String | in filter for the \"reference\" field
String referenceNin = "referenceNin_example"; // String | nin filter for the \"reference\" field
String updatedAtIn = "updatedAtIn_example"; // String | in filter for the \"updated_at\" field
String updatedAtNin = "updatedAtNin_example"; // String | nin filter for the \"updated_at\" field
DateTime updatedAtLte = new DateTime(); // DateTime | lte filter for the \"updated_at\" field
DateTime updatedAtGte = new DateTime(); // DateTime | gte filter for the \"updated_at\" field
try {
    DeviceBlockCategoryPage result = apiInstance.blockCategoriesList(limit, order, after, include, referenceEq, referenceNeq, referenceIn, referenceNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryLifecycleApi#blockCategoriesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| This endpoint doesn&#39;t support paging. Parameter is accepted for API compatibility. Value is ignored | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. Default: ASC. | [optional]
 **after** | **String**| This endpoint doesn&#39;t support paging. Parameter is accepted for API compatibility. Value is ignored | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]
 **referenceEq** | **String**| eq filter for the \&quot;reference\&quot; field | [optional]
 **referenceNeq** | **String**| neq filter for the \&quot;reference\&quot; field | [optional]
 **referenceIn** | **String**| in filter for the \&quot;reference\&quot; field | [optional]
 **referenceNin** | **String**| nin filter for the \&quot;reference\&quot; field | [optional]
 **updatedAtIn** | **String**| in filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtNin** | **String**| nin filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtLte** | **DateTime**| lte filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtGte** | **DateTime**| gte filter for the \&quot;updated_at\&quot; field | [optional]

### Return type

[**DeviceBlockCategoryPage**](DeviceBlockCategoryPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="blockCategoriesRetrieve"></a>
# **blockCategoriesRetrieve**
> DeviceBlockCategory blockCategoriesRetrieve(blockCategoryReference)

Get a device block category.

Retrieve a device block category. A block category is a short description of why a device was suspended or returned to service.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryLifecycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryLifecycleApi apiInstance = new DeviceDirectoryLifecycleApi();
String blockCategoryReference = "blockCategoryReference_example"; // String | The reference of the block category.
try {
    DeviceBlockCategory result = apiInstance.blockCategoriesRetrieve(blockCategoryReference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryLifecycleApi#blockCategoriesRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **blockCategoryReference** | **String**| The reference of the block category. |

### Return type

[**DeviceBlockCategory**](DeviceBlockCategory.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceResume"></a>
# **deviceResume**
> Void deviceResume(id, block)

Return a device to service.

Returning a device to service restores connectivity to the device. All API functionality is restored.  **Example:** Following example enables device to connect again to Pelion Device Management. Note that the category must match the reason why device was suspended. This device was reported stolen but was now found. &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_id&gt;/resume \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;category\&quot;: \&quot;lost_or_stolen\&quot;, \&quot;description\&quot;: \&quot;Was found, was not stolen but miss placed\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryLifecycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryLifecycleApi apiInstance = new DeviceDirectoryLifecycleApi();
String id = "id_example"; // String | The ID of the device.
Block block = new Block(); // Block | The device block.
try {
    Void result = apiInstance.deviceResume(id, block);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryLifecycleApi#deviceResume");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the device. |
 **block** | [**Block**](Block.md)| The device block. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceSuspend"></a>
# **deviceSuspend**
> Void deviceSuspend(id, block)

Suspend a device.

Suspending a device prevents it from connecting to Device Management. If a device is currently connected, it will be disconnected. Some API operations will fail while a device is suspended.  ***Example:* Following example suspends a device with category \&quot;Lost or stolen\&quot;. You can see available categories with &#39;/v3/device-block-categories/&#39;. &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_id&gt;/suspend \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;category\&quot;: \&quot;lost_or_stolen\&quot;, \&quot;description\&quot;: \&quot;EXAMPLE: Customer contacted via phone and reported device being stolen. Specific time of the theft was not know. Device last used in May/2019\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryLifecycleApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryLifecycleApi apiInstance = new DeviceDirectoryLifecycleApi();
String id = "id_example"; // String | The ID of the device.
Block1 block = new Block1(); // Block1 | The device block.
try {
    Void result = apiInstance.deviceSuspend(id, block);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryLifecycleApi#deviceSuspend");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the device. |
 **block** | [**Block1**](Block1.md)| The device block. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

