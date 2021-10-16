# DeviceUpdateFirmwareImagesApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**firmwareImageCreate**](DeviceUpdateFirmwareImagesApi.md#firmwareImageCreate) | **POST** v3/firmware-images | Create an image
[**firmwareImageDestroy**](DeviceUpdateFirmwareImagesApi.md#firmwareImageDestroy) | **DELETE** v3/firmware-images/{image_id} | Delete an image
[**firmwareImageList**](DeviceUpdateFirmwareImagesApi.md#firmwareImageList) | **GET** v3/firmware-images | List all images
[**firmwareImageRetrieve**](DeviceUpdateFirmwareImagesApi.md#firmwareImageRetrieve) | **GET** v3/firmware-images/{image_id} | Get an image.
[**uploadJobChunkCreate**](DeviceUpdateFirmwareImagesApi.md#uploadJobChunkCreate) | **POST** v3/firmware-images/upload-jobs/{upload_job_id}/chunks | Append a chunk to an upload job
[**uploadJobChunkList**](DeviceUpdateFirmwareImagesApi.md#uploadJobChunkList) | **GET** v3/firmware-images/upload-jobs/{upload_job_id}/chunks | List all metadata for uploaded chunks
[**uploadJobChunkRetreive**](DeviceUpdateFirmwareImagesApi.md#uploadJobChunkRetreive) | **GET** v3/firmware-images/upload-jobs/{upload_job_id}/chunks/{chunk_id} | Get metadata about a chunk
[**uploadJobCreate**](DeviceUpdateFirmwareImagesApi.md#uploadJobCreate) | **POST** v3/firmware-images/upload-jobs | Create a new upload job.
[**uploadJobDelete**](DeviceUpdateFirmwareImagesApi.md#uploadJobDelete) | **DELETE** v3/firmware-images/upload-jobs/{upload_job_id} | Delete an upload job
[**uploadJobList**](DeviceUpdateFirmwareImagesApi.md#uploadJobList) | **GET** v3/firmware-images/upload-jobs | Get all upload jobs
[**uploadJobRetrieve**](DeviceUpdateFirmwareImagesApi.md#uploadJobRetrieve) | **GET** v3/firmware-images/upload-jobs/{upload_job_id} | Retrieve information for an upload job
[**uploadJobUpdate**](DeviceUpdateFirmwareImagesApi.md#uploadJobUpdate) | **PUT** v3/firmware-images/upload-jobs/{upload_job_id} | Update an upload job


<a name="firmwareImageCreate"></a>
# **firmwareImageCreate**
> FirmwareImage firmwareImageCreate(datafile, description, name)

Create an image

Create a firmware image. &lt;BR/&gt; **Note:** Only use this API for images smaller than 100 MB. For larger images, [upload in chunks](https://developer.pelion.com/docs/device-management/current/updating-firmware/uploading-a-large-firmware-image.html). &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/firmware-images \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;Content-Type: multipart/form-data&#39; \\ -F &#39;datafile&#x3D;@myimage.bin;type&#x3D;application/octet-stream&#39; -F &#39;description&#x3D;bla bla&#39; \\ -F &#39;name&#x3D;My Linux Image&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
File datafile = new File("/path/to/file.txt"); // File | The firmware image file to upload. File name must not exceed 166 characters.
String description = "description_example"; // String | The description of the firmware image.
String name = "name_example"; // String | The name of the firmware image.
try {
    FirmwareImage result = apiInstance.firmwareImageCreate(datafile, description, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#firmwareImageCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **datafile** | **File**| The firmware image file to upload. File name must not exceed 166 characters. |
 **description** | **String**| The description of the firmware image. | [optional]
 **name** | **String**| The name of the firmware image. | [optional]

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

Delete a firmware image. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/firmware-images/11234567f9012ab56790120000789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
String imageId = "imageId_example"; // String | The firmware image ID.
try {
    Void result = apiInstance.firmwareImageDestroy(imageId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#firmwareImageDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **imageId** | **String**| The firmware image ID. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="firmwareImageList"></a>
# **firmwareImageList**
> FirmwareImagePage firmwareImageList(limit, order, after, include, filter, createdAtIn, createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileChecksumEq, datafileChecksumNeq, datafileChecksumIn, datafileChecksumNin, datafileSizeEq, datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte)

List all images

List all firmware images. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/firmware-images \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | ASC or DESC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data.  `?filter={URL-encoded query string}`  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>created_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>datafile</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>datafile_checksum</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>datafile_size</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>description</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>etag</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>name</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>updated_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>   </tbody> </table> &nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: `key1=value1&key2=value2&key3=value3`  would be URL-encoded as: `?filter=key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3`   **Filtering by properties** `name__eq=myimage`  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: `2016-11-30T16:25:12.1234Z` * UTC RFC3339 without milliseconds. Example: `2016-11-30T16:25:12Z` * UTC RFC3339 shortened without milliseconds and punctuation. Example: `20161130T162512Z`  Date-time filtering supports three operators:  * equality by appending `__eq` to the field name * greater than or equal to by appending `__gte` to the field name * less than or equal to by appending `__lte` to the field name  `{field name}[|__eq|__lte|__gte]={UTC RFC3339 date-time}`  Time ranges may be specified by including both the `__gte` and `__lte` forms in the filter. For example:  `created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering on multiple fields**  `name__eq=myimage&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: `__eq` * non-equality: `__neq` * in : `__in` * not in: `__nin`  For `__in` and `__nin` filters list of parameters must be comma-separated:  `name__in=fw-image1,fw-image2`
String createdAtIn = "createdAtIn_example"; // String | in filter for the \"created_at\" field
String createdAtNin = "createdAtNin_example"; // String | nin filter for the \"created_at\" field
DateTime createdAtLte = new DateTime(); // DateTime | lte filter for the \"created_at\" field
DateTime createdAtGte = new DateTime(); // DateTime | gte filter for the \"created_at\" field
String datafileEq = "datafileEq_example"; // String | eq filter for the \"datafile\" field
String datafileNeq = "datafileNeq_example"; // String | neq filter for the \"datafile\" field
String datafileIn = "datafileIn_example"; // String | in filter for the \"datafile\" field
String datafileNin = "datafileNin_example"; // String | nin filter for the \"datafile\" field
String datafileChecksumEq = "datafileChecksumEq_example"; // String | eq filter for the \"datafile_checksum\" field
String datafileChecksumNeq = "datafileChecksumNeq_example"; // String | neq filter for the \"datafile_checksum\" field
String datafileChecksumIn = "datafileChecksumIn_example"; // String | in filter for the \"datafile_checksum\" field
String datafileChecksumNin = "datafileChecksumNin_example"; // String | nin filter for the \"datafile_checksum\" field
Long datafileSizeEq = 789L; // Long | eq filter for the \"datafile_size\" field
Long datafileSizeNeq = 789L; // Long | neq filter for the \"datafile_size\" field
String datafileSizeIn = "datafileSizeIn_example"; // String | in filter for the \"datafile_size\" field
String datafileSizeNin = "datafileSizeNin_example"; // String | nin filter for the \"datafile_size\" field
String descriptionEq = "descriptionEq_example"; // String | eq filter for the \"description\" field
String descriptionNeq = "descriptionNeq_example"; // String | neq filter for the \"description\" field
String descriptionIn = "descriptionIn_example"; // String | in filter for the \"description\" field
String descriptionNin = "descriptionNin_example"; // String | nin filter for the \"description\" field
String idEq = "idEq_example"; // String | eq filter for the \"id\" field
String idNeq = "idNeq_example"; // String | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
String nameEq = "nameEq_example"; // String | eq filter for the \"name\" field
String nameNeq = "nameNeq_example"; // String | neq filter for the \"name\" field
String nameIn = "nameIn_example"; // String | in filter for the \"name\" field
String nameNin = "nameNin_example"; // String | nin filter for the \"name\" field
String updatedAtIn = "updatedAtIn_example"; // String | in filter for the \"updated_at\" field
String updatedAtNin = "updatedAtNin_example"; // String | nin filter for the \"updated_at\" field
DateTime updatedAtLte = new DateTime(); // DateTime | lte filter for the \"updated_at\" field
DateTime updatedAtGte = new DateTime(); // DateTime | gte filter for the \"updated_at\" field
try {
    FirmwareImagePage result = apiInstance.firmwareImageList(limit, order, after, include, filter, createdAtIn, createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileChecksumEq, datafileChecksumNeq, datafileChecksumIn, datafileChecksumNin, datafileSizeEq, datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#firmwareImageList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| ASC or DESC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count. | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data.  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;datafile&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;datafile_checksum&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;datafile_size&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by properties** &#x60;name__eq&#x3D;myimage&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;name__eq&#x3D;myimage&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; | [optional]
 **createdAtIn** | **String**| in filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtNin** | **String**| nin filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtLte** | **DateTime**| lte filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtGte** | **DateTime**| gte filter for the \&quot;created_at\&quot; field | [optional]
 **datafileEq** | **String**| eq filter for the \&quot;datafile\&quot; field | [optional]
 **datafileNeq** | **String**| neq filter for the \&quot;datafile\&quot; field | [optional]
 **datafileIn** | **String**| in filter for the \&quot;datafile\&quot; field | [optional]
 **datafileNin** | **String**| nin filter for the \&quot;datafile\&quot; field | [optional]
 **datafileChecksumEq** | **String**| eq filter for the \&quot;datafile_checksum\&quot; field | [optional]
 **datafileChecksumNeq** | **String**| neq filter for the \&quot;datafile_checksum\&quot; field | [optional]
 **datafileChecksumIn** | **String**| in filter for the \&quot;datafile_checksum\&quot; field | [optional]
 **datafileChecksumNin** | **String**| nin filter for the \&quot;datafile_checksum\&quot; field | [optional]
 **datafileSizeEq** | **Long**| eq filter for the \&quot;datafile_size\&quot; field | [optional]
 **datafileSizeNeq** | **Long**| neq filter for the \&quot;datafile_size\&quot; field | [optional]
 **datafileSizeIn** | **String**| in filter for the \&quot;datafile_size\&quot; field | [optional]
 **datafileSizeNin** | **String**| nin filter for the \&quot;datafile_size\&quot; field | [optional]
 **descriptionEq** | **String**| eq filter for the \&quot;description\&quot; field | [optional]
 **descriptionNeq** | **String**| neq filter for the \&quot;description\&quot; field | [optional]
 **descriptionIn** | **String**| in filter for the \&quot;description\&quot; field | [optional]
 **descriptionNin** | **String**| nin filter for the \&quot;description\&quot; field | [optional]
 **idEq** | **String**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **String**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **nameEq** | **String**| eq filter for the \&quot;name\&quot; field | [optional]
 **nameNeq** | **String**| neq filter for the \&quot;name\&quot; field | [optional]
 **nameIn** | **String**| in filter for the \&quot;name\&quot; field | [optional]
 **nameNin** | **String**| nin filter for the \&quot;name\&quot; field | [optional]
 **updatedAtIn** | **String**| in filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtNin** | **String**| nin filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtLte** | **DateTime**| lte filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtGte** | **DateTime**| gte filter for the \&quot;updated_at\&quot; field | [optional]

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

Get an image.

Retrieve a firmware image. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/firmware-images/1123456f9012ab567890120000789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
String imageId = "imageId_example"; // String | The firmware image ID
try {
    FirmwareImage result = apiInstance.firmwareImageRetrieve(imageId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#firmwareImageRetrieve");
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

<a name="uploadJobChunkCreate"></a>
# **uploadJobChunkCreate**
> UploadChunkInfo uploadJobChunkCreate(contentMD5, contentLength, uploadJobId, chunk)

Append a chunk to an upload job

Append a chunk to an upload job. To finish a job, upload a zero-length chunk. &lt;BR/&gt; **Note:** Chunk size must be between 5MB and 100MB, the last chunk can be less than 5MB; the maximum number of chunks is limited to 10,000. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;Content-MD5: Q2h1Y2sgSW51ZwDIAXR5IQ&#x3D;&#x3D;&#39; \\ -H &#39;Content-Type: binary/octet-stream&#39; \\ --data-binary &#39;@chunkfile.bin&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
byte[] contentMD5 = B; // byte[] | The base64-encoded binary digest of the body (chunk data).
Integer contentLength = 56; // Integer | 
String uploadJobId = "uploadJobId_example"; // String | The upload job ID.
byte[] chunk = BINARY_DATA_HERE; // byte[] | Chunk.
try {
    UploadChunkInfo result = apiInstance.uploadJobChunkCreate(contentMD5, contentLength, uploadJobId, chunk);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#uploadJobChunkCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentMD5** | **byte[]**| The base64-encoded binary digest of the body (chunk data). |
 **contentLength** | **Integer**|  |
 **uploadJobId** | **String**| The upload job ID. |
 **chunk** | **byte[]**| Chunk. | [optional]

### Return type

[**UploadChunkInfo**](UploadChunkInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/json

<a name="uploadJobChunkList"></a>
# **uploadJobChunkList**
> UploadChunkInfoPage uploadJobChunkList(uploadJobId, limit, order, after, include, filter, createdAtIn, createdAtNin, createdAtLte, createdAtGte, idEq, idNeq, idIn, idNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, hashEq, hashNeq, hashIn, hashNin, lengthEq, lengthNeq, lengthIn, lengthNin, lengthLte, lengthGte)

List all metadata for uploaded chunks

List all metadata for uploaded chunks. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
String uploadJobId = "uploadJobId_example"; // String | The upload job ID.
Integer limit = 56; // Integer | How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | ASC or DESC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data  `?filter={URL-encoded query string}`  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>created_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>etag</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>updated_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>hash</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>length</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>   </tbody> </table> &nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: `key1=value1&key2=value2&key3=value3`  would be URL-encoded as: `?filter=key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3`   **Filtering by properties** `hash__eq=8FS70vXrq5y1VxAAssUMAg==`  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: `2016-11-30T16:25:12.1234Z` * UTC RFC3339 without milliseconds. Example: `2016-11-30T16:25:12Z` * UTC RFC3339 shortened without milliseconds and punctuation. Example: `20161130T162512Z`  Date-time filtering supports three operators:  * equality by appending `__eq` to the field name * greater than or equal to by appending `__gte` to the field name * less than or equal to by appending `__lte` to the field name  `{field name}[|__eq|__lte|__gte]={UTC RFC3339 date-time}`  Time ranges may be specified by including both the `__gte` and `__lte` forms in the filter. For example:  `created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering on multiple fields**  `status__eq=in_progress&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: `__eq` * non-equality: `__neq` * in : `__in` * not in: `__nin`  For `__in` and `__nin` filters list of parameters must be comma-separated:  `status__in=in_progress,success`
String createdAtIn = "createdAtIn_example"; // String | in filter for the \"created_at\" field
String createdAtNin = "createdAtNin_example"; // String | nin filter for the \"created_at\" field
DateTime createdAtLte = new DateTime(); // DateTime | lte filter for the \"created_at\" field
DateTime createdAtGte = new DateTime(); // DateTime | gte filter for the \"created_at\" field
Integer idEq = 56; // Integer | eq filter for the \"id\" field
Integer idNeq = 56; // Integer | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
String updatedAtIn = "updatedAtIn_example"; // String | in filter for the \"updated_at\" field
String updatedAtNin = "updatedAtNin_example"; // String | nin filter for the \"updated_at\" field
DateTime updatedAtLte = new DateTime(); // DateTime | lte filter for the \"updated_at\" field
DateTime updatedAtGte = new DateTime(); // DateTime | gte filter for the \"updated_at\" field
String hashEq = "hashEq_example"; // String | eq filter for the \"hash\" field
String hashNeq = "hashNeq_example"; // String | neq filter for the \"hash\" field
String hashIn = "hashIn_example"; // String | in filter for the \"hash\" field
String hashNin = "hashNin_example"; // String | nin filter for the \"hash\" field
Integer lengthEq = 56; // Integer | eq filter for the \"length\" field
Integer lengthNeq = 56; // Integer | neq filter for the \"length\" field
String lengthIn = "lengthIn_example"; // String | in filter for the \"length\" field
String lengthNin = "lengthNin_example"; // String | nin filter for the \"length\" field
Integer lengthLte = 56; // Integer | lte filter for the \"length\" field
Integer lengthGte = 56; // Integer | gte filter for the \"length\" field
try {
    UploadChunkInfoPage result = apiInstance.uploadJobChunkList(uploadJobId, limit, order, after, include, filter, createdAtIn, createdAtNin, createdAtLte, createdAtGte, idEq, idNeq, idIn, idNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, hashEq, hashNeq, hashIn, hashNin, lengthEq, lengthNeq, lengthIn, lengthNin, lengthLte, lengthGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#uploadJobChunkList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uploadJobId** | **String**| The upload job ID. |
 **limit** | **Integer**| How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| ASC or DESC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count. | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;hash&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;length&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by properties** &#x60;hash__eq&#x3D;8FS70vXrq5y1VxAAssUMAg&#x3D;&#x3D;&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;status__eq&#x3D;in_progress&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;status__in&#x3D;in_progress,success&#x60; | [optional]
 **createdAtIn** | **String**| in filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtNin** | **String**| nin filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtLte** | **DateTime**| lte filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtGte** | **DateTime**| gte filter for the \&quot;created_at\&quot; field | [optional]
 **idEq** | **Integer**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **Integer**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **updatedAtIn** | **String**| in filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtNin** | **String**| nin filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtLte** | **DateTime**| lte filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtGte** | **DateTime**| gte filter for the \&quot;updated_at\&quot; field | [optional]
 **hashEq** | **String**| eq filter for the \&quot;hash\&quot; field | [optional]
 **hashNeq** | **String**| neq filter for the \&quot;hash\&quot; field | [optional]
 **hashIn** | **String**| in filter for the \&quot;hash\&quot; field | [optional]
 **hashNin** | **String**| nin filter for the \&quot;hash\&quot; field | [optional]
 **lengthEq** | **Integer**| eq filter for the \&quot;length\&quot; field | [optional]
 **lengthNeq** | **Integer**| neq filter for the \&quot;length\&quot; field | [optional]
 **lengthIn** | **String**| in filter for the \&quot;length\&quot; field | [optional]
 **lengthNin** | **String**| nin filter for the \&quot;length\&quot; field | [optional]
 **lengthLte** | **Integer**| lte filter for the \&quot;length\&quot; field | [optional]
 **lengthGte** | **Integer**| gte filter for the \&quot;length\&quot; field | [optional]

### Return type

[**UploadChunkInfoPage**](UploadChunkInfoPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="uploadJobChunkRetreive"></a>
# **uploadJobChunkRetreive**
> UploadChunkInfo uploadJobChunkRetreive(uploadJobId, chunkId)

Get metadata about a chunk

Get metadata about a chunk. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks/12345678901234567890123456789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
String uploadJobId = "uploadJobId_example"; // String | The upload job ID.
String chunkId = "chunkId_example"; // String | Chunk.
try {
    UploadChunkInfo result = apiInstance.uploadJobChunkRetreive(uploadJobId, chunkId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#uploadJobChunkRetreive");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uploadJobId** | **String**| The upload job ID. |
 **chunkId** | **String**| Chunk. |

### Return type

[**UploadChunkInfo**](UploadChunkInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="uploadJobCreate"></a>
# **uploadJobCreate**
> UploadJob uploadJobCreate(uploadJob)

Create a new upload job.

Create a new upload job &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{   \&quot;name\&quot;: \&quot;New Linux update\&quot;,   \&quot;description\&quot;: \&quot;New Linux update for my devices\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
UploadJob uploadJob = new UploadJob(); // UploadJob | Upload job.
try {
    UploadJob result = apiInstance.uploadJobCreate(uploadJob);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#uploadJobCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uploadJob** | [**UploadJob**](UploadJob.md)| Upload job. |

### Return type

[**UploadJob**](UploadJob.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="uploadJobDelete"></a>
# **uploadJobDelete**
> Void uploadJobDelete(uploadJobId)

Delete an upload job

Delete an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
String uploadJobId = "uploadJobId_example"; // String | The upload job ID.
try {
    Void result = apiInstance.uploadJobDelete(uploadJobId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#uploadJobDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uploadJobId** | **String**| The upload job ID. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="uploadJobList"></a>
# **uploadJobList**
> UploadJobPage uploadJobList(limit, order, after, include, filter, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, nameEq, nameNeq, nameIn, nameNin, createdAtIn, createdAtNin, createdAtLte, createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, completeEq, completeNeq, statusEq, statusNeq, statusIn, statusNin)

Get all upload jobs

Get all upload jobs. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | ASC or DESC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data.  `?filter={URL-encoded query string}`  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>name</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>description</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>complete</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>firmware_image_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>status</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>created_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>etag</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>updated_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>   </tbody> </table> &nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: `key1=value1&key2=value2&key3=value3`  would be URL-encoded as: `?filter=key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3`   **Filtering by properties** `name__eq=myimage`  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: `2016-11-30T16:25:12.1234Z` * UTC RFC3339 without milliseconds. Example: `2016-11-30T16:25:12Z` * UTC RFC3339 shortened without milliseconds and punctuation. Example: `20161130T162512Z`  Date-time filtering supports three operators:  * equality by appending `__eq` to the field name * greater than or equal to by appending `__gte` to the field name * less than or equal to by appending `__lte` to the field name  `{field name}[|__eq|__lte|__gte]={UTC RFC3339 date-time}`  Time ranges may be specified by including both the `__gte` and `__lte` forms in the filter. For example:  `created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering on multiple fields**  `name__eq=myimage&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: `__eq` * non-equality: `__neq` * in : `__in` * not in: `__nin`  For `__in` and `__nin` filters list of parameters must be comma-separated:  `name__in=fw-image1,fw-image2`
String updatedAtIn = "updatedAtIn_example"; // String | in filter for the \"updated_at\" field
String updatedAtNin = "updatedAtNin_example"; // String | nin filter for the \"updated_at\" field
DateTime updatedAtLte = new DateTime(); // DateTime | lte filter for the \"updated_at\" field
DateTime updatedAtGte = new DateTime(); // DateTime | gte filter for the \"updated_at\" field
String nameEq = "nameEq_example"; // String | eq filter for the \"name\" field
String nameNeq = "nameNeq_example"; // String | neq filter for the \"name\" field
String nameIn = "nameIn_example"; // String | in filter for the \"name\" field
String nameNin = "nameNin_example"; // String | nin filter for the \"name\" field
String createdAtIn = "createdAtIn_example"; // String | in filter for the \"created_at\" field
String createdAtNin = "createdAtNin_example"; // String | nin filter for the \"created_at\" field
DateTime createdAtLte = new DateTime(); // DateTime | lte filter for the \"created_at\" field
DateTime createdAtGte = new DateTime(); // DateTime | gte filter for the \"created_at\" field
String descriptionEq = "descriptionEq_example"; // String | eq filter for the \"description\" field
String descriptionNeq = "descriptionNeq_example"; // String | neq filter for the \"description\" field
String descriptionIn = "descriptionIn_example"; // String | in filter for the \"description\" field
String descriptionNin = "descriptionNin_example"; // String | nin filter for the \"description\" field
String idEq = "idEq_example"; // String | eq filter for the \"id\" field
String idNeq = "idNeq_example"; // String | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
Boolean completeEq = true; // Boolean | eq filter for the \"complete\" field
Boolean completeNeq = true; // Boolean | neq filter for the \"complete\" field
String statusEq = "statusEq_example"; // String | eq filter for the \"status\" field
String statusNeq = "statusNeq_example"; // String | neq filter for the \"status\" field
String statusIn = "statusIn_example"; // String | in filter for the \"status\" field
String statusNin = "statusNin_example"; // String | nin filter for the \"status\" field
try {
    UploadJobPage result = apiInstance.uploadJobList(limit, order, after, include, filter, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, nameEq, nameNeq, nameIn, nameNin, createdAtIn, createdAtNin, createdAtLte, createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, completeEq, completeNeq, statusEq, statusNeq, statusIn, statusNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#uploadJobList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| ASC or DESC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count. | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data.  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;complete&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;firmware_image_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;status&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by properties** &#x60;name__eq&#x3D;myimage&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;name__eq&#x3D;myimage&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; | [optional]
 **updatedAtIn** | **String**| in filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtNin** | **String**| nin filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtLte** | **DateTime**| lte filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtGte** | **DateTime**| gte filter for the \&quot;updated_at\&quot; field | [optional]
 **nameEq** | **String**| eq filter for the \&quot;name\&quot; field | [optional]
 **nameNeq** | **String**| neq filter for the \&quot;name\&quot; field | [optional]
 **nameIn** | **String**| in filter for the \&quot;name\&quot; field | [optional]
 **nameNin** | **String**| nin filter for the \&quot;name\&quot; field | [optional]
 **createdAtIn** | **String**| in filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtNin** | **String**| nin filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtLte** | **DateTime**| lte filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtGte** | **DateTime**| gte filter for the \&quot;created_at\&quot; field | [optional]
 **descriptionEq** | **String**| eq filter for the \&quot;description\&quot; field | [optional]
 **descriptionNeq** | **String**| neq filter for the \&quot;description\&quot; field | [optional]
 **descriptionIn** | **String**| in filter for the \&quot;description\&quot; field | [optional]
 **descriptionNin** | **String**| nin filter for the \&quot;description\&quot; field | [optional]
 **idEq** | **String**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **String**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **completeEq** | **Boolean**| eq filter for the \&quot;complete\&quot; field | [optional]
 **completeNeq** | **Boolean**| neq filter for the \&quot;complete\&quot; field | [optional]
 **statusEq** | **String**| eq filter for the \&quot;status\&quot; field | [optional]
 **statusNeq** | **String**| neq filter for the \&quot;status\&quot; field | [optional]
 **statusIn** | **String**| in filter for the \&quot;status\&quot; field | [optional]
 **statusNin** | **String**| nin filter for the \&quot;status\&quot; field | [optional]

### Return type

[**UploadJobPage**](UploadJobPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="uploadJobRetrieve"></a>
# **uploadJobRetrieve**
> UploadJob uploadJobRetrieve(uploadJobId)

Retrieve information for an upload job

Get an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
String uploadJobId = "uploadJobId_example"; // String | The upload job ID.
try {
    UploadJob result = apiInstance.uploadJobRetrieve(uploadJobId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#uploadJobRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uploadJobId** | **String**| The upload job ID. |

### Return type

[**UploadJob**](UploadJob.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="uploadJobUpdate"></a>
# **uploadJobUpdate**
> UploadJob uploadJobUpdate(uploadJobId, uploadJob)

Update an upload job

Update an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -d &#39;{   \&quot;name\&quot;: \&quot;New Linux update\&quot;,   \&quot;description\&quot;: \&quot;New Linux update for my class XX devices\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateFirmwareImagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateFirmwareImagesApi apiInstance = new DeviceUpdateFirmwareImagesApi();
String uploadJobId = "uploadJobId_example"; // String | The upload job ID.
UploadJob1 uploadJob = new UploadJob1(); // UploadJob1 | Upload job.
try {
    UploadJob result = apiInstance.uploadJobUpdate(uploadJobId, uploadJob);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateFirmwareImagesApi#uploadJobUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uploadJobId** | **String**| The upload job ID. |
 **uploadJob** | [**UploadJob1**](UploadJob1.md)| Upload job. |

### Return type

[**UploadJob**](UploadJob.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

