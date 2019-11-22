# DeviceDirectoryEventsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deviceEventList**](DeviceDirectoryEventsApi.md#deviceEventList) | **GET** v3/device-events/ | List all device events.
[**deviceEventRetrieve**](DeviceDirectoryEventsApi.md#deviceEventRetrieve) | **GET** v3/device-events/{device_event_id}/ | Retrieve a device event.
[**deviceLogList**](DeviceDirectoryEventsApi.md#deviceLogList) | **GET** v3/devicelog/ | DEPRECATED: List all device events.
[**deviceLogRetrieve**](DeviceDirectoryEventsApi.md#deviceLogRetrieve) | **GET** v3/devicelog/{device_event_id}/ | DEPRECATED: Retrieve a device event.


<a name="deviceEventList"></a>
# **deviceEventList**
> DeviceEventPage deviceEventList(limit, order, after, include, filter, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq)

List all device events.

List all device events for an account.  **Example:** Following example gets device-events limiting returned results to max 5 events &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/device-events?limit&#x3D;5 \\ -H &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60; or to get events for certain device filter based on device_id: &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/device-events?device_id&#x3D;&lt;device_id&gt; \\ -H &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryEventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryEventsApi apiInstance = new DeviceDirectoryEventsApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data.  ##### Filtering  `?filter={URL encoded query string}`  The query string is made up of key/value pairs separated by ampersands. So for a query of `key1=value1&key2=value2&key3=value3`, this would be encoded as `?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3`.  ###### Filterable fields:  The below table lists all filterable fields:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>date_time</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>description</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>device_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>event_type</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>state_change</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>   </tbody> </table> &nbsp;  The examples below show the queries in *unencoded* form.  ###### By id:  `id={id}`  ###### By state change:  `state_change=[True|False]`  ###### By event type:  `event_type={value}`  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format: `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example, 2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example, 20161130T162512Z.  Date-time filtering supports three operators:  * Equality. * Greater than or equal to &ndash; field name suffixed with `__gte`. * Less than or equal to &ndash; field name suffixed with `__lte`. Lower and upper limits to a date-time range may be specified by including both the `__gte` and `__lte` forms in the filter:  `{field name}[|__lte|__gte]={UTC RFC3339 date-time}`  ##### Multi-field example  `id=0158d38771f70000000000010010038c&state_change=True&date_time__gte=2016-11-30T16:25:12.1234Z`  Encoded:  `?filter=id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z`  ##### Filtering with filter operators  String field filtering supports the following operators:  * Equality: `__eq`. * Non-equality: `__neq`. * In : `__in`. * Not in: `__nin`.  For `__in` and `__nin` filters list of parameters must be comma-separated:  `event_type__in=update.device.device-created,update.device.device-updated`
String dateTimeIn = "dateTimeIn_example"; // String | in filter for the \"date_time\" field
String dateTimeNin = "dateTimeNin_example"; // String | nin filter for the \"date_time\" field
DateTime dateTimeLte = new DateTime(); // DateTime | lte filter for the \"date_time\" field
DateTime dateTimeGte = new DateTime(); // DateTime | gte filter for the \"date_time\" field
String descriptionEq = "descriptionEq_example"; // String | eq filter for the \"description\" field
String descriptionNeq = "descriptionNeq_example"; // String | neq filter for the \"description\" field
String descriptionIn = "descriptionIn_example"; // String | in filter for the \"description\" field
String descriptionNin = "descriptionNin_example"; // String | nin filter for the \"description\" field
String idEq = "idEq_example"; // String | eq filter for the \"id\" field
String idNeq = "idNeq_example"; // String | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
String deviceIdEq = "deviceIdEq_example"; // String | eq filter for the \"device_id\" field
String deviceIdNeq = "deviceIdNeq_example"; // String | neq filter for the \"device_id\" field
String deviceIdIn = "deviceIdIn_example"; // String | in filter for the \"device_id\" field
String deviceIdNin = "deviceIdNin_example"; // String | nin filter for the \"device_id\" field
String eventTypeEq = "eventTypeEq_example"; // String | eq filter for the \"event_type\" field
String eventTypeNeq = "eventTypeNeq_example"; // String | neq filter for the \"event_type\" field
String eventTypeIn = "eventTypeIn_example"; // String | in filter for the \"event_type\" field
String eventTypeNin = "eventTypeNin_example"; // String | nin filter for the \"event_type\" field
Boolean stateChangeEq = true; // Boolean | eq filter for the \"state_change\" field
Boolean stateChangeNeq = true; // Boolean | neq filter for the \"state_change\" field
try {
    DeviceEventPage result = apiInstance.deviceEventList(limit, order, after, include, filter, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryEventsApi#deviceEventList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. Default: ASC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data.  ##### Filtering  &#x60;?filter&#x3D;{URL encoded query string}&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;, this would be encoded as &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;.  ###### Filterable fields:  The below table lists all filterable fields:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;date_time&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;event_type&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state_change&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By id:  &#x60;id&#x3D;{id}&#x60;  ###### By state change:  &#x60;state_change&#x3D;[True|False]&#x60;  ###### By event type:  &#x60;event_type&#x3D;{value}&#x60;  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format: &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example, 2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example, 20161130T162512Z.  Date-time filtering supports three operators:  * Equality. * Greater than or equal to &amp;ndash; field name suffixed with &#x60;__gte&#x60;. * Less than or equal to &amp;ndash; field name suffixed with &#x60;__lte&#x60;. Lower and upper limits to a date-time range may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter:  &#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  ##### Multi-field example  &#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;  Encoded:  &#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * Equality: &#x60;__eq&#x60;. * Non-equality: &#x60;__neq&#x60;. * In : &#x60;__in&#x60;. * Not in: &#x60;__nin&#x60;.  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60; | [optional]
 **dateTimeIn** | **String**| in filter for the \&quot;date_time\&quot; field | [optional]
 **dateTimeNin** | **String**| nin filter for the \&quot;date_time\&quot; field | [optional]
 **dateTimeLte** | **DateTime**| lte filter for the \&quot;date_time\&quot; field | [optional]
 **dateTimeGte** | **DateTime**| gte filter for the \&quot;date_time\&quot; field | [optional]
 **descriptionEq** | **String**| eq filter for the \&quot;description\&quot; field | [optional]
 **descriptionNeq** | **String**| neq filter for the \&quot;description\&quot; field | [optional]
 **descriptionIn** | **String**| in filter for the \&quot;description\&quot; field | [optional]
 **descriptionNin** | **String**| nin filter for the \&quot;description\&quot; field | [optional]
 **idEq** | **String**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **String**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **deviceIdEq** | **String**| eq filter for the \&quot;device_id\&quot; field | [optional]
 **deviceIdNeq** | **String**| neq filter for the \&quot;device_id\&quot; field | [optional]
 **deviceIdIn** | **String**| in filter for the \&quot;device_id\&quot; field | [optional]
 **deviceIdNin** | **String**| nin filter for the \&quot;device_id\&quot; field | [optional]
 **eventTypeEq** | **String**| eq filter for the \&quot;event_type\&quot; field | [optional]
 **eventTypeNeq** | **String**| neq filter for the \&quot;event_type\&quot; field | [optional]
 **eventTypeIn** | **String**| in filter for the \&quot;event_type\&quot; field | [optional]
 **eventTypeNin** | **String**| nin filter for the \&quot;event_type\&quot; field | [optional]
 **stateChangeEq** | **Boolean**| eq filter for the \&quot;state_change\&quot; field | [optional]
 **stateChangeNeq** | **Boolean**| neq filter for the \&quot;state_change\&quot; field | [optional]

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

Retrieve a specific device event.  **Example:** To fetch a specific event you can use the &#39;id&#39; field form the &#39;/v3/device-events&#39;. Form of &#39;016c03d40a4e000000000001001003b4&#39; &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/device-events/&lt;device_event_id&gt; \\ -H &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryEventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryEventsApi apiInstance = new DeviceDirectoryEventsApi();
String deviceEventId = "deviceEventId_example"; // String | 
try {
    DeviceEventData result = apiInstance.deviceEventRetrieve(deviceEventId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryEventsApi#deviceEventRetrieve");
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

<a name="deviceLogList"></a>
# **deviceLogList**
> DeviceEventPage deviceLogList(limit, order, after, include, filter, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin)

DEPRECATED: List all device events.

DEPRECATED: List all device events. Use &#x60;/v3/device-events/&#x60; instead.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryEventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryEventsApi apiInstance = new DeviceDirectoryEventsApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data.  ##### Filtering  `?filter={URL encoded query string}`  The query string is made up of key/value pairs separated by ampersands. So for a query of `key1=value1&key2=value2&key3=value3`, this would be encoded as `?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3`.  ###### Filterable fields:  The below table lists all filterable fields:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>date_time</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>description</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>device_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>event_type</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>state_change</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>   </tbody> </table> &nbsp;  The examples below show the queries in *unencoded* form.  ###### By id:  `id={id}`  ###### By state change:  `state_change=[True|False]`  ###### By event type:  `event_type={value}`  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example, 2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example, 20161130T162512Z.  Date-time filtering supports three operators:  * Equality. * Greater than or equal to &ndash; field name suffixed with `__gte`. * Less than or equal to &ndash; field name suffixed with `__lte`.  Lower and upper limits to a date-time range may be specified by including both the `__gte` and `__lte` forms in the filter:  `{field name}[|__lte|__gte]={UTC RFC3339 date-time}`  ##### Multi-field example  `id=0158d38771f70000000000010010038c&state_change=True&date_time__gte=2016-11-30T16:25:12.1234Z`  Encoded:  `?filter=id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z`  ##### Filtering with filter operators  String field filtering supports the following operators:  * Equality: `__eq`. * Non-equality: `__neq`. * In : `__in`. * Not in: `__nin`.  For `__in` and `__nin` filters list of parameters must be comma-separated: `event_type__in=update.device.device-created,update.device.device-updated`.
String dateTimeIn = "dateTimeIn_example"; // String | in filter for the \"date_time\" field
String dateTimeNin = "dateTimeNin_example"; // String | nin filter for the \"date_time\" field
DateTime dateTimeLte = new DateTime(); // DateTime | lte filter for the \"date_time\" field
DateTime dateTimeGte = new DateTime(); // DateTime | gte filter for the \"date_time\" field
String descriptionEq = "descriptionEq_example"; // String | eq filter for the \"description\" field
String descriptionNeq = "descriptionNeq_example"; // String | neq filter for the \"description\" field
String descriptionIn = "descriptionIn_example"; // String | in filter for the \"description\" field
String descriptionNin = "descriptionNin_example"; // String | nin filter for the \"description\" field
String idEq = "idEq_example"; // String | eq filter for the \"id\" field
String idNeq = "idNeq_example"; // String | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
String deviceIdEq = "deviceIdEq_example"; // String | eq filter for the \"device_id\" field
String deviceIdNeq = "deviceIdNeq_example"; // String | neq filter for the \"device_id\" field
String deviceIdIn = "deviceIdIn_example"; // String | in filter for the \"device_id\" field
String deviceIdNin = "deviceIdNin_example"; // String | nin filter for the \"device_id\" field
String eventTypeEq = "eventTypeEq_example"; // String | eq filter for the \"event_type\" field
String eventTypeNeq = "eventTypeNeq_example"; // String | neq filter for the \"event_type\" field
String eventTypeIn = "eventTypeIn_example"; // String | in filter for the \"event_type\" field
String eventTypeNin = "eventTypeNin_example"; // String | nin filter for the \"event_type\" field
Boolean stateChangeEq = true; // Boolean | eq filter for the \"state_change\" field
Boolean stateChangeNeq = true; // Boolean | neq filter for the \"state_change\" field
String stateChangeIn = "stateChangeIn_example"; // String | in filter for the \"state_change\" field
String stateChangeNin = "stateChangeNin_example"; // String | nin filter for the \"state_change\" field
try {
    DeviceEventPage result = apiInstance.deviceLogList(limit, order, after, include, filter, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryEventsApi#deviceLogList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. Default: ASC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data.  ##### Filtering  &#x60;?filter&#x3D;{URL encoded query string}&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;, this would be encoded as &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;.  ###### Filterable fields:  The below table lists all filterable fields:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;date_time&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;event_type&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state_change&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By id:  &#x60;id&#x3D;{id}&#x60;  ###### By state change:  &#x60;state_change&#x3D;[True|False]&#x60;  ###### By event type:  &#x60;event_type&#x3D;{value}&#x60;  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example, 2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example, 20161130T162512Z.  Date-time filtering supports three operators:  * Equality. * Greater than or equal to &amp;ndash; field name suffixed with &#x60;__gte&#x60;. * Less than or equal to &amp;ndash; field name suffixed with &#x60;__lte&#x60;.  Lower and upper limits to a date-time range may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter:  &#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  ##### Multi-field example  &#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;  Encoded:  &#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * Equality: &#x60;__eq&#x60;. * Non-equality: &#x60;__neq&#x60;. * In : &#x60;__in&#x60;. * Not in: &#x60;__nin&#x60;.  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated: &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60;. | [optional]
 **dateTimeIn** | **String**| in filter for the \&quot;date_time\&quot; field | [optional]
 **dateTimeNin** | **String**| nin filter for the \&quot;date_time\&quot; field | [optional]
 **dateTimeLte** | **DateTime**| lte filter for the \&quot;date_time\&quot; field | [optional]
 **dateTimeGte** | **DateTime**| gte filter for the \&quot;date_time\&quot; field | [optional]
 **descriptionEq** | **String**| eq filter for the \&quot;description\&quot; field | [optional]
 **descriptionNeq** | **String**| neq filter for the \&quot;description\&quot; field | [optional]
 **descriptionIn** | **String**| in filter for the \&quot;description\&quot; field | [optional]
 **descriptionNin** | **String**| nin filter for the \&quot;description\&quot; field | [optional]
 **idEq** | **String**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **String**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **deviceIdEq** | **String**| eq filter for the \&quot;device_id\&quot; field | [optional]
 **deviceIdNeq** | **String**| neq filter for the \&quot;device_id\&quot; field | [optional]
 **deviceIdIn** | **String**| in filter for the \&quot;device_id\&quot; field | [optional]
 **deviceIdNin** | **String**| nin filter for the \&quot;device_id\&quot; field | [optional]
 **eventTypeEq** | **String**| eq filter for the \&quot;event_type\&quot; field | [optional]
 **eventTypeNeq** | **String**| neq filter for the \&quot;event_type\&quot; field | [optional]
 **eventTypeIn** | **String**| in filter for the \&quot;event_type\&quot; field | [optional]
 **eventTypeNin** | **String**| nin filter for the \&quot;event_type\&quot; field | [optional]
 **stateChangeEq** | **Boolean**| eq filter for the \&quot;state_change\&quot; field | [optional]
 **stateChangeNeq** | **Boolean**| neq filter for the \&quot;state_change\&quot; field | [optional]
 **stateChangeIn** | **String**| in filter for the \&quot;state_change\&quot; field | [optional]
 **stateChangeNin** | **String**| nin filter for the \&quot;state_change\&quot; field | [optional]

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

Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/ instead).

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryEventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryEventsApi apiInstance = new DeviceDirectoryEventsApi();
String deviceEventId = "deviceEventId_example"; // String | 
try {
    DeviceEventData result = apiInstance.deviceLogRetrieve(deviceEventId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryEventsApi#deviceLogRetrieve");
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

