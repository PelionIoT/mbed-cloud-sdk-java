
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
**inheritedType** | [**InheritedTypeEnum**](#InheritedTypeEnum) | Indicates the type of the entity where the limitation is inherited from. |  [optional]
**inheritedValue** | [**AccountLimitationInheritedValue**](AccountLimitationInheritedValue.md) |  |  [optional]
**limit** | **Long** | The value of the limit. |  [optional]
**name** | **String** | Name of the account limitation. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;limitation&#39; |  [optional]
**quota** | **Long** | Quota of the account limitation. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]


<a name="InheritedTypeEnum"></a>
## Enum: InheritedTypeEnum
Name | Value
---- | -----
ACCOUNT | &quot;account&quot;
TEMPLATE | &quot;template&quot;
TIER_TEMPLATE | &quot;tier_template&quot;


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
LIMITATION | &quot;limitation&quot;



