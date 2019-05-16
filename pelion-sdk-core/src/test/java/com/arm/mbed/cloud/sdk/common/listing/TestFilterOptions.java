package com.arm.mbed.cloud.sdk.common.listing;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestFilterOptions {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(FilterOptions.class).suppress(Warning.STRICT_INHERITANCE)
                      .suppress(Warning.NONFINAL_FIELDS).verify();
    }

}
