
# DeveloperCertificateResponseData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**securityFileContent** | **String** | Content of the security.c file that will be flashed into the device to provide the security credentials |  [optional]
**description** | **String** | Description for the developer certificate. |  [optional]
**name** | **String** | Name of the developer certificate. |  [optional]
**developerCertificate** | **String** | PEM format X.509 developer certificate. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**object** | **String** | Entity name, always &#39;trusted-cert&#39; |  [optional]
**developerPrivateKey** | **String** | PEM format developer private key associated to the certificate. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**id** | **String** | mUUID that uniquely identifies the developer certificate. |  [optional]
**accountId** | **String** | account to which the developer certificate belongs |  [optional]



