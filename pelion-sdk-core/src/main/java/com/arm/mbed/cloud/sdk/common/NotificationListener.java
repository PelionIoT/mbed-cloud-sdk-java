package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Websocket notification listener.
 */
@Preamble(description = "Websocket notification listener")
@Internal
public class NotificationListener extends WebSocketListener {
    private static final String NOTIFICATION_LOG_PREFIX = "Notification - ";

    private final SdkLogger logger;

    private final Callback<String> onNotificationCallBack;
    private final Callback<Integer> onOpenCallBack;
    private final Callback<Integer> onClosingCallBack;
    private final Callback<Throwable> onErrorCallback;

    private static final int NORMAL_CLOSURE_STATUS = 1000;

    /**
     * Constructor.
     * 
     * @param logger
     *            logger
     * @param onNotificationCallBack
     *            callback to call on notification
     * @param onOpenCallBack
     *            callback to call on client start
     * @param onClosingCallBack
     *            callback to call on client shutdown
     * @param onErrorCallback
     *            callback to call on error.
     */
    public NotificationListener(SdkLogger logger, Callback<String> onNotificationCallBack,
                                Callback<Integer> onOpenCallBack, Callback<Integer> onClosingCallBack,
                                Callback<Throwable> onErrorCallback) {
        super();
        this.logger = logger == null ? SdkLogger.getLogger() : logger;
        this.onNotificationCallBack = onNotificationCallBack == null ? new Callback<String>() {

            @Override
            public void execute(String arg) {
                defaultMessage(arg);
            }
        } : onNotificationCallBack;
        this.onOpenCallBack = onOpenCallBack == null ? new Callback<Integer>() {

            @Override
            public void execute(Integer arg) {
                defaultMessage(arg);

            }
        } : onOpenCallBack;
        this.onClosingCallBack = onClosingCallBack == null ? new Callback<Integer>() {

            @Override
            public void execute(Integer arg) {
                defaultMessage(arg);

            }
        } : onClosingCallBack;
        this.onErrorCallback = onErrorCallback == null ? new Callback<Throwable>() {

            @Override
            public void execute(Throwable arg) {
                defaultMessage(arg);

            }
        } : onErrorCallback;
    }

    /**
     * Constructor.
     * 
     * @param logger
     *            a logger
     */
    public NotificationListener(SdkLogger logger) {
        this(logger, null, null, null, null);
    }

    /**
     * Constructor.
     */
    public NotificationListener() {
        this(SdkLogger.getLogger());
    }

    private void defaultMessage(Object value) {
        logInfo("Nothing to do. Message: " + value);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        logInfo("Opening [" + webSocket.toString() + "]: " + response.toString());
        onOpenCallBack.execute(Integer.valueOf(response.code()));
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        logDebug("Receiving: " + text);
        onNotificationCallBack.execute(text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        final String text = bytes == null ? null : bytes.utf8();
        logDebug("Receiving bytes: " + text);
        onNotificationCallBack.execute(text);
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, @Nullable String reason) {
        logInfo("Closing: " + code + ". Reason: " + reason);
        webSocket.close(NORMAL_CLOSURE_STATUS, reason);
        onClosingCallBack.execute(Integer.valueOf(code));
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable cause, Response response) {
        logError("Error: " + cause.getMessage());
        onErrorCallback.execute(cause);
    }

    /**
     * Logs information message.
     * 
     * @param message
     *            message to log.
     */
    public void logInfo(String message) {
        logger.logInfo(generateLoggingMessageMetadata(message));
    }

    /**
     * Logs error message.
     * 
     * @param message
     *            message to log.
     */
    public void logError(String message) {
        logger.logError(generateLoggingMessageMetadata(message));
    }

    /**
     * Logs debug message.
     * 
     * @param message
     *            message to log.
     */
    public void logDebug(String message) {
        logger.logDebug(generateLoggingMessageMetadata(message));
    }

    private String generateLoggingMessageMetadata(String string) {
        final StringBuilder builder = new StringBuilder(30);
        builder.append(NOTIFICATION_LOG_PREFIX).append(string);
        return builder.toString();
    }

    /**
     * Gets corresponding logger.
     * 
     * @return the logger
     */
    public SdkLogger getLogger() {
        return logger;
    }

    /**
     * Gets the onNotification callback
     * 
     * @return corresponding callback.
     */
    public Callback<String> getOnNotificationCallback() {
        return onNotificationCallBack;
    }

    /**
     * Gets the onOpen callback
     * 
     * @return corresponding callback.
     */
    public Callback<Integer> getOnOpenCallback() {
        return onOpenCallBack;
    }

    /**
     * Gets the onClosing callback
     * 
     * @return corresponding callback.
     */
    public Callback<Integer> getOnClosingCallback() {
        return onClosingCallBack;
    }

    /**
     * Gets the onError callback
     * 
     * @return corresponding callback.
     */
    public Callback<Throwable> getOnErrorCallback() {
        return onErrorCallback;
    }

}
