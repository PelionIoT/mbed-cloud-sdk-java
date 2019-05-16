package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.LoginHistory;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;

@Preamble(description = "Adapter for login history model")
@Internal
public final class LoginHistoryAdapter {

    private LoginHistoryAdapter() {
        super();
    }

    /**
     * Maps login history.
     * 
     * @param history
     *            login history to map.
     * @return login history.
     */
    public static LoginHistory
           map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory history) {
        if (history == null) {
            return null;
        }
        return new LoginHistory(TranslationUtils.toDate(history.getDate()), history.getUserAgent(),
                                history.getIpAddress(), TranslationUtils.toBool(history.isSuccess(), false));
    }

    /**
     * Gets login history mapper.
     * 
     * @return login history.
     */
    public static Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory, LoginHistory>
           getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory,
                          LoginHistory>() {

            @Override
            public LoginHistory
                   map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory toBeMapped) {
                return LoginHistoryAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Maps list of login history
     * 
     * @param loginHistory
     *            login history list.
     * @return a list of login history.
     */
    public static List<LoginHistory>
           mapList(List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory> loginHistory) {
        return GenericAdapter.mapList(loginHistory, getMapper());
    }

    /**
     * Gets list mapper.
     * 
     * @return list mapper.
     */
    public static Mapper<List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory>,
                         List<LoginHistory>>
           getListMapper() {
        return new Mapper<List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory>,
                          List<LoginHistory>>() {

            @Override
            public List<LoginHistory>
                   map(List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory> toBeMapped) {
                return LoginHistoryAdapter.mapList(toBeMapped);
            }
        };
    }
}
