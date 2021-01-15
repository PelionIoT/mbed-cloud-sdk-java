# DeviceDirectoryGroupsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**groupCreate**](DeviceDirectoryGroupsApi.md#groupCreate) | **POST** v3/device-groups/ | Create a group.
[**groupDelete**](DeviceDirectoryGroupsApi.md#groupDelete) | **DELETE** v3/device-groups/{device-group-id}/ | Delete a group.
[**groupList**](DeviceDirectoryGroupsApi.md#groupList) | **GET** v3/device-groups/ | List all groups.
[**groupMembersAdd**](DeviceDirectoryGroupsApi.md#groupMembersAdd) | **POST** v3/device-groups/{device-group-id}/devices/add/ | Add a device to a group.
[**groupMembersRemove**](DeviceDirectoryGroupsApi.md#groupMembersRemove) | **POST** v3/device-groups/{device-group-id}/devices/remove/ | Remove a device from a group.
[**groupMembersRetrieve**](DeviceDirectoryGroupsApi.md#groupMembersRetrieve) | **GET** v3/device-groups/{device-group-id}/devices/ | Get a page of devices.
[**groupRetrieve**](DeviceDirectoryGroupsApi.md#groupRetrieve) | **GET** v3/device-groups/{device-group-id}/ | Get a group.
[**groupUpdate**](DeviceDirectoryGroupsApi.md#groupUpdate) | **PUT** v3/device-groups/{device-group-id}/ | Modify the attributes of a group.


<a name="groupCreate"></a>
# **groupCreate**
> DeviceGroup groupCreate(group)

Create a group.

Create a group.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryGroupsApi apiInstance = new DeviceDirectoryGroupsApi();
Group group = new Group(); // Group | Group
try {
    DeviceGroup result = apiInstance.groupCreate(group);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryGroupsApi#groupCreate");
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

Delete a group.

Delete a group. This deletes the group, but not the devices in the group.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryGroupsApi apiInstance = new DeviceDirectoryGroupsApi();
String deviceGroupId = "deviceGroupId_example"; // String | The ID of the group.
try {
    Void result = apiInstance.groupDelete(deviceGroupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryGroupsApi#groupDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**| The ID of the group. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupList"></a>
# **groupList**
> DeviceGroupPage groupList(limit, order, after, include, filter, idEq, idNeq, idIn, idNin, devicesCountEq, devicesCountNeq, devicesCountIn, devicesCountNin, devicesCountLte, devicesCountGte, nameEq, nameNeq, nameIn, nameNin, createdAtIn, createdAtNin, createdAtLte, createdAtGte, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte)

List all groups.

List all groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryGroupsApi apiInstance = new DeviceDirectoryGroupsApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data.  ##### Filtering  `?filter={URL encoded query string}`  The query string is made up of key/value pairs separated by ampersands. So for a query of `key1=value1&key2=value2&key3=value3`, this would be encoded as `?filter=key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3`.  ###### Filterable fields:  The table lists all filterable fields:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>devices_count</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>name</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>custom_attributes</td>       <td>✓</td>       <td>&nbsp;</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>component_attributes</td>       <td>✓</td>       <td>&nbsp;</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>created_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>updated_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>etag</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>   </tbody> </table> &nbsp;  The examples below show the queries in *unencoded* form.  ###### By device group properties:  `name__eq=mygroup`  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example, 2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example, 20161130T162512Z.  Date-time filtering supports three operators:  * Equality. * Greater than or equal to &ndash; field name suffixed with `__gte`. * Less than or equal to &ndash; field name suffixed with `__lte`.  Lower and upper limits to a date-time range may be specified by including both the `__gte` and `__lte` forms in the filter:  `{field name}[|__lte|__gte]={UTC RFC3339 date-time}`  ###### By device group custom attributes:  `custom_attributes__{param}={value}`  `custom_attributes__tag=TAG1`  ###### By device group component attributes:  `component_attributes__{name}={version}` `component_attributes__{name}__{operator}={version}`  `component_attributes__ble=1.2.3` `component_attributes__main__gt=1.2.3`  ##### Multi-field example  `name__eq=mygroup&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  Encoded:  `?filter=name__eq%3Dmygroup%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-12-30T00%3A00%3A00Z`  ##### Filtering with filter operators  String field filtering supports the following operators:  * Equality: `__eq`. * Non-equality: `__neq`. * In : `__in`. * Not in: `__nin`.  For `__in` and `__nin` filters list of parameters must be comma-separated: `name__in=group1,group2`
String idEq = "idEq_example"; // String | eq filter for the \"id\" field
String idNeq = "idNeq_example"; // String | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
Integer devicesCountEq = 56; // Integer | eq filter for the \"devices_count\" field
Integer devicesCountNeq = 56; // Integer | neq filter for the \"devices_count\" field
String devicesCountIn = "devicesCountIn_example"; // String | in filter for the \"devices_count\" field
String devicesCountNin = "devicesCountNin_example"; // String | nin filter for the \"devices_count\" field
Integer devicesCountLte = 56; // Integer | lte filter for the \"devices_count\" field
Integer devicesCountGte = 56; // Integer | gte filter for the \"devices_count\" field
String nameEq = "nameEq_example"; // String | eq filter for the \"name\" field
String nameNeq = "nameNeq_example"; // String | neq filter for the \"name\" field
String nameIn = "nameIn_example"; // String | in filter for the \"name\" field
String nameNin = "nameNin_example"; // String | nin filter for the \"name\" field
String createdAtIn = "createdAtIn_example"; // String | in filter for the \"created_at\" field
String createdAtNin = "createdAtNin_example"; // String | nin filter for the \"created_at\" field
DateTime createdAtLte = new DateTime(); // DateTime | lte filter for the \"created_at\" field
DateTime createdAtGte = new DateTime(); // DateTime | gte filter for the \"created_at\" field
String updatedAtIn = "updatedAtIn_example"; // String | in filter for the \"updated_at\" field
String updatedAtNin = "updatedAtNin_example"; // String | nin filter for the \"updated_at\" field
DateTime updatedAtLte = new DateTime(); // DateTime | lte filter for the \"updated_at\" field
DateTime updatedAtGte = new DateTime(); // DateTime | gte filter for the \"updated_at\" field
try {
    DeviceGroupPage result = apiInstance.groupList(limit, order, after, include, filter, idEq, idNeq, idIn, idNin, devicesCountEq, devicesCountNeq, devicesCountIn, devicesCountNin, devicesCountLte, devicesCountGte, nameEq, nameNeq, nameIn, nameNin, createdAtIn, createdAtNin, createdAtLte, createdAtGte, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryGroupsApi#groupList");
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
 **filter** | **String**| URL-encoded query string parameter to filter returned data.  ##### Filtering  &#x60;?filter&#x3D;{URL encoded query string}&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;, this would be encoded as &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;.  ###### Filterable fields:  The table lists all filterable fields:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;devices_count&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;custom_attributes&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;component_attributes&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By device group properties:  &#x60;name__eq&#x3D;mygroup&#x60;  ###### On date-time fields:  Date-time fields should be specified in UTC RFC3339 format &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example, 2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example, 20161130T162512Z.  Date-time filtering supports three operators:  * Equality. * Greater than or equal to &amp;ndash; field name suffixed with &#x60;__gte&#x60;. * Less than or equal to &amp;ndash; field name suffixed with &#x60;__lte&#x60;.  Lower and upper limits to a date-time range may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter:  &#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  ###### By device group custom attributes:  &#x60;custom_attributes__{param}&#x3D;{value}&#x60;  &#x60;custom_attributes__tag&#x3D;TAG1&#x60;  ###### By device group component attributes:  &#x60;component_attributes__{name}&#x3D;{version}&#x60; &#x60;component_attributes__{name}__{operator}&#x3D;{version}&#x60;  &#x60;component_attributes__ble&#x3D;1.2.3&#x60; &#x60;component_attributes__main__gt&#x3D;1.2.3&#x60;  ##### Multi-field example  &#x60;name__eq&#x3D;mygroup&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  Encoded:  &#x60;?filter&#x3D;name__eq%3Dmygroup%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-12-30T00%3A00%3A00Z&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * Equality: &#x60;__eq&#x60;. * Non-equality: &#x60;__neq&#x60;. * In : &#x60;__in&#x60;. * Not in: &#x60;__nin&#x60;.  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated: &#x60;name__in&#x3D;group1,group2&#x60; | [optional]
 **idEq** | **String**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **String**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **devicesCountEq** | **Integer**| eq filter for the \&quot;devices_count\&quot; field | [optional]
 **devicesCountNeq** | **Integer**| neq filter for the \&quot;devices_count\&quot; field | [optional]
 **devicesCountIn** | **String**| in filter for the \&quot;devices_count\&quot; field | [optional]
 **devicesCountNin** | **String**| nin filter for the \&quot;devices_count\&quot; field | [optional]
 **devicesCountLte** | **Integer**| lte filter for the \&quot;devices_count\&quot; field | [optional]
 **devicesCountGte** | **Integer**| gte filter for the \&quot;devices_count\&quot; field | [optional]
 **nameEq** | **String**| eq filter for the \&quot;name\&quot; field | [optional]
 **nameNeq** | **String**| neq filter for the \&quot;name\&quot; field | [optional]
 **nameIn** | **String**| in filter for the \&quot;name\&quot; field | [optional]
 **nameNin** | **String**| nin filter for the \&quot;name\&quot; field | [optional]
 **createdAtIn** | **String**| in filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtNin** | **String**| nin filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtLte** | **DateTime**| lte filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtGte** | **DateTime**| gte filter for the \&quot;created_at\&quot; field | [optional]
 **updatedAtIn** | **String**| in filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtNin** | **String**| nin filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtLte** | **DateTime**| lte filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtGte** | **DateTime**| gte filter for the \&quot;updated_at\&quot; field | [optional]

### Return type

[**DeviceGroupPage**](DeviceGroupPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupMembersAdd"></a>
# **groupMembersAdd**
> Void groupMembersAdd(deviceGroupId, body)

Add a device to a group.

Add one device to a group. A device can be in multiple groups.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryGroupsApi apiInstance = new DeviceDirectoryGroupsApi();
String deviceGroupId = "deviceGroupId_example"; // String | The ID of the group.
DeviceGroupManipulation body = new DeviceGroupManipulation(); // DeviceGroupManipulation | Body of the request.
try {
    Void result = apiInstance.groupMembersAdd(deviceGroupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryGroupsApi#groupMembersAdd");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**| The ID of the group. |
 **body** | [**DeviceGroupManipulation**](DeviceGroupManipulation.md)| Body of the request. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupMembersRemove"></a>
# **groupMembersRemove**
> Void groupMembersRemove(deviceGroupId, body)

Remove a device from a group.

Remove one device from a group.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryGroupsApi apiInstance = new DeviceDirectoryGroupsApi();
String deviceGroupId = "deviceGroupId_example"; // String | The ID of the group.
DeviceGroupManipulation body = new DeviceGroupManipulation(); // DeviceGroupManipulation | Body of the request.
try {
    Void result = apiInstance.groupMembersRemove(deviceGroupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryGroupsApi#groupMembersRemove");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**| The ID of the group. |
 **body** | [**DeviceGroupManipulation**](DeviceGroupManipulation.md)| Body of the request. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="groupMembersRetrieve"></a>
# **groupMembersRetrieve**
> DevicePage groupMembersRetrieve(deviceGroupId, limit, order, after, include, lifecycleStatusEq, lifecycleStatusNeq, lifecycleStatusIn, lifecycleStatusNin, operatorSuspendedEq, operatorSuspendedNeq, lastOperatorSuspendedCategoryEq, lastOperatorSuspendedCategoryNeq, lastOperatorSuspendedCategoryIn, lastOperatorSuspendedCategoryNin, lastOperatorSuspendedUpdatedAtIn, lastOperatorSuspendedUpdatedAtNin, lastOperatorSuspendedUpdatedAtLte, lastOperatorSuspendedUpdatedAtGte, systemSuspendedEq, systemSuspendedNeq, lastSystemSuspendedCategoryEq, lastSystemSuspendedCategoryNeq, lastSystemSuspendedCategoryIn, lastSystemSuspendedCategoryNin, lastSystemSuspendedUpdatedAtIn, lastSystemSuspendedUpdatedAtNin, lastSystemSuspendedUpdatedAtLte, lastSystemSuspendedUpdatedAtGte, accountIdEq, accountIdNeq, accountIdIn, accountIdNin, autoUpdateEq, autoUpdateNeq, bootstrapExpirationDateIn, bootstrapExpirationDateNin, bootstrapExpirationDateLte, bootstrapExpirationDateGte, bootstrappedTimestampIn, bootstrappedTimestampNin, bootstrappedTimestampLte, bootstrappedTimestampGte, caIdEq, caIdNeq, caIdIn, caIdNin, connectorExpirationDateIn, connectorExpirationDateNin, connectorExpirationDateLte, connectorExpirationDateGte, createdAtIn, createdAtNin, createdAtLte, createdAtGte, deployedStateEq, deployedStateNeq, deployedStateIn, deployedStateNin, deploymentEq, deploymentNeq, deploymentIn, deploymentNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, deviceExecutionModeEq, deviceExecutionModeNeq, deviceExecutionModeIn, deviceExecutionModeNin, deviceKeyEq, deviceKeyNeq, deviceKeyIn, deviceKeyNin, endpointNameEq, endpointNameNeq, endpointNameIn, endpointNameNin, endpointTypeEq, endpointTypeNeq, endpointTypeIn, endpointTypeNin, enrolmentListTimestampIn, enrolmentListTimestampNin, enrolmentListTimestampLte, enrolmentListTimestampGte, firmwareChecksumEq, firmwareChecksumNeq, firmwareChecksumIn, firmwareChecksumNin, hostGatewayEq, hostGatewayNeq, hostGatewayIn, hostGatewayNin, idEq, idNeq, idIn, idNin, manifestEq, manifestNeq, manifestIn, manifestNin, manifestTimestampIn, manifestTimestampNin, manifestTimestampLte, manifestTimestampGte, mechanismEq, mechanismNeq, mechanismIn, mechanismNin, mechanismUrlEq, mechanismUrlNeq, mechanismUrlIn, mechanismUrlNin, nameEq, nameNeq, nameIn, nameNin, netIdEq, netIdNeq, netIdIn, netIdNin, serialNumberEq, serialNumberNeq, serialNumberIn, serialNumberNin, stateEq, stateNeq, stateIn, stateNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, vendorIdEq, vendorIdNeq, vendorIdIn, vendorIdNin)

Get a page of devices.

Get a page of devices in a specified group.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryGroupsApi apiInstance = new DeviceDirectoryGroupsApi();
String deviceGroupId = "deviceGroupId_example"; // String | 
Integer limit = 56; // Integer | How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String lifecycleStatusEq = "lifecycleStatusEq_example"; // String | eq filter for the \"lifecycle_status\" field
String lifecycleStatusNeq = "lifecycleStatusNeq_example"; // String | neq filter for the \"lifecycle_status\" field
String lifecycleStatusIn = "lifecycleStatusIn_example"; // String | in filter for the \"lifecycle_status\" field
String lifecycleStatusNin = "lifecycleStatusNin_example"; // String | nin filter for the \"lifecycle_status\" field
Boolean operatorSuspendedEq = true; // Boolean | eq filter for the \"operator_suspended\" field
Boolean operatorSuspendedNeq = true; // Boolean | neq filter for the \"operator_suspended\" field
String lastOperatorSuspendedCategoryEq = "lastOperatorSuspendedCategoryEq_example"; // String | eq filter for the \"last_operator_suspended_category\" field
String lastOperatorSuspendedCategoryNeq = "lastOperatorSuspendedCategoryNeq_example"; // String | neq filter for the \"last_operator_suspended_category\" field
String lastOperatorSuspendedCategoryIn = "lastOperatorSuspendedCategoryIn_example"; // String | in filter for the \"last_operator_suspended_category\" field
String lastOperatorSuspendedCategoryNin = "lastOperatorSuspendedCategoryNin_example"; // String | nin filter for the \"last_operator_suspended_category\" field
String lastOperatorSuspendedUpdatedAtIn = "lastOperatorSuspendedUpdatedAtIn_example"; // String | in filter for the \"last_operator_suspended_updated_at\" field
String lastOperatorSuspendedUpdatedAtNin = "lastOperatorSuspendedUpdatedAtNin_example"; // String | nin filter for the \"last_operator_suspended_updated_at\" field
DateTime lastOperatorSuspendedUpdatedAtLte = new DateTime(); // DateTime | lte filter for the \"last_operator_suspended_updated_at\" field
DateTime lastOperatorSuspendedUpdatedAtGte = new DateTime(); // DateTime | gte filter for the \"last_operator_suspended_updated_at\" field
Boolean systemSuspendedEq = true; // Boolean | eq filter for the \"system_suspended\" field
Boolean systemSuspendedNeq = true; // Boolean | neq filter for the \"system_suspended\" field
String lastSystemSuspendedCategoryEq = "lastSystemSuspendedCategoryEq_example"; // String | eq filter for the \"last_system_suspended_category\" field
String lastSystemSuspendedCategoryNeq = "lastSystemSuspendedCategoryNeq_example"; // String | neq filter for the \"last_system_suspended_category\" field
String lastSystemSuspendedCategoryIn = "lastSystemSuspendedCategoryIn_example"; // String | in filter for the \"last_system_suspended_category\" field
String lastSystemSuspendedCategoryNin = "lastSystemSuspendedCategoryNin_example"; // String | nin filter for the \"last_system_suspended_category\" field
String lastSystemSuspendedUpdatedAtIn = "lastSystemSuspendedUpdatedAtIn_example"; // String | in filter for the \"last_system_suspended_updated_at\" field
String lastSystemSuspendedUpdatedAtNin = "lastSystemSuspendedUpdatedAtNin_example"; // String | nin filter for the \"last_system_suspended_updated_at\" field
DateTime lastSystemSuspendedUpdatedAtLte = new DateTime(); // DateTime | lte filter for the \"last_system_suspended_updated_at\" field
DateTime lastSystemSuspendedUpdatedAtGte = new DateTime(); // DateTime | gte filter for the \"last_system_suspended_updated_at\" field
String accountIdEq = "accountIdEq_example"; // String | eq filter for the \"account_id\" field
String accountIdNeq = "accountIdNeq_example"; // String | neq filter for the \"account_id\" field
String accountIdIn = "accountIdIn_example"; // String | in filter for the \"account_id\" field
String accountIdNin = "accountIdNin_example"; // String | nin filter for the \"account_id\" field
Boolean autoUpdateEq = true; // Boolean | eq filter for the \"auto_update\" field
Boolean autoUpdateNeq = true; // Boolean | neq filter for the \"auto_update\" field
String bootstrapExpirationDateIn = "bootstrapExpirationDateIn_example"; // String | in filter for the \"bootstrap_expiration_date\" field
String bootstrapExpirationDateNin = "bootstrapExpirationDateNin_example"; // String | nin filter for the \"bootstrap_expiration_date\" field
LocalDate bootstrapExpirationDateLte = new LocalDate(); // LocalDate | lte filter for the \"bootstrap_expiration_date\" field
LocalDate bootstrapExpirationDateGte = new LocalDate(); // LocalDate | gte filter for the \"bootstrap_expiration_date\" field
String bootstrappedTimestampIn = "bootstrappedTimestampIn_example"; // String | in filter for the \"bootstrapped_timestamp\" field
String bootstrappedTimestampNin = "bootstrappedTimestampNin_example"; // String | nin filter for the \"bootstrapped_timestamp\" field
DateTime bootstrappedTimestampLte = new DateTime(); // DateTime | lte filter for the \"bootstrapped_timestamp\" field
DateTime bootstrappedTimestampGte = new DateTime(); // DateTime | gte filter for the \"bootstrapped_timestamp\" field
String caIdEq = "caIdEq_example"; // String | eq filter for the \"ca_id\" field
String caIdNeq = "caIdNeq_example"; // String | neq filter for the \"ca_id\" field
String caIdIn = "caIdIn_example"; // String | in filter for the \"ca_id\" field
String caIdNin = "caIdNin_example"; // String | nin filter for the \"ca_id\" field
String connectorExpirationDateIn = "connectorExpirationDateIn_example"; // String | in filter for the \"connector_expiration_date\" field
String connectorExpirationDateNin = "connectorExpirationDateNin_example"; // String | nin filter for the \"connector_expiration_date\" field
LocalDate connectorExpirationDateLte = new LocalDate(); // LocalDate | lte filter for the \"connector_expiration_date\" field
LocalDate connectorExpirationDateGte = new LocalDate(); // LocalDate | gte filter for the \"connector_expiration_date\" field
String createdAtIn = "createdAtIn_example"; // String | in filter for the \"created_at\" field
String createdAtNin = "createdAtNin_example"; // String | nin filter for the \"created_at\" field
DateTime createdAtLte = new DateTime(); // DateTime | lte filter for the \"created_at\" field
DateTime createdAtGte = new DateTime(); // DateTime | gte filter for the \"created_at\" field
String deployedStateEq = "deployedStateEq_example"; // String | eq filter for the \"deployed_state\" field
String deployedStateNeq = "deployedStateNeq_example"; // String | neq filter for the \"deployed_state\" field
String deployedStateIn = "deployedStateIn_example"; // String | in filter for the \"deployed_state\" field
String deployedStateNin = "deployedStateNin_example"; // String | nin filter for the \"deployed_state\" field
String deploymentEq = "deploymentEq_example"; // String | eq filter for the \"deployment\" field
String deploymentNeq = "deploymentNeq_example"; // String | neq filter for the \"deployment\" field
String deploymentIn = "deploymentIn_example"; // String | in filter for the \"deployment\" field
String deploymentNin = "deploymentNin_example"; // String | nin filter for the \"deployment\" field
String descriptionEq = "descriptionEq_example"; // String | eq filter for the \"description\" field
String descriptionNeq = "descriptionNeq_example"; // String | neq filter for the \"description\" field
String descriptionIn = "descriptionIn_example"; // String | in filter for the \"description\" field
String descriptionNin = "descriptionNin_example"; // String | nin filter for the \"description\" field
String deviceClassEq = "deviceClassEq_example"; // String | eq filter for the \"device_class\" field
String deviceClassNeq = "deviceClassNeq_example"; // String | neq filter for the \"device_class\" field
String deviceClassIn = "deviceClassIn_example"; // String | in filter for the \"device_class\" field
String deviceClassNin = "deviceClassNin_example"; // String | nin filter for the \"device_class\" field
Integer deviceExecutionModeEq = 56; // Integer | eq filter for the \"device_execution_mode\" field
Integer deviceExecutionModeNeq = 56; // Integer | neq filter for the \"device_execution_mode\" field
String deviceExecutionModeIn = "deviceExecutionModeIn_example"; // String | in filter for the \"device_execution_mode\" field
String deviceExecutionModeNin = "deviceExecutionModeNin_example"; // String | nin filter for the \"device_execution_mode\" field
String deviceKeyEq = "deviceKeyEq_example"; // String | eq filter for the \"device_key\" field
String deviceKeyNeq = "deviceKeyNeq_example"; // String | neq filter for the \"device_key\" field
String deviceKeyIn = "deviceKeyIn_example"; // String | in filter for the \"device_key\" field
String deviceKeyNin = "deviceKeyNin_example"; // String | nin filter for the \"device_key\" field
String endpointNameEq = "endpointNameEq_example"; // String | eq filter for the \"endpoint_name\" field
String endpointNameNeq = "endpointNameNeq_example"; // String | neq filter for the \"endpoint_name\" field
String endpointNameIn = "endpointNameIn_example"; // String | in filter for the \"endpoint_name\" field
String endpointNameNin = "endpointNameNin_example"; // String | nin filter for the \"endpoint_name\" field
String endpointTypeEq = "endpointTypeEq_example"; // String | eq filter for the \"endpoint_type\" field
String endpointTypeNeq = "endpointTypeNeq_example"; // String | neq filter for the \"endpoint_type\" field
String endpointTypeIn = "endpointTypeIn_example"; // String | in filter for the \"endpoint_type\" field
String endpointTypeNin = "endpointTypeNin_example"; // String | nin filter for the \"endpoint_type\" field
String enrolmentListTimestampIn = "enrolmentListTimestampIn_example"; // String | in filter for the \"enrolment_list_timestamp\" field
String enrolmentListTimestampNin = "enrolmentListTimestampNin_example"; // String | nin filter for the \"enrolment_list_timestamp\" field
DateTime enrolmentListTimestampLte = new DateTime(); // DateTime | lte filter for the \"enrolment_list_timestamp\" field
DateTime enrolmentListTimestampGte = new DateTime(); // DateTime | gte filter for the \"enrolment_list_timestamp\" field
String firmwareChecksumEq = "firmwareChecksumEq_example"; // String | eq filter for the \"firmware_checksum\" field
String firmwareChecksumNeq = "firmwareChecksumNeq_example"; // String | neq filter for the \"firmware_checksum\" field
String firmwareChecksumIn = "firmwareChecksumIn_example"; // String | in filter for the \"firmware_checksum\" field
String firmwareChecksumNin = "firmwareChecksumNin_example"; // String | nin filter for the \"firmware_checksum\" field
String hostGatewayEq = "hostGatewayEq_example"; // String | eq filter for the \"host_gateway\" field
String hostGatewayNeq = "hostGatewayNeq_example"; // String | neq filter for the \"host_gateway\" field
String hostGatewayIn = "hostGatewayIn_example"; // String | in filter for the \"host_gateway\" field
String hostGatewayNin = "hostGatewayNin_example"; // String | nin filter for the \"host_gateway\" field
String idEq = "idEq_example"; // String | eq filter for the \"id\" field
String idNeq = "idNeq_example"; // String | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
String manifestEq = "manifestEq_example"; // String | eq filter for the \"manifest\" field
String manifestNeq = "manifestNeq_example"; // String | neq filter for the \"manifest\" field
String manifestIn = "manifestIn_example"; // String | in filter for the \"manifest\" field
String manifestNin = "manifestNin_example"; // String | nin filter for the \"manifest\" field
String manifestTimestampIn = "manifestTimestampIn_example"; // String | in filter for the \"manifest_timestamp\" field
String manifestTimestampNin = "manifestTimestampNin_example"; // String | nin filter for the \"manifest_timestamp\" field
DateTime manifestTimestampLte = new DateTime(); // DateTime | lte filter for the \"manifest_timestamp\" field
DateTime manifestTimestampGte = new DateTime(); // DateTime | gte filter for the \"manifest_timestamp\" field
String mechanismEq = "mechanismEq_example"; // String | eq filter for the \"mechanism\" field
String mechanismNeq = "mechanismNeq_example"; // String | neq filter for the \"mechanism\" field
String mechanismIn = "mechanismIn_example"; // String | in filter for the \"mechanism\" field
String mechanismNin = "mechanismNin_example"; // String | nin filter for the \"mechanism\" field
String mechanismUrlEq = "mechanismUrlEq_example"; // String | eq filter for the \"mechanism_url\" field
String mechanismUrlNeq = "mechanismUrlNeq_example"; // String | neq filter for the \"mechanism_url\" field
String mechanismUrlIn = "mechanismUrlIn_example"; // String | in filter for the \"mechanism_url\" field
String mechanismUrlNin = "mechanismUrlNin_example"; // String | nin filter for the \"mechanism_url\" field
String nameEq = "nameEq_example"; // String | eq filter for the \"name\" field
String nameNeq = "nameNeq_example"; // String | neq filter for the \"name\" field
String nameIn = "nameIn_example"; // String | in filter for the \"name\" field
String nameNin = "nameNin_example"; // String | nin filter for the \"name\" field
String netIdEq = "netIdEq_example"; // String | eq filter for the \"net_id\" field
String netIdNeq = "netIdNeq_example"; // String | neq filter for the \"net_id\" field
String netIdIn = "netIdIn_example"; // String | in filter for the \"net_id\" field
String netIdNin = "netIdNin_example"; // String | nin filter for the \"net_id\" field
String serialNumberEq = "serialNumberEq_example"; // String | eq filter for the \"serial_number\" field
String serialNumberNeq = "serialNumberNeq_example"; // String | neq filter for the \"serial_number\" field
String serialNumberIn = "serialNumberIn_example"; // String | in filter for the \"serial_number\" field
String serialNumberNin = "serialNumberNin_example"; // String | nin filter for the \"serial_number\" field
String stateEq = "stateEq_example"; // String | eq filter for the \"state\" field
String stateNeq = "stateNeq_example"; // String | neq filter for the \"state\" field
String stateIn = "stateIn_example"; // String | in filter for the \"state\" field
String stateNin = "stateNin_example"; // String | nin filter for the \"state\" field
String updatedAtIn = "updatedAtIn_example"; // String | in filter for the \"updated_at\" field
String updatedAtNin = "updatedAtNin_example"; // String | nin filter for the \"updated_at\" field
DateTime updatedAtLte = new DateTime(); // DateTime | lte filter for the \"updated_at\" field
DateTime updatedAtGte = new DateTime(); // DateTime | gte filter for the \"updated_at\" field
String vendorIdEq = "vendorIdEq_example"; // String | eq filter for the \"vendor_id\" field
String vendorIdNeq = "vendorIdNeq_example"; // String | neq filter for the \"vendor_id\" field
String vendorIdIn = "vendorIdIn_example"; // String | in filter for the \"vendor_id\" field
String vendorIdNin = "vendorIdNin_example"; // String | nin filter for the \"vendor_id\" field
try {
    DevicePage result = apiInstance.groupMembersRetrieve(deviceGroupId, limit, order, after, include, lifecycleStatusEq, lifecycleStatusNeq, lifecycleStatusIn, lifecycleStatusNin, operatorSuspendedEq, operatorSuspendedNeq, lastOperatorSuspendedCategoryEq, lastOperatorSuspendedCategoryNeq, lastOperatorSuspendedCategoryIn, lastOperatorSuspendedCategoryNin, lastOperatorSuspendedUpdatedAtIn, lastOperatorSuspendedUpdatedAtNin, lastOperatorSuspendedUpdatedAtLte, lastOperatorSuspendedUpdatedAtGte, systemSuspendedEq, systemSuspendedNeq, lastSystemSuspendedCategoryEq, lastSystemSuspendedCategoryNeq, lastSystemSuspendedCategoryIn, lastSystemSuspendedCategoryNin, lastSystemSuspendedUpdatedAtIn, lastSystemSuspendedUpdatedAtNin, lastSystemSuspendedUpdatedAtLte, lastSystemSuspendedUpdatedAtGte, accountIdEq, accountIdNeq, accountIdIn, accountIdNin, autoUpdateEq, autoUpdateNeq, bootstrapExpirationDateIn, bootstrapExpirationDateNin, bootstrapExpirationDateLte, bootstrapExpirationDateGte, bootstrappedTimestampIn, bootstrappedTimestampNin, bootstrappedTimestampLte, bootstrappedTimestampGte, caIdEq, caIdNeq, caIdIn, caIdNin, connectorExpirationDateIn, connectorExpirationDateNin, connectorExpirationDateLte, connectorExpirationDateGte, createdAtIn, createdAtNin, createdAtLte, createdAtGte, deployedStateEq, deployedStateNeq, deployedStateIn, deployedStateNin, deploymentEq, deploymentNeq, deploymentIn, deploymentNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, deviceExecutionModeEq, deviceExecutionModeNeq, deviceExecutionModeIn, deviceExecutionModeNin, deviceKeyEq, deviceKeyNeq, deviceKeyIn, deviceKeyNin, endpointNameEq, endpointNameNeq, endpointNameIn, endpointNameNin, endpointTypeEq, endpointTypeNeq, endpointTypeIn, endpointTypeNin, enrolmentListTimestampIn, enrolmentListTimestampNin, enrolmentListTimestampLte, enrolmentListTimestampGte, firmwareChecksumEq, firmwareChecksumNeq, firmwareChecksumIn, firmwareChecksumNin, hostGatewayEq, hostGatewayNeq, hostGatewayIn, hostGatewayNin, idEq, idNeq, idIn, idNin, manifestEq, manifestNeq, manifestIn, manifestNin, manifestTimestampIn, manifestTimestampNin, manifestTimestampLte, manifestTimestampGte, mechanismEq, mechanismNeq, mechanismIn, mechanismNin, mechanismUrlEq, mechanismUrlNeq, mechanismUrlIn, mechanismUrlNin, nameEq, nameNeq, nameIn, nameNin, netIdEq, netIdNeq, netIdIn, netIdNin, serialNumberEq, serialNumberNeq, serialNumberIn, serialNumberNin, stateEq, stateNeq, stateIn, stateNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, vendorIdEq, vendorIdNeq, vendorIdIn, vendorIdNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryGroupsApi#groupMembersRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceGroupId** | **String**|  |
 **limit** | **Integer**| How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. Default: ASC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]
 **lifecycleStatusEq** | **String**| eq filter for the \&quot;lifecycle_status\&quot; field | [optional]
 **lifecycleStatusNeq** | **String**| neq filter for the \&quot;lifecycle_status\&quot; field | [optional]
 **lifecycleStatusIn** | **String**| in filter for the \&quot;lifecycle_status\&quot; field | [optional]
 **lifecycleStatusNin** | **String**| nin filter for the \&quot;lifecycle_status\&quot; field | [optional]
 **operatorSuspendedEq** | **Boolean**| eq filter for the \&quot;operator_suspended\&quot; field | [optional]
 **operatorSuspendedNeq** | **Boolean**| neq filter for the \&quot;operator_suspended\&quot; field | [optional]
 **lastOperatorSuspendedCategoryEq** | **String**| eq filter for the \&quot;last_operator_suspended_category\&quot; field | [optional]
 **lastOperatorSuspendedCategoryNeq** | **String**| neq filter for the \&quot;last_operator_suspended_category\&quot; field | [optional]
 **lastOperatorSuspendedCategoryIn** | **String**| in filter for the \&quot;last_operator_suspended_category\&quot; field | [optional]
 **lastOperatorSuspendedCategoryNin** | **String**| nin filter for the \&quot;last_operator_suspended_category\&quot; field | [optional]
 **lastOperatorSuspendedUpdatedAtIn** | **String**| in filter for the \&quot;last_operator_suspended_updated_at\&quot; field | [optional]
 **lastOperatorSuspendedUpdatedAtNin** | **String**| nin filter for the \&quot;last_operator_suspended_updated_at\&quot; field | [optional]
 **lastOperatorSuspendedUpdatedAtLte** | **DateTime**| lte filter for the \&quot;last_operator_suspended_updated_at\&quot; field | [optional]
 **lastOperatorSuspendedUpdatedAtGte** | **DateTime**| gte filter for the \&quot;last_operator_suspended_updated_at\&quot; field | [optional]
 **systemSuspendedEq** | **Boolean**| eq filter for the \&quot;system_suspended\&quot; field | [optional]
 **systemSuspendedNeq** | **Boolean**| neq filter for the \&quot;system_suspended\&quot; field | [optional]
 **lastSystemSuspendedCategoryEq** | **String**| eq filter for the \&quot;last_system_suspended_category\&quot; field | [optional]
 **lastSystemSuspendedCategoryNeq** | **String**| neq filter for the \&quot;last_system_suspended_category\&quot; field | [optional]
 **lastSystemSuspendedCategoryIn** | **String**| in filter for the \&quot;last_system_suspended_category\&quot; field | [optional]
 **lastSystemSuspendedCategoryNin** | **String**| nin filter for the \&quot;last_system_suspended_category\&quot; field | [optional]
 **lastSystemSuspendedUpdatedAtIn** | **String**| in filter for the \&quot;last_system_suspended_updated_at\&quot; field | [optional]
 **lastSystemSuspendedUpdatedAtNin** | **String**| nin filter for the \&quot;last_system_suspended_updated_at\&quot; field | [optional]
 **lastSystemSuspendedUpdatedAtLte** | **DateTime**| lte filter for the \&quot;last_system_suspended_updated_at\&quot; field | [optional]
 **lastSystemSuspendedUpdatedAtGte** | **DateTime**| gte filter for the \&quot;last_system_suspended_updated_at\&quot; field | [optional]
 **accountIdEq** | **String**| eq filter for the \&quot;account_id\&quot; field | [optional]
 **accountIdNeq** | **String**| neq filter for the \&quot;account_id\&quot; field | [optional]
 **accountIdIn** | **String**| in filter for the \&quot;account_id\&quot; field | [optional]
 **accountIdNin** | **String**| nin filter for the \&quot;account_id\&quot; field | [optional]
 **autoUpdateEq** | **Boolean**| eq filter for the \&quot;auto_update\&quot; field | [optional]
 **autoUpdateNeq** | **Boolean**| neq filter for the \&quot;auto_update\&quot; field | [optional]
 **bootstrapExpirationDateIn** | **String**| in filter for the \&quot;bootstrap_expiration_date\&quot; field | [optional]
 **bootstrapExpirationDateNin** | **String**| nin filter for the \&quot;bootstrap_expiration_date\&quot; field | [optional]
 **bootstrapExpirationDateLte** | **LocalDate**| lte filter for the \&quot;bootstrap_expiration_date\&quot; field | [optional]
 **bootstrapExpirationDateGte** | **LocalDate**| gte filter for the \&quot;bootstrap_expiration_date\&quot; field | [optional]
 **bootstrappedTimestampIn** | **String**| in filter for the \&quot;bootstrapped_timestamp\&quot; field | [optional]
 **bootstrappedTimestampNin** | **String**| nin filter for the \&quot;bootstrapped_timestamp\&quot; field | [optional]
 **bootstrappedTimestampLte** | **DateTime**| lte filter for the \&quot;bootstrapped_timestamp\&quot; field | [optional]
 **bootstrappedTimestampGte** | **DateTime**| gte filter for the \&quot;bootstrapped_timestamp\&quot; field | [optional]
 **caIdEq** | **String**| eq filter for the \&quot;ca_id\&quot; field | [optional]
 **caIdNeq** | **String**| neq filter for the \&quot;ca_id\&quot; field | [optional]
 **caIdIn** | **String**| in filter for the \&quot;ca_id\&quot; field | [optional]
 **caIdNin** | **String**| nin filter for the \&quot;ca_id\&quot; field | [optional]
 **connectorExpirationDateIn** | **String**| in filter for the \&quot;connector_expiration_date\&quot; field | [optional]
 **connectorExpirationDateNin** | **String**| nin filter for the \&quot;connector_expiration_date\&quot; field | [optional]
 **connectorExpirationDateLte** | **LocalDate**| lte filter for the \&quot;connector_expiration_date\&quot; field | [optional]
 **connectorExpirationDateGte** | **LocalDate**| gte filter for the \&quot;connector_expiration_date\&quot; field | [optional]
 **createdAtIn** | **String**| in filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtNin** | **String**| nin filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtLte** | **DateTime**| lte filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtGte** | **DateTime**| gte filter for the \&quot;created_at\&quot; field | [optional]
 **deployedStateEq** | **String**| eq filter for the \&quot;deployed_state\&quot; field | [optional]
 **deployedStateNeq** | **String**| neq filter for the \&quot;deployed_state\&quot; field | [optional]
 **deployedStateIn** | **String**| in filter for the \&quot;deployed_state\&quot; field | [optional]
 **deployedStateNin** | **String**| nin filter for the \&quot;deployed_state\&quot; field | [optional]
 **deploymentEq** | **String**| eq filter for the \&quot;deployment\&quot; field | [optional]
 **deploymentNeq** | **String**| neq filter for the \&quot;deployment\&quot; field | [optional]
 **deploymentIn** | **String**| in filter for the \&quot;deployment\&quot; field | [optional]
 **deploymentNin** | **String**| nin filter for the \&quot;deployment\&quot; field | [optional]
 **descriptionEq** | **String**| eq filter for the \&quot;description\&quot; field | [optional]
 **descriptionNeq** | **String**| neq filter for the \&quot;description\&quot; field | [optional]
 **descriptionIn** | **String**| in filter for the \&quot;description\&quot; field | [optional]
 **descriptionNin** | **String**| nin filter for the \&quot;description\&quot; field | [optional]
 **deviceClassEq** | **String**| eq filter for the \&quot;device_class\&quot; field | [optional]
 **deviceClassNeq** | **String**| neq filter for the \&quot;device_class\&quot; field | [optional]
 **deviceClassIn** | **String**| in filter for the \&quot;device_class\&quot; field | [optional]
 **deviceClassNin** | **String**| nin filter for the \&quot;device_class\&quot; field | [optional]
 **deviceExecutionModeEq** | **Integer**| eq filter for the \&quot;device_execution_mode\&quot; field | [optional]
 **deviceExecutionModeNeq** | **Integer**| neq filter for the \&quot;device_execution_mode\&quot; field | [optional]
 **deviceExecutionModeIn** | **String**| in filter for the \&quot;device_execution_mode\&quot; field | [optional]
 **deviceExecutionModeNin** | **String**| nin filter for the \&quot;device_execution_mode\&quot; field | [optional]
 **deviceKeyEq** | **String**| eq filter for the \&quot;device_key\&quot; field | [optional]
 **deviceKeyNeq** | **String**| neq filter for the \&quot;device_key\&quot; field | [optional]
 **deviceKeyIn** | **String**| in filter for the \&quot;device_key\&quot; field | [optional]
 **deviceKeyNin** | **String**| nin filter for the \&quot;device_key\&quot; field | [optional]
 **endpointNameEq** | **String**| eq filter for the \&quot;endpoint_name\&quot; field | [optional]
 **endpointNameNeq** | **String**| neq filter for the \&quot;endpoint_name\&quot; field | [optional]
 **endpointNameIn** | **String**| in filter for the \&quot;endpoint_name\&quot; field | [optional]
 **endpointNameNin** | **String**| nin filter for the \&quot;endpoint_name\&quot; field | [optional]
 **endpointTypeEq** | **String**| eq filter for the \&quot;endpoint_type\&quot; field | [optional]
 **endpointTypeNeq** | **String**| neq filter for the \&quot;endpoint_type\&quot; field | [optional]
 **endpointTypeIn** | **String**| in filter for the \&quot;endpoint_type\&quot; field | [optional]
 **endpointTypeNin** | **String**| nin filter for the \&quot;endpoint_type\&quot; field | [optional]
 **enrolmentListTimestampIn** | **String**| in filter for the \&quot;enrolment_list_timestamp\&quot; field | [optional]
 **enrolmentListTimestampNin** | **String**| nin filter for the \&quot;enrolment_list_timestamp\&quot; field | [optional]
 **enrolmentListTimestampLte** | **DateTime**| lte filter for the \&quot;enrolment_list_timestamp\&quot; field | [optional]
 **enrolmentListTimestampGte** | **DateTime**| gte filter for the \&quot;enrolment_list_timestamp\&quot; field | [optional]
 **firmwareChecksumEq** | **String**| eq filter for the \&quot;firmware_checksum\&quot; field | [optional]
 **firmwareChecksumNeq** | **String**| neq filter for the \&quot;firmware_checksum\&quot; field | [optional]
 **firmwareChecksumIn** | **String**| in filter for the \&quot;firmware_checksum\&quot; field | [optional]
 **firmwareChecksumNin** | **String**| nin filter for the \&quot;firmware_checksum\&quot; field | [optional]
 **hostGatewayEq** | **String**| eq filter for the \&quot;host_gateway\&quot; field | [optional]
 **hostGatewayNeq** | **String**| neq filter for the \&quot;host_gateway\&quot; field | [optional]
 **hostGatewayIn** | **String**| in filter for the \&quot;host_gateway\&quot; field | [optional]
 **hostGatewayNin** | **String**| nin filter for the \&quot;host_gateway\&quot; field | [optional]
 **idEq** | **String**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **String**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **manifestEq** | **String**| eq filter for the \&quot;manifest\&quot; field | [optional]
 **manifestNeq** | **String**| neq filter for the \&quot;manifest\&quot; field | [optional]
 **manifestIn** | **String**| in filter for the \&quot;manifest\&quot; field | [optional]
 **manifestNin** | **String**| nin filter for the \&quot;manifest\&quot; field | [optional]
 **manifestTimestampIn** | **String**| in filter for the \&quot;manifest_timestamp\&quot; field | [optional]
 **manifestTimestampNin** | **String**| nin filter for the \&quot;manifest_timestamp\&quot; field | [optional]
 **manifestTimestampLte** | **DateTime**| lte filter for the \&quot;manifest_timestamp\&quot; field | [optional]
 **manifestTimestampGte** | **DateTime**| gte filter for the \&quot;manifest_timestamp\&quot; field | [optional]
 **mechanismEq** | **String**| eq filter for the \&quot;mechanism\&quot; field | [optional]
 **mechanismNeq** | **String**| neq filter for the \&quot;mechanism\&quot; field | [optional]
 **mechanismIn** | **String**| in filter for the \&quot;mechanism\&quot; field | [optional]
 **mechanismNin** | **String**| nin filter for the \&quot;mechanism\&quot; field | [optional]
 **mechanismUrlEq** | **String**| eq filter for the \&quot;mechanism_url\&quot; field | [optional]
 **mechanismUrlNeq** | **String**| neq filter for the \&quot;mechanism_url\&quot; field | [optional]
 **mechanismUrlIn** | **String**| in filter for the \&quot;mechanism_url\&quot; field | [optional]
 **mechanismUrlNin** | **String**| nin filter for the \&quot;mechanism_url\&quot; field | [optional]
 **nameEq** | **String**| eq filter for the \&quot;name\&quot; field | [optional]
 **nameNeq** | **String**| neq filter for the \&quot;name\&quot; field | [optional]
 **nameIn** | **String**| in filter for the \&quot;name\&quot; field | [optional]
 **nameNin** | **String**| nin filter for the \&quot;name\&quot; field | [optional]
 **netIdEq** | **String**| eq filter for the \&quot;net_id\&quot; field | [optional]
 **netIdNeq** | **String**| neq filter for the \&quot;net_id\&quot; field | [optional]
 **netIdIn** | **String**| in filter for the \&quot;net_id\&quot; field | [optional]
 **netIdNin** | **String**| nin filter for the \&quot;net_id\&quot; field | [optional]
 **serialNumberEq** | **String**| eq filter for the \&quot;serial_number\&quot; field | [optional]
 **serialNumberNeq** | **String**| neq filter for the \&quot;serial_number\&quot; field | [optional]
 **serialNumberIn** | **String**| in filter for the \&quot;serial_number\&quot; field | [optional]
 **serialNumberNin** | **String**| nin filter for the \&quot;serial_number\&quot; field | [optional]
 **stateEq** | **String**| eq filter for the \&quot;state\&quot; field | [optional]
 **stateNeq** | **String**| neq filter for the \&quot;state\&quot; field | [optional]
 **stateIn** | **String**| in filter for the \&quot;state\&quot; field | [optional]
 **stateNin** | **String**| nin filter for the \&quot;state\&quot; field | [optional]
 **updatedAtIn** | **String**| in filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtNin** | **String**| nin filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtLte** | **DateTime**| lte filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtGte** | **DateTime**| gte filter for the \&quot;updated_at\&quot; field | [optional]
 **vendorIdEq** | **String**| eq filter for the \&quot;vendor_id\&quot; field | [optional]
 **vendorIdNeq** | **String**| neq filter for the \&quot;vendor_id\&quot; field | [optional]
 **vendorIdIn** | **String**| in filter for the \&quot;vendor_id\&quot; field | [optional]
 **vendorIdNin** | **String**| nin filter for the \&quot;vendor_id\&quot; field | [optional]

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

Returns [DeviceGroup](https://developer.pelion.com/docs/device-management-api/device-directory/) info what contains info of the group, for example, name and updated date. To list the devices in the group, use &#39;/v3/device-groups/{device-group-id}/devices/&#39;.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryGroupsApi apiInstance = new DeviceDirectoryGroupsApi();
String deviceGroupId = "deviceGroupId_example"; // String | The group ID
try {
    DeviceGroup result = apiInstance.groupRetrieve(deviceGroupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryGroupsApi#groupRetrieve");
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

Modify the attributes of a group, such as the description.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDirectoryGroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDirectoryGroupsApi apiInstance = new DeviceDirectoryGroupsApi();
String deviceGroupId = "deviceGroupId_example"; // String | 
Group1 group = new Group1(); // Group1 | Group
try {
    DeviceGroup result = apiInstance.groupUpdate(deviceGroupId, group);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDirectoryGroupsApi#groupUpdate");
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

