
# GlobalSignCredentials

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**apiKey** | **String** | Unique ID for API client (provided by GlobalSign). | 
**apiSecret** | **String** | API secret matching the API key (provided by GlobalSign). | 
**clientCertificate** | **String** | The client certificate provided by GlobalSign to allow HTTPS connection over TLS/SSL. The certificate wraps a public key that matches a private key provided by the customer. The certificate must be in PEM format. | 
**passphrase** | **String** | The passphrase to decrypt the private key in case it is encrypted. Empty if the private key is not encrypted. |  [optional]
**privateKey** | **String** | The private key that matches the client certificate to allow HTTPS connection over TLS/SSL. The private key may be encrypted using a symmetric encryption key derived from a passphrase. The private key must be in PEM format. | 



