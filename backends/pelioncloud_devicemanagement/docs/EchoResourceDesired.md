
# EchoResourceDesired

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**desiredAt** | [**DateTime**](DateTime.md) | The time of the latest value write was initiated. |  [optional]
**status** | [**BigDecimal**](BigDecimal.md) | The status of the desired value. 0 &#x3D; &#39;pending write&#39;, 1 &#x3D; &#39;success&#39;, 2 &#x3D; &#39;failed&#39;. |  [optional]
**statusUpdatedAt** | [**DateTime**](DateTime.md) | The time of the last status update. |  [optional]
**value** | **byte[]** | The desired value in base64 encoded format. |  [optional]



