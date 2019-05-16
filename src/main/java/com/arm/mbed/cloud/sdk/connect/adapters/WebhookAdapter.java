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

    /**
     * Maps a webhook.
     * 
     * @param apiWebhook
     *            webhook to map
     * @return a webhook
     */
    public static Webhook map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook apiWebhook) {
        if (apiWebhook == null) {
            return null;
        }
        final Webhook webhook = new Webhook();
        webhook.setUrl(TranslationUtils.toUrl(apiWebhook.getUrl()));
        webhook.setHeaders(apiWebhook.getHeaders());
        return webhook;
    }

    /**
     * Gets a mapper.
     * 
     * @return mapper
     */
    public static Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook, Webhook>
           getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook, Webhook>() {

            @Override
            public Webhook map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook toBeMapped) {
                return WebhookAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Reverses mapping of a new webhook.
     * 
     * @param webhook
     *            new webhook
     * @return a new webhook request
     */
    public static com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook
           reverseMap(Webhook webhook) {
        if (webhook == null) {
            return null;
        }
        final com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook internalWebhook = new com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook();
        internalWebhook.setUrl(TranslationUtils.toString(webhook.getUrl()));
        internalWebhook.setHeaders(webhook.getHeaders());
        return internalWebhook;
    }

}
