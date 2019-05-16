// This file was generated by the Pelion SDK foundation code generator.
// This unit test suite was autogenerated on Fri Apr 05 11:10:55 BST 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

/**
 * Unit tests for Model UpdateCampaign.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestUpdateCampaign {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            UpdateCampaign updatecampaign1 = new UpdateCampaign(null, "c6109e86-01c7-4934-841d-15ada8cda244",
                                                                new Date(1554459065358L),
                                                                "7e065b1c-d110-4405-b360-8d6f096d95f8",
                                                                "af725369-ac15-4a2e-acd9-0b2024d1602b",
                                                                new Date(1554459058066L),
                                                                "f5e8b629-d79b-44e7-907f-dd23c1df8898",
                                                                "1f9e9736-5629-4a4d-9c27-55c568b088a3",
                                                                "187e74b3-b2c9-40fa-98e0-2f38ff4d27f8",
                                                                "e8a029d6-4112-4436-8f46-e16401993c9e",
                                                                "76f83b76-b60e-4dbf-9c99-4bcf8708d5a0",
                                                                new Date(1554459058297L), new Date(1554459060614L),
                                                                new Date(1554459061711L));
            UpdateCampaign updatecampaign2 = updatecampaign1.clone();
            assertNotNull(updatecampaign1);
            assertNotNull(updatecampaign2);
            assertNotSame(updatecampaign2, updatecampaign1);
            assertEquals(updatecampaign2, updatecampaign1);
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
            UpdateCampaign updatecampaign1 = new UpdateCampaign(null, "3536ba78-e9ee-4438-bd2a-4da64161401c",
                                                                new Date(1554459059224L),
                                                                "b0b715ed-36ec-4eeb-8321-ecd1e11ed81e",
                                                                "d77a7541-e2ed-4f18-93cc-bc550346e0f7",
                                                                new Date(1554459061071L),
                                                                "f8d94ad9-cfae-48ec-8a1a-51d6ffcad86c",
                                                                "ef0bf713-cedb-44df-b11f-9c40e136140a",
                                                                "e894b750-db73-41c6-95c6-c668cdc20500",
                                                                "e53d8944-c1e4-49f4-91eb-f8afc5c87326",
                                                                "3d5c8047-1417-4405-82d5-f1bf9b17b102",
                                                                new Date(1554459063270L), new Date(1554459057790L),
                                                                new Date(1554459058372L));
            UpdateCampaign updatecampaign2 = new UpdateCampaign(null, "3536ba78-e9ee-4438-bd2a-4da64161401c",

                                                                new Date(1554459059224L),
                                                                "b0b715ed-36ec-4eeb-8321-ecd1e11ed81e",
                                                                "d77a7541-e2ed-4f18-93cc-bc550346e0f7",
                                                                new Date(1554459061071L),
                                                                "f8d94ad9-cfae-48ec-8a1a-51d6ffcad86c",
                                                                "ef0bf713-cedb-44df-b11f-9c40e136140a",
                                                                "e894b750-db73-41c6-95c6-c668cdc20500",
                                                                "e53d8944-c1e4-49f4-91eb-f8afc5c87326",
                                                                "3d5c8047-1417-4405-82d5-f1bf9b17b102",
                                                                new Date(1554459063270L), new Date(1554459057790L),
                                                                new Date(1554459058372L));
            assertNotNull(updatecampaign1);
            assertNotNull(updatecampaign2);
            assertNotSame(updatecampaign2, updatecampaign1);
            assertEquals(updatecampaign2, updatecampaign1);
            assertEquals(updatecampaign2.hashCode(), updatecampaign1.hashCode());
            int hashCode = updatecampaign1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, updatecampaign1.hashCode());
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
        UpdateCampaign updatecampaign = new UpdateCampaign(null, "301165c4-edc3-4b8e-b4fc-1b7fcac99faa",
                                                           new Date(1554459059399L),
                                                           "a92acd27-afe8-4b68-a5cf-50a84c1453a9",
                                                           "044ac07b-9824-40e6-8fa9-c7335db01346",
                                                           new Date(1554459059200L),
                                                           "3efaff45-4c20-43f2-b58f-f76b85c2713c",
                                                           "25354415-57c9-4971-9ade-aaa68ef6b62e",
                                                           "7c2a7060-208e-4613-9215-af48c9854244",
                                                           "d11d054a-b2a8-452b-8855-986bb4a50dae",
                                                           "4ad69bce-fb09-44cb-bf6a-9a1c46e81979",
                                                           new Date(1554459061120L), new Date(1554459063069L),
                                                           new Date(1554459065190L));
        assertTrue(updatecampaign.isValid());
    }

    /**
     * Tests device Filter encoding decoding
     */
    @Test
    public void testDeviceFilterEncodingDecoding() {
        Filters f = new Filters();
        f.add(new Filter("id", FilterOperator.EQUAL, "a value"));
        UpdateCampaign updatecampaign = new UpdateCampaign();
        assertNull(updatecampaign.getDeviceFilter());
        updatecampaign.setDeviceFiltersHelper(f);
        assertNotNull(updatecampaign.getDeviceFilter());
        assertEquals("id__eq=a value", updatecampaign.getDeviceFilter());
        assertEquals(f, updatecampaign.getDeviceFiltersHelper());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            UpdateCampaign updatecampaign1 = new UpdateCampaign(null, "2474ae20-6173-432c-ac7d-2f2c0c378b18",
                                                                new Date(1554459065062L),
                                                                "4f4f9c2f-e7f9-42f7-bfb6-1d88eddcfe16",
                                                                "006598fa-67f8-4570-af65-2314348c4f76",
                                                                new Date(1554459062223L),
                                                                "fbe467f3-e406-4660-9aad-f8313fba2a57",
                                                                "f631fa83-f09a-476a-ad00-520f3a3bc24a",
                                                                "510c1f35-ff22-458a-bd6a-f4e26808cdf3",
                                                                "28e7ed8b-ceac-4f27-87a5-a89e43c7d253",
                                                                "d23f1cc8-54cd-4862-b910-51194c747061",
                                                                new Date(1554459064721L), new Date(1554459062330L),
                                                                new Date(1554459059485L));
            UpdateCampaign updatecampaign2 = new UpdateCampaign(null, "2474ae20-6173-432c-ac7d-2f2c0c378b18",
                                                                new Date(1554459065062L),
                                                                "4f4f9c2f-e7f9-42f7-bfb6-1d88eddcfe16",
                                                                "006598fa-67f8-4570-af65-2314348c4f76",
                                                                new Date(1554459062223L),
                                                                "fbe467f3-e406-4660-9aad-f8313fba2a57",
                                                                "f631fa83-f09a-476a-ad00-520f3a3bc24a",
                                                                "510c1f35-ff22-458a-bd6a-f4e26808cdf3",
                                                                "28e7ed8b-ceac-4f27-87a5-a89e43c7d253",
                                                                "d23f1cc8-54cd-4862-b910-51194c747061",
                                                                new Date(1554459064721L), new Date(1554459062330L),
                                                                new Date(1554459059485L));
            UpdateCampaign updatecampaign3 = new UpdateCampaign(null, "1caf3743-7882-4e8b-aac0-a9fd3a7a3c8d",
                                                                new Date(1554459060026L),
                                                                "74895f6a-9439-4594-86e2-db96f6a8d81e",
                                                                "0512c47d-4fd5-47c1-80aa-70fd3dd258d5",
                                                                new Date(1554459062370L),
                                                                "8abaf78f-8826-4796-8f6a-ed6e4a00ca94",
                                                                "ab6dc5f3-e2b3-4c63-915c-9bd23aecdaea",
                                                                "825f9bac-0525-4961-97ee-43f4495abab5",
                                                                "992d320f-53d9-4e50-bbc5-981f6972f2bc",
                                                                "bc5f77ad-4d79-4a7e-a7ba-9b40cd080274",
                                                                new Date(1554459065318L), new Date(1554459056590L),
                                                                new Date(1554459056140L));
            assertNotNull(updatecampaign1);
            assertNotNull(updatecampaign2);
            assertNotNull(updatecampaign3);
            assertNotSame(updatecampaign2, updatecampaign1);
            assertNotSame(updatecampaign3, updatecampaign1);
            assertEquals(updatecampaign2, updatecampaign1);
            assertEquals(updatecampaign2, updatecampaign1);
            assertEquals(updatecampaign1, updatecampaign2);
            assertEquals(updatecampaign1, updatecampaign1);
            assertFalse(updatecampaign1.equals(null));
            assertNotEquals(updatecampaign3, updatecampaign1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }

    }
}
