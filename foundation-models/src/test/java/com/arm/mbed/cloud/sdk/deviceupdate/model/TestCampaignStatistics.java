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
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("d82584f2-422e-4f7f-84eb-2b5a6dc76f68",
                                                                            -114, new Date(1559752146330L),
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
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("dffdd848-08b6-41d7-84fc-32e97adf6d36", 59,
                                                                            new Date(1559752153181L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics2 = new CampaignStatistics("dffdd848-08b6-41d7-84fc-32e97adf6d36", 59,
                                                                            new Date(1559752153181L),
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
        CampaignStatistics campaignstatistics = new CampaignStatistics("a8cfb921-5378-4830-9fc6-2b1fa9d027a5", -101,
                                                                       new Date(1559752144975L),
                                                                       CampaignStatisticsId.getDefault(),
                                                                       CampaignStatisticsSummaryStatus.getDefault());
        assertTrue(campaignstatistics.isValid());
        CampaignStatistics campaignstatisticsInvalid = new CampaignStatistics(null, 110, new Date(1559752150004L),
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
            CampaignStatistics campaignstatistics1 = new CampaignStatistics("3e1ace13-8c29-42cf-b18a-9e942ebcd2b3", -88,
                                                                            new Date(1559752147207L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics2 = new CampaignStatistics("3e1ace13-8c29-42cf-b18a-9e942ebcd2b3", -88,
                                                                            new Date(1559752147207L),
                                                                            CampaignStatisticsId.getDefault(),
                                                                            CampaignStatisticsSummaryStatus.getDefault());
            CampaignStatistics campaignstatistics3 = new CampaignStatistics("e8b16c12-1a5e-4d20-9673-ce6e7bd324f8", -76,
                                                                            new Date(1559752148711L),
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
