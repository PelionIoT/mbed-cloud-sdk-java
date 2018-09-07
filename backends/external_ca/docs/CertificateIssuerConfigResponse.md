
# CertificateIssuerConfigResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**certificateIssuerId** | **String** | The ID of the certificate issuer. Null if Device Management internal HSM is used.  |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Created UTC time RFC3339. |  [optional]
**etag** | **String** | Entity instance signature. |  [optional]
**id** | **String** | The ID of the certificate issuer configuration.  |  [optional]
**isCustom** | **Boolean** |  |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]
**reference** | **String** | The certificate name to which the certificate issuer configuration applies. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Updated UTC time RFC3339. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
CONFIGURATION | &quot;certificate-issuer-configuration&quot;



