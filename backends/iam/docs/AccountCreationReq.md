
# AccountCreationReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressLine1** | **String** | Postal address line 1, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**addressLine2** | **String** | Postal address line 2, not longer than 100 characters. |  [optional]
**adminEmail** | **String** | The email address of the account admin, not longer than 254 characters. |  [optional]
**adminFullName** | **String** | The full name of the admin user to be created. |  [optional]
**adminName** | **String** | The username of the admin user to be created, containing alphanumerical letters and -,._@+&#x3D; characters. It must be at least 4 but not more than 30 character long. |  [optional]
**adminPassword** | **String** | The password when creating a new user. It will be generated when not present in the request. |  [optional]
**aliases** | **List&lt;String&gt;** | An array of aliases, not more than 10. An alias is not shorter than 8 and not longer than 100 characters. |  [optional]
**city** | **String** | The city part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**company** | **String** | The name of the company, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**contact** | **String** | The name of the contact person for this account, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**contractNumber** | **String** | Contract number of the customer. |  [optional]
**country** | **String** | The country part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**customerNumber** | **String** | Customer number of the customer. |  [optional]
**displayName** | **String** | The display name for the account, not longer than 100 characters. |  [optional]
**email** | **String** | The company email address for this account, not longer than 254 characters. Required for commercial accounts only. |  [optional]
**endMarket** | **String** | The end market of the account to be created. | 
**phoneNumber** | **String** | The phone number of a representative of the company, not longer than 100 characters. |  [optional]
**postalCode** | **String** | The postal code part of the postal address, not longer than 100 characters. |  [optional]
**state** | **String** | The state part of the postal address, not longer than 100 characters. |  [optional]



