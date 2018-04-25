
# CertificateIssuerRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | General description for the certificate issuer. |  [optional]
**issuerAttributes** | **Object** | General attributes for connecting the certificate issuer. When the issuer_type is GLOBAL_SIGN, the value shall be empty.  |  [optional]
**issuerCredentials** | **Object** | Credentials required for connecting to the certificate issuer. When the issuer_type is GLOBAL_SIGN, see definition of GlobalSignCredentials.  |  [optional]
**issuerType** | [**IssuerTypeEnum**](#IssuerTypeEnum) | Type of certificate issuer. - GLOBAL_SIGN:   Certificates are issued by GlobalSign service. The users must provide their own GlobalSign account credentials.  | 
**name** | **String** | Certificate issuer name, unique per account. | 


<a name="IssuerTypeEnum"></a>
## Enum: IssuerTypeEnum
Name | Value
---- | -----
SIGN | &quot;GLOBAL_SIGN&quot;



