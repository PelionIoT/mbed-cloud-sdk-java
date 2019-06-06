// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantTrustedCertificateListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantTrustedCertificateListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions1 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(-11),
                                                                                                                                        Long.valueOf(126),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "5e10889b-559f-4018-9dbd-c36bfca2dbf6",
                                                                                                                                        null,
                                                                                                                                        null);
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions2 = subtenanttrustedcertificatelistoptions1.clone();
            assertNotNull(subtenanttrustedcertificatelistoptions1);
            assertNotNull(subtenanttrustedcertificatelistoptions2);
            assertNotSame(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the filters method.
     */
    @SuppressWarnings({ "boxing", "resource" })
    @Test
    public void testFilters() {
        try {
            SubtenantTrustedCertificateListOptions option = new SubtenantTrustedCertificateListOptions().equalToValid(Boolean.TRUE)
                                                                                                        .equalToName("b5a44d3d-60b1-45c1-b7e2-bfa03668357b")
                                                                                                        .equalToStatus(SubtenantTrustedCertificateStatus.getDefault())
                                                                                                        .equalToDeviceExecutionMode(Integer.valueOf(-70))
                                                                                                        .notEqualToDeviceExecutionMode(Integer.valueOf(-26))
                                                                                                        .likeIssuer("bdfe2696-24b5-404e-931f-5b2152a20b10")
                                                                                                        .equalToService(SubtenantTrustedCertificateService.getDefault())
                                                                                                        .likeSubject("beec3b51-63f5-4b49-8033-d0b100f43767")
                                                                                                        .equalToEnrollmentMode(Boolean.TRUE);
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_VALID));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_VALID,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getValidFilters());
            assertEquals(Boolean.TRUE,
                         ListOptionsEncoder.encodeSingleEqualFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_VALID,
                                                                    Boolean.class, option));
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_NAME));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_NAME,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getNameFilters());
            assertEquals("b5a44d3d-60b1-45c1-b7e2-bfa03668357b",
                         ListOptionsEncoder.encodeSingleEqualFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_NAME,
                                                                    String.class, option));
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_STATUS));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_STATUS,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getStatusFilters());
            assertEquals(SubtenantTrustedCertificateStatus.getDefault(),
                         ListOptionsEncoder.encodeSingleEqualFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_STATUS,
                                                                    SubtenantTrustedCertificateStatus.class, option));
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getDeviceExecutionModeFilters());
            assertEquals(Integer.valueOf(-70),
                         ListOptionsEncoder.encodeSingleEqualFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                                                    Integer.class, option));
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                        FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDeviceExecutionModeFilters());
            assertEquals(Integer.valueOf(-26),
                         ListOptionsEncoder.encodeSingleNotEqualFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                                                       Integer.class, option));
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_ISSUER));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_ISSUER,
                                        FilterOperator.LIKE));
            assertNotNull(option.getIssuerFilters());
            assertEquals("bdfe2696-24b5-404e-931f-5b2152a20b10",
                         ListOptionsEncoder.encodeSingleLikeFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_ISSUER,
                                                                   String.class, option));
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_SERVICE));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_SERVICE,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getServiceFilters());
            assertEquals(SubtenantTrustedCertificateService.getDefault(),
                         ListOptionsEncoder.encodeSingleEqualFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_SERVICE,
                                                                    SubtenantTrustedCertificateService.class, option));
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_SUBJECT));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_SUBJECT,
                                        FilterOperator.LIKE));
            assertNotNull(option.getSubjectFilters());
            assertEquals("beec3b51-63f5-4b49-8033-d0b100f43767",
                         ListOptionsEncoder.encodeSingleLikeFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_SUBJECT,
                                                                   String.class, option));
            assertTrue(option.hasFilters(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_ENROLLMENT_MODE));
            assertTrue(option.hasFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_ENROLLMENT_MODE,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getEnrollmentModeFilters());
            assertEquals(Boolean.TRUE,
                         ListOptionsEncoder.encodeSingleEqualFilter(SubtenantTrustedCertificateListOptions.TAG_FILTER_BY_ENROLLMENT_MODE,
                                                                    Boolean.class, option));
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
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions1 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(30),
                                                                                                                                        Long.valueOf(9),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "1123e72f-73e4-433c-8da6-b84e15777b05",
                                                                                                                                        null,
                                                                                                                                        null);
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions2 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(30),
                                                                                                                                        Long.valueOf(9),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "1123e72f-73e4-433c-8da6-b84e15777b05",
                                                                                                                                        null,
                                                                                                                                        null);
            assertNotNull(subtenanttrustedcertificatelistoptions1);
            assertNotNull(subtenanttrustedcertificatelistoptions2);
            assertNotSame(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2.hashCode(),
                         subtenanttrustedcertificatelistoptions1.hashCode());
            int hashCode = subtenanttrustedcertificatelistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenanttrustedcertificatelistoptions1.hashCode());
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
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions1 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(78),
                                                                                                                                        Long.valueOf(44),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "88fc931c-76a6-413e-a8fc-2ed6c3b0658f",
                                                                                                                                        null,
                                                                                                                                        null);
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions2 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(78),
                                                                                                                                        Long.valueOf(44),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "88fc931c-76a6-413e-a8fc-2ed6c3b0658f",
                                                                                                                                        null,
                                                                                                                                        null);
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions3 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(-50),
                                                                                                                                        Long.valueOf(-51),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "dcbc62f0-0a43-44fb-91bd-14a921f5f21b",
                                                                                                                                        null,
                                                                                                                                        null);
            assertNotNull(subtenanttrustedcertificatelistoptions1);
            assertNotNull(subtenanttrustedcertificatelistoptions2);
            assertNotNull(subtenanttrustedcertificatelistoptions3);
            assertNotSame(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertNotSame(subtenanttrustedcertificatelistoptions3, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions1, subtenanttrustedcertificatelistoptions2);
            assertEquals(subtenanttrustedcertificatelistoptions1, subtenanttrustedcertificatelistoptions1);
            assertFalse(subtenanttrustedcertificatelistoptions1.equals(null));
            assertNotEquals(subtenanttrustedcertificatelistoptions3, subtenanttrustedcertificatelistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
