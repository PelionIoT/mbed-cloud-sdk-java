// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model UpdateCampaignDao.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestUpdateCampaignDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            UpdateCampaignDao updatecampaigndao1 = new UpdateCampaignDao();
            UpdateCampaignDao updatecampaigndao2 = updatecampaigndao1.clone();
            assertNotNull(updatecampaigndao1);
            assertNotNull(updatecampaigndao2);
            assertNotSame(updatecampaigndao2, updatecampaigndao1);
            assertEquals(updatecampaigndao2, updatecampaigndao1);
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
            UpdateCampaignDao updatecampaigndao1 = new UpdateCampaignDao();
            UpdateCampaignDao updatecampaigndao2 = new UpdateCampaignDao();
            assertNotNull(updatecampaigndao1);
            assertNotNull(updatecampaigndao2);
            assertNotSame(updatecampaigndao2, updatecampaigndao1);
            assertEquals(updatecampaigndao2, updatecampaigndao1);
            assertEquals(updatecampaigndao2.hashCode(), updatecampaigndao1.hashCode());
            int hashCode = updatecampaigndao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, updatecampaigndao1.hashCode());
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
            UpdateCampaignDao updatecampaigndao1 = new UpdateCampaignDao();
            UpdateCampaignDao updatecampaigndao2 = new UpdateCampaignDao();
            assertNotNull(updatecampaigndao1);
            assertNotNull(updatecampaigndao2);
            assertNotSame(updatecampaigndao2, updatecampaigndao1);
            assertEquals(updatecampaigndao2, updatecampaigndao1);
            assertEquals(updatecampaigndao2, updatecampaigndao1);
            assertEquals(updatecampaigndao1, updatecampaigndao2);
            assertEquals(updatecampaigndao1, updatecampaigndao1);
            assertFalse(updatecampaigndao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}