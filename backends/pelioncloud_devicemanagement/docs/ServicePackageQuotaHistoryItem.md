
# ServicePackageQuotaHistoryItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**added** | [**DateTime**](DateTime.md) | Added time of quota history entry in RFC3339 date-time with millisecond accuracy and UTC time zone. | 
**amount** | **Long** | Negative or positive quota usage. | 
**id** | **String** | Service package quota history ID. | 
**reason** | [**ReasonEnum**](#ReasonEnum) | Type of quota usage entry. | 
**reservation** | [**ServicePackageQuotaHistoryReservation**](ServicePackageQuotaHistoryReservation.md) | Reservation details if reason is &#x60;reservation&#x60;, &#x60;reservation_release&#x60; or &#x60;reservation_termination&#x60;. |  [optional]
**servicePackage** | [**ServicePackageQuotaHistoryServicePackage**](ServicePackageQuotaHistoryServicePackage.md) | Service package details if reason is &#x60;package_creation&#x60;, &#x60;package_renewal&#x60;, &#x60;package_termination&#x60;, or &#x60;package_tokens_edit&#x60;. |  [optional]


<a name="ReasonEnum"></a>
## Enum: ReasonEnum
Name | Value
---- | -----
RESERVATION | &quot;reservation&quot;
RESERVATION_RELEASE | &quot;reservation_release&quot;
RESERVATION_TERMINATION | &quot;reservation_termination&quot;
PACKAGE_CREATION | &quot;package_creation&quot;
PACKAGE_RENEWAL | &quot;package_renewal&quot;
PACKAGE_TERMINATION | &quot;package_termination&quot;
PACKAGE_TOKENS_EDIT | &quot;package_tokens_edit&quot;



