
# EventTypeSummary

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **Integer** |  |  [optional]
**createdAt** | [**DateTime**](DateTime.md) |  |  [optional]
**id** | [**IdEnum**](#IdEnum) | ID of the event type description |  [optional]
**object** | **String** |  |  [optional]
**summaryStatus** | [**SummaryStatusEnum**](#SummaryStatusEnum) | The event type description. |  [optional]


<a name="IdEnum"></a>
## Enum: IdEnum
Name | Value
---- | -----
FAILED | &quot;failed&quot;
SUCCESS | &quot;success&quot;
PENDING | &quot;pending&quot;
SKIPPED | &quot;skipped&quot;


<a name="SummaryStatusEnum"></a>
## Enum: SummaryStatusEnum
Name | Value
---- | -----
FAILED | &quot;FAILED&quot;
SUCCESS | &quot;SUCCESS&quot;
PENDING | &quot;PENDING&quot;
SKIPPED | &quot;SKIPPED&quot;



