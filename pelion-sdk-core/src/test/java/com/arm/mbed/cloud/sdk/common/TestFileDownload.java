package com.arm.mbed.cloud.sdk.common;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestFileDownload {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(FileDownload.class).suppress(Warning.STRICT_INHERITANCE)
                      .suppress(Warning.TRANSIENT_FIELDS)
                      .withPrefabValues(ApiClientWrapper.class,
                                        new ApiClientWrapper(ConnectionOptions.newConfiguration("1")),
                                        new ApiClientWrapper(ConnectionOptions.newConfiguration("2")))
                      .verify();
    }

}
