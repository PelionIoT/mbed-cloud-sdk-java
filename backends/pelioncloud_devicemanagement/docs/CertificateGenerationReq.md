
# CertificateGenerationReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**algorithm** | [**AlgorithmEnum**](#AlgorithmEnum) | The algorithm and its key size used for generating the certificate. Defaults to RSA2048. |  [optional]
**validity** | **Integer** | Validity for the certificate in days. |  [optional]


<a name="AlgorithmEnum"></a>
## Enum: AlgorithmEnum
Name | Value
---- | -----
RSA2048 | &quot;RSA2048&quot;
RSA3072 | &quot;RSA3072&quot;
EC224 | &quot;EC224&quot;
EC256 | &quot;EC256&quot;
EC384 | &quot;EC384&quot;
EC521 | &quot;EC521&quot;
ECDSA224 | &quot;ECDSA224&quot;
ECDSA256 | &quot;ECDSA256&quot;
ECDSA384 | &quot;ECDSA384&quot;
ECDSA521 | &quot;ECDSA521&quot;



