
# BulkResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | ID | 
**completedAt** | [**DateTime**](DateTime.md) | The time of completing the bulk creation task.  |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The time of receiving the bulk creation task.  | 
**errorsCount** | **Integer** | The number of enrollment identities with failed processing.  | 
**errorsReportFile** | **String** |  |  [optional]
**etag** | **String** | etag | 
**fullReportFile** | **String** |  |  [optional]
**id** | **String** | Bulk ID | 
**object** | [**ObjectEnum**](#ObjectEnum) |  | 
**processedCount** | **Integer** | The number of enrollment identities processed until now.  | 
**status** | [**StatusEnum**](#StatusEnum) | The state of the process is &#39;new&#39; at the time of creation. If the creation is still in progress, the state is shown as &#39;processing&#39;. When the request has been fully processed, the state changes to &#39;completed&#39;.  | 
**totalCount** | **Integer** | Total number of enrollment identities found in the input CSV.  | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
UPLOADS | &quot;enrollment-identity-bulk-uploads&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NEW | &quot;new&quot;
PROCESSING | &quot;processing&quot;
COMPLETED | &quot;completed&quot;



