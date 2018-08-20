package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.Iterator;
import java.util.stream.IntStream;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Order;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestIdListResponse {

    @Test
    public void testIterator() {
        final IdListResponse response = generateListOfIds(10);
        int i = 0;
        Iterator<String> it = response.iterator();
        while (it.hasNext()) {
            assertEquals(i, Integer.parseInt(it.next()));
            i++;
        }
    }

    @Test
    public void testFirst() {
        assertNull(generateListOfIds(0).first());
        int numberOfElements = 1;
        IdListResponse response = generateListOfIds(numberOfElements);
        assertEquals(String.valueOf(0), response.first());
        numberOfElements = 10;
        response = generateListOfIds(numberOfElements);
        assertEquals(String.valueOf(0), response.first());
    }

    @Test
    public void testLast() {
        assertNull(generateListOfIds(0).last());
        int numberOfElements = 1;
        IdListResponse response = generateListOfIds(numberOfElements);
        assertEquals(String.valueOf(numberOfElements - 1), response.last());
        numberOfElements = 10;
        response = generateListOfIds(numberOfElements);
        assertEquals(String.valueOf(numberOfElements - 1), response.last());
    }

    @Test
    public void testGetNumberOfElements() {
        int numberOfElements = 1;
        IdListResponse response = generateListOfIds(numberOfElements);
        assertEquals(numberOfElements, response.getNumberOfElements());
        numberOfElements = 10;
        response = generateListOfIds(numberOfElements);
        assertEquals(numberOfElements, response.getNumberOfElements());
    }

    @Test
    public void testClone() {
        final IdListResponse response = generateListOfIds(10);
        final IdListResponse responseClone = response.clone();
        assertNotSame(response, responseClone);
        assertEquals(response, responseClone);
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(IdListResponse.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    private IdListResponse generateListOfIds(int numberOfElements) {
        final IdListResponse response = new IdListResponse(true, 100, "after", "to be continued", 5, Order.DESC);
        IntStream.range(0, numberOfElements).forEach(i -> response.addData(String.valueOf(i)));
        return response;
    }

}
