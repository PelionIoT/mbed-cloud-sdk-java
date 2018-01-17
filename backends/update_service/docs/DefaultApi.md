# DefaultApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**campaignCreate**](DefaultApi.md#campaignCreate) | **POST** v3/campaigns/ | 
[**campaignDestroy**](DefaultApi.md#campaignDestroy) | **DELETE** v3/update-campaigns/{campaign_id}/ | 
[**campaignList**](DefaultApi.md#campaignList) | **GET** v3/campaigns/ | 
[**campaignPartialUpdate**](DefaultApi.md#campaignPartialUpdate) | **PATCH** v3/update-campaigns/{campaign_id}/ | 
[**campaignRetrieve**](DefaultApi.md#campaignRetrieve) | **GET** v3/update-campaigns/{campaign_id}/ | 
[**campaignUpdate**](DefaultApi.md#campaignUpdate) | **PUT** v3/update-campaigns/{campaign_id}/ | 
[**firmwareImageCreate**](DefaultApi.md#firmwareImageCreate) | **POST** v3/firmware-images/ | 
[**firmwareImageDestroy**](DefaultApi.md#firmwareImageDestroy) | **DELETE** v3/firmware-images/{image_id}/ | 
[**firmwareImageList**](DefaultApi.md#firmwareImageList) | **GET** v3/firmware-images/ | 
[**firmwareImageRetrieve**](DefaultApi.md#firmwareImageRetrieve) | **GET** v3/firmware-images/{image_id}/ | 
[**firmwareManifestCreate**](DefaultApi.md#firmwareManifestCreate) | **POST** v3/firmware-manifests/ | 
[**firmwareManifestDestroy**](DefaultApi.md#firmwareManifestDestroy) | **DELETE** v3/firmware-manifests/{manifest_id}/ | 
[**firmwareManifestList**](DefaultApi.md#firmwareManifestList) | **GET** v3/firmware-manifests/ | 
[**firmwareManifestRetrieve**](DefaultApi.md#firmwareManifestRetrieve) | **GET** v3/firmware-manifests/{manifest_id}/ | 
[**updateCampaignCreate**](DefaultApi.md#updateCampaignCreate) | **POST** v3/update-campaigns/ | 
[**updateCampaignDestroy**](DefaultApi.md#updateCampaignDestroy) | **DELETE** v3/campaigns/{campaign_id}/ | 
[**updateCampaignList**](DefaultApi.md#updateCampaignList) | **GET** v3/update-campaigns/ | 
[**updateCampaignPartialUpdate**](DefaultApi.md#updateCampaignPartialUpdate) | **PATCH** v3/campaigns/{campaign_id}/ | 
[**updateCampaignRetrieve**](DefaultApi.md#updateCampaignRetrieve) | **GET** v3/campaigns/{campaign_id}/ | 
[**updateCampaignStop**](DefaultApi.md#updateCampaignStop) | **POST** v3/update-campaigns/{campaign_id}/stop | 
[**updateCampaignUpdate**](DefaultApi.md#updateCampaignUpdate) | **PUT** v3/campaigns/{campaign_id}/ | 
[**v3CampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet**](DefaultApi.md#v3CampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet) | **GET** v3/campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/ | 
[**v3CampaignsCampaignIdCampaignDeviceMetadataGet**](DefaultApi.md#v3CampaignsCampaignIdCampaignDeviceMetadataGet) | **GET** v3/campaigns/{campaign_id}/campaign-device-metadata/ | 
[**v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet**](DefaultApi.md#v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet) | **GET** v3/update-campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/ | 
[**v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet**](DefaultApi.md#v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet) | **GET** v3/update-campaigns/{campaign_id}/campaign-device-metadata/ | 


<a name="campaignCreate"></a>
# **campaignCreate**
> UpdateCampaign campaignCreate(campaign)



Create an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
UpdateCampaignPostRequest campaign = new UpdateCampaignPostRequest(); // UpdateCampaignPostRequest | Update campaign
try {
    UpdateCampaign result = apiInstance.campaignCreate(campaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#campaignCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaign** | [**UpdateCampaignPostRequest**](UpdateCampaignPostRequest.md)| Update campaign |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="campaignDestroy"></a>
# **campaignDestroy**
> Void campaignDestroy(campaignId)



DEPRECATED (use /v3/campaigns/{campaign_id}/ instead) Delete an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The ID of the update campaign
try {
    Void result = apiInstance.campaignDestroy(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#campaignDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The ID of the update campaign |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="campaignList"></a>
# **campaignList**
> UpdateCampaignPage campaignList(limit, order, after, filter, include)



Get update campaigns for devices specified by a filter.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many update campaigns to retrieve
String order = "order_example"; // String | The order of the records. Acceptable values: ASC, DESC. Default: ASC
String after = "after_example"; // String | The ID of the the item after which to retrieve the next page
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data  `?filter={URL-encoded query string}`  The query string is made up of key-value pairs separated by ampersands. For example, this query: `key1=value1&key2=value2&key3=value3`  would be URL-encoded as: `?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3`   **Filtering by campaign properties** `state=[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]`  `root_manifest_id=43217771234242e594ddb433816c498a`  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: `2016-11-30T16:25:12.1234Z` * UTC RFC3339 without milliseconds. Example: `2016-11-30T16:25:12Z` * UTC RFC3339 shortened without milliseconds and punctuation. Example: `20161130T162512Z`  Date-time filtering supports three operators:  * equality * greater than or equal to by appending `__gte` to the field name * less than or equal to by appending `__lte` to the field name  `{field name}[|__lte|__gte]={UTC RFC3339 date-time}`  Time ranges may be specified by including both the `__gte` and `__lte` forms in the filter. For example:  `created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering on multiple fields**  `state=deployed&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: total_count
try {
    UpdateCampaignPage result = apiInstance.campaignList(limit, order, after, filter, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#campaignList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many update campaigns to retrieve | [optional]
 **order** | **String**| The order of the records. Acceptable values: ASC, DESC. Default: ASC | [optional]
 **after** | **String**| The ID of the the item after which to retrieve the next page | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;   **Filtering by campaign properties** &#x60;state&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]&#x60;  &#x60;root_manifest_id&#x3D;43217771234242e594ddb433816c498a&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;state&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60; | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: total_count | [optional]

### Return type

[**UpdateCampaignPage**](UpdateCampaignPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="campaignPartialUpdate"></a>
# **campaignPartialUpdate**
> UpdateCampaign campaignPartialUpdate(campaignId, campaign)



DEPRECATED (use /v3/campaigns/{campaign_id}/ instead) Modify a subset of an update campaign&#39;s fields.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | 
UpdateCampaignPatchRequest campaign = new UpdateCampaignPatchRequest(); // UpdateCampaignPatchRequest | Update campaign
try {
    UpdateCampaign result = apiInstance.campaignPartialUpdate(campaignId, campaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#campaignPartialUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**|  |
 **campaign** | [**UpdateCampaignPatchRequest**](UpdateCampaignPatchRequest.md)| Update campaign |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="campaignRetrieve"></a>
# **campaignRetrieve**
> UpdateCampaign campaignRetrieve(campaignId)



DEPRECATED (use /v3/campaigns/{campaign_id}/ instead) Get an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The campaign ID
try {
    UpdateCampaign result = apiInstance.campaignRetrieve(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#campaignRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="campaignUpdate"></a>
# **campaignUpdate**
> UpdateCampaign campaignUpdate(campaignId, campaign)



DEPRECATED (use /v3/campaigns/{campaign_id}/ instead) Modify an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | 
UpdateCampaignPutRequest campaign = new UpdateCampaignPutRequest(); // UpdateCampaignPutRequest | Update campaign
try {
    UpdateCampaign result = apiInstance.campaignUpdate(campaignId, campaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#campaignUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**|  |
 **campaign** | [**UpdateCampaignPutRequest**](UpdateCampaignPutRequest.md)| Update campaign |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="firmwareImageCreate"></a>
# **firmwareImageCreate**
> FirmwareImage firmwareImageCreate(datafile, name, description)



Create firmware image.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
File datafile = new File("/path/to/file.txt"); // File | The firmware image file to upload
String name = "name_example"; // String | The name of the firmware image
String description = "description_example"; // String | The description of the firmware image
try {
    FirmwareImage result = apiInstance.firmwareImageCreate(datafile, name, description);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#firmwareImageCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **datafile** | **File**| The firmware image file to upload |
 **name** | **String**| The name of the firmware image |
 **description** | **String**| The description of the firmware image | [optional]

### Return type

[**FirmwareImage**](FirmwareImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="firmwareImageDestroy"></a>
# **firmwareImageDestroy**
> Void firmwareImageDestroy(imageId)



Delete firmware image.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String imageId = "imageId_example"; // String | The firmware image ID
try {
    Void result = apiInstance.firmwareImageDestroy(imageId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#firmwareImageDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **imageId** | **String**| The firmware image ID |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="firmwareImageList"></a>
# **firmwareImageList**
> FirmwareImagePage firmwareImageList(limit, order, after, filter, include)



List all firmware images.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many firmware images to retrieve
String order = "order_example"; // String | ASC or DESC
String after = "after_example"; // String | The ID of the the item after which to retrieve the next page
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data  `?filter={URL-encoded query string}`  The query string is made up of key-value pairs separated by ampersands. For example, this query: `key1=value1&key2=value2&key3=value3`  would be URL-encoded as: `?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3`   **Filtering by properties** `name=myimage`  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: `2016-11-30T16:25:12.1234Z` * UTC RFC3339 without milliseconds. Example: `2016-11-30T16:25:12Z` * UTC RFC3339 shortened without milliseconds and punctuation. Example: `20161130T162512Z`  Date-time filtering supports three operators:  * equality * greater than or equal to by appending `__gte` to the field name * less than or equal to by appending `__lte` to the field name  `{field name}[|__lte|__gte]={UTC RFC3339 date-time}`  Time ranges may be specified by including both the `__gte` and `__lte` forms in the filter. For example:  `created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering on multiple fields**  `name=myimage&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: total_count
try {
    FirmwareImagePage result = apiInstance.firmwareImageList(limit, order, after, filter, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#firmwareImageList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many firmware images to retrieve | [optional]
 **order** | **String**| ASC or DESC | [optional]
 **after** | **String**| The ID of the the item after which to retrieve the next page | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;   **Filtering by properties** &#x60;name&#x3D;myimage&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;name&#x3D;myimage&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60; | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: total_count | [optional]

### Return type

[**FirmwareImagePage**](FirmwareImagePage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="firmwareImageRetrieve"></a>
# **firmwareImageRetrieve**
> FirmwareImage firmwareImageRetrieve(imageId)



Retrieve firmware image.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String imageId = "imageId_example"; // String | The firmware image ID
try {
    FirmwareImage result = apiInstance.firmwareImageRetrieve(imageId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#firmwareImageRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **imageId** | **String**| The firmware image ID |

### Return type

[**FirmwareImage**](FirmwareImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="firmwareManifestCreate"></a>
# **firmwareManifestCreate**
> FirmwareManifest firmwareManifestCreate(datafile, name, description)



Create firmware manifest.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
File datafile = new File("/path/to/file.txt"); // File | The manifest file to create. The API gateway enforces the account-specific file size.
String name = "name_example"; // String | The name of the firmware manifest
String description = "description_example"; // String | The description of the firmware manifest
try {
    FirmwareManifest result = apiInstance.firmwareManifestCreate(datafile, name, description);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#firmwareManifestCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **datafile** | **File**| The manifest file to create. The API gateway enforces the account-specific file size. |
 **name** | **String**| The name of the firmware manifest |
 **description** | **String**| The description of the firmware manifest | [optional]

### Return type

[**FirmwareManifest**](FirmwareManifest.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="firmwareManifestDestroy"></a>
# **firmwareManifestDestroy**
> Void firmwareManifestDestroy(manifestId)



Delete firmware manifest.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String manifestId = "manifestId_example"; // String | The firmware manifest ID
try {
    Void result = apiInstance.firmwareManifestDestroy(manifestId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#firmwareManifestDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **manifestId** | **String**| The firmware manifest ID |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="firmwareManifestList"></a>
# **firmwareManifestList**
> FirmwareManifestPage firmwareManifestList(limit, order, after, filter, include)



List firmware manifests.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many firmware manifests to retrieve
String order = "order_example"; // String | ASC or DESC
String after = "after_example"; // String | The ID of the the item after which to retrieve the next page.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data  `?filter={URL-encoded query string}`  The query string is made up of key-value pairs separated by ampersands. For example, this query: `key1=value1&key2=value2&key3=value3`  would be URL-encoded as: `?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3`   **Filtering by properties** `name=mymanifest`  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: `2016-11-30T16:25:12.1234Z` * UTC RFC3339 without milliseconds. Example: `2016-11-30T16:25:12Z` * UTC RFC3339 shortened without milliseconds and punctuation. Example: `20161130T162512Z`  Date-time filtering supports three operators:  * equality * greater than or equal to by appending `__gte` to the field name * less than or equal to by appending `__lte` to the field name  `{field name}[|__lte|__gte]={UTC RFC3339 date-time}`  Time ranges may be specified by including both the `__gte` and `__lte` forms in the filter. For example:  `created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering on multiple fields**  `name=mymanifest&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: total_count
try {
    FirmwareManifestPage result = apiInstance.firmwareManifestList(limit, order, after, filter, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#firmwareManifestList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many firmware manifests to retrieve | [optional]
 **order** | **String**| ASC or DESC | [optional]
 **after** | **String**| The ID of the the item after which to retrieve the next page. | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;   **Filtering by properties** &#x60;name&#x3D;mymanifest&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;name&#x3D;mymanifest&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60; | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: total_count | [optional]

### Return type

[**FirmwareManifestPage**](FirmwareManifestPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="firmwareManifestRetrieve"></a>
# **firmwareManifestRetrieve**
> FirmwareManifest firmwareManifestRetrieve(manifestId)



Retrieve firmware manifest.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String manifestId = "manifestId_example"; // String | The firmware manifest ID
try {
    FirmwareManifest result = apiInstance.firmwareManifestRetrieve(manifestId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#firmwareManifestRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **manifestId** | **String**| The firmware manifest ID |

### Return type

[**FirmwareManifest**](FirmwareManifest.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignCreate"></a>
# **updateCampaignCreate**
> UpdateCampaign updateCampaignCreate(campaign)



DEPRECATED (use /v3/campaigns/ instead) Create an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
UpdateCampaignPostRequest campaign = new UpdateCampaignPostRequest(); // UpdateCampaignPostRequest | Update campaign
try {
    UpdateCampaign result = apiInstance.updateCampaignCreate(campaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaign** | [**UpdateCampaignPostRequest**](UpdateCampaignPostRequest.md)| Update campaign |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignDestroy"></a>
# **updateCampaignDestroy**
> Void updateCampaignDestroy(campaignId)



Delete an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The ID of the update campaign
try {
    Void result = apiInstance.updateCampaignDestroy(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The ID of the update campaign |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignList"></a>
# **updateCampaignList**
> UpdateCampaignPage updateCampaignList(limit, order, after, filter, include)



DEPRECATED (use /v3/campaigns/ instead) Get update campaigns for devices specified by a filter.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many update campaigns to retrieve
String order = "order_example"; // String | The order of the records. Acceptable values: ASC, DESC. Default: ASC
String after = "after_example"; // String | The ID of the the item after which to retrieve the next page
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data  `?filter={URL-encoded query string}`  The query string is made up of key-value pairs separated by ampersands. For example, this query: `key1=value1&key2=value2&key3=value3`  would be URL-encoded as: `?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3`   **Filtering by campaign properties** `state=[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]`  `root_manifest_id=43217771234242e594ddb433816c498a`  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: `2016-11-30T16:25:12.1234Z` * UTC RFC3339 without milliseconds. Example: `2016-11-30T16:25:12Z` * UTC RFC3339 shortened without milliseconds and punctuation. Example: `20161130T162512Z`  Date-time filtering supports three operators:  * equality * greater than or equal to by appending `__gte` to the field name * less than or equal to by appending `__lte` to the field name  `{field name}[|__lte|__gte]={UTC RFC3339 date-time}`  Time ranges may be specified by including both the `__gte` and `__lte` forms in the filter. For example:  `created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering on multiple fields**  `state=deployed&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: total_count
try {
    UpdateCampaignPage result = apiInstance.updateCampaignList(limit, order, after, filter, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many update campaigns to retrieve | [optional]
 **order** | **String**| The order of the records. Acceptable values: ASC, DESC. Default: ASC | [optional]
 **after** | **String**| The ID of the the item after which to retrieve the next page | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;   **Filtering by campaign properties** &#x60;state&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]&#x60;  &#x60;root_manifest_id&#x3D;43217771234242e594ddb433816c498a&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;state&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60; | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: total_count | [optional]

### Return type

[**UpdateCampaignPage**](UpdateCampaignPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignPartialUpdate"></a>
# **updateCampaignPartialUpdate**
> UpdateCampaign updateCampaignPartialUpdate(campaignId, campaign)



Modify a subset of an update campaign&#39;s fields.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | 
UpdateCampaignPatchRequest campaign = new UpdateCampaignPatchRequest(); // UpdateCampaignPatchRequest | Update campaign
try {
    UpdateCampaign result = apiInstance.updateCampaignPartialUpdate(campaignId, campaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignPartialUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**|  |
 **campaign** | [**UpdateCampaignPatchRequest**](UpdateCampaignPatchRequest.md)| Update campaign |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignRetrieve"></a>
# **updateCampaignRetrieve**
> UpdateCampaign updateCampaignRetrieve(campaignId)



Get an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The campaign ID
try {
    UpdateCampaign result = apiInstance.updateCampaignRetrieve(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignStop"></a>
# **updateCampaignStop**
> UpdateCampaign updateCampaignStop(campaignId)



Stop a running update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The campaign ID
try {
    UpdateCampaign result = apiInstance.updateCampaignStop(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignStop");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignUpdate"></a>
# **updateCampaignUpdate**
> UpdateCampaign updateCampaignUpdate(campaignId, campaign)



Modify an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | 
UpdateCampaignPutRequest campaign = new UpdateCampaignPutRequest(); // UpdateCampaignPutRequest | Update campaign
try {
    UpdateCampaign result = apiInstance.updateCampaignUpdate(campaignId, campaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**|  |
 **campaign** | [**UpdateCampaignPutRequest**](UpdateCampaignPutRequest.md)| Update campaign |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="v3CampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet"></a>
# **v3CampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet**
> CampaignDeviceMetadata v3CampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet(campaignId, campaignDeviceMetadataId)



Get update campaign metadata.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The update campaign ID
String campaignDeviceMetadataId = "campaignDeviceMetadataId_example"; // String | The campaign device metadata ID
try {
    CampaignDeviceMetadata result = apiInstance.v3CampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet(campaignId, campaignDeviceMetadataId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#v3CampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The update campaign ID |
 **campaignDeviceMetadataId** | **String**| The campaign device metadata ID |

### Return type

[**CampaignDeviceMetadata**](CampaignDeviceMetadata.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="v3CampaignsCampaignIdCampaignDeviceMetadataGet"></a>
# **v3CampaignsCampaignIdCampaignDeviceMetadataGet**
> CampaignDeviceMetadataPage v3CampaignsCampaignIdCampaignDeviceMetadataGet(campaignId, limit, order, after, include)



Get campaign device metadata.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The update campaign ID
Integer limit = 56; // Integer | How many objects to retrieve in the page
String order = "order_example"; // String | ASC or DESC
String after = "after_example"; // String | The ID of the the item after which to retrieve the next page
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: total_count
try {
    CampaignDeviceMetadataPage result = apiInstance.v3CampaignsCampaignIdCampaignDeviceMetadataGet(campaignId, limit, order, after, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#v3CampaignsCampaignIdCampaignDeviceMetadataGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The update campaign ID |
 **limit** | **Integer**| How many objects to retrieve in the page | [optional]
 **order** | **String**| ASC or DESC | [optional]
 **after** | **String**| The ID of the the item after which to retrieve the next page | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: total_count | [optional]

### Return type

[**CampaignDeviceMetadataPage**](CampaignDeviceMetadataPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet"></a>
# **v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet**
> CampaignDeviceMetadata v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet(campaignId, campaignDeviceMetadataId)



DEPRECATED (use /v3/campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/ instead) Get update campaign metadata.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The update campaign ID
String campaignDeviceMetadataId = "campaignDeviceMetadataId_example"; // String | The campaign device metadata ID
try {
    CampaignDeviceMetadata result = apiInstance.v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet(campaignId, campaignDeviceMetadataId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The update campaign ID |
 **campaignDeviceMetadataId** | **String**| The campaign device metadata ID |

### Return type

[**CampaignDeviceMetadata**](CampaignDeviceMetadata.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet"></a>
# **v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet**
> CampaignDeviceMetadataPage v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet(campaignId, limit, order, after, include)



DEPRECATED (use /v3/campaigns/{campaign_id}/campaign-device-metadata/ instead) Get campaign device metadata.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.updateservice.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String campaignId = "campaignId_example"; // String | The update campaign ID
Integer limit = 56; // Integer | How many objects to retrieve in the page
String order = "order_example"; // String | ASC or DESC
String after = "after_example"; // String | The ID of the the item after which to retrieve the next page
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: total_count
try {
    CampaignDeviceMetadataPage result = apiInstance.v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet(campaignId, limit, order, after, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The update campaign ID |
 **limit** | **Integer**| How many objects to retrieve in the page | [optional]
 **order** | **String**| ASC or DESC | [optional]
 **after** | **String**| The ID of the the item after which to retrieve the next page | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: total_count | [optional]

### Return type

[**CampaignDeviceMetadataPage**](CampaignDeviceMetadataPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

