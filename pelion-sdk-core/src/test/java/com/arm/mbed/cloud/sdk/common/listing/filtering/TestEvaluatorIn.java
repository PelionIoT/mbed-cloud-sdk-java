package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TestEvaluatorIn {

    @SuppressWarnings("boxing")
    @Test
    public void testIsVerifiedGeneric() {
        EvaluatorIn in = new EvaluatorIn();
        Filter filter = new Filter("test", FilterOperator.NOT_EQUAL, "test");
        assertFalse(in.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.IN, null);
        assertFalse(in.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.IN, "test");
        assertTrue(in.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.IN, Arrays.asList(1, 2, 3));
        assertTrue(in.isVerified(filter, 2));
        assertFalse(in.isVerified(filter, " "));
    }

    @Test
    public void testIsVerifiedString() {
        EvaluatorIn in = new EvaluatorIn();
        Filter filter = new Filter("test", FilterOperator.IN, "test");
        assertTrue(in.isVerified(filter, "test"));
        assertTrue(in.isVerified(filter, "te"));
        assertFalse(in.isVerified(filter, Integer.valueOf(1)));
        assertFalse(in.isVerified(filter, " test"));
        assertFalse(in.isVerified(filter, "test "));
        assertFalse(in.isVerified(filter, "TEST"));
        filter = new Filter("test", FilterOperator.IN, Arrays.asList("test1", "test", "test3"));
        assertTrue(in.isVerified(filter, "test"));
        assertFalse(in.isVerified(filter, "TEST"));
    }

    @SuppressWarnings("boxing")
    @Test
    public void testIsVerifiedInteger() {
        EvaluatorIn in = new EvaluatorIn();
        Filter filter = new Filter("test", FilterOperator.IN, Integer.valueOf(1));
        assertTrue(in.isVerified(filter, Integer.valueOf(1)));
        assertFalse(in.isVerified(filter, Integer.valueOf(2)));
        assertTrue(in.isVerified(filter, Byte.valueOf((byte) 1)));
        assertTrue(in.isVerified(filter, Long.valueOf(1)));
        assertTrue(in.isVerified(filter, Double.valueOf(1)));
        assertFalse(in.isVerified(filter, Double.valueOf(1.2)));
        assertFalse(in.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.IN, Arrays.asList(1, 2, 3, 4));
        assertTrue(in.isVerified(filter, Double.valueOf(3)));
        assertFalse(in.isVerified(filter, Double.valueOf(3.2)));
        assertFalse(in.isVerified(filter, Integer.valueOf(5)));

    }

    @SuppressWarnings("boxing")
    @Test
    public void testIsVerifiedDouble() {
        EvaluatorIn in = new EvaluatorIn();
        Filter filter = new Filter("test", FilterOperator.IN, Double.valueOf(1));
        assertTrue(in.isVerified(filter, Integer.valueOf(1)));
        assertFalse(in.isVerified(filter, Integer.valueOf(2)));
        assertTrue(in.isVerified(filter, Byte.valueOf((byte) 1)));
        assertTrue(in.isVerified(filter, Long.valueOf(1)));
        assertTrue(in.isVerified(filter, Double.valueOf(1)));
        assertFalse(in.isVerified(filter, Double.valueOf(1.2)));
        assertFalse(in.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.IN, Arrays.asList(1.2, 2, 3.5, 4));
        assertTrue(in.isVerified(filter, Double.valueOf(3.5)));
        assertFalse(in.isVerified(filter, Double.valueOf(3.2)));
        assertTrue(in.isVerified(filter, Integer.valueOf(4)));
        assertFalse(in.isVerified(filter, Integer.valueOf(5)));
    }
}
