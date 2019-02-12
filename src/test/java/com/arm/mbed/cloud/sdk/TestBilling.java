package com.arm.mbed.cloud.sdk;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class TestBilling {

    @Test
    public void testGenerateReportReferenceFromDate() {
        try (Billing api = new Billing(ConnectionOptions.newConfiguration())) {
            Calendar date = new GregorianCalendar(2018, 3, 15);
            assertEquals("2018-04", api.generateReportReferenceFromDate(date.getTime()));
            date = new GregorianCalendar(2018, 10, 15);
            assertEquals("2018-11", api.generateReportReferenceFromDate(date.getTime()));
        }
    }

    @Test
    public void testGenerateReportReference() {
        try (Billing api = new Billing(ConnectionOptions.newConfiguration())) {
            assertEquals("2018-04", api.generateReportReference(2018, 4));
            assertEquals("2018-11", api.generateReportReference(2018, 11));
        }
    }

}
