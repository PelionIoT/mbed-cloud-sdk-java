
# OIDCInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authorizationEndpoint** | **String** | URL of the OAuth 2.0 authorization endpoint. |  [optional]
**autoEnrollment** | **Boolean** | For future use. |  [optional]
**clientId** | **String** | Client ID needed to authenticate and gain access to identity provider&#39;s API. |  [optional]
**clientSecret** | **String** | Client secret needed to authenticate and gain access to identity provider&#39;s API. |  [optional]
**endSessionEndpoint** | **String** | URL of the provider&#39;s end session endpoint. |  [optional]
**issuer** | **String** | Issuer of the identity provider. |  [optional]
**jwksUri** | **String** | URL of the provider&#39;s JSON web key set document. |  [optional]
**keys** | [**List&lt;IdpPublicKey&gt;**](IdpPublicKey.md) | Provider&#39;s public keys and key IDs used to sign ID tokens. PEM-encoded. |  [optional]
**redirectUri** | **String** | The URI needed to authenticate and gain access to identity provider&#39;s API. |  [optional]
**revocationEndpoint** | **String** | URL of the provider&#39;s token revocation endpoint. |  [optional]
**tokenEndpoint** | **String** | URL of the OAuth 2.0 authorization endpoint. |  [optional]
**userinfoEndpoint** | **String** | URL of the OAuth 2.0 UserInfo endpoint. |  [optional]



