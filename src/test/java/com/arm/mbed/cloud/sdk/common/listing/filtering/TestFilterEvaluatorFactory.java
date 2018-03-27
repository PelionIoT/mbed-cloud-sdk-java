package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TestFilterEvaluatorFactory {

    @Test
    public void testIsVerified() {
        Filter filter = new Filter("test", FilterOperator.NOT_EQUAL, "test");
        assertTrue(FilterEvaluatorFactory.isVerified(filter, "t1"));
        assertFalse(FilterEvaluatorFactory.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.EQUAL, "test");
        assertFalse(FilterEvaluatorFactory.isVerified(filter, "t1"));
        assertTrue(FilterEvaluatorFactory.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.LIKE, "t_st%");
        assertFalse(FilterEvaluatorFactory.isVerified(filter, "tste"));
        assertTrue(FilterEvaluatorFactory.isVerified(filter, "tasTes"));
        filter = new Filter("test", FilterOperator.IN, "test");
        assertFalse(FilterEvaluatorFactory.isVerified(filter, "t1"));
        assertTrue(FilterEvaluatorFactory.isVerified(filter, "te"));
        filter = new Filter("test", FilterOperator.IN, Arrays.asList("1", "test", "five"));
        assertFalse(FilterEvaluatorFactory.isVerified(filter, "t1"));
        assertTrue(FilterEvaluatorFactory.isVerified(filter, "test"));
        filter = new Filter("test", FilterOperator.NOT_IN, "test");
        assertTrue(FilterEvaluatorFactory.isVerified(filter, "t1"));
        assertFalse(FilterEvaluatorFactory.isVerified(filter, "te"));
        filter = new Filter("test", FilterOperator.NOT_IN, Arrays.asList("1", "test", "five"));
        assertTrue(FilterEvaluatorFactory.isVerified(filter, "t1"));
        assertFalse(FilterEvaluatorFactory.isVerified(filter, "test"));
    }

}
