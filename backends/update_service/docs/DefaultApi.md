# DefaultApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**firmwareImageCreate**](DefaultApi.md#firmwareImageCreate) | **POST** v3/firmware-images/ | Create an image
[**firmwareImageDestroy**](DefaultApi.md#firmwareImageDestroy) | **DELETE** v3/firmware-images/{image_id}/ | Delete an image
[**firmwareImageList**](DefaultApi.md#firmwareImageList) | **GET** v3/firmware-images/ | List all images
[**firmwareImageRetrieve**](DefaultApi.md#firmwareImageRetrieve) | **GET** v3/firmware-images/{image_id}/ | Get an image
[**firmwareManifestCreate**](DefaultApi.md#firmwareManifestCreate) | **POST** v3/firmware-manifests/ | Create a manifest
[**firmwareManifestDestroy**](DefaultApi.md#firmwareManifestDestroy) | **DELETE** v3/firmware-manifests/{manifest_id}/ | Delete a manifest
[**firmwareManifestList**](DefaultApi.md#firmwareManifestList) | **GET** v3/firmware-manifests/ | List manifests
[**firmwareManifestRetrieve**](DefaultApi.md#firmwareManifestRetrieve) | **GET** v3/firmware-manifests/{manifest_id}/ | Get a manifest
[**updateCampaignArchive**](DefaultApi.md#updateCampaignArchive) | **POST** v3/update-campaigns/{campaign_id}/archive | Archive a campaign.
[**updateCampaignCreate**](DefaultApi.md#updateCampaignCreate) | **POST** v3/update-campaigns/ | Create a campaign
[**updateCampaignDestroy**](DefaultApi.md#updateCampaignDestroy) | **DELETE** v3/update-campaigns/{campaign_id}/ | Delete a campaign
[**updateCampaignList**](DefaultApi.md#updateCampaignList) | **GET** v3/update-campaigns/ | List all campaigns
[**updateCampaignMetadataList**](DefaultApi.md#updateCampaignMetadataList) | **GET** v3/update-campaigns/{campaign_id}/campaign-device-metadata/ | List all campaign device metadata
[**updateCampaignMetadataRetrieve**](DefaultApi.md#updateCampaignMetadataRetrieve) | **GET** v3/update-campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/ | Get a campaign device metadata
[**updateCampaignMetrics**](DefaultApi.md#updateCampaignMetrics) | **GET** v3/update-campaigns/{campaign_id}/metrics | Get campaign metrics
[**updateCampaignRetrieve**](DefaultApi.md#updateCampaignRetrieve) | **GET** v3/update-campaigns/{campaign_id}/ | Get a campaign.
[**updateCampaignStart**](DefaultApi.md#updateCampaignStart) | **POST** v3/update-campaigns/{campaign_id}/start | Start a campaign.
[**updateCampaignStop**](DefaultApi.md#updateCampaignStop) | **POST** v3/update-campaigns/{campaign_id}/stop | Stop a campaign.
[**updateCampaignUpdate**](DefaultApi.md#updateCampaignUpdate) | **PUT** v3/update-campaigns/{campaign_id}/ | Modify a campaign


<a name="firmwareImageCreate"></a>
# **firmwareImageCreate**
> FirmwareImage firmwareImageCreate(datafile, name, description)

Create an image

Create a firmware image.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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

Delete an image

Delete a firmware image.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
> FirmwareImagePage firmwareImageList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileChecksumEq, datafileChecksumNeq, datafileChecksumIn, datafileChecksumNin, datafileSizeEq, datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, timestampEq, timestampNeq, timestampIn, timestampNin, timestampLte, timestampGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include)

List all images

List all firmware images.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
String createdAtEq = "createdAtEq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNeq = "createdAtNeq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtIn = "createdAtIn_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNin = "createdAtNin_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtLte = "createdAtLte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtGte = "createdAtGte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String datafileEq = "datafileEq_example"; // String | Filter for datafile
String datafileNeq = "datafileNeq_example"; // String | Filter for datafile
String datafileIn = "datafileIn_example"; // String | Filter for datafile
String datafileNin = "datafileNin_example"; // String | Filter for datafile
String datafileChecksumEq = "datafileChecksumEq_example"; // String | Filter for datafile_checksum
String datafileChecksumNeq = "datafileChecksumNeq_example"; // String | Filter for datafile_checksum
String datafileChecksumIn = "datafileChecksumIn_example"; // String | Filter for datafile_checksum
String datafileChecksumNin = "datafileChecksumNin_example"; // String | Filter for datafile_checksum
String datafileSizeEq = "datafileSizeEq_example"; // String | Filter for datafile_size
String datafileSizeNeq = "datafileSizeNeq_example"; // String | Filter for datafile_size
String datafileSizeIn = "datafileSizeIn_example"; // String | Filter for datafile_size
String datafileSizeNin = "datafileSizeNin_example"; // String | Filter for datafile_size
String descriptionEq = "descriptionEq_example"; // String | Filter for description
String descriptionNeq = "descriptionNeq_example"; // String | Filter for description
String descriptionIn = "descriptionIn_example"; // String | Filter for description
String descriptionNin = "descriptionNin_example"; // String | Filter for description
String etagEq = "etagEq_example"; // String | Filter for etag
String etagNeq = "etagNeq_example"; // String | Filter for etag
String etagIn = "etagIn_example"; // String | Filter for etag
String etagNin = "etagNin_example"; // String | Filter for etag
String etagLte = "etagLte_example"; // String | Filter for etag
String etagGte = "etagGte_example"; // String | Filter for etag
String idEq = "idEq_example"; // String | Filter for id
String idNeq = "idNeq_example"; // String | Filter for id
String idIn = "idIn_example"; // String | Filter for id
String idNin = "idNin_example"; // String | Filter for id
String nameEq = "nameEq_example"; // String | Filter for name
String nameNeq = "nameNeq_example"; // String | Filter for name
String nameIn = "nameIn_example"; // String | Filter for name
String nameNin = "nameNin_example"; // String | Filter for name
String timestampEq = "timestampEq_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampNeq = "timestampNeq_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampIn = "timestampIn_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampNin = "timestampNin_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampLte = "timestampLte_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampGte = "timestampGte_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtEq = "updatedAtEq_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtNeq = "updatedAtNeq_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtIn = "updatedAtIn_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtNin = "updatedAtNin_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtLte = "updatedAtLte_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtGte = "updatedAtGte_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count
try {
    FirmwareImagePage result = apiInstance.firmwareImageList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileChecksumEq, datafileChecksumNeq, datafileChecksumIn, datafileChecksumNin, datafileSizeEq, datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, timestampEq, timestampNeq, timestampIn, timestampNin, timestampLte, timestampGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include);
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
 **createdAtEq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNeq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtIn** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNin** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtLte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtGte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **datafileEq** | **String**| Filter for datafile | [optional]
 **datafileNeq** | **String**| Filter for datafile | [optional]
 **datafileIn** | **String**| Filter for datafile | [optional]
 **datafileNin** | **String**| Filter for datafile | [optional]
 **datafileChecksumEq** | **String**| Filter for datafile_checksum | [optional]
 **datafileChecksumNeq** | **String**| Filter for datafile_checksum | [optional]
 **datafileChecksumIn** | **String**| Filter for datafile_checksum | [optional]
 **datafileChecksumNin** | **String**| Filter for datafile_checksum | [optional]
 **datafileSizeEq** | **String**| Filter for datafile_size | [optional]
 **datafileSizeNeq** | **String**| Filter for datafile_size | [optional]
 **datafileSizeIn** | **String**| Filter for datafile_size | [optional]
 **datafileSizeNin** | **String**| Filter for datafile_size | [optional]
 **descriptionEq** | **String**| Filter for description | [optional]
 **descriptionNeq** | **String**| Filter for description | [optional]
 **descriptionIn** | **String**| Filter for description | [optional]
 **descriptionNin** | **String**| Filter for description | [optional]
 **etagEq** | **String**| Filter for etag | [optional]
 **etagNeq** | **String**| Filter for etag | [optional]
 **etagIn** | **String**| Filter for etag | [optional]
 **etagNin** | **String**| Filter for etag | [optional]
 **etagLte** | **String**| Filter for etag | [optional]
 **etagGte** | **String**| Filter for etag | [optional]
 **idEq** | **String**| Filter for id | [optional]
 **idNeq** | **String**| Filter for id | [optional]
 **idIn** | **String**| Filter for id | [optional]
 **idNin** | **String**| Filter for id | [optional]
 **nameEq** | **String**| Filter for name | [optional]
 **nameNeq** | **String**| Filter for name | [optional]
 **nameIn** | **String**| Filter for name | [optional]
 **nameNin** | **String**| Filter for name | [optional]
 **timestampEq** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampNeq** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampIn** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampNin** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampLte** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampGte** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtEq** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtNeq** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtIn** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtNin** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtLte** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtGte** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count | [optional]

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

Get an image

Retrieve a firmware image.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
> FirmwareManifest firmwareManifestCreate(datafile, name, description, keyTable)

Create a manifest

Create a firmware manifest.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
File keyTable = new File("/path/to/file.txt"); // File | The key table of pre-shared keys for devices
try {
    FirmwareManifest result = apiInstance.firmwareManifestCreate(datafile, name, description, keyTable);
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
 **keyTable** | **File**| The key table of pre-shared keys for devices | [optional]

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

Delete a manifest

Delete a firmware manifest.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
> FirmwareManifestPage firmwareManifestList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileSizeEq, datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, timestampEq, timestampNeq, timestampIn, timestampNin, timestampLte, timestampGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include)

List manifests

List firmware manifests.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
String after = "after_example"; // String | The ID of the the item after which to retrieve the next page
String createdAtEq = "createdAtEq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNeq = "createdAtNeq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtIn = "createdAtIn_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNin = "createdAtNin_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtLte = "createdAtLte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtGte = "createdAtGte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String datafileEq = "datafileEq_example"; // String | Filter for datafile
String datafileNeq = "datafileNeq_example"; // String | Filter for datafile
String datafileIn = "datafileIn_example"; // String | Filter for datafile
String datafileNin = "datafileNin_example"; // String | Filter for datafile
String datafileSizeEq = "datafileSizeEq_example"; // String | Filter for datafile_size
String datafileSizeNeq = "datafileSizeNeq_example"; // String | Filter for datafile_size
String datafileSizeIn = "datafileSizeIn_example"; // String | Filter for datafile_size
String datafileSizeNin = "datafileSizeNin_example"; // String | Filter for datafile_size
String descriptionEq = "descriptionEq_example"; // String | Filter for description
String descriptionNeq = "descriptionNeq_example"; // String | Filter for description
String descriptionIn = "descriptionIn_example"; // String | Filter for description
String descriptionNin = "descriptionNin_example"; // String | Filter for description
String deviceClassEq = "deviceClassEq_example"; // String | Filter for device_class
String deviceClassNeq = "deviceClassNeq_example"; // String | Filter for device_class
String deviceClassIn = "deviceClassIn_example"; // String | Filter for device_class
String deviceClassNin = "deviceClassNin_example"; // String | Filter for device_class
String etagEq = "etagEq_example"; // String | Filter for etag
String etagNeq = "etagNeq_example"; // String | Filter for etag
String etagIn = "etagIn_example"; // String | Filter for etag
String etagNin = "etagNin_example"; // String | Filter for etag
String etagLte = "etagLte_example"; // String | Filter for etag
String etagGte = "etagGte_example"; // String | Filter for etag
String idEq = "idEq_example"; // String | Filter for id
String idNeq = "idNeq_example"; // String | Filter for id
String idIn = "idIn_example"; // String | Filter for id
String idNin = "idNin_example"; // String | Filter for id
String nameEq = "nameEq_example"; // String | Filter for name
String nameNeq = "nameNeq_example"; // String | Filter for name
String nameIn = "nameIn_example"; // String | Filter for name
String nameNin = "nameNin_example"; // String | Filter for name
String timestampEq = "timestampEq_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampNeq = "timestampNeq_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampIn = "timestampIn_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampNin = "timestampNin_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampLte = "timestampLte_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String timestampGte = "timestampGte_example"; // String | Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtEq = "updatedAtEq_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtNeq = "updatedAtNeq_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtIn = "updatedAtIn_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtNin = "updatedAtNin_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtLte = "updatedAtLte_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtGte = "updatedAtGte_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count
try {
    FirmwareManifestPage result = apiInstance.firmwareManifestList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileSizeEq, datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, timestampEq, timestampNeq, timestampIn, timestampNin, timestampLte, timestampGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include);
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
 **after** | **String**| The ID of the the item after which to retrieve the next page | [optional]
 **createdAtEq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNeq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtIn** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNin** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtLte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtGte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **datafileEq** | **String**| Filter for datafile | [optional]
 **datafileNeq** | **String**| Filter for datafile | [optional]
 **datafileIn** | **String**| Filter for datafile | [optional]
 **datafileNin** | **String**| Filter for datafile | [optional]
 **datafileSizeEq** | **String**| Filter for datafile_size | [optional]
 **datafileSizeNeq** | **String**| Filter for datafile_size | [optional]
 **datafileSizeIn** | **String**| Filter for datafile_size | [optional]
 **datafileSizeNin** | **String**| Filter for datafile_size | [optional]
 **descriptionEq** | **String**| Filter for description | [optional]
 **descriptionNeq** | **String**| Filter for description | [optional]
 **descriptionIn** | **String**| Filter for description | [optional]
 **descriptionNin** | **String**| Filter for description | [optional]
 **deviceClassEq** | **String**| Filter for device_class | [optional]
 **deviceClassNeq** | **String**| Filter for device_class | [optional]
 **deviceClassIn** | **String**| Filter for device_class | [optional]
 **deviceClassNin** | **String**| Filter for device_class | [optional]
 **etagEq** | **String**| Filter for etag | [optional]
 **etagNeq** | **String**| Filter for etag | [optional]
 **etagIn** | **String**| Filter for etag | [optional]
 **etagNin** | **String**| Filter for etag | [optional]
 **etagLte** | **String**| Filter for etag | [optional]
 **etagGte** | **String**| Filter for etag | [optional]
 **idEq** | **String**| Filter for id | [optional]
 **idNeq** | **String**| Filter for id | [optional]
 **idIn** | **String**| Filter for id | [optional]
 **idNin** | **String**| Filter for id | [optional]
 **nameEq** | **String**| Filter for name | [optional]
 **nameNeq** | **String**| Filter for name | [optional]
 **nameIn** | **String**| Filter for name | [optional]
 **nameNin** | **String**| Filter for name | [optional]
 **timestampEq** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampNeq** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampIn** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampNin** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampLte** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **timestampGte** | **String**| Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtEq** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtNeq** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtIn** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtNin** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtLte** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtGte** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count | [optional]

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

Get a manifest

Retrieve a firmware manifest.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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

<a name="updateCampaignArchive"></a>
# **updateCampaignArchive**
> Void updateCampaignArchive(campaignId)

Archive a campaign.

This command will archive a campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
    Void result = apiInstance.updateCampaignArchive(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignArchive");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignCreate"></a>
# **updateCampaignCreate**
> UpdateCampaign updateCampaignCreate(campaign)

Create a campaign

Create an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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

Delete a campaign

Delete an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
> UpdateCampaignPage updateCampaignList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceFilterEq, deviceFilterNeq, deviceFilterIn, deviceFilterNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, finishedEq, finishedNeq, finishedIn, finishedNin, finishedLte, finishedGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, rootManifestIdEq, rootManifestIdNeq, rootManifestIdIn, rootManifestIdNin, startedAtEq, startedAtNeq, startedAtIn, startedAtNin, startedAtLte, startedAtGte, stateEq, stateNeq, stateIn, stateNin, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, whenEq, whenNeq, whenIn, whenNin, whenLte, whenGte, include)

List all campaigns

Get update campaigns for devices specified by a filter.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
String createdAtEq = "createdAtEq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNeq = "createdAtNeq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtIn = "createdAtIn_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNin = "createdAtNin_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtLte = "createdAtLte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtGte = "createdAtGte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String descriptionEq = "descriptionEq_example"; // String | Filter for description
String descriptionNeq = "descriptionNeq_example"; // String | Filter for description
String descriptionIn = "descriptionIn_example"; // String | Filter for description
String descriptionNin = "descriptionNin_example"; // String | Filter for description
String deviceFilterEq = "deviceFilterEq_example"; // String | Filter for device_filter
String deviceFilterNeq = "deviceFilterNeq_example"; // String | Filter for device_filter
String deviceFilterIn = "deviceFilterIn_example"; // String | Filter for device_filter
String deviceFilterNin = "deviceFilterNin_example"; // String | Filter for device_filter
String etagEq = "etagEq_example"; // String | Filter for etag
String etagNeq = "etagNeq_example"; // String | Filter for etag
String etagIn = "etagIn_example"; // String | Filter for etag
String etagNin = "etagNin_example"; // String | Filter for etag
String etagLte = "etagLte_example"; // String | Filter for etag
String etagGte = "etagGte_example"; // String | Filter for etag
String finishedEq = "finishedEq_example"; // String | Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String finishedNeq = "finishedNeq_example"; // String | Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String finishedIn = "finishedIn_example"; // String | Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String finishedNin = "finishedNin_example"; // String | Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String finishedLte = "finishedLte_example"; // String | Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String finishedGte = "finishedGte_example"; // String | Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String idEq = "idEq_example"; // String | Filter for id
String idNeq = "idNeq_example"; // String | Filter for id
String idIn = "idIn_example"; // String | Filter for id
String idNin = "idNin_example"; // String | Filter for id
String nameEq = "nameEq_example"; // String | Filter for name
String nameNeq = "nameNeq_example"; // String | Filter for name
String nameIn = "nameIn_example"; // String | Filter for name
String nameNin = "nameNin_example"; // String | Filter for name
String rootManifestIdEq = "rootManifestIdEq_example"; // String | Filter for root_manifest_id
String rootManifestIdNeq = "rootManifestIdNeq_example"; // String | Filter for root_manifest_id
String rootManifestIdIn = "rootManifestIdIn_example"; // String | Filter for root_manifest_id
String rootManifestIdNin = "rootManifestIdNin_example"; // String | Filter for root_manifest_id
String startedAtEq = "startedAtEq_example"; // String | Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String startedAtNeq = "startedAtNeq_example"; // String | Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String startedAtIn = "startedAtIn_example"; // String | Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String startedAtNin = "startedAtNin_example"; // String | Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String startedAtLte = "startedAtLte_example"; // String | Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String startedAtGte = "startedAtGte_example"; // String | Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String stateEq = "stateEq_example"; // String | Filter for state
String stateNeq = "stateNeq_example"; // String | Filter for state
String stateIn = "stateIn_example"; // String | Filter for state
String stateNin = "stateNin_example"; // String | Filter for state
String updatedAtEq = "updatedAtEq_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtNeq = "updatedAtNeq_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtIn = "updatedAtIn_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtNin = "updatedAtNin_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtLte = "updatedAtLte_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtGte = "updatedAtGte_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String whenEq = "whenEq_example"; // String | Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String whenNeq = "whenNeq_example"; // String | Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String whenIn = "whenIn_example"; // String | Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String whenNin = "whenNin_example"; // String | Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String whenLte = "whenLte_example"; // String | Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String whenGte = "whenGte_example"; // String | Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count
try {
    UpdateCampaignPage result = apiInstance.updateCampaignList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceFilterEq, deviceFilterNeq, deviceFilterIn, deviceFilterNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, finishedEq, finishedNeq, finishedIn, finishedNin, finishedLte, finishedGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, rootManifestIdEq, rootManifestIdNeq, rootManifestIdIn, rootManifestIdNin, startedAtEq, startedAtNeq, startedAtIn, startedAtNin, startedAtLte, startedAtGte, stateEq, stateNeq, stateIn, stateNin, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, whenEq, whenNeq, whenIn, whenNin, whenLte, whenGte, include);
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
 **createdAtEq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNeq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtIn** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNin** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtLte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtGte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **descriptionEq** | **String**| Filter for description | [optional]
 **descriptionNeq** | **String**| Filter for description | [optional]
 **descriptionIn** | **String**| Filter for description | [optional]
 **descriptionNin** | **String**| Filter for description | [optional]
 **deviceFilterEq** | **String**| Filter for device_filter | [optional]
 **deviceFilterNeq** | **String**| Filter for device_filter | [optional]
 **deviceFilterIn** | **String**| Filter for device_filter | [optional]
 **deviceFilterNin** | **String**| Filter for device_filter | [optional]
 **etagEq** | **String**| Filter for etag | [optional]
 **etagNeq** | **String**| Filter for etag | [optional]
 **etagIn** | **String**| Filter for etag | [optional]
 **etagNin** | **String**| Filter for etag | [optional]
 **etagLte** | **String**| Filter for etag | [optional]
 **etagGte** | **String**| Filter for etag | [optional]
 **finishedEq** | **String**| Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **finishedNeq** | **String**| Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **finishedIn** | **String**| Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **finishedNin** | **String**| Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **finishedLte** | **String**| Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **finishedGte** | **String**| Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **idEq** | **String**| Filter for id | [optional]
 **idNeq** | **String**| Filter for id | [optional]
 **idIn** | **String**| Filter for id | [optional]
 **idNin** | **String**| Filter for id | [optional]
 **nameEq** | **String**| Filter for name | [optional]
 **nameNeq** | **String**| Filter for name | [optional]
 **nameIn** | **String**| Filter for name | [optional]
 **nameNin** | **String**| Filter for name | [optional]
 **rootManifestIdEq** | **String**| Filter for root_manifest_id | [optional]
 **rootManifestIdNeq** | **String**| Filter for root_manifest_id | [optional]
 **rootManifestIdIn** | **String**| Filter for root_manifest_id | [optional]
 **rootManifestIdNin** | **String**| Filter for root_manifest_id | [optional]
 **startedAtEq** | **String**| Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **startedAtNeq** | **String**| Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **startedAtIn** | **String**| Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **startedAtNin** | **String**| Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **startedAtLte** | **String**| Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **startedAtGte** | **String**| Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **stateEq** | **String**| Filter for state | [optional]
 **stateNeq** | **String**| Filter for state | [optional]
 **stateIn** | **String**| Filter for state | [optional]
 **stateNin** | **String**| Filter for state | [optional]
 **updatedAtEq** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtNeq** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtIn** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtNin** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtLte** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtGte** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **whenEq** | **String**| Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **whenNeq** | **String**| Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **whenIn** | **String**| Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **whenNin** | **String**| Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **whenLte** | **String**| Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **whenGte** | **String**| Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count | [optional]

### Return type

[**UpdateCampaignPage**](UpdateCampaignPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignMetadataList"></a>
# **updateCampaignMetadataList**
> CampaignDeviceMetadataPage updateCampaignMetadataList(campaignId, limit, order, after, include)

List all campaign device metadata

Get campaign device metadata.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count
try {
    CampaignDeviceMetadataPage result = apiInstance.updateCampaignMetadataList(campaignId, limit, order, after, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignMetadataList");
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
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count | [optional]

### Return type

[**CampaignDeviceMetadataPage**](CampaignDeviceMetadataPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignMetadataRetrieve"></a>
# **updateCampaignMetadataRetrieve**
> CampaignDeviceMetadata updateCampaignMetadataRetrieve(campaignId, campaignDeviceMetadataId)

Get a campaign device metadata

Get update campaign metadata.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
    CampaignDeviceMetadata result = apiInstance.updateCampaignMetadataRetrieve(campaignId, campaignDeviceMetadataId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignMetadataRetrieve");
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

<a name="updateCampaignMetrics"></a>
# **updateCampaignMetrics**
> CampaignMetrics updateCampaignMetrics(campaignId)

Get campaign metrics

Get detailed statistics of a campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
    CampaignMetrics result = apiInstance.updateCampaignMetrics(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignMetrics");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID |

### Return type

[**CampaignMetrics**](CampaignMetrics.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignRetrieve"></a>
# **updateCampaignRetrieve**
> UpdateCampaign updateCampaignRetrieve(campaignId)

Get a campaign.

Get an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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

<a name="updateCampaignStart"></a>
# **updateCampaignStart**
> Void updateCampaignStart(campaignId)

Start a campaign.

This command will begin the process of starting a campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
    Void result = apiInstance.updateCampaignStart(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateCampaignStart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignStop"></a>
# **updateCampaignStop**
> Void updateCampaignStop(campaignId)

Stop a campaign.

This command will begin the process of stopping a campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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
    Void result = apiInstance.updateCampaignStop(campaignId);
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

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignUpdate"></a>
# **updateCampaignUpdate**
> UpdateCampaign updateCampaignUpdate(campaignId, campaign)

Modify a campaign

Modify an update campaign.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.updateservice.ApiException;
//import com.arm.mbed.cloud.sdk.internal.updateservice.Configuration;
//import com.arm.mbed.cloud.sdk.internal.updateservice.auth.*;
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

