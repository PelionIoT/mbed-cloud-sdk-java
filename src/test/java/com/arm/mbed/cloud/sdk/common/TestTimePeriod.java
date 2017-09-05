package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

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
        period.setDuration(14);
        period.setUnit(TimeUnit.DAYS);
        assertEquals("2w", period.toString());
        period.setDuration(15);
        period.setUnit(TimeUnit.DAYS);
        assertEquals("15d", period.toString());
    }

    @Test
    public void testFromString() {
        TimePeriod period = new TimePeriod();
        assertEquals("1d", period.toString());
        period.fromString("3m");
        assertEquals(TimeUnit.MINUTES, period.getUnit());
        assertEquals(3, period.getDuration());
        period = new TimePeriod("100h");
        assertEquals(TimeUnit.HOURS, period.getUnit());
        assertEquals(100, period.getDuration());
        period.fromString(" 1000 s ");
        assertEquals(TimeUnit.SECONDS, period.getUnit());
        assertEquals(1000, period.getDuration());
        assertEquals("1000s", period.toString());
        period = new TimePeriod("2w");
        assertEquals(TimeUnit.DAYS, period.getUnit());
        assertEquals(14, period.getDuration());
        assertEquals("2w", period.toString());
        period = new TimePeriod("1y");
        assertEquals(TimeUnit.DAYS, period.getUnit());
        assertEquals(366, period.getDuration());
        assertEquals("1y", period.toString());
    }

}
