
# TrustedCertificateInternalResp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The ID of the account. | 
**certificate** | **String** | X509.v3 trusted certificate in PEM format. | 
**certificateFingerprint** | **String** | A SHA-256 fingerprint of the certificate. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | Human readable description of this certificate. |  [optional]
**deviceExecutionMode** | **Integer** | Device execution mode where 1 means a developer certificate. |  [optional]
**enrollmentMode** | **Boolean** | If true, signature is not required. Default value false. |  [optional]
**etag** | **String** | API resource entity version. | 
**id** | **String** | Entity ID. | 
**issuer** | **String** | Issuer of the certificate. | 
**name** | **String** | Certificate name. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;trusted-cert&#39; | 
**ownerId** | **String** | The ID of the owner. |  [optional]
**privateKey** | **String** | Private key of the certificate in PEM or base64 encoded DER format. | 
**service** | [**ServiceEnum**](#ServiceEnum) | Service name where the certificate is to be used. | 
**status** | [**StatusEnum**](#StatusEnum) | Status of the certificate. |  [optional]
**subject** | **String** | Subject of the certificate. | 
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]
**validity** | [**DateTime**](DateTime.md) | Expiration time in UTC formatted as RFC3339. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
CERT | &quot;trusted-cert&quot;


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



