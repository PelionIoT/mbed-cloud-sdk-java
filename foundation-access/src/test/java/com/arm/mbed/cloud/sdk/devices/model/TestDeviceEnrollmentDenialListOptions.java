// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollmentDenialListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEnrollmentDenialListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEnrollmentDenialListOptions deviceenrollmentdeniallistoptions1 = new DeviceEnrollmentDenialListOptions(Integer.valueOf(1),
                                                                                                                         Long.valueOf(-58),
                                                                                                                         Order.getDefault(),
                                                                                                                         "3119c45e-91fa-4206-a619-3fa67a9ad9ae",
                                                                                                                         null,
                                                                                                                         null);
            DeviceEnrollmentDenialListOptions deviceenrollmentdeniallistoptions2 = deviceenrollmentdeniallistoptions1.clone();
            assertNotNull(deviceenrollmentdeniallistoptions1);
            assertNotNull(deviceenrollmentdeniallistoptions2);
            assertNotSame(deviceenrollmentdeniallistoptions2, deviceenrollmentdeniallistoptions1);
            assertEquals(deviceenrollmentdeniallistoptions2, deviceenrollmentdeniallistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the filters method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testFilters() {
        try {
            DeviceEnrollmentDenialListOptions option = new DeviceEnrollmentDenialListOptions().equalToEndpointName("740bf9ed-5942-4154-ba9b-672424c6d8bf")
                                                                                              .equalToTrustedCertificateId("4b338fa0-1ec7-444c-b916-1f9690443625");
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(DeviceEnrollmentDenialListOptions.TAG_FILTER_BY_ENDPOINT_NAME));
            assertTrue(option.hasFilter(DeviceEnrollmentDenialListOptions.TAG_FILTER_BY_ENDPOINT_NAME,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getEndpointNameFilters());
            assertEquals("740bf9ed-5942-4154-ba9b-672424c6d8bf",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEnrollmentDenialListOptions.TAG_FILTER_BY_ENDPOINT_NAME,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEnrollmentDenialListOptions.TAG_FILTER_BY_TRUSTED_CERTIFICATE_ID));
            assertTrue(option.hasFilter(DeviceEnrollmentDenialListOptions.TAG_FILTER_BY_TRUSTED_CERTIFICATE_ID,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getTrustedCertificateIdFilters());
            assertEquals("4b338fa0-1ec7-444c-b916-1f9690443625",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEnrollmentDenialListOptions.TAG_FILTER_BY_TRUSTED_CERTIFICATE_ID,
                                                                    String.class, option));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the hashCode method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testHashCode() {
        try {
            DeviceEnrollmentDenialListOptions deviceenrollmentdeniallistoptions1 = new DeviceEnrollmentDenialListOptions(Integer.valueOf(39),
                                                                                                                         Long.valueOf(93),
                                                                                                                         Order.getDefault(),
                                                                                                                         "c5eb9a3d-8f16-4c54-aae1-251d85854d1c",
                                                                                                                         null,
                                                                                                                         null);
            DeviceEnrollmentDenialListOptions deviceenrollmentdeniallistoptions2 = new DeviceEnrollmentDenialListOptions(Integer.valueOf(39),
                                                                                                                         Long.valueOf(93),
                                                                                                                         Order.getDefault(),
                                                                                                                         "c5eb9a3d-8f16-4c54-aae1-251d85854d1c",
                                                                                                                         null,
                                                                                                                         null);
            assertNotNull(deviceenrollmentdeniallistoptions1);
            assertNotNull(deviceenrollmentdeniallistoptions2);
            assertNotSame(deviceenrollmentdeniallistoptions2, deviceenrollmentdeniallistoptions1);
            assertEquals(deviceenrollmentdeniallistoptions2, deviceenrollmentdeniallistoptions1);
            assertEquals(deviceenrollmentdeniallistoptions2.hashCode(), deviceenrollmentdeniallistoptions1.hashCode());
            int hashCode = deviceenrollmentdeniallistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceenrollmentdeniallistoptions1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollmentDenialListOptions deviceenrollmentdeniallistoptions1 = new DeviceEnrollmentDenialListOptions(Integer.valueOf(22),
                                                                                                                         Long.valueOf(-81),
                                                                                                                         Order.getDefault(),
                                                                                                                         "06e78152-88db-4bf3-8f89-3c911a652285",
                                                                                                                         null,
                                                                                                                         null);
            DeviceEnrollmentDenialListOptions deviceenrollmentdeniallistoptions2 = new DeviceEnrollmentDenialListOptions(Integer.valueOf(22),
                                                                                                                         Long.valueOf(-81),
                                                                                                                         Order.getDefault(),
                                                                                                                         "06e78152-88db-4bf3-8f89-3c911a652285",
                                                                                                                         null,
                                                                                                                         null);
            DeviceEnrollmentDenialListOptions deviceenrollmentdeniallistoptions3 = new DeviceEnrollmentDenialListOptions(Integer.valueOf(63),
                                                                                                                         Long.valueOf(-99),
                                                                                                                         Order.getDefault(),
                                                                                                                         "1726b8ba-153e-4805-9241-bff76598cc4d",
                                                                                                                         null,
                                                                                                                         null);
            assertNotNull(deviceenrollmentdeniallistoptions1);
            assertNotNull(deviceenrollmentdeniallistoptions2);
            assertNotNull(deviceenrollmentdeniallistoptions3);
            assertNotSame(deviceenrollmentdeniallistoptions2, deviceenrollmentdeniallistoptions1);
            assertNotSame(deviceenrollmentdeniallistoptions3, deviceenrollmentdeniallistoptions1);
            assertEquals(deviceenrollmentdeniallistoptions2, deviceenrollmentdeniallistoptions1);
            assertEquals(deviceenrollmentdeniallistoptions2, deviceenrollmentdeniallistoptions1);
            assertEquals(deviceenrollmentdeniallistoptions1, deviceenrollmentdeniallistoptions2);
            assertEquals(deviceenrollmentdeniallistoptions1, deviceenrollmentdeniallistoptions1);
            assertFalse(deviceenrollmentdeniallistoptions1.equals(null));
            assertNotEquals(deviceenrollmentdeniallistoptions3, deviceenrollmentdeniallistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
