// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.adapters;

import com.arm.mbed.cloud.sdk.accounts.model.LoginHistory;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import java.util.List;

/**
 * Adapter for login histories.
 */
@Preamble(description = "Adapter for login histories.")
@Internal
@SuppressWarnings("checkstyle:LineLength")
public final class LoginHistoryAdapter {
    /**
     * Constructor.
     */
    private LoginHistoryAdapter() {
        super();
        // Nothing to do;
    }

    /**
     * Maps a login history into a login history.
     * 
     * @param toBeMapped
     *            a login history.
     * @return mapped a login history
     */
    @Internal
    public static LoginHistory
           map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final LoginHistory loginHistory = new LoginHistory(TranslationUtils.toDate(toBeMapped.getDate()),
                                                           toBeMapped.getIpAddress(),
                                                           TranslationUtils.toBool(toBeMapped.isSuccess()),
                                                           toBeMapped.getUserAgent());
        return loginHistory;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory,
                                        LoginHistory>
           getMapper() {
        return new GenericAdapter.Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory,
                                         LoginHistory>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public LoginHistory
                   map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory toBeMapped) {
                return LoginHistoryAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a list into a list.
     * 
     * @param toBeMapped
     *            a list.
     * @return mapped simple list
     */
    @Internal
    public static List<LoginHistory>
           mapSimpleList(List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory> toBeMapped) {
        return GenericAdapter.mapList(toBeMapped, LoginHistoryAdapter.getMapper());
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static
           GenericAdapter.Mapper<List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory>,
                                 List<LoginHistory>>
           getSimpleListMapper() {
        return new GenericAdapter.Mapper<List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory>,
                                         List<LoginHistory>>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public List<LoginHistory>
                   map(List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LoginHistory> toBeMapped) {
                return LoginHistoryAdapter.mapSimpleList(toBeMapped);
            }
        };
    }
}
