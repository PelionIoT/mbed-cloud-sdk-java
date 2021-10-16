
# Resource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**obs** | **Boolean** | &#39;Determines whether you can subscribe to changes for this resource. It can have values &#x60;true&#x60; or &#x60;false&#x60;.&#39; |  [optional]
**rt** | **String** | Application-specific resource type that describes this resource, created by the [client application](https://developer.pelion.com/docs/device-management/current/resources/resource-setup-in-device-management-client.html). Not meant to be a human-readable name for the resource. Multiple resource types may be included, separated by a space. |  [optional]
**type** | **String** | The content type of the resource.  We recommend you use the content types listed in the [LwM2M specification](http://www.openmobilealliance.org/wp/omna/lwm2m/lwm2mregistry.html). |  [optional]
**uri** | **String** | The resource URL. This can be the path to:  - An object; for example, &#x60;3303&#x60;. - An object instance; for example &#x60;3303/0&#x60;. - A resource; for example &#x60;3303/0/5602&#x60;.  For more information about the Device Management resource model, please see the [Device Management documentation](https://developer.pelion.com/docs/device-management/current/resources/resource-model.html). | 



