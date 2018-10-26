
# CertificateEnrollmentListResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The entity ID to fetch after the given one. |  [optional]
**data** | [**List&lt;CertificateEnrollment&gt;**](CertificateEnrollment.md) | List of certificate enrollments. |  [optional]
**hasMore** | **Boolean** | Flag indicating whether there are more results. |  [optional]
**limit** | **Integer** | The number of results to return. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Describes the type of objects in the list. |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | The order of the records to return based on creation time. By default ASC. |  [optional]
**totalCount** | **Integer** | The total number of records. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
LIST | &quot;list&quot;


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;



