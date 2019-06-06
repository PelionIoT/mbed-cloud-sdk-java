// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/**
 * Unit tests for Model DeviceEventsListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEventsListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEventsListOptions deviceeventslistoptions1 = new DeviceEventsListOptions(Integer.valueOf(-117),
                                                                                           Long.valueOf(17),
                                                                                           Order.getDefault(),
                                                                                           "47894678-1421-4e69-8acb-95e07586f0cd",
                                                                                           null, null);
            DeviceEventsListOptions deviceeventslistoptions2 = deviceeventslistoptions1.clone();
            assertNotNull(deviceeventslistoptions1);
            assertNotNull(deviceeventslistoptions2);
            assertNotSame(deviceeventslistoptions2, deviceeventslistoptions1);
            assertEquals(deviceeventslistoptions2, deviceeventslistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the filters method.
     */
    @SuppressWarnings({ "boxing", "resource" })
    @Test
    public void testFilters() {
        try {
            DeviceEventsListOptions option = new DeviceEventsListOptions().equalToDeviceId("f13b58d5-179f-4632-b496-925d8b59785d")
                                                                          .notEqualToDeviceId("5823840a-1220-472c-ab6a-61b42323d7bc")
                                                                          .inDeviceIds(Arrays.asList("b990fb72-f61c-4bca-9c81-6502b22cd579",
                                                                                                     "0f1e9b9a-ec32-40d8-ab29-fffa563d5abf",
                                                                                                     "886bbc9b-7a1e-4d15-a78a-3541bf9da61e"))
                                                                          .notInDeviceIds(Arrays.asList("8ac7c174-6e38-4fc2-aa54-b61391ddc7dc",
                                                                                                        "cd107a49-b610-4f5b-9452-6d82f0405580"))
                                                                          .equalToDescription("e400c7e7-1e44-4eea-89c4-e7fa030e2cb6")
                                                                          .notEqualToDescription("07d21416-7e00-49de-bd3a-ec616016a3ee")
                                                                          .inDescriptions(Arrays.asList("3fed6495-dc84-4050-a642-bf680a0e3282",
                                                                                                        "c5fc9916-fe83-48b3-a139-a7d107d8232a",
                                                                                                        "0003f4cf-8c6f-4cb6-bece-c5110d227a22",
                                                                                                        "fd76a35d-a6e4-45b5-90b4-06dae341dd94"))
                                                                          .notInDescriptions(Arrays.asList("b2ce08de-d68a-4a8d-a3a3-f31f7da9c4f2",
                                                                                                           "35234aef-e89e-430c-8947-58525453aca8",
                                                                                                           "5ac9eb25-baf2-4d42-81b4-3e3be2fb163a",
                                                                                                           "265663ca-28e1-4257-89e1-0c8837a5bd7a",
                                                                                                           "bc3874ea-7498-489a-b917-c1551f054ba3",
                                                                                                           "03b29622-2d45-4b0b-9127-5d4ff6689a42",
                                                                                                           "c3a4ebc8-ef6b-4166-9700-1197d136f607",
                                                                                                           "f6c55db8-a678-414f-becf-ef4c41972480",
                                                                                                           "bf2e08d6-fbde-4cf3-ae24-54f68c80d095"))
                                                                          .inDateTimes(Arrays.asList(new Date(1559762580390L),
                                                                                                     new Date(1559762578169L),
                                                                                                     new Date(1559762577120L)))
                                                                          .notInDateTimes(Arrays.asList(new Date(1559762582663L),
                                                                                                        new Date(1559762576576L),
                                                                                                        new Date(1559762582303L),
                                                                                                        new Date(1559762578274L),
                                                                                                        new Date(1559762579980L)))
                                                                          .lessThanDateTime(new Date(1559762583868L))
                                                                          .greaterThanDateTime(new Date(1559762578568L))
                                                                          .equalToStateChange(Boolean.FALSE)
                                                                          .notEqualToStateChange(Boolean.TRUE)
                                                                          .equalToId("374e76bd-d29b-4759-af06-2ec2b2a993b9")
                                                                          .notEqualToId("c2bf4e60-e1a2-4ee1-ab8a-6eaee3357c6e")
                                                                          .inIds(Arrays.asList("940bffbd-2d42-477d-b144-688246f9a624",
                                                                                               "b66f10ae-403a-4832-ad00-d52514ae7143"))
                                                                          .notInIds(Arrays.asList("c5852492-dbfd-4e3c-956a-871dad1288e2",
                                                                                                  "e05019a2-0330-4c75-b848-ee51ec61694e"))
                                                                          .equalToEventType("e9208511-4644-4416-9163-e8c31abf00cb")
                                                                          .notEqualToEventType("608d1eaf-a353-4563-b379-c87a5de1c081")
                                                                          .inEventTypes(Arrays.asList("eb0df12f-bf7d-4d89-bfe5-6e768152ddf0",
                                                                                                      "075e93e5-a9dc-483b-8f08-f47a56fa0cc6",
                                                                                                      "a2b47cae-2422-46f1-9a34-b1c8525c2aeb",
                                                                                                      "3617a22f-16a6-402a-978f-9d83810582b0",
                                                                                                      "2896fe7b-2072-48e3-bae6-61ce20ea7a2a"))
                                                                          .notInEventTypes(Arrays.asList("d2fc5bb5-532b-4080-9bf6-0926ae6a1a7d",
                                                                                                         "5b04a4f6-f193-4a89-9c89-c8baa2610bc8",
                                                                                                         "1977732d-2886-40bd-b509-0bc4dca87d64",
                                                                                                         "2ac85625-081b-4adf-82f2-6557b80e2683",
                                                                                                         "cb4fa65c-5fbf-4cf2-adf0-46de6e3557f1",
                                                                                                         "7166ff03-8334-40cc-8dc3-d0ff90f91160"));
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID, FilterOperator.EQUAL));
            assertNotNull(option.getDeviceIdFilters());
            assertEquals("f13b58d5-179f-4632-b496-925d8b59785d",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDeviceIdFilters());
            assertEquals("5823840a-1220-472c-ab6a-61b42323d7bc",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID,
                                                                       String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID, FilterOperator.IN));
            assertNotNull(option.getDeviceIdFilters());
            assertEquals(Arrays.asList("b990fb72-f61c-4bca-9c81-6502b22cd579", "0f1e9b9a-ec32-40d8-ab29-fffa563d5abf",
                                       "886bbc9b-7a1e-4d15-a78a-3541bf9da61e"),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID,
                                                                 List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID, FilterOperator.NOT_IN));
            assertNotNull(option.getDeviceIdFilters());
            assertEquals(Arrays.asList("8ac7c174-6e38-4fc2-aa54-b61391ddc7dc", "cd107a49-b610-4f5b-9452-6d82f0405580"),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID,
                                                                    List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.EQUAL));
            assertNotNull(option.getDescriptionFilters());
            assertEquals("e400c7e7-1e44-4eea-89c4-e7fa030e2cb6",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDescriptionFilters());
            assertEquals("07d21416-7e00-49de-bd3a-ec616016a3ee",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                       String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.IN));
            assertNotNull(option.getDescriptionFilters());
            assertEquals(Arrays.asList("3fed6495-dc84-4050-a642-bf680a0e3282", "c5fc9916-fe83-48b3-a139-a7d107d8232a",
                                       "0003f4cf-8c6f-4cb6-bece-c5110d227a22", "fd76a35d-a6e4-45b5-90b4-06dae341dd94"),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                 List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.NOT_IN));
            assertNotNull(option.getDescriptionFilters());
            assertEquals(Arrays.asList("b2ce08de-d68a-4a8d-a3a3-f31f7da9c4f2", "35234aef-e89e-430c-8947-58525453aca8",
                                       "5ac9eb25-baf2-4d42-81b4-3e3be2fb163a", "265663ca-28e1-4257-89e1-0c8837a5bd7a",
                                       "bc3874ea-7498-489a-b917-c1551f054ba3", "03b29622-2d45-4b0b-9127-5d4ff6689a42",
                                       "c3a4ebc8-ef6b-4166-9700-1197d136f607", "f6c55db8-a678-414f-becf-ef4c41972480",
                                       "bf2e08d6-fbde-4cf3-ae24-54f68c80d095"),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                    List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME, FilterOperator.IN));
            assertNotNull(option.getDateTimeFilters());
            assertEquals(Arrays.asList(new Date(1559762580390L), new Date(1559762578169L), new Date(1559762577120L)),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME,
                                                                 List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME, FilterOperator.NOT_IN));
            assertNotNull(option.getDateTimeFilters());
            assertEquals(Arrays.asList(new Date(1559762582663L), new Date(1559762576576L), new Date(1559762582303L),
                                       new Date(1559762578274L), new Date(1559762579980L)),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME,
                                                                    List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME, FilterOperator.LESS_THAN));
            assertNotNull(option.getDateTimeFilters());
            assertEquals(new Date(1559762583868L),
                         ListOptionsEncoder.encodeSingleLessThanFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME,
                                                                       Date.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME, FilterOperator.GREATER_THAN));
            assertNotNull(option.getDateTimeFilters());
            assertEquals(new Date(1559762578568L),
                         ListOptionsEncoder.encodeSingleGreaterThanFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME,
                                                                          Date.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE, FilterOperator.EQUAL));
            assertNotNull(option.getStateChangeFilters());
            assertEquals(Boolean.FALSE,
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE,
                                                                    Boolean.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getStateChangeFilters());
            assertEquals(Boolean.TRUE,
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE,
                                                                       Boolean.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, FilterOperator.EQUAL));
            assertNotNull(option.getIdFilters());
            assertEquals("374e76bd-d29b-4759-af06-2ec2b2a993b9",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getIdFilters());
            assertEquals("c2bf4e60-e1a2-4ee1-ab8a-6eaee3357c6e",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID,
                                                                       String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, FilterOperator.IN));
            assertNotNull(option.getIdFilters());
            assertEquals(Arrays.asList("940bffbd-2d42-477d-b144-688246f9a624", "b66f10ae-403a-4832-ad00-d52514ae7143"),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, List.class,
                                                                 option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, FilterOperator.NOT_IN));
            assertNotNull(option.getIdFilters());
            assertEquals(Arrays.asList("c5852492-dbfd-4e3c-956a-871dad1288e2", "e05019a2-0330-4c75-b848-ee51ec61694e"),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID,
                                                                    List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE, FilterOperator.EQUAL));
            assertNotNull(option.getEventTypeFilters());
            assertEquals("e9208511-4644-4416-9163-e8c31abf00cb",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getEventTypeFilters());
            assertEquals("608d1eaf-a353-4563-b379-c87a5de1c081",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE,
                                                                       String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE, FilterOperator.IN));
            assertNotNull(option.getEventTypeFilters());
            assertEquals(Arrays.asList("eb0df12f-bf7d-4d89-bfe5-6e768152ddf0", "075e93e5-a9dc-483b-8f08-f47a56fa0cc6",
                                       "a2b47cae-2422-46f1-9a34-b1c8525c2aeb", "3617a22f-16a6-402a-978f-9d83810582b0",
                                       "2896fe7b-2072-48e3-bae6-61ce20ea7a2a"),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE,
                                                                 List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE, FilterOperator.NOT_IN));
            assertNotNull(option.getEventTypeFilters());
            assertEquals(Arrays.asList("d2fc5bb5-532b-4080-9bf6-0926ae6a1a7d", "5b04a4f6-f193-4a89-9c89-c8baa2610bc8",
                                       "1977732d-2886-40bd-b509-0bc4dca87d64", "2ac85625-081b-4adf-82f2-6557b80e2683",
                                       "cb4fa65c-5fbf-4cf2-adf0-46de6e3557f1", "7166ff03-8334-40cc-8dc3-d0ff90f91160"),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE,
                                                                    List.class, option));
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
            DeviceEventsListOptions deviceeventslistoptions1 = new DeviceEventsListOptions(Integer.valueOf(11),
                                                                                           Long.valueOf(-38),
                                                                                           Order.getDefault(),
                                                                                           "310cd5a5-45d2-4443-a088-5b64ea873e07",
                                                                                           null, null);
            DeviceEventsListOptions deviceeventslistoptions2 = new DeviceEventsListOptions(Integer.valueOf(11),
                                                                                           Long.valueOf(-38),
                                                                                           Order.getDefault(),
                                                                                           "310cd5a5-45d2-4443-a088-5b64ea873e07",
                                                                                           null, null);
            assertNotNull(deviceeventslistoptions1);
            assertNotNull(deviceeventslistoptions2);
            assertNotSame(deviceeventslistoptions2, deviceeventslistoptions1);
            assertEquals(deviceeventslistoptions2, deviceeventslistoptions1);
            assertEquals(deviceeventslistoptions2.hashCode(), deviceeventslistoptions1.hashCode());
            int hashCode = deviceeventslistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceeventslistoptions1.hashCode());
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
            DeviceEventsListOptions deviceeventslistoptions1 = new DeviceEventsListOptions(Integer.valueOf(-83),
                                                                                           Long.valueOf(60),
                                                                                           Order.getDefault(),
                                                                                           "4f72f73a-5d5c-43e3-a746-3d7962725bb0",
                                                                                           null, null);
            DeviceEventsListOptions deviceeventslistoptions2 = new DeviceEventsListOptions(Integer.valueOf(-83),
                                                                                           Long.valueOf(60),
                                                                                           Order.getDefault(),
                                                                                           "4f72f73a-5d5c-43e3-a746-3d7962725bb0",
                                                                                           null, null);
            DeviceEventsListOptions deviceeventslistoptions3 = new DeviceEventsListOptions(Integer.valueOf(-73),
                                                                                           Long.valueOf(67),
                                                                                           Order.getDefault(),
                                                                                           "c43e590c-bad1-44fd-aa7b-58b413a1965a",
                                                                                           null, null);
            assertNotNull(deviceeventslistoptions1);
            assertNotNull(deviceeventslistoptions2);
            assertNotNull(deviceeventslistoptions3);
            assertNotSame(deviceeventslistoptions2, deviceeventslistoptions1);
            assertNotSame(deviceeventslistoptions3, deviceeventslistoptions1);
            assertEquals(deviceeventslistoptions2, deviceeventslistoptions1);
            assertEquals(deviceeventslistoptions2, deviceeventslistoptions1);
            assertEquals(deviceeventslistoptions1, deviceeventslistoptions2);
            assertEquals(deviceeventslistoptions1, deviceeventslistoptions1);
            assertFalse(deviceeventslistoptions1.equals(null));
            assertNotEquals(deviceeventslistoptions3, deviceeventslistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
