
# CertificateEnrollment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**certificateName** | **String** | The certificate name. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. | 
**deviceId** | **String** | The device ID. | 
**enrollResult** | [**EnrollResultEnum**](#EnrollResultEnum) | The result of certificate enrollment request. |  [optional]
**enrollResultDetail** | **String** | Additional information in case of failure. |  [optional]
**enrollStatus** | [**EnrollStatusEnum**](#EnrollStatusEnum) | The status of certificate enrollment request. |  [optional]
**etag** | **String** | Entity instance signature. | 
**id** | **String** | The certificate enrollment ID. | 
**object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Update UTC time RFC3339. |  [optional]


<a name="EnrollResultEnum"></a>
## Enum: EnrollResultEnum
Name | Value
---- | -----
SUCCESS | &quot;success&quot;
FAILURE | &quot;failure&quot;


<a name="EnrollStatusEnum"></a>
## Enum: EnrollStatusEnum
Name | Value
---- | -----
NEW | &quot;new&quot;
COMPLETED | &quot;completed&quot;


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ENROLLMENT | &quot;certificate-enrollment&quot;



