package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "This object represents a user login history in Arm Mbed Cloud")
public class LoginHistory implements SDKModel {

    /**
     * 
     */
    private static final long serialVersionUID = -3096297390909097558L;
    /**
     * Date of login
     */
    @DefaultValue(value = "now()")
    public final Date date;
    /**
     * User agent used for login
     */
    public final String userAgent;
    /**
     * IP Address login from
     */
    public final String ipAddress;
    /**
     * Whether login was successful
     */
    @DefaultValue(value = "false")
    public final boolean success;

    public LoginHistory(Date date, String userAgent, String ipAddress, boolean success) {
        super();
        this.date = date;
        this.userAgent = userAgent;
        this.ipAddress = ipAddress;
        this.success = success;
    }

    public LoginHistory() {
        this(new Date(), null, null, false);
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

}
