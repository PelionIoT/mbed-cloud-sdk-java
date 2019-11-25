
# AccountLimitation

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**billingPeriod** | **Integer** | Billing period of the account limitation. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | Description of the account limitation. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**id** | **String** | Entity ID. |  [optional]
**inherited** | **Boolean** | Flag indicating whether this limitation is inherited. |  [optional]
**inheritedFrom** | **String** | Indicates where this limit is inherited from. |  [optional]
**inheritedType** | **String** | Indicates the type of the entity where the limitation is inherited from. |  [optional]
**limit** | **Integer** | The value of the limit. |  [optional]
**name** | **String** | Name of the account limitation. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;limitation&#39; |  [optional]
**quota** | **Integer** | Quota of the account limitation. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
USER | &quot;user&quot;
API_KEY | &quot;api-key&quot;
GROUP | &quot;group&quot;
ACCOUNT | &quot;account&quot;
ACCOUNT_TEMPLATE | &quot;account_template&quot;
TRUSTED_CERT | &quot;trusted_cert&quot;
LIST | &quot;list&quot;
ERROR | &quot;error&quot;
AGREEMENT | &quot;agreement&quot;
SIGNED_AGREEMENT | &quot;signed_agreement&quot;
POLICY | &quot;policy&quot;
LIMITATION | &quot;limitation&quot;
IDENTITY_PROVIDER | &quot;identity_provider&quot;
USER_SESSION | &quot;user_session&quot;
USER_INVITATION | &quot;user_invitation&quot;
NOTIFICATION_ENTRY | &quot;notification_entry&quot;
BRANDING_COLOR | &quot;branding_color&quot;
BRANDING_IMAGE | &quot;branding_image&quot;



