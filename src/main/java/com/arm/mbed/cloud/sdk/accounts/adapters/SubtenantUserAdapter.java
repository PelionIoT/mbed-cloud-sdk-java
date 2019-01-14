// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.adapters;

import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUser;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserStatus;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;
import java.util.List;

/**
 * Adapter for subtenant users.
 */
@Preamble(description = "Adapter for subtenant users.")
@Internal
@SuppressWarnings("checkstyle:LineLength")
public final class SubtenantUserAdapter {
    /**
     * Constructor.
     */
    private SubtenantUserAdapter() {
        super();
        // Nothing to do;
    }

    /**
     * Maps a user info resp into a subtenant user.
     * 
     * @param toBeMapped
     *            a user info resp.
     * @return mapped a subtenant user
     */
    @Internal
    public static SubtenantUser map(UserInfoResp toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final SubtenantUser subtenantUser = new SubtenantUser(TranslationUtils.toDate(toBeMapped.getCreatedAt()),
                                                              TranslationUtils.toLong(toBeMapped.getCreationTime()),
                                                              TranslationUtils.toBool(toBeMapped.isEmailVerified()),
                                                              TranslationUtils.toLong(toBeMapped.getLastLoginTime()),
                                                              LoginHistoryAdapter.mapSimpleList(toBeMapped.getLoginHistory()),
                                                              TranslationUtils.toLong(toBeMapped.getPasswordChangedTime()),
                                                              TranslationUtils.toDate(toBeMapped.getUpdatedAt()));
        subtenantUser.setAccountId(toBeMapped.getAccountId());
        subtenantUser.setAddress(toBeMapped.getAddress());
        subtenantUser.setEmail(toBeMapped.getEmail());
        subtenantUser.setFullName(toBeMapped.getFullName());
        subtenantUser.setId(toBeMapped.getId());
        subtenantUser.setLoginProfiles(LoginProfileAdapter.mapSimpleList(toBeMapped.getLoginProfiles()));
        subtenantUser.setMarketingAccepted(TranslationUtils.toBool(toBeMapped.isIsMarketingAccepted()));
        subtenantUser.setPassword(toBeMapped.getPassword());
        subtenantUser.setPhoneNumber(toBeMapped.getPhoneNumber());
        subtenantUser.setStatus(translateToSubtenantUserStatus(toBeMapped.getStatus()));
        subtenantUser.setTermsAccepted(TranslationUtils.toBool(toBeMapped.isIsGtcAccepted()));
        subtenantUser.setTwoFactorAuthentication(TranslationUtils.toBool(toBeMapped.isIsTotpEnabled()));
        subtenantUser.setUsername(toBeMapped.getUsername());
        return subtenantUser;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<UserInfoResp, SubtenantUser> getMapper() {
        return new GenericAdapter.Mapper<UserInfoResp, SubtenantUser>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public SubtenantUser map(UserInfoResp toBeMapped) {
                return SubtenantUserAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a subtenant user into a user info req.
     * 
     * @param toBeMapped
     *            a subtenant user.
     * @return mapped a user info req
     */
    @Internal
    public static UserInfoReq reverseMapAddRequest(SubtenantUser toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final UserInfoReq userInfoReq = new UserInfoReq();
        userInfoReq.setAddress(toBeMapped.getAddress());
        userInfoReq.setEmail(toBeMapped.getEmail());
        userInfoReq.setFullName(toBeMapped.getFullName());
        // No field equivalent to groups in UserInfoReq was found in SubtenantUser
        userInfoReq.setIsGtcAccepted(toBeMapped.isTermsAccepted());
        userInfoReq.setIsMarketingAccepted(toBeMapped.isMarketingAccepted());
        userInfoReq.setLoginProfiles(LoginProfileAdapter.reverseMapAddSimpleList(toBeMapped.getLoginProfiles()));
        userInfoReq.setPassword(toBeMapped.getPassword());
        userInfoReq.setPhoneNumber(toBeMapped.getPhoneNumber());
        userInfoReq.setUsername(toBeMapped.getUsername());
        return userInfoReq;
    }

    /**
     * Maps a subtenant user into a user update req.
     * 
     * @param toBeMapped
     *            a subtenant user.
     * @return mapped a user update req
     */
    @Internal
    public static UserUpdateReq reverseMapUpdateRequest(SubtenantUser toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final UserUpdateReq userUpdateReq = new UserUpdateReq();
        userUpdateReq.setAddress(toBeMapped.getAddress());
        userUpdateReq.setEmail(toBeMapped.getEmail());
        userUpdateReq.setFullName(toBeMapped.getFullName());
        // No field equivalent to groups in UserUpdateReq was found in SubtenantUser
        userUpdateReq.setIsGtcAccepted(toBeMapped.isTermsAccepted());
        userUpdateReq.setIsMarketingAccepted(toBeMapped.isMarketingAccepted());
        userUpdateReq.setIsTotpEnabled(toBeMapped.isTwoFactorAuthentication());
        userUpdateReq.setLoginProfiles(LoginProfileAdapter.reverseMapUpdateSimpleList(toBeMapped.getLoginProfiles()));
        userUpdateReq.setPhoneNumber(toBeMapped.getPhoneNumber());
        userUpdateReq.setStatus(translateToComArmMbedCloudSdkLowlevelPelionclouddevicemanagementModelUserupdatereqStatusenum(toBeMapped.getStatus()));
        userUpdateReq.setUsername(toBeMapped.getUsername());
        return userUpdateReq;
    }

    /**
     * Maps the enum value.
     * 
     * @param toBeMapped
     *            a status enum.
     * @return mapped enum value
     */
    @Internal
    protected static SubtenantUserStatus translateToSubtenantUserStatus(UserInfoResp.StatusEnum toBeMapped) {
        if (toBeMapped == null) {
            return SubtenantUserStatus.getUnknownEnum();
        }
        switch (toBeMapped) {
            case ENROLLING:
                return SubtenantUserStatus.ENROLLING;
            case INVITED:
                return SubtenantUserStatus.INVITED;
            case ACTIVE:
                return SubtenantUserStatus.ACTIVE;
            case RESET:
                return SubtenantUserStatus.RESET;
            case INACTIVE:
                return SubtenantUserStatus.INACTIVE;
            default:
                return SubtenantUserStatus.getUnknownEnum();
        }
    }

    /**
     * Maps a user info resp list into a subtenant user.
     * 
     * @param toBeMapped
     *            a user info resp list.
     * @return mapped list response
     */
    @Internal
    public static ListResponse<SubtenantUser> mapList(UserInfoRespList toBeMapped) {
        final UserInfoRespList finalList = toBeMapped;
        final GenericAdapter.RespList<UserInfoResp> respList = new GenericAdapter.RespList<UserInfoResp>() {
            /**
             * Executes getData.
             * 
             * @return something
             */
            @Override
            public List<UserInfoResp> getData() {
                return (finalList == null) ? null : finalList.getData();
            }

            /**
             * Executes getContinuationMarker.
             * 
             * @return something
             */
            @Override
            public String getContinuationMarker() {
                return null;
            }

            /**
             * Executes getHasMore.
             * 
             * @return something
             */
            @Override
            public Boolean getHasMore() {
                return (finalList == null) ? null : finalList.isHasMore();
            }

            /**
             * Executes getLimit.
             * 
             * @return something
             */
            @Override
            public Integer getLimit() {
                return (finalList == null) ? null : finalList.getLimit();
            }

            /**
             * Executes getOrder.
             * 
             * @return something
             */
            @Override
            public String getOrder() {
                return (finalList == null) ? null : finalList.getOrder().toString();
            }

            /**
             * Executes getAfter.
             * 
             * @return something
             */
            @Override
            public String getAfter() {
                return (finalList == null) ? null : finalList.getAfter();
            }

            /**
             * Executes getTotalCount.
             * 
             * @return something
             */
            @Override
            public Integer getTotalCount() {
                return (finalList == null) ? null : finalList.getTotalCount();
            }
        };
        return GenericAdapter.mapList(respList, SubtenantUserAdapter.getMapper());
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<UserInfoRespList, ListResponse<SubtenantUser>> getListMapper() {
        return new GenericAdapter.Mapper<UserInfoRespList, ListResponse<SubtenantUser>>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public ListResponse<SubtenantUser> map(UserInfoRespList toBeMapped) {
                return SubtenantUserAdapter.mapList(toBeMapped);
            }
        };
    }

    /**
     * Maps the enum value.
     * 
     * @param toBeMapped
     *            a subtenant user status.
     * @return mapped enum value
     */
    @Internal
    protected static UserUpdateReq.StatusEnum
              translateToComArmMbedCloudSdkLowlevelPelionclouddevicemanagementModelUserupdatereqStatusenum(SubtenantUserStatus toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        switch (toBeMapped) {
            case ENROLLING:
                return UserUpdateReq.StatusEnum.ENROLLING;
            case INVITED:
                return UserUpdateReq.StatusEnum.INVITED;
            case ACTIVE:
                return UserUpdateReq.StatusEnum.ACTIVE;
            case RESET:
                return UserUpdateReq.StatusEnum.RESET;
            case INACTIVE:
                return UserUpdateReq.StatusEnum.INACTIVE;
            default:
                return null;
        }
    }
}
