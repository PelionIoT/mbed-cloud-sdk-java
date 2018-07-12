
# PreviousServicePackage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**created** | [**DateTime**](DateTime.md) | Service package creation time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**endTime** | [**DateTime**](DateTime.md) | Service package end time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**expires** | [**DateTime**](DateTime.md) | Service package expiration time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**firmwareUpdateCount** | **Integer** | Size of firmware update quota of this service package. | 
**id** | **String** | ID of this service package. | 
**modified** | [**DateTime**](DateTime.md) | Service package latest modified time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**nextId** | **String** | Next service package ID if this service package has a pending renewal or null. |  [optional]
**previousId** | **String** | Previous service package ID. |  [optional]
**reason** | [**ReasonEnum**](#ReasonEnum) | Reason why this service package was ended | 
**startTime** | [**DateTime**](DateTime.md) | Service package start time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 


<a name="ReasonEnum"></a>
## Enum: ReasonEnum
Name | Value
---- | -----
RENEWED | &quot;renewed&quot;
TERMINATED | &quot;terminated&quot;



