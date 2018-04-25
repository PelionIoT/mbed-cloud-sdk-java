
# CertificateIssuerInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | **String** | Creation UTC time RFC3339. |  [optional]
**description** | **String** | General description for the certificate issuer. |  [optional]
**etag** | **String** | Entity instance signature. |  [optional]
**id** | **String** | The ID of the certificate issuer. |  [optional]
**issuerAttributes** | **Map&lt;String, String&gt;** | General attributes for connecting the certificate issuer. When the issuer_type is GLOBAL_SIGN, the value shall be empty.  |  [optional]
**issuerType** | [**IssuerTypeEnum**](#IssuerTypeEnum) | Type of certificate issuer. - GLOBAL_SIGN:   Certificates are issued by GlobalSign service. The users must provide their own GlobalSign account credentials.  | 
**name** | **String** | Certificate issuer name, unique per account. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]


<a name="IssuerTypeEnum"></a>
## Enum: IssuerTypeEnum
Name | Value
---- | -----
SIGN | &quot;GLOBAL_SIGN&quot;


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ISSUER | &quot;certificate-issuer&quot;



