
# Metric

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deviceServerRestApiError** | **Long** | The number of failed [Connect API](/docs/v1.2/api-references/connect-api.html) requests the account has performed. |  [optional]
**bootstrapsFailed** | **Long** | The number of failed bootstraps the account has performed. |  [optional]
**transactions** | **Long** | The number of transaction events from or to devices linked to the account. A transaction is a 512-byte block of data processed by mbed Cloud. It can be either sent by the device (device --&gt; mbed cloud) or received by the device (mbed cloud --&gt; device). A transaction does not include IP, TCP or UDP, TLS or DTLS packet overhead. It only contains the packet payload (full CoAP packet including CoAP headers). |  [optional]
**timestamp** | **String** | UTC time in RFC3339 format. The timestamp is the starting point of the interval for which the data is aggregated. Each interval includes data for the time greater than or equal to the timestamp and less than the next interval&#39;s starting point. |  [optional]
**registeredDevices** | **Long** | The maximum number of registered devices linked to the account. The registered devices count is calculated based on unique registrations plus registration updates over a period of 5 minutes. |  [optional]
**bootstrapsPending** | **Long** | The number of pending bootstraps the account has performed. |  [optional]
**deviceServerRestApiSuccess** | **Long** | The number of successful [Connect API](/docs/v1.2/api-references/connect-api.html) requests the account has performed. |  [optional]
**handshakesSuccessful** | **Long** | The number of successful handshakes the account has performed. |  [optional]
**bootstrapsSuccessful** | **Long** | The number of successful bootstraps the account has performed. |  [optional]
**id** | **String** | A unique metric ID. |  [optional]



