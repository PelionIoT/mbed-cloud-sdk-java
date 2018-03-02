package mbed_cloud_sdk;

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.connect.model.MetricsPeriodListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsStartEndListOptions;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationData;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;

import io.reactivex.BackpressureStrategy;
import io.reactivex.functions.Consumer;
import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class ConnectExamples extends AbstractExample {
    /**
     * Finds all devices currently connected and created in November 2017.
     */
    @Example
    public void listConnectedDevice() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            DeviceListOptions options = new DeviceListOptions();
            options.addCreatedAtFilter(new GregorianCalendar(2017, 10, 1).getTime(), FilterOperator.GREATER_THAN);
            options.addCreatedAtFilter(new GregorianCalendar(2017, 10, 30).getTime(), FilterOperator.LESS_THAN);
            Paginator<Device> devices = api.listAllConnectedDevices(options);
            for (Device device : devices) {
                log("Connected device created in November 2017", device);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Lists device resources.
     */
    @Example
    public void listDeviceResources() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setLimit(Integer.valueOf(1));
            Paginator<Device> deviceIterator = api.listAllConnectedDevices(options);
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            Device device = deviceIterator.first();
            log("Device", device);
            // Listing all device's resource.
            List<Resource> resources = api.listResources(device);
            for (Resource resource : resources) {
                log("Resource present on device", resource);
            }
        } catch (Exception e) {
            logError("last API Metadata", api.getLastApiMetadata());
            fail(e.getMessage());
        }
    }

    /**
     * Gets a resource value.
     */
    @SuppressWarnings("boxing")
    @Example
    public void getResourceValue() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        // resource path to get value from
        String resourcePath = "/5001/0/1";
        try {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setLimit(1);

            Paginator<Device> deviceIterator = api.listAllConnectedDevices(options);
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            Device device = deviceIterator.first();
            log("Device", device);
            Resource resourceToConsider = api.getResource(device, resourcePath);
            if (resourceToConsider == null) {
                fail("The resource of interest does not exist on this device");
            }
            log("Resource of interest", resourceToConsider);
            // Getting resource value
            Object value = api.getResourceValue(resourceToConsider, new TimePeriod(10));
            log("Resource value", value);
            // Stopping potential daemons running
            api.stopNotifications();
            api.shutdownConnectService();
        } catch (Exception e) {
            e.printStackTrace();
            logError("last API Metadata", api.getLastApiMetadata());
            try {
                api.stopNotifications();
            } catch (MbedCloudException e1) {
                e1.printStackTrace();
            }
            api.shutdownConnectService();
            fail(e.getMessage());
        }
    }

    /**
     * Sets a resource value.
     */
    @SuppressWarnings("boxing")
    @Example
    public void setResourceValue() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        // writable resource path to set a value to
        String resourcePath = "/5001/0/1";
        try {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setLimit(1);
            Paginator<Device> deviceIterator = api.listAllConnectedDevices(options);
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            Device device = deviceIterator.next();
            log("Device", device);
            Resource resourceToConsider = api.getResource(device, resourcePath);
            log("Resource of interest", resourceToConsider);
            if (resourceToConsider == null) {
                fail("The resource of interest does not exist on this device");
            }
            // Getting resource value
            Object value = api.getResourceValue(resourceToConsider, new TimePeriod(10));
            log("Current resource value", value);
            // Setting a new resource value
            api.setResourceValue(resourceToConsider, "10", new TimePeriod(10));
            // Getting the modified resource value
            value = api.getResourceValue(resourceToConsider, new TimePeriod(10));
            log("Newly set resource value", value);
            // Stopping potential daemons running
            api.stopNotifications();
            api.shutdownConnectService();
        } catch (Exception e) {
            e.printStackTrace();
            logError("last API Metadata", api.getLastApiMetadata());
            try {
                api.stopNotifications();
            } catch (MbedCloudException e1) {
                e1.printStackTrace();
            }
            api.shutdownConnectService();
            fail(e.getMessage());
        }
    }

    /**
     * Creates, updates and deletes a presubscription.
     */
    @SuppressWarnings("null")
    @Example
    public void managePresubscription() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Listing already defined presubscriptions.
            List<Presubscription> listPresubscriptions = api.listPresubscriptions();
            for (Presubscription presubscription : listPresubscriptions) {
                log("Already defined presubscription", presubscription);
            }
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setLimit(Integer.valueOf(1));
            Paginator<Device> deviceIterator = api.listAllConnectedDevices(options);
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            Device device = deviceIterator.next();
            log("Device", device);
            // Adding presubscriptions on all observable resources of a device.
            List<Resource> observableResources = api.listObservableResources(device);
            if (observableResources == null) {
                fail("There is no observable resources on this device");
            }
            List<Presubscription> newPresubscriptions = new LinkedList<>();
            for (Resource resourceToSubscribeTo : observableResources) {
                Presubscription presubscription = new Presubscription(resourceToSubscribeTo);
                newPresubscriptions.add(presubscription);
                log("New presubscription", presubscription);
            }
            api.updatePresubscriptions(newPresubscriptions);
            // Listing all defined presubscriptions.
            listPresubscriptions = api.listPresubscriptions();
            for (Presubscription presubscription : listPresubscriptions) {
                log("Newly defined presubscription", presubscription);
            }
            // Deleting all presubscriptions present on the system.
            api.deletePresubscriptions();
        } catch (Exception e) {
            logError("last API Metadata", api.getLastApiMetadata());
            fail(e.getMessage());
        }
    }

    /**
     * Lists metrics from last 30 days in 1-day intervals.
     */
    @Example
    public void listLast30DaysMetric() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Defining query options.
            MetricsPeriodListOptions options = new MetricsPeriodListOptions();
            options.setPeriod("30d");
            options.setInterval("1d");
            // Listing metrics data.
            Paginator<Metric> metrics = api.listAllMetrics(options);
            for (Metric metric : metrics) {
                log("Metric", metric);
            }
        } catch (Exception e) {
            logError("last API Metadata", api.getLastApiMetadata());
            fail(e.getMessage());
        }
    }

    /**
     * Lists metrics from last 2 days in 3-hour intervals.
     */
    @Example
    public void listLast2DaysMetric() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Defining query options.
            MetricsPeriodListOptions options = new MetricsPeriodListOptions();
            options.setPeriod("2d");
            options.setInterval("3h");
            // Listing metrics data.
            Paginator<Metric> metrics = api.listAllMetrics(options);
            for (Metric metric : metrics) {
                log("Metric", metric);
            }
        } catch (Exception e) {
            logError("last API Metadata", api.getLastApiMetadata());
            fail(e.getMessage());
        }
    }

    /**
     * Lists metrics for March 2017.
     */
    @Example
    public void listMarch2017Metric() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Defining query options.
            MetricsStartEndListOptions options = new MetricsStartEndListOptions();
            options.setStart(new GregorianCalendar(2017, 2, 1).getTime());
            options.setEnd(new GregorianCalendar(2017, 3, 1).getTime());
            // Listing metrics data.
            Paginator<Metric> metrics = api.listAllMetrics(options);
            for (Metric metric : metrics) {
                log("Metric", metric);
            }
        } catch (Exception e) {
            logError("last API Metadata", api.getLastApiMetadata());
            fail(e.getMessage());
        }
    }

    /**
     * Subscribes to a resource with callbacks.
     */
    @SuppressWarnings({ "boxing", "null" })
    @Example
    public void subscribeToResourcesWithCallbacks() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setLimit(1);
            Paginator<Device> deviceIterator = api.listAllConnectedDevices(options);
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            Device device = deviceIterator.next();
            log("Device", device);
            List<Resource> observableResources = api.listObservableResources(device);
            if (observableResources == null) {
                fail("There is no observable resources on this device");
            }
            for (final Resource resourceToSubscribeTo : observableResources) {
                log("Resource suscribed", resourceToSubscribeTo);
                // Creating a subscriber for each resource.
                if (resourceToSubscribeTo != null) {
                    // Defining callbacks.
                    Callback<Object> onNotificationCallback = new Callback<Object>() {

                        @Override
                        public void execute(Object arg) {
                            log("Received notification value for " + resourceToSubscribeTo + " using callbacks", arg);

                        }
                    };
                    Callback<Throwable> onErrorCallback = new Callback<Throwable>() {

                        @Override
                        public void execute(Throwable t) {
                            log("Received following error for " + resourceToSubscribeTo, t);

                        }
                    };
                    api.addResourceSubscription(resourceToSubscribeTo, onNotificationCallback, onErrorCallback);
                }
            }
            // Listening to notifications for 2 minutes.
            api.startNotifications();
            Thread.sleep(120000);
            // Stopping notification pull channel.
            api.stopNotifications();
            Thread.sleep(100);
            api.shutdownConnectService();

        } catch (Exception e) {
            e.printStackTrace();
            logError("last API Metadata", api.getLastApiMetadata());
            try {
                api.stopNotifications();
                Thread.sleep(100);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            api.shutdownConnectService();
            fail(e.getMessage());
        }
    }

    /**
     * Subscribes to a resource with observable streams.
     * <p>
     * Note: for more information about observable streams, see also <a href="http://reactivex.io/">Reactive X</a>
     */
    @SuppressWarnings({ "boxing", "null" })
    @Example
    public void subscribeToResourcesWithObservableStreams() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setLimit(1);
            Paginator<Device> deviceIterator = api.listAllConnectedDevices(options);
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            Device device = deviceIterator.next();
            log("Device", device);
            List<Resource> observableResources = api.listObservableResources(device);
            if (observableResources == null) {
                fail("There is no observable resources on this device");
            }
            for (Resource resourceToSubscribeTo : observableResources) {
                log("Resource suscribed", resourceToSubscribeTo);
                // Adding subscription for each resource.
                if (resourceToSubscribeTo != null) {
                    api.addResourceSubscription(resourceToSubscribeTo, BackpressureStrategy.BUFFER)
                            .subscribe(generateSubscriptionConsumer(resourceToSubscribeTo));
                }
            }
            // Listening to notifications for 2 minutes.
            api.startNotifications();
            Thread.sleep(120000);
            // Stopping notification pull channel.
            api.stopNotifications();
            Thread.sleep(100);
            api.shutdownConnectService();

        } catch (Exception e) {
            e.printStackTrace();
            logError("last API Metadata", api.getLastApiMetadata());
            try {
                api.stopNotifications();
                Thread.sleep(100);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            api.shutdownConnectService();
            fail(e.getMessage());
        }
    }

    // Defines action to perform on notification.
    private Consumer<Object> generateSubscriptionConsumer(final Resource resource) {
        return new Consumer<Object>() {

            @Override
            public void accept(Object t) throws Exception {
                log("Received notification value for " + resource + " using observable streams", t);
            }
        };
    }

    /**
     * Injects notifications to the notification system.
     */
    @Example
    public void injectNotifications() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Creating notifications.
            String[] payloads = { "Q2hhbmdlIG1lIQ==", "VGhpcyBpcyB2YWx1ZSAy", "VGhpcyBpcyBhbm90aGVyIHZhbHVl",
                    "VGhpcyB3aWxsIGJlIG15IGxhc3Qgbm90aWZpY2F0aW9uIGJlY2F1c2UgSSBhbSB3aWxsaW5nIHRvIGdvIGJhY2sgdG8gc2xlZXA=" };
            List<String> payloadList = Arrays.asList(payloads);
            String deviceId = "015f4ac587f500000000000100100249";
            String resourcePath = "/3200/0/5501";
            NotificationMessage notifications = new NotificationMessage();
            for (String payload : payloadList) {
                NotificationData notification = new NotificationData();
                notification.setEp(deviceId);
                notification.setPath(resourcePath);
                notification.setPayload(payload);
                notifications.addNotificationsItem(notification);
            }
            // Creating the same notifications but using their JSON representation instead.
            String otherNotifications = "{\"notifications\":[{\"path\":\"/3200/0/5501\",\"payload\":\"Q2hhbmdlIG1lIQ\u003d\u003d\",\"ep\":\"015f4ac587f500000000000100100249\"},{\"path\":\"/3200/0/5501\",\"payload\":\"VGhpcyBpcyB2YWx1ZSAy\",\"ep\":\"015f4ac587f500000000000100100249\"}"
                    + ",{\"path\":\"/3200/0/5501\",\"payload\":\"VGhpcyBpcyBhbm90aGVyIHZhbHVl\",\"ep\":\"015f4ac587f500000000000100100249\"},{\"path\":\"/3200/0/5501\",\"payload\":\"VGhpcyB3aWxsIGJlIG15IGxhc3Qgbm90aWZpY2F0aW9uIGJlY2F1c2UgSSBhbSB3aWxsaW5nIHRvIGdvIGJhY2sgdG8gc2xlZXA\u003d\",\"ep\":\"015f4ac587f500000000000100100249\"}]}";

            Resource resource = new Resource(deviceId, resourcePath);
            // Creating a subscriber for this resource.
            api.createResourceSubscriptionObserver(resource, BackpressureStrategy.BUFFER)
                    .subscribe(new Consumer<Object>() {

                        @Override
                        public void accept(Object t) throws Exception {
                            log("Received notification value", t);
                        }
                    });
            // Emitting notifications.
            api.notify(notifications);
            api.notify(otherNotifications);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Sets up a webhook for notifications
     */
    @Example
    public void setUpAWebhook() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        // Telling the API to stop notification channel if already in use
        api.setForceClear(true);
        try {
            // Defining resource to listen to
            String resourcePath = "/5002/0/1";
            log("Resource path of interest", resourcePath);
            // Creating webhook.
            Webhook webhook = new Webhook(new URL("http://mbedcloudjavawebhooktest.requestcatcher.com/test"));
            log("Webhook", webhook);
            // Setting up webhook.
            api.updateWebhook(webhook);
            Thread.sleep(2000);
            // Adding subscription to all connected devices.
            Paginator<Device> connectedDevices = api.listAllConnectedDevices(null);
            for (Device connectedDevice : connectedDevices) {
                try {
                    Resource resource = api.getResource(connectedDevice, resourcePath);
                    if (resource != null) {
                        api.addResourceSubscription(resource);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    logError("An error occurred when trying to fetch Resource [" + resourcePath + "] on device: "
                            + connectedDevice, api.getLastApiMetadata());
                }
            }
            // Waiting for notifications to be sent to the webhook.
            Thread.sleep(60000);
            // Deleting the webhook.
            deleteWebhook(api);
        } catch (Exception e) {
            e.printStackTrace();
            logError("last API Metadata", api.getLastApiMetadata());
            deleteWebhook(api);
            fail(e.getMessage());
        }
    }

    /**
     * Switches between notification channels.
     */
    @Example
    public void switchNotificationChannel() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Using Notification pull channel.
            api.startNotifications();
            Thread.sleep(5000);
            // Stopping notification pull channel.
            api.stopNotifications();
            Thread.sleep(100);
            // Starting a webhook channel.
            // Creating a webhook.
            Webhook webhook = new Webhook(new URL("http://mbedcloudjavawebhooktest.requestcatcher.com/test"));
            log("Webhook", webhook);
            // Setting up the webhook.
            api.updateWebhook(webhook);
            Thread.sleep(2000);
            // Stopping webhook channel.
            deleteWebhook(api);
            // Shutting down connect service.
            api.shutdownConnectService();
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                api.stopNotifications();
                Thread.sleep(100);
                api.shutdownConnectService();
                Thread.sleep(100);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            deleteWebhook(api);
        }
    }

    /**
     * Switches between notification channels using forceClear.
     * <p>
     * forceClear parameter forces a notification channel to stop before a new one is started.
     */
    @Example
    public void switchNotificationChannelWithForceClear() {
        ConnectionOptions config = Configuration.get();
        Connect api = new Connect(config);
        try {
            // Setting forceClear to true
            api.setForceClear(true);
            // Using Notification pull channel.
            api.startNotifications();
            Thread.sleep(5000);
            // Starting a webhook channel.
            // Creating a webhook.
            Webhook webhook = new Webhook(new URL("http://mbedcloudjavawebhooktest.requestcatcher.com/test"));
            log("Webhook", webhook);
            // Setting up the webhook.
            api.updateWebhook(webhook);
            Thread.sleep(2000);
            // Using Notification pull channel again.
            api.startNotifications();
            Thread.sleep(5000);
            // Shutting down connect service.
            api.shutdownConnectService();
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                api.shutdownConnectService();
                Thread.sleep(100);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            deleteWebhook(api);
        }
    }

    private void deleteWebhook(Connect api) {
        try {
            api.deleteWebhook();
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }

    }

}
