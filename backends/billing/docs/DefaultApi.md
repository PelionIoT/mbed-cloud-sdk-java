# DefaultApi

All URIs are relative to *http://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getBillingReport**](DefaultApi.md#getBillingReport) | **GET** v3/billing-report | Get billing report.
[**getBillingReportActiveDevices**](DefaultApi.md#getBillingReportActiveDevices) | **GET** v3/billing-report-active-devices | Get raw active devices billing data for the month.
[**getBillingReportFirmwareUpdates**](DefaultApi.md#getBillingReportFirmwareUpdates) | **GET** v3/billing-report-firmware-updates | Get raw firmware updates billing data for the month.
[**getServicePackageQuota**](DefaultApi.md#getServicePackageQuota) | **GET** v3/service-packages-quota | Service package quota
[**getServicePackageQuotaHistory**](DefaultApi.md#getServicePackageQuotaHistory) | **GET** v3/service-packages-quota-history | Service package quota history
[**getServicePackages**](DefaultApi.md#getServicePackages) | **GET** v3/service-packages | Get all service packages.


<a name="getBillingReport"></a>
# **getBillingReport**
> ReportResponse getBillingReport(month)

Get billing report.

Fetch generated billing report for the currently authenticated commercial non-subtenant account. Billing reports for subtenant accounts are included in their aggregator&#39;s billing report response.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.billing.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.billing.ApiException;
//import com.arm.mbed.cloud.sdk.internal.billing.Configuration;
//import com.arm.mbed.cloud.sdk.internal.billing.auth.*;
//import com.arm.mbed.cloud.sdk.internal.billing.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String month = "month_example"; // String | Queried year and month of billing report
try {
    ReportResponse result = apiInstance.getBillingReport(month);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getBillingReport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **String**| Queried year and month of billing report |

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

Get raw active devices billing data for the month.

Fetch raw active devices billing data for the currently authenticated commercial non-subtenant account. They are supplementary data for billing report. The raw active devices billing data for subtenant accounts are included in their aggregator&#39;s raw active devices billing data. Endpoint returns the URL to download the gzipped csv file. First line of the file is the header which describes information of active devices included, e.g. active device ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.billing.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.billing.ApiException;
//import com.arm.mbed.cloud.sdk.internal.billing.Configuration;
//import com.arm.mbed.cloud.sdk.internal.billing.auth.*;
//import com.arm.mbed.cloud.sdk.internal.billing.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String month = "month_example"; // String | Queried year and month of billing report
try {
    BillingReportRawDataResponse result = apiInstance.getBillingReportActiveDevices(month);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getBillingReportActiveDevices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **String**| Queried year and month of billing report |

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

Get raw firmware updates billing data for the month.

Fetch raw firmware updates billing data for the currently authenticated commercial non-subtenant account. They are supplementary data for billing report. The raw firmware updates billing data for subtenant accounts are included in their aggregator&#39;s raw firmware updates billing data. Endpoint returns the URL to download the gzipped csv file. First line of the file is the header which describes information of firmware updates included, e.g. firmware update device ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.billing.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.billing.ApiException;
//import com.arm.mbed.cloud.sdk.internal.billing.Configuration;
//import com.arm.mbed.cloud.sdk.internal.billing.auth.*;
//import com.arm.mbed.cloud.sdk.internal.billing.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String month = "month_example"; // String | Queried year and month of billing report
try {
    BillingReportRawDataResponse result = apiInstance.getBillingReportFirmwareUpdates(month);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getBillingReportFirmwareUpdates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **String**| Queried year and month of billing report |

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

Service package quota

Get the available firmware update quota for the currently authenticated commercial acount.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.billing.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.billing.ApiException;
//import com.arm.mbed.cloud.sdk.internal.billing.Configuration;
//import com.arm.mbed.cloud.sdk.internal.billing.auth.*;
//import com.arm.mbed.cloud.sdk.internal.billing.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    ServicePackageQuota result = apiInstance.getServicePackageQuota();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getServicePackageQuota");
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

<a name="getServicePackageQuotaHistory"></a>
# **getServicePackageQuotaHistory**
> ServicePackageQuotaHistoryResponse getServicePackageQuotaHistory(limit, after)

Service package quota history

Get your quota usage history. This API is available for commercial accounts. Aggregator accounts can see own and subtenant quota usage data. History data is ordered in ascending order based on the added timestamp. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.billing.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.billing.ApiException;
//import com.arm.mbed.cloud.sdk.internal.billing.Configuration;
//import com.arm.mbed.cloud.sdk.internal.billing.auth.*;
//import com.arm.mbed.cloud.sdk.internal.billing.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 56; // Integer | Maximum amount of quota history entries contained in one paged response.
String after = "after_example"; // String | To fetch after which quota history ID. The results will contain entries after specified entry.
try {
    ServicePackageQuotaHistoryResponse result = apiInstance.getServicePackageQuotaHistory(limit, after);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getServicePackageQuotaHistory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Maximum amount of quota history entries contained in one paged response. | [optional]
 **after** | **String**| To fetch after which quota history ID. The results will contain entries after specified entry. | [optional]

### Return type

[**ServicePackageQuotaHistoryResponse**](ServicePackageQuotaHistoryResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getServicePackages"></a>
# **getServicePackages**
> ServicePackagesResponse getServicePackages()

Get all service packages.

Get information of all service packages for currently authenticated commercial account. The response is returned with descending order by service package created timestamp, listing first pending service package, then active service package, and previous service packages at last.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.billing.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.billing.ApiException;
//import com.arm.mbed.cloud.sdk.internal.billing.Configuration;
//import com.arm.mbed.cloud.sdk.internal.billing.auth.*;
//import com.arm.mbed.cloud.sdk.internal.billing.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    ServicePackagesResponse result = apiInstance.getServicePackages();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getServicePackages");
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

