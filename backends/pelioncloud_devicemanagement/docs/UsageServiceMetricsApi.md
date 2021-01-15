# UsageServiceMetricsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMetrics**](UsageServiceMetricsApi.md#getMetrics) | **GET** v3/metrics | Provides account-specific statistics for other cloud services.


<a name="getMetrics"></a>
# **getMetrics**
> SuccessfulResponse getMetrics(include, interval, start, end, period, limit, after, order)

Provides account-specific statistics for other cloud services.

Get account-specific statistics.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UsageServiceMetricsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UsageServiceMetricsApi apiInstance = new UsageServiceMetricsApi();
String include = "include_example"; // String | A comma-separated list of requested metrics and total_count (if included, the response will contain total_count to specify the total number of records available). Supported values are:  - `transactions` - `full_registrations` - `registration_updates` - `deleted_registrations` - `expired_registrations` - `bootstraps_successful` - `bootstraps_failed` - `bootstraps_pending` - `handshakes_successful` - `connect_rest_api_success` - `connect_rest_api_error` - `device_proxy_request_success` - `device_proxy_request_error` - `device_subscription_request_success` - `device_subscription_request_error` - `device_observations` - `total_count`  **Note:**  The metrics `device_proxy_request_success`, `device_proxy_request_error`, `device_subscription_request_success`, `device_subscription_request_error` and `device_observations` monitor only the response from the device to Device Management Connect. They do not confirm that the response is delivered to the client callback URLs used when you try to access device resources using [Connect API](https://developer.pelion.com/docs/device-management-api/connect/) endpoints. New metrics will be added to monitor the response delivery to client callback URLs later.  **Example:**  ``` curl  -X GET https://api.us-east-1.mbedcloud.com/v3/metrics?include=transactions,total_count&start=20170207&end=20170407&interval=1d \\       -H \"Authorization : Bearer <access_key>\" ```  **Response:**    {     \"object\": \"list\",     \"limit\": 20,     \"total_count\": 54,     \"after\": \"2017-07-26T00:00:00Z\",     \"has_more\": true,     \"data\": [         {             \"id\": \"015d8157c800015e306fffff005374617473000\",             \"timestamp\": \"2017-07-27T00:00:00Z\",             \"transactions\": 27366         },         {             \"id\": \"015d867e2400015e306fffff005374617473000\",             \"timestamp\": \"2017-07-28T00:00:00Z\",             \"transactions\": 27480         }     ] } ```
String interval = "interval_example"; // String | Group the data by this interval in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The interval cannot exceed one year (365 days). The allowed ranges are 5m-525600m/1h-8760h/1d-365d/1w-53w.
LocalDate start = new LocalDate(); // LocalDate | UTC time/year/date in RFC3339 format. Fetch the data with timestamp greater than or equal to this value. Sample values: 20170207T092056990Z/2017-02-07T09:20:56.990Z/2017/20170207. The time between start and end parameters cannot exceed one year (365 days). The parameter is not mandatory if the period is specified.
LocalDate end = new LocalDate(); // LocalDate | UTC time/year/date in RFC3339 format. Fetch the data with timestamp less than this value. Sample values: 20170207T092056990Z/2017-02-07T09:20:56.990Z/2017/20170207. The time between start and end parameters cannot exceed one year (365 days). The parameter is not mandatory if the period is specified.
String period = "period_example"; // String | Period. Fetch the data for the period in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The parameter is not mandatory if the start and end time are specified. The period cannot exceed one year (365 days). The allowed ranges are 5m-525600m/1h-8760h/1d-365d/1w-53w.
Integer limit = 56; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The metric ID after which to start fetching. This also can be used for pagination.  **Example:**  ``` curl  -X GET https://api.us-east-1.mbedcloud.com/v3/metrics?include=transactions,total_count&start=20170707&end=20170829&interval=1d&limit=20 \\       -H \"Authorization : Bearer <access_key>\" ```  **Response:** ``` {    \"object\": \"list\",    \"limit\": 20,    \"total_count\": 54,    \"has_more\": true,    \"data\": [        {            \"id\": \"015d1a589800015e306fffff005374617473000\",            \"timestamp\": \"2017-07-07T00:00:00Z\",            \"transactions\": 26381        },        .        .        .        {            \"id\": \"015d7c316c00015e306fffff005374617473000\",            \"timestamp\": \"2017-07-26T00:00:00Z\",            \"transactions\": 25569        }    ] } ```  If the parameter `has more` is true, it indicates that the list is not complete and more values are available. You can give the last ID of the list as the value of the `after` query parameter, and you get the next page of values. You can keep doing this until `has more` is false.  ``` curl -X GET https://api.us-east-1.mbedcloud.com/v3/metrics?include=transactions,total_count&start=20170707&end=20170829&interval=1d&limit=20&after=015d7c316c00015e306fffff005374617473000 \\      -H \"Authorization : Bearer <access_key>\" ```  **Response:** ``` {    \"object\": \"list\",    \"limit\": 20,    \"total_count\": 54,    \"after\": \"2017-07-26T00:00:00Z\",    \"has_more\": true,    \"data\": [        {            \"id\": \"015d8157c800015e306fffff005374617473000\",            \"timestamp\": \"2017-07-27T00:00:00Z\",            \"transactions\": 27366        },      .      .      .        {            \"id\": \"015de3309c00015e306fffff005374617473000\",            \"timestamp\": \"2017-08-15T00:00:00Z\",            \"transactions\": 24707        }    ] } ```
String order = "order_example"; // String | 'Record order. Acceptable values: ASC, DESC. Default: ASC.'
try {
    SuccessfulResponse result = apiInstance.getMetrics(include, interval, start, end, period, limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageServiceMetricsApi#getMetrics");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | **String**| A comma-separated list of requested metrics and total_count (if included, the response will contain total_count to specify the total number of records available). Supported values are:  - &#x60;transactions&#x60; - &#x60;full_registrations&#x60; - &#x60;registration_updates&#x60; - &#x60;deleted_registrations&#x60; - &#x60;expired_registrations&#x60; - &#x60;bootstraps_successful&#x60; - &#x60;bootstraps_failed&#x60; - &#x60;bootstraps_pending&#x60; - &#x60;handshakes_successful&#x60; - &#x60;connect_rest_api_success&#x60; - &#x60;connect_rest_api_error&#x60; - &#x60;device_proxy_request_success&#x60; - &#x60;device_proxy_request_error&#x60; - &#x60;device_subscription_request_success&#x60; - &#x60;device_subscription_request_error&#x60; - &#x60;device_observations&#x60; - &#x60;total_count&#x60;  **Note:**  The metrics &#x60;device_proxy_request_success&#x60;, &#x60;device_proxy_request_error&#x60;, &#x60;device_subscription_request_success&#x60;, &#x60;device_subscription_request_error&#x60; and &#x60;device_observations&#x60; monitor only the response from the device to Device Management Connect. They do not confirm that the response is delivered to the client callback URLs used when you try to access device resources using [Connect API](https://developer.pelion.com/docs/device-management-api/connect/) endpoints. New metrics will be added to monitor the response delivery to client callback URLs later.  **Example:**  &#x60;&#x60;&#x60; curl  -X GET https://api.us-east-1.mbedcloud.com/v3/metrics?include&#x3D;transactions,total_count&amp;start&#x3D;20170207&amp;end&#x3D;20170407&amp;interval&#x3D;1d \\       -H \&quot;Authorization : Bearer &lt;access_key&gt;\&quot; &#x60;&#x60;&#x60;  **Response:**    {     \&quot;object\&quot;: \&quot;list\&quot;,     \&quot;limit\&quot;: 20,     \&quot;total_count\&quot;: 54,     \&quot;after\&quot;: \&quot;2017-07-26T00:00:00Z\&quot;,     \&quot;has_more\&quot;: true,     \&quot;data\&quot;: [         {             \&quot;id\&quot;: \&quot;015d8157c800015e306fffff005374617473000\&quot;,             \&quot;timestamp\&quot;: \&quot;2017-07-27T00:00:00Z\&quot;,             \&quot;transactions\&quot;: 27366         },         {             \&quot;id\&quot;: \&quot;015d867e2400015e306fffff005374617473000\&quot;,             \&quot;timestamp\&quot;: \&quot;2017-07-28T00:00:00Z\&quot;,             \&quot;transactions\&quot;: 27480         }     ] } &#x60;&#x60;&#x60; |
 **interval** | **String**| Group the data by this interval in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The interval cannot exceed one year (365 days). The allowed ranges are 5m-525600m/1h-8760h/1d-365d/1w-53w. |
 **start** | **LocalDate**| UTC time/year/date in RFC3339 format. Fetch the data with timestamp greater than or equal to this value. Sample values: 20170207T092056990Z/2017-02-07T09:20:56.990Z/2017/20170207. The time between start and end parameters cannot exceed one year (365 days). The parameter is not mandatory if the period is specified. | [optional]
 **end** | **LocalDate**| UTC time/year/date in RFC3339 format. Fetch the data with timestamp less than this value. Sample values: 20170207T092056990Z/2017-02-07T09:20:56.990Z/2017/20170207. The time between start and end parameters cannot exceed one year (365 days). The parameter is not mandatory if the period is specified. | [optional]
 **period** | **String**| Period. Fetch the data for the period in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The parameter is not mandatory if the start and end time are specified. The period cannot exceed one year (365 days). The allowed ranges are 5m-525600m/1h-8760h/1d-365d/1w-53w. | [optional]
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional]
 **after** | **String**| The metric ID after which to start fetching. This also can be used for pagination.  **Example:**  &#x60;&#x60;&#x60; curl  -X GET https://api.us-east-1.mbedcloud.com/v3/metrics?include&#x3D;transactions,total_count&amp;start&#x3D;20170707&amp;end&#x3D;20170829&amp;interval&#x3D;1d&amp;limit&#x3D;20 \\       -H \&quot;Authorization : Bearer &lt;access_key&gt;\&quot; &#x60;&#x60;&#x60;  **Response:** &#x60;&#x60;&#x60; {    \&quot;object\&quot;: \&quot;list\&quot;,    \&quot;limit\&quot;: 20,    \&quot;total_count\&quot;: 54,    \&quot;has_more\&quot;: true,    \&quot;data\&quot;: [        {            \&quot;id\&quot;: \&quot;015d1a589800015e306fffff005374617473000\&quot;,            \&quot;timestamp\&quot;: \&quot;2017-07-07T00:00:00Z\&quot;,            \&quot;transactions\&quot;: 26381        },        .        .        .        {            \&quot;id\&quot;: \&quot;015d7c316c00015e306fffff005374617473000\&quot;,            \&quot;timestamp\&quot;: \&quot;2017-07-26T00:00:00Z\&quot;,            \&quot;transactions\&quot;: 25569        }    ] } &#x60;&#x60;&#x60;  If the parameter &#x60;has more&#x60; is true, it indicates that the list is not complete and more values are available. You can give the last ID of the list as the value of the &#x60;after&#x60; query parameter, and you get the next page of values. You can keep doing this until &#x60;has more&#x60; is false.  &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/metrics?include&#x3D;transactions,total_count&amp;start&#x3D;20170707&amp;end&#x3D;20170829&amp;interval&#x3D;1d&amp;limit&#x3D;20&amp;after&#x3D;015d7c316c00015e306fffff005374617473000 \\      -H \&quot;Authorization : Bearer &lt;access_key&gt;\&quot; &#x60;&#x60;&#x60;  **Response:** &#x60;&#x60;&#x60; {    \&quot;object\&quot;: \&quot;list\&quot;,    \&quot;limit\&quot;: 20,    \&quot;total_count\&quot;: 54,    \&quot;after\&quot;: \&quot;2017-07-26T00:00:00Z\&quot;,    \&quot;has_more\&quot;: true,    \&quot;data\&quot;: [        {            \&quot;id\&quot;: \&quot;015d8157c800015e306fffff005374617473000\&quot;,            \&quot;timestamp\&quot;: \&quot;2017-07-27T00:00:00Z\&quot;,            \&quot;transactions\&quot;: 27366        },      .      .      .        {            \&quot;id\&quot;: \&quot;015de3309c00015e306fffff005374617473000\&quot;,            \&quot;timestamp\&quot;: \&quot;2017-08-15T00:00:00Z\&quot;,            \&quot;transactions\&quot;: 24707        }    ] } &#x60;&#x60;&#x60; | [optional]
 **order** | **String**| &#39;Record order. Acceptable values: ASC, DESC. Default: ASC.&#39; | [optional]

### Return type

[**SuccessfulResponse**](SuccessfulResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

