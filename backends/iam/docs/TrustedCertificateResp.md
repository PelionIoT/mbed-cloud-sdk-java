
# TrustedCertificateResp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**service** | [**ServiceEnum**](#ServiceEnum) | Service name where the certificate is to be used. | 
**status** | [**StatusEnum**](#StatusEnum) | Status of the certificate. |  [optional]
**name** | **String** | Certificate name. | 
**certificate** | **String** | X509.v3 trusted certificate in PEM format. | 
**enrollmentMode** | **Boolean** | If true, signature is not required. Default value false. |  [optional]
**issuer** | **String** | Issuer of the certificate. | 
**deviceExecutionMode** | **Integer** | Device execution mode where 1 means a developer certificate. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;trusted-cert&#39; | 
**subject** | **String** | Subject of the certificate. | 
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]
**accountId** | **String** | The UUID of the account. | 
**etag** | **String** | API resource entity version. | 
**validity** | [**DateTime**](DateTime.md) | Expiration time in UTC formatted as RFC3339. | 
**ownerId** | **String** | The UUID of the owner. |  [optional]
**id** | **String** | Entity ID. | 
**description** | **String** | Human readable description of this certificate. |  [optional]


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


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
CERT | &quot;trusted-cert&quot;



