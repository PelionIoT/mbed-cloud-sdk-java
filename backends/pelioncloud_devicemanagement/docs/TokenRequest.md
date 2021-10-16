
# TokenRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**aud** | **List&lt;String&gt;** | Array of \\&lt;type\\&gt;:\\&lt;identity\\&gt; tuples representing devices for which access is being requested. There must be at least one id/ep tuple.&lt;br/&gt; \\&lt;type\\&gt; ::&#x3D; id|ep &lt;br/&gt; \\&lt;identity\\&gt;::&#x3D;[a-zA-Z0-9+/&#x3D;- ]+ &lt;br/&gt;\\&lt;audience\\&gt; :&#x3D;&#x3D; \\&lt;type\\&gt; \&quot;:\&quot; \\&lt;identity\\&gt;  &lt;br/&gt; \\&lt;identity\\&gt; can be up to 60 characters long, and can contain spaces. &lt;br/&gt; The audience array can contain up to 50 tuples. If IAM does not authorize even one item in the list, Secure Device Access does not authorize the whole request and does not return an access token (access denied). | 
**cnf** | **String** | The Android application proof-of-possession public key. | 
**grantType** | **String** | Hardcoded - can only be \&quot;client_credentials\&quot;. | 
**scope** | **String** | The space-delimited list of operations that user is requesting permission for. The array must contain at least one scope item. A scope item can have up to 60 characters. A scope list can hold up to 20 scope items. &lt;br/&gt; \\&lt;scope\\&gt;::&#x3D;[a-zA-Z][a-zA-Z0-9-]* &lt;br/&gt; \\&lt;scope-list\\&gt;::&#x3D; \\&lt;scope\\&gt; | \\&lt;scope\\&gt; \&quot; \&quot; | \\&lt;scope\\&gt; \&quot; \&quot; \\&lt;scope-list\\&gt; &lt;br/&gt; The scope being requested must match the action that the Android application eventually performs on the IoT device. The device matches the scope in the access token to the action requested in the operation bundle. | 



