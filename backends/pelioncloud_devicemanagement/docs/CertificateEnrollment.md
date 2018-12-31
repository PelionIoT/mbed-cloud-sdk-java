
# CertificateEnrollment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**certificateName** | **String** | The certificate name. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. | 
**deviceId** | **String** | The device ID. | 
**enrollResult** | [**EnrollResultEnum**](#EnrollResultEnum) |  |  [optional]
**enrollStatus** | [**EnrollStatusEnum**](#EnrollStatusEnum) |  |  [optional]
**etag** | **String** | Entity instance signature. | 
**id** | **String** | The ID of the certificate enrollment. | 
**object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Update UTC time RFC3339. |  [optional]


<a name="EnrollResultEnum"></a>
## Enum: EnrollResultEnum
Name | Value
---- | -----
SUCCESS | &quot;success&quot;
NOT_FOUND | &quot;not_found&quot;
FORBIDDEN | &quot;forbidden&quot;
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



