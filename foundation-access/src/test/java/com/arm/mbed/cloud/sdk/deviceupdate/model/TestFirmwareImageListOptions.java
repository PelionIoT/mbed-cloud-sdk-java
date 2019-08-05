// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/**
 * Unit tests for Model FirmwareImageListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestFirmwareImageListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            FirmwareImageListOptions firmwareimagelistoptions1 = new FirmwareImageListOptions(Integer.valueOf(98),
                                                                                              Long.valueOf(66),
                                                                                              Order.getDefault(),
                                                                                              "b33f1cda-0d40-42f8-9a4e-f0f276705afd",
                                                                                              null, null);
            FirmwareImageListOptions firmwareimagelistoptions2 = firmwareimagelistoptions1.clone();
            assertNotNull(firmwareimagelistoptions1);
            assertNotNull(firmwareimagelistoptions2);
            assertNotSame(firmwareimagelistoptions2, firmwareimagelistoptions1);
            assertEquals(firmwareimagelistoptions2, firmwareimagelistoptions1);
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
            FirmwareImageListOptions option = new FirmwareImageListOptions().inUpdatedAts(Arrays.asList(new Date(1565006434138L),
                                                                                                        new Date(1565006435863L),
                                                                                                        new Date(1565006437884L),
                                                                                                        new Date(1565006442527L)))
                                                                            .notInUpdatedAts(Arrays.asList(new Date(1565006438686L),
                                                                                                           new Date(1565006440200L)))
                                                                            .lessThanUpdatedAt(new Date(1565006436482L))
                                                                            .greaterThanUpdatedAt(new Date(1565006442876L))
                                                                            .equalToName("3ed2289f-daf8-48f9-ac58-a88624614bbb")
                                                                            .notEqualToName("2820ce86-10eb-4c1b-a676-43bba76d1746")
                                                                            .inNames(Arrays.asList("58f2b821-fbca-472d-9fd9-4a89200d3efe"))
                                                                            .notInNames(Arrays.asList("3648fd48-60ad-4ae1-9984-ac346195722e"))
                                                                            .equalToDescription("ead968a3-d410-4fe1-9507-461ccb86a796")
                                                                            .notEqualToDescription("e117a30d-96b2-4e13-805b-a304bd7492f4")
                                                                            .inDescriptions(Arrays.asList("033ec496-a8dc-4581-9749-178ad0d8dd7f",
                                                                                                          "c002d115-caef-46ff-9c58-ecd01448777d",
                                                                                                          "cb9344a8-2fc2-4f37-abd8-cf829ab32ce3",
                                                                                                          "e539bedd-ce14-44fa-97da-832a331f7fb3"))
                                                                            .notInDescriptions(Arrays.asList("42d66df2-e4ee-4694-b769-a2ff7a661401",
                                                                                                             "91914c8f-b472-4e62-9059-07864a37ec11",
                                                                                                             "3ce2f0c5-eafe-4f26-9f73-e22e5c15d8e0",
                                                                                                             "5b9b43d5-96ac-41cf-9de1-cfc6c4c406d0",
                                                                                                             "9d295939-85ce-43dc-8a34-96bab6158bc8",
                                                                                                             "5de8016b-69f9-4b1b-8b7e-4c27be8b88cd"))
                                                                            .inCreatedAts(Arrays.asList(new Date(1565006435240L)))
                                                                            .notInCreatedAts(Arrays.asList(new Date(1565006443285L),
                                                                                                           new Date(1565006438065L),
                                                                                                           new Date(1565006436381L),
                                                                                                           new Date(1565006438809L),
                                                                                                           new Date(1565006436378L),
                                                                                                           new Date(1565006433929L)))
                                                                            .lessThanCreatedAt(new Date(1565006443561L))
                                                                            .greaterThanCreatedAt(new Date(1565006437837L))
                                                                            .equalToDatafileUrl("03499d04-1ea7-428d-816f-8a02919ef818")
                                                                            .notEqualToDatafileUrl("5b018183-6f38-459a-97d0-9fa9c55f3296")
                                                                            .inDatafileUrls(Arrays.asList("74540784-094a-413d-9b8d-f0ff319d4b43",
                                                                                                          "daaa70a0-1348-4b00-859e-bae418bf4de2",
                                                                                                          "93725e9c-8e69-4cf2-a1d1-f8440c6f5e04"))
                                                                            .notInDatafileUrls(Arrays.asList("5aa2d1af-aae1-4e4d-8618-7ae929844afc",
                                                                                                             "67f149ce-56a1-4b27-8fad-9740f6111fe6",
                                                                                                             "fd198547-3082-4756-9929-834f2277d83d",
                                                                                                             "9524ba67-552a-4323-8a9f-c7b66245ff6e",
                                                                                                             "5b0bdc3d-a63a-45de-864e-a7b97dbdc0fc"))
                                                                            .equalToDatafileSize(Long.valueOf(121))
                                                                            .notEqualToDatafileSize(Long.valueOf(-77))
                                                                            .inDatafileSizes(Arrays.asList(Long.valueOf(-38),
                                                                                                           Long.valueOf(44),
                                                                                                           Long.valueOf(-68),
                                                                                                           Long.valueOf(38),
                                                                                                           Long.valueOf(-69)))
                                                                            .notInDatafileSizes(Arrays.asList(Long.valueOf(58),
                                                                                                              Long.valueOf(29),
                                                                                                              Long.valueOf(119)))
                                                                            .equalToDatafileChecksum("9b46fee4-83c1-43c3-ad21-b8ddd16c018a")
                                                                            .notEqualToDatafileChecksum("2b9dd208-1c9d-46ec-8fbc-d37aa6408a98")
                                                                            .inDatafileChecksums(Arrays.asList("e1b45ec7-b75a-4423-959d-7c60f3568716"))
                                                                            .notInDatafileChecksums(Arrays.asList("1634362d-df4f-4eae-800f-9a8e98438433",
                                                                                                                  "750eee5f-6c21-4116-b2f5-59a29e8f5459",
                                                                                                                  "1d2f9d8a-0a7f-4d71-abf3-95fccbe7b7c3"))
                                                                            .equalToId("d645489d-d738-4026-bce4-f9b0c778b072")
                                                                            .notEqualToId("a4654949-ea0f-4bf1-a1b1-42739ec39428")
                                                                            .inIds(Arrays.asList("07e47111-68e8-4d3f-9d81-1a29b3e09f08"))
                                                                            .notInIds(Arrays.asList("618704c1-ed75-441c-b9f9-61a2333cf756",
                                                                                                    "8e80f7d8-ace6-449f-8cdd-5a6a0ef50335"));
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT, FilterOperator.IN));
            assertNotNull(option.getUpdatedAtFilters());
            assertEquals(Arrays.asList(new Date(1565006434138L), new Date(1565006435863L), new Date(1565006437884L),
                                       new Date(1565006442527L)),
                         ListOptionsEncoder.encodeSingleInFilter(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT,
                                                                 List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT, FilterOperator.NOT_IN));
            assertNotNull(option.getUpdatedAtFilters());
            assertEquals(Arrays.asList(new Date(1565006438686L), new Date(1565006440200L)),
                         ListOptionsEncoder.encodeSingleNotInFilter(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT,
                                                                    List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT, FilterOperator.LESS_THAN));
            assertNotNull(option.getUpdatedAtFilters());
            assertEquals(new Date(1565006436482L),
                         ListOptionsEncoder.encodeSingleLessThanFilter(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT,
                                                                       Date.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT,
                                        FilterOperator.GREATER_THAN));
            assertNotNull(option.getUpdatedAtFilters());
            assertEquals(new Date(1565006442876L),
                         ListOptionsEncoder.encodeSingleGreaterThanFilter(FirmwareImageListOptions.TAG_FILTER_BY_UPDATED_AT,
                                                                          Date.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_NAME));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_NAME, FilterOperator.EQUAL));
            assertNotNull(option.getNameFilters());
            assertEquals("3ed2289f-daf8-48f9-ac58-a88624614bbb",
                         ListOptionsEncoder.encodeSingleEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_NAME,
                                                                    String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_NAME));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_NAME, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getNameFilters());
            assertEquals("2820ce86-10eb-4c1b-a676-43bba76d1746",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_NAME,
                                                                       String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_NAME));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_NAME, FilterOperator.IN));
            assertNotNull(option.getNameFilters());
            assertEquals(Arrays.asList("58f2b821-fbca-472d-9fd9-4a89200d3efe"),
                         ListOptionsEncoder.encodeSingleInFilter(FirmwareImageListOptions.TAG_FILTER_BY_NAME,
                                                                 List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_NAME));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_NAME, FilterOperator.NOT_IN));
            assertNotNull(option.getNameFilters());
            assertEquals(Arrays.asList("3648fd48-60ad-4ae1-9984-ac346195722e"),
                         ListOptionsEncoder.encodeSingleNotInFilter(FirmwareImageListOptions.TAG_FILTER_BY_NAME,
                                                                    List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.EQUAL));
            assertNotNull(option.getDescriptionFilters());
            assertEquals("ead968a3-d410-4fe1-9507-461ccb86a796",
                         ListOptionsEncoder.encodeSingleEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                    String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDescriptionFilters());
            assertEquals("e117a30d-96b2-4e13-805b-a304bd7492f4",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                       String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.IN));
            assertNotNull(option.getDescriptionFilters());
            assertEquals(Arrays.asList("033ec496-a8dc-4581-9749-178ad0d8dd7f", "c002d115-caef-46ff-9c58-ecd01448777d",
                                       "cb9344a8-2fc2-4f37-abd8-cf829ab32ce3", "e539bedd-ce14-44fa-97da-832a331f7fb3"),
                         ListOptionsEncoder.encodeSingleInFilter(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                 List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION, FilterOperator.NOT_IN));
            assertNotNull(option.getDescriptionFilters());
            assertEquals(Arrays.asList("42d66df2-e4ee-4694-b769-a2ff7a661401", "91914c8f-b472-4e62-9059-07864a37ec11",
                                       "3ce2f0c5-eafe-4f26-9f73-e22e5c15d8e0", "5b9b43d5-96ac-41cf-9de1-cfc6c4c406d0",
                                       "9d295939-85ce-43dc-8a34-96bab6158bc8", "5de8016b-69f9-4b1b-8b7e-4c27be8b88cd"),
                         ListOptionsEncoder.encodeSingleNotInFilter(FirmwareImageListOptions.TAG_FILTER_BY_DESCRIPTION,
                                                                    List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT, FilterOperator.IN));
            assertNotNull(option.getCreatedAtFilters());
            assertEquals(Arrays.asList(new Date(1565006435240L)),
                         ListOptionsEncoder.encodeSingleInFilter(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT,
                                                                 List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT, FilterOperator.NOT_IN));
            assertNotNull(option.getCreatedAtFilters());
            assertEquals(Arrays.asList(new Date(1565006443285L), new Date(1565006438065L), new Date(1565006436381L),
                                       new Date(1565006438809L), new Date(1565006436378L), new Date(1565006433929L)),
                         ListOptionsEncoder.encodeSingleNotInFilter(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT,
                                                                    List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT, FilterOperator.LESS_THAN));
            assertNotNull(option.getCreatedAtFilters());
            assertEquals(new Date(1565006443561L),
                         ListOptionsEncoder.encodeSingleLessThanFilter(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT,
                                                                       Date.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT,
                                        FilterOperator.GREATER_THAN));
            assertNotNull(option.getCreatedAtFilters());
            assertEquals(new Date(1565006437837L),
                         ListOptionsEncoder.encodeSingleGreaterThanFilter(FirmwareImageListOptions.TAG_FILTER_BY_CREATED_AT,
                                                                          Date.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL, FilterOperator.EQUAL));
            assertNotNull(option.getDatafileUrlFilters());
            assertEquals("03499d04-1ea7-428d-816f-8a02919ef818",
                         ListOptionsEncoder.encodeSingleEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL,
                                                                    String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDatafileUrlFilters());
            assertEquals("5b018183-6f38-459a-97d0-9fa9c55f3296",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL,
                                                                       String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL, FilterOperator.IN));
            assertNotNull(option.getDatafileUrlFilters());
            assertEquals(Arrays.asList("74540784-094a-413d-9b8d-f0ff319d4b43", "daaa70a0-1348-4b00-859e-bae418bf4de2",
                                       "93725e9c-8e69-4cf2-a1d1-f8440c6f5e04"),
                         ListOptionsEncoder.encodeSingleInFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL,
                                                                 List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL, FilterOperator.NOT_IN));
            assertNotNull(option.getDatafileUrlFilters());
            assertEquals(Arrays.asList("5aa2d1af-aae1-4e4d-8618-7ae929844afc", "67f149ce-56a1-4b27-8fad-9740f6111fe6",
                                       "fd198547-3082-4756-9929-834f2277d83d", "9524ba67-552a-4323-8a9f-c7b66245ff6e",
                                       "5b0bdc3d-a63a-45de-864e-a7b97dbdc0fc"),
                         ListOptionsEncoder.encodeSingleNotInFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_URL,
                                                                    List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE, FilterOperator.EQUAL));
            assertNotNull(option.getDatafileSizeFilters());
            assertEquals(Long.valueOf(121),
                         ListOptionsEncoder.encodeSingleEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE,
                                                                    Long.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE,
                                        FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDatafileSizeFilters());
            assertEquals(Long.valueOf(-77),
                         ListOptionsEncoder.encodeSingleNotEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE,
                                                                       Long.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE, FilterOperator.IN));
            assertNotNull(option.getDatafileSizeFilters());
            assertEquals(Arrays.asList(Long.valueOf(-38), Long.valueOf(44), Long.valueOf(-68), Long.valueOf(38),
                                       Long.valueOf(-69)),
                         ListOptionsEncoder.encodeSingleInFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE,
                                                                 List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE, FilterOperator.NOT_IN));
            assertNotNull(option.getDatafileSizeFilters());
            assertEquals(Arrays.asList(Long.valueOf(58), Long.valueOf(29), Long.valueOf(119)),
                         ListOptionsEncoder.encodeSingleNotInFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_SIZE,
                                                                    List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM,
                                        FilterOperator.EQUAL));
            assertNotNull(option.getDatafileChecksumFilters());
            assertEquals("9b46fee4-83c1-43c3-ad21-b8ddd16c018a",
                         ListOptionsEncoder.encodeSingleEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM,
                                                                    String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM,
                                        FilterOperator.NOT_EQUAL));
            assertNotNull(option.getDatafileChecksumFilters());
            assertEquals("2b9dd208-1c9d-46ec-8fbc-d37aa6408a98",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM,
                                                                       String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM, FilterOperator.IN));
            assertNotNull(option.getDatafileChecksumFilters());
            assertEquals(Arrays.asList("e1b45ec7-b75a-4423-959d-7c60f3568716"),
                         ListOptionsEncoder.encodeSingleInFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM,
                                                                 List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM,
                                        FilterOperator.NOT_IN));
            assertNotNull(option.getDatafileChecksumFilters());
            assertEquals(Arrays.asList("1634362d-df4f-4eae-800f-9a8e98438433", "750eee5f-6c21-4116-b2f5-59a29e8f5459",
                                       "1d2f9d8a-0a7f-4d71-abf3-95fccbe7b7c3"),
                         ListOptionsEncoder.encodeSingleNotInFilter(FirmwareImageListOptions.TAG_FILTER_BY_DATAFILE_CHECKSUM,
                                                                    List.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_ID, FilterOperator.EQUAL));
            assertNotNull(option.getIdFilters());
            assertEquals("d645489d-d738-4026-bce4-f9b0c778b072",
                         ListOptionsEncoder.encodeSingleEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_ID,
                                                                    String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_ID, FilterOperator.NOT_EQUAL));
            assertNotNull(option.getIdFilters());
            assertEquals("a4654949-ea0f-4bf1-a1b1-42739ec39428",
                         ListOptionsEncoder.encodeSingleNotEqualFilter(FirmwareImageListOptions.TAG_FILTER_BY_ID,
                                                                       String.class, option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_ID, FilterOperator.IN));
            assertNotNull(option.getIdFilters());
            assertEquals(Arrays.asList("07e47111-68e8-4d3f-9d81-1a29b3e09f08"),
                         ListOptionsEncoder.encodeSingleInFilter(FirmwareImageListOptions.TAG_FILTER_BY_ID, List.class,
                                                                 option));
            assertTrue(option.hasFilters(FirmwareImageListOptions.TAG_FILTER_BY_ID));
            assertTrue(option.hasFilter(FirmwareImageListOptions.TAG_FILTER_BY_ID, FilterOperator.NOT_IN));
            assertNotNull(option.getIdFilters());
            assertEquals(Arrays.asList("618704c1-ed75-441c-b9f9-61a2333cf756", "8e80f7d8-ace6-449f-8cdd-5a6a0ef50335"),
                         ListOptionsEncoder.encodeSingleNotInFilter(FirmwareImageListOptions.TAG_FILTER_BY_ID,
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
            FirmwareImageListOptions firmwareimagelistoptions1 = new FirmwareImageListOptions(Integer.valueOf(116),
                                                                                              Long.valueOf(33),
                                                                                              Order.getDefault(),
                                                                                              "1ac1162b-d60f-428c-ac96-c42c3dc3e13f",
                                                                                              null, null);
            FirmwareImageListOptions firmwareimagelistoptions2 = new FirmwareImageListOptions(Integer.valueOf(116),
                                                                                              Long.valueOf(33),
                                                                                              Order.getDefault(),
                                                                                              "1ac1162b-d60f-428c-ac96-c42c3dc3e13f",
                                                                                              null, null);
            assertNotNull(firmwareimagelistoptions1);
            assertNotNull(firmwareimagelistoptions2);
            assertNotSame(firmwareimagelistoptions2, firmwareimagelistoptions1);
            assertEquals(firmwareimagelistoptions2, firmwareimagelistoptions1);
            assertEquals(firmwareimagelistoptions2.hashCode(), firmwareimagelistoptions1.hashCode());
            int hashCode = firmwareimagelistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, firmwareimagelistoptions1.hashCode());
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
            FirmwareImageListOptions firmwareimagelistoptions1 = new FirmwareImageListOptions(Integer.valueOf(-64),
                                                                                              Long.valueOf(-125),
                                                                                              Order.getDefault(),
                                                                                              "512d1c12-9c06-4d52-a9dc-67ace2a18ed8",
                                                                                              null, null);
            FirmwareImageListOptions firmwareimagelistoptions2 = new FirmwareImageListOptions(Integer.valueOf(-64),
                                                                                              Long.valueOf(-125),
                                                                                              Order.getDefault(),
                                                                                              "512d1c12-9c06-4d52-a9dc-67ace2a18ed8",
                                                                                              null, null);
            FirmwareImageListOptions firmwareimagelistoptions3 = new FirmwareImageListOptions(Integer.valueOf(115),
                                                                                              Long.valueOf(74),
                                                                                              Order.getDefault(),
                                                                                              "c6bccc26-efea-46fc-b0a7-790eebf2db65",
                                                                                              null, null);
            assertNotNull(firmwareimagelistoptions1);
            assertNotNull(firmwareimagelistoptions2);
            assertNotNull(firmwareimagelistoptions3);
            assertNotSame(firmwareimagelistoptions2, firmwareimagelistoptions1);
            assertNotSame(firmwareimagelistoptions3, firmwareimagelistoptions1);
            assertEquals(firmwareimagelistoptions2, firmwareimagelistoptions1);
            assertEquals(firmwareimagelistoptions2, firmwareimagelistoptions1);
            assertEquals(firmwareimagelistoptions1, firmwareimagelistoptions2);
            assertEquals(firmwareimagelistoptions1, firmwareimagelistoptions1);
            assertFalse(firmwareimagelistoptions1.equals(null));
            assertNotEquals(firmwareimagelistoptions3, firmwareimagelistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
