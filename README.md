# Mbed Cloud SDK for Java

The Mbed Cloud SDK provides a simplified interface to the [Mbed Cloud APIs](https://www.mbed.com/en/platform/cloud/) by exposing functionality using conventions and paradigms familiar to Java developers.

## Prerequisites
* Java > 1.7   _tested with [Oracle JRE](http://www.oracle.com/technetwork/java/javase/downloads/index.html)_

## Logging
* The SDK uses **[SLF4j](https://www.slf4j.org/)** and hence, any supported logging framework  (e.g. java.util.logging, logback, log4j) can be used by your application.

## Distribution
[ ![Download](https://api.bintray.com/packages/armmbed/mbed-cloud-sdk/mbed-cloud-sdk/images/download.svg) ](https://bintray.com/armmbed/mbed-cloud-sdk/mbed-cloud-sdk/_latestVersion)

In order to best meet your requirements, Java SDK is packaged in 3 different ways:
* Individual Jars
* Distribution ZIP. See related [gradle plugin](https://docs.gradle.org/current/userguide/javaLibraryDistribution_plugin.html) for more details.
* A [fat jar](https://github.com/johnrengelman/shadow) comprising the SDK and all its dependencies.

These artifacts are published on [JCenter](https://bintray.com/bintray/jcenter
) and [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22mbed-cloud-sdk%22). 
They can therefore be retrieved and included into your project using the package manager of your choice. To do so, please follow the instructions present on one of this artifact repositories ([Bintray page of the project](https://bintray.com/armmbed/mbed-cloud-sdk/mbed-cloud-sdk/)).


## Usage
These instructions can also be found in the [official documentation](https://s3-us-west-2.amazonaws.com/mbed-cloud-sdk-java/index.html):
1. Create an API key on [Mbed Cloud Portal](https://portal.mbedcloud.com/).
2. Create a configuration object:
    ```java
        String logLevel = "BODY"; //Defines the logging level of HTTP communications. See CallLogLevel for more information.
        String apiKey = "<apikey>"; //API key to use for contacting Mbed Cloud.
        ConnectionOptions config = new ConnectionOptions(apiKey);
        config.setClientLogLevel(CallLogLevel.getLevel(logLevel));
    ```
3. Import SDK using one of the packages listed above and you are ready to go.
    ```java
        DeviceDirectory deviceApi = new DeviceDirectory(config);
        try {
            System.out.println(deviceApi.listDevices(null));
        } catch (MbedCloudException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    ```

## Documentation and examples
See the full documentation and API reference (i.e. javadoc) at https://cloud.mbed.com/docs/latest/mbed-cloud-sdk-java/.
For usage examples, please have a look at the [example project](examples/README.md).

## Contributing
Mbed Cloud SDK for Java is open source and we would like your help. There is a brief guide on how to get started in [CONTRIBUTING.md](CONTRIBUTING.md). 

## Project
* All code inside _\*.internal.\*_ packages or annotated as **@Internal** is considered private API and should not be relied upon at all.
* Classes annotated as **@Module** contain all Arm Mbed Cloud APIs
* Methods annotated as **@API** are the functions which can be used to interact with Mbed Cloud.
* APIs, objects or methods annotated as **@Deprecated** are supported until the next major release and will be removed later on. It is highly recommended to stop using them.
* Methods with **@Daemon** annotation should be used to monitor SDK daemon threads.

## Licence
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Mbed Cloud SDK for Java is free-to-use and licensed under the **Apache License
2.0**. See LICENCE file for more information.