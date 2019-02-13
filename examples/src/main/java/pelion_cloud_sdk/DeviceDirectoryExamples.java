package pelion_cloud_sdk;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.UUID;
import java.util.stream.StreamSupport;

import com.arm.mbed.cloud.sdk.DeviceDirectory;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceEvent;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceEventListOptions;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceState;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Query;
import com.arm.mbed.cloud.sdk.devicedirectory.model.QueryListOptions;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class DeviceDirectoryExamples extends AbstractExample {
    /**
     * Creates, updates and deletes a device.
     */
    @Example
    public void manageDevices() {
        ConnectionOptions config = Configuration.get();
        DeviceDirectory api = new DeviceDirectory(config);
        String deviceId = null;
        try {
            // Creating a device.
            String certificateIssuerId = UUID.randomUUID().toString();
            log("Certificate Issuer Id", certificateIssuerId);
            String certificateFingerprint = UUID.randomUUID().toString();
            log("Certificate Fingerprint", certificateFingerprint);
            Device myDevice = new Device(certificateIssuerId, certificateFingerprint);
            myDevice.setName("my-test-device-" + UUID.randomUUID().toString());
            myDevice.setDeviceExecutionMode(Integer.valueOf(1));

            // Adding the device.
            myDevice = api.addDevice(myDevice);
            log("Created device", myDevice);
            deviceId = myDevice.getId();

            // Updating the device.
            certificateIssuerId = UUID.randomUUID().toString();
            log("Updated Certificate Issuer Id", certificateIssuerId);
            myDevice.setCertificateIssuerId(certificateIssuerId);
            myDevice = api.updateDevice(myDevice);
            log("Updated device", myDevice);
            deviceId = myDevice.getId();

            // Deleting the device.
            deleteCreatedDevice(deviceId, api);
        } catch (Exception e) {
            logError("last API Metadata", api.getLastApiMetadata());
            deleteCreatedDevice(deviceId, api);
            fail(e.getMessage());
        }
    }

    private void deleteCreatedDevice(String deviceId, DeviceDirectory api) {
        try {
            if (deviceId != null) {
                api.deleteDevice(deviceId);
            }
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Creates, updates and deletes a query.
     */
    @Example
    public void manageQueries() {
        ConnectionOptions config = Configuration.get();
        DeviceDirectory api = new DeviceDirectory(config);
        String queryId = null;
        try {
            // Creating a query.
            String queryName = "test-" + UUID.randomUUID().toString();
            log("Query name", queryName);
            Query myQuery = new Query(queryName, null);
            myQuery.addCreatedAtFilter(new Date(), FilterOperator.LESS_THAN);

            // Adding the query.
            myQuery = api.addQuery(myQuery);
            log("Created query", myQuery);
            queryId = myQuery.getId();

            // Updating the query.
            queryName = "test-" + UUID.randomUUID().toString();
            log("Updated Query name", queryName);
            myQuery.setName(queryName);
            myQuery = api.updateQuery(myQuery);
            log("Updated query", myQuery);
            queryId = myQuery.getId();

            // Fetching the query.
            myQuery = api.getQuery(queryId);
            log("Retrieved query", myQuery);

            // Finding the first 5 devices corresponding to the query.
            DeviceListOptions options = new DeviceListOptions();
            options.setFilters(myQuery.fetchFilters());
            options.setPageSize(Integer.valueOf(5));
            ListResponse<Device> matchingDevices = api.listDevices(options);
            for (Device device : matchingDevices.getData()) {
                log("Matching device", device);
            }

        } catch (Exception e) {
            logError("last API Metadata", api.getLastApiMetadata());
            fail(e.getMessage());
        } finally {
            // Deleting the query.
            deleteCreatedQuery(queryId, api);
        }
    }

    private void deleteCreatedQuery(String queryId, DeviceDirectory api) {
        try {
            if (queryId != null) {
                api.deleteQuery(queryId);
            }
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Lists the first 900 devices in the Cloud and log their status.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Paginator
     */
    @Example
    public void listDevices() {
        ConnectionOptions config = Configuration.get();
        // an example: list devices in Mbed Cloud
        // Creating an instance of the SDK
        try (DeviceDirectory api = new DeviceDirectory(config)) {
            // Getting a paginator over the first 900 devices present in the Cloud.
            // In the Java SDK, all listing APIs start with 'list'. When the method name also contains 'All',
            // the corresponding paginator is returned. Otherwise, a ListResponse (i.e. only one page) is returned.
            Paginator<Device> paginator = api.listAllDevices(DeviceListOptions.newOptions().maxResults(900)
                                                                              .order(Order.ASC));
            // For each device found, log their ID and State.
            StreamSupport.stream(paginator.spliterator(), false)
                         .map(device -> device.getId() + " [" + device.getState() + "]").forEach(d -> log("Device", d));
        }
        // end of example
        catch (Exception e) {
            logError("Exception", e);
            fail(e.getMessage());
        }
    }

    /**
     * Lists the last 900 deregistered devices in the Cloud and log their id.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Paginator
     */
    @Example
    public void listDeregisteredDevices() {
        ConnectionOptions config = Configuration.get();
        // an example: list deregistered devices in Mbed Cloud
        // Creating an instance of the SDK
        try (DeviceDirectory api = new DeviceDirectory(config)) {
            // Setting the listing options (i.e. limit the number of results to 900 and order the results in the reverse
            // order)
            DeviceListOptions options = DeviceListOptions.newOptions().maxResults(900).order(Order.DESC);
            // Setting a filter
            options.addStateFilter(DeviceState.DEREGISTERED, FilterOperator.EQUAL);
            // Getting a paginator over the last 900 deregistered devices present in the Cloud.
            // In the Java SDK, all listing APIs start with 'list'. When the method name also contains 'All',
            // the corresponding paginator is returned. Otherwise, a ListResponse (i.e. only one page) is returned.
            Paginator<Device> paginator = api.listAllDevices(options);
            // For each device found, log their ID and State.
            StreamSupport.stream(paginator.spliterator(), false)
                         .map(device -> device.getId() + " [" + device.getState() + "]")
                         .forEach(d -> log("Deregistered device", d));
        }
        // end of example
        catch (Exception e) {
            logError("Exception", e);
            fail(e.getMessage());
        }
    }

    /**
     * Lists the first 5 current queries.
     */
    @Example
    public void listQueries() {
        ConnectionOptions config = Configuration.get();
        try (DeviceDirectory api = new DeviceDirectory(config)) {
            // Defining listing options.
            QueryListOptions options = new QueryListOptions();
            options.setPageSize(5);
            // Listing queries.
            ListResponse<Query> queries = api.listQueries(options);
            for (Query query : queries.getData()) {
                log("Query", query);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Lists the first 5 device events.
     */
    @Example
    public void listDeviceEvents() {
        ConnectionOptions config = Configuration.get();
        try (DeviceDirectory api = new DeviceDirectory(config)) {
            // Defining query options.
            DeviceEventListOptions options = new DeviceEventListOptions();
            options.setPageSize(Integer.valueOf(5));
            // Listing device events in a page.
            ListResponse<DeviceEvent> events = api.listDeviceEvents(options);
            for (DeviceEvent event : events.getData()) {
                log("Device event", event);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
