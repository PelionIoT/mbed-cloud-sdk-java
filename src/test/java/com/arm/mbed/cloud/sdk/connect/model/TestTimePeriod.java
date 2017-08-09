package com.arm.mbed.cloud.sdk.connect.model;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.TimePeriod;

public class TestTimePeriod {

    @Test
    public void testToString() {
        TimePeriod period = new TimePeriod();
        assertEquals("1d", period.toString());
        period.setDuration(3);
        period.setUnit(TimeUnit.MINUTES);
        assertEquals("3m", period.toString());
        period.setDuration(100);
        period.setUnit(TimeUnit.HOURS);
        assertEquals("100h", period.toString());
    }

}
