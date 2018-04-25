
# CertificateIssuerUpdateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | General description for the certificate issuer. |  [optional]
**issuerAttributes** | **Object** | General attributes for connecting the certificate issuer. When the issuer_type is GLOBAL_SIGN, the value shall be empty.  |  [optional]
**issuerCredentials** | **Object** | Credentials required for connecting to the certificate issuer. When issuer_type is GLOBAL_SIGN, see definition of GlobalSignCredentials.  |  [optional]
**name** | **String** | Certificate issuer name. |  [optional]



