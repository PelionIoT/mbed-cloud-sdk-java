# Changelog

The SDK source code is hosted on GitHub at https://github.com/ARMmbed/mbed-cloud-sdk-java

This news file contains a log of notable changes to the SDK. Built artefacts, including previous versions, can be retrieved using any Java package manager (e.g. Gradle, Ant/Ivy, Maven) from [Jcenter](https://bintray.com/armmbed/mbed-cloud-sdk) or [Maven Central](https://mvnrepository.com/artifact/com.arm.mbed.cloud.sdk/mbed-cloud-sdk).

[//]: # (begin_release_notes)

2.2.1 (2019-02-25)
==================

### Bugfixes

- Changed the log level of `An error occurred when trying to fetch server date from API metadata` to remove confusion. (#2233)

### Misc

- #1


2.2.0 (2018-11-15)
==================

### Features

- It is now possible to renew certificates or manage Certificate issuers in the Security module. (#1868)

- LWM2M actions on resources are now performed using solely Observers and RXJava introduced with Subscriptions. (#4)

### Bugfixes

- `Set` and `execute` resource value actions now use `/v2/device-requests/` enpoint as former endpoints are deprecated (#1883)


2.1.0 (2018-10-26)
==================

### Features

- Added a generic client `GenericClient` which can be used by the user to call any endpoint of Pelion Cloud. (#1498)

### Bugfixes

- Added a filter on Device ID in Campaign model (#1478)

- Use pyautoversion to set SDK's version (#2)

- Fixed `SpotBugs` gradle plugin failure with latest `gradle` (#3)


2.0.0 (2018-07-31)
==================

### Features

- It is now possible to download active devices and firmware updates reports in the Billing module. (#1398)

- Settings can now be configured from `.env` files. See https://github.com/cdimascio/java-dotenv for more details. Host and API keys can be specified using the following environment variables: respectively `MBED_CLOUD_SDK_HOST` and `MBED_CLOUD_SDK_API_KEY`. (#927)


1.2.10 (2018-07-06)
===================

### Features

- Added a preferences file for development on Eclipse [/config/eclipse] (#1)

- Billing module was integrated. This provides the ability to fetch various
  reports regarding billing (e.g. Service package status, remaining quota,
  history of transactions) (#1216)


1.2.9 (2018-06-27)
==================

### Features

- Updated account and user custom properties fields in AccountManagement
  (#1254)

- Paginator<T> and ListOptions objects used in the SDK to list elements now
  take `maxResults` and `pageSize` to remove the ambiguity of former parameter
  `limit`. (#1296)

- Added an experimental single point of entry for using the SDK
  (MbedCloudClient) (#1348)

- Removed custom properties field from user and account models (#1362)

- Pre-shared keys registered in the Cloud can now be listed (#631)


1.2.8 (2018-05-23)
==================

### Features

- Added new field (phase) to update campaign. (1057)

- Added 'Resource value change' subscription channel. This supercedes
  'presubscription' and 'subscription' behaviours to provide a uniform
  interface in line with the existing 'Device state change' channel. See
  Connect module > subscribe(). (1102)

- Updated models regarding Users and Accounts to better manage custom
  properties. Added additional filters when listing users. (1225)

- It is now possible to upload all device decryption keys for a campaign as a
  single blob when adding the firmware manifest (552)

- Bootstrap module for Pre-Shared Keys was integrated. This provides the
  ability to set Pre-Shared Keys for device bring-up. (630)

### Bugfixes

- Updated Connect backend endpoint names (1235)


1.2.7 (2018-04-09)
==================

### Features

- Exponential backoff in case of request call failure during notification pull
  was implemented. (1065)

- Specified User Agent header when sending requests to Pelion Cloud (634)

- Notification channels for device registration status notifications (4 events)
  were added. (722)

### Bugfixes

- Updated Connector CA schema (1081)

- Updated contribution guidelines (729)

- Modified backends to avoid duplicate code leading to Android compilation
  issue (976)


# Older Releases:

## 1.2.6

### Deliverables
The application source code is hosted on GitHub at https://github.com/ARMmbed/mbed-cloud-sdk-java
Built artefacts can be retrieved using any Java package manager (e.g. Gradle, Ant/Ivy, Maven) from [Jcenter](https://bintray.com/armmbed/mbed-cloud-sdk) or [Maven Central](https://mvnrepository.com/artifact/com.arm.mbed.cloud.sdk/mbed-cloud-sdk).

### Changes
- REST API changes:
  - Device Directory
  - Update
  - Account Management
  - Enrollment (First to claim) was introduced
    - Account admin can upload a list of devices to claim and view the status of claimed devices
  - Connect
    - A new endpoint was introduced for retrieving resource values.
- Bug fixes and improvements:
  - Get resource value bug listed in previous releases was fixed
  - Added states to upload campaigns
  - File upload to the cloud (correct filename)
  - Bug regarding exceptions thrown when empty lists were retrieved
  - Connect - deleteSubscriptions()
- Environments supported:
  - Java > 1.7

### Known Issues
- The Java SDK cannot currently be used on Android because of the following error.
```java
  com.android.build.api.transform.TransformException: com.android.dex.DexException: Multiple dex files define Lcom/arm/mbed/cloud/sdk/internal/JSON$1;
```
## 1.2.5

### Deliverables
The application source code is hosted on GitHub at https://github.com/ARMmbed/mbed-cloud-sdk-java
Built artefacts can be retrieved using any Java package manager (e.g. Gradle, Ant/Ivy, Maven) from [Jcenter](https://bintray.com/armmbed/mbed-cloud-sdk) or [Maven Central](https://mvnrepository.com/artifact/com.arm.mbed.cloud.sdk/mbed-cloud-sdk).

### Changes
- REST API changes:
  - Device Directory
  - Update
- Bug fixes and improvements:
  - Swagger codegen upgrade
  - Paginator
  - Developer certificate missing data
  - File upload to the cloud
  - Date conversion
  - Filter issues
- Environments supported:
  - Java > 1.7

### Known Issues
- Testing shows that `getResourceValue` (Connect module) will fail
when the cloud service returns a value directly, rather than
through an open notification channel. This affects all previous versions.
- The only known workaround at present is to ensure the cloud cache is not used by:
  - Waiting between calls to get_resource_value
  - Reducing [the configured TTL](https://cloud.mbed.com/docs/latest/collecting/handle-resources.html#working-with-the-server-cache) on the cloud client image on the device

## 1.2.4

### Deliverables
The application source code is hosted on GitHub at https://github.com/ARMmbed/mbed-cloud-sdk-java
Built artefacts can be retrieved using any Java package manager (e.g. Gradle, Ant/Ivy, Maven) from [Jcenter](https://bintray.com/armmbed/mbed-cloud-sdk) or [Maven Central](https://mvnrepository.com/artifact/com.arm.mbed.cloud.sdk/mbed-cloud-sdk).

### Changes
- Initial release tracking Pelion Cloud 1.2 APIs
- APIs supported:
  - Account Management
  - Certificates
  - Connect
  - Device Directory
  - Update
- Environments supported:
  - Java > 1.7

### Known Issues
- Testing shows that `getResourceValue` (Connect module) will fail
when the cloud service returns a value directly, rather than
through an open notification channel. This affects all previous versions.
- The only known workaround at present is to ensure the cloud cache is not used by:
  - Waiting between calls to get_resource_value
  - Reducing [the configured TTL](https://cloud.mbed.com/docs/latest/collecting/handle-resources.html#working-with-the-server-cache) on the cloud client image on the device
