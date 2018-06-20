
# ErrorObjectResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **Integer** | Error code. Correlates with response status code. | 
**fields** | [**List&lt;FieldMessageEntry&gt;**](FieldMessageEntry.md) | A list of request fields that failed the validation. | 
**message** | **String** | Error message. | 
**object** | **String** | entity name: &#39;error&#39; | 
**requestId** | **String** | Request ID from JWT. | 
**type** | **String** | Error type. | 



