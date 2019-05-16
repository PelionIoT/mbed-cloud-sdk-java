// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model UpdateCampaignHealthIndicator.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestUpdateCampaignHealthIndicator {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            UpdateCampaignHealthIndicator updatecampaignhealthindicator = UpdateCampaignHealthIndicator.getValue(null);
            assertNotNull(updatecampaignhealthindicator);
            assertTrue(updatecampaignhealthindicator.isDefault());
            updatecampaignhealthindicator = UpdateCampaignHealthIndicator.getValue(UpdateCampaignHealthIndicator.getDefault()
                                                                                                                .getString());
            assertNotNull(updatecampaignhealthindicator);
            assertTrue(updatecampaignhealthindicator.isDefault());
            updatecampaignhealthindicator = UpdateCampaignHealthIndicator.getValue("ERROR");
            assertNotNull(updatecampaignhealthindicator);
            assertTrue(updatecampaignhealthindicator.isDefault());
            updatecampaignhealthindicator = UpdateCampaignHealthIndicator.getValue("ok");
            assertNotNull(updatecampaignhealthindicator);
            assertFalse(updatecampaignhealthindicator.isDefault());
            updatecampaignhealthindicator = UpdateCampaignHealthIndicator.getValue("36cbfe51-75ff-46c0-8297-01f89a327780");
            assertNotNull(updatecampaignhealthindicator);
            assertTrue(updatecampaignhealthindicator.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
