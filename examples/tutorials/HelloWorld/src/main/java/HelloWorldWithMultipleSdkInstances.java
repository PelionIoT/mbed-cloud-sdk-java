
//an example: hello world with sdk instance
import com.arm.mbed.cloud.Sdk;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListOptions;

public class HelloWorldWithMultipleSdkInstances {

    public static void main(String[] args) {

        // Create an instance of the Pelion Device Management SDK
        try (Sdk sdk = Sdk.createSdk(ConnectionOptions.newConfiguration())) {

            // Listing the first 10 devices on your Pelion Device Management account
            sdk.foundation().getDeviceListDao().list((new DeviceListOptions()).maxResults(10))
               .forEach(device -> System.out.println("Hello device " + device.getName()));

        } catch (MbedCloudException exception) {
            exception.printStackTrace();
        }

    }

}
// end of example
