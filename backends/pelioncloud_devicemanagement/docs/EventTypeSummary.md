
# EventTypeSummary

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**campaignId** | **String** | ID of the associated campaign. |  [optional]
**count** | **Integer** |  |  [optional]
**createdAt** | [**DateTime**](DateTime.md) |  |  [optional]
**id** | [**IdEnum**](#IdEnum) | ID of the event type description |  [optional]
**object** | **String** |  |  [optional]
**summaryStatus** | [**SummaryStatusEnum**](#SummaryStatusEnum) | The event type description. |  [optional]


<a name="IdEnum"></a>
## Enum: IdEnum
Name | Value
---- | -----
FAIL | &quot;fail&quot;
SUCCESS | &quot;success&quot;
INFO | &quot;info&quot;
SKIPPED | &quot;skipped&quot;


<a name="SummaryStatusEnum"></a>
## Enum: SummaryStatusEnum
Name | Value
---- | -----
FAIL | &quot;FAIL&quot;
SUCCESS | &quot;SUCCESS&quot;
INFO | &quot;INFO&quot;
SKIPPED | &quot;SKIPPED&quot;



