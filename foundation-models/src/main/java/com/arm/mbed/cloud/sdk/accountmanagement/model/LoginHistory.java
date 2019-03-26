package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.PerformsNoOperation;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "This object represents a user login history in Arm Pelion Cloud")
public class LoginHistory implements SdkModel {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -3096297390909097558L;
    /**
     * Date of login.
     */
    @DefaultValue(value = "now()")
    public final Date date;
    /**
     * User agent used for login.
     */
    public final String userAgent;
    /**
     * IP Address login from.
     */
    public final String ipAddress;
    /**
     * Whether login was successful.
     */
    @DefaultValue(value = "false")
    public final boolean success;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #LoginHistory()} instead.
     *
     * @param date
     *            date
     * @param userAgent
     *            userAgent
     * @param ipAddress
     *            ipAddress
     * @param success
     *            success
     */
    @Internal
    public LoginHistory(Date date, String userAgent, String ipAddress, boolean success) {
        super();
        this.date = date;
        this.userAgent = userAgent;
        this.ipAddress = ipAddress;
        this.success = success;
    }

    /**
     * Constructor for login history.
     * <p>
     * Other constructors are for internal usage only.
     */
    public LoginHistory() {
        this(new Date(), null, null, false);
    }

    /**
     * Gets login history Id.
     *
     * @return an id.
     */
    @Override
    @Internal
    public String getId() {
        return (getDate() == null) ? null : getDate().toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.SdkModel#setId(java.lang.String)
     */
    @PerformsNoOperation
    @Internal
    @Override
    public void setId(String id) {
        // Nothing to do

    }

    /**
     * Gets the date.
     *
     * @return the date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets user agent.
     *
     * @return the userAgent.
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Gets the IP address.
     *
     * @return the ipAddress.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * States whether login was successful or not.
     *
     * @return the success.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Gets a clone
     *
     * @return a clone.
     * @see java.lang.Object#clone()
     */
    @Override
    public LoginHistory clone() {
        return new LoginHistory(date, userAgent, ipAddress, success);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LoginHistory [date=" + date + ", userAgent=" + userAgent + ", ipAddress=" + ipAddress + ", success="
               + success + "]";
    }

}
