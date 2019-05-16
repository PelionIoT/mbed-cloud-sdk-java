package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.listing.IdListResponse;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

public class TestGenericAdapter {

    @Test
    public void testMapListListOfUMapperOfUT() {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add(" 2 ");
        list.add(" 3");
        list.add("4 ");
        list.add("5");
        List<Integer> mappedList = GenericAdapter.mapList(list, new Mapper<String, Integer>() {

            @SuppressWarnings("boxing")
            @Override
            public Integer map(String toBeMapped) {
                return TranslationUtils.toInt(toBeMapped, 0);
            }
        });
        for (int i = 0; i < 5; i++) {
            assertEquals(new Integer(i + 1), mappedList.get(i));
        }
    }

    @Test
    public void testIdentity() {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add(" 2 ");
        list.add(" 3");
        list.add("4 ");
        list.add("5");
        List<String> mappedList = GenericAdapter.mapList(list, GenericAdapter.identityMapper(String.class));
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), mappedList.get(i));
        }
    }

    @Test
    public void testMapListToRegistry() {
        List<String> data = new LinkedList<>();
        data.add("1");
        data.add(" 2 ");
        data.add(" 3");
        data.add("4 ");
        data.add("5");

        GenericAdapter.MappedObjectRegistry<IntegerModel> registry = new GenericAdapter.MappedObjectRegistry<>(data,
                                                                                                               new Mapper<String,
                                                                                                                          IntegerModel>() {

                                                                                                                   @Override
                                                                                                                   public IntegerModel
                                                                                                                          map(String toBeMapped) {
                                                                                                                       return new IntegerModel(TranslationUtils.toInt(toBeMapped,
                                                                                                                                                                      0));
                                                                                                                   }
                                                                                                               });
        for (int i = 0; i < data.size(); i++) {
            final IntegerModel expectedModel = new IntegerModel(i + 1);
            assertTrue(registry.contains(expectedModel));
            assertTrue(registry.contains(expectedModel.getId()));
        }

    }

    @Test
    public void testMapListRespListOfUMapperOfUT() {
        final List<String> data = new LinkedList<>();
        data.add("1");
        data.add(" 2 ");
        data.add(" 3");
        data.add("4 ");
        data.add("5");
        RespList<String> list = new RespList<String>() {

            @SuppressWarnings("boxing")
            @Override
            public Boolean getHasMore() {
                return false;
            }

            @SuppressWarnings("boxing")
            @Override
            public Integer getTotalCount() {
                return 1;
            }

            @Override
            public String getAfter() {
                return null;
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }

            @SuppressWarnings("boxing")
            @Override
            public Integer getLimit() {
                return 5;
            }

            @Override
            public String getOrder() {
                return null;
            }

            @Override
            public List<String> getData() {
                return data;
            }
        };
        ListResponse<IntegerModel> listResp = GenericAdapter.mapList(list, new Mapper<String, IntegerModel>() {

            @Override
            public IntegerModel map(String toBeMapped) {
                return new IntegerModel(TranslationUtils.toInt(toBeMapped, 0));
            }
        });
        List<IntegerModel> mappedList = listResp.getData();
        for (int i = 0; i < 5; i++) {
            assertEquals(new IntegerModel(i + 1), mappedList.get(i));
        }
        assertEquals(list.getLimit(), list.getLimit());
    }

    @Test
    public void testMapListIdRespListOfUMapperOfUT() {
        final List<String> data = new LinkedList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        RespList<String> list = new RespList<String>() {

            @SuppressWarnings("boxing")
            @Override
            public Boolean getHasMore() {
                return false;
            }

            @SuppressWarnings("boxing")
            @Override
            public Integer getTotalCount() {
                return 1;
            }

            @Override
            public String getAfter() {
                return null;
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }

            @SuppressWarnings("boxing")
            @Override
            public Integer getLimit() {
                return 5;
            }

            @Override
            public String getOrder() {
                return null;
            }

            @Override
            public List<String> getData() {
                return data;
            }
        };
        IdListResponse listResp = GenericAdapter.mapIdList(list, GenericAdapter.identityMapper(String.class));
        List<String> mappedList = listResp.getData();
        for (int i = 0; i < 5; i++) {
            assertEquals(String.valueOf(i + 1), mappedList.get(i));
        }
        assertEquals(list.getLimit(), list.getLimit());
    }

    private static class IntegerModel implements SdkModel {
        /**
         *
         */
        private static final long serialVersionUID = 5594572725706194677L;
        private final Integer value;

        public IntegerModel(Integer value) {
            super();
            this.value = value;
        }

        public IntegerModel(int value) {
            this(new Integer(value));
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public String getId() {
            return String.valueOf(hashCode());
        }

        @Override
        public IntegerModel clone() {
            return new IntegerModel(value);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((value == null) ? 0 : value.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            IntegerModel other = (IntegerModel) obj;
            if (value == null) {
                if (other.value != null) {
                    return false;
                }
            } else if (!value.equals(other.value)) {
                return false;
            }
            return true;
        }

        @Override
        public void setId(String id) {
            // Nothing to do.

        }

    }
}
