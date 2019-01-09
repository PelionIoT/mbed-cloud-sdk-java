package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

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
        String[] likeFilters = { "?e%", "?a%" };// Array
        filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, "TEST"));
        assertTrue(like.isVerified(filter, "ham"));
        assertFalse(like.isVerified(filter, "Homerus"));
        List<String> likeFilterList = Arrays.asList("?e%", "?a%");// List
        filter = new Filter("test", FilterOperator.LIKE, likeFilterList);
        assertTrue(like.isVerified(filter, "TEST"));
        assertTrue(like.isVerified(filter, "ham"));
        assertFalse(like.isVerified(filter, "Homerus"));
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
        @SuppressWarnings("boxing")
        Integer[] likeFilters = { 1, new Integer(2) };
        filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
        int[] likePrimitiveFilters = { 1, 2 };
        filter = new Filter("test", FilterOperator.LIKE, likePrimitiveFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
    }

    @Test
    public void testIsVerifiedByte() {
        EvaluatorLike like = new EvaluatorLike();
        @SuppressWarnings("boxing")
        Byte[] likeFilters = { 1, new Byte((byte) 2) };
        Filter filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
        byte[] likePrimitiveFilters = { 1, 2 };
        filter = new Filter("test", FilterOperator.LIKE, likePrimitiveFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
    }

    @Test
    public void testIsVerifiedShort() {
        EvaluatorLike like = new EvaluatorLike();
        @SuppressWarnings("boxing")
        Short[] likeFilters = { new Short((short) 1), 2 };
        Filter filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
        short[] likePrimitiveFilters = { 1, 2 };
        filter = new Filter("test", FilterOperator.LIKE, likePrimitiveFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
    }

    @Test
    public void testIsVerifiedLong() {
        EvaluatorLike like = new EvaluatorLike();
        @SuppressWarnings("boxing")
        Long[] likeFilters = { 1l, new Long(2l) };
        Filter filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
        long[] likePrimitiveFilters = { 1, 2 };
        filter = new Filter("test", FilterOperator.LIKE, likePrimitiveFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
    }

    @Test
    public void testIsVerifiedFloat() {
        EvaluatorLike like = new EvaluatorLike();
        @SuppressWarnings("boxing")
        Float[] likeFilters = { new Float(1.0f), 2f };
        Filter filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
        float[] likePrimitiveFilters = { 1, 2 };
        filter = new Filter("test", FilterOperator.LIKE, likePrimitiveFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
    }

    @Test
    public void testIsVerifiedDouble() {
        EvaluatorLike like = new EvaluatorLike();
        @SuppressWarnings("boxing")
        Double[] likeFilters = { new Double(1d), 2.0d };
        Filter filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
        double[] likePrimitiveFilters = { 1, 2 };
        filter = new Filter("test", FilterOperator.LIKE, likePrimitiveFilters);
        assertTrue(like.isVerified(filter, Integer.valueOf(1)));
        assertTrue(like.isVerified(filter, Integer.valueOf(2)));
        assertFalse(like.isVerified(filter, Integer.valueOf(3)));
    }

    @SuppressWarnings("boxing")
    @Test
    public void testIsVerifiedBoolean() {
        EvaluatorLike like = new EvaluatorLike();
        Boolean[] likeFilters = { Boolean.TRUE, Boolean.FALSE };
        Filter filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, true));
        assertTrue(like.isVerified(filter, Boolean.FALSE));
        boolean[] likePrimitiveFilters = { true, false };
        filter = new Filter("test", FilterOperator.LIKE, likePrimitiveFilters);
        assertTrue(like.isVerified(filter, Boolean.TRUE));
        assertTrue(like.isVerified(filter, false));
    }

    @SuppressWarnings("boxing")
    @Test
    public void testIsVerifiedCharacter() {
        EvaluatorLike like = new EvaluatorLike();
        Character[] likeFilters = { new Character('a'), 'f' };
        Filter filter = new Filter("test", FilterOperator.LIKE, likeFilters);
        assertTrue(like.isVerified(filter, 'a'));
        assertFalse(like.isVerified(filter, 'g'));
        char[] likePrimitiveFilters = { 'a', 'f' };
        filter = new Filter("test", FilterOperator.LIKE, likePrimitiveFilters);
        assertTrue(like.isVerified(filter, 'a'));
        assertFalse(like.isVerified(filter, 'g'));
    }
}
