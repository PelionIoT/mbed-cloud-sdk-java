# Changelog
## 1.2.5
![Status](https://img.shields.io/badge/status-beta-orange.svg)
### Deliverables
The application source code is hosted on GitHub at https://github.com/ARMmbed/mbed-cloud-sdk-java
Built artefacts can be retrieved using any Java package manager (e.g. Gradle, Ant/Ivy, Maven) from [Jcenter](https://bintray.com/armmbed/mbed-cloud-sdk) or [Maven Central](https://mvnrepository.com/artifact/com.arm.mbed.cloud.sdk/mbed-cloud-sdk).

### Changes
- REST API changes:
  - Device Diectory
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
  - Device Diectory
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