// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import org.junit.Test;

/**
 * Unit tests for Model TrustedCertificateListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestTrustedCertificateListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            TrustedCertificateListOptions trustedcertificatelistoptions1 = new TrustedCertificateListOptions(Integer.valueOf(-72),
                                                                                                             Long.valueOf(65),
                                                                                                             Order.getDefault(),
                                                                                                             "e2598e95-2eb1-4e60-a51b-e88e43e5a868",
                                                                                                             null,
                                                                                                             null);
            TrustedCertificateListOptions trustedcertificatelistoptions2 = trustedcertificatelistoptions1.clone();
            assertNotNull(trustedcertificatelistoptions1);
            assertNotNull(trustedcertificatelistoptions2);
            assertNotSame(trustedcertificatelistoptions2, trustedcertificatelistoptions1);
            assertEquals(trustedcertificatelistoptions2, trustedcertificatelistoptions1);
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
            TrustedCertificateListOptions option = new TrustedCertificateListOptions().equalToValid(Boolean.FALSE)
                                                                                      .equalToName("c8816812-cebd-47ba-899d-c5e0f02c7d66")
                                                                                      .equalToStatus(TrustedCertificateStatus.getDefault())
                                                                                      .equalToDeviceExecutionMode(Integer.valueOf(39))
                                                                                      .notEqualToDeviceExecutionMode(Integer.valueOf(80))
                                                                                      .likeIssuer("cdecaec6-8eae-48e3-8c0a-e3075e0cf422")
                                                                                      .equalToService(TrustedCertificateService.getDefault())
                                                                                      .likeSubject("11db0dde-0065-4808-b4e2-58035ad153f2")
                                                                                      .equalToEnrollmentMode(Boolean.TRUE);
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_VALID));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_VALID, FilterOperator.EQUAL));
            assertNotNull(option.getValidFilters());
            assertEquals(Boolean.FALSE,
                         ListOptionsEncoder.encodeSingleEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_VALID,
                                                                    Boolean.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_NAME));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_NAME, FilterOperator.EQUAL));
            assertNotNull(option.getNameFilters());
            assertEquals("c8816812-cebd-47ba-899d-c5e0f02c7d66",
                         ListOptionsEncoder.encodeSingleEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_NAME,
                                                                    String.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_STATUS));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_STATUS, FilterOperator.EQUAL));
            assertNotNull(option.getStatusFilters());
            assertEquals(TrustedCertificateStatus.getDefault(),
                         ListOptionsEncoder.encodeSingleEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_STATUS,
                                                                    TrustedCertificateStatus.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getDeviceExecutionModeFilters());
            assertEquals(Integer.valueOf(39),
                         ListOptionsEncoder.encodeSingleEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                                                    Integer.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                        FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDeviceExecutionModeFilters());
            assertEquals(Integer.valueOf(80),
                         ListOptionsEncoder.encodeSingleNotEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                                                       Integer.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_ISSUER));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_ISSUER, FilterOperator.LIKE));
            assertNotNull(option.getIssuerFilters());
            assertEquals("cdecaec6-8eae-48e3-8c0a-e3075e0cf422",
                         ListOptionsEncoder.encodeSingleLikeFilter(TrustedCertificateListOptions.TAG_FILTER_BY_ISSUER,
                                                                   String.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_SERVICE));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_SERVICE, FilterOperator.EQUAL));
            assertNotNull(option.getServiceFilters());
            assertEquals(TrustedCertificateService.getDefault(),
                         ListOptionsEncoder.encodeSingleEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_SERVICE,
                                                                    TrustedCertificateService.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_SUBJECT));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_SUBJECT, FilterOperator.LIKE));
            assertNotNull(option.getSubjectFilters());
            assertEquals("11db0dde-0065-4808-b4e2-58035ad153f2",
                         ListOptionsEncoder.encodeSingleLikeFilter(TrustedCertificateListOptions.TAG_FILTER_BY_SUBJECT,
                                                                   String.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_ENROLLMENT_MODE));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_ENROLLMENT_MODE,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getEnrollmentModeFilters());
            assertEquals(Boolean.TRUE,
                         ListOptionsEncoder.encodeSingleEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_ENROLLMENT_MODE,
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
            TrustedCertificateListOptions trustedcertificatelistoptions1 = new TrustedCertificateListOptions(Integer.valueOf(122),
                                                                                                             Long.valueOf(-121),
                                                                                                             Order.getDefault(),
                                                                                                             "b858cce3-38f1-4e89-a5b8-967c8fd3cafa",
                                                                                                             null,
                                                                                                             null);
            TrustedCertificateListOptions trustedcertificatelistoptions2 = new TrustedCertificateListOptions(Integer.valueOf(122),
                                                                                                             Long.valueOf(-121),
                                                                                                             Order.getDefault(),
                                                                                                             "b858cce3-38f1-4e89-a5b8-967c8fd3cafa",
                                                                                                             null,
                                                                                                             null);
            assertNotNull(trustedcertificatelistoptions1);
            assertNotNull(trustedcertificatelistoptions2);
            assertNotSame(trustedcertificatelistoptions2, trustedcertificatelistoptions1);
            assertEquals(trustedcertificatelistoptions2, trustedcertificatelistoptions1);
            assertEquals(trustedcertificatelistoptions2.hashCode(), trustedcertificatelistoptions1.hashCode());
            int hashCode = trustedcertificatelistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, trustedcertificatelistoptions1.hashCode());
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
            TrustedCertificateListOptions trustedcertificatelistoptions1 = new TrustedCertificateListOptions(Integer.valueOf(-8),
                                                                                                             Long.valueOf(-11),
                                                                                                             Order.getDefault(),
                                                                                                             "dc837ac8-33bd-4fa4-a26d-fc00929589d2",
                                                                                                             null,
                                                                                                             null);
            TrustedCertificateListOptions trustedcertificatelistoptions2 = new TrustedCertificateListOptions(Integer.valueOf(-8),
                                                                                                             Long.valueOf(-11),
                                                                                                             Order.getDefault(),
                                                                                                             "dc837ac8-33bd-4fa4-a26d-fc00929589d2",
                                                                                                             null,
                                                                                                             null);
            TrustedCertificateListOptions trustedcertificatelistoptions3 = new TrustedCertificateListOptions(Integer.valueOf(-70),
                                                                                                             Long.valueOf(-3),
                                                                                                             Order.getDefault(),
                                                                                                             "a5ec18af-06ef-4c71-838a-eea84a2da64d",
                                                                                                             null,
                                                                                                             null);
            assertNotNull(trustedcertificatelistoptions1);
            assertNotNull(trustedcertificatelistoptions2);
            assertNotNull(trustedcertificatelistoptions3);
            assertNotSame(trustedcertificatelistoptions2, trustedcertificatelistoptions1);
            assertNotSame(trustedcertificatelistoptions3, trustedcertificatelistoptions1);
            assertEquals(trustedcertificatelistoptions2, trustedcertificatelistoptions1);
            assertEquals(trustedcertificatelistoptions2, trustedcertificatelistoptions1);
            assertEquals(trustedcertificatelistoptions1, trustedcertificatelistoptions2);
            assertEquals(trustedcertificatelistoptions1, trustedcertificatelistoptions1);
            assertFalse(trustedcertificatelistoptions1.equals(null));
            assertNotEquals(trustedcertificatelistoptions3, trustedcertificatelistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}