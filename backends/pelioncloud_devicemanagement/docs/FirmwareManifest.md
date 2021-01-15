
# FirmwareManifest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**DateTime**](DateTime.md) | The time the entity was created. |  [optional]
**datafile** | **String** | The URL of the ASN.1 DER-encoded firmware manifest binary. |  [optional]
**datafileSize** | **Long** | The size of the firmware manifest in bytes. |  [optional]
**deliveredPayloadDigest** | **String** | Digest (SHA256, hex-encoded) of the payload to deliver to the device. |  [optional]
**deliveredPayloadSize** | **Long** | The size in bytes of the payload to deliver to the device. |  [optional]
**deliveredPayloadType** | [**DeliveredPayloadTypeEnum**](#DeliveredPayloadTypeEnum) | Type of the payload to deliver to the device (full or delta image). |  [optional]
**deliveredPayloadUrl** | **String** | The URL of the payload to deliver to the device. |  [optional]
**description** | **String** | The description of the firmware manifest. |  [optional]
**deviceClass** | [**UUID**](UUID.md) | The device class ID. |  [optional]
**deviceVendor** | [**UUID**](UUID.md) | The device vendor ID. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**id** | **String** | The firmware manifest ID. |  [optional]
**keyTable** | **String** | The key table of pre-shared keys for devices. |  [optional]
**manifestSchemaVersion** | [**ManifestSchemaVersionEnum**](#ManifestSchemaVersionEnum) | Version of the manifest schema (1 or 3). |  [optional]
**name** | **String** | The name of the manifest. |  [optional]
**object** | **String** | Entity name: always &#39;firmware-manifest&#39;. |  [optional]
**parsedRawManifest** | **Object** | Raw manifest in JSON format, parsed from ASN.1 DER encoding. Fields may change. Backwards compatibility is not guaranteed. Recommended for debugging only.  |  [optional]
**precursorPayloadDigest** | **String** | Digest (SHA256, hex-encoded) of the currently installed payload. |  [optional]
**timestamp** | [**DateTime**](DateTime.md) | The firmware manifest version as a timestamp. |  [optional]
**updatePriority** | **Long** | Update priority, passed to the application callback when an update is performed. Allows the application to make application-specific decisions. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | The time the entity was updated. |  [optional]


<a name="DeliveredPayloadTypeEnum"></a>
## Enum: DeliveredPayloadTypeEnum
Name | Value
---- | -----
FULL | &quot;full&quot;
DELTA | &quot;delta&quot;


<a name="ManifestSchemaVersionEnum"></a>
## Enum: ManifestSchemaVersionEnum
Name | Value
---- | -----
_1 | &quot;1&quot;
_3 | &quot;3&quot;



