package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;

@Preamble(description = "Adapter for webhook model")
public class WebhookAdapter {
    public static Webhook map(com.arm.mbed.cloud.sdk.internal.mds.model.Webhook apiWebhook) {
        if (apiWebhook == null) {
            return null;
        }
        Webhook webhook = new Webhook();
        webhook.setUrl(TranslationUtils.toUrl(apiWebhook.getUrl()));
        webhook.setHeaders(convertHeaders(apiWebhook.getHeaders()));
        return webhook;
    }

    public static Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Webhook, Webhook> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Webhook, Webhook>() {

            @Override
            public Webhook map(com.arm.mbed.cloud.sdk.internal.mds.model.Webhook toBeMapped) {
                return WebhookAdapter.map(toBeMapped);
            }

        };
    }

    public static com.arm.mbed.cloud.sdk.internal.mds.model.Webhook reverseMap(Webhook webhook) {
        if (webhook == null) {
            return null;
        }
        com.arm.mbed.cloud.sdk.internal.mds.model.Webhook internalWebhook = new com.arm.mbed.cloud.sdk.internal.mds.model.Webhook();
        internalWebhook.setUrl(TranslationUtils.toString(webhook.getUrl()));
        internalWebhook.setHeaders(convertToHeaderObject(webhook.getHeaders()));
        return internalWebhook;
    }

    private static Map<String, String> convertHeaders(Object headers) {
        // TODO
        return null;
    }

    private static Object convertToHeaderObject(Map<String, String> headers) {
        // TODO
        return null;
    }

}
