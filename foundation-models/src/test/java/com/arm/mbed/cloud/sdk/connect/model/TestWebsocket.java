package com.arm.mbed.cloud.sdk.connect.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestWebsocket {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Websocket.class).suppress(Warning.NONFINAL_FIELDS).suppress(Warning.STRICT_INHERITANCE)
                      .verify();
    }

    @Test
    public void testClone() {

        Websocket model = new Websocket("anID", 100, WebsocketStatus.DISCONNECTED);
        Websocket clone = model.clone();
        assertNotSame(model, clone);
        assertEquals(model, clone);

    }
}
