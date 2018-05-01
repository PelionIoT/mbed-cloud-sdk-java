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
> DeviceEventPage deviceEventList(limit, order, after, dateTimeEq, dateTimeNeq, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin, include)

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
String dateTimeEq = "dateTimeEq_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeNeq = "dateTimeNeq_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeIn = "dateTimeIn_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeNin = "dateTimeNin_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeLte = "dateTimeLte_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeGte = "dateTimeGte_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String descriptionEq = "descriptionEq_example"; // String | Filter for description
String descriptionNeq = "descriptionNeq_example"; // String | Filter for description
String descriptionIn = "descriptionIn_example"; // String | Filter for description
String descriptionNin = "descriptionNin_example"; // String | Filter for description
String idEq = "idEq_example"; // String | Filter for id
String idNeq = "idNeq_example"; // String | Filter for id
String idIn = "idIn_example"; // String | Filter for id
String idNin = "idNin_example"; // String | Filter for id
String deviceIdEq = "deviceIdEq_example"; // String | Filter for device_id
String deviceIdNeq = "deviceIdNeq_example"; // String | Filter for device_id
String deviceIdIn = "deviceIdIn_example"; // String | Filter for device_id
String deviceIdNin = "deviceIdNin_example"; // String | Filter for device_id
String eventTypeEq = "eventTypeEq_example"; // String | Filter for event_type
String eventTypeNeq = "eventTypeNeq_example"; // String | Filter for event_type
String eventTypeIn = "eventTypeIn_example"; // String | Filter for event_type
String eventTypeNin = "eventTypeNin_example"; // String | Filter for event_type
String stateChangeEq = "stateChangeEq_example"; // String | Filter for state_change
String stateChangeNeq = "stateChangeNeq_example"; // String | Filter for state_change
String stateChangeIn = "stateChangeIn_example"; // String | Filter for state_change
String stateChangeNin = "stateChangeNin_example"; // String | Filter for state_change
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`
try {
    DeviceEventPage result = apiInstance.deviceEventList(limit, order, after, dateTimeEq, dateTimeNeq, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin, include);
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
 **dateTimeEq** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeNeq** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeIn** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeNin** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeLte** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeGte** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **descriptionEq** | **String**| Filter for description | [optional]
 **descriptionNeq** | **String**| Filter for description | [optional]
 **descriptionIn** | **String**| Filter for description | [optional]
 **descriptionNin** | **String**| Filter for description | [optional]
 **idEq** | **String**| Filter for id | [optional]
 **idNeq** | **String**| Filter for id | [optional]
 **idIn** | **String**| Filter for id | [optional]
 **idNin** | **String**| Filter for id | [optional]
 **deviceIdEq** | **String**| Filter for device_id | [optional]
 **deviceIdNeq** | **String**| Filter for device_id | [optional]
 **deviceIdIn** | **String**| Filter for device_id | [optional]
 **deviceIdNin** | **String**| Filter for device_id | [optional]
 **eventTypeEq** | **String**| Filter for event_type | [optional]
 **eventTypeNeq** | **String**| Filter for event_type | [optional]
 **eventTypeIn** | **String**| Filter for event_type | [optional]
 **eventTypeNin** | **String**| Filter for event_type | [optional]
 **stateChangeEq** | **String**| Filter for state_change | [optional]
 **stateChangeNeq** | **String**| Filter for state_change | [optional]
 **stateChangeIn** | **String**| Filter for state_change | [optional]
 **stateChangeNin** | **String**| Filter for state_change | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60; | [optional]

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
> DevicePage deviceList(limit, order, after, accountIdEq, accountIdNeq, accountIdIn, accountIdNin, autoUpdateEq, autoUpdateNeq, autoUpdateIn, autoUpdateNin, bootstrapExpirationDateEq, bootstrapExpirationDateNeq, bootstrapExpirationDateIn, bootstrapExpirationDateNin, bootstrapExpirationDateLte, bootstrapExpirationDateGte, bootstrappedTimestampEq, bootstrappedTimestampNeq, bootstrappedTimestampIn, bootstrappedTimestampNin, bootstrappedTimestampLte, bootstrappedTimestampGte, caIdEq, caIdNeq, caIdIn, caIdNin, connectorExpirationDateEq, connectorExpirationDateNeq, connectorExpirationDateIn, connectorExpirationDateNin, connectorExpirationDateLte, connectorExpirationDateGte, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, customAttributesEq, customAttributesNeq, customAttributesIn, customAttributesNin, deployedStateEq, deployedStateNeq, deployedStateIn, deployedStateNin, deploymentEq, deploymentNeq, deploymentIn, deploymentNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, deviceExecutionModeEq, deviceExecutionModeNeq, deviceExecutionModeIn, deviceExecutionModeNin, deviceKeyEq, deviceKeyNeq, deviceKeyIn, deviceKeyNin, endpointNameEq, endpointNameNeq, endpointNameIn, endpointNameNin, endpointTypeEq, endpointTypeNeq, endpointTypeIn, endpointTypeNin, enrolmentListTimestampEq, enrolmentListTimestampNeq, enrolmentListTimestampIn, enrolmentListTimestampNin, enrolmentListTimestampLte, enrolmentListTimestampGte, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, firmwareChecksumEq, firmwareChecksumNeq, firmwareChecksumIn, firmwareChecksumNin, hostGatewayEq, hostGatewayNeq, hostGatewayIn, hostGatewayNin, idEq, idNeq, idIn, idNin, manifestEq, manifestNeq, manifestIn, manifestNin, manifestTimestampEq, manifestTimestampNeq, manifestTimestampIn, manifestTimestampNin, manifestTimestampLte, manifestTimestampGte, mechanismEq, mechanismNeq, mechanismIn, mechanismNin, mechanismUrlEq, mechanismUrlNeq, mechanismUrlIn, mechanismUrlNin, nameEq, nameNeq, nameIn, nameNin, serialNumberEq, serialNumberNeq, serialNumberIn, serialNumberNin, stateEq, stateNeq, stateIn, stateNin, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, vendorIdEq, vendorIdNeq, vendorIdIn, vendorIdNin, include)

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
String accountIdEq = "accountIdEq_example"; // String | Filter for account_id
String accountIdNeq = "accountIdNeq_example"; // String | Filter for account_id
String accountIdIn = "accountIdIn_example"; // String | Filter for account_id
String accountIdNin = "accountIdNin_example"; // String | Filter for account_id
String autoUpdateEq = "autoUpdateEq_example"; // String | Filter for auto_update
String autoUpdateNeq = "autoUpdateNeq_example"; // String | Filter for auto_update
String autoUpdateIn = "autoUpdateIn_example"; // String | Filter for auto_update
String autoUpdateNin = "autoUpdateNin_example"; // String | Filter for auto_update
String bootstrapExpirationDateEq = "bootstrapExpirationDateEq_example"; // String | Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrapExpirationDateNeq = "bootstrapExpirationDateNeq_example"; // String | Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrapExpirationDateIn = "bootstrapExpirationDateIn_example"; // String | Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrapExpirationDateNin = "bootstrapExpirationDateNin_example"; // String | Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrapExpirationDateLte = "bootstrapExpirationDateLte_example"; // String | Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrapExpirationDateGte = "bootstrapExpirationDateGte_example"; // String | Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrappedTimestampEq = "bootstrappedTimestampEq_example"; // String | Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrappedTimestampNeq = "bootstrappedTimestampNeq_example"; // String | Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrappedTimestampIn = "bootstrappedTimestampIn_example"; // String | Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrappedTimestampNin = "bootstrappedTimestampNin_example"; // String | Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrappedTimestampLte = "bootstrappedTimestampLte_example"; // String | Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String bootstrappedTimestampGte = "bootstrappedTimestampGte_example"; // String | Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String caIdEq = "caIdEq_example"; // String | Filter for ca_id
String caIdNeq = "caIdNeq_example"; // String | Filter for ca_id
String caIdIn = "caIdIn_example"; // String | Filter for ca_id
String caIdNin = "caIdNin_example"; // String | Filter for ca_id
String connectorExpirationDateEq = "connectorExpirationDateEq_example"; // String | Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String connectorExpirationDateNeq = "connectorExpirationDateNeq_example"; // String | Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String connectorExpirationDateIn = "connectorExpirationDateIn_example"; // String | Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String connectorExpirationDateNin = "connectorExpirationDateNin_example"; // String | Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String connectorExpirationDateLte = "connectorExpirationDateLte_example"; // String | Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String connectorExpirationDateGte = "connectorExpirationDateGte_example"; // String | Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtEq = "createdAtEq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNeq = "createdAtNeq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtIn = "createdAtIn_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNin = "createdAtNin_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtLte = "createdAtLte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtGte = "createdAtGte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String customAttributesEq = "customAttributesEq_example"; // String | Filter for custom_attributes
String customAttributesNeq = "customAttributesNeq_example"; // String | Filter for custom_attributes
String customAttributesIn = "customAttributesIn_example"; // String | Filter for custom_attributes
String customAttributesNin = "customAttributesNin_example"; // String | Filter for custom_attributes
String deployedStateEq = "deployedStateEq_example"; // String | Filter for deployed_state
String deployedStateNeq = "deployedStateNeq_example"; // String | Filter for deployed_state
String deployedStateIn = "deployedStateIn_example"; // String | Filter for deployed_state
String deployedStateNin = "deployedStateNin_example"; // String | Filter for deployed_state
String deploymentEq = "deploymentEq_example"; // String | Filter for deployment
String deploymentNeq = "deploymentNeq_example"; // String | Filter for deployment
String deploymentIn = "deploymentIn_example"; // String | Filter for deployment
String deploymentNin = "deploymentNin_example"; // String | Filter for deployment
String descriptionEq = "descriptionEq_example"; // String | Filter for description
String descriptionNeq = "descriptionNeq_example"; // String | Filter for description
String descriptionIn = "descriptionIn_example"; // String | Filter for description
String descriptionNin = "descriptionNin_example"; // String | Filter for description
String deviceClassEq = "deviceClassEq_example"; // String | Filter for device_class
String deviceClassNeq = "deviceClassNeq_example"; // String | Filter for device_class
String deviceClassIn = "deviceClassIn_example"; // String | Filter for device_class
String deviceClassNin = "deviceClassNin_example"; // String | Filter for device_class
String deviceExecutionModeEq = "deviceExecutionModeEq_example"; // String | Filter for device_execution_mode
String deviceExecutionModeNeq = "deviceExecutionModeNeq_example"; // String | Filter for device_execution_mode
String deviceExecutionModeIn = "deviceExecutionModeIn_example"; // String | Filter for device_execution_mode
String deviceExecutionModeNin = "deviceExecutionModeNin_example"; // String | Filter for device_execution_mode
String deviceKeyEq = "deviceKeyEq_example"; // String | Filter for device_key
String deviceKeyNeq = "deviceKeyNeq_example"; // String | Filter for device_key
String deviceKeyIn = "deviceKeyIn_example"; // String | Filter for device_key
String deviceKeyNin = "deviceKeyNin_example"; // String | Filter for device_key
String endpointNameEq = "endpointNameEq_example"; // String | Filter for endpoint_name
String endpointNameNeq = "endpointNameNeq_example"; // String | Filter for endpoint_name
String endpointNameIn = "endpointNameIn_example"; // String | Filter for endpoint_name
String endpointNameNin = "endpointNameNin_example"; // String | Filter for endpoint_name
String endpointTypeEq = "endpointTypeEq_example"; // String | Filter for endpoint_type
String endpointTypeNeq = "endpointTypeNeq_example"; // String | Filter for endpoint_type
String endpointTypeIn = "endpointTypeIn_example"; // String | Filter for endpoint_type
String endpointTypeNin = "endpointTypeNin_example"; // String | Filter for endpoint_type
String enrolmentListTimestampEq = "enrolmentListTimestampEq_example"; // String | Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String enrolmentListTimestampNeq = "enrolmentListTimestampNeq_example"; // String | Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String enrolmentListTimestampIn = "enrolmentListTimestampIn_example"; // String | Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String enrolmentListTimestampNin = "enrolmentListTimestampNin_example"; // String | Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String enrolmentListTimestampLte = "enrolmentListTimestampLte_example"; // String | Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String enrolmentListTimestampGte = "enrolmentListTimestampGte_example"; // String | Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String etagEq = "etagEq_example"; // String | Filter for etag
String etagNeq = "etagNeq_example"; // String | Filter for etag
String etagIn = "etagIn_example"; // String | Filter for etag
String etagNin = "etagNin_example"; // String | Filter for etag
String etagLte = "etagLte_example"; // String | Filter for etag
String etagGte = "etagGte_example"; // String | Filter for etag
String firmwareChecksumEq = "firmwareChecksumEq_example"; // String | Filter for firmware_checksum
String firmwareChecksumNeq = "firmwareChecksumNeq_example"; // String | Filter for firmware_checksum
String firmwareChecksumIn = "firmwareChecksumIn_example"; // String | Filter for firmware_checksum
String firmwareChecksumNin = "firmwareChecksumNin_example"; // String | Filter for firmware_checksum
String hostGatewayEq = "hostGatewayEq_example"; // String | Filter for host_gateway
String hostGatewayNeq = "hostGatewayNeq_example"; // String | Filter for host_gateway
String hostGatewayIn = "hostGatewayIn_example"; // String | Filter for host_gateway
String hostGatewayNin = "hostGatewayNin_example"; // String | Filter for host_gateway
String idEq = "idEq_example"; // String | Filter for id
String idNeq = "idNeq_example"; // String | Filter for id
String idIn = "idIn_example"; // String | Filter for id
String idNin = "idNin_example"; // String | Filter for id
String manifestEq = "manifestEq_example"; // String | Filter for manifest
String manifestNeq = "manifestNeq_example"; // String | Filter for manifest
String manifestIn = "manifestIn_example"; // String | Filter for manifest
String manifestNin = "manifestNin_example"; // String | Filter for manifest
String manifestTimestampEq = "manifestTimestampEq_example"; // String | Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String manifestTimestampNeq = "manifestTimestampNeq_example"; // String | Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String manifestTimestampIn = "manifestTimestampIn_example"; // String | Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String manifestTimestampNin = "manifestTimestampNin_example"; // String | Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String manifestTimestampLte = "manifestTimestampLte_example"; // String | Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String manifestTimestampGte = "manifestTimestampGte_example"; // String | Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String mechanismEq = "mechanismEq_example"; // String | Filter for mechanism
String mechanismNeq = "mechanismNeq_example"; // String | Filter for mechanism
String mechanismIn = "mechanismIn_example"; // String | Filter for mechanism
String mechanismNin = "mechanismNin_example"; // String | Filter for mechanism
String mechanismUrlEq = "mechanismUrlEq_example"; // String | Filter for mechanism_url
String mechanismUrlNeq = "mechanismUrlNeq_example"; // String | Filter for mechanism_url
String mechanismUrlIn = "mechanismUrlIn_example"; // String | Filter for mechanism_url
String mechanismUrlNin = "mechanismUrlNin_example"; // String | Filter for mechanism_url
String nameEq = "nameEq_example"; // String | Filter for name
String nameNeq = "nameNeq_example"; // String | Filter for name
String nameIn = "nameIn_example"; // String | Filter for name
String nameNin = "nameNin_example"; // String | Filter for name
String serialNumberEq = "serialNumberEq_example"; // String | Filter for serial_number
String serialNumberNeq = "serialNumberNeq_example"; // String | Filter for serial_number
String serialNumberIn = "serialNumberIn_example"; // String | Filter for serial_number
String serialNumberNin = "serialNumberNin_example"; // String | Filter for serial_number
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
String vendorIdEq = "vendorIdEq_example"; // String | Filter for vendor_id
String vendorIdNeq = "vendorIdNeq_example"; // String | Filter for vendor_id
String vendorIdIn = "vendorIdIn_example"; // String | Filter for vendor_id
String vendorIdNin = "vendorIdNin_example"; // String | Filter for vendor_id
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
try {
    DevicePage result = apiInstance.deviceList(limit, order, after, accountIdEq, accountIdNeq, accountIdIn, accountIdNin, autoUpdateEq, autoUpdateNeq, autoUpdateIn, autoUpdateNin, bootstrapExpirationDateEq, bootstrapExpirationDateNeq, bootstrapExpirationDateIn, bootstrapExpirationDateNin, bootstrapExpirationDateLte, bootstrapExpirationDateGte, bootstrappedTimestampEq, bootstrappedTimestampNeq, bootstrappedTimestampIn, bootstrappedTimestampNin, bootstrappedTimestampLte, bootstrappedTimestampGte, caIdEq, caIdNeq, caIdIn, caIdNin, connectorExpirationDateEq, connectorExpirationDateNeq, connectorExpirationDateIn, connectorExpirationDateNin, connectorExpirationDateLte, connectorExpirationDateGte, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, customAttributesEq, customAttributesNeq, customAttributesIn, customAttributesNin, deployedStateEq, deployedStateNeq, deployedStateIn, deployedStateNin, deploymentEq, deploymentNeq, deploymentIn, deploymentNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, deviceExecutionModeEq, deviceExecutionModeNeq, deviceExecutionModeIn, deviceExecutionModeNin, deviceKeyEq, deviceKeyNeq, deviceKeyIn, deviceKeyNin, endpointNameEq, endpointNameNeq, endpointNameIn, endpointNameNin, endpointTypeEq, endpointTypeNeq, endpointTypeIn, endpointTypeNin, enrolmentListTimestampEq, enrolmentListTimestampNeq, enrolmentListTimestampIn, enrolmentListTimestampNin, enrolmentListTimestampLte, enrolmentListTimestampGte, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, firmwareChecksumEq, firmwareChecksumNeq, firmwareChecksumIn, firmwareChecksumNin, hostGatewayEq, hostGatewayNeq, hostGatewayIn, hostGatewayNin, idEq, idNeq, idIn, idNin, manifestEq, manifestNeq, manifestIn, manifestNin, manifestTimestampEq, manifestTimestampNeq, manifestTimestampIn, manifestTimestampNin, manifestTimestampLte, manifestTimestampGte, mechanismEq, mechanismNeq, mechanismIn, mechanismNin, mechanismUrlEq, mechanismUrlNeq, mechanismUrlIn, mechanismUrlNin, nameEq, nameNeq, nameIn, nameNin, serialNumberEq, serialNumberNeq, serialNumberIn, serialNumberNin, stateEq, stateNeq, stateIn, stateNin, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, vendorIdEq, vendorIdNeq, vendorIdIn, vendorIdNin, include);
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
 **accountIdEq** | **String**| Filter for account_id | [optional]
 **accountIdNeq** | **String**| Filter for account_id | [optional]
 **accountIdIn** | **String**| Filter for account_id | [optional]
 **accountIdNin** | **String**| Filter for account_id | [optional]
 **autoUpdateEq** | **String**| Filter for auto_update | [optional]
 **autoUpdateNeq** | **String**| Filter for auto_update | [optional]
 **autoUpdateIn** | **String**| Filter for auto_update | [optional]
 **autoUpdateNin** | **String**| Filter for auto_update | [optional]
 **bootstrapExpirationDateEq** | **String**| Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrapExpirationDateNeq** | **String**| Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrapExpirationDateIn** | **String**| Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrapExpirationDateNin** | **String**| Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrapExpirationDateLte** | **String**| Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrapExpirationDateGte** | **String**| Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrappedTimestampEq** | **String**| Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrappedTimestampNeq** | **String**| Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrappedTimestampIn** | **String**| Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrappedTimestampNin** | **String**| Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrappedTimestampLte** | **String**| Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **bootstrappedTimestampGte** | **String**| Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **caIdEq** | **String**| Filter for ca_id | [optional]
 **caIdNeq** | **String**| Filter for ca_id | [optional]
 **caIdIn** | **String**| Filter for ca_id | [optional]
 **caIdNin** | **String**| Filter for ca_id | [optional]
 **connectorExpirationDateEq** | **String**| Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **connectorExpirationDateNeq** | **String**| Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **connectorExpirationDateIn** | **String**| Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **connectorExpirationDateNin** | **String**| Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **connectorExpirationDateLte** | **String**| Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **connectorExpirationDateGte** | **String**| Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtEq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNeq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtIn** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNin** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtLte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtGte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **customAttributesEq** | **String**| Filter for custom_attributes | [optional]
 **customAttributesNeq** | **String**| Filter for custom_attributes | [optional]
 **customAttributesIn** | **String**| Filter for custom_attributes | [optional]
 **customAttributesNin** | **String**| Filter for custom_attributes | [optional]
 **deployedStateEq** | **String**| Filter for deployed_state | [optional]
 **deployedStateNeq** | **String**| Filter for deployed_state | [optional]
 **deployedStateIn** | **String**| Filter for deployed_state | [optional]
 **deployedStateNin** | **String**| Filter for deployed_state | [optional]
 **deploymentEq** | **String**| Filter for deployment | [optional]
 **deploymentNeq** | **String**| Filter for deployment | [optional]
 **deploymentIn** | **String**| Filter for deployment | [optional]
 **deploymentNin** | **String**| Filter for deployment | [optional]
 **descriptionEq** | **String**| Filter for description | [optional]
 **descriptionNeq** | **String**| Filter for description | [optional]
 **descriptionIn** | **String**| Filter for description | [optional]
 **descriptionNin** | **String**| Filter for description | [optional]
 **deviceClassEq** | **String**| Filter for device_class | [optional]
 **deviceClassNeq** | **String**| Filter for device_class | [optional]
 **deviceClassIn** | **String**| Filter for device_class | [optional]
 **deviceClassNin** | **String**| Filter for device_class | [optional]
 **deviceExecutionModeEq** | **String**| Filter for device_execution_mode | [optional]
 **deviceExecutionModeNeq** | **String**| Filter for device_execution_mode | [optional]
 **deviceExecutionModeIn** | **String**| Filter for device_execution_mode | [optional]
 **deviceExecutionModeNin** | **String**| Filter for device_execution_mode | [optional]
 **deviceKeyEq** | **String**| Filter for device_key | [optional]
 **deviceKeyNeq** | **String**| Filter for device_key | [optional]
 **deviceKeyIn** | **String**| Filter for device_key | [optional]
 **deviceKeyNin** | **String**| Filter for device_key | [optional]
 **endpointNameEq** | **String**| Filter for endpoint_name | [optional]
 **endpointNameNeq** | **String**| Filter for endpoint_name | [optional]
 **endpointNameIn** | **String**| Filter for endpoint_name | [optional]
 **endpointNameNin** | **String**| Filter for endpoint_name | [optional]
 **endpointTypeEq** | **String**| Filter for endpoint_type | [optional]
 **endpointTypeNeq** | **String**| Filter for endpoint_type | [optional]
 **endpointTypeIn** | **String**| Filter for endpoint_type | [optional]
 **endpointTypeNin** | **String**| Filter for endpoint_type | [optional]
 **enrolmentListTimestampEq** | **String**| Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **enrolmentListTimestampNeq** | **String**| Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **enrolmentListTimestampIn** | **String**| Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **enrolmentListTimestampNin** | **String**| Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **enrolmentListTimestampLte** | **String**| Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **enrolmentListTimestampGte** | **String**| Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **etagEq** | **String**| Filter for etag | [optional]
 **etagNeq** | **String**| Filter for etag | [optional]
 **etagIn** | **String**| Filter for etag | [optional]
 **etagNin** | **String**| Filter for etag | [optional]
 **etagLte** | **String**| Filter for etag | [optional]
 **etagGte** | **String**| Filter for etag | [optional]
 **firmwareChecksumEq** | **String**| Filter for firmware_checksum | [optional]
 **firmwareChecksumNeq** | **String**| Filter for firmware_checksum | [optional]
 **firmwareChecksumIn** | **String**| Filter for firmware_checksum | [optional]
 **firmwareChecksumNin** | **String**| Filter for firmware_checksum | [optional]
 **hostGatewayEq** | **String**| Filter for host_gateway | [optional]
 **hostGatewayNeq** | **String**| Filter for host_gateway | [optional]
 **hostGatewayIn** | **String**| Filter for host_gateway | [optional]
 **hostGatewayNin** | **String**| Filter for host_gateway | [optional]
 **idEq** | **String**| Filter for id | [optional]
 **idNeq** | **String**| Filter for id | [optional]
 **idIn** | **String**| Filter for id | [optional]
 **idNin** | **String**| Filter for id | [optional]
 **manifestEq** | **String**| Filter for manifest | [optional]
 **manifestNeq** | **String**| Filter for manifest | [optional]
 **manifestIn** | **String**| Filter for manifest | [optional]
 **manifestNin** | **String**| Filter for manifest | [optional]
 **manifestTimestampEq** | **String**| Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **manifestTimestampNeq** | **String**| Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **manifestTimestampIn** | **String**| Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **manifestTimestampNin** | **String**| Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **manifestTimestampLte** | **String**| Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **manifestTimestampGte** | **String**| Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **mechanismEq** | **String**| Filter for mechanism | [optional]
 **mechanismNeq** | **String**| Filter for mechanism | [optional]
 **mechanismIn** | **String**| Filter for mechanism | [optional]
 **mechanismNin** | **String**| Filter for mechanism | [optional]
 **mechanismUrlEq** | **String**| Filter for mechanism_url | [optional]
 **mechanismUrlNeq** | **String**| Filter for mechanism_url | [optional]
 **mechanismUrlIn** | **String**| Filter for mechanism_url | [optional]
 **mechanismUrlNin** | **String**| Filter for mechanism_url | [optional]
 **nameEq** | **String**| Filter for name | [optional]
 **nameNeq** | **String**| Filter for name | [optional]
 **nameIn** | **String**| Filter for name | [optional]
 **nameNin** | **String**| Filter for name | [optional]
 **serialNumberEq** | **String**| Filter for serial_number | [optional]
 **serialNumberNeq** | **String**| Filter for serial_number | [optional]
 **serialNumberIn** | **String**| Filter for serial_number | [optional]
 **serialNumberNin** | **String**| Filter for serial_number | [optional]
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
 **vendorIdEq** | **String**| Filter for vendor_id | [optional]
 **vendorIdNeq** | **String**| Filter for vendor_id | [optional]
 **vendorIdIn** | **String**| Filter for vendor_id | [optional]
 **vendorIdNin** | **String**| Filter for vendor_id | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]

### Return type

[**DevicePage**](DevicePage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceLogList"></a>
# **deviceLogList**
> DeviceEventPage deviceLogList(limit, order, after, dateTimeEq, dateTimeNeq, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin, include)

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
String dateTimeEq = "dateTimeEq_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeNeq = "dateTimeNeq_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeIn = "dateTimeIn_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeNin = "dateTimeNin_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeLte = "dateTimeLte_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String dateTimeGte = "dateTimeGte_example"; // String | Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String descriptionEq = "descriptionEq_example"; // String | Filter for description
String descriptionNeq = "descriptionNeq_example"; // String | Filter for description
String descriptionIn = "descriptionIn_example"; // String | Filter for description
String descriptionNin = "descriptionNin_example"; // String | Filter for description
String idEq = "idEq_example"; // String | Filter for id
String idNeq = "idNeq_example"; // String | Filter for id
String idIn = "idIn_example"; // String | Filter for id
String idNin = "idNin_example"; // String | Filter for id
String deviceIdEq = "deviceIdEq_example"; // String | Filter for device_id
String deviceIdNeq = "deviceIdNeq_example"; // String | Filter for device_id
String deviceIdIn = "deviceIdIn_example"; // String | Filter for device_id
String deviceIdNin = "deviceIdNin_example"; // String | Filter for device_id
String eventTypeEq = "eventTypeEq_example"; // String | Filter for event_type
String eventTypeNeq = "eventTypeNeq_example"; // String | Filter for event_type
String eventTypeIn = "eventTypeIn_example"; // String | Filter for event_type
String eventTypeNin = "eventTypeNin_example"; // String | Filter for event_type
String stateChangeEq = "stateChangeEq_example"; // String | Filter for state_change
String stateChangeNeq = "stateChangeNeq_example"; // String | Filter for state_change
String stateChangeIn = "stateChangeIn_example"; // String | Filter for state_change
String stateChangeNin = "stateChangeNin_example"; // String | Filter for state_change
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
try {
    DeviceEventPage result = apiInstance.deviceLogList(limit, order, after, dateTimeEq, dateTimeNeq, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin, include);
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
 **dateTimeEq** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeNeq** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeIn** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeNin** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeLte** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **dateTimeGte** | **String**| Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **descriptionEq** | **String**| Filter for description | [optional]
 **descriptionNeq** | **String**| Filter for description | [optional]
 **descriptionIn** | **String**| Filter for description | [optional]
 **descriptionNin** | **String**| Filter for description | [optional]
 **idEq** | **String**| Filter for id | [optional]
 **idNeq** | **String**| Filter for id | [optional]
 **idIn** | **String**| Filter for id | [optional]
 **idNin** | **String**| Filter for id | [optional]
 **deviceIdEq** | **String**| Filter for device_id | [optional]
 **deviceIdNeq** | **String**| Filter for device_id | [optional]
 **deviceIdIn** | **String**| Filter for device_id | [optional]
 **deviceIdNin** | **String**| Filter for device_id | [optional]
 **eventTypeEq** | **String**| Filter for event_type | [optional]
 **eventTypeNeq** | **String**| Filter for event_type | [optional]
 **eventTypeIn** | **String**| Filter for event_type | [optional]
 **eventTypeNin** | **String**| Filter for event_type | [optional]
 **stateChangeEq** | **String**| Filter for state_change | [optional]
 **stateChangeNeq** | **String**| Filter for state_change | [optional]
 **stateChangeIn** | **String**| Filter for state_change | [optional]
 **stateChangeNin** | **String**| Filter for state_change | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]

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
> DeviceQueryPage deviceQueryList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, idLte, idGte, nameEq, nameNeq, nameIn, nameNin, nameLte, nameGte, queryEq, queryNeq, queryIn, queryNin, queryLte, queryGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include)

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
String createdAtEq = "createdAtEq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNeq = "createdAtNeq_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtIn = "createdAtIn_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtNin = "createdAtNin_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtLte = "createdAtLte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String createdAtGte = "createdAtGte_example"; // String | Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
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
String idLte = "idLte_example"; // String | Filter for id
String idGte = "idGte_example"; // String | Filter for id
String nameEq = "nameEq_example"; // String | Filter for name
String nameNeq = "nameNeq_example"; // String | Filter for name
String nameIn = "nameIn_example"; // String | Filter for name
String nameNin = "nameNin_example"; // String | Filter for name
String nameLte = "nameLte_example"; // String | Filter for name
String nameGte = "nameGte_example"; // String | Filter for name
String queryEq = "queryEq_example"; // String | Filter for query
String queryNeq = "queryNeq_example"; // String | Filter for query
String queryIn = "queryIn_example"; // String | Filter for query
String queryNin = "queryNin_example"; // String | Filter for query
String queryLte = "queryLte_example"; // String | Filter for query
String queryGte = "queryGte_example"; // String | Filter for query
String updatedAtEq = "updatedAtEq_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtNeq = "updatedAtNeq_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtIn = "updatedAtIn_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtNin = "updatedAtNin_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtLte = "updatedAtLte_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String updatedAtGte = "updatedAtGte_example"; // String | Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
try {
    DeviceQueryPage result = apiInstance.deviceQueryList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, idLte, idGte, nameEq, nameNeq, nameIn, nameNin, nameLte, nameGte, queryEq, queryNeq, queryIn, queryNin, queryLte, queryGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include);
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
 **createdAtEq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNeq** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtIn** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtNin** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtLte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **createdAtGte** | **String**| Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
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
 **idLte** | **String**| Filter for id | [optional]
 **idGte** | **String**| Filter for id | [optional]
 **nameEq** | **String**| Filter for name | [optional]
 **nameNeq** | **String**| Filter for name | [optional]
 **nameIn** | **String**| Filter for name | [optional]
 **nameNin** | **String**| Filter for name | [optional]
 **nameLte** | **String**| Filter for name | [optional]
 **nameGte** | **String**| Filter for name | [optional]
 **queryEq** | **String**| Filter for query | [optional]
 **queryNeq** | **String**| Filter for query | [optional]
 **queryIn** | **String**| Filter for query | [optional]
 **queryNin** | **String**| Filter for query | [optional]
 **queryLte** | **String**| Filter for query | [optional]
 **queryGte** | **String**| Filter for query | [optional]
 **updatedAtEq** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtNeq** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtIn** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtNin** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtLte** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **updatedAtGte** | **String**| Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]

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

