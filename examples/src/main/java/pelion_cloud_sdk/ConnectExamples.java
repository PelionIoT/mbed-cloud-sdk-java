package pelion_cloud_sdk;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.functions.Consumer;

import com.arm.mbed.cloud.Sdk;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.connect.model.MetricsPeriodListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsStartEndListOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;
import com.arm.mbed.cloud.sdk.devices.model.Device;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListDao;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.devices.model.DeviceState;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

/**
 * Examples for interacting with devices.
 */
public class ConnectExamples extends AbstractExample {
    /**
     * Finds all devices currently connected and created in November 2017.
     */
    @Example
    public void listConnectedDevice() {
        try (Sdk sdk = Sdk.createSdk(Configuration.get()); DeviceListDao dao = sdk.foundation().getDeviceListDao()) {

            // Note: month is zero-based
            DeviceListOptions options = new DeviceListOptions().equalToState(DeviceState.REGISTERED)
                                                               .greaterThanCreatedAt(new GregorianCalendar(2017, 10,
                                                                                                           1).getTime())
                                                               .lessThanCreatedAt(new GregorianCalendar(2017, 11,
                                                                                                        1).getTime());

            Paginator<Device> devices = dao.list(options);
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
        try (Sdk sdk = Sdk.createSdk(Configuration.get()); DeviceListDao dao = sdk.foundation().getDeviceListDao()) {
            Paginator<Device> deviceIterator = dao.list(new DeviceListOptions().equalToState(DeviceState.REGISTERED)
                                                                               .maxResults(10));
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            Device device = deviceIterator.first();
            log("Device", device);
            // Listing all device's resource.
            List<Resource> resources = sdk.lowLevelRest().getConnectModule().listResources(device);
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
        // resource path to get value from
        String resourcePath = "/3/0/13";
        try (Sdk sdk = Sdk.createSdk(Configuration.get()); DeviceListDao dao = sdk.foundation().getDeviceListDao()) {
            Paginator<Device> deviceIterator = dao.list(new DeviceListOptions().equalToState(DeviceState.REGISTERED)
                                                                               .maxResults(10));
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            Device device = deviceIterator.first();
            log("Device", device);

            Resource resourceToConsider = sdk.lowLevelRest().getConnectModule().getResource(device, resourcePath);
            if (resourceToConsider == null) {
                fail("The resource of interest does not exist on this device");
            }
            log("Resource of interest", resourceToConsider);
            // Getting resource value
            Object value = sdk.lowLevelRest().getConnectModule().getResourceValue(resourceToConsider,
                                                                                  new TimePeriod(10));
            log("Resource value", value);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Sets a resource value.
     */
    @Example
    public void setResourceValue() {
        // an example: get and set a resource value
        try (Sdk sdk = Sdk.createSdk(Configuration.get()); DeviceListDao dao = sdk.foundation().getDeviceListDao()) {
            // Use the Foundation interface to find a device.
            Paginator<Device> deviceIterator = dao.list(new DeviceListOptions().equalToState(DeviceState.REGISTERED)
                                                                               .maxResults(1));
            // cloak
            if (!deviceIterator.hasNext()) {
                fail("No endpoints registered. Aborting.");
            }
            // uncloak
            Device device = deviceIterator.first();
            // cloak
            log("Device", device);
            // uncloak
            // Find an observable resource
            List<Resource> observableResources = sdk.lowLevelRest().getConnectModule().listObservableResources(device);
            // cloak
            assertNotNull(observableResources);
            assertFalse(observableResources.isEmpty());
            // uncloak
            Resource resource = observableResources.get(0);
            // cloak
            if (resource == null) {
                fail("The resource of interest does not exist on this device");
            }
            log("Resource of interest", resource);
            // uncloak
            // Getting resource value
            // cloak
            Object value = sdk.lowLevelRest().getConnectModule().getResourceValue(resource, new TimePeriod(10));
            log("Current resource value", value);
            // uncloak
            // Set a resource value
            sdk.lowLevelRest().getConnectModule().setResourceValue(resource, "12", new TimePeriod(10));
            // Get a resource value
            value = sdk.lowLevelRest().getConnectModule().getResourceValue(resource, new TimePeriod(10));
            // cloak
            log("Newly set resource value", value);
            // uncloak
            System.out.println("Device " + device.getId() + ", path " + resource.getPath() + ", current value: "
                               + value);
        } catch (Exception e) {
            e.printStackTrace();
            // cloak
            fail(e.getMessage());
            // uncloak
        }
        // end of example
    }

    /**
     * Lists metrics from last 30 days in 1-day intervals.
     */
    @Example
    public void listLast30DaysMetric() {
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Defining query options.
            MetricsPeriodListOptions options = new MetricsPeriodListOptions();
            options.setPeriod("30d");
            options.setInterval("1d");
            // Listing metrics data.
            Paginator<Metric> metrics = sdk.lowLevelRest().getConnectModule().listAllMetrics(options);
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
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Defining query options.
            MetricsPeriodListOptions options = new MetricsPeriodListOptions();
            options.setPeriod("2d");
            options.setInterval("3h");
            // Listing metrics data.
            Paginator<Metric> metrics = sdk.lowLevelRest().getConnectModule().listAllMetrics(options);
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
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Defining query options.
            MetricsStartEndListOptions options = new MetricsStartEndListOptions();
            options.setStart(new GregorianCalendar(2018, 2, 1).getTime());
            options.setEnd(new GregorianCalendar(2018, 3, 1).getTime());
            // Listing metrics data.
            Paginator<Metric> metrics = sdk.lowLevelRest().getConnectModule().listAllMetrics(options);
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

    /**
     * Subscribes to device state changes.
     * <p>
     * Note: This example introduces new high level abstraction objects such as Observer
     */

    @Example
    public void subscribeToDeviceStateChanges() {
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Creating an Observer listening to device state changes for devices whose ids start with 016 and for
            // devices which are newly registered or expired.
            // For more information about backpressure strategies, please have a look at related documentation:
            // https://github.com/ReactiveX/RxJava/wiki/Backpressure
            DeviceStateObserver observer = sdk.subscribe(DeviceStateFilterOptions.newFilter().likeDevice("016%")
                                                                                 .inDeviceStates(Arrays.asList(com.arm.mbed.cloud.sdk.subscribe.model.DeviceState.REGISTRATION,
                                                                                                               com.arm.mbed.cloud.sdk.subscribe.model.DeviceState.EXPIRED_REGISTRATION)),
                                                         BackpressureStrategy.BUFFER);
            // Printing device changes when they happen.
            observer.flow().subscribe(System.out::println);
            // Listening to device state changes for 2 minutes.
            Thread.sleep(120000);
        } catch (Exception e) {
            e.printStackTrace();
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
        // an example: subscribe to resource values
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Configure a subscription to receive resource value changes on all devices.
            // For more information about backpressure strategies, please have a look at related documentation:
            // https://github.com/ReactiveX/RxJava/wiki/Backpressure
            // For more information about First Value strategies, have a look at
            // com.arm.mbed.cloud.sdk.subscribe.model.FirstValue
            ResourceValueObserver observer = sdk.subscribe(SubscriptionFilterOptions.newFilter().likeDevice("%"),
                                                           BackpressureStrategy.BUFFER, FirstValue.ON_VALUE_UPDATE);
            // Print the subscription notifications received
            observer.flow().subscribe(System.out::println);
            // cloak
            // Listening to resource value changes for 2 minutes.
            Thread.sleep(120000);
            // uncloak
        } catch (Exception e) {
            e.printStackTrace();
            // cloak
            fail(e.getMessage());
            // uncloak
        }
        // end of example
    }

    /**
     * Injects notifications to the notification system.
     */
    @Example
    public void injectNotifications() {
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
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
            sdk.subscribe(resource, BackpressureStrategy.BUFFER).flow().subscribe(new Consumer<Object>() {

                @Override
                public void accept(Object t) throws Exception {
                    log("Received notification value", t);
                }
            });
            // Emitting notifications.
            sdk.notify(notifications);
            sdk.notify(otherNotifications);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Uses a webhook for notifications
     */
    @Example
    public void useServerInitiatedNotificationChannel() {
        // an example: using a webhook for handling notifications from Pelion Cloud
        // Ensure no daemon threads are started.
        try (Sdk sdk = Sdk.createSdk(Configuration.get().autostartDaemon(false))) {
            // Describing a webhook to use (i.e. a publicly available webserver accepting POST request).
            Webhook webhook = new Webhook(new URL("http://mbedcloudjavawebhooktest.requestcatcher.com/test"));
            log("Webhook", webhook);
            // Registering the webhook to Pelion Cloud.
            sdk.lowLevelRest().getConnectModule().updateWebhook(webhook);
            // Defining a resource to listen to
            String resourcePath = "/5002/0/1";
            log("Resource path of interest", resourcePath);
            // Subscribing to the resource value changes
            sdk.subscribe(SubscriptionFilterOptions.newFilter().equalResourcePath(resourcePath),
                          BackpressureStrategy.MISSING)
               .flow().subscribe();
            // Ensuring the webhook has been correctly registered
            log("Registered webhook", sdk.lowLevelRest().getConnectModule().getWebhook());
            // Waiting for notifications to be sent to the webhook.
            Thread.sleep(60000);// TODO do some actual work in your application
            // Unlink the webhook.
            sdk.lowLevelRest().getConnectModule().deleteWebhook();
        } catch (Exception e) {
            fail(e.getMessage());
        }
        // end of example

    }

}
