package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestEvaluatorNotEqual {
    @Test
    public void testIsVerifiedGeneric() {
        EvaluatorNotEqual neq = new EvaluatorNotEqual();
        Filter filter = new Filter("test", FilterOperator.EQUAL, "test");
        assertFalse(neq.isVerified(filter, "test1"));
        filter = new Filter("test", FilterOperator.NOT_EQUAL, null);
        assertFalse(neq.isVerified(filter, null));
    }

    @Test
    public void testIsVerifiedString() {
        EvaluatorNotEqual neq = new EvaluatorNotEqual();
        Filter filter = new Filter("test", FilterOperator.NOT_EQUAL, "test");
        assertFalse(neq.isVerified(filter, "test"));
        assertTrue(neq.isVerified(filter, Integer.valueOf(1)));
        assertTrue(neq.isVerified(filter, " test"));
        assertTrue(neq.isVerified(filter, "test "));
        assertTrue(neq.isVerified(filter, "TEST"));
    }

    @Test
    public void testIsVerifiedInteger() {
        EvaluatorNotEqual neq = new EvaluatorNotEqual();
        Filter filter = new Filter("test", FilterOperator.NOT_EQUAL, Integer.valueOf(1));
        assertFalse(neq.isVerified(filter, Integer.valueOf(1)));
        assertTrue(neq.isVerified(filter, Integer.valueOf(2)));
        assertFalse(neq.isVerified(filter, Byte.valueOf((byte) 1)));
        assertFalse(neq.isVerified(filter, Long.valueOf(1)));
        assertFalse(neq.isVerified(filter, Double.valueOf(1)));
        assertTrue(neq.isVerified(filter, Double.valueOf(1.2)));
        assertTrue(neq.isVerified(filter, "test"));
    }

    @Test
    public void testIsVerifiedDouble() {
        EvaluatorNotEqual neq = new EvaluatorNotEqual();
        Filter filter = new Filter("test", FilterOperator.NOT_EQUAL, Double.valueOf(1));
        assertFalse(neq.isVerified(filter, Integer.valueOf(1)));
        assertTrue(neq.isVerified(filter, Integer.valueOf(2)));
        assertFalse(neq.isVerified(filter, Byte.valueOf((byte) 1)));
        assertFalse(neq.isVerified(filter, Long.valueOf(1)));
        assertFalse(neq.isVerified(filter, Double.valueOf(1)));
        assertTrue(neq.isVerified(filter, Double.valueOf(1.2)));
        assertTrue(neq.isVerified(filter, "test"));
    }

}
