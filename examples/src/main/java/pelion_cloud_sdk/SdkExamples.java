package pelion_cloud_sdk;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;

import com.arm.mbed.cloud.Sdk;
import com.arm.mbed.cloud.sdk.common.CallLogLevel;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceState;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class SdkExamples extends AbstractExample {

    /**
     * Configures the SDK.
     */

    @Example
    public void configureTheSdk() {
        // an example: configuring the SDK
        ConnectionOptions config = ConnectionOptions.newConfiguration("an_API_KEY_for_the_cloud");
        // If the host is not the default Mbed Cloud, it needs to be specified
        config.setHost("Cloud host URL");
        // The level of logging regarding Http communications with the Cloud can also be specified (see CallLogLevel for
        // more details).
        config.setClientLogLevel(CallLogLevel.BASIC);
        try (Sdk sdk = Sdk.createSdk(config)) {
            // TODO do something with the SDK
            // Stop the SDK when you do not need it anymore.
        } catch (Exception e) {
            // TODO do something with the exception
            e.printStackTrace();
        }
        // end of example
    }

    /**
     * Subscribes to device state changes.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Observer
     */

    @Example
    public void subscribeToDeviceStateChanges() {
        ConnectionOptions config = Configuration.get();
        config.autostartDaemon(false);
        try (Sdk sdk = Sdk.createSdk(config)) {
            // an example: subscribing to device state changes
            // Creating an Observer listening to device state changes for devices whose id starts with 016 and for
            // devices which are newly registered or expired. Such device state changes are then printed to the console
            // when they occur.
            // For more information about backpressure strategies, please have a look at related documentation:
            // https://github.com/ReactiveX/RxJava/wiki/Backpressure
            sdk.subscribe(DeviceStateFilterOptions.newFilter().likeDevice("016%")
                                                  .inDeviceStates(Arrays.asList(DeviceState.REGISTRATION,
                                                                                DeviceState.EXPIRED_REGISTRATION)),
                          BackpressureStrategy.BUFFER)
               .flow().subscribe(System.out::println);

            // Listening to device state changes for 2 minutes.
            Thread.sleep(120000); // TODO do some actual work in your application
            // Removing all subscriptions registered server side
            sdk.unsubscribeAll();
            // Stopping the SDK when no longer needed.
            sdk.quit();
            // end of example

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Subscribes to a resource value change.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Observer
     */

    @Example
    public void subscribeToDeviceValueChanges() {
        ConnectionOptions config = Configuration.get();
        config.autostartDaemon(false);
        try (Sdk sdk = Sdk.createSdk(config)) {
            // an example: subscribing to resource value changes
            // Creating an Observer listening to resource value changes for devices whose id starts with 016 and
            // resource paths starting with /3/0/. Such resource value changes are then printed to "standard out" when
            // they occur.
            // For more information about backpressure strategies, please have a look at related documentation:
            // https://github.com/ReactiveX/RxJava/wiki/Backpressure
            // For more information about First Value strategies, have a look at
            // com.arm.mbed.cloud.sdk.subscribe.model.FirstValue
            sdk.subscribe(SubscriptionFilterOptions.newFilter().likeDevice("016%").likeResourcePath("/3/0/%"),
                          BackpressureStrategy.BUFFER, FirstValue.ON_VALUE_UPDATE)
               .flow().subscribe(System.out::println);
            // Listening to resource value changes for 2 minutes.
            Thread.sleep(120000); // TODO do some actual work in your application
            // cloak
            // Checking that an observer was created
            assertTrue(sdk.subscribe().hasObservers());
            // Notifying a device change
            sdk.subscribe().notify(SubscriptionType.NOTIFICATION,
                                   new ResourceValueNotification("016546546465", "/3/0/5").payload("TEST"));
            // uncloak
            // Stopping the SDK when no longer needed.
            sdk.quit();
            // end of example

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Subscribes to a newly registered device.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Observer
     */

    @Example
    public void subscribeToNewRegisteredDeviceStateChanges() {
        ConnectionOptions config = Configuration.get();
        try (Sdk sdk = Sdk.createSdk(config.autostartDaemon(false))) {
            // an example: subscribing to newly registered devices
            // Creating an Observer listening to device state changes for
            // devices which are newly registered.
            // For more information about backpressure strategies, please have a look at related documentation:
            // https://github.com/ReactiveX/RxJava/wiki/Backpressure

            sdk.subscribe(DeviceStateFilterOptions.newFilter().equalDeviceState(DeviceState.REGISTRATION),
                          BackpressureStrategy.BUFFER)
               .flow().timeout(80, TimeUnit.SECONDS).subscribe(System.out::println);

            // Listening to device state changes for 1 minute.
            Thread.sleep(60000); // TODO do some other work in your application
            // cloak
            // Checking that an observer was created
            assertTrue(sdk.subscribe().hasObservers());
            // Notifying a device change
            sdk.subscribe().notify(SubscriptionType.DEVICE_STATE_CHANGE,
                                   new DeviceStateNotification(DeviceState.REGISTRATION, "A RANDOM DEVICE ID"));
            // uncloak
            // Stopping the SDK.
            sdk.stop();
            // end of example

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
