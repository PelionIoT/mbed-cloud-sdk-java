package com.arm.mbed.cloud.sdk.subscribe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestDeviceStateNotification {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(DeviceStateNotification.class).suppress(Warning.NONFINAL_FIELDS)
                      .suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testClone() {
        DeviceStateNotification model = new DeviceStateNotification(DeviceState.EXPIRED_REGISTRATION, "some device id",
                                                                    "an endpoint name");
        DeviceStateNotification clone = model.clone();
        assertNotSame(model, clone);
        assertEquals(model, clone);
    }
}
