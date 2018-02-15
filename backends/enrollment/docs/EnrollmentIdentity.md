
# EnrollmentIdentity

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**enrollmentIdentity** | **String** | Enrollment identity. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]
**accountId** | **String** | muuid | 
**createdAt** | [**DateTime**](DateTime.md) | The time of the enrollment identity creation. | 
**claimedAt** | [**DateTime**](DateTime.md) | The time of claiming the device to be assigned to the account. |  [optional]
**expiresAt** | [**DateTime**](DateTime.md) | The enrollment claim expiration time. If the device does not connect to Mbed Cloud before the expiration, the claim is removed without a separate notice | 
**enrolledDeviceId** | **String** | Enrolled device internal ID |  [optional]
**etag** | **String** |  | 
**id** | **String** | Enrollment identity internal id | 
**deviceId** | **String** | The ID of the device in the Device Directory once it has been registered. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ENROLLMENT | &quot;enrollment&quot;



