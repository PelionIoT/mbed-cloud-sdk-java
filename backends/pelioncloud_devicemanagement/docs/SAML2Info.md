
# SAML2Info

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**assertionEndpoint** | **String** | URL of the service provider&#39;s assertion endpoint. |  [optional]
**idpEntityId** | **String** | Entity ID of the identity provider. |  [optional]
**idpX509Certs** | **List&lt;String&gt;** | List of public X509 certificates of the identity provider in PEM format. |  [optional]
**sloEndpoint** | **String** | URL of the identity provider&#39;s SLO endpoint. |  [optional]
**spEntityId** | **String** | Entity ID of the service provider. |  [optional]
**spX509Cert** | **String** | Public X509 certificate of the service provider in PEM format. This is a read-only attribute, see API documentation about how to generate a new one or how to delete it. |  [optional]
**ssoEndpoint** | **String** | URL of the identity provider&#39;s SSO endpoint. |  [optional]



