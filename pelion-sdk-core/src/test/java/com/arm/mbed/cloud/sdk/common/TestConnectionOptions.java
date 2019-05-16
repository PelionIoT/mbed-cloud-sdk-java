package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestConnectionOptions {

    @Test
    public void testHost() {
        ConnectionOptions opt = ConnectionOptions.newConfiguration();
        assertFalse(opt.isHostEmpty());
        opt.host(null);
        assertFalse(opt.isHostEmpty());
        opt.host("");
        assertFalse(opt.isHostEmpty());
        opt.host("\'\'");
        assertFalse(opt.isHostEmpty());
        opt.host("''");
        assertFalse(opt.isHostEmpty());
        opt.host("'     \t '");
        assertFalse(opt.isHostEmpty());
        opt.host("\"\"");
        assertFalse(opt.isHostEmpty());
        assertTrue(opt.getHost().endsWith("/"));
    }

    @Test
    public void testIsEntryEmpty() {
        assertTrue(ConnectionOptions.isEntryEmpty(null));
        assertTrue(ConnectionOptions.isEntryEmpty("\'\'"));
        assertTrue(ConnectionOptions.isEntryEmpty("\"\""));
        assertTrue(ConnectionOptions.isEntryEmpty("\"   \""));
        assertTrue(ConnectionOptions.isEntryEmpty("''"));
        assertTrue(ConnectionOptions.isEntryEmpty("'  '"));
        assertTrue(ConnectionOptions.isEntryEmpty("'  \t '"));
        assertFalse(ConnectionOptions.isEntryEmpty("' this is a test '"));
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ConnectionOptions.class).suppress(Warning.NONFINAL_FIELDS)
                      .withIgnoredFields("clientLogLevel", "requestTimeout").suppress(Warning.STRICT_INHERITANCE)
                      .verify();
    }
}
