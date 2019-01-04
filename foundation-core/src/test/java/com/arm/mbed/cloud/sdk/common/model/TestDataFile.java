package com.arm.mbed.cloud.sdk.common.model;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestDataFile {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(DataFile.class).suppress(Warning.NONFINAL_FIELDS).suppress(Warning.STRICT_INHERITANCE)
                      .verify();
    }
}
