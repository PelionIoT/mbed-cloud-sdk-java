package com.arm.mbed.cloud.sdk.connect.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestSubscription {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Subscription.class).suppress(Warning.NONFINAL_FIELDS)
                      .suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testClone() {
        Subscription model = new Subscription(new Resource("deviceId", "resourcePath"));
        Subscription clone = model.clone();
        assertNotSame(model, clone);
        assertEquals(model, clone);
    }
}
