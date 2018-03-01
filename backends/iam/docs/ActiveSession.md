
# ActiveSession

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The UUID of the account. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;user-session&#39; | 
**userAgent** | **String** | User Agent header from the login request. | 
**ipAddress** | **String** | IP address of the client. | 
**referenceToken** | **String** | The reference token. | 
**loginTime** | [**DateTime**](DateTime.md) | The login time of the user. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
SESSION | &quot;user-session&quot;



