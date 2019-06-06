// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model CampaignStatisticsEventsListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCampaignStatisticsEventsListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            CampaignStatisticsEventsListOptions campaignstatisticseventslistoptions1 = new CampaignStatisticsEventsListOptions(Integer.valueOf(-52),
                                                                                                                               Long.valueOf(-115),
                                                                                                                               Order.getDefault(),
                                                                                                                               "609891d3-c957-4671-9519-11f7805de6d5",
                                                                                                                               null,
                                                                                                                               null);
            CampaignStatisticsEventsListOptions campaignstatisticseventslistoptions2 = campaignstatisticseventslistoptions1.clone();
            assertNotNull(campaignstatisticseventslistoptions1);
            assertNotNull(campaignstatisticseventslistoptions2);
            assertNotSame(campaignstatisticseventslistoptions2, campaignstatisticseventslistoptions1);
            assertEquals(campaignstatisticseventslistoptions2, campaignstatisticseventslistoptions1);
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
            CampaignStatisticsEventsListOptions campaignstatisticseventslistoptions1 = new CampaignStatisticsEventsListOptions(Integer.valueOf(-120),
                                                                                                                               Long.valueOf(-72),
                                                                                                                               Order.getDefault(),
                                                                                                                               "18b3560a-9be5-42f8-9c37-70f010da72a3",
                                                                                                                               null,
                                                                                                                               null);
            CampaignStatisticsEventsListOptions campaignstatisticseventslistoptions2 = new CampaignStatisticsEventsListOptions(Integer.valueOf(-120),
                                                                                                                               Long.valueOf(-72),
                                                                                                                               Order.getDefault(),
                                                                                                                               "18b3560a-9be5-42f8-9c37-70f010da72a3",
                                                                                                                               null,
                                                                                                                               null);
            assertNotNull(campaignstatisticseventslistoptions1);
            assertNotNull(campaignstatisticseventslistoptions2);
            assertNotSame(campaignstatisticseventslistoptions2, campaignstatisticseventslistoptions1);
            assertEquals(campaignstatisticseventslistoptions2, campaignstatisticseventslistoptions1);
            assertEquals(campaignstatisticseventslistoptions2.hashCode(),
                         campaignstatisticseventslistoptions1.hashCode());
            int hashCode = campaignstatisticseventslistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, campaignstatisticseventslistoptions1.hashCode());
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
            CampaignStatisticsEventsListOptions campaignstatisticseventslistoptions1 = new CampaignStatisticsEventsListOptions(Integer.valueOf(67),
                                                                                                                               Long.valueOf(-51),
                                                                                                                               Order.getDefault(),
                                                                                                                               "fbe49ee1-fd6c-4edb-9aff-dc0d76f342ef",
                                                                                                                               null,
                                                                                                                               null);
            CampaignStatisticsEventsListOptions campaignstatisticseventslistoptions2 = new CampaignStatisticsEventsListOptions(Integer.valueOf(67),
                                                                                                                               Long.valueOf(-51),
                                                                                                                               Order.getDefault(),
                                                                                                                               "fbe49ee1-fd6c-4edb-9aff-dc0d76f342ef",
                                                                                                                               null,
                                                                                                                               null);
            CampaignStatisticsEventsListOptions campaignstatisticseventslistoptions3 = new CampaignStatisticsEventsListOptions(Integer.valueOf(-21),
                                                                                                                               Long.valueOf(75),
                                                                                                                               Order.getDefault(),
                                                                                                                               "42242ccf-57db-492c-b699-96b6b64612f8",
                                                                                                                               null,
                                                                                                                               null);
            assertNotNull(campaignstatisticseventslistoptions1);
            assertNotNull(campaignstatisticseventslistoptions2);
            assertNotNull(campaignstatisticseventslistoptions3);
            assertNotSame(campaignstatisticseventslistoptions2, campaignstatisticseventslistoptions1);
            assertNotSame(campaignstatisticseventslistoptions3, campaignstatisticseventslistoptions1);
            assertEquals(campaignstatisticseventslistoptions2, campaignstatisticseventslistoptions1);
            assertEquals(campaignstatisticseventslistoptions2, campaignstatisticseventslistoptions1);
            assertEquals(campaignstatisticseventslistoptions1, campaignstatisticseventslistoptions2);
            assertEquals(campaignstatisticseventslistoptions1, campaignstatisticseventslistoptions1);
            assertFalse(campaignstatisticseventslistoptions1.equals(null));
            assertNotEquals(campaignstatisticseventslistoptions3, campaignstatisticseventslistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
