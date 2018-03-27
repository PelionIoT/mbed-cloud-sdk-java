package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TestEvaluatorNotIn {

    @SuppressWarnings("boxing")
    @Test
    public void testIsVerifiedGeneric() {
        EvaluatorNotIn nin = new EvaluatorNotIn();
        Filter filter = new Filter("test", FilterOperator.NOT_EQUAL, "test");
        assertFalse(nin.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.NOT_IN, null);
        assertFalse(nin.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.NOT_IN, "test");
        assertFalse(nin.isVerified(filter, "test"));
        assertTrue(nin.isVerified(filter, "test "));
        filter = new Filter("test", FilterOperator.NOT_IN, Arrays.asList(1, 2, 3));
        assertFalse(nin.isVerified(filter, 2));
        assertTrue(nin.isVerified(filter, " "));
    }

    @Test
    public void testIsVerifiedString() {
        EvaluatorNotIn nin = new EvaluatorNotIn();
        Filter filter = new Filter("test", FilterOperator.NOT_IN, "test");
        assertFalse(nin.isVerified(filter, "test"));
        assertFalse(nin.isVerified(filter, "te"));
        assertTrue(nin.isVerified(filter, Integer.valueOf(1)));
        assertTrue(nin.isVerified(filter, " test"));
        assertTrue(nin.isVerified(filter, "test "));
        assertTrue(nin.isVerified(filter, "TEST"));
        filter = new Filter("test", FilterOperator.NOT_IN, Arrays.asList("test1", "test", "test3"));
        assertFalse(nin.isVerified(filter, "test"));
        assertTrue(nin.isVerified(filter, "TEST"));
    }

    @SuppressWarnings("boxing")
    @Test
    public void testIsVerifiedInteger() {
        EvaluatorNotIn nin = new EvaluatorNotIn();
        Filter filter = new Filter("test", FilterOperator.NOT_IN, Integer.valueOf(1));
        assertFalse(nin.isVerified(filter, Integer.valueOf(1)));
        assertTrue(nin.isVerified(filter, Integer.valueOf(2)));
        assertFalse(nin.isVerified(filter, Byte.valueOf((byte) 1)));
        assertFalse(nin.isVerified(filter, Long.valueOf(1)));
        assertFalse(nin.isVerified(filter, Double.valueOf(1)));
        assertTrue(nin.isVerified(filter, Double.valueOf(1.2)));
        assertTrue(nin.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.NOT_IN, Arrays.asList(1, 2, 3, 4));
        assertFalse(nin.isVerified(filter, Double.valueOf(3)));
        assertTrue(nin.isVerified(filter, Double.valueOf(3.2)));
        assertTrue(nin.isVerified(filter, Integer.valueOf(5)));
    }

    @SuppressWarnings("boxing")
    @Test
    public void testIsVerifiedDouble() {
        EvaluatorNotIn nin = new EvaluatorNotIn();
        Filter filter = new Filter("test", FilterOperator.NOT_IN, Double.valueOf(1));
        assertFalse(nin.isVerified(filter, Integer.valueOf(1)));
        assertTrue(nin.isVerified(filter, Integer.valueOf(2)));
        assertFalse(nin.isVerified(filter, Byte.valueOf((byte) 1)));
        assertFalse(nin.isVerified(filter, Long.valueOf(1)));
        assertFalse(nin.isVerified(filter, Double.valueOf(1)));
        assertTrue(nin.isVerified(filter, Double.valueOf(1.2)));
        assertTrue(nin.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.NOT_IN, Arrays.asList(1.2, 2, 3.5, 4));
        assertFalse(nin.isVerified(filter, Double.valueOf(3.5)));
        assertTrue(nin.isVerified(filter, Double.valueOf(3.2)));
        assertFalse(nin.isVerified(filter, Integer.valueOf(4)));
        assertTrue(nin.isVerified(filter, Integer.valueOf(5)));
    }
}
