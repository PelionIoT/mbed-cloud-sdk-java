
# TrustedCertificateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) | Status of the certificate. |  [optional]
**certificate** | **String** | X509.v3 trusted certificate in PEM format. | 
**name** | **String** | Certificate name, not longer than 100 characters. | 
**service** | [**ServiceEnum**](#ServiceEnum) | Service name where the certificate must be used. | 
**signature** | **String** | Base64 encoded signature of the account ID signed by the certificate to be uploaded. Signature must be hashed with SHA256. | 
**description** | **String** | Human readable description of this certificate, not longer than 500 characters. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;


<a name="ServiceEnum"></a>
## Enum: ServiceEnum
Name | Value
---- | -----
LWM2M | &quot;lwm2m&quot;
BOOTSTRAP | &quot;bootstrap&quot;



