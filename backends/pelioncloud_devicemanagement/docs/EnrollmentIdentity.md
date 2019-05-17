
# EnrollmentIdentity

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | ID | 
**claimedAt** | [**DateTime**](DateTime.md) | The time the device was claimed. | 
**createdAt** | [**DateTime**](DateTime.md) | The time of the enrollment identity creation. | 
**enrolledDeviceId** | **String** | The ID of the device in the Device Directory once it is registered. | 
**enrollmentIdentity** | **String** | Enrollment identity. | 
**etag** | **String** |  | 
**expiresAt** | [**DateTime**](DateTime.md) | The enrollment claim expiration time. If the device does not connect to Device Management before expiration, the claim is removed without separate notice. | 
**id** | **String** | Enrollment identity. | 
**object** | [**ObjectEnum**](#ObjectEnum) |  | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ENROLLMENT | &quot;enrollment&quot;



