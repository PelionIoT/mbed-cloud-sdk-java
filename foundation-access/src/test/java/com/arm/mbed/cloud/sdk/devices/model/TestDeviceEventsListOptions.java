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
            DeviceEventsListOptions deviceeventslistoptions1 = new DeviceEventsListOptions(Integer.valueOf(-31),
                                                                                           Long.valueOf(-101),
                                                                                           Order.getDefault(),
                                                                                           "cf45e2b7-a7c7-4297-9fde-f05708984949",
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
            DeviceEventsListOptions option = new DeviceEventsListOptions().equalToDeviceId("14673865-1a46-479a-9d3e-a0441204dac8")
                                                                          .notEqualToDeviceId("cefaed86-2c85-4ce0-bbb2-eca9257e3f0e")
                                                                          .inDeviceIds(Arrays.asList("2e1b87be-f7e9-4798-aa96-c8924fc7b882",
                                                                                                     "8cdc23dc-af10-4766-b0dc-13531602014f",
                                                                                                     "be407474-1a2c-4cf2-9165-cd0a9f783176",
                                                                                                     "0fe13823-fb82-475b-8fc3-cbe1546c1d32",
                                                                                                     "d4ae3020-a377-4753-815a-2124de5464aa",
                                                                                                     "6c4ec7e0-9d3f-4b57-beef-068caac2cb77",
                                                                                                     "80a9bece-d1b6-4bd9-930f-7c4dd19aeba4"))
                                                                          .notInDeviceIds(Arrays.asList("2c2358da-3603-491f-ac41-cda6676a6ec5",
                                                                                                        "f588a803-cfdc-4f8a-b676-df79fda65a2c",
                                                                                                        "4735fdce-39a6-4213-a8bc-a092d7557fbc",
                                                                                                        "61aa4787-fbcb-4455-98a0-94c3024171e7",
                                                                                                        "8728924a-829c-49bd-85a0-f710dea0de42",
                                                                                                        "62d30b44-50bb-4714-b0b8-49c8a5f47e34"))
                                                                          .equalToDescription("cfb87754-b820-43d3-b502-9dc858e8f2f8")
                                                                          .notEqualToDescription("c1d61668-c7ec-4d9d-b843-af4ae73bf8fb")
                                                                          .inDescriptions(Arrays.asList("3e1aaa2c-7128-4f7d-9808-1ad10fbb74bb",
                                                                                                        "725169c5-53f9-4fad-b808-f8e144c65e7e",
                                                                                                        "b4c3efce-e4a9-4ecc-b052-49a564424b50",
                                                                                                        "a4ae91ca-5b01-4343-ae3b-181a4ce10f5c",
                                                                                                        "4172de5e-d25f-4224-af20-aeabcb0a031d",
                                                                                                        "9b621c29-7000-4a83-9755-742b83788f51",
                                                                                                        "fe8a3fe3-fbfc-4747-9378-2c448a1d9fbb",
                                                                                                        "34ef37b5-5482-439f-a9b5-9b4f5d5989e6",
                                                                                                        "5300369a-e8ad-4a4f-81f1-76c9827d6505"))
                                                                          .notInDescriptions(Arrays.asList("33659c45-4fb6-41b7-a9f6-0f194ce91073"))
                                                                          .inDateTimes(Arrays.asList(new Date(1560172172698L),
                                                                                                     new Date(1560172163820L),
                                                                                                     new Date(1560172166848L),
                                                                                                     new Date(1560172166560L),
                                                                                                     new Date(1560172166969L),
                                                                                                     new Date(1560172167821L),
                                                                                                     new Date(1560172164268L),
                                                                                                     new Date(1560172165198L)))
                                                                          .notInDateTimes(Arrays.asList(new Date(1560172167747L),
                                                                                                        new Date(1560172169484L),
                                                                                                        new Date(1560172170599L),
                                                                                                        new Date(1560172172164L),
                                                                                                        new Date(1560172170141L)))
                                                                          .lessThanDateTime(new Date(1560172165233L))
                                                                          .greaterThanDateTime(new Date(1560172166402L))
                                                                          .equalToStateChange(Boolean.TRUE)
                                                                          .notEqualToStateChange(Boolean.FALSE)
                                                                          .equalToId("8b001c6c-ac74-40cd-b029-c59c4bf237c6")
                                                                          .notEqualToId("ddbd591a-51b9-4a3a-acdc-cab9908870a9")
                                                                          .inIds(Arrays.asList("5b3c3e04-cc88-4431-8d62-fe12d7a8f460",
                                                                                               "6262f95b-ac65-409c-8d9c-9f9fd153dba6",
                                                                                               "42d4c619-663d-4f55-8475-326b22db5509",
                                                                                               "3c224114-0d2f-45da-b2c7-e3c5a2d07dc6"))
                                                                          .notInIds(Arrays.asList("def5869d-6661-4dc2-8d45-97f191d644a9",
                                                                                                  "be34517d-4521-49ed-954a-5449fb6b507f",
                                                                                                  "2d305572-f4b0-405f-bdfd-1fa51db87655"))
                                                                          .equalToEventType("32502c56-f1df-4cd9-add1-1538ae4b94d2")
                                                                          .notEqualToEventType("d5b9b648-4777-4ec7-be7e-b71099507a55")
                                                                          .inEventTypes(Arrays.asList("761d5847-79d6-4257-9b4e-9f85ef39292d",
                                                                                                      "25596128-6003-4666-8a66-c4b2c403ddda",
                                                                                                      "e99ef244-6669-4070-9360-66501b7aac31",
                                                                                                      "3e72eb29-dcbd-437f-ba9e-b1584fb758f1"))
                                                                          .notInEventTypes(Arrays.asList("493a8f67-9f30-45e1-998a-01efc2c66c56",
                                                                                                         "61a18b66-84ac-48e5-9e6f-5ef8dd7261b6",
                                                                                                         "8b96e2fd-8090-4788-b930-aee5c9e92f52",
                                                                                                         "e12ae8f5-2d59-4fbd-bffe-a61e8bea85ce"));
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID, FilterOperator.EQUAL));
            assertNotNull(option.getDeviceIdFilters());
            assertEquals("14673865-1a46-479a-9d3e-a0441204dac8",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDeviceIdFilters());
            assertEquals("cefaed86-2c85-4ce0-bbb2-eca9257e3f0e",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID,
                                                                       String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID, FilterOperator.IN));
            assertNotNull(option.getDeviceIdFilters());
            assertEquals(Arrays.asList("2e1b87be-f7e9-4798-aa96-c8924fc7b882", "8cdc23dc-af10-4766-b0dc-13531602014f",
                                       "be407474-1a2c-4cf2-9165-cd0a9f783176", "0fe13823-fb82-475b-8fc3-cbe1546c1d32",
                                       "d4ae3020-a377-4753-815a-2124de5464aa", "6c4ec7e0-9d3f-4b57-beef-068caac2cb77",
                                       "80a9bece-d1b6-4bd9-930f-7c4dd19aeba4"),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID,
                                                                 List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID, FilterOperator.NOT_IN));
            assertNotNull(option.getDeviceIdFilters());
            assertEquals(Arrays.asList("2c2358da-3603-491f-ac41-cda6676a6ec5", "f588a803-cfdc-4f8a-b676-df79fda65a2c",
                                       "4735fdce-39a6-4213-a8bc-a092d7557fbc", "61aa4787-fbcb-4455-98a0-94c3024171e7",
                                       "8728924a-829c-49bd-85a0-f710dea0de42", "62d30b44-50bb-4714-b0b8-49c8a5f47e34"),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DEVICE_ID,
                                                                    List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.EQUAL));
            assertNotNull(option.getDescriptionFilters());
            assertEquals("cfb87754-b820-43d3-b502-9dc858e8f2f8",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDescriptionFilters());
            assertEquals("c1d61668-c7ec-4d9d-b843-af4ae73bf8fb",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                       String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.IN));
            assertNotNull(option.getDescriptionFilters());
            assertEquals(Arrays.asList("3e1aaa2c-7128-4f7d-9808-1ad10fbb74bb", "725169c5-53f9-4fad-b808-f8e144c65e7e",
                                       "b4c3efce-e4a9-4ecc-b052-49a564424b50", "a4ae91ca-5b01-4343-ae3b-181a4ce10f5c",
                                       "4172de5e-d25f-4224-af20-aeabcb0a031d", "9b621c29-7000-4a83-9755-742b83788f51",
                                       "fe8a3fe3-fbfc-4747-9378-2c448a1d9fbb", "34ef37b5-5482-439f-a9b5-9b4f5d5989e6",
                                       "5300369a-e8ad-4a4f-81f1-76c9827d6505"),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                 List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.NOT_IN));
            assertNotNull(option.getDescriptionFilters());
            assertEquals(Arrays.asList("33659c45-4fb6-41b7-a9f6-0f194ce91073"),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                    List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME, FilterOperator.IN));
            assertNotNull(option.getDateTimeFilters());
            assertEquals(Arrays.asList(new Date(1560172172698L), new Date(1560172163820L), new Date(1560172166848L),
                                       new Date(1560172166560L), new Date(1560172166969L), new Date(1560172167821L),
                                       new Date(1560172164268L), new Date(1560172165198L)),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME,
                                                                 List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME, FilterOperator.NOT_IN));
            assertNotNull(option.getDateTimeFilters());
            assertEquals(Arrays.asList(new Date(1560172167747L), new Date(1560172169484L), new Date(1560172170599L),
                                       new Date(1560172172164L), new Date(1560172170141L)),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME,
                                                                    List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME, FilterOperator.LESS_THAN));
            assertNotNull(option.getDateTimeFilters());
            assertEquals(new Date(1560172165233L),
                         ListOptionsEncoder.encodeSingleLessThanFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME,
                                                                       Date.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME, FilterOperator.GREATER_THAN));
            assertNotNull(option.getDateTimeFilters());
            assertEquals(new Date(1560172166402L),
                         ListOptionsEncoder.encodeSingleGreaterThanFilter(DeviceEventsListOptions.TAG_FILTER_BY_DATE_TIME,
                                                                          Date.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE, FilterOperator.EQUAL));
            assertNotNull(option.getStateChangeFilters());
            assertEquals(Boolean.TRUE,
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE,
                                                                    Boolean.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getStateChangeFilters());
            assertEquals(Boolean.FALSE,
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_STATE_CHANGE,
                                                                       Boolean.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, FilterOperator.EQUAL));
            assertNotNull(option.getIdFilters());
            assertEquals("8b001c6c-ac74-40cd-b029-c59c4bf237c6",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getIdFilters());
            assertEquals("ddbd591a-51b9-4a3a-acdc-cab9908870a9",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID,
                                                                       String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, FilterOperator.IN));
            assertNotNull(option.getIdFilters());
            assertEquals(Arrays.asList("5b3c3e04-cc88-4431-8d62-fe12d7a8f460", "6262f95b-ac65-409c-8d9c-9f9fd153dba6",
                                       "42d4c619-663d-4f55-8475-326b22db5509", "3c224114-0d2f-45da-b2c7-e3c5a2d07dc6"),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, List.class,
                                                                 option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID, FilterOperator.NOT_IN));
            assertNotNull(option.getIdFilters());
            assertEquals(Arrays.asList("def5869d-6661-4dc2-8d45-97f191d644a9", "be34517d-4521-49ed-954a-5449fb6b507f",
                                       "2d305572-f4b0-405f-bdfd-1fa51db87655"),
                         ListOptionsEncoder.encodeSingleNotInFilter(DeviceEventsListOptions.TAG_FILTER_BY_ID,
                                                                    List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE, FilterOperator.EQUAL));
            assertNotNull(option.getEventTypeFilters());
            assertEquals("32502c56-f1df-4cd9-add1-1538ae4b94d2",
                         ListOptionsEncoder.encodeSingleEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE,
                                                                    String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getEventTypeFilters());
            assertEquals("d5b9b648-4777-4ec7-be7e-b71099507a55",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE,
                                                                       String.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE, FilterOperator.IN));
            assertNotNull(option.getEventTypeFilters());
            assertEquals(Arrays.asList("761d5847-79d6-4257-9b4e-9f85ef39292d", "25596128-6003-4666-8a66-c4b2c403ddda",
                                       "e99ef244-6669-4070-9360-66501b7aac31", "3e72eb29-dcbd-437f-ba9e-b1584fb758f1"),
                         ListOptionsEncoder.encodeSingleInFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE,
                                                                 List.class, option));
            assertTrue(option.hasFilters(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE));
            assertTrue(option.hasFilter(DeviceEventsListOptions.TAG_FILTER_BY_EVENT_TYPE, FilterOperator.NOT_IN));
            assertNotNull(option.getEventTypeFilters());
            assertEquals(Arrays.asList("493a8f67-9f30-45e1-998a-01efc2c66c56", "61a18b66-84ac-48e5-9e6f-5ef8dd7261b6",
                                       "8b96e2fd-8090-4788-b930-aee5c9e92f52", "e12ae8f5-2d59-4fbd-bffe-a61e8bea85ce"),
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
            DeviceEventsListOptions deviceeventslistoptions1 = new DeviceEventsListOptions(Integer.valueOf(18),
                                                                                           Long.valueOf(-54),
                                                                                           Order.getDefault(),
                                                                                           "d866014f-2d0f-4787-b991-94291818358f",
                                                                                           null, null);
            DeviceEventsListOptions deviceeventslistoptions2 = new DeviceEventsListOptions(Integer.valueOf(18),
                                                                                           Long.valueOf(-54),
                                                                                           Order.getDefault(),
                                                                                           "d866014f-2d0f-4787-b991-94291818358f",
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
            DeviceEventsListOptions deviceeventslistoptions1 = new DeviceEventsListOptions(Integer.valueOf(0),
                                                                                           Long.valueOf(7),
                                                                                           Order.getDefault(),
                                                                                           "6facc0d2-e889-4812-9202-785c6e7e9319",
                                                                                           null, null);
            DeviceEventsListOptions deviceeventslistoptions2 = new DeviceEventsListOptions(Integer.valueOf(0),
                                                                                           Long.valueOf(7),
                                                                                           Order.getDefault(),
                                                                                           "6facc0d2-e889-4812-9202-785c6e7e9319",
                                                                                           null, null);
            DeviceEventsListOptions deviceeventslistoptions3 = new DeviceEventsListOptions(Integer.valueOf(-42),
                                                                                           Long.valueOf(-14),
                                                                                           Order.getDefault(),
                                                                                           "48f44543-7bd8-4c6f-8bc8-d125a11a8a61",
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
