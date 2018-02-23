
# TrustedCertificateUpdateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) | Status of the certificate. |  [optional]
**enrollmentMode** | **Boolean** | If true, signature parameter is not required. Default value is false. |  [optional]
**certificate** | **String** | X509.v3 trusted certificate in PEM format. |  [optional]
**name** | **String** | Certificate name, not longer than 100 characters. |  [optional]
**service** | [**ServiceEnum**](#ServiceEnum) | Service name where the certificate must be used. |  [optional]
**signature** | **String** | Base64 encoded signature of the account ID signed by the certificate whose data to be updated. Signature must be hashed with SHA256. |  [optional]
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



