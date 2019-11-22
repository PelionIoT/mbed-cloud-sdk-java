package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

import java.util.GregorianCalendar;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.connect.model.MetricsPeriodListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsStartEndListOptions;

public class TestAllListOptions {

    @Test
    public void testMetricPeriodListOptionsClone() {
        MetricsPeriodListOptions opt1 = new MetricsPeriodListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        opt1.setPeriod("30d");
        opt1.setInterval("2d");
        MetricsPeriodListOptions opt2 = new MetricsPeriodListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testMetricStartEndListOptionsClone() {
        MetricsStartEndListOptions opt1 = new MetricsStartEndListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        opt1.setInterval("1d");
        opt1.setStart(new GregorianCalendar(2017, 0, 9).getTime());
        opt1.setEnd(new GregorianCalendar(2018, 0, 9).getTime());
        MetricsStartEndListOptions opt2 = new MetricsStartEndListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }
}
