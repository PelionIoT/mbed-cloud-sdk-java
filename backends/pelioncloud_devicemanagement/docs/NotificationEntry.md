
# NotificationEntry

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The ID of the account. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**errorMsg** | **String** | The error message if there was an error while transmitting the account notification. |  [optional]
**etag** | **String** | API resource entity version. | 
**id** | **String** | Entity ID. | 
**message** | **String** | The message contained in this account notification entry. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;notification-entry&#39; | 
**receiver** | **String** | The receiver this account notification entry. |  [optional]
**subject** | **String** | The subject of this account notification entry. |  [optional]
**success** | **Boolean** | A flag indiciating whether the sending of this account notification entry was successful, true or false. |  [optional]
**type** | **String** | The type of this account notification entry. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ENTRY | &quot;notification-entry&quot;



