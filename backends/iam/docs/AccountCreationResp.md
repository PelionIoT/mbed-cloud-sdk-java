
# AccountCreationResp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**endMarket** | **String** | The end market of the account to be created. | 
**adminId** | **String** | The ID of the admin user created. | 
**email** | **String** | The company email address for this account, not longer than 254 characters. Required for commercial accounts only. |  [optional]
**adminName** | **String** | The username of the admin user to be created, containing alphanumerical letters and -,._@+&#x3D; characters. It must be at least 4 but not more than 30 character long. |  [optional]
**postalCode** | **String** | The postal code part of the postal address, not longer than 100 characters. |  [optional]
**id** | **String** | Account ID. | 
**aliases** | **List&lt;String&gt;** | An array of aliases, not more than 10. An alias is not shorter than 8 and not longer than 100 characters. |  [optional]
**addressLine2** | **String** | Postal address line 2, not longer than 100 characters. |  [optional]
**city** | **String** | The city part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**addressLine1** | **String** | Postal address line 1, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**displayName** | **String** | The display name for the account, not longer than 100 characters. |  [optional]
**state** | **String** | The state part of the postal address, not longer than 100 characters. |  [optional]
**adminPassword** | **String** | The password when creating a new user. It will be generated when not present in the request. |  [optional]
**contractNumber** | **String** | Contract number of the customer. |  [optional]
**phoneNumber** | **String** | The phone number of a representative of the company, not longer than 100 characters. |  [optional]
**company** | **String** | The name of the company, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**adminKey** | **String** | The admin API key created for the account. |  [optional]
**adminFullName** | **String** | The full name of the admin user to be created. |  [optional]
**country** | **String** | The country part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**customerNumber** | **String** | Customer number of the customer. |  [optional]
**contact** | **String** | The name of the contact person for this account, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**adminEmail** | **String** | The email address of the account admin, not longer than 254 characters. |  [optional]


