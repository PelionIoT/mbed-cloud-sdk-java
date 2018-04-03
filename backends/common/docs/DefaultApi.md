# DefaultApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**test**](DefaultApi.md#test) | **GET**  | 


<a name="test"></a>
# **test**
> Void test()



### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.common.ApiException;
//import com.arm.mbed.cloud.sdk.internal.common.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    Void result = apiInstance.test();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#test");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

