
# ReportResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | [**ReportAccountContactInfo**](ReportAccountContactInfo.md) | Account contact information. | 
**aggregated** | [**ReportBillingData**](ReportBillingData.md) | Aggregated report billing data including all subtenant accounts if any. | 
**billingData** | [**ReportBillingData**](ReportBillingData.md) | Report billing data. | 
**id** | **String** | Billing report id. | 
**month** | **String** | Month of requested billing report | 
**object** | [**ObjectEnum**](#ObjectEnum) | Billing report response object. Always set to &#39;billing-report&#39;. | 
**servicePackage** | [**ServicePackageReport**](ServicePackageReport.md) | Report service package. |  [optional]
**subtenants** | [**List&lt;SubtenantAccountReport&gt;**](SubtenantAccountReport.md) | List of billing reports for subtenant accounts. Empty list if account does not have any subtenant account. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
REPORT | &quot;billing-report&quot;



