
# Resource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rt** | **String** | Application specific resource type that describes this resource. [It is created by the client side application](/docs/v1.2/collecting/resource-setup-in-mbed-cloud-client.html). Not meant to be a human-readable name for the resource. Multiple resource types may be included, they are separated by a space. |  [optional]
**type** | **String** | The content type of the resource. &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Important&lt;/b&gt;&lt;br/&gt; You are encouraged to use the resource types listed in the [LwM2M specification](http://technical.openmobilealliance.org/Technical/technical-information/omna/lightweight-m2m-lwm2m-object-registry).  |  [optional]
**uri** | **String** | The URL of the resource. | 
**obs** | **Boolean** | Observable determines whether you can subscribe to changes for this resource. It can have values \&quot;true\&quot; or \&quot;false\&quot;.  |  [optional]



