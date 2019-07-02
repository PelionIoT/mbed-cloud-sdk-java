package com.arm.mbed.cloud.sdk.connect.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestWebhook {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Webhook.class).suppress(Warning.NONFINAL_FIELDS).suppress(Warning.STRICT_INHERITANCE)
                      .verify();
    }

    @Test
    public void testClone() {
        try {
            Webhook model = new Webhook(new URL("http://somepath.test"));
            Webhook clone = model.clone();
            assertNotSame(model, clone);
            assertEquals(model, clone);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
            fail(exception.getMessage());
        }
    }
}
