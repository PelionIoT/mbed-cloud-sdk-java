// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model CampaignStatisticsId.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCampaignStatisticsId {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            CampaignStatisticsId campaignstatisticsid = CampaignStatisticsId.getValue(null);
            assertNotNull(campaignstatisticsid);
            assertTrue(campaignstatisticsid.isDefault());
            campaignstatisticsid = CampaignStatisticsId.getValue(CampaignStatisticsId.getDefault().getString());
            assertNotNull(campaignstatisticsid);
            assertTrue(campaignstatisticsid.isDefault());
            campaignstatisticsid = CampaignStatisticsId.getValue("FAIL");
            assertNotNull(campaignstatisticsid);
            assertTrue(campaignstatisticsid.isDefault());
            campaignstatisticsid = CampaignStatisticsId.getValue("info");
            assertNotNull(campaignstatisticsid);
            assertFalse(campaignstatisticsid.isDefault());
            campaignstatisticsid = CampaignStatisticsId.getValue("409e94c3-043a-4ac4-afbf-010ecf81de9f");
            assertNotNull(campaignstatisticsid);
            assertTrue(campaignstatisticsid.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
