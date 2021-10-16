
# ReportResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | [**ReportAccountContactInfo**](ReportAccountContactInfo.md) | Account contact information. | 
**aggregated** | [**ReportBillingData**](ReportBillingData.md) | Aggregated report billing data including all tenant accounts, if any. |  [optional]
**billingData** | [**ReportBillingData**](ReportBillingData.md) | Report billing data. | 
**id** | **String** | Billing report ID. | 
**month** | **String** | Month of requested billing report. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Billing report response object. Always set to &#x60;billing-report&#x60;. | 
**servicePackage** | [**ServicePackageReport**](ServicePackageReport.md) | Service package report. |  [optional]
**subtenants** | [**List&lt;SubtenantAccountReport&gt;**](SubtenantAccountReport.md) | List of billing reports for tenant accounts. Empty list if account does not have any tenant account. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
REPORT | &quot;billing-report&quot;



