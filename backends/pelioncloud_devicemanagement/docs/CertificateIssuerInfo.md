
# CertificateIssuerInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | General description for the certificate issuer. |  [optional]
**etag** | **String** | Entity instance signature. |  [optional]
**id** | **String** | Certificate issuer ID. |  [optional]
**issuerAttributes** | **Map&lt;String, String&gt;** | General attributes for connecting the certificate issuer. When the issuer_type is GLOBAL_SIGN, the value is empty. When the issuer_type is CFSSL_AUTH, see definition of CfsslAttributes. |  [optional]
**issuerType** | [**IssuerTypeEnum**](#IssuerTypeEnum) | Certificate issuer type. - GLOBAL_SIGN:   Certificates are issued by GlobalSign service. You must provide your own GlobalSign account credentials. - CFSSL_AUTH:   Certificates are issued by CFSSL authenticated signing service.   You must provide your own CFSSL host_url and credentials. | 
**name** | **String** | Certificate issuer name, unique per account. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]


<a name="IssuerTypeEnum"></a>
## Enum: IssuerTypeEnum
Name | Value
---- | -----
GLOBAL_SIGN | &quot;GLOBAL_SIGN&quot;
CFSSL_AUTH | &quot;CFSSL_AUTH&quot;


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ISSUER | &quot;certificate-issuer&quot;



