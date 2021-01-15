# UsageBillingReportsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getBillingReport**](UsageBillingReportsApi.md#getBillingReport) | **GET** v3/billing-report | Get billing report.
[**getBillingReportActiveDevices**](UsageBillingReportsApi.md#getBillingReportActiveDevices) | **GET** v3/billing-report-active-devices | Get raw billing data of the active devices for the month.
[**getBillingReportFirmwareUpdates**](UsageBillingReportsApi.md#getBillingReportFirmwareUpdates) | **GET** v3/billing-report-firmware-updates | Get raw billing data of the firmware updates for the month.
[**getServicePackageQuota**](UsageBillingReportsApi.md#getServicePackageQuota) | **GET** v3/service-packages-quota | Service package quota.
[**getServicePackages**](UsageBillingReportsApi.md#getServicePackages) | **GET** v3/service-packages | Get all service packages.


<a name="getBillingReport"></a>
# **getBillingReport**
> ReportResponse getBillingReport(month)

Get billing report.

Fetch the billing report generated for the currently authenticated commercial account. The billing reports for tenant accounts are also included in their aggregator&#39;s billing report response. The response contains below additional counters when the account&#39;s business model is set to &#x60;API calls&#x60; by the account administrator.   - rest_api_requests_with_user_token   - rest_api_requests_with_api_key_token   - pelion_to_webapp_notifications   - device_to_pelion_messages   - pelion_to_device_messages  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UsageBillingReportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UsageBillingReportsApi apiInstance = new UsageBillingReportsApi();
String month = "month_example"; // String | Queried year and month of billing report.
try {
    ReportResponse result = apiInstance.getBillingReport(month);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageBillingReportsApi#getBillingReport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **String**| Queried year and month of billing report. |

### Return type

[**ReportResponse**](ReportResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getBillingReportActiveDevices"></a>
# **getBillingReportActiveDevices**
> BillingReportRawDataResponse getBillingReportActiveDevices(month)

Get raw billing data of the active devices for the month.

Fetch raw billing data for active devices for the currently authenticated commercial account.  This is supplementary data for the billing report. The raw billing data of the active devices for tenant accounts are included in their aggregator&#39;s raw billing data of the active devices.  The endpoint returns the URL to download the gzipped CSV file. The first line is the header providing information on active devices, for example, the ID of an active device.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UsageBillingReportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UsageBillingReportsApi apiInstance = new UsageBillingReportsApi();
String month = "month_example"; // String | Queried year and month of billing report.
try {
    BillingReportRawDataResponse result = apiInstance.getBillingReportActiveDevices(month);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageBillingReportsApi#getBillingReportActiveDevices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **String**| Queried year and month of billing report. |

### Return type

[**BillingReportRawDataResponse**](BillingReportRawDataResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getBillingReportFirmwareUpdates"></a>
# **getBillingReportFirmwareUpdates**
> BillingReportRawDataResponse getBillingReportFirmwareUpdates(month)

Get raw billing data of the firmware updates for the month.

Fetch raw billing data for firmware updates for the currently authenticated commercial account.  This is supplementary data for the billing report. The raw billing data of the firmware updates for tenant accounts are also included in their aggregator&#39;s raw billing data of the firmware updates.  The endpoint returns the URL to download the gzipped CSV file. The first line is the header providing information on the firmware updates, for example, the ID of a firmware update.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UsageBillingReportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UsageBillingReportsApi apiInstance = new UsageBillingReportsApi();
String month = "month_example"; // String | Queried year and month of billing report.
try {
    BillingReportRawDataResponse result = apiInstance.getBillingReportFirmwareUpdates(month);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageBillingReportsApi#getBillingReportFirmwareUpdates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **String**| Queried year and month of billing report. |

### Return type

[**BillingReportRawDataResponse**](BillingReportRawDataResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getServicePackageQuota"></a>
# **getServicePackageQuota**
> ServicePackageQuota getServicePackageQuota()

Service package quota.

Get the available firmware update quota for the current authenticated commercial account.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UsageBillingReportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UsageBillingReportsApi apiInstance = new UsageBillingReportsApi();
try {
    ServicePackageQuota result = apiInstance.getServicePackageQuota();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageBillingReportsApi#getServicePackageQuota");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ServicePackageQuota**](ServicePackageQuota.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getServicePackages"></a>
# **getServicePackages**
> ServicePackagesResponse getServicePackages()

Get all service packages.

Get information for all service packages for the current authenticated commercial account. The response is returned in descending order by service package created timestamp: first the pending service package, then the active service package, then the previous service packages.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UsageBillingReportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UsageBillingReportsApi apiInstance = new UsageBillingReportsApi();
try {
    ServicePackagesResponse result = apiInstance.getServicePackages();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageBillingReportsApi#getServicePackages");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ServicePackagesResponse**](ServicePackagesResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

