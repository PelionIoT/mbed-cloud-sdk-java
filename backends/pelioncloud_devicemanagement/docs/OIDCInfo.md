
# OIDCInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authorizationEndpoint** | **String** | URL of the OAuth 2.0 authorization endpoint. |  [optional]
**autoEnrollment** | **Boolean** | For future use. |  [optional]
**claimMapping** | [**OIDCClaimMapping**](OIDCClaimMapping.md) | Mapping table for supporting custom OIDC claims. |  [optional]
**clientId** | **String** | Client ID needed to authenticate and gain access to identity provider&#39;s API. |  [optional]
**clientSecret** | **String** | Client secret needed to authenticate and gain access to identity provider&#39;s API. |  [optional]
**endSessionEndpoint** | **String** | URL of the provider&#39;s end session endpoint. |  [optional]
**issuer** | **String** | Issuer of the identity provider. | 
**jwksUri** | **String** | URL of the provider&#39;s JSON web key set document. |  [optional]
**keys** | [**List&lt;IdpPublicKey&gt;**](IdpPublicKey.md) | Provider&#39;s public keys and key IDs used to sign ID tokens. PEM-encoded. |  [optional]
**redirectUri** | **String** | The URI needed to authenticate and gain access to identity provider&#39;s API. Leave this empty to use the default redirect URI. |  [optional]
**revocationEndpoint** | **String** | URL of the provider&#39;s token revocation endpoint. |  [optional]
**scopes** | **String** | Space-separated list of scopes sent in the authentication request. When not configured otherwise, the default scopes are [&#39;openid profile email&#39;](https://openid.net/specs/openid-connect-core-1_0.html#ScopeClaims). |  [optional]
**tokenEndpoint** | **String** | URL of the OAuth 2.0 authorization endpoint. |  [optional]
**tokenRequestMode** | [**TokenRequestModeEnum**](#TokenRequestModeEnum) | One way to obtain the access token. Since the request results in the transmission of clear-text credentials, the client must use the POST mode. |  [optional]
**tokenResponsePath** | **String** | Path to the standard data in the token response. Levels in the JSON structure must be separated by &#39;.&#39; (dot) characters. |  [optional]
**userinfoEndpoint** | **String** | URL of the OAuth 2.0 UserInfo endpoint. |  [optional]


<a name="TokenRequestModeEnum"></a>
## Enum: TokenRequestModeEnum
Name | Value
---- | -----
POST | &quot;POST&quot;
GET | &quot;GET&quot;



