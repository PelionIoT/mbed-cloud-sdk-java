import com.arm.mbed.cloud.sdk.DeviceDirectory;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

public class App {

    public static void main(String[] args) {
        // Instantiating the API with Mbed Cloud credentials
        DeviceDirectory api = new DeviceDirectory(ConnectionOptions.newConfiguration("an API KEY"));

        // Listing all devices on our Mbed Cloud account
        try {
            api.listAllDevices(null)
                    .forEach(d -> System.out.println("Hello Thing " + d.getId() + " [" + d.getState() + "]"));
        } catch (MbedCloudException e) {
            e.printStackTrace();
        }
    }
}
