
# CertificateIssuerConfigListResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The entity ID to fetch after current result set. |  [optional]
**data** | [**List&lt;CertificateIssuerConfigResponse&gt;**](CertificateIssuerConfigResponse.md) | List of certificate issuers. |  [optional]
**limit** | **Integer** | The number of results returned. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Describes the type of objects in the list. |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | The order of results. |  [optional]
**totalCount** | **Integer** | The total number or records. |  [optional]


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



