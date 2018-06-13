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

compile 'com.arm.mbed.cloud.sdk:mbed-cloud-sdk:1.x.y'

/*
You can also comment out the dependency on 'guava' as it is not required and add the following line to tell the logger not to log anything.
*/

compile 'org.slf4j:slf4j-nop:1.7.25'

/*
In an editor/IDE of your choice, open src/main/java/App.java and add the following code in the 'main' function after the greeting line 'System.out.println(new App().getGreeting());'
*/

        /**
         * This is a small application to make newly registered devices blink. Devices must have the mbed client example
         * installed on them: https://github.com/ARMmbed/mbed-cloud-client-example/
         */
        // Loading the API key for Mbed Cloud from an environment variable
        final ConnectionOptions config = ConnectionOptions.newConfiguration(System.getenv("MBED_CLOUD_API_KEY"));
        // Instantiating the different SDK modules
        final Connect connectApi = new Connect(config);
        final AccountManagement accountApi = new AccountManagement(config);

        try {
            // Checking that we can connect to Mbed Cloud by checking my account
            System.out.println("Hello " + accountApi.getAccount().getContact());
            System.out.println("You are about to blink all newly registered devices...");

            final TimePeriod timeout = new TimePeriod(5);
            // According to the Mbed Client documentation
            // https://cloud.mbed.com/docs/current/connecting/client-lite.html#testing
            // the blinking resource is, as follows:
            final String blinkResourcePath = "/3201/0/5850";

            // Subscribing to any newly registered devices. When a new device gets registered, its ID is printed to the
            // console and a request to blink is sent.
            connectApi.subscribe()
                    .deviceStateChanges(DeviceStateFilterOptions.newFilter().equalDeviceState(DeviceState.REGISTRATION),
                            BackpressureStrategy.BUFFER)
                    .flow().doOnError(System.err::println).subscribe(message -> {
                        // Printing the ID of the newly registered device
                        System.out.println("Received a notification from device [" + message.getDeviceId() + "]");
                        // Sending a request to blink to the corresponding device
                        connectApi.executeResource(message.getDeviceId(), blinkResourcePath, null, false, timeout);
                    });
            /*
             * TODO Do some actual work
             */
            Thread.sleep(120000);// waiting for 2 minutes
            /*
             * TODO Do some actual work
             */
            // Stopping the SDK when finishing
            connectApi.stopNotifications();
        } catch (MbedCloudException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Quitting the SDK, ensuring that all daemon threads are stopped.
            connectApi.shutdownConnectService();
        }
        // End of the application

/*
This code is your first desktop app using  the SDKs.
It requires the 'MBED_CLOUD_API_KEY' environment variable to be set with your API key in order to work.
Run your code using gradle.
*/

> gradle run

/*
It is possible to output more logging by the line concerning the logger implementation in 'build.gradle' by the following.
*/

compile 'org.slf4j:slf4j-simple:1.7.25'

/*
It is possible to find all the code for this tutorial on Github: .
*/

// end of example
