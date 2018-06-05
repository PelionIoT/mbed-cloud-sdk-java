
# PreviousServicePackage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**created** | **String** | Service package creation time in RFC3339 date-time with UTC time zone. | 
**endTime** | **String** | Service package end time in RFC3339 date-time with UTC time zone. | 
**expires** | **String** | Service package expiration time in RFC3339 date-time with UTC time zone. | 
**firmwareUpdateCount** | **Integer** | Size of firmware update quota of this service package. | 
**id** | **String** | ID of this service package. | 
**modified** | **String** | Service package latest modified time in RFC3339 date-time with UTC time zone. | 
**nextId** | **String** | Next service package ID if this service package has a pending renewal or null. |  [optional]
**previousId** | **String** | Previous service package ID. |  [optional]
**reason** | [**ReasonEnum**](#ReasonEnum) | Reason why this service package was ended | 
**startTime** | **String** | Service package start time in RFC3339 date-time with UTC time zone. | 


<a name="ReasonEnum"></a>
## Enum: ReasonEnum
Name | Value
---- | -----
RENEWED | &quot;renewed&quot;
TERMINATED | &quot;terminated&quot;



