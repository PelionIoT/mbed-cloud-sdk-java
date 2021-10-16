# GatewayLogsPublicApiApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getDeviceLogBasedOnLogID**](GatewayLogsPublicApiApi.md#getDeviceLogBasedOnLogID) | **GET** v3/device-logs/{device_log_id} | Retrieve a device log by ID.
[**listGatewayDeviceLogs**](GatewayLogsPublicApiApi.md#listGatewayDeviceLogs) | **GET** v3/device-logs | List all device logs based on filters
[**listSingleGatewayDeviceLogs**](GatewayLogsPublicApiApi.md#listSingleGatewayDeviceLogs) | **GET** v3/devices/{device_id}/logs | Return the logs for a specific device.


<a name="getDeviceLogBasedOnLogID"></a>
# **getDeviceLogBasedOnLogID**
> Log getDeviceLogBasedOnLogID(deviceLogId)

Retrieve a device log by ID.

Retrieve a device log from a device by log ID.  **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-logs/(device_log_id) &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.GatewayLogsPublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

GatewayLogsPublicApiApi apiInstance = new GatewayLogsPublicApiApi();
String deviceLogId = "deviceLogId_example"; // String | The ID of the device log.
try {
    Log result = apiInstance.getDeviceLogBasedOnLogID(deviceLogId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GatewayLogsPublicApiApi#getDeviceLogBasedOnLogID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceLogId** | **String**| The ID of the device log. |

### Return type

[**Log**](Log.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listGatewayDeviceLogs"></a>
# **listGatewayDeviceLogs**
> LogsPage listGatewayDeviceLogs(deviceIdIn, limit, after, order, include, timestampLte, timestampGte, appNameEq, typeEq, messageEq, levelGte)

List all device logs based on filters

List logs for all devices based on a combination of filters.  **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-logs &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.GatewayLogsPublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

GatewayLogsPublicApiApi apiInstance = new GatewayLogsPublicApiApi();
String deviceIdIn = "deviceIdIn_example"; // String | The device ID for which to retrieve logs.
Integer limit = 100; // Integer | Limit the number of returned results. The default value is 100.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "DESC"; // String | Record order. Acceptable values: ASC, DESC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count
DateTime timestampLte = new DateTime(); // DateTime | RFC 3339 UTC timestamp range upper limit.
DateTime timestampGte = new DateTime(); // DateTime | RFC 3339 UTC timestamp range lower limit.
String appNameEq = "appNameEq_example"; // String | Name of the application on a device that generated logs.
String typeEq = "typeEq_example"; // String | Device log type filter.
String messageEq = "messageEq_example"; // String | Device log message filter.
String levelGte = "levelGte_example"; // String | Minimum severity level of logs to retrieve.
try {
    LogsPage result = apiInstance.listGatewayDeviceLogs(deviceIdIn, limit, after, order, include, timestampLte, timestampGte, appNameEq, typeEq, messageEq, levelGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GatewayLogsPublicApiApi#listGatewayDeviceLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceIdIn** | **String**| The device ID for which to retrieve logs. | [optional]
 **limit** | **Integer**| Limit the number of returned results. The default value is 100. | [optional] [default to 100]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. | [optional] [default to DESC] [enum: ASC, DESC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count | [optional]
 **timestampLte** | **DateTime**| RFC 3339 UTC timestamp range upper limit. | [optional]
 **timestampGte** | **DateTime**| RFC 3339 UTC timestamp range lower limit. | [optional]
 **appNameEq** | **String**| Name of the application on a device that generated logs. | [optional]
 **typeEq** | **String**| Device log type filter. | [optional]
 **messageEq** | **String**| Device log message filter. | [optional]
 **levelGte** | **String**| Minimum severity level of logs to retrieve. | [optional] [enum: DEBUG, TRACE, INFO, WARNING, ERROR, CRITICAL]

### Return type

[**LogsPage**](LogsPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listSingleGatewayDeviceLogs"></a>
# **listSingleGatewayDeviceLogs**
> LogsPage listSingleGatewayDeviceLogs(deviceId, limit, after, order, include, timestampLte, timestampGte, appNameEq, typeEq, messageEq, levelGte)

Return the logs for a specific device.

Retrieve logs for a given device based on a combination of filters.  **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/devices/{device_id}/logs &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.GatewayLogsPublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

GatewayLogsPublicApiApi apiInstance = new GatewayLogsPublicApiApi();
String deviceId = "deviceId_example"; // String | The id of the device
Integer limit = 100; // Integer | Limit the number of returned results. The default value is 100.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "DESC"; // String | Record order. Acceptable values: ASC, DESC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count
DateTime timestampLte = new DateTime(); // DateTime | RFC 3339 UTC timestamp range upper limit.
DateTime timestampGte = new DateTime(); // DateTime | RFC 3339 UTC timestamp range lower limit.
String appNameEq = "appNameEq_example"; // String | Name of the application on a device that generated logs.
String typeEq = "typeEq_example"; // String | Device log type filter.
String messageEq = "messageEq_example"; // String | Device log message filter.
String levelGte = "levelGte_example"; // String | Minimum severity level of logs to retrieve.
try {
    LogsPage result = apiInstance.listSingleGatewayDeviceLogs(deviceId, limit, after, order, include, timestampLte, timestampGte, appNameEq, typeEq, messageEq, levelGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GatewayLogsPublicApiApi#listSingleGatewayDeviceLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| The id of the device |
 **limit** | **Integer**| Limit the number of returned results. The default value is 100. | [optional] [default to 100]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. | [optional] [default to DESC] [enum: ASC, DESC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count | [optional]
 **timestampLte** | **DateTime**| RFC 3339 UTC timestamp range upper limit. | [optional]
 **timestampGte** | **DateTime**| RFC 3339 UTC timestamp range lower limit. | [optional]
 **appNameEq** | **String**| Name of the application on a device that generated logs. | [optional]
 **typeEq** | **String**| Device log type filter. | [optional]
 **messageEq** | **String**| Device log message filter. | [optional]
 **levelGte** | **String**| Minimum severity level of logs to retrieve. | [optional] [enum: DEBUG, TRACE, INFO, WARNING, ERROR, CRITICAL]

### Return type

[**LogsPage**](LogsPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

