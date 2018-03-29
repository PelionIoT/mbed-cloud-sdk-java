# Changelog

The SDK source code is hosted on GitHub at https://github.com/ARMmbed/mbed-cloud-sdk-java

This news file contains a log of notable changes to the SDK. Built artefacts, including previous versions, can be retrieved using any Java package manager (e.g. Gradle, Ant/Ivy, Maven) from [Jcenter](https://bintray.com/armmbed/mbed-cloud-sdk) or [Maven Central](https://mvnrepository.com/artifact/com.arm.mbed.cloud.sdk/mbed-cloud-sdk).

[//]: # (begin_release_notes)

# Older Releases:

## 1.2.6
![Status](https://img.shields.io/badge/status-beta-orange.svg)
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
![Status](https://img.shields.io/badge/status-beta-orange.svg)
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
![Status](https://img.shields.io/badge/status-beta-orange.svg)
### Deliverables
The application source code is hosted on GitHub at https://github.com/ARMmbed/mbed-cloud-sdk-java
Built artefacts can be retrieved using any Java package manager (e.g. Gradle, Ant/Ivy, Maven) from [Jcenter](https://bintray.com/armmbed/mbed-cloud-sdk) or [Maven Central](https://mvnrepository.com/artifact/com.arm.mbed.cloud.sdk/mbed-cloud-sdk).

### Changes
- Initial release tracking Mbed Cloud 1.2 APIs
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