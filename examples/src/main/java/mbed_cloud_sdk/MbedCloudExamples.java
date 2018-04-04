package mbed_cloud_sdk;

import static org.junit.Assert.fail;

import java.util.Arrays;

import com.arm.mbed.cloud.sdk.MbedCloud;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceState;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;

import io.reactivex.BackpressureStrategy;
import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class MbedCloudExamples extends AbstractExample {

    /**
     * Subscribes to device state changes.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Observer
     */

    @Example
    public void subscribeToDeviceStateChanges() {
        ConnectionOptions config = Configuration.get();
        MbedCloud sdk = MbedCloud.createSdk(config);
        try {
            // an example: subscribing to device state changes
            // Creating an Observer listening to device state changes for devices whose ids start with 016 and for
            // devices which are newly registered or expired. Such device state changes are then printed when they
            // occur.
            // For more information about backpressure strategies, please have a look at related documentation:
            // https://github.com/ReactiveX/RxJava/wiki/Backpressure
            sdk.subscribe(
                    DeviceStateFilterOptions.newFilter().likeDevice("016%")
                            .inDeviceStates(Arrays.asList(DeviceState.REGISTRATION, DeviceState.EXPIRED_REGISTRATION)),
                    BackpressureStrategy.BUFFER).flow().subscribe(System.out::println);

            // Listening to device state changes for 2 minutes.
            Thread.sleep(120000);

            // Stopping the SDK.
            sdk.stop();
            // end of example

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
