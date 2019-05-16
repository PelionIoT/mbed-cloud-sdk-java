package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.Iterator;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.SdkModel;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestListResponse {

    @Test
    public void testIterator() {
        ListResponse<IntegerModel> response = new ListResponse<>(true, 5, null, null, 6, Order.ASC);
        response.addData(new IntegerModel(0));
        response.addData(new IntegerModel(1));
        response.addData(new IntegerModel(2));
        response.addData(new IntegerModel(3));
        response.addData(new IntegerModel(4));
        response.addData(new IntegerModel(5));
        int i = 0;
        Iterator<IntegerModel> it = response.iterator();
        while (it.hasNext()) {
            assertEquals(i, it.next().getValue());
            i++;
        }
    }

    @Test
    public void testFirst() {
        ListResponse<IntegerModel> response = new ListResponse<>(true, 5, null, null, 6, Order.ASC);
        assertNull(response.first());
        response.addData(new IntegerModel(5));
        assertEquals(5, response.first().getValue());
        assertEquals(5, response.first().getValue());
        response.addData(new IntegerModel(4));
        response.addData(new IntegerModel(3));
        response.addData(new IntegerModel(2));
        response.addData(new IntegerModel(1));
        response.addData(new IntegerModel(0));
        assertEquals(5, response.first().getValue());
        assertEquals(5, response.first().getValue());

    }

    @Test
    public void testLast() {
        ListResponse<IntegerModel> response = new ListResponse<>(true, 5, null, null, 6, Order.ASC);
        assertNull(response.last());
        response.addData(new IntegerModel(5));
        assertEquals(5, response.last().getValue());
        assertEquals(5, response.last().getValue());
        response.addData(new IntegerModel(4));
        response.addData(new IntegerModel(3));
        response.addData(new IntegerModel(2));
        response.addData(new IntegerModel(1));
        response.addData(new IntegerModel(0));
        assertEquals(0, response.last().getValue());
        assertEquals(0, response.last().getValue());
    }

    @Test
    public void testGetNumberOfElements() {
        ListResponse<IntegerModel> response = new ListResponse<>(true, 5, null, null, 6, Order.ASC);
        assertEquals(0, response.getNumberOfElements());
        response.addData(new IntegerModel(5));
        assertEquals(1, response.getNumberOfElements());
        response.addData(new IntegerModel(4));
        response.addData(new IntegerModel(3));
        response.addData(new IntegerModel(2));
        response.addData(new IntegerModel(1));
        response.addData(new IntegerModel(0));
        assertEquals(6, response.getNumberOfElements());
    }

    @Test
    public void testClone() {
        ListResponse<IntegerModel> response = new ListResponse<>(true, 5, null, null, 6, Order.ASC);
        response.addData(new IntegerModel(5));
        response.addData(new IntegerModel(4));
        response.addData(new IntegerModel(3));
        response.addData(new IntegerModel(2));
        response.addData(new IntegerModel(1));
        response.addData(new IntegerModel(0));
        ListResponse<IntegerModel> response2 = response.clone();
        assertEquals(response2, response);
        assertFalse(response2 == response);
        assertEquals(response2.hashCode(), response.hashCode());

    }

    @Test
    public void testEqualsObject() {
        ListResponse<IntegerModel> response = new ListResponse<>(true, 5, null, null, 6, Order.ASC);
        response.addData(new IntegerModel(5));
        response.addData(new IntegerModel(4));
        response.addData(new IntegerModel(3));
        response.addData(new IntegerModel(2));
        response.addData(new IntegerModel(1));
        response.addData(new IntegerModel(0));
        ListResponse<IntegerModel> response2 = new ListResponse<>(true, 5, null, null, 6, Order.ASC);
        response2.addData(new IntegerModel(5));
        response2.addData(new IntegerModel(4));
        response2.addData(new IntegerModel(3));
        response2.addData(new IntegerModel(2));
        response2.addData(new IntegerModel(1));
        response2.addData(new IntegerModel(0));
        assertEquals(response2, response);
        assertFalse(response2 == response);
        assertEquals(response2.hashCode(), response.hashCode());
        ListResponse<IntegerModel> response3 = new ListResponse<>(true, 5, null, null, 6, Order.ASC);
        response3.addData(new IntegerModel(5));
        response3.addData(new IntegerModel(4));
        response3.addData(new IntegerModel(3));
        response3.addData(new IntegerModel(2));
        response3.addData(new IntegerModel(1));
        assertNotEquals(response3, response);
        response3.addData(new IntegerModel(0));
        assertEquals(response3, response);
        response3.setHasMore(false);
        assertNotEquals(response3, response);
        assertNotEquals(response3.hashCode(), response.hashCode());
        response2.setOrder(Order.DESC);
        assertNotEquals(response2, response);
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(ListResponse.class)
                      .withPrefabValues(SdkModel.class, new IntegerModel(1), new IntegerModel(2))
                      .suppress(Warning.NONFINAL_FIELDS).verify();
    }

    private static final class IntegerModel implements SdkModel {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private int value;

        public IntegerModel(int value) {
            super();
            this.value = value;
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.common.SdkModel#getId()
         */
        @Override
        public String getId() {
            return String.valueOf(value);
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#clone()
         */
        @Override
        public IntegerModel clone() {
            return new IntegerModel(value);
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + value;
            return result;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            IntegerModel other = (IntegerModel) obj;
            if (value != other.value) {
                return false;
            }
            return true;
        }

        @Override
        public void setId(String id) {
            value = Integer.parseInt(id);
        }

    }

}
