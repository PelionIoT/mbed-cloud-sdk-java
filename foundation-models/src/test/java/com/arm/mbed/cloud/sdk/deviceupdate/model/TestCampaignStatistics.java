// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model CampaignStatistics.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCampaignStatistics {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("8bd8f44d-a5a3-4664-937d-6d03029c7e9c", 39,
                                                                            new Date(1560172164205L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics2 = campaignstatistics1.clone();
            assertNotNull(campaignstatistics1);
            assertNotNull(campaignstatistics2);
            assertNotSame(campaignstatistics2, campaignstatistics1);
            assertEquals(campaignstatistics2, campaignstatistics1);
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
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("398acf3e-69c8-48b2-a441-6e42fa10be59",
                                                                            -122, new Date(1560172163656L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics2 = new CampaignStatistics("398acf3e-69c8-48b2-a441-6e42fa10be59",
                                                                            -122, new Date(1560172163656L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            assertNotNull(campaignstatistics1);
            assertNotNull(campaignstatistics2);
            assertNotSame(campaignstatistics2, campaignstatistics1);
            assertEquals(campaignstatistics2, campaignstatistics1);
            assertEquals(campaignstatistics2.hashCode(), campaignstatistics1.hashCode());
            int hashCode = campaignstatistics1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, campaignstatistics1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the isValid method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testIsValid() {
        CampaignStatistics campaignstatistics = new CampaignStatistics("b4835c6e-3907-4d65-9e37-7e6fbed06fe1", 64,
                                                                       new Date(1560172163095L),
                                                                       CampaignStatisticsId.getDefault(),
                                                                       CampaignStatisticsSummaryStatus.getDefault());
        assertTrue(campaignstatistics.isValid());
        CampaignStatistics campaignstatisticsInvalid = new CampaignStatistics(null, 103, new Date(1560172169430L),
                                                                              CampaignStatisticsId.getDefault(),
                                                                              CampaignStatisticsSummaryStatus.getDefault());
        assertFalse(campaignstatisticsInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("6feed9bc-cf46-4143-abe9-fc789c288dff", -57,
                                                                            new Date(1560172162800L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics2 = new CampaignStatistics("6feed9bc-cf46-4143-abe9-fc789c288dff", -57,
                                                                            new Date(1560172162800L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics3 = new CampaignStatistics("897a9166-a5b5-412a-9dcc-96441b634676", 32,
                                                                            new Date(1560172166871L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            assertNotNull(campaignstatistics1);
            assertNotNull(campaignstatistics2);
            assertNotNull(campaignstatistics3);
            assertNotSame(campaignstatistics2, campaignstatistics1);
            assertNotSame(campaignstatistics3, campaignstatistics1);
            assertEquals(campaignstatistics2, campaignstatistics1);
            assertEquals(campaignstatistics2, campaignstatistics1);
            assertEquals(campaignstatistics1, campaignstatistics2);
            assertEquals(campaignstatistics1, campaignstatistics1);
            assertFalse(campaignstatistics1.equals(null));
            assertNotEquals(campaignstatistics3, campaignstatistics1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
