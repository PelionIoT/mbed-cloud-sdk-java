
# ServicePackageQuotaHistoryItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**added** | [**DateTime**](DateTime.md) | Added time of quota history entry. | 
**amount** | **Long** | the amount of quota usage, negative or positive | 
**id** | **String** | Service package quota history id. | 
**reason** | [**ReasonEnum**](#ReasonEnum) | Type of quota usage entry. | 
**reservation** | [**ServicePackageQuotaHistoryReservation**](ServicePackageQuotaHistoryReservation.md) | Reservation details if reason is reservation, reservation_release or reservation_termination. |  [optional]
**servicePackage** | [**ServicePackageQuotaHistoryServicePackage**](ServicePackageQuotaHistoryServicePackage.md) | Service package details if reason is package_creation, package_renewal or package_termination |  [optional]


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



