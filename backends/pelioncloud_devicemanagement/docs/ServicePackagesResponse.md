
# ServicePackagesResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | [**ActiveServicePackage**](ActiveServicePackage.md) | Currently active service package. Can be null. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Always set to &#x60;service-packages&#x60;. | 
**pending** | [**PendingServicePackage**](PendingServicePackage.md) | Current pending service package. Can be null. |  [optional]
**previous** | [**List&lt;PreviousServicePackage&gt;**](PreviousServicePackage.md) | List of previous service packages. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
PACKAGES | &quot;service-packages&quot;



