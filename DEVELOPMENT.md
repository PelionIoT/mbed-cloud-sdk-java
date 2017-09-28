# Arm Mbed Cloud SDK for Java

[![CircleCI](https://circleci.com/gh/ARMmbed/mbed-cloud-sdk-java.svg?style=shield&circle-token=0167754c8a12d770eb92b9165ac9022a8c422633)](https://circleci.com/gh/ARMmbed/mbed-cloud-sdk-java)

[![Builds](https://img.shields.io/badge/sdk-builds-blue.svg)](http://armmbed.github.io/mbed-cloud-sdk-java/builds/)
[![Docs](https://img.shields.io/badge/sdk-documentation-blue.svg)](https://s3-us-west-2.amazonaws.com/mbed-cloud-sdk-java/index.html)

## Prerequisites
* Java > 1.7   _tested with [Oracle JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)_
* [Gradle](https://gradle.org/). _Use gradle wrapper if possible_
* Python > 2.7 or > 3.6. _In case build scripts are used or for running test suite_
* grep > 2.5. _In case build scripts are used_
* git. _In case build scripts are used_


## Building
1. Sets required environment/build variables in gradle.properties
2. In order to build the SDK, you can call gradle tasks directly or use wrapper scripts present in ./scripts folder

    ```shell
        python sdk.py <action>
        e.g. python sdk.py build
    ```


## Testing
1. Sets required environment variables for the test server to run: **ENVVAR_MBED_CLOUD_API_KEY** and **ENVVAR_MBED_CLOUD_HOST**.
1. Clone [mbed-cloud-sdk-testrunner](https://github.com/ARMmbed/mbed-cloud-sdk-testrunner) in ./tests folder.
2. Run run.bat or run.sh to launch SDK system test campaign.