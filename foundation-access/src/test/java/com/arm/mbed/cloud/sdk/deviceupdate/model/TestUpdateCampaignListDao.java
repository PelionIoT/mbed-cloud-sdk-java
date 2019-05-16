// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model UpdateCampaignListDao.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestUpdateCampaignListDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            UpdateCampaignListDao updatecampaignlistdao1 = new UpdateCampaignListDao();
            UpdateCampaignListDao updatecampaignlistdao2 = updatecampaignlistdao1.clone();
            assertNotNull(updatecampaignlistdao1);
            assertNotNull(updatecampaignlistdao2);
            assertNotSame(updatecampaignlistdao2, updatecampaignlistdao1);
            assertEquals(updatecampaignlistdao2, updatecampaignlistdao1);
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
            UpdateCampaignListDao updatecampaignlistdao1 = new UpdateCampaignListDao();
            UpdateCampaignListDao updatecampaignlistdao2 = new UpdateCampaignListDao();
            assertNotNull(updatecampaignlistdao1);
            assertNotNull(updatecampaignlistdao2);
            assertNotSame(updatecampaignlistdao2, updatecampaignlistdao1);
            assertEquals(updatecampaignlistdao2, updatecampaignlistdao1);
            assertEquals(updatecampaignlistdao2.hashCode(), updatecampaignlistdao1.hashCode());
            int hashCode = updatecampaignlistdao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, updatecampaignlistdao1.hashCode());
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
            UpdateCampaignListDao updatecampaignlistdao1 = new UpdateCampaignListDao();
            UpdateCampaignListDao updatecampaignlistdao2 = new UpdateCampaignListDao();
            assertNotNull(updatecampaignlistdao1);
            assertNotNull(updatecampaignlistdao2);
            assertNotSame(updatecampaignlistdao2, updatecampaignlistdao1);
            assertEquals(updatecampaignlistdao2, updatecampaignlistdao1);
            assertEquals(updatecampaignlistdao2, updatecampaignlistdao1);
            assertEquals(updatecampaignlistdao1, updatecampaignlistdao2);
            assertEquals(updatecampaignlistdao1, updatecampaignlistdao1);
            assertFalse(updatecampaignlistdao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
