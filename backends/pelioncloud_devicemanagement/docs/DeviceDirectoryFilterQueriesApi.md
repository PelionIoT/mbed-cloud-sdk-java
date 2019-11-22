# DeviceDirectoryFilterQueriesApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deviceQueryCreate**](DeviceDirectoryFilterQueriesApi.md#deviceQueryCreate) | **POST** v3/device-queries/ | Create a device query.
[**deviceQueryDestroy**](DeviceDirectoryFilterQueriesApi.md#deviceQueryDestroy) | **DELETE** v3/device-queries/{query_id}/ | Delete a device query.
[**deviceQueryList**](DeviceDirectoryFilterQueriesApi.md#deviceQueryList) | **GET** v3/device-queries/ | List device queries.
[**deviceQueryRetrieve**](DeviceDirectoryFilterQueriesApi.md#deviceQueryRetrieve) | **GET** v3/device-queries/{query_id}/ | Retrieve a device query.
[**deviceQueryUpdate**](DeviceDirectoryFilterQueriesApi.md#deviceQueryUpdate) | **PUT** v3/device-queries/{query_id}/ | Update a device query.


<a name="deviceQueryCreate"></a>
# **deviceQueryCreate**
> DeviceQuery deviceQueryCreate(device)

Create a device query.

Create a new device query.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryFilterQueriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryFilterQueriesApi apiInstance = new DeviceDirectoryFilterQueriesApi();
DeviceQueryPostPutRequest device = new DeviceQueryPostPutRequest(); // DeviceQueryPostPutRequest | 
try {
    DeviceQuery result = apiInstance.deviceQueryCreate(device);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryFilterQueriesApi#deviceQueryCreate");
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

Delete a device query.

Delete a device query.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryFilterQueriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryFilterQueriesApi apiInstance = new DeviceDirectoryFilterQueriesApi();
String queryId = "queryId_example"; // String | 
try {
    Void result = apiInstance.deviceQueryDestroy(queryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryFilterQueriesApi#deviceQueryDestroy");
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
> DeviceQueryPage deviceQueryList(limit, order, after, include, filter, createdAtIn, createdAtNin, createdAtLte, createdAtGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, queryEq, queryNeq, queryIn, queryNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte)

List device queries.

List all device queries.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryFilterQueriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryFilterQueriesApi apiInstance = new DeviceDirectoryFilterQueriesApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data.  ##### Filtering  `?filter={URL encoded query string}`  The query string is made up of key/value pairs separated by ampersands. So for a query of `key1=value1&key2=value2&key3=value3`, this would be encoded as: `?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3`.  The below table lists all filterable fields:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>created_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>etag</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>name</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>query</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>updated_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>   </tbody> </table> &nbsp;  The examples below show the queries in *unencoded* form.  ###### By device query properties (all properties are filterable):  For example: `description={value}`  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example, 2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example, 20161130T162512Z.  Date-time filtering supports three operators:  * Equality. * Greater than or equal to &ndash; field name suffixed with `__gte`. * Less than or equal to &ndash; field name suffixed with `__lte`.  Lower and upper limits to a date-time range may be specified by including both the `__gte` and `__lte` forms in the filter: `{field name}[|__lte|__gte]={UTC RFC3339 date-time}`.  ##### Multi-field example  `query_id=0158d38771f70000000000010010038c&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  Encoded:  `filter=query_id%3D0158d38771f70000000000010010038c%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z`  ##### Filtering with filter operators  String field filtering supports the following operators:  * Equality: `__eq`. * Non-equality: `__neq`. * In : `__in`. * Not in: `__nin`.  For `__in` and `__nin` filters list of parameters must be comma-separated: `name__nin=query1,query2`
String createdAtIn = "createdAtIn_example"; // String | in filter for the \"created_at\" field
String createdAtNin = "createdAtNin_example"; // String | nin filter for the \"created_at\" field
DateTime createdAtLte = new DateTime(); // DateTime | lte filter for the \"created_at\" field
DateTime createdAtGte = new DateTime(); // DateTime | gte filter for the \"created_at\" field
String idEq = "idEq_example"; // String | eq filter for the \"id\" field
String idNeq = "idNeq_example"; // String | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
String nameEq = "nameEq_example"; // String | eq filter for the \"name\" field
String nameNeq = "nameNeq_example"; // String | neq filter for the \"name\" field
String nameIn = "nameIn_example"; // String | in filter for the \"name\" field
String nameNin = "nameNin_example"; // String | nin filter for the \"name\" field
String queryEq = "queryEq_example"; // String | eq filter for the \"query\" field
String queryNeq = "queryNeq_example"; // String | neq filter for the \"query\" field
String queryIn = "queryIn_example"; // String | in filter for the \"query\" field
String queryNin = "queryNin_example"; // String | nin filter for the \"query\" field
String updatedAtIn = "updatedAtIn_example"; // String | in filter for the \"updated_at\" field
String updatedAtNin = "updatedAtNin_example"; // String | nin filter for the \"updated_at\" field
DateTime updatedAtLte = new DateTime(); // DateTime | lte filter for the \"updated_at\" field
DateTime updatedAtGte = new DateTime(); // DateTime | gte filter for the \"updated_at\" field
try {
    DeviceQueryPage result = apiInstance.deviceQueryList(limit, order, after, include, filter, createdAtIn, createdAtNin, createdAtLte, createdAtGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, queryEq, queryNeq, queryIn, queryNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryFilterQueriesApi#deviceQueryList");
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
 **filter** | **String**| URL-encoded query string parameter to filter returned data.  ##### Filtering  &#x60;?filter&#x3D;{URL encoded query string}&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;, this would be encoded as: &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;.  The below table lists all filterable fields:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;query&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By device query properties (all properties are filterable):  For example: &#x60;description&#x3D;{value}&#x60;  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example, 2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example, 20161130T162512Z.  Date-time filtering supports three operators:  * Equality. * Greater than or equal to &amp;ndash; field name suffixed with &#x60;__gte&#x60;. * Less than or equal to &amp;ndash; field name suffixed with &#x60;__lte&#x60;.  Lower and upper limits to a date-time range may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter: &#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;.  ##### Multi-field example  &#x60;query_id&#x3D;0158d38771f70000000000010010038c&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  Encoded:  &#x60;filter&#x3D;query_id%3D0158d38771f70000000000010010038c%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * Equality: &#x60;__eq&#x60;. * Non-equality: &#x60;__neq&#x60;. * In : &#x60;__in&#x60;. * Not in: &#x60;__nin&#x60;.  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated: &#x60;name__nin&#x3D;query1,query2&#x60; | [optional]
 **createdAtIn** | **String**| in filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtNin** | **String**| nin filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtLte** | **DateTime**| lte filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtGte** | **DateTime**| gte filter for the \&quot;created_at\&quot; field | [optional]
 **idEq** | **String**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **String**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **nameEq** | **String**| eq filter for the \&quot;name\&quot; field | [optional]
 **nameNeq** | **String**| neq filter for the \&quot;name\&quot; field | [optional]
 **nameIn** | **String**| in filter for the \&quot;name\&quot; field | [optional]
 **nameNin** | **String**| nin filter for the \&quot;name\&quot; field | [optional]
 **queryEq** | **String**| eq filter for the \&quot;query\&quot; field | [optional]
 **queryNeq** | **String**| neq filter for the \&quot;query\&quot; field | [optional]
 **queryIn** | **String**| in filter for the \&quot;query\&quot; field | [optional]
 **queryNin** | **String**| nin filter for the \&quot;query\&quot; field | [optional]
 **updatedAtIn** | **String**| in filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtNin** | **String**| nin filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtLte** | **DateTime**| lte filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtGte** | **DateTime**| gte filter for the \&quot;updated_at\&quot; field | [optional]

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
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryFilterQueriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryFilterQueriesApi apiInstance = new DeviceDirectoryFilterQueriesApi();
String queryId = "queryId_example"; // String | 
try {
    DeviceQuery result = apiInstance.deviceQueryRetrieve(queryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryFilterQueriesApi#deviceQueryRetrieve");
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

Update a device query.

Update a specifc device query.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryFilterQueriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryFilterQueriesApi apiInstance = new DeviceDirectoryFilterQueriesApi();
String queryId = "queryId_example"; // String | 
DeviceQueryPostPutRequest body = new DeviceQueryPostPutRequest(); // DeviceQueryPostPutRequest | Device query update object.
try {
    DeviceQuery result = apiInstance.deviceQueryUpdate(queryId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryFilterQueriesApi#deviceQueryUpdate");
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

