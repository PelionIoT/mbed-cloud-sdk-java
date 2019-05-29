# Pelion Device Management SDK for Java - Examples

This java project presents several examples of how the SDK can be used to interact with Pelion Cloud.
It is based on JUnit framework and can be run as is from the command line or from your favourite IDE (e.g. [eclipse](https://www.eclipse.org/) or [IntelliJ](https://www.jetbrains.com/idea/)).
It will require however that **`MBED_CLOUD_API_KEY`** environment variable is set using a valid Pelion Cloud API key (Use [Pelion Device Management Portal](https://portal.mbedcloud.com/) to get one if not already the case).
The level of logging of HTTP communications can also be set using **`HTTP_LOG_LEVEL`** variable (see CallLogLevel for more information about valid values).

## Prerequisites
* Java > 1.7   _tested with [Oracle JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)_
* [Gradle](https://gradle.org/). _Use gradle wrapper if possible_
* JUnit > 4. (Gradle should download the right version)


## Importing into an IDE
1. Create IDE project files using ```gradlew eclipse``` or ```gradlew idea``` depending on the IDE you want to use.
2. Open the IDE of your choice:
    * If eclipse, go to File>Import>Existing Gradle Project (Relevant Eclipse Plug-in might be needed)
    * If IntelliJ, Import project>Import project from external model>Gradle

## Project
All example code can be found in src/main/java/mbed_cloud_sdk or can be browsed [online](https://armmbed.github.io/mbed-cloud-sdk-java/examples).
Every example is annotated with **@Example** and can be run independently or as a full suite.
These examples are designed to give developers a headstart with developing with the Pelion Device Management SDK for Java.


## Building and Testing
1. Set required environment variables for the example to run:  **`MBED_CLOUD_API_KEY`**.
2. Run ```gradlew test``` to run the full example suite in the command line or use IDE's JUnit plug-in instead.
