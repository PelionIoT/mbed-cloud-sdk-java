# DefaultApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deviceCreate**](DefaultApi.md#deviceCreate) | **POST** v3/devices/ | Create a device
[**deviceDestroy**](DefaultApi.md#deviceDestroy) | **DELETE** v3/devices/{id}/ | Delete a device.
[**deviceEventList**](DefaultApi.md#deviceEventList) | **GET** v3/device-events/ | List all device events.
[**deviceEventRetrieve**](DefaultApi.md#deviceEventRetrieve) | **GET** v3/device-events/{device_event_id}/ | Retrieve a device event.
[**deviceList**](DefaultApi.md#deviceList) | **GET** v3/devices/ | List all devices.
[**deviceLogList**](DefaultApi.md#deviceLogList) | **GET** v3/devicelog/ | DEPRECATED: List all device events.
[**deviceLogRetrieve**](DefaultApi.md#deviceLogRetrieve) | **GET** v3/devicelog/{device_event_id}/ | DEPRECATED: Retrieve a device event.
[**deviceQueryCreate**](DefaultApi.md#deviceQueryCreate) | **POST** v3/device-queries/ | Create a device query
[**deviceQueryDestroy**](DefaultApi.md#deviceQueryDestroy) | **DELETE** v3/device-queries/{query_id}/ | Delete a device query
[**deviceQueryList**](DefaultApi.md#deviceQueryList) | **GET** v3/device-queries/ | List device queries.
[**deviceQueryRetrieve**](DefaultApi.md#deviceQueryRetrieve) | **GET** v3/device-queries/{query_id}/ | Retrieve a device query.
[**deviceQueryUpdate**](DefaultApi.md#deviceQueryUpdate) | **PUT** v3/device-queries/{query_id}/ | Update a device query
[**deviceRetrieve**](DefaultApi.md#deviceRetrieve) | **GET** v3/devices/{id}/ | Get a devices
[**deviceUpdate**](DefaultApi.md#deviceUpdate) | **PUT** v3/devices/{id}/ | Update a device
[**groupCreate**](DefaultApi.md#groupCreate) | **POST** v3/device-groups/ | Create a group
[**groupDelete**](DefaultApi.md#groupDelete) | **DELETE** v3/device-groups/{device-group-id}/ | Delete a group
[**groupList**](DefaultApi.md#groupList) | **GET** v3/device-groups/ | List all groups.
[**groupMembersAdd**](DefaultApi.md#groupMembersAdd) | **POST** v3/device-groups/{device-group-id}/devices/add/ | Add devices from a group
[**groupMembersRemove**](DefaultApi.md#groupMembersRemove) | **POST** v3/device-groups/{device-group-id}/devices/remove/ | Remove devices from a group
[**groupMembersRetrieve**](DefaultApi.md#groupMembersRetrieve) | **GET** v3/device-groups/{device-group-id}/devices/ | Get a page of devices
[**groupRetrieve**](DefaultApi.md#groupRetrieve) | **GET** v3/device-groups/{device-group-id}/ | Get a group.
[**groupUpdate**](DefaultApi.md#groupUpdate) | **PUT** v3/device-groups/{device-group-id}/ | Modify the attributes of a group.


<a name="deviceCreate"></a>
# **deviceCreate**
> DeviceData deviceCreate(device)

Create a device

Create a new device.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
DeviceDataPostRequest device = new DeviceDataPostRequest(); // DeviceDataPostRequest | 
try {
    DeviceData result = apiInstance.deviceCreate(device);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **device** | [**DeviceDataPostRequest**](DeviceDataPostRequest.md)|  |

### Return type

[**DeviceData**](DeviceData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceDestroy"></a>
# **deviceDestroy**
> Void deviceDestroy(id)

Delete a device.

Delete device. Only available for devices with a developer certificate. Attempts to delete a device with a production certicate will return a 400 response.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | 
try {
    Void result = apiInstance.deviceDestroy(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceEventList"></a>
# **deviceEventList**
> DeviceEventPage deviceEventList(limit, order, after, include, filter)

List all device events.

List all device events for an account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page.
String order = "order_example"; // String | The order of the records based on creation time, `ASC` or `DESC`; by default `ASC`.
String after = "after_example"; // String | The ID of The item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`
String filter = "filter_example"; // String | URL encoded query string parameter to filter returned data.  ##### Filtering  ```?filter={URL encoded query string}```  The query string is made up of key/value pairs separated by ampersands. So for a query of ```key1=value1&key2=value2&key3=value3``` this would be encoded as follows: ```?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3```  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>date_time</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>description</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>device_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>event_type</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>state_change</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>   </tbody> </table> &nbsp;  The examples below show the queries in *unencoded* form.  ###### By id:  ```id={id}```  ###### By state change:  ```state_change=[True|False]```  ###### By event type:  ```event_type={value}```  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format ```YYYY-MM-DDThh:mm:ss.msZ```. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &ndash; field name suffixed with ```__gte``` * less than or equal to &ndash; field name suffixed with ```__lte``` Lower and upper limits to a date-time range may be specified by including both the ```__gte``` and ```__lte``` forms in the filter. ```{field name}[|__lte|__gte]={UTC RFC3339 date-time}```  ##### Multi-field example  ```id=0158d38771f70000000000010010038c&state_change=True&date_time__gte=2016-11-30T16:25:12.1234Z```  Encoded:  ```?filter=id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z```  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: `__eq` * non-equality: `__neq` * in : `__in` * not in: `__nin`  For `__in` and `__nin` filters list of parameters must be comma-separated: `event_type__in=update.device.device-created,update.device.device-updated`
try {
    DeviceEventPage result = apiInstance.deviceEventList(limit, order, after, include, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceEventList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page. | [optional]
 **order** | **String**| The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. | [optional]
 **after** | **String**| The ID of The item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60; | [optional]
 **filter** | **String**| URL encoded query string parameter to filter returned data.  ##### Filtering  &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60;  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;date_time&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;event_type&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state_change&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By id:  &#x60;&#x60;&#x60;id&#x3D;{id}&#x60;&#x60;&#x60;  ###### By state change:  &#x60;&#x60;&#x60;state_change&#x3D;[True|False]&#x60;&#x60;&#x60;  ###### By event type:  &#x60;&#x60;&#x60;event_type&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example  &#x60;&#x60;&#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;&#x60;&#x60;  Encoded:  &#x60;&#x60;&#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;&#x60;&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated: &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60; | [optional]

### Return type

[**DeviceEventPage**](DeviceEventPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceEventRetrieve"></a>
# **deviceEventRetrieve**
> DeviceEventData deviceEventRetrieve(deviceEventId)

Retrieve a device event.

Retrieve a specific device event.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deviceEventId = "deviceEventId_example"; // String | 
try {
    DeviceEventData result = apiInstance.deviceEventRetrieve(deviceEventId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceEventRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceEventId** | **String**|  |

### Return type

[**DeviceEventData**](DeviceEventData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceList"></a>
# **deviceList**
> DevicePage deviceList(limit, order, after, include, filter)

List all devices.

List all devices.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page.
String order = "order_example"; // String | The order of the records based on creation time, `ASC` or `DESC`; by default `ASC`.
String after = "after_example"; // String | The ID of The item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String filter = "filter_example"; // String | URL encoded query string parameter to filter returned data.  ##### Filtering  ```?filter={URL encoded query string}```  The query string is made up of key/value pairs separated by ampersands. So for a query of ```key1=value1&key2=value2&key3=value3``` this would be encoded as follows: ```?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3```  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>account_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>auto_update</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>bootstrap_expiration_date</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>bootstrapped_timestamp</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>ca_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>connector_expiration_date</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>created_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>custom_attributes</td>       <td>✓</td>       <td>&nbsp;</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>deployed_state</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>deployment</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>description</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>device_class</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>device_execution_mode</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>device_key</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>endpoint_name</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>endpoint_type</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>enrolment_list_timestamp</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>etag</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>firmware_checksum</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>host_gateway</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>manifest</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>manifest_timestamp</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>mechanism</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>mechanism_url</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>name</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>serial_number</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>state</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>updated_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>vendor_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>   </tbody> </table> &nbsp;  The examples below show the queries in *unencoded* form.  ###### By device properties (all properties are filterable):  ```state=[unenrolled|cloud_enrolling|bootstrapped|registered]``` ```device_class={value}```  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format ```YYYY-MM-DDThh:mm:ss.msZ```. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &ndash; field name suffixed with ```__gte``` * less than or equal to &ndash; field name suffixed with ```__lte```  Lower and upper limits to a date-time range may be specified by including both the ```__gte``` and ```__lte``` forms in the filter. ```{field name}[|__lte|__gte]={UTC RFC3339 date-time}```  ###### On device custom attributes:  ```custom_attributes__{param}={value}``` ```custom_attributes__tag=TAG1```  ##### Multi-field example  ```state=bootstrapped&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z```  Encoded:  ```?filter=state%3Dbootstrapped%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z```  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: `__eq` * non-equality: `__neq` * in : `__in` * not in: `__nin`  For `__in` and `__nin` filters list of parameters must be comma-separated: `state__nin=unenrolled,dergistered`
try {
    DevicePage result = apiInstance.deviceList(limit, order, after, include, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page. | [optional]
 **order** | **String**| The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. | [optional]
 **after** | **String**| The ID of The item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]
 **filter** | **String**| URL encoded query string parameter to filter returned data.  ##### Filtering  &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60;  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;account_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;auto_update&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;bootstrap_expiration_date&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;bootstrapped_timestamp&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;ca_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;connector_expiration_date&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;custom_attributes&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;deployed_state&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;deployment&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_class&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_execution_mode&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_key&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;endpoint_name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;endpoint_type&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;enrolment_list_timestamp&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;firmware_checksum&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;host_gateway&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;manifest&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;manifest_timestamp&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;mechanism&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;mechanism_url&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;serial_number&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;vendor_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By device properties (all properties are filterable):  &#x60;&#x60;&#x60;state&#x3D;[unenrolled|cloud_enrolling|bootstrapped|registered]&#x60;&#x60;&#x60; &#x60;&#x60;&#x60;device_class&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ###### On device custom attributes:  &#x60;&#x60;&#x60;custom_attributes__{param}&#x3D;{value}&#x60;&#x60;&#x60; &#x60;&#x60;&#x60;custom_attributes__tag&#x3D;TAG1&#x60;&#x60;&#x60;  ##### Multi-field example  &#x60;&#x60;&#x60;state&#x3D;bootstrapped&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;  Encoded:  &#x60;&#x60;&#x60;?filter&#x3D;state%3Dbootstrapped%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated: &#x60;state__nin&#x3D;unenrolled,dergistered&#x60; | [optional]

### Return type

[**DevicePage**](DevicePage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceLogList"></a>
# **deviceLogList**
> DeviceEventPage deviceLogList(limit, order, after, include, filter)

DEPRECATED: List all device events.

DEPRECATED: List all device events. Use &#x60;/v3/device-events/&#x60; instead.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page.
String order = "order_example"; // String | The order of the records based on creation time, `ASC` or `DESC`; by default `ASC`.
String after = "after_example"; // String | The ID of The item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String filter = "filter_example"; // String | URL encoded query string parameter to filter returned data.  ##### Filtering  ```?filter={URL encoded query string}```  The query string is made up of key/value pairs separated by ampersands. So for a query of ```key1=value1&key2=value2&key3=value3``` this would be encoded as follows: ```?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3```  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>date_time</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>description</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>device_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>event_type</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>state_change</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>   </tbody> </table> &nbsp;  The examples below show the queries in *unencoded* form.  ###### By id:  ```id={id}```  ###### By state change:  ```state_change=[True|False]```  ###### By event type:  ```event_type={value}```  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format ```YYYY-MM-DDThh:mm:ss.msZ```. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &ndash; field name suffixed with ```__gte``` * less than or equal to &ndash; field name suffixed with ```__lte```  Lower and upper limits to a date-time range may be specified by including both the ```__gte``` and ```__lte``` forms in the filter. ```{field name}[|__lte|__gte]={UTC RFC3339 date-time}```  ##### Multi-field example ```id=0158d38771f70000000000010010038c&state_change=True&date_time__gte=2016-11-30T16:25:12.1234Z```  Encoded:  ```?filter=id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z```  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: `__eq` * non-equality: `__neq` * in : `__in` * not in: `__nin`  For `__in` and `__nin` filters list of parameters must be comma-separated: `event_type__in=update.device.device-created,update.device.device-updated`
try {
    DeviceEventPage result = apiInstance.deviceLogList(limit, order, after, include, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceLogList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page. | [optional]
 **order** | **String**| The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. | [optional]
 **after** | **String**| The ID of The item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]
 **filter** | **String**| URL encoded query string parameter to filter returned data.  ##### Filtering  &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60;  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;date_time&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;event_type&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state_change&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By id:  &#x60;&#x60;&#x60;id&#x3D;{id}&#x60;&#x60;&#x60;  ###### By state change:  &#x60;&#x60;&#x60;state_change&#x3D;[True|False]&#x60;&#x60;&#x60;  ###### By event type:  &#x60;&#x60;&#x60;event_type&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example &#x60;&#x60;&#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;&#x60;&#x60;  Encoded:  &#x60;&#x60;&#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;&#x60;&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated: &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60; | [optional]

### Return type

[**DeviceEventPage**](DeviceEventPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceLogRetrieve"></a>
# **deviceLogRetrieve**
> DeviceEventData deviceLogRetrieve(deviceEventId)

DEPRECATED: Retrieve a device event.

Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/ instead)

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deviceEventId = "deviceEventId_example"; // String | 
try {
    DeviceEventData result = apiInstance.deviceLogRetrieve(deviceEventId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceLogRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceEventId** | **String**|  |

### Return type

[**DeviceEventData**](DeviceEventData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceQueryCreate"></a>
# **deviceQueryCreate**
> DeviceQuery deviceQueryCreate(device)

Create a device query

Create a new device query.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
DeviceQueryPostPutRequest device = new DeviceQueryPostPutRequest(); // DeviceQueryPostPutRequest | 
try {
    DeviceQuery result = apiInstance.deviceQueryCreate(device);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceQueryCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **device** | [**DeviceQueryPostPutRequest**](DeviceQueryPostPutRequest.md)|  |

### Return type

[**DeviceQuery**](DeviceQuery.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceQueryDestroy"></a>
# **deviceQueryDestroy**
> Void deviceQueryDestroy(queryId)

Delete a device query

Delete a device query.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String queryId = "queryId_example"; // String | 
try {
    Void result = apiInstance.deviceQueryDestroy(queryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceQueryDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queryId** | **String**|  |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceQueryList"></a>
# **deviceQueryList**
> DeviceQueryPage deviceQueryList(limit, order, after, include, filter)

List device queries.

List all device queries. The result will be paged into pages of 100.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page.
String order = "order_example"; // String | The order of the records based on creation time, `ASC` or `DESC`; by default `ASC`.
String after = "after_example"; // String | The ID of The item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String filter = "filter_example"; // String | URL encoded query string parameter to filter returned data.  ##### Filtering  ```?filter={URL encoded query string}```  The query string is made up of key/value pairs separated by ampersands. So for a query of ```key1=value1&key2=value2&key3=value3``` this would be encoded as follows: ```?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3```  The below table lists all the fields that can be filtered on with certain filters:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>created_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>etag</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>name</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>query</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>updated_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>   </tbody> </table> &nbsp;  The examples below show the queries in *unencoded* form.  ###### By device query properties (all properties are filterable):  For example: ```description={value}```  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format ```YYYY-MM-DDThh:mm:ss.msZ```. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &ndash; field name suffixed with ```__gte``` * less than or equal to &ndash; field name suffixed with ```__lte```  Lower and upper limits to a date-time range may be specified by including both the ```__gte``` and ```__lte``` forms in the filter. ```{field name}[|__lte|__gte]={UTC RFC3339 date-time}```  ##### Multi-field example  ```query_id=0158d38771f70000000000010010038c&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z```  Encoded:  ```filter=query_id%3D0158d38771f70000000000010010038c%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z```  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: `__eq` * non-equality: `__neq` * in : `__in` * not in: `__nin`  For `__in` and `__nin` filters list of parameters must be comma-separated: `name__nin=query1,query2`
try {
    DeviceQueryPage result = apiInstance.deviceQueryList(limit, order, after, include, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceQueryList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page. | [optional]
 **order** | **String**| The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. | [optional]
 **after** | **String**| The ID of The item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]
 **filter** | **String**| URL encoded query string parameter to filter returned data.  ##### Filtering  &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60;  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;query&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By device query properties (all properties are filterable):  For example: &#x60;&#x60;&#x60;description&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example  &#x60;&#x60;&#x60;query_id&#x3D;0158d38771f70000000000010010038c&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;  Encoded:  &#x60;&#x60;&#x60;filter&#x3D;query_id%3D0158d38771f70000000000010010038c%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated: &#x60;name__nin&#x3D;query1,query2&#x60; | [optional]

### Return type

[**DeviceQueryPage**](DeviceQueryPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceQueryRetrieve"></a>
# **deviceQueryRetrieve**
> DeviceQuery deviceQueryRetrieve(queryId)

Retrieve a device query.

Retrieve a specific device query.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String queryId = "queryId_example"; // String | 
try {
    DeviceQuery result = apiInstance.deviceQueryRetrieve(queryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceQueryRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queryId** | **String**|  |

### Return type

[**DeviceQuery**](DeviceQuery.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceQueryUpdate"></a>
# **deviceQueryUpdate**
> DeviceQuery deviceQueryUpdate(queryId, body)

Update a device query

Update a specifc device query.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String queryId = "queryId_example"; // String | 
DeviceQueryPostPutRequest body = new DeviceQueryPostPutRequest(); // DeviceQueryPostPutRequest | Device query update object.
try {
    DeviceQuery result = apiInstance.deviceQueryUpdate(queryId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceQueryUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queryId** | **String**|  |
 **body** | [**DeviceQueryPostPutRequest**](DeviceQueryPostPutRequest.md)| Device query update object. |

### Return type

[**DeviceQuery**](DeviceQuery.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRetrieve"></a>
# **deviceRetrieve**
> DeviceData deviceRetrieve(id)

Get a devices

Retrieve information about a specific device.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | 
try {
    DeviceData result = apiInstance.deviceRetrieve(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**DeviceData**](DeviceData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceUpdate"></a>
# **deviceUpdate**
> DeviceData deviceUpdate(id, device)

Update a device

Update a specific device.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | The ID of the device.
DeviceDataPutRequest device = new DeviceDataPutRequest(); // DeviceDataPutRequest | 
try {
    DeviceData result = apiInstance.deviceUpdate(id, device);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deviceUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the device. |
 **device** | [**DeviceDataPutRequest**](DeviceDataPutRequest.md)|  |

### Return type

[**DeviceData**](DeviceData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupCreate"></a>
# **groupCreate**
> DeviceGroup groupCreate(group)

Create a group

Create a group

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Group group = new Group(); // Group | Group
try {
    DeviceGroup result = apiInstance.groupCreate(group);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **group** | [**Group**](Group.md)| Group |

### Return type

[**DeviceGroup**](DeviceGroup.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupDelete"></a>
# **groupDelete**
> Void groupDelete(deviceGroupId)

Delete a group

Delete a group.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deviceGroupId = "deviceGroupId_example"; // String | The ID of the group
try {
    Void result = apiInstance.groupDelete(deviceGroupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**| The ID of the group |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupList"></a>
# **groupList**
> DeviceGroupPage groupList(limit, order, after, include)

List all groups.

List all groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page.
String order = "order_example"; // String | The order of the records based on creation time, `ASC` or `DESC`; by default `ASC`.
String after = "after_example"; // String | The ID of The item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
try {
    DeviceGroupPage result = apiInstance.groupList(limit, order, after, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page. | [optional]
 **order** | **String**| The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. | [optional]
 **after** | **String**| The ID of The item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]

### Return type

[**DeviceGroupPage**](DeviceGroupPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupMembersAdd"></a>
# **groupMembersAdd**
> DevicePage groupMembersAdd(deviceGroupId, body)

Add devices from a group

Add one or more devices from a group

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deviceGroupId = "deviceGroupId_example"; // String | The ID of the group
DeviceGroupManipulation body = new DeviceGroupManipulation(); // DeviceGroupManipulation | Body of the request
try {
    DevicePage result = apiInstance.groupMembersAdd(deviceGroupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupMembersAdd");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**| The ID of the group |
 **body** | [**DeviceGroupManipulation**](DeviceGroupManipulation.md)| Body of the request |

### Return type

[**DevicePage**](DevicePage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupMembersRemove"></a>
# **groupMembersRemove**
> DevicePage groupMembersRemove(deviceGroupId, body)

Remove devices from a group

Remove one or more devices from a group

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deviceGroupId = "deviceGroupId_example"; // String | The ID of the group
DeviceGroupManipulation body = new DeviceGroupManipulation(); // DeviceGroupManipulation | Body of the request
try {
    DevicePage result = apiInstance.groupMembersRemove(deviceGroupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupMembersRemove");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**| The ID of the group |
 **body** | [**DeviceGroupManipulation**](DeviceGroupManipulation.md)| Body of the request |

### Return type

[**DevicePage**](DevicePage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupMembersRetrieve"></a>
# **groupMembersRetrieve**
> DevicePage groupMembersRetrieve(deviceGroupId)

Get a page of devices

Get a page of device

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deviceGroupId = "deviceGroupId_example"; // String | 
try {
    DevicePage result = apiInstance.groupMembersRetrieve(deviceGroupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupMembersRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**|  |

### Return type

[**DevicePage**](DevicePage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupRetrieve"></a>
# **groupRetrieve**
> DeviceGroup groupRetrieve(deviceGroupId)

Get a group.

Get a group.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deviceGroupId = "deviceGroupId_example"; // String | The group ID
try {
    DeviceGroup result = apiInstance.groupRetrieve(deviceGroupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**| The group ID |

### Return type

[**DeviceGroup**](DeviceGroup.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupUpdate"></a>
# **groupUpdate**
> DeviceGroup groupUpdate(deviceGroupId, group)

Modify the attributes of a group.

Modify the attributes of a group.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiException;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.Configuration;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.auth.*;
//import com.arm.mbed.cloud.sdk.internal.devicedirectory.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deviceGroupId = "deviceGroupId_example"; // String | 
Group1 group = new Group1(); // Group1 | Group
try {
    DeviceGroup result = apiInstance.groupUpdate(deviceGroupId, group);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#groupUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**|  |
 **group** | [**Group1**](Group1.md)| Group |

### Return type

[**DeviceGroup**](DeviceGroup.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

