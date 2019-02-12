# Arm Mbed Cloud SDK for Java

[![CircleCI](https://circleci.com/gh/ARMmbed/mbed-cloud-sdk-java.svg?style=shield&circle-token=0167754c8a12d770eb92b9165ac9022a8c422633)](https://circleci.com/gh/ARMmbed/mbed-cloud-sdk-java)

[![Builds](https://img.shields.io/badge/sdk-builds-blue.svg)](http://armmbed.github.io/mbed-cloud-sdk-java/builds/)
[![Docs](https://img.shields.io/badge/sdk-documentation-blue.svg)](https://s3-us-west-2.amazonaws.com/mbed-cloud-sdk-java/index.html)
[![codecov](https://codecov.io/gh/ARMmbed/mbed-cloud-sdk-java/branch/master/graph/badge.svg?token=hpPPKYJW5L)](https://codecov.io/gh/ARMmbed/mbed-cloud-sdk-java)
[![Maintainability](https://api.codeclimate.com/v1/badges/8bc50f9e9e99bdabc030/maintainability)](https://codeclimate.com/github/ARMmbed/mbed-cloud-sdk-java/maintainability)
[ ![Download](https://api.bintray.com/packages/armmbed/mbed-cloud-sdk/mbed-cloud-sdk/images/download.svg) ](https://bintray.com/armmbed/mbed-cloud-sdk/mbed-cloud-sdk/_latestVersion)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Prerequisites
* Java > 1.7   _tested with [Oracle JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)_
* [Gradle](https://gradle.org/). _Use gradle wrapper if possible_
* Python > 2.7 or > 3.6. _In case build scripts are used or for running test suite_
* grep > 2.5. _In case build scripts are used_
* git. _In case build scripts are used_


## Building
1. Clone the git repository to your machine:

    ``shell
        git clone https://github.com/ARMmbed/mbed-cloud-sdk-java.git
    ``
2. Sets required environment/build variables in gradle.properties
3. In order to build the SDK, you can call gradle tasks directly or use wrapper scripts present in ./scripts folder

    ``shell
        ./gradlew build (on Linux) gradlew.bat build (on Windows)
                or
        python scripts/sdk.py <action>
        e.g. python sdk.py build
    ``
  Note that actions other than 'build are available; use ``./gradlew tasks`` to see a complete list

### Formatting the sources
The build uses checkstyle to ensure that the source code has a consistent format. You can automatically apply formatting to the code by running ``./gradlew spotlessApply`` in the project root at any time.

## Javadoc
It is possible to customise the javadoc output by specifying file paths of header, footer, style sheet, etc. in gradle.properties.
e.g. on Windows:

```shell
    javadocStylesheet=C:\\Users\\john\\mbed-cloud-sdk-java\\stylesheet.css
```
To regenerate the javadoc, just run the following command:
```shell
    ./gradlew clean javadoc
```

* **Style sheet:** _(javadoc -stylesheetfile option)_ Specifies the path of an alternate HTML stylesheet file. Without this option, the Javadoc tool automatically creates a stylesheet file stylesheet.css that is hard-coded in the Javadoc tool. This option enables you to override this default. The filename can be any name and is not restricted to stylesheet.css.

* **Top:** _(javadoc -top option)_ Specifies the text to be placed at the top of each output file.

* **Header:** _(javadoc -header option)_ Specifies the header text to be placed at the top of each output file. The header will be placed to the right of the upper navigation bar. header may contain HTML tags and white space. Any internal quotation marks within header may have to be escaped.

* **Bottom:** _(javadoc -bottom option)_ Specifies the text to be placed at the bottom of each output file. The text will be placed at the bottom of the page, below the lower navigation bar. The text may contain HTML tags and white space. Any internal quotation marks within text may have to be escaped.

* **Footer:** _(javadoc -footer option)_ Specifies the footer text to be placed at the bottom of each output file. The footer will be placed to the right of the lower navigation bar. footer may contain HTML tags and white space. Any internal quotation marks within footer may have to be escaped.

## Testing
The SDK is tested via a set of unit tests and integration tests.
* Unit tests can be run using ```gradlew test``` command. They use JUnit framework and are present in src/test folder.
* All integration tests are defined in [mbed-cloud-sdk-testrunner](https://github.com/ARMmbed/mbed-cloud-sdk-testrunner).

## Releasing
The SDK is set up to perform CI/CD on every commit to `master`. Only approved builds are then uploaded to JCenter and Maven Central. The version number is bumped automatically. It is however possible to overwrite it by setting the following environment variable `MBED_CLOUD_SDK_VERSION_TO_SET` with the wanted version value.
