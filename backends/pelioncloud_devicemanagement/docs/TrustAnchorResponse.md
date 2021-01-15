
# TrustAnchorResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time. |  [optional]
**description** | **String** | The updated notes about the trust anchor. |  [optional]
**etag** | **String** | Entity instance signature, 1 or Unix timestamp of last customer update. |  [optional]
**fingerprint** | **byte[]** | The SHA256 of the trust anchor public key; the prefix &#39;mbed.ta.&#39; followed by the trust anchor public key as a SHA256 hash in Base64-encoded DER format. |  [optional]
**id** | **String** | The ID of the entity. |  [optional]
**object** | **String** | The API resource entity |  [optional]
**publicKey** | **byte[]** | The trust anchor public key in PEM format. |  [optional]
**publicKeyDer** | **byte[]** | The generated trust anchor public key in Base64-encoded DER format. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Update UTC time. |  [optional]



