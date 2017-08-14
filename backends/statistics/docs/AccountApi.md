# AccountApi

All URIs are relative to *http://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v3MetricsGet**](AccountApi.md#v3MetricsGet) | **GET** v3/metrics | Provides account-specific statistics for other cloud services.


<a name="v3MetricsGet"></a>
# **v3MetricsGet**
> SuccessfulResponse v3MetricsGet(include, interval, authorization, start, end, period, limit, after, order)

Provides account-specific statistics for other cloud services.

This REST API is used to get account-specific statistics.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.statistics.api.AccountApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountApi apiInstance = new AccountApi();
String include = "include_example"; // String | A comma-separated list of requested metrics and total_count ( if included, the response will contain total_count to specify total number of records available). Supported values are:  - `transactions` - `registered_devices` - `bootstraps_successful` - `bootstraps_failed` - `bootstraps_pending` - `handshakes_successful` - `handshakes_failed` - `device_server_rest_api_success` - `device_server_rest_api_error` - `total_count` 
String interval = "interval_example"; // String | Group data by this interval in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The maximum interval cannot exceed more than one year ( 365 days ) and so the allowed ranges are 5m - 525600m / 1h - 8760h / 1d - 365d / 1w - 53w. 
String authorization = "authorization_example"; // String | Bearer {Access Token}. A valid API Gateway access token. The token is validated and the associated account identifier is used to retrieve account-specific statistics. 
String start = "start_example"; // String | UTC time/year/date in RFC3339 format. Fetch the data with timestamp greater than or equal to this value. Sample values: 20170207T092056990Z / 2017-02-07T09:20:56.990Z / 2017 / 20170207. The maximum time between start and end parameters cannot exceed more than one year (365 days). The parameter is not mandatory, if the period is specified. 
String end = "end_example"; // String | UTC time/year/date in RFC3339 format. Fetch the data with timestamp less than this value.Sample values: 20170207T092056990Z / 2017-02-07T09:20:56.990Z / 2017 / 20170207. The maximum time between start and end parameters cannot exceed more than one year ( 365 days ). The parameter is not mandatory, if the period is specified. 
String period = "period_example"; // String | Period. Fetch the data for the period in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The parameter is not mandatory, if the start and end time are specified. The maximum period cannot exceed more than one year ( 365 days ) and so the allowed ranges are 5m - 525600m / 1h - 8760h / 1d - 365d / 1w - 53w. 
Integer limit = 56; // Integer | The number of results to return. Default value is 50, minimum value is 2 and maximum value is 1000. 
String after = "after_example"; // String | The metric ID after which to start fetching. 
String order = "order_example"; // String | The order of the records to return. Available values are ASC and DESC. The default value is ASC. 
try {
    SuccessfulResponse result = apiInstance.v3MetricsGet(include, interval, authorization, start, end, period, limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#v3MetricsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | **String**| A comma-separated list of requested metrics and total_count ( if included, the response will contain total_count to specify total number of records available). Supported values are:  - &#x60;transactions&#x60; - &#x60;registered_devices&#x60; - &#x60;bootstraps_successful&#x60; - &#x60;bootstraps_failed&#x60; - &#x60;bootstraps_pending&#x60; - &#x60;handshakes_successful&#x60; - &#x60;handshakes_failed&#x60; - &#x60;device_server_rest_api_success&#x60; - &#x60;device_server_rest_api_error&#x60; - &#x60;total_count&#x60;  |
 **interval** | **String**| Group data by this interval in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The maximum interval cannot exceed more than one year ( 365 days ) and so the allowed ranges are 5m - 525600m / 1h - 8760h / 1d - 365d / 1w - 53w.  |
 **authorization** | **String**| Bearer {Access Token}. A valid API Gateway access token. The token is validated and the associated account identifier is used to retrieve account-specific statistics.  |
 **start** | **String**| UTC time/year/date in RFC3339 format. Fetch the data with timestamp greater than or equal to this value. Sample values: 20170207T092056990Z / 2017-02-07T09:20:56.990Z / 2017 / 20170207. The maximum time between start and end parameters cannot exceed more than one year (365 days). The parameter is not mandatory, if the period is specified.  | [optional]
 **end** | **String**| UTC time/year/date in RFC3339 format. Fetch the data with timestamp less than this value.Sample values: 20170207T092056990Z / 2017-02-07T09:20:56.990Z / 2017 / 20170207. The maximum time between start and end parameters cannot exceed more than one year ( 365 days ). The parameter is not mandatory, if the period is specified.  | [optional]
 **period** | **String**| Period. Fetch the data for the period in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The parameter is not mandatory, if the start and end time are specified. The maximum period cannot exceed more than one year ( 365 days ) and so the allowed ranges are 5m - 525600m / 1h - 8760h / 1d - 365d / 1w - 53w.  | [optional]
 **limit** | **Integer**| The number of results to return. Default value is 50, minimum value is 2 and maximum value is 1000.  | [optional]
 **after** | **String**| The metric ID after which to start fetching.  | [optional]
 **order** | **String**| The order of the records to return. Available values are ASC and DESC. The default value is ASC.  | [optional]

### Return type

[**SuccessfulResponse**](SuccessfulResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

