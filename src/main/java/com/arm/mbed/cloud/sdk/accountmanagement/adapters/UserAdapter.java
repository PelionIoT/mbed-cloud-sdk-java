package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.adapters.GenericListAdapter.Mapper;
import com.arm.mbed.cloud.sdk.accountmanagement.adapters.GenericListAdapter.RespList;
import com.arm.mbed.cloud.sdk.accountmanagement.model.User;
import com.arm.mbed.cloud.sdk.accountmanagement.model.UserStatus;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ListResponse;
import com.arm.mbed.cloud.sdk.internal.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.internal.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.model.UserInfoResp.StatusEnum;
import com.arm.mbed.cloud.sdk.internal.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.internal.model.UserUpdateReq;

@Preamble(description = "Adapter for user model")
public class UserAdapter {
	public static User map(UserInfoResp apiUser) {
		if (apiUser == null) {
			return null;
		}
		User user = new User(apiUser.getId(), apiUser.getAccountId(), apiUser.getGroups(),
				toStatus(apiUser.getStatus()), apiUser.getEmailVerified(),
				TranslationUtils.toDate(apiUser.getCreatedAt()),
				TranslationUtils.toTimeStamp(apiUser.getCreationTime()),
				TranslationUtils.toTimeStamp(apiUser.getPasswordChangedTime()),
				TranslationUtils.toTimeStamp(apiUser.getLastLoginTime()));
		user.setFullName(apiUser.getFullName());
		user.setUsername(apiUser.getUsername());
		user.setPassword(apiUser.getPassword());
		user.setEmail(apiUser.getEmail());
		user.setPhoneNumber(apiUser.getPhoneNumber());
		user.setAddress(apiUser.getAddress());
		user.setTermAccepted(apiUser.getIsGtcAccepted());
		user.setMarketingAccepted(apiUser.getIsMarketingAccepted());
		return user;

	}

	public static UserInfoReq addMap(User user) {
		if (user == null) {
			return null;
		}
		UserInfoReq userInfo = new UserInfoReq();
		userInfo.setFullName(user.getFullName());
		userInfo.setUsername(user.getUsername());
		userInfo.setPassword(user.getPassword());
		userInfo.setEmail(user.getEmail());
		userInfo.setPhoneNumber(user.getEmail());
		userInfo.setIsGtcAccepted(user.areTermsAccepted());
		userInfo.setIsMarketingAccepted(user.isMarketingAccepted());
		return userInfo;
	}

	public static UserUpdateReq updateMap(User user) {
		if (user == null) {
			return null;
		}
		UserUpdateReq userUpdate = new UserUpdateReq();
		userUpdate.setFullName(user.getFullName());
		userUpdate.setUsername(user.getUsername());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setEmail(user.getEmail());
		userUpdate.setPhoneNumber(user.getEmail());
		userUpdate.setIsGtcAccepted(user.areTermsAccepted());
		userUpdate.setIsMarketingAccepted(user.isMarketingAccepted());
		return userUpdate;
	}

	public static ListResponse<User> mapList(UserInfoRespList userList) {
		Mapper<User, UserInfoResp> mapper = new Mapper<User, UserInfoResp>() {

			@Override
			public <T, U> T map(U toBeMapped) {
				return map(toBeMapped);
			}

		};
		RespList<UserInfoResp> respList = new RespList<UserInfoResp>() {

			@Override
			public Boolean getHasMore() {
				return (userList == null) ? null : userList.getHasMore();
			}

			@Override
			public Integer getTotalCount() {
				return (userList == null) ? null : userList.getTotalCount();
			}

			@Override
			public String getAfter() {
				return (userList == null) ? null : userList.getAfter();
			}

			@Override
			public Integer getLimit() {
				return (userList == null) ? null : userList.getLimit();
			}

			@Override
			public String getOrder() {
				return (userList == null) ? null : userList.getOrder().toString();
			}

			@Override
			public List<UserInfoResp> getData() {
				return (userList == null) ? null : userList.getData();
			}
		};
		return GenericListAdapter.mapList(respList, mapper);

	}

	private static UserStatus toStatus(StatusEnum userStatus) {
		UserStatus status = null;
		switch (userStatus) {
		case ACTIVE:
			status = UserStatus.ACTIVE;
			break;
		case ENROLLING:
			status = UserStatus.ENROLLING;
			break;
		case INACTIVE:
			status = UserStatus.INACTIVE;
			break;
		case INVITED:
			status = UserStatus.INVITED;
			break;
		case RESET:
			status = UserStatus.RESET;
			break;
		default:
			status = UserStatus.INACTIVE;
			break;

		}
		return status;
	}
}
