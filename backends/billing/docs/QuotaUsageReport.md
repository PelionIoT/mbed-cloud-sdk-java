
# QuotaUsageReport

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Long** | Amount of quota usage entry. Negavtive if it is quota consumption. | 
**campaignName** | **String** | Campaign name of quota usage entry. Null if quota usage entry type is not reservation or reservation release. |  [optional]
**time** | [**DateTime**](DateTime.md) | Added time of quota usage entry. | 
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



