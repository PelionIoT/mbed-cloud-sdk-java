
# DeveloperCertificateResponseData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | account to which the developer certificate belongs |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | Description for the developer certificate. |  [optional]
**developerCertificate** | **String** | PEM format X.509 developer certificate. |  [optional]
**developerPrivateKey** | **String** | PEM format developer private key associated to the certificate. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**id** | **String** | ID that uniquely identifies the developer certificate. |  [optional]
**name** | **String** | Name of the developer certificate. |  [optional]
**object** | **String** | Entity name, always &#39;trusted-cert&#39; |  [optional]
**securityFileContent** | **String** | Content of the security.c file that will be flashed into the device to provide the security credentials |  [optional]



