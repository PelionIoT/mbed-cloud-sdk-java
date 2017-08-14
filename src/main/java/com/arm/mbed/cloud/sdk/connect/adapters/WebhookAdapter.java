package com.arm.mbed.cloud.sdk.connect.adapters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;

@Preamble(description = "Adapter for webhook model")
public class WebhookAdapter {
    public static Webhook map(com.arm.mbed.cloud.sdk.internal.model.Webhook apiWebhook) {
        if (apiWebhook == null) {
            return null;
        }
        Webhook webhook = new Webhook();
        webhook.setUrl(convertUrl(apiWebhook.getUrl()));
        webhook.setHeaders(convertHeaders(apiWebhook.getHeaders()));
        return webhook;
    }

    public static Mapper<com.arm.mbed.cloud.sdk.internal.model.Webhook, Webhook> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.model.Webhook, Webhook>() {

            @Override
            public Webhook map(com.arm.mbed.cloud.sdk.internal.model.Webhook toBeMapped) {
                return WebhookAdapter.map(toBeMapped);
            }

        };
    }

    private static URL convertUrl(String url) {
        try {
            return (url == null) ? null : new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Map<String, String> convertHeaders(Object headers) {
        // TODO
        return null;
    }

}
