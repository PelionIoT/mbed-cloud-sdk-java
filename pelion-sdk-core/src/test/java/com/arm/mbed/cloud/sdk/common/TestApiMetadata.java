package com.arm.mbed.cloud.sdk.common;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestApiMetadata {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ApiMetadata.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

}
