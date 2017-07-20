package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.adapters.GenericListAdapter.Mapper;
import com.arm.mbed.cloud.sdk.accountmanagement.adapters.GenericListAdapter.RespList;
import com.arm.mbed.cloud.sdk.accountmanagement.model.Group;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ListResponse;
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

	public static ListResponse<Group> mapList(GroupSummaryList groupList) {
		Mapper<Group, GroupSummary> mapper = new Mapper<Group, GroupSummary>() {

			@SuppressWarnings("unchecked")
			@Override
			public <T, U> T map(U toBeMapped) {
				return (T) GroupAdapter.map((GroupSummary) toBeMapped);
			}

		};
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
		return GenericListAdapter.mapList(respList, mapper);
	}

}
