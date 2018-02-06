package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.Group;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;

@Preamble(description = "Adapter for group model")
@Internal
public final class GroupAdapter {

    private GroupAdapter() {
        super();
    }

    /**
     * Maps group objects.
     * 
     * @param groupSummary
     *            a group summary.
     * @return equivalent group.
     */
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

    /**
     * Gets group mapper.
     * 
     * @return groupd mapper.
     */
    public static Mapper<GroupSummary, Group> getMapper() {
        return new Mapper<GroupSummary, Group>() {

            @Override
            public Group map(GroupSummary toBeMapped) {
                return GroupAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Maps a list of groups.
     * 
     * @param list
     *            list to map.
     * @return a list of groups.
     */
    public static ListResponse<Group> mapList(GroupSummaryList list) {
        final GroupSummaryList groupList = list;
        final RespList<GroupSummary> respList = new RespList<GroupSummary>() {

            @Override
            public Boolean getHasMore() {
                return (groupList == null) ? null : groupList.isHasMore();
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

    /**
     * Gets list mapper.
     * 
     * @return the list mapper.
     */
    public static Mapper<GroupSummaryList, ListResponse<Group>> getListMapper() {
        return new Mapper<GroupSummaryList, ListResponse<Group>>() {

            @Override
            public ListResponse<Group> map(GroupSummaryList toBeMapped) {
                return GroupAdapter.mapList(toBeMapped);
            }

        };
    }

}
