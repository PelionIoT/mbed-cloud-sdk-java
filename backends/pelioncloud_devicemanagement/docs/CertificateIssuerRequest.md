
# CertificateIssuerRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | General description of the certificate issuer. |  [optional]
**issuerAttributes** | **Map&lt;String, String&gt;** | General attributes for connecting the certificate issuer. When the issuer_type is GLOBAL_SIGN, the value is empty. When the issuer_type is CFSSL_AUTH, see definition of CfsslAttributes. |  [optional]
**issuerCredentials** | **Map&lt;String, String&gt;** | The credentials required to connect to the certificate issuer. When the issuer_type is GLOBAL_SIGN, see definition of GlobalSignCredentials. When the issuer_type is CFSSL_AUTH, see definition of CfsslAuthCredentials. | 
**issuerType** | [**IssuerTypeEnum**](#IssuerTypeEnum) | Certificate issuer type. - GLOBAL_SIGN:   Certificates are issued by GlobalSign service. You must provide your own GlobalSign account credentials. - CFSSL_AUTH:   Certificates are issued by CFSSL authenticated signing service.   You must provide your own CFSSL host_url and credentials. | 
**name** | **String** | Certificate issuer name, unique per account. | 


<a name="IssuerTypeEnum"></a>
## Enum: IssuerTypeEnum
Name | Value
---- | -----
GLOBAL_SIGN | &quot;GLOBAL_SIGN&quot;
CFSSL_AUTH | &quot;CFSSL_AUTH&quot;



