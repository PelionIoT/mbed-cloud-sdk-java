package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.Group;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.ListResponse;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.model.GroupSummaryList;

@Preamble(description = "Adapter for group model")
public class GroupAdapter {

    public static Group map(GroupSummary groupSummary) {
        if (groupSummary == null) {
            return null;
        }
        return new Group(groupSummary.getId(), groupSummary.getAccountId(), groupSummary.getName(),
                TranslationUtils.toInt(groupSummary.getUserCount()),
                TranslationUtils.toInt(groupSummary.getApikeyCount()),
                TranslationUtils.toDate(groupSummary.getCreatedAt()),
                TranslationUtils.toTimeStamp(groupSummary.getCreationTime()),
                TranslationUtils.toTimeStamp(groupSummary.getLastUpdateTime()));
    }

    public static Mapper<GroupSummary, Group> getMapper() {
        return new Mapper<GroupSummary, Group>() {

            @Override
            public Group map(GroupSummary toBeMapped) {
                return GroupAdapter.map(toBeMapped);
            }

        };
    }

    public static ListResponse<Group> mapList(GroupSummaryList list) {
        final GroupSummaryList groupList = list;
        RespList<GroupSummary> respList = new RespList<GroupSummary>() {

            @Override
            public Boolean getHasMore() {
                return (groupList == null) ? null : groupList.getHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (groupList == null) ? null : groupList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (groupList == null) ? null : groupList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (groupList == null) ? null : groupList.getLimit();
            }

            @Override
            public String getOrder() {
                return (groupList == null) ? null : groupList.getOrder().toString();
            }

            @Override
            public List<GroupSummary> getData() {
                return (groupList == null) ? null : groupList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    public static Mapper<GroupSummaryList, ListResponse<Group>> getListMapper() {
        return new Mapper<GroupSummaryList, ListResponse<Group>>() {

            @Override
            public ListResponse<Group> map(GroupSummaryList toBeMapped) {
                return GroupAdapter.mapList(toBeMapped);
            }

        };
    }

}
