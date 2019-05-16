
# DeveloperCertificateResponseData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | Account to which the developer certificate belongs. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | Description for the developer certificate. |  [optional]
**developerCertificate** | **String** | PEM-format X.509 developer certificate. |  [optional]
**developerPrivateKey** | **String** | PEM-format developer private key associated with the certificate. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**id** | **String** | ID that uniquely identifies the developer certificate. |  [optional]
**name** | **String** | Name of the developer certificate. |  [optional]
**object** | **String** | Entity name: always &#x60;trusted-cert&#x60;. |  [optional]
**securityFileContent** | **String** | Content of the &#x60;security.c&#x60; file flashed to the device to provide security credentials. |  [optional]



