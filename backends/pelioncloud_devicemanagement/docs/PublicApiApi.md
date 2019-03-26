# PublicApiApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBulkDeviceEnrollment**](PublicApiApi.md#createBulkDeviceEnrollment) | **POST** v3/device-enrollments-bulk-uploads | Bulk upload
[**createDeviceEnrollment**](PublicApiApi.md#createDeviceEnrollment) | **POST** v3/device-enrollments | Create a single enrollment.
[**deleteBulkDeviceEnrollment**](PublicApiApi.md#deleteBulkDeviceEnrollment) | **POST** v3/device-enrollments-bulk-deletes | Bulk delete
[**deleteDeviceEnrollment**](PublicApiApi.md#deleteDeviceEnrollment) | **DELETE** v3/device-enrollments/{id} | Delete an enrollment by ID.
[**getBulkDeviceEnrollment**](PublicApiApi.md#getBulkDeviceEnrollment) | **GET** v3/device-enrollments-bulk-uploads/{id} | Get bulk upload entity
[**getBulkDeviceEnrollmentDelete**](PublicApiApi.md#getBulkDeviceEnrollmentDelete) | **GET** v3/device-enrollments-bulk-deletes/{id} | Get bulk delete entity
[**getDeviceEnrollment**](PublicApiApi.md#getDeviceEnrollment) | **GET** v3/device-enrollments/{id} | Get details of an single enrollment by ID.
[**getDeviceEnrollments**](PublicApiApi.md#getDeviceEnrollments) | **GET** v3/device-enrollments | Get a list of enrollments per account.


<a name="createBulkDeviceEnrollment"></a>
# **createBulkDeviceEnrollment**
> BulkResponse createBulkDeviceEnrollment(enrollmentIdentities)

Bulk upload

With bulk upload, you can upload a &#x60;CSV&#x60; file containing a number of enrollment IDs.  **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ -F &#39;enrollment_identities&#x3D;@/path/to/enrollments/enrollments.csv&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-uploads  &#x60;&#x60;&#x60; **The validation rules for an CSV file.** 1. The first line in the uploaded CSV file is assumed to be the header and is ignored. 1. Each line can contain comma-separated values, where the first value is always assumed to be the Enrollment ID. Everything after the first comma is ignored. 1. Valid enrollments begin with A followed by a - and 95 characters in the format as below. 1. Up to one enrollment ID is expected per line. Empty lines are ignored. 1. Trailing comma at the end of the line is optional. 1. Lines are terminated with either a line feed \\n, a carriage return \\r, or both together \\r\\n. 1. Leading and trailing whitespace characters (Unicode U+0000 - U+0020) are removed from the identity before validation. 1. Empty identities are ignored. 1. Valid enrollment identities may be enclosed within quotes. Whitespace inside quotes is not trimmed and will fail validation. Empty quotes are also considered to be an invalid enrollment identity. 1. UTF-8 encoding is expected.   **A valid enrollment file:** &#x60;&#x60;&#x60; \&quot;Examples of valid identites, notes\&quot; \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:44:71:93:23:22:15:43:23:12\&quot;, \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12\&quot; A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12 A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:24:44:71:22:15:43:23:12, This text is ignored,  A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:60:25:48:44:71:22:15:43:23:12       , Whitespace is trimmed before validation   \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:60:25:48:44:71:22:15:43:23:12\&quot;       , Whitespace around quotes is also trimmed  &#x60;&#x60;&#x60;  **A file containing invalid identities:** &#x60;&#x60;&#x60; \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:44:71:93:23:22:15:43:23:12\&quot;, First line is ignored A_4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12, Invalid version identifier A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12, Too short identity \&quot;\&quot;, Empty quotes are an invalid identity \&quot; A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:44:71:93:23:22:15:43:23:12 \&quot;, Whitespace inside quotes is not trimmed causing an error  &#x60;&#x60;&#x60;  **An empty file:** &#x60;&#x60;&#x60; \&quot;Examples of blank lines that are ignored\&quot;  ,, , This is also considered to a blank line &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
File enrollmentIdentities = new File("/path/to/file.txt"); // File | The `CSV` file containing the enrollment IDs. The maximum file size is 10MB.
try {
    BulkResponse result = apiInstance.createBulkDeviceEnrollment(enrollmentIdentities);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#createBulkDeviceEnrollment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enrollmentIdentities** | **File**| The &#x60;CSV&#x60; file containing the enrollment IDs. The maximum file size is 10MB. |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="createDeviceEnrollment"></a>
# **createDeviceEnrollment**
> EnrollmentIdentity createDeviceEnrollment(enrollmentIdentity)

Create a single enrollment.

When the device connects to the bootstrap server and provides the enrollment ID, it will be assigned to your account. &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments \\ -d &#39;{\&quot;enrollment_identity\&quot;: \&quot;A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5\&quot;}&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
EnrollmentId enrollmentIdentity = new EnrollmentId(); // EnrollmentId | 
try {
    EnrollmentIdentity result = apiInstance.createDeviceEnrollment(enrollmentIdentity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#createDeviceEnrollment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enrollmentIdentity** | [**EnrollmentId**](EnrollmentId.md)|  |

### Return type

[**EnrollmentIdentity**](EnrollmentIdentity.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteBulkDeviceEnrollment"></a>
# **deleteBulkDeviceEnrollment**
> BulkResponse deleteBulkDeviceEnrollment(enrollmentIdentities)

Bulk delete

With bulk delete, you can upload a &#x60;CSV&#x60; file containing a number of enrollment IDs to be deleted.  **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ -F &#39;enrollment_identities&#x3D;@/path/to/enrollments/enrollments.csv&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-deletes  &#x60;&#x60;&#x60; **The validation rules for an CSV file.** 1. The first line in the uploaded CSV file is assumed to be the header and is ignored. 1. Each line can contain comma-separated values, where the first value is always assumed to be the Enrollment ID. Everything after the first comma is ignored. 1. Valid enrollments begin with A followed by a - and 95 characters in the format as below. 1. Up to one enrollment ID is expected per line. Empty lines are ignored. 1. Trailing comma at the end of the line is optional. 1. Lines are terminated with either a line feed \\n, a carriage return \\r, or both together \\r\\n. 1. Leading and trailing whitespace characters (Unicode U+0000 - U+0020) are removed from the identity before validation. 1. Empty identities are ignored. 1. Valid enrollment identities may be enclosed within quotes. Whitespace inside quotes is not trimmed and will fail validation. Empty quotes are also considered to be an invalid enrollment identity. 1. UTF-8 encoding is expected.   **A valid enrollment file:** &#x60;&#x60;&#x60; \&quot;Examples of valid identites, notes\&quot; \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:44:71:93:23:22:15:43:23:12\&quot;, \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12\&quot; A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12 A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:24:44:71:22:15:43:23:12, This text is ignored,  A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:60:25:48:44:71:22:15:43:23:12       , Whitespace is trimmed before validation   \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:60:25:48:44:71:22:15:43:23:12\&quot;       , Whitespace around quotes is also trimmed  &#x60;&#x60;&#x60;  **A file containing invalid identities:** &#x60;&#x60;&#x60; \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:44:71:93:23:22:15:43:23:12\&quot;, First line is ignored A_4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12, Invalid version identifier A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12, Too short identity \&quot;\&quot;, Empty quotes are an invalid identity \&quot; A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:44:71:93:23:22:15:43:23:12 \&quot;, Whitespace inside quotes is not trimmed causing an error  &#x60;&#x60;&#x60;  **An empty file:** &#x60;&#x60;&#x60; \&quot;Examples of blank lines that are ignored\&quot;  ,, , This is also considered to a blank line &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
File enrollmentIdentities = new File("/path/to/file.txt"); // File | The `CSV` file containing the enrollment IDs. The maximum file size is 10MB.
try {
    BulkResponse result = apiInstance.deleteBulkDeviceEnrollment(enrollmentIdentities);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#deleteBulkDeviceEnrollment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enrollmentIdentities** | **File**| The &#x60;CSV&#x60; file containing the enrollment IDs. The maximum file size is 10MB. |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="deleteDeviceEnrollment"></a>
# **deleteDeviceEnrollment**
> Void deleteDeviceEnrollment(id)

Delete an enrollment by ID.

To free a device from your account you can delete the enrollment claim. To bypass the device ownership, you need to delete the enrollment and do a factory reset for the device. For more information, see [Transferring the ownership using First-to-Claim](/docs/current/connecting/device-ownership-first-to-claim-by-enrollment-list.html). &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl -X DELETE \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments/{id} &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
String id = "id_example"; // String | Enrollment identity.
try {
    Void result = apiInstance.deleteDeviceEnrollment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#deleteDeviceEnrollment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Enrollment identity. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getBulkDeviceEnrollment"></a>
# **getBulkDeviceEnrollment**
> BulkResponse getBulkDeviceEnrollment(id)

Get bulk upload entity

Provides information on bulk upload for the given ID. For example, the bulk status and the number of processed enrollment identities. Also links to the bulk upload reports are provided. **Report file format:** The report files have a header line and the value are separated by commas. The lines are delimited by a line break (CRLF). The report file is compliant with IETF Informal CSV common format [RFC 4180](https://tools.ietf.org/html/rfc4180). An example of a full report file: &#x60;&#x60;&#x60; \&quot;entity__id\&quot;,\&quot;entity__created_at\&quot;,\&quot;error__code\&quot;,\&quot;error__type\&quot;,\&quot;error__message\&quot;,\&quot;error__fields\&quot; \&quot;A-F9:AA:AA:AA:DE:31:C7:30:72:55:27:AE:8B:E1:1C:6F:42:7D:06:CF:FB:18:6F:59:48:29:B3:98:4B:76:8F:9E\&quot;,\&quot;2018-09-07T12:10:58.428Z\&quot;,\&quot;\&quot;,\&quot;\&quot;,\&quot;\&quot;,\&quot;\&quot; \&quot;A-FF:AA:AA:AA:3B:43:EB:D7:C7:30:03:5F:C8:D0:15:91:70:C2:5D:4F:EB:24:E9:3A:BB:D8:3C:FE:20:EA:B1:72\&quot;,\&quot;2018-09-07T12:10:58.428Z\&quot;,\&quot;\&quot;,\&quot;\&quot;,\&quot;\&quot;,\&quot;\&quot; &#x60;&#x60;&#x60; An example of an error report file: &#x60;&#x60;&#x60; \&quot;entity__id\&quot;,\&quot;error__code\&quot;,\&quot;error__type\&quot;,\&quot;error__message\&quot;,\&quot;error__fields\&quot; \&quot;A-F9:AA:AA:AA:DE:31:C7:30:72:55:27:AE:8B:E1:1C:6F:42:7D:06:CF:FB:18:6F:59:48:29:B3:98:4B:76:8F:9E\&quot;,\&quot;409\&quot;,\&quot;duplicate\&quot;,\&quot;Enrollment identity is already claimed in the mbed Cloud.\&quot;,\&quot;\&quot; \&quot;A-FF:AA:AA:AA:3B:43:EB:D7:C7:30:03:5F:C8:D0:15:91:70:C2:5D:4F:EB:24:E9:3A:BB:D8:3C:FE:20:EA:B1:72\&quot;,\&quot;409\&quot;,\&quot;duplicate\&quot;,\&quot;Enrollment identity is already claimed in the mbed Cloud.\&quot;,\&quot;\&quot; &#x60;&#x60;&#x60; **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-uploads/{id} &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
String id = "id_example"; // String | Bulk create task entity ID
try {
    BulkResponse result = apiInstance.getBulkDeviceEnrollment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#getBulkDeviceEnrollment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Bulk create task entity ID |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/csv, application/json

<a name="getBulkDeviceEnrollmentDelete"></a>
# **getBulkDeviceEnrollmentDelete**
> BulkResponse getBulkDeviceEnrollmentDelete(id)

Get bulk delete entity

Provides information on bulk delete for the given ID. For example, the bulk status and the number of processed enrollment identities. Also links to the bulk delete reports are provided. **Report file format:** The report files have a header line and the value are separated by commas. The lines are delimited by a line break (CRLF). The report file is compliant with IETF Informal CSV common format [RFC 4180](https://tools.ietf.org/html/rfc4180). An example of a full report file: &#x60;&#x60;&#x60; \&quot;entity__id\&quot;,\&quot;entity__deleted_at\&quot;,\&quot;error__code\&quot;,\&quot;error__type\&quot;,\&quot;error__message\&quot;,\&quot;error__fields\&quot; \&quot;A-F9:AA:AA:AA:DE:31:C7:30:72:55:27:AE:8B:E1:1C:6F:42:7D:06:CF:FB:18:6F:59:48:29:B3:98:4B:76:8F:9E\&quot;,\&quot;2018-09-07T12:10:58.428Z\&quot;,\&quot;\&quot;,\&quot;\&quot;,\&quot;\&quot;,\&quot;\&quot; \&quot;A-FF:AA:AA:AA:3B:43:EB:D7:C7:30:03:5F:C8:D0:15:91:70:C2:5D:4F:EB:24:E9:3A:BB:D8:3C:FE:20:EA:B1:72\&quot;,\&quot;2018-09-07T12:10:58.428Z\&quot;,\&quot;\&quot;,\&quot;\&quot;,\&quot;\&quot;,\&quot;\&quot; &#x60;&#x60;&#x60; An example of an error report file: &#x60;&#x60;&#x60; \&quot;entity__id\&quot;,\&quot;error__code\&quot;,\&quot;error__type\&quot;,\&quot;error__message\&quot;,\&quot;error__fields\&quot; \&quot;A-F9:AA:AA:AA:DE:31:C7:30:72:55:27:AE:8B:E1:1C:6F:42:7D:06:CF:FB:18:6F:59:48:29:B3:98:4B:76:8F:9E\&quot;,\&quot;409\&quot;,\&quot;duplicate\&quot;,\&quot;Enrollment identity is already claimed in the mbed Cloud.\&quot;,\&quot;\&quot; \&quot;A-FF:AA:AA:AA:3B:43:EB:D7:C7:30:03:5F:C8:D0:15:91:70:C2:5D:4F:EB:24:E9:3A:BB:D8:3C:FE:20:EA:B1:72\&quot;,\&quot;409\&quot;,\&quot;duplicate\&quot;,\&quot;Enrollment identity is already claimed in the mbed Cloud.\&quot;,\&quot;\&quot; &#x60;&#x60;&#x60; **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-deletes/{id} &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
String id = "id_example"; // String | Bulk delete task entity ID
try {
    BulkResponse result = apiInstance.getBulkDeviceEnrollmentDelete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#getBulkDeviceEnrollmentDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Bulk delete task entity ID |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/csv, application/json

<a name="getDeviceEnrollment"></a>
# **getDeviceEnrollment**
> EnrollmentIdentity getDeviceEnrollment(id)

Get details of an single enrollment by ID.

To check the enrollment info in detail, for example date of claim and expiration date. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments/{id} &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
String id = "id_example"; // String | Enrollment identity.
try {
    EnrollmentIdentity result = apiInstance.getDeviceEnrollment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#getDeviceEnrollment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Enrollment identity. |

### Return type

[**EnrollmentIdentity**](EnrollmentIdentity.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDeviceEnrollments"></a>
# **getDeviceEnrollments**
> EnrollmentIdentities getDeviceEnrollments(limit, after, order, include)

Get a list of enrollments per account.

Provides a list of pending and claimed enrollments. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments &#x60;&#x60;&#x60; With query parameters: &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ &#39;https://api.us-east-1.mbedcloud.com/v3/device-enrollments?limit&#x3D;10&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
Integer limit = 56; // Integer | Number of results to be returned. Between 2 and 1000, inclusive.
String after = "after_example"; // String | Entity ID to fetch after.
String order = "ASC"; // String | ASC or DESC
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    EnrollmentIdentities result = apiInstance.getDeviceEnrollments(limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#getDeviceEnrollments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Number of results to be returned. Between 2 and 1000, inclusive. | [optional]
 **after** | **String**| Entity ID to fetch after. | [optional]
 **order** | **String**| ASC or DESC | [optional] [default to ASC] [enum: ASC, DESC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]

### Return type

[**EnrollmentIdentities**](EnrollmentIdentities.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

