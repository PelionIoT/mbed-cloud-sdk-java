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
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class App extends AbstractVerticle {
    private final Connect api = new Connect(ConnectionOptions.newConfiguration(System.getenv("MBED_CLOUD_API_KEY"))
            .host(System.getenv("MBED_CLOUD_HOST")).autostartDaemon(false));

    @Override
    public void start() {
        HttpServer server = vertx.createHttpServer();
        // Initialise the storage to store incoming data.
        SharedData sd = vertx.sharedData();
        LocalMap<String, JsonObject> notificationMap = sd.getLocalMap("notifications");
        // Define routes and handlers
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.get("/hi").handler(req -> req.response().end("hello you!"));
        router.post("/ping").handler(req -> req.response().end("pong"));
        router.post("/setup").blockingHandler(req -> {
            // Configure webhook URI to receive data from Mbed Cloud on the data-in endpoint
            try {
                String webhookPath = System.getenv("DATA_IN_URI");
                if (api != null && webhookPath != null) {
                    api.updateWebhook(new Webhook(new URL(webhookPath)));

                    // Configure a subscription to receive resource value changes on devices with ids starting with 016
                    api.subscribe()
                            .resourceValues(SubscriptionFilterOptions.newFilter().likeDevice("016%"),
                                    BackpressureStrategy.BUFFER, FirstValue.ON_VALUE_UPDATE)
                            .flow().subscribe(notification -> {
                                addRecord(notificationMap, notification);
                            });
                } else {
                    req.response().setStatusCode(403)
                            .end("An error occurred: Api missing " + api + " or webhook URL " + webhookPath);
                }
            } catch (MbedCloudException | MalformedURLException e) {
                req.response().setStatusCode(403).end(e.getMessage());
            }
            req.response().end("OK");
        });
        router.get("/data-out").blockingHandler(routingContext -> {
            // Return all data which is currently in the datastore
            JsonArray array = new JsonArray(Arrays.asList(notificationMap.values()));
            routingContext.response().putHeader("content-type", "application/json").end(array.encode());
        });
        router.put("/data-in").blockingHandler(routingContext -> {
            // Add the received data to the data-store.
            JsonObject body = routingContext.getBodyAsJson();
            addRecord(notificationMap, body);

            routingContext.response().putHeader("content-type", "application/json")
                    .end(body == null ? new JsonObject().encode() : body.encode());
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

}
