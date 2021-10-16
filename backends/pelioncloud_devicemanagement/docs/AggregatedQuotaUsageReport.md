
# AggregatedQuotaUsageReport

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** |  | 
**amount** | **Long** | Amount of quota usage entry. Negative if quota consumption. | 
**campaignName** | **String** | Campaign name of quota usage entry. Null if quota usage entry type is not &#x60;reservation&#x60; or &#x60;reservation release&#x60;. |  [optional]
**time** | [**DateTime**](DateTime.md) | Added time of quota usage entry in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**type** | [**TypeEnum**](#TypeEnum) | Type of quota usage entry. | 


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
RESERVATION | &quot;reservation&quot;
RESERVATION_RELEASE | &quot;reservation_release&quot;
RESERVATION_TERMINATION | &quot;reservation_termination&quot;
PACKAGE_RENEWAL | &quot;package_renewal&quot;
PACKAGE_CREATION | &quot;package_creation&quot;
PACKAGE_TERMINATION | &quot;package_termination&quot;
PACKAGE_TOKENS_EDIT | &quot;package_tokens_edit&quot;



