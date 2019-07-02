package com.arm.mbed.cloud.sdk.subscribe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestNotificationWithPayload {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(NotificationWithPayload.class).suppress(Warning.NONFINAL_FIELDS)
                      .suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testClone() {
        NotificationWithPayload model = new NotificationWithPayload();
        model.setContentType("some type");
        model.setPayload(new Object());
        model.setThrowable(null);
        NotificationWithPayload clone = model.clone();
        assertNotSame(model, clone);
        assertEquals(model, clone);
    }
}
