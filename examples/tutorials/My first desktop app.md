// an example: My first desktop app

/*
For this example, we are going to use Gradle as a package manager.
This tool will have to be installed on your machine (https://gradle.org/install/).

First, it is necessary to set up a project. This can be done using Gradle.
*/

> gradle init --type java-application

/*
This command generated all the files (e.g. helper scripts, example code, etc.) necessary for a java application.

As we want to integrate the SDK into our application, we need to add a dependency to it in 'build.gradle' file.
Open this file in an editor and copy the snippet related to Gradle from https://bintray.com/armmbed/mbed-cloud-sdk/mbed-cloud-sdk into the 'dependencies' section.
It should be something like:
*/

implementation 'com.arm.mbed.cloud.sdk:mbed-cloud-sdk:1.x.y'

/*
You can also comment out the dependency on 'guava' as it is not required and add the following line to tell the logger not to log anything.
*/

implementation 'org.slf4j:slf4j-nop:1.7.25'

/*
In an editor/IDE of your choice, open src/main/java/App.java and add the following code in the 'main' function after the greeting line 'System.out.println(new App().getGreeting());'
*/

   /**
         * This is a small application to switch on the LED on newly registered devices. Devices must have the Mbed
         * client example installed on them: https://github.com/ARMmbed/simple-mbed-cloud-client
         */
        // Loading the API key for Pelion Device Management from an environment variable
        final ConnectionOptions config = ConnectionOptions.newConfiguration(System.getenv("MBED_CLOUD_API_KEY"));
        // Instantiating an SDK.
        try (Sdk sdk = Sdk.createSdk(config); AccountDao accountDao = sdk.foundation().getAccountDao()) {
            // Checking that we can connect to Pelion Device Management by checking my account
            System.out.println("Hello " + accountDao.me().getContact());
            System.out.println("You are about to blink all newly registered devices...");

            final TimePeriod timeout = new TimePeriod(10);
            // According to the Pelion Device Management IoT Connection Tutorial
            // https://os.mbed.com/guides/connect-device-to-pelion/
            // the LED state resource is, as follows:
            final String LedStateResourcePath = "3201/0/5853";

            // Subscribing to any newly registered devices. When a new device gets registered, its ID is printed to the
            // console and a request to switch on the LED is sent.
            sdk.subscribe(DeviceStateFilterOptions.newFilter().equalDeviceState(DeviceState.REGISTRATION),
                          BackpressureStrategy.BUFFER)
               .flow().doOnError(System.err::println).subscribe(message -> {
                   // Printing the ID of the newly registered device
                   System.out.println("Received a notification from device [" + message.getDeviceId()
                                      + "] which just registered to Pelion Device Management");
                   Resource resource = sdk.lowLevelRest().getConnectModule()
                                          .getResource(new Device(message.getDeviceId()), LedStateResourcePath);
                   if (resource == null) {
                       System.out.println("Device [" + message.getDeviceId() + "] does not have the resource ["
                                          + LedStateResourcePath + "] defined to switch on the LED");
                   } else {
                       // Sending a request to switch on the LED to the corresponding device
                       System.out.println("Asking Device [" + message.getDeviceId() + "] to switch on the LED");
                       sdk.lowLevelRest().getConnectModule().setResourceValue(resource, "1", timeout);

                   }
               });
            /*
             * TODO Do some actual work
             */
            Thread.sleep(120000);// waiting for 2 minutes
            /*
             * TODO Do some actual work
             */
        } catch (MbedCloudException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        // End of the application

/*
This code is your first desktop app using the SDKs.
It requires the 'MBED_CLOUD_API_KEY' environment variable to be set with your API key in order to work.
Run your code using gradle.
*/

`> .\gradlew run`

/*
It is possible to output more logging by replacing the line concerning the logger implementation in 'build.gradle' by the following.
*/

implementation 'org.slf4j:slf4j-simple:1.7.25'

/*
It is possible to find all the code for this tutorial on Github: https://github.com/ARMmbed/mbed-cloud-sdk-java/tree/master/examples/tutorials
*/

// end of example
