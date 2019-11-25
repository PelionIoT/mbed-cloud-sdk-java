
# SerializationConfigObjectV2

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deregistrationsAsObject** | **Boolean** | Defines serialization format for &#39;de-registrations&#39; and &#39;registrations-expired&#39;. If set to true, de-registration and registration-expired messages will be represented as json objects and can have additional fields: &#39;uid&#39;, &#39;timestamp&#39;, &#39;original-ep&#39;, together with the &#39;ep&#39; field. If set to false, (default) - de-registration and &#39;registration-expired&#39; will be represented by a string, containing only data from &#39;ep&#39; field.  |  [optional]
**includeOriginalEp** | **Boolean** | Include &#39;original-ep&#39; message field in serialized objects. This is the endpoint_name from the device.  |  [optional]
**includeTimestamp** | **Boolean** | Include &#39;timestamp&#39; message field in serialized objects. The timestamp represents the time that the notification service receives the message and sorts it into the queue. Timestamp provides information of queue length (web-app current time - timestamp &#x3D; delay).  |  [optional]
**includeUid** | **Boolean** | Include &#39;uid&#39; message field to serialized objects. This is message ID, and can be used for duplicate detection.  |  [optional]



