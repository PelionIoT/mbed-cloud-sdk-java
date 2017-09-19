package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
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
                return TranslationUtils.convertToInteger(toBeMapped, 0);
            }
        });
        for (int i = 0; i < 5; i++) {
            assertEquals(new Integer(i + 1), mappedList.get(i));
        }
    }

    @Test
    public void testMapListRespListOfUMapperOfUT() {
        List<String> data = new LinkedList<>();
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
        ListResponse<Integer> listResp = GenericAdapter.mapList(list, new Mapper<String, Integer>() {

            @SuppressWarnings("boxing")
            @Override
            public Integer map(String toBeMapped) {
                return TranslationUtils.convertToInteger(toBeMapped, 0);
            }
        });
        List<Integer> mappedList = listResp.getData();
        for (int i = 0; i < 5; i++) {
            assertEquals(new Integer(i + 1), mappedList.get(i));
        }
        assertEquals(list.getLimit(), list.getLimit());
    }
}
