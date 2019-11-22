
# IdentityProviderInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The ID of the account the identity provider belongs to. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | Description for the identity provider. |  [optional]
**etag** | **String** | API resource entity version. | 
**id** | **String** | Entity ID. | 
**isDefault** | **Boolean** | Flag indicating whether this is the global default identity provider. |  [optional]
**name** | **String** | Name of the identity provider. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;identity-provider&#39; | 
**saml2Attributes** | [**SAML2Info**](SAML2Info.md) | SAML2 specific attributes. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of the identity provider. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Identity provider type. | 
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
PROVIDER | &quot;identity-provider&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
SUSPENDED | &quot;SUSPENDED&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
NATIVE | &quot;NATIVE&quot;
MBED | &quot;MBED&quot;
SAML2 | &quot;SAML2&quot;
OIDC | &quot;OIDC&quot;



