package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestEvaluatorLike {
    @Test
    public void testIsVerifiedGeneric() {
        EvaluatorLike like = new EvaluatorLike();
        Filter filter = new Filter("test", FilterOperator.NOT_EQUAL, "test");
        assertFalse(like.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.LIKE, null);
        assertTrue(like.isVerified(filter, null));
        assertFalse(like.isVerified(filter, " "));
    }

    @Test
    public void testIsVerifiedString() {
        EvaluatorLike like = new EvaluatorLike();
        Filter filter = new Filter("test", FilterOperator.LIKE, "test");
        assertTrue(like.isVerified(filter, "test"));
        assertFalse(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, " test"));
        assertTrue(like.isVerified(filter, "test "));
        assertTrue(like.isVerified(filter, "TEST"));
        filter = new Filter("test", FilterOperator.LIKE, ".e.*");// Java Regex
        assertTrue(like.isVerified(filter, "TEST"));
        assertTrue(like.isVerified(filter, "te"));
        assertTrue(like.isVerified(filter, "Aerospace"));
        assertTrue(like.isVerified(filter, "Aer"));
        assertFalse(like.isVerified(filter, "AAerospace"));
        filter = new Filter("test", FilterOperator.LIKE, "_e%");// SQL like
        assertTrue(like.isVerified(filter, "TEST"));
        assertTrue(like.isVerified(filter, "TE"));
        assertTrue(like.isVerified(filter, "AErospace"));
        assertTrue(like.isVerified(filter, "AEr"));
        assertFalse(like.isVerified(filter, "AAErospace"));
        filter = new Filter("test", FilterOperator.LIKE, "?e%");// MS Access like
        assertTrue(like.isVerified(filter, "TEST"));
        assertTrue(like.isVerified(filter, "TE"));
        assertTrue(like.isVerified(filter, "AErospace"));
        assertTrue(like.isVerified(filter, "AEr"));
        assertFalse(like.isVerified(filter, "AAErospace"));
    }

    @Test
    public void testIsVerifiedInteger() {
        EvaluatorLike like = new EvaluatorLike();
        Filter filter = new Filter("test", FilterOperator.LIKE, Integer.valueOf(1));
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertFalse(like.isVerified(filter, Integer.valueOf(2)));
        assertTrue(like.isVerified(filter, Byte.valueOf((byte) 1)));
        assertTrue(like.isVerified(filter, Long.valueOf(1)));
        assertTrue(like.isVerified(filter, Double.valueOf(1)));
        assertFalse(like.isVerified(filter, Double.valueOf(1.2)));
        assertFalse(like.isVerified(filter, "test"));
    }

}
