package com.arm.mbed.cloud.sdk.connect.adapters;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;

@Preamble(description = "Adapter for webhook model")
public final class WebhookAdapter {

    private WebhookAdapter() {
        super();
    }

    public static Webhook map(com.arm.mbed.cloud.sdk.internal.mds.model.Webhook apiWebhook) {
        if (apiWebhook == null) {
            return null;
        }
        final Webhook webhook = new Webhook();
        webhook.setUrl(TranslationUtils.toUrl(apiWebhook.getUrl()));
        webhook.setHeaders(apiWebhook.getHeaders());
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
        final com.arm.mbed.cloud.sdk.internal.mds.model.Webhook internalWebhook = new com.arm.mbed.cloud.sdk.internal.mds.model.Webhook();
        internalWebhook.setUrl(TranslationUtils.toString(webhook.getUrl()));
        internalWebhook.setHeaders(webhook.getHeaders());
        return internalWebhook;
    }

}
