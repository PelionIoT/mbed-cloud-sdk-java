package com.arm.mbed.cloud.sdk.connect.adapters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;

@Preamble(description = "Adapter for webhook model")
public class WebhookAdapter {
    public static Webhook map(com.arm.mbed.cloud.sdk.internal.model.Webhook apiWebhook) throws MalformedURLException {
        if (apiWebhook == null) {
            return null;
        }
        Webhook webhook = new Webhook();
        webhook.setUrl(convertUrl(apiWebhook.getUrl()));
        webhook.setHeaders(convertHeaders(apiWebhook.getHeaders()));
        return webhook;
    }

    private static URL convertUrl(String url) throws MalformedURLException {
        return (url == null) ? null : new URL(url);
    }

    private static Map<String, String> convertHeaders(Object headers) {
        // TODO
        return null;
    }

}
