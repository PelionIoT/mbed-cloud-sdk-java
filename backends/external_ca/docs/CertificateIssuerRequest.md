
# CertificateIssuerRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | General description for the certificate issuer. |  [optional]
**issuerAttributes** | **Object** | General attributes for connecting the certificate issuer. When the issuer_type is GLOBAL_SIGN, the value shall be empty. When the issuer_type is CFSSL_AUTH, see definition of CfsslAttributes.  |  [optional]
**issuerCredentials** | **Object** | The credentials required for connecting to the certificate issuer. When the issuer_type is GLOBAL_SIGN, see definition of GlobalSignCredentials. When the issuer_type is CFSSL_AUTH, see definition of CfsslAuthCredentials.  |  [optional]
**issuerType** | [**IssuerTypeEnum**](#IssuerTypeEnum) | The type of the certificate issuer. - GLOBAL_SIGN:   Certificates are issued by GlobalSign service. The users must provide their own GlobalSign account credentials. - CFSSL_AUTH:   Certificates are issued by CFSSL authenticated signing service.   The users must provide their own CFSSL host_url and credentials.  | 
**name** | **String** | Certificate issuer name, unique per account. | 


<a name="IssuerTypeEnum"></a>
## Enum: IssuerTypeEnum
Name | Value
---- | -----
GLOBAL_SIGN | &quot;GLOBAL_SIGN&quot;
CFSSL_AUTH | &quot;CFSSL_AUTH&quot;



