
# FeaturePolicy

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**action** | **String** | Comma-separated list of actions, empty string represents all actions. |  [optional]
**allow** | **Boolean** | True or false controlling whether an action is allowed or not. |  [optional]
**feature** | **String** | Feature name corresponding to this policy. |  [optional]
**inherited** | **Boolean** | Flag indicating whether this feature is inherited or overwritten specifically. |  [optional]
**inheritedFrom** | **String** | An ID indicating where this policy is inherited from. |  [optional]
**inheritedType** | [**InheritedTypeEnum**](#InheritedTypeEnum) | Indicates the type of entity this policy is inherited from. |  [optional]
**resource** | **String** | Resource that is protected by this policy. |  [optional]


<a name="InheritedTypeEnum"></a>
## Enum: InheritedTypeEnum
Name | Value
---- | -----
ACCOUNT | &quot;account&quot;
TEMPLATE | &quot;template&quot;
TIER_TEMPLATE | &quot;tier_template&quot;



