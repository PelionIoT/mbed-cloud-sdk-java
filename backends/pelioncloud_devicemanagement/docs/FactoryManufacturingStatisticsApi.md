# FactoryManufacturingStatisticsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**manufacturingStatisticsReport**](FactoryManufacturingStatisticsApi.md#manufacturingStatisticsReport) | **GET** v3/manufacturing/statistics | Retrieve provisioning statistics for devices in your factories.


<a name="manufacturingStatisticsReport"></a>
# **manufacturingStatisticsReport**
> StatisticsReportListResponse manufacturingStatisticsReport(start, end)

Retrieve provisioning statistics for devices in your factories.

Get manufacturing statistics report. **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/manufacturing/statistics?start&#x3D;2020-06-23T21:00:00.000Z&amp;end&#x3D;2020-07-01T20:59:59.999Z --header &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.FactoryManufacturingStatisticsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

FactoryManufacturingStatisticsApi apiInstance = new FactoryManufacturingStatisticsApi();
DateTime start = new DateTime(); // DateTime | The start date and time for the report.
DateTime end = new DateTime(); // DateTime | The end date and time for the report. The default value is the current date-time.
try {
    StatisticsReportListResponse result = apiInstance.manufacturingStatisticsReport(start, end);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FactoryManufacturingStatisticsApi#manufacturingStatisticsReport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **DateTime**| The start date and time for the report. |
 **end** | **DateTime**| The end date and time for the report. The default value is the current date-time. | [optional]

### Return type

[**StatisticsReportListResponse**](StatisticsReportListResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

