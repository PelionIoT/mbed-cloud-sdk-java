package com.arm.mbed.cloud.sdk.subscribe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.connect.model.Resource;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestResourceValueNotification {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ResourceValueNotification.class).suppress(Warning.NONFINAL_FIELDS)
                      .suppress(Warning.STRICT_INHERITANCE).withRedefinedSuperclass().verify();
    }

    @Test
    public void testClone() {
        ResourceValueNotification model = new ResourceValueNotification(new Resource("some device ID", "some path"));
        model.setContentType("some content type");
        model.setPayload(new Object());
        ResourceValueNotification clone = model.clone();
        assertNotSame(model, clone);
        assertEquals(model, clone);
    }
}
