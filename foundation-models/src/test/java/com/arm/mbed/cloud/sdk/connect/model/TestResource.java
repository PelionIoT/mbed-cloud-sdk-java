package com.arm.mbed.cloud.sdk.connect.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestResource {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Resource.class).suppress(Warning.NONFINAL_FIELDS).suppress(Warning.STRICT_INHERITANCE)
                      .withIgnoredFields("resourceType", "contentType", "interfaceDescription", "observable").verify();
    }

    @Test
    public void testClone() {
        Resource model = new Resource("deviceId", "resourcePath");
        Resource clone = model.clone();
        assertNotSame(model, clone);
        assertEquals(model, clone);
    }
}
