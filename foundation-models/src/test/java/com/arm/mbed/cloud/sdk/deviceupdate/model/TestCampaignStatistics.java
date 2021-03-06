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
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("f7ffbebc-9bfe-4e19-9fbf-84f2fa6b921c", -77,
                                                                            new Date(1574704663391L),
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
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("108d94ef-bbe2-4402-b827-37f2a62d1f7a", -78,
                                                                            new Date(1574704665646L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics2 = new CampaignStatistics("108d94ef-bbe2-4402-b827-37f2a62d1f7a", -78,
                                                                            new Date(1574704665646L),
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
        CampaignStatistics campaignstatistics = new CampaignStatistics("68d858c6-733e-43e6-9327-67af90f33085", -42,
                                                                       new Date(1574704665442L),
                                                                       CampaignStatisticsId.getDefault(),
                                                                       CampaignStatisticsSummaryStatus.getDefault());
        assertTrue(campaignstatistics.isValid());
        CampaignStatistics campaignstatisticsInvalid = new CampaignStatistics(null, 7, new Date(1574704662934L),
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
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("e0ab6eef-509f-487e-9e9a-9d6a203384fd", -71,
                                                                            new Date(1574704661699L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics2 = new CampaignStatistics("e0ab6eef-509f-487e-9e9a-9d6a203384fd", -71,
                                                                            new Date(1574704661699L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics3 = new CampaignStatistics("b97dd9be-8af0-4e69-b2d4-d1118e89a497", -39,
                                                                            new Date(1574704660369L),
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
