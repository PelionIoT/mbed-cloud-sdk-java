
//an example: hello world
import java.io.IOException;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListDao;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListOptions;

public class HelloWorld {

    public static void main(String[] args) {

        try (DeviceListDao dao = new DeviceListDao()) {

            // Listing the first 10 devices on your Pelion Device Management account
            dao.list((new DeviceListOptions()).maxResults(10))
               .forEach(device -> System.out.println("Hello device " + device.getName()));

        } catch (MbedCloudException | IOException exception) {
            exception.printStackTrace();
        }
    }

}
// end of example
