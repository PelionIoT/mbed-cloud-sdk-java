package pelion_cloud_sdk;

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.functions.Consumer;

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.common.CallLogLevel;
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
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceState;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

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
        try (Connect api = new Connect(config)) {
            DeviceListOptions options = new DeviceListOptions();

            // Note: month is zero-based
            options.addCreatedAtFilter(new GregorianCalendar(2017, 10, 1).getTime(), FilterOperator.GREATER_THAN);
            options.addCreatedAtFilter(new GregorianCalendar(2017, 11, 1).getTime(), FilterOperator.LESS_THAN);
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
        try (Connect api = new Connect(config)) {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setPageSize(Integer.valueOf(1));
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
            fail(e.getMessage());
        }
    }

    /**
     * Gets a resource value.
     */
    @Example
    public void getResourceValue() {
        ConnectionOptions config = Configuration.get();
        // resource path to get value from
        String resourcePath = "/3/0/13";
        try (Connect api = new Connect(config)) {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setMaxResults(1l);

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
            fail(e.getMessage());
        }
    }

    /**
     * Sets a resource value.
     */
    @Example
    public void setResourceValue() {
        ConnectionOptions config = Configuration.get();
        // writable resource path to set a value to
        String resourcePath = "/5001/0/1";
        try (Connect api = new Connect(config)) {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setPageSize(1);
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
        try (Connect api = new Connect(config.logLevel(CallLogLevel.BODY))) {
            // Listing already defined presubscriptions.
            List<Presubscription> listPresubscriptions = api.listPresubscriptions();
            if (listPresubscriptions != null) {
                for (Presubscription presubscription : listPresubscriptions) {
                    log("Already defined presubscription", presubscription);
                }
            }
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setPageSize(Integer.valueOf(1));
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

            for (Resource resourceToSubscribeTo : observableResources) {
                Presubscription presubscription = new Presubscription(resourceToSubscribeTo);
                log("New presubscription", presubscription);
                api.addPresubscription(presubscription);
            }
            // Listing all defined presubscriptions.
            listPresubscriptions = api.listPresubscriptions();
            for (Presubscription presubscription : listPresubscriptions) {
                log("Deleting Newly defined presubscription", presubscription);
                api.deletePresubscription(presubscription);
            }
            // Deleting all presubscriptions present on the system.
            api.deletePresubscriptions();
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Lists metrics from last 30 days in 1-day intervals.
     */
    @Example
    public void listLast30DaysMetric() {
        ConnectionOptions config = Configuration.get();
        try (Connect api = new Connect(config)) {
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
            fail(e.getMessage());
        }
    }

    /**
     * Lists metrics from last 2 days in 3-hour intervals.
     */
    @Example
    public void listLast2DaysMetric() {
        ConnectionOptions config = Configuration.get();
        try (Connect api = new Connect(config)) {
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
            fail(e.getMessage());
        }
    }

    /**
     * Lists metrics for March 2018.
     */
    @Example
    public void listMarch2018Metric() {
        ConnectionOptions config = Configuration.get().logLevel(CallLogLevel.BODY);
        try (Connect api = new Connect(config)) {
            // Defining query options.
            MetricsStartEndListOptions options = new MetricsStartEndListOptions();
            options.setStart(new GregorianCalendar(2018, 2, 1).getTime());
            options.setEnd(new GregorianCalendar(2018, 3, 1).getTime());
            // Listing metrics data.
            Paginator<Metric> metrics = api.listAllMetrics(options);
            for (Metric metric : metrics) {
                log("Metric", metric);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Subscribes to a resource with callbacks.
     * <p>
     *
     * @see #subscribeToResourceValueChanges()
     */
    @Deprecated
    @SuppressWarnings("null")
    @Example
    public void subscribeToResourcesWithCallbacks() {
        ConnectionOptions config = Configuration.get();
        try (Connect api = new Connect(config)) {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setPageSize(1);
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
            fail(e.getMessage());
        }
    }

    /**
     * Subscribes to a resource with observable streams.
     * <p>
     * Note: for more information about observable streams, see also <a href="http://reactivex.io/">Reactive X</a>
     * <p>
     *
     * @see #subscribeToResourceValueChanges()
     */
    @Deprecated
    @Example
    public void subscribeToResourcesWithObservableStreams() {
        ConnectionOptions config = Configuration.get();
        try (Connect api = new Connect(config)) {
            // Getting a connected device.
            DeviceListOptions options = new DeviceListOptions();
            options.setPageSize(Integer.valueOf(1));
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
            fail(e.getMessage());
        }
    }

    /**
     * Subscribes to device state changes.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Observer
     */

    @Example
    public void subscribeToDeviceStateChanges() {
        ConnectionOptions config = Configuration.get();
        Connect api = null;
        try {
            api = new Connect(config);
            // Creating an Observer listening to device state changes for devices whose ids start with 016 and for
            // devices which are newly registered or expired.
            // For more information about backpressure strategies, please have a look at related documentation:
            // https://github.com/ReactiveX/RxJava/wiki/Backpressure
            DeviceStateObserver observer = api.subscribe()
                                              .deviceStateChanges(DeviceStateFilterOptions.newFilter()
                                                                                          .likeDevice("016%")
                                                                                          .inDeviceStates(Arrays.asList(DeviceState.REGISTRATION,
                                                                                                                        DeviceState.EXPIRED_REGISTRATION)),
                                                                  BackpressureStrategy.BUFFER);
            // Printing device changes when they happen.
            observer.flow().subscribe(System.out::println);
            // Listening to device state changes for 2 minutes.
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
     * Subscribes to resource value changes.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Observer
     */

    @Example
    public void subscribeToResourceValueChanges() {
        ConnectionOptions config = Configuration.get();
        try (Connect api = new Connect(config)) {
            // Creating an Observer listening to resource value changes for devices whose ids start with 016 and
            // resource paths starting with /3/0/.
            // For more information about backpressure strategies, please have a look at related documentation:
            // https://github.com/ReactiveX/RxJava/wiki/Backpressure
            // For more information about First Value strategies, have a look at
            // com.arm.mbed.cloud.sdk.subscribe.model.FirstValue
            ResourceValueObserver observer = api.subscribe()
                                                .resourceValues(SubscriptionFilterOptions.newFilter().likeDevice("016%")
                                                                                         .likeResourcePath("/3/0/%"),
                                                                BackpressureStrategy.BUFFER,
                                                                FirstValue.ON_VALUE_UPDATE);
            // Printing resource value notification when they happen.
            observer.flow().subscribe(System.out::println);
            // Listening to resource value changes for 2 minutes.
            Thread.sleep(120000);

            // Stopping notification pull channel.
            api.stopNotifications();
            Thread.sleep(100);
            api.shutdownConnectService();
        } catch (Exception e) {
            e.printStackTrace();
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
        try (Connect api = new Connect(config)) {
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
     * Uses a webhook for notifications
     */
    @Example
    public void useServerInitiatedNotificationChannel() {
        ConnectionOptions config = Configuration.get().autostartDaemon(false);
        // an example: using a webhook for handling notifications from Mbed Cloud
        Connect api = new Connect(config);

        // cloak
        // Telling the API to stop notification channel if already in use
        api.setForceClear(true);
        try {
            // uncloak
            // Describing a webhook to use (i.e. a publicly available webserver accepting POST request).
            Webhook webhook = new Webhook(new URL("http://mbedcloudjavawebhooktest.requestcatcher.com/test"));
            log("Webhook", webhook);
            // Registering the webhook to Mbed Cloud.
            api.updateWebhook(webhook);
            // Defining a resource to listen to
            String resourcePath = "/5002/0/1";
            log("Resource path of interest", resourcePath);
            // Subscribing to the resource value changes
            api.subscribe().resourceValues(SubscriptionFilterOptions.newFilter().equalResourcePath(resourcePath),
                                           BackpressureStrategy.MISSING)
               .flow().subscribe();
            // Ensuring the webhook has been correctly registered
            log("Registered webhook", api.getWebhook());
            // Waiting for notifications to be sent to the webhook.
            Thread.sleep(60000);// TODO do some actual work in your application
            // Deleting the webhook when it is no longer needed.
            api.deleteWebhook();
            // end of example
        } catch (Exception e) {
            logError("Exception", e);
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
