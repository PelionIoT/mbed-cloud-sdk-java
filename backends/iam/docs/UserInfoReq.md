
# UserInfoReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address** | **String** | Address, not longer than 100 characters. |  [optional]
**email** | **String** | The email address, not longer than 254 characters. | 
**fullName** | **String** | The full name of the user, not longer than 100 characters. |  [optional]
**groups** | **List&lt;String&gt;** | A list of IDs of the groups this user belongs to. |  [optional]
**isGtcAccepted** | **Boolean** | A flag indicating that the General Terms and Conditions has been accepted. |  [optional]
**isMarketingAccepted** | **Boolean** | A flag indicating that receiving marketing information has been accepted. |  [optional]
**password** | **String** | The password when creating a new user. It will be generated when not present in the request. |  [optional]
**phoneNumber** | **String** | Phone number, not longer than 100 characters. |  [optional]
**userProperties** | [**Map&lt;String, Map&lt;String, String&gt;&gt;**](Map.md) | User&#39;s account specific custom properties. |  [optional]
**username** | **String** | A username containing alphanumerical letters and -,._@+&#x3D; characters. It must be at least 4 but not more than 30 character long. |  [optional]



