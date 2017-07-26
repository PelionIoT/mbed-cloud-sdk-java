
# ManifestContents

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**classId** | **String** | Hex representation of the 128-bit RFC4122 GUID that represents the device class that the update targets. |  [optional]
**vendorId** | **String** | Hex representation of the 128-bit RFC4122 GUID that represents the vendor. |  [optional]
**manifestVersion** | **String** | The version of the manifest format being used. |  [optional]
**description** | **String** | A short description of the update. |  [optional]
**nonce** | **String** | A 128-bit random field |  [optional]
**timestamp** | **Integer** | The time the manifest was created. The timestamp is stored as Unix time. |  [optional]
**encryptionMode** | [**ManifestContentsEncryptionMode**](ManifestContentsEncryptionMode.md) |  |  [optional]
**applyImmediately** | **Boolean** | A flag that indicates that the update described by the manifest should be applied as soon as possible. |  [optional]
**deviceId** | **String** | Hex representation of the 128-bit RFC4122 GUID that uniquely identifies the device. Each device has a single, unique device ID. |  [optional]
**payload** | [**ManifestContentsPayload**](ManifestContentsPayload.md) |  |  [optional]



