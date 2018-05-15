package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.CustomProperties;
import com.arm.mbed.cloud.sdk.accountmanagement.model.User;
import com.arm.mbed.cloud.sdk.accountmanagement.model.UserStatus;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp.StatusEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateReq;

@Preamble(description = "Adapter for user model")
@Internal
public final class UserAdapter {

    private UserAdapter() {
        super();
    }

    /**
     * Maps user.
     *
     * @param apiUser
     *            user to map.
     * @return mapped user.
     */
    public static User map(UserInfoResp apiUser) {
        if (apiUser == null) {
            return null;
        }
        final User user = new User(apiUser.getId(), apiUser.getAccountId(), apiUser.getGroups(),
                toStatus(apiUser.getStatus()), TranslationUtils.toBool(apiUser.isEmailVerified(), false),
                TranslationUtils.toDate(apiUser.getCreatedAt()),
                TranslationUtils.toTimeStamp(apiUser.getCreationTime()),
                TranslationUtils.toTimeStamp(apiUser.getPasswordChangedTime()),
                TranslationUtils.toTimeStamp(apiUser.getLastLoginTime()),
                TranslationUtils.toBool(apiUser.isIsTotpEnabled(), false),
                LoginHistoryAdapter.mapList(apiUser.getLoginHistory()));
        user.setFullName(apiUser.getFullName());
        user.setUsername(apiUser.getUsername());
        user.setPassword(apiUser.getPassword());
        user.setEmail(apiUser.getEmail());
        user.setPhoneNumber(apiUser.getPhoneNumber());
        user.setAddress(apiUser.getAddress());
        user.setTermsAccepted(TranslationUtils.toBool(apiUser.isIsGtcAccepted(), true));
        user.setMarketingAccepted(TranslationUtils.toBool(apiUser.isIsMarketingAccepted(), true));
        user.setCustomFields(new CustomProperties(apiUser.getCustomFields()));
        return user;

    }

    /**
     * Gets user mapper.
     *
     * @return user mapper.
     */
    public static Mapper<UserInfoResp, User> getMapper() {
        return new Mapper<UserInfoResp, User>() {

            @Override
            public User map(UserInfoResp toBeMapped) {
                return UserAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Reverses user mapping for a new user.
     *
     * @param user
     *            to map.
     * @return new user request.
     */
    public static UserInfoReq reverseMapAdd(User user) {
        if (user == null) {
            return null;
        }
        final UserInfoReq userInfo = new UserInfoReq();
        userInfo.setFullName(user.getFullName());
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword(user.getPassword());
        userInfo.setEmail(user.getEmail());
        userInfo.setPhoneNumber(user.getPhoneNumber());
        userInfo.setAddress(user.getAddress());
        userInfo.setIsGtcAccepted(Boolean.valueOf(user.areTermsAccepted()));
        userInfo.setIsMarketingAccepted(Boolean.valueOf(user.isMarketingAccepted()));
        userInfo.setGroups(user.getGroups());
        userInfo.setCustomFields(user.hasCustomFields() ? user.getCustomFields().getRawProperties() : null);
        return userInfo;
    }

    /**
     * Reverses user mapping for a user to update.
     *
     * @param user
     *            to update.
     * @return related update request.
     */
    public static UserUpdateReq reverseMapUpdate(User user) {
        if (user == null) {
            return null;
        }
        final UserUpdateReq userUpdate = new UserUpdateReq();
        userUpdate.setFullName(user.getFullName());
        userUpdate.setUsername(user.getUsername());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userUpdate.setAddress(user.getAddress());
        userUpdate.setIsGtcAccepted(Boolean.valueOf(user.areTermsAccepted()));
        userUpdate.setIsMarketingAccepted(Boolean.valueOf(user.isMarketingAccepted()));
        userUpdate.setGroups(user.getGroups());
        userUpdate.setCustomFields(user.hasCustomFields() ? user.getCustomFields().getRawProperties() : null);
        return userUpdate;
    }

    /**
     * Maps list of users.
     *
     * @param list
     *            of users to map.
     * @return list of users.
     */
    public static ListResponse<User> mapList(UserInfoRespList list) {

        final UserInfoRespList userList = list;
        final RespList<UserInfoResp> respList = new RespList<UserInfoResp>() {

            @Override
            public Boolean getHasMore() {
                return (userList == null) ? null : userList.isHasMore();
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

    /**
     * Gets list mapper.
     *
     * @return list mapper.
     */
    public static Mapper<UserInfoRespList, ListResponse<User>> getListMapper() {
        return new Mapper<UserInfoRespList, ListResponse<User>>() {

            @Override
            public ListResponse<User> map(UserInfoRespList toBeMapped) {
                return UserAdapter.mapList(toBeMapped);
            }

        };
    }

    private static UserStatus toStatus(StatusEnum userStatus) {
        if (userStatus == null) {
            return UserStatus.getUnknownEnum();
        }
        switch (userStatus) {
            case ACTIVE:
                return UserStatus.ACTIVE;
            case ENROLLING:
                return UserStatus.ENROLLING;
            case INACTIVE:
                return UserStatus.INACTIVE;
            case INVITED:
                return UserStatus.INVITED;
            case RESET:
                return UserStatus.RESET;
            default:
                return UserStatus.getUnknownEnum();

        }
    }
}
