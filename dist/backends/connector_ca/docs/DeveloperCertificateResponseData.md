
# DeveloperCertificateResponseData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**securityFileContent** | **String** | The content of the &#x60;security.c&#x60; file that is flashed into the device to provide the security credentials |  [optional]
**description** | **String** | Description for the developer certificate. |  [optional]
**name** | **String** | The name of the developer certificate. |  [optional]
**developerCertificate** | **String** | The PEM format X.509 developer certificate. |  [optional]
**serverUri** | **String** | The URI to which the client needs to connect to. |  [optional]
**createdAt** | **String** | Creation UTC time RFC3339. |  [optional]
**object** | **String** | Entity name, always &#x60;trusted-cert&#x60;. |  [optional]
**developerPrivateKey** | **String** | The PEM format developer private key associated to the certificate. |  [optional]
**serverCertificate** | **String** | The PEM format X.509 server certificate that is used to validate the server certificate that is received during the TLS/DTLS handshake. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**id** | **String** | The mUUID that uniquely identifies the developer certificate. |  [optional]
**accountId** | **String** | The account to which the developer certificate belongs. |  [optional]



