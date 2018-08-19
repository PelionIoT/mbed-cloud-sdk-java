package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Order;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestIdListResponse {

    @Test
    public void testClone() {
        final IdListResponse response = new IdListResponse(true, 100, "after", "to be continued", 5, Order.DESC);
        response.addData("1");
        response.addData("2");
        final IdListResponse responseClone = response.clone();
        assertNotSame(response, responseClone);
        assertEquals(response, responseClone);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IdListResponse.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
}
