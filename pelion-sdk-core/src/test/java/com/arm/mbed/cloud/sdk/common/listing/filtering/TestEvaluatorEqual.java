package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestEvaluatorEqual {
    @Test
    public void testIsVerifiedGeneric() {
        EvaluatorEqual eq = new EvaluatorEqual();
        Filter filter = new Filter("test", FilterOperator.NOT_EQUAL, "test");
        assertFalse(eq.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.EQUAL, null);
        assertTrue(eq.isVerified(filter, null));
        assertFalse(eq.isVerified(filter, " "));
    }

    @Test
    public void testIsVerifiedString() {
        EvaluatorEqual eq = new EvaluatorEqual();
        Filter filter = new Filter("test", FilterOperator.EQUAL, "test");
        assertTrue(eq.isVerified(filter, "test"));
        assertFalse(eq.isVerified(filter, Integer.valueOf(1)));
        assertFalse(eq.isVerified(filter, " test"));
        assertFalse(eq.isVerified(filter, "test "));
        assertFalse(eq.isVerified(filter, "TEST"));
    }

    @Test
    public void testIsVerifiedInteger() {
        EvaluatorEqual eq = new EvaluatorEqual();
        Filter filter = new Filter("test", FilterOperator.EQUAL, Integer.valueOf(1));
        assertTrue(eq.isVerified(filter, Integer.valueOf(1)));
        assertFalse(eq.isVerified(filter, Integer.valueOf(2)));
        assertTrue(eq.isVerified(filter, Byte.valueOf((byte) 1)));
        assertTrue(eq.isVerified(filter, Long.valueOf(1)));
        assertTrue(eq.isVerified(filter, Double.valueOf(1)));
        assertFalse(eq.isVerified(filter, Double.valueOf(1.2)));
        assertFalse(eq.isVerified(filter, "test"));
    }

    @Test
    public void testIsVerifiedDouble() {
        EvaluatorEqual eq = new EvaluatorEqual();
        Filter filter = new Filter("test", FilterOperator.EQUAL, Double.valueOf(1));
        assertTrue(eq.isVerified(filter, Integer.valueOf(1)));
        assertFalse(eq.isVerified(filter, Integer.valueOf(2)));
        assertTrue(eq.isVerified(filter, Byte.valueOf((byte) 1)));
        assertTrue(eq.isVerified(filter, Long.valueOf(1)));
        assertTrue(eq.isVerified(filter, Double.valueOf(1)));
        assertFalse(eq.isVerified(filter, Double.valueOf(1.2)));
        assertFalse(eq.isVerified(filter, "test"));
    }

}
