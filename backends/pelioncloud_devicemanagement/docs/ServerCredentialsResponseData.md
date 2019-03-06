
# ServerCredentialsResponseData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**id** | **String** | ID that uniquely identifies the entity. |  [optional]
**object** | **String** | Entity name, always &#39;server-credentials&#39; |  [optional]
**serverCertificate** | **String** | PEM format X.509 server certificate that will be used to validate the server certificate that will be received during the TLS/DTLS handshake. |  [optional]
**serverUri** | **String** | Server URI to which the client needs to connect to. |  [optional]



