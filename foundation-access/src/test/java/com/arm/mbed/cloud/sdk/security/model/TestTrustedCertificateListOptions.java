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
            TrustedCertificateListOptions trustedcertificatelistoptions1 = new TrustedCertificateListOptions(Integer.valueOf(-64),
                                                                                                             Long.valueOf(103),
                                                                                                             Order.getDefault(),
                                                                                                             "2042d6fd-f3f5-41e1-b223-fddd7296705e",
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
                                                                                      .equalToName("39654423-aeda-4e46-8822-a2671e62e4f9")
                                                                                      .equalToStatus(TrustedCertificateStatus.getDefault())
                                                                                      .equalToDeviceExecutionMode(Integer.valueOf(45))
                                                                                      .notEqualToDeviceExecutionMode(Integer.valueOf(70))
                                                                                      .likeIssuer("64ddd1c5-16cd-48d8-8087-380a3fd6f999")
                                                                                      .equalToService(TrustedCertificateService.getDefault())
                                                                                      .likeSubject("9b625350-0092-443c-82c5-fcd68255b601")
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
            assertEquals("39654423-aeda-4e46-8822-a2671e62e4f9",
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
            assertEquals(Integer.valueOf(45),
                         ListOptionsEncoder.encodeSingleEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                                                    Integer.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                        FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDeviceExecutionModeFilters());
            assertEquals(Integer.valueOf(70),
                         ListOptionsEncoder.encodeSingleNotEqualFilter(TrustedCertificateListOptions.TAG_FILTER_BY_DEVICE_EXECUTION_MODE,
                                                                       Integer.class, option));
            assertTrue(option.hasFilters(TrustedCertificateListOptions.TAG_FILTER_BY_ISSUER));
            assertTrue(option.hasFilter(TrustedCertificateListOptions.TAG_FILTER_BY_ISSUER, FilterOperator.LIKE));
            assertNotNull(option.getIssuerFilters());
            assertEquals("64ddd1c5-16cd-48d8-8087-380a3fd6f999",
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
            assertEquals("9b625350-0092-443c-82c5-fcd68255b601",
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
            TrustedCertificateListOptions trustedcertificatelistoptions1 = new TrustedCertificateListOptions(Integer.valueOf(-98),
                                                                                                             Long.valueOf(-23),
                                                                                                             Order.getDefault(),
                                                                                                             "0bea3f83-9f54-44a9-980c-4350a371cbf1",
                                                                                                             null,
                                                                                                             null);
            TrustedCertificateListOptions trustedcertificatelistoptions2 = new TrustedCertificateListOptions(Integer.valueOf(-98),
                                                                                                             Long.valueOf(-23),
                                                                                                             Order.getDefault(),
                                                                                                             "0bea3f83-9f54-44a9-980c-4350a371cbf1",
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
            TrustedCertificateListOptions trustedcertificatelistoptions1 = new TrustedCertificateListOptions(Integer.valueOf(119),
                                                                                                             Long.valueOf(13),
                                                                                                             Order.getDefault(),
                                                                                                             "b63f421e-4554-4fbf-807d-ce986cc352b6",
                                                                                                             null,
                                                                                                             null);
            TrustedCertificateListOptions trustedcertificatelistoptions2 = new TrustedCertificateListOptions(Integer.valueOf(119),
                                                                                                             Long.valueOf(13),
                                                                                                             Order.getDefault(),
                                                                                                             "b63f421e-4554-4fbf-807d-ce986cc352b6",
                                                                                                             null,
                                                                                                             null);
            TrustedCertificateListOptions trustedcertificatelistoptions3 = new TrustedCertificateListOptions(Integer.valueOf(-102),
                                                                                                             Long.valueOf(13),
                                                                                                             Order.getDefault(),
                                                                                                             "db1d95d6-b73b-4742-a35b-7a59a6a62655",
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
