package com.arm.mbed.cloud.sdk.common.listing.filtering;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TestCustomFilter {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CustomFilter.class).verify();
    }

}
