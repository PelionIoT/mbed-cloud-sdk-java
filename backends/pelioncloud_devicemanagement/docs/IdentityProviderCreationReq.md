
# IdentityProviderCreationReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | Description for the identity provider. |  [optional]
**name** | **String** | Name of the identity provider. | 
**oidcAttributes** | [**OIDCInfo**](OIDCInfo.md) | OIDC specific attributes. |  [optional]
**saml2Attributes** | [**SAML2Req**](SAML2Req.md) | SAML2 specific attributes. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of the identity provider. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Identity provider type. | 


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
SAML2 | &quot;SAML2&quot;
OIDC | &quot;OIDC&quot;



