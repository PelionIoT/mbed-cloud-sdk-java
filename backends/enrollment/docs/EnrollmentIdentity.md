
# EnrollmentIdentity

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | muuid | 
**claimedAt** | [**DateTime**](DateTime.md) | The time of claiming the device to be assigned to the account. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The time of the enrollment identity creation. | 
**deviceId** | **String** | The ID of the device in the Device Directory once it has been registered. |  [optional]
**enrolledDeviceId** | **String** | Enrolled device internal ID |  [optional]
**enrollmentIdentity** | **String** | Enrollment identity. |  [optional]
**etag** | **String** |  | 
**expiresAt** | [**DateTime**](DateTime.md) | The enrollment claim expiration time. If the device does not connect to Mbed Cloud before the expiration, the claim is removed without a separate notice | 
**id** | **String** | Enrollment identity internal id | 
**object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ENROLLMENT | &quot;enrollment&quot;



