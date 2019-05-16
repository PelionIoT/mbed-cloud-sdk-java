/*
 * Mbed Cloud API
 * The full Mbed Cloud API
 *
 * OpenAPI spec version: 3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * NotificationMessage
 */

public class NotificationMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("async-responses")
    private List<AsyncIDResponse> asyncResponses = null;

    @SerializedName("de-registrations")
    private List<String> deRegistrations = null;

    @SerializedName("notifications")
    private List<NotificationData> notifications = null;

    @SerializedName("reg-updates")
    private List<EndpointData> regUpdates = null;

    @SerializedName("registrations")
    private List<EndpointData> registrations = null;

    @SerializedName("registrations-expired")
    private List<String> registrationsExpired = null;

    public NotificationMessage asyncResponses(List<AsyncIDResponse> asyncResponses) {
        this.asyncResponses = asyncResponses;
        return this;
    }

    public NotificationMessage addAsyncResponsesItem(AsyncIDResponse asyncResponsesItem) {
        if (this.asyncResponses == null) {
            this.asyncResponses = new ArrayList<AsyncIDResponse>();
        }
        this.asyncResponses.add(asyncResponsesItem);
        return this;
    }

    /**
     * Get asyncResponses
     * 
     * @return asyncResponses
     **/
    @ApiModelProperty(value = "")
    public List<AsyncIDResponse> getAsyncResponses() {
        return asyncResponses;
    }

    public void setAsyncResponses(List<AsyncIDResponse> asyncResponses) {
        this.asyncResponses = asyncResponses;
    }

    public NotificationMessage deRegistrations(List<String> deRegistrations) {
        this.deRegistrations = deRegistrations;
        return this;
    }

    public NotificationMessage addDeRegistrationsItem(String deRegistrationsItem) {
        if (this.deRegistrations == null) {
            this.deRegistrations = new ArrayList<String>();
        }
        this.deRegistrations.add(deRegistrationsItem);
        return this;
    }

    /**
     * Get deRegistrations
     * 
     * @return deRegistrations
     **/
    @ApiModelProperty(value = "")
    public List<String> getDeRegistrations() {
        return deRegistrations;
    }

    public void setDeRegistrations(List<String> deRegistrations) {
        this.deRegistrations = deRegistrations;
    }

    public NotificationMessage notifications(List<NotificationData> notifications) {
        this.notifications = notifications;
        return this;
    }

    public NotificationMessage addNotificationsItem(NotificationData notificationsItem) {
        if (this.notifications == null) {
            this.notifications = new ArrayList<NotificationData>();
        }
        this.notifications.add(notificationsItem);
        return this;
    }

    /**
     * Get notifications
     * 
     * @return notifications
     **/
    @ApiModelProperty(value = "")
    public List<NotificationData> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationData> notifications) {
        this.notifications = notifications;
    }

    public NotificationMessage regUpdates(List<EndpointData> regUpdates) {
        this.regUpdates = regUpdates;
        return this;
    }

    public NotificationMessage addRegUpdatesItem(EndpointData regUpdatesItem) {
        if (this.regUpdates == null) {
            this.regUpdates = new ArrayList<EndpointData>();
        }
        this.regUpdates.add(regUpdatesItem);
        return this;
    }

    /**
     * Get regUpdates
     * 
     * @return regUpdates
     **/
    @ApiModelProperty(value = "")
    public List<EndpointData> getRegUpdates() {
        return regUpdates;
    }

    public void setRegUpdates(List<EndpointData> regUpdates) {
        this.regUpdates = regUpdates;
    }

    public NotificationMessage registrations(List<EndpointData> registrations) {
        this.registrations = registrations;
        return this;
    }

    public NotificationMessage addRegistrationsItem(EndpointData registrationsItem) {
        if (this.registrations == null) {
            this.registrations = new ArrayList<EndpointData>();
        }
        this.registrations.add(registrationsItem);
        return this;
    }

    /**
     * Get registrations
     * 
     * @return registrations
     **/
    @ApiModelProperty(value = "")
    public List<EndpointData> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<EndpointData> registrations) {
        this.registrations = registrations;
    }

    public NotificationMessage registrationsExpired(List<String> registrationsExpired) {
        this.registrationsExpired = registrationsExpired;
        return this;
    }

    public NotificationMessage addRegistrationsExpiredItem(String registrationsExpiredItem) {
        if (this.registrationsExpired == null) {
            this.registrationsExpired = new ArrayList<String>();
        }
        this.registrationsExpired.add(registrationsExpiredItem);
        return this;
    }

    /**
     * Get registrationsExpired
     * 
     * @return registrationsExpired
     **/
    @ApiModelProperty(value = "")
    public List<String> getRegistrationsExpired() {
        return registrationsExpired;
    }

    public void setRegistrationsExpired(List<String> registrationsExpired) {
        this.registrationsExpired = registrationsExpired;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificationMessage notificationMessage = (NotificationMessage) o;
        return Objects.equals(this.asyncResponses, notificationMessage.asyncResponses)
               && Objects.equals(this.deRegistrations, notificationMessage.deRegistrations)
               && Objects.equals(this.notifications, notificationMessage.notifications)
               && Objects.equals(this.regUpdates, notificationMessage.regUpdates)
               && Objects.equals(this.registrations, notificationMessage.registrations)
               && Objects.equals(this.registrationsExpired, notificationMessage.registrationsExpired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asyncResponses, deRegistrations, notifications, regUpdates, registrations,
                            registrationsExpired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationMessage {\n");

        sb.append("    asyncResponses: ").append(toIndentedString(asyncResponses)).append("\n");
        sb.append("    deRegistrations: ").append(toIndentedString(deRegistrations)).append("\n");
        sb.append("    notifications: ").append(toIndentedString(notifications)).append("\n");
        sb.append("    regUpdates: ").append(toIndentedString(regUpdates)).append("\n");
        sb.append("    registrations: ").append(toIndentedString(registrations)).append("\n");
        sb.append("    registrationsExpired: ").append(toIndentedString(registrationsExpired)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
