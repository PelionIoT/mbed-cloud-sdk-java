
# TrustedCertificateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**certificate** | **String** | A chain of X509.v3 trusted certificates in PEM format. The chain must contain all certificates from root to leaf. Otherwise, the signature parameter is required. | 
**description** | **String** | Human readable description of this certificate, not longer than 500 characters. |  [optional]
**enrollmentMode** | **Boolean** | Certificate is used in enrollment mode. Default value is false. |  [optional]
**name** | **String** | Certificate name, not longer than 100 characters. | 
**service** | [**ServiceEnum**](#ServiceEnum) | Service name where the certificate must be used. | 
**signature** | **String** | DEPRECATED: Base64 encoded signature of the account ID signed by the certificate to be uploaded. The signature must be hashed with SHA256. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of the certificate. |  [optional]


<a name="ServiceEnum"></a>
## Enum: ServiceEnum
Name | Value
---- | -----
LWM2M | &quot;lwm2m&quot;
BOOTSTRAP | &quot;bootstrap&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



