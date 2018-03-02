
# ChangeLoginSessionResp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) | The status of the logged in user. &#39;Reset&#39; means that the password must be changed immediately. | 
**userId** | **String** | User ID. | 
**accountId** | **String** | The UUID of the account where the user login session is changed to. | 
**roles** | **List&lt;String&gt;** | The roles of the logged in user. | 
**token** | **String** | Reference token. | 
**parentAccountId** | **String** | The UUID of the parent account. | 
**mfaStatus** | [**MfaStatusEnum**](#MfaStatusEnum) | The enforcement status of setting up the multi-factor authentication. &#39;Enabled&#39; means that the MFA has been enabled despite the enforcement. &#39;Enforced&#39; means that setting up the MFA is required after login. &#39;Optional&#39; means that the MFA is not required. | 


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;Active&quot;
RESET | &quot;Reset&quot;
INACTIVE | &quot;Inactive&quot;


<a name="MfaStatusEnum"></a>
## Enum: MfaStatusEnum
Name | Value
---- | -----
ENABLED | &quot;enabled&quot;
ENFORCED | &quot;enforced&quot;
OPTIONAL | &quot;optional&quot;



