package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.User;
import com.arm.mbed.cloud.sdk.accountmanagement.model.UserStatus;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.ListResponse;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp.StatusEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateReq;

@Preamble(description = "Adapter for user model")
public class UserAdapter {
    public static User map(UserInfoResp apiUser) {
        if (apiUser == null) {
            return null;
        }
        User user = new User(apiUser.getId(), apiUser.getAccountId(), apiUser.getGroups(),
                toStatus(apiUser.getStatus()), TranslationUtils.toBool(apiUser.getEmailVerified(), false),
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
        user.setTermAccepted(TranslationUtils.toBool(apiUser.getIsGtcAccepted(), true));
        user.setMarketingAccepted(TranslationUtils.toBool(apiUser.getIsMarketingAccepted(), true));
        return user;

    }

    public static Mapper<UserInfoResp, User> getMapper() {
        return new Mapper<UserInfoResp, User>() {

            @Override
            public User map(UserInfoResp toBeMapped) {
                return UserAdapter.map(toBeMapped);
            }

        };
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
        userInfo.setPhoneNumber(user.getPhoneNumber());
        userInfo.setIsGtcAccepted(Boolean.valueOf(user.areTermsAccepted()));
        userInfo.setIsMarketingAccepted(Boolean.valueOf(user.isMarketingAccepted()));
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
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userUpdate.setIsGtcAccepted(Boolean.valueOf(user.areTermsAccepted()));
        userUpdate.setIsMarketingAccepted(Boolean.valueOf(user.isMarketingAccepted()));
        return userUpdate;
    }

    public static ListResponse<User> mapList(UserInfoRespList list) {

        final UserInfoRespList userList = list;
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
        return GenericAdapter.mapList(respList, getMapper());
    }

    public static Mapper<UserInfoRespList, ListResponse<User>> getListMapper() {
        return new Mapper<UserInfoRespList, ListResponse<User>>() {

            @Override
            public ListResponse<User> map(UserInfoRespList toBeMapped) {
                return UserAdapter.mapList(toBeMapped);
            }

        };
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
                status = UserStatus.getDefault();
                break;

        }
        return status;
    }
}
