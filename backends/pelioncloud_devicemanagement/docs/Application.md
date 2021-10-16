
# Application

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The ID of the account. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | The description of the application. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**groups** | **List&lt;String&gt;** | A list of group IDs this application belongs to. |  [optional]
**id** | **String** | The ID of the application. |  [optional]
**lastUsedAt** | [**DateTime**](DateTime.md) | The time of the latest application usage. |  [optional]
**name** | **String** | The display name for the application. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;application&#39; |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the application. When admin sets the application as inactive all related data and configurations are cleared from the system. If application is activated again, client must open new channels and set new subscriptions to start receiving events again. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
APPLICATION | &quot;application&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



