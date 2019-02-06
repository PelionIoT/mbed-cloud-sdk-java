package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Nullable;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class NotificationListener extends WebSocketListener {
    private final SdkLogger logger;

    private final Callback<String> onNotificationCallBack;
    private final Callback<Integer> onOpenCallBack;
    private final Callback<Integer> onClosingCallBack;
    private final Callback<Throwable> onErrorCallback;

    private static final int NORMAL_CLOSURE_STATUS = 1000;

    public NotificationListener(SdkLogger logger, Callback<String> onNotificationCallBack,
                                Callback<Integer> onOpenCallBack, Callback<Integer> onClosingCallBack,
                                Callback<Throwable> onErrorCallback) {
        super();
        this.logger = logger;
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

    public NotificationListener(SdkLogger logger) {
        this(logger, null, null, null, null);
    }

    public NotificationListener() {
        this(new SdkLogger());
    }

    private void defaultMessage(Object value) {
        logInfo("Nothing to do. Message: " + String.valueOf(value));
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        logInfo("Opening [" + webSocket.toString() + "]: " + response.toString());
        onOpenCallBack.execute(response.code());
    }
    // webSocket.send("Hello, it's SSaurel !");
    // webSocket.send("What's up ?");
    // webSocket.send(ByteString.decodeHex("deadbeef"));
    // // webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !");
    // }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        logInfo("Receiving [" + webSocket.toString() + "]: " + text);
        onNotificationCallBack.execute(text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        String text = bytes.utf8();
        logInfo("Receiving bytes [" + webSocket.toString() + "]: " + text);
        onNotificationCallBack.execute(text);
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, @Nullable String reason) {
        logInfo("Closing [" + webSocket.toString() + "]: " + code + ". Reason: " + reason);
        webSocket.close(NORMAL_CLOSURE_STATUS, reason);
        onClosingCallBack.execute(code);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        logError("Error [" + webSocket.toString() + "]: " + t.getMessage());
        onErrorCallback.execute(t);
    }

    private void logInfo(String string) {
        if (logger == null) {
            return;
        }
        logger.logInfo(string);
    }

    private void logError(String string) {
        if (logger == null) {
            return;
        }
        logger.logError(string);
    }

}
