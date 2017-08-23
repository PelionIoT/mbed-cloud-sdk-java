
# UserUpdateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**phoneNumber** | **String** | Phone number, not longer than 100 characters. |  [optional]
**username** | **String** | A username containing alphanumerical letters and -,._@+&#x3D; characters. It must be at least 4 but not more than 30 character long. |  [optional]
**isMarketingAccepted** | **Boolean** | A flag indicating that receiving marketing information has been accepted. |  [optional]
**isGtcAccepted** | **Boolean** | A flag indicating that the General Terms and Conditions has been accepted. |  [optional]
**isTotpEnabled** | **Boolean** | A flag indicating whether 2-factor authentication (TOTP) has to be enabled or disabled. |  [optional]
**status** | **String** | The status of the user. |  [optional]
**fullName** | **String** | The full name of the user, not longer than 100 characters. |  [optional]
**address** | **String** | Address, not longer than 100 characters. |  [optional]
**password** | **String** | The password when creating a new user. It will will generated when not present in the request. |  [optional]
**email** | **String** | The email address, not longer than 254 characters. | 



