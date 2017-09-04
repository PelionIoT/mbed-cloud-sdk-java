
# ManifestContents

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**classId** | **String** | The device class&#39;s 128-bit RFC4122 GUID as a hexidecimal digit string |  [optional]
**vendorId** | **String** | The vendor&#39;s 128-bit RFC4122 GUID as a hexidecimal digit string |  [optional]
**manifestVersion** | **Integer** | The manifest format version |  [optional]
**description** | **String** | A short description of the update |  [optional]
**nonce** | **String** | A 128-bit random field. This is provided by the manifest tool to ensure that the signing algorithm is safe from timing side-channel attacks. |  [optional]
**timestamp** | **Integer** | The time the manifest was created. The timestamp is stored as Unix time. |  [optional]
**encryptionMode** | [**ManifestContentsEncryptionMode**](ManifestContentsEncryptionMode.md) |  |  [optional]
**applyImmediately** | **Boolean** | A flag that indicates whether the update described by the manifest should be applied as soon as possible |  [optional]
**deviceId** | **String** | The device&#39;s 128-bit RFC4122 GUID as a hexidecimal digit string. Each device has a single, unique device ID. |  [optional]
**payload** | [**ManifestContentsPayload**](ManifestContentsPayload.md) |  |  [optional]



