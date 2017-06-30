
# TrustedCertificateResp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**service** | [**ServiceEnum**](#ServiceEnum) | Service name where the certificate is to be used. | 
**status** | [**StatusEnum**](#StatusEnum) | Status of the certificate. |  [optional]
**description** | **String** | Human readable description of this certificate. |  [optional]
**certificate** | **String** | X509.v3 trusted certificate in PEM format. | 
**issuer** | **String** | Issuer of the certificate. | 
**deviceExecutionMode** | **Integer** | Device execution mode where 1 means a developer certificate. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;trusted-cert&#39; | 
**subject** | **String** | Subject of the certificate. | 
**accountId** | **String** | The UUID of the account. | 
**etag** | **String** | API resource entity version. | 
**validity** | [**DateTime**](DateTime.md) | Expiration time in UTC formatted as RFC3339. | 
**ownerId** | **String** | The UUID of the owner. |  [optional]
**id** | **String** | Entity ID. | 
**name** | **String** | Certificate name. | 


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
USER | &quot;user&quot;
API_KEY | &quot;api-key&quot;
GROUP | &quot;group&quot;
ACCOUNT | &quot;account&quot;
ACCOUNT_TEMPLATE | &quot;account-template&quot;
TRUSTED_CERT | &quot;trusted-cert&quot;
LIST | &quot;list&quot;
ERROR | &quot;error&quot;



