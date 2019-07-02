package com.arm.mbed.cloud.sdk.subscribe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.connect.model.Resource;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestAllNotifications {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(AllNotifications.class).suppress(Warning.NONFINAL_FIELDS)
                      .suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testClone() {
        List<DeviceStateNotification> deviceStates = Arrays.asList(new DeviceStateNotification(DeviceState.EXPIRED_REGISTRATION,
                                                                                               "some device id",
                                                                                               "an endpoint name"),
                                                                   new DeviceStateNotification(DeviceState.REGISTRATION,
                                                                                               "some other device id",
                                                                                               "an endpoint name"));
        List<AsynchronousResponseNotification> asyncResponses = Arrays.asList(new AsynchronousResponseNotification("some id",
                                                                                                                   400),
                                                                              new AsynchronousResponseNotification("some other id",
                                                                                                                   400));

        List<ResourceValueNotification> resourceValues = Arrays.asList(new ResourceValueNotification(new Resource("some device ID",
                                                                                                                  "some path")),
                                                                       new ResourceValueNotification(new Resource("some other device ID",
                                                                                                                  "some other path")));
        AllNotifications model = new AllNotifications(resourceValues, asyncResponses, deviceStates);
        AllNotifications clone = model.clone();
        assertNotSame(model, clone);
        assertEquals(model, clone);
    }
}
