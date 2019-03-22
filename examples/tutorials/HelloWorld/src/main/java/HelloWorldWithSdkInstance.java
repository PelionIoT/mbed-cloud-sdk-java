
//an example: hello world with multiple API keys 
import com.arm.mbed.cloud.Sdk;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListOptions;

public class HelloWorldWithSdkInstance {
    // cloak
    private static final String ACCOUNT_ONE_API_KEY = "";
    private static final String ACCOUNT_TWO_API_KEY = "";

    // uncloak

    public static void main(String[] args) {
        // Create instances of the Pelion Device Management SDK for two accounts
        Sdk accountOne = Sdk.createSdk(ConnectionOptions.newConfiguration(ACCOUNT_ONE_API_KEY));
        Sdk accountTwo = Sdk.createSdk(ConnectionOptions.newConfiguration(ACCOUNT_TWO_API_KEY));
        try {
            // Listing the first 10 devices on the first account
            accountOne.foundation().getDeviceListDao().list((new DeviceListOptions()).maxResults(10))
                      .forEach(device -> System.out.println("Hello device " + device.getName()));
            // Listing the first 10 devices on the second account
            accountTwo.foundation().getDeviceListDao().list((new DeviceListOptions()).maxResults(10))
                      .forEach(device -> System.out.println("Hello device " + device.getName()));

        } catch (MbedCloudException exception) {
            exception.printStackTrace();
        } finally {
            accountOne.close();
            accountTwo.close();
        }

    }

}
// end of example
