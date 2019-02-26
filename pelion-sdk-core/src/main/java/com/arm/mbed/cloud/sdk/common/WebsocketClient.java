package com.arm.mbed.cloud.sdk.common;

import java.io.Closeable;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.ApiClient;

import okhttp3.Request;
import okhttp3.WebSocket;

@Preamble(description = "Websocket client")
@Internal
public class WebsocketClient implements Closeable {
    private static final int WAIT_TIME = 2000; // 2 seconds

    @Preamble(description = "Websocket status code")
    /**
     * Status code returned by the websocket.
     * <p>
     * <a href="https://tools.ietf.org/html/rfc6455#section-7.4.1">RFC description</a>
     *
     */
    public enum StatusCode {
        /**
         * Normal closure, meaning that the purpose for which the connection was established has been fulfilled.
         */
        NORMAL_CLOSURE(1000),
        /**
         * An endpoint is "going away", such as a server going down or a browser stoping the connection.
         */
        GOING_AWAY(1001),
        /**
         * An endpoint is terminating the connection due to a protocol error.
         */
        PROTOCOL_ERROR(1002),
        /**
         * The connection was closed abnormally, e.g., without sending or receiving a Close control frame.
         */
        ABNORMAL_CLOSURE(1006),
        /**
         * Situations other than 1003 (Endpoint received an unsupported frame ) and 1009 (Endpoint won't process large
         * frame).
         */
        POLICY_VIOLATION(1008),
        /**
         * Server is terminating the connection because it encountered an unexpected condition that prevented it from
         * fulfilling the request.
         */
        SERVER_INTERNAL_ERROR(1011),
        /**
         * Unknown error.
         */
        UNKNOWN(0);

        private final int code;

        private StatusCode(int value) {
            this.code = value;
        }

        public int getCode() {
            return code;
        }

        public static StatusCode getStatus(Integer code) {
            return code == null ? StatusCode.UNKNOWN : getStatus(code.intValue());
        }

        /**
         * Gets status corresponding to a particular code.
         * 
         * @param code
         *            code to consider
         * @return corresponding status.
         */
        public static StatusCode getStatus(int code) {
            for (final StatusCode status : values()) {
                if (status.getCode() == code) {
                    return status;
                }
            }
            return UNKNOWN;
        }

        @Override
        public String toString() {
            return name() + " (" + code + ")";
        }

    }

    private static final String PARAMETER_MESSAGE = "message";
    private static final String ERROR_MESSAGE_NOT_WORKING = "Websocket client is not working";
    private static final String WEBSOCKET_PROTOCOL = "wss";
    private static final String PREFIX_KEY = "pelion_";
    private static final String HEADER_SECURITY = "Sec-WebSocket-Protocol";
    private final ApiClient client;
    private final ConnectionOptions configuration;
    private final String connectEndpoint;
    private final NotificationListener listener;
    private final AtomicReference<WebSocket> wsClient;
    private final AtomicBoolean isWorking;
    private final AtomicBoolean needsToClose;
    private final SdkLogger logger;

    /**
     * Constructor.
     * 
     * @param client
     *            underlying HTTP client
     * @param configuration
     *            connection options
     * @param connectEndpoint
     *            endpoint for websocket connection
     * @param listener
     *            notification listener
     * @param logger
     *            a logger
     */
    @Internal
    public WebsocketClient(ApiClient client, ConnectionOptions configuration, String connectEndpoint,
                           NotificationListener listener, SdkLogger logger) {
        super();
        this.client = client;
        this.connectEndpoint = connectEndpoint;
        this.listener = transformListener(listener);
        this.configuration = configuration;
        wsClient = new AtomicReference<>();
        isWorking = new AtomicBoolean(false);
        needsToClose = new AtomicBoolean(false);
        this.logger = logger == null ? SdkLogger.getLogger() : logger;
    }

    /**
     * Starts the websocket client.
     * 
     * @throws MbedCloudException
     *             if errors happen during client setup.
     */
    public void start() throws MbedCloudException {
        needsToClose.set(false);
        if (isWorking.get() || wsClient.get() != null) {
            return;
        }
        int retries = 30;
        try {
            final WebSocket socket = client.getOkBuilder().build()
                                           .newWebSocket(new Request.Builder().url(getConnectionUrl(configuration.getHostUrl()))
                                                                              .addHeader(HEADER_SECURITY,
                                                                                         PREFIX_KEY + configuration.getApiKey()
                                                                                                          + ", "
                                                                                                          + WEBSOCKET_PROTOCOL)
                                                                              .build(),
                                                         listener);
            wsClient.set(socket);
            while (!isRunning() && !needsToClose.get() && retries > 0) {
                pause();
                retries--;
            }
            if (!isRunning() || needsToClose.get()) {
                logger.logWarn("The websocket could not start in time.");
            }
        } catch (MalformedURLException exception) {
            logger.throwSdkException(exception);
        } catch (InterruptedException exception) {
            logger.logWarn("The Websocket client is started but not ready", exception);
        }

    }

    /**
     * Force stops the connection.
     */
    public void forceStop() {
        needsToClose.set(true);
        if (!isRunning()) {
            return;
        }
        logger.logInfo("Force closing the websocket client");
        final WebSocket ws = wsClient.get();
        if (ws != null) {
            ws.cancel();
        }
        isWorking.set(false);
        wsClient.set(null);
    }

    /**
     * Stops gently the websocket connection.
     */
    public void stop() {
        logger.logInfo("Closing the websocket client");
        needsToClose.set(true);
        if (!isRunning()) {
            return;
        }
        int retries = 2;
        final WebSocket ws = wsClient.get();
        if (ws != null) {
            ws.close(StatusCode.NORMAL_CLOSURE.getCode(), "Websocket client was requested to stop");
            try {
                while (isRunning() && retries > 0) {
                    pause();
                    retries--;
                }
            } catch (InterruptedException exception) {
                logger.logError("Could not close the websocket client gently.", exception);
            }
        }
    }

    /**
     * Sends a message through the websocket connection.
     * 
     * @param message
     *            a message.
     * @throws MbedCloudException
     *             if an error arises.
     */
    public void sendMessage(@NonNull String message) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, message, PARAMETER_MESSAGE);
        logger.logDebug("Sending message to Pelion Cloud [" + message + "]");
        if (!isRunning()) {
            logger.throwSdkException(ERROR_MESSAGE_NOT_WORKING);
        }
        final WebSocket ws = wsClient.get();
        if (ws == null) {
            logger.throwSdkException(ERROR_MESSAGE_NOT_WORKING);
        }
        ws.send(message);
    }

    /**
     * States whether the client is working or not.
     * 
     * @return True if the client is up and running. False, otherwise.
     */
    public boolean isRunning() {
        return isWorking.get();
    }

    private String getConnectionUrl(URL url) throws MbedCloudException {
        if (url == null) {
            return null;
        }
        try {
            // FIXME The protocol should be ws or wss but Java URL does not consider them as valid protocols. Getting
            // the following exception otherwise java.net.MalformedURLException: Unknown protocol: ws
            return new URL(url.getProtocol(), url.getHost(),
                           ApiUtils.normaliseResourcePath(connectEndpoint)).toString();
        } catch (MalformedURLException exception) {
            logger.throwSdkException(exception);
        } // return "wss://api-ns-websocket.mbedcloudintegration.net/v2/notification/websocket-connect";
        return null;
    }

    private NotificationListener transformListener(final NotificationListener notificationListener) {
        if (notificationListener == null) {
            return null;

        }
        final NotificationListener listener = new NotificationListener(notificationListener.getLogger(),
                                                                       notificationListener.getOnNotificationCallBack(),
                                                                       new Callback<Integer>() {

                                                                           @Override
                                                                           public void execute(Integer arg) {
                                                                               notificationListener.getOnOpenCallBack()
                                                                                                   .execute(arg);
                                                                               isWorking.set(true);
                                                                               resume();
                                                                           }
                                                                       }, new Callback<Integer>() {

                                                                           @Override
                                                                           public void execute(Integer arg) {
                                                                               notificationListener.logInfo("Closing - Status: "
                                                                                                            + StatusCode.getStatus(arg));
                                                                               needsToClose.set(true);
                                                                               isWorking.set(false);
                                                                               wsClient.set(null);
                                                                               notificationListener.getOnClosingCallBack()
                                                                                                   .execute(arg);
                                                                               resume();
                                                                           }
                                                                       }, new Callback<Throwable>() {

                                                                           @Override
                                                                           public void execute(Throwable arg) {
                                                                               notificationListener.getOnErrorCallback()
                                                                                                   .execute(arg);
                                                                               if (isRunning()) {
                                                                                   requestClosure(StatusCode.PROTOCOL_ERROR);
                                                                               } else {
                                                                                   needsToClose.set(true);
                                                                               }
                                                                               if (arg instanceof EOFException) {
                                                                                   resume();
                                                                               }
                                                                           }
                                                                       });
        return listener;

    }

    private synchronized void resume() {
        notifyAll();
    }

    private void requestClosure(StatusCode closureCode) {
        final WebSocket ws = wsClient.get();
        if (ws != null) {
            ws.close(closureCode.getCode(), "Websocket client was requested to stop");
        }
    }

    protected synchronized void pause() throws InterruptedException {
        wait(WAIT_TIME);
    }

    @Override
    public void close() {
        stop();
        forceStop();
    }

}
