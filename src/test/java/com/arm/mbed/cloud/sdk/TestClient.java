package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.common.CallLogLevel;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceListOptions;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class TestClient {
    private static final String ENVVAR_MBED_CLOUD_HOST = "MBED_CLOUD_HOST";
    private static final String ENVVAR_MBED_CLOUD_API_KEY = "MBED_CLOUD_API_KEY";
    private static final String LOGGER_DELEGATE_FACTORY_CLASS_NAME_PROPERTY = "vertx.logger-delegate-factory-class-name";
    private static final String LOGGER_DELEGATE_FACTORY_CLASS_NAME = "io.vertx.core.logging.SLF4JLogDelegateFactory";
    static {
        System.setProperty(LOGGER_DELEGATE_FACTORY_CLASS_NAME_PROPERTY, LOGGER_DELEGATE_FACTORY_CLASS_NAME);
    }
    private final Logger testLogger = LoggerFactory.getLogger("Java SDK Test server");

    public TestClient() {
        ConnectionOptions config = new ConnectionOptions(System.getenv(ENVVAR_MBED_CLOUD_API_KEY),
                System.getenv(ENVVAR_MBED_CLOUD_HOST));
        config.setClientLogLevel(CallLogLevel.BODY);
        // config.setClientLogLevel(CallLogLevel.BODY);
        // logInfo(JsonObject.mapFrom(config).encodePrettily());
        // AccountManagement api = new AccountManagement(config);
        // ListResponse<ApiKey> keys = null;
        // try {
        // ApiKeyListOptions options = new ApiKeyListOptions();
        // options.setLimit(2);
        // keys = api.listApiKeys(options);
        // } catch (MbedCloudException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // ApiKey key = null;
        // try {
        // key = api.getApiKey("015d5fe8aec502420a01020800000000");
        // } catch (MbedCloudException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // logInfo(JsonObject.mapFrom(key).encodePrettily());
        //
        // ListResponse<Group> groups = null;
        // try {
        //
        // ListOptions options = new ListOptions();
        // options.setLimit(5);
        // groups = api.listGroups(options);
        // } catch (MbedCloudException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // logInfo(JsonObject.mapFrom(groups).encodePrettily());

        // User user = new User();
        // user.setUsername("TRUNNER-OGP1UV");
        // user.setPhoneNumber("TRUNNER-0JWCM7");
        // user.setEmail("TRUNNER-OGP1UV@arm.com");
        // user.setFullName("TRUNNER-HC8OSJ");
        // User userR = null;
        // try {
        // userR = api.addUser(user);
        // } catch (MbedCloudException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // logInfo(JsonObject.mapFrom(userR).encodePrettily());
        //
        // Certificates certapi = new Certificates(config);
        // Certificate certificate = new Certificate();
        // certificate.setName("sfsaf");
        // certificate.setCertificateData("sdffgsdkfusghdifuah");
        // certificate.setType(CertificateType.BOOTSTRAP);
        // certificate.setSignature("hklfkdhdslfhsdlkhf");
        // try {
        // certapi.addCertificate(certificate);
        // } catch (Exception e) {
        // e.printStackTrace();
        // logWarn(e.getMessage());
        // }

        try {
            DeviceDirectory api = new DeviceDirectory(config);
            DeviceListOptions opt = new DeviceListOptions();
            opt.setLimit(10);
            Paginator<Device> response = api.listAllDevices(opt);
            // System.out.println(response.hasMore());
            // System.out.println(response.getData().size());
            int i = 0;
            for (Device device : response) {
                System.out.println(device);
                i++;
                // try {
                // Resource resource = connectApi.getResource(device, "/3/0");
                // Object value = connectApi.getResourceValue(resource, null);
                // System.out.println(value);
                // } catch (Exception e) {
                // System.out.println("Failed " + e.getMessage());
                // }

            }
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // AccountManagement accountApi = new AccountManagement(config);
        // DeviceDirectory deviceApi = new DeviceDirectory(config);
        // try {

        // Paginator<User> list = accountApi.listAllUsers(null);
        // while (list.hasNext()) {
        // User next = list.next();
        // System.out.println(next);
        // accountApi.updateUser(next);
        // }
        // Paginator<Device> list = connectApi.listAllDevices(null);
        // connectApi.startNotifications();
        // if (list.hasNext()) {
        // Device device = list.next();
        // logInfo(JsonObject.mapFrom(device).encodePrettily());
        // // Resource resource = connectApi.getResource(device, "/3/0");
        // connectApi.deleteDeviceSubscriptions(device.getId());
        // List<Presubscription> listPresubscriptions;
        // try {
        // listPresubscriptions = connectApi.listPresubscriptions();
        //
        // for (Presubscription presubscription : listPresubscriptions) {
        // for (String resource : presubscription.getResourcePaths()) {
        // System.out.println("presubscription: [device: " + presubscription.getDeviceId() + ", path: "
        // + resource + "] ");
        // }
        // }
        // } catch (MbedCloudException e1) {
        // // TODO Auto-generated catch block
        // e1.printStackTrace();
        // }
        // List<String> listSub = connectApi.listDeviceSubscriptions(device);
        // for (String subscription : listSub) {
        // logInfo(subscription);
        // }
        // Resource aResource = null;
        // for (Resource resource : connectApi.listResources(device)) {
        // System.out.println("NEW RESOURCE " + resource);
        // connectApi.addResourceSubscription(resource);
        // aResource = resource;
        // }
        // if (aResource != null) {
        // logInfo("Resource is subscribed? " + connectApi.getResourceSubscription(aResource));
        // }
        // listSub = connectApi.listDeviceSubscriptions(device);
        // for (String subscription : listSub) {
        // logInfo(subscription);
        // }
        // // List<Resource> resources = connectApi.listResources(device);
        // // for (Resource resource : resources) {
        // // logInfo(JsonObject.mapFrom(resource).encodePrettily());
        // // }
        // // connectApi.getResourceValue(device.getId(), "/5002/0/1", false, false, null);
        // }
        // try {
        // Thread.sleep(300000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // connectApi.stopNotifications();
        // connectApi.shutdownConnectService();

        // try {
        // connectApi.startNotifications();
        // String path = "/5002/0/1";
        // Paginator<Device> list = connectApi.listAllConnectedDevices(null);
        // while (list.hasNext()) {
        // Device device = list.next();
        // logInfo(JsonObject.mapFrom(device).encodePrettily());
        // Resource resource = new Resource(device.getId(), path);
        // // Callback<Object> callback = new Callback<Object>() {
        // //
        // // @Override
        // // public void execute(Object arg) {
        // // System.out.println("Just received a notification from " + device.getId() + " regarding " + path
        // // + ": " + String.valueOf(arg));
        // //
        // // }
        // // };
        // // connectApi.registerResourceSubscriptionCallback(resource, callback, null);
        // connectApi.createResourceSubscriptionObserver(resource, BackpressureStrategy.BUFFER)
        // .subscribe(System.out::println);
        // connectApi.addResourceSubscription(resource);
        // // Object value = connectApi.getResourceValue(device.getId(), path, false, false, new TimePeriod(30));
        // // System.out.println(value);
        // }
        // } catch (MbedCloudException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // System.out.println("came here");
        // }
        // try {
        // Thread.sleep(120000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // System.out.println("END");
        // try {
        // connectApi.stopNotifications();
        // } catch (MbedCloudException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // connectApi.shutdownConnectService();

        // } catch (MbedCloudException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

    }

    private void logInfo(String message) {
        testLogger.info(message);
    }

    private void logWarn(String message) {
        testLogger.warn(message);
    }

    public static void main(String[] args) {
        TestClient client = new TestClient();
    }

}
