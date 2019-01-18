package com.arm.mbed.cloud.sdk.common.model;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestDataFile {

    @Test
    public void checkContentType() {
        DataFile file = new DataFile(new File("test.csv"));
        assertEquals(DataFile.CSV_FILE_MEDIA_TYPE, file.getContentType());
        file = new DataFile(new File("test.csv.test"));
        assertEquals(DataFile.BINARY_FILE_MEDIA_TYPE, file.getContentType());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(DataFile.class).suppress(Warning.NONFINAL_FIELDS).suppress(Warning.STRICT_INHERITANCE)
                      .verify();
    }
}
