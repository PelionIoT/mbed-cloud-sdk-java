package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.LoginHistory;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;

@Preamble(description = "Adapter for login history model")
public class LoginHistoryAdapter {

    private LoginHistoryAdapter() {
        super();
    }

    public static LoginHistory map(com.arm.mbed.cloud.sdk.internal.iam.model.LoginHistory history) {
        if (history == null) {
            return null;
        }
        LoginHistory logingHistory = new LoginHistory(TranslationUtils.toDate(history.getDate()),
                history.getUserAgent(), history.getIpAddress(), TranslationUtils.toBool(history.getSuccess(), false));
        return logingHistory;
    }

    public static Mapper<com.arm.mbed.cloud.sdk.internal.iam.model.LoginHistory, LoginHistory> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.iam.model.LoginHistory, LoginHistory>() {

            @Override
            public LoginHistory map(com.arm.mbed.cloud.sdk.internal.iam.model.LoginHistory toBeMapped) {
                return LoginHistoryAdapter.map(toBeMapped);
            }

        };
    }

    public static List<LoginHistory> mapList(
            List<com.arm.mbed.cloud.sdk.internal.iam.model.LoginHistory> loginHistory) {
        return GenericAdapter.mapList(loginHistory, getMapper());
    }

    public static Mapper<List<com.arm.mbed.cloud.sdk.internal.iam.model.LoginHistory>, List<LoginHistory>> getListMapper() {
        return new Mapper<List<com.arm.mbed.cloud.sdk.internal.iam.model.LoginHistory>, List<LoginHistory>>() {

            @Override
            public List<LoginHistory> map(List<com.arm.mbed.cloud.sdk.internal.iam.model.LoginHistory> toBeMapped) {
                return LoginHistoryAdapter.mapList(toBeMapped);
            }
        };
    }
}
