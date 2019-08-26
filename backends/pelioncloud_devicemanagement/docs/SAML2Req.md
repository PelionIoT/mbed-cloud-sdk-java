
# SAML2Req

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**entityDescriptor** | **byte[]** | Contains an entity descriptor document for the identity provider. Can be used as an alternative method to provide the identity provider&#39;s attributes. |  [optional]
**idpEntityId** | **String** | Entity ID of the identity provider. |  [optional]
**idpX509Certs** | **List&lt;String&gt;** | List of public X509 certificates of the identity provider. Certificates must be in PEM format. |  [optional]
**sloEndpoint** | **String** | URL of the identity provider&#39;s SLO endpoint. |  [optional]
**spEntityId** | **String** | Entity ID of the service provider. We recommend that you leave it empty and let the system generate it. |  [optional]
**ssoEndpoint** | **String** | URL of the identity provider&#39;s SSO endpoint. |  [optional]



