
# UploadChunkInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**DateTime**](DateTime.md) | The time the entity was created |  [optional]
**etag** | **String** | API resource entity version |  [optional]
**hash** | **String** | The hash of the chunk. The default hash is MD5. If no Content-MD5 header is supplied as part of uploading the chunk then this will be empty. |  [optional]
**id** | **Integer** | The chunk number |  [optional]
**length** | **Integer** | The length of the chunk |  [optional]
**object** | **String** | Entity name: always &#39;upload-info&#39; |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | The time the entity was updated |  [optional]
**uploadJobId** | **String** | The upload job ID. |  [optional]



