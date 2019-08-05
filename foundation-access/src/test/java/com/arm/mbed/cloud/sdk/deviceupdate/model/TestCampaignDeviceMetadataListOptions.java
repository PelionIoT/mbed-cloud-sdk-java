// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model CampaignDeviceMetadataListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCampaignDeviceMetadataListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            CampaignDeviceMetadataListOptions campaigndevicemetadatalistoptions1 = new CampaignDeviceMetadataListOptions(Integer.valueOf(67),
                                                                                                                         Long.valueOf(-123),
                                                                                                                         Order.getDefault(),
                                                                                                                         "558a0ac2-f51b-4ae0-9247-9fd9c3468e7b",
                                                                                                                         null,
                                                                                                                         null);
            CampaignDeviceMetadataListOptions campaigndevicemetadatalistoptions2 = campaigndevicemetadatalistoptions1.clone();
            assertNotNull(campaigndevicemetadatalistoptions1);
            assertNotNull(campaigndevicemetadatalistoptions2);
            assertNotSame(campaigndevicemetadatalistoptions2, campaigndevicemetadatalistoptions1);
            assertEquals(campaigndevicemetadatalistoptions2, campaigndevicemetadatalistoptions1);
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
            CampaignDeviceMetadataListOptions campaigndevicemetadatalistoptions1 = new CampaignDeviceMetadataListOptions(Integer.valueOf(87),
                                                                                                                         Long.valueOf(-15),
                                                                                                                         Order.getDefault(),
                                                                                                                         "eb4974de-1176-4a40-a31e-2c8af0f919ea",
                                                                                                                         null,
                                                                                                                         null);
            CampaignDeviceMetadataListOptions campaigndevicemetadatalistoptions2 = new CampaignDeviceMetadataListOptions(Integer.valueOf(87),
                                                                                                                         Long.valueOf(-15),
                                                                                                                         Order.getDefault(),
                                                                                                                         "eb4974de-1176-4a40-a31e-2c8af0f919ea",
                                                                                                                         null,
                                                                                                                         null);
            assertNotNull(campaigndevicemetadatalistoptions1);
            assertNotNull(campaigndevicemetadatalistoptions2);
            assertNotSame(campaigndevicemetadatalistoptions2, campaigndevicemetadatalistoptions1);
            assertEquals(campaigndevicemetadatalistoptions2, campaigndevicemetadatalistoptions1);
            assertEquals(campaigndevicemetadatalistoptions2.hashCode(), campaigndevicemetadatalistoptions1.hashCode());
            int hashCode = campaigndevicemetadatalistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, campaigndevicemetadatalistoptions1.hashCode());
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
            CampaignDeviceMetadataListOptions campaigndevicemetadatalistoptions1 = new CampaignDeviceMetadataListOptions(Integer.valueOf(-60),
                                                                                                                         Long.valueOf(-42),
                                                                                                                         Order.getDefault(),
                                                                                                                         "958a0fea-0ebd-402e-8f31-652055709f13",
                                                                                                                         null,
                                                                                                                         null);
            CampaignDeviceMetadataListOptions campaigndevicemetadatalistoptions2 = new CampaignDeviceMetadataListOptions(Integer.valueOf(-60),
                                                                                                                         Long.valueOf(-42),
                                                                                                                         Order.getDefault(),
                                                                                                                         "958a0fea-0ebd-402e-8f31-652055709f13",
                                                                                                                         null,
                                                                                                                         null);
            CampaignDeviceMetadataListOptions campaigndevicemetadatalistoptions3 = new CampaignDeviceMetadataListOptions(Integer.valueOf(3),
                                                                                                                         Long.valueOf(-22),
                                                                                                                         Order.getDefault(),
                                                                                                                         "942edb41-e602-4a58-973b-c797194daab8",
                                                                                                                         null,
                                                                                                                         null);
            assertNotNull(campaigndevicemetadatalistoptions1);
            assertNotNull(campaigndevicemetadatalistoptions2);
            assertNotNull(campaigndevicemetadatalistoptions3);
            assertNotSame(campaigndevicemetadatalistoptions2, campaigndevicemetadatalistoptions1);
            assertNotSame(campaigndevicemetadatalistoptions3, campaigndevicemetadatalistoptions1);
            assertEquals(campaigndevicemetadatalistoptions2, campaigndevicemetadatalistoptions1);
            assertEquals(campaigndevicemetadatalistoptions2, campaigndevicemetadatalistoptions1);
            assertEquals(campaigndevicemetadatalistoptions1, campaigndevicemetadatalistoptions2);
            assertEquals(campaigndevicemetadatalistoptions1, campaigndevicemetadatalistoptions1);
            assertFalse(campaigndevicemetadatalistoptions1.equals(null));
            assertNotEquals(campaigndevicemetadatalistoptions3, campaigndevicemetadatalistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
