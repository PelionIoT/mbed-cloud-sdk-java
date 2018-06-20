import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

import io.reactivex.BackpressureStrategy;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * This is a small web server listening to resource value changes from devices whose Ids start with 016. All changes can
 * be seen by calling the "/data-out" route. This example uses the webhook notification channel mode and therefore would
 * need a publicly available URL in order to work.
 */
public class App extends AbstractVerticle {
    // Creation of an SDK instance
    private final Connect api = new Connect(ConnectionOptions.newConfiguration(System.getenv("MBED_CLOUD_API_KEY"))
            .host(System.getenv("MBED_CLOUD_HOST")).autostartDaemon(false));

    @Override
    public void start() {
        if (vertx == null) {
            vertx = Vertx
                    .vertx(new VertxOptions().setWorkerPoolSize(40).setBlockedThreadCheckInterval(1000L * 60L * 10L)
                            .setMaxWorkerExecuteTime(1000L * 1000L * 1000L * 60L * 10L));
        }
        HttpServer server = vertx.createHttpServer();
        // Initialise the storage to store incoming data.
        SharedData sd = vertx.sharedData();
        LocalMap<String, JsonObject> notificationMap = sd.getLocalMap("notifications");
        // Setup the observer to call the method which adds data to the datastore
        // Configure a subscription to receive resource value changes on devices with ids starting with 016
        try {
            api.subscribe().resourceValues(SubscriptionFilterOptions.newFilter().likeDevice("016%"),
                    BackpressureStrategy.BUFFER, FirstValue.ON_VALUE_UPDATE).flow().subscribe(notification -> {
                        // Add any new record to the datastore
                        addRecord(notificationMap, notification);
                    });
        } catch (MbedCloudException e1) {
            e1.printStackTrace();
            return;
        }
        // Define routes and handlers
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        // Some testing routes to check that the webserver is working
        router.get("/hi").handler(req -> req.response().end("hello you!"));
        router.post("/ping").handler(req -> req.response().end("pong"));
        router.post("/setup").blockingHandler(req -> {
            // Setup webhook when server is up and running
            // Configure webhook URI to receive data from Mbed Cloud on the data-in endpoint
            try {
                String webhookPath = System.getenv("DATA_IN_URI");
                if (api != null && webhookPath != null) {
                    api.updateWebhook(new Webhook(new URL(webhookPath)));

                    req.response().end("WebHook configured to use URI: " + webhookPath);
                } else {
                    req.response().setStatusCode(403)
                            .end("An error occurred: Api missing " + api + " or webhook URL " + webhookPath);
                }
            } catch (MbedCloudException | MalformedURLException e) {
                req.response().setStatusCode(403).end(e.getMessage());
            }
        });
        router.get("/data-out").blockingHandler(routingContext -> {
            // Return all data which is currently in the datastore
            final JsonArray array = new JsonArray(Arrays.asList(notificationMap.values()));
            routingContext.response().putHeader("content-type", "application/json").end(array.encode());
        });
        router.put("/data-in").blockingHandler(routingContext -> {
            // Add the received data to the data-store.
            String body = routingContext.getBodyAsString();
            if (body != null) {
                if (api != null) {
                    api.notify(body);
                } else {
                    routingContext.response().setStatusCode(403).end("An error occurred: Api missing: " + api);
                    return;
                }
            }
            routingContext.response().putHeader("content-type", "application/json")
                    .end(body == null ? new JsonObject().encode() : body);
        });

        server.requestHandler(router::accept).listen(80);

    }

    // Add the provided data to the local cache
    private void addRecord(LocalMap<String, JsonObject> notificationMap, Object object) {
        if (object != null) {
            JsonObject json = object instanceof JsonObject ? (JsonObject) object : JsonObject.mapFrom(object);
            notificationMap.put(new Date().toString(), json);
        }
    }

    // end of example

    public static void main(String[] args) {
        App server = new App();
        try {
            server.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
