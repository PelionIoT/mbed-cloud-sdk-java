
# ActiveSession

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The UUID of the account. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**ipAddress** | **String** | IP address of the client. | 
**loginTime** | [**DateTime**](DateTime.md) | The login time of the user. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;user-session&#39; | 
**referenceToken** | **String** | The reference token. | 
**userAgent** | **String** | User Agent header from the login request. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
SESSION | &quot;user-session&quot;



