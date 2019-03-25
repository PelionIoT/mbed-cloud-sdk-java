
# ActiveServicePackage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**created** | [**DateTime**](DateTime.md) | Service package creation time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**expires** | [**DateTime**](DateTime.md) | Service package expiration time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**firmwareUpdateCount** | **Integer** | Size of firmware update quota of this service package. | 
**gracePeriod** | **Boolean** | Indicates whether the service package is in its grace period. | 
**id** | **String** | ID of this service package. | 
**modified** | [**DateTime**](DateTime.md) | Service package latest modified time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**nextId** | **String** | Next service package ID if this service package has a pending renewal, or null. |  [optional]
**previousId** | **String** | Previous service package ID or null. |  [optional]
**startTime** | [**DateTime**](DateTime.md) | Service package start time in RFC3339 date-time with millisecond accuracy and UTC time zone. | 



