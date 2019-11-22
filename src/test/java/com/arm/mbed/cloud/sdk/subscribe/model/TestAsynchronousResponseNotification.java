package com.arm.mbed.cloud.sdk.subscribe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestAsynchronousResponseNotification {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(AsynchronousResponseNotification.class).suppress(Warning.NONFINAL_FIELDS)
                      .suppress(Warning.STRICT_INHERITANCE).withRedefinedSuperclass().verify();
    }

    @Test
    public void testClone() {
        AsynchronousResponseNotification model = new AsynchronousResponseNotification("some id", 400);
        AsynchronousResponseNotification clone = model.clone();
        assertNotSame(model, clone);
        assertEquals(model, clone);
    }
}
