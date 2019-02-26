
// an example: hello world

import com.arm.mbed.cloud.sdk.Sdk;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListDao;

public class App {
    private static final String MY_KEY = "A valid API key";

    public static void main(String[] args) {
        // Create a configuration object based on the supplied API key
        ConnectionOptions config = ConnectionOptions.newConfiguration(MY_KEY);

        // Open an SDK context based on this configuration
        try (Sdk sdk = new Sdk(config)) {

            // Listing all devices on our Pelion Cloud account
            DeviceListDao allDevices = sdk.entities().getDeviceListDao();

            // Print out some basic information about the devices found here
            allDevices.list().forEach(d -> System.out.println("Device with ID='" + d.getId() + "' is in '"
                                                              + d.getState() + "' state."));

        } catch (MbedCloudException exception) {
            // If something went wrong, print an exception stacktrace
            exception.printStackTrace();
        }

        // The SDK will be automatically closed at this point
    }

}
// end of example
