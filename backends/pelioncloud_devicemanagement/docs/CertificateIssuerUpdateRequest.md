
# CertificateIssuerUpdateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | General description of the certificate issuer. |  [optional]
**issuerAttributes** | **Map&lt;String, String&gt;** | General attributes for connecting the certificate issuer. When the issuer_type is GLOBAL_SIGN, the value shall be empty. When the issuer_type is CFSSL_AUTH, see definition of CfsslAttributes.  |  [optional]
**issuerCredentials** | **Map&lt;String, String&gt;** | The credentials required for connecting to the certificate issuer. When the issuer_type is GLOBAL_SIGN, see definition of GlobalSignCredentials. When the issuer_type is CFSSL_AUTH, see definition of CfsslAuthCredentials.  |  [optional]
**name** | **String** | Certificate issuer name. |  [optional]



