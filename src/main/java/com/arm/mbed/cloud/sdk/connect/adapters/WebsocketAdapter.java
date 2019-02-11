package com.arm.mbed.cloud.sdk.connect.adapters;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.connect.model.Websocket;
import com.arm.mbed.cloud.sdk.connect.model.WebsocketStatus;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.WebsocketChannel;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.WebsocketChannel.StatusEnum;

@Preamble(description = "Adapter for websocket model")
public final class WebsocketAdapter {

    private WebsocketAdapter() {
        super();
    }

    /**
     * Maps a webhook.
     * 
     * @param apiWebhook
     *            webhook to map
     * @return a webhook
     */
    public static Websocket map(WebsocketChannel apiWebhook) {
        if (apiWebhook == null) {
            return null;
        }
        final Websocket websocket = new Websocket(null, 0, toStatus(apiWebhook.getStatus()));
        return websocket;
    }

    private static WebsocketStatus toStatus(StatusEnum status) {
        if (status == null) {
            return WebsocketStatus.getUnknownEnum();
        }
        switch (status) {
            case CONNECTED:
                return WebsocketStatus.CONNECTED;
            case DISCONNECTED:
                return WebsocketStatus.DISCONNECTED;

        }
        return WebsocketStatus.getUnknownEnum();
    }

    /**
     * Gets a mapper.
     * 
     * @return mapper
     */
    public static Mapper<WebsocketChannel, Websocket> getMapper() {
        return new Mapper<WebsocketChannel, Websocket>() {

            @Override
            public Websocket map(WebsocketChannel toBeMapped) {
                return WebsocketAdapter.map(toBeMapped);
            }

        };
    }

}
