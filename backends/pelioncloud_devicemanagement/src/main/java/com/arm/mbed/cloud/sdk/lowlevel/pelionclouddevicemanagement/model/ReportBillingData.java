/*
 * Pelion Device Management API
 * Pelion Device Management API build from the publicly defined API definitions.
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
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * ReportBillingData
 */

public class ReportBillingData implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("active_devices")
    private Long activeDevices = null;

    @SerializedName("firmware_updates")
    private Long firmwareUpdates = null;

    @SerializedName("generated")
    private DateTime generated = null;

    @SerializedName("period_end")
    private DateTime periodEnd = null;

    @SerializedName("period_start")
    private DateTime periodStart = null;

    @SerializedName("sda_tokens")
    private Long sdaTokens = null;

    public ReportBillingData activeDevices(Long activeDevices) {
        this.activeDevices = activeDevices;
        return this;
    }

    /**
     * Get activeDevices minimum: 0
     * 
     * @return activeDevices
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getActiveDevices() {
        return activeDevices;
    }

    public void setActiveDevices(Long activeDevices) {
        this.activeDevices = activeDevices;
    }

    public ReportBillingData firmwareUpdates(Long firmwareUpdates) {
        this.firmwareUpdates = firmwareUpdates;
        return this;
    }

    /**
     * Get firmwareUpdates minimum: 0
     * 
     * @return firmwareUpdates
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getFirmwareUpdates() {
        return firmwareUpdates;
    }

    public void setFirmwareUpdates(Long firmwareUpdates) {
        this.firmwareUpdates = firmwareUpdates;
    }

    public ReportBillingData generated(DateTime generated) {
        this.generated = generated;
        return this;
    }

    /**
     * Billing report generated time in RFC3339 date-time with millisecond accuracy and UTC time zone.
     * 
     * @return generated
     **/
    @ApiModelProperty(required = true,
                      value = "Billing report generated time in RFC3339 date-time with millisecond accuracy and UTC time zone.")
    public DateTime getGenerated() {
        return generated;
    }

    public void setGenerated(DateTime generated) {
        this.generated = generated;
    }

    public ReportBillingData periodEnd(DateTime periodEnd) {
        this.periodEnd = periodEnd;
        return this;
    }

    /**
     * Billing report end time in RFC3339 date-time with millisecond accuracy and UTC time zone.
     * 
     * @return periodEnd
     **/
    @ApiModelProperty(required = true,
                      value = "Billing report end time in RFC3339 date-time with millisecond accuracy and UTC time zone.")
    public DateTime getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(DateTime periodEnd) {
        this.periodEnd = periodEnd;
    }

    public ReportBillingData periodStart(DateTime periodStart) {
        this.periodStart = periodStart;
        return this;
    }

    /**
     * Billing report start time in RFC3339 date-time with millisecond accuracy and UTC time zone.
     * 
     * @return periodStart
     **/
    @ApiModelProperty(required = true,
                      value = "Billing report start time in RFC3339 date-time with millisecond accuracy and UTC time zone.")
    public DateTime getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(DateTime periodStart) {
        this.periodStart = periodStart;
    }

    public ReportBillingData sdaTokens(Long sdaTokens) {
        this.sdaTokens = sdaTokens;
        return this;
    }

    /**
     * Get sdaTokens minimum: 0
     * 
     * @return sdaTokens
     **/
    @ApiModelProperty(required = true, value = "")
    public Long getSdaTokens() {
        return sdaTokens;
    }

    public void setSdaTokens(Long sdaTokens) {
        this.sdaTokens = sdaTokens;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReportBillingData reportBillingData = (ReportBillingData) o;
        return Objects.equals(this.activeDevices, reportBillingData.activeDevices)
               && Objects.equals(this.firmwareUpdates, reportBillingData.firmwareUpdates)
               && Objects.equals(this.generated, reportBillingData.generated)
               && Objects.equals(this.periodEnd, reportBillingData.periodEnd)
               && Objects.equals(this.periodStart, reportBillingData.periodStart)
               && Objects.equals(this.sdaTokens, reportBillingData.sdaTokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activeDevices, firmwareUpdates, generated, periodEnd, periodStart, sdaTokens);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReportBillingData {\n");

        sb.append("    activeDevices: ").append(toIndentedString(activeDevices)).append("\n");
        sb.append("    firmwareUpdates: ").append(toIndentedString(firmwareUpdates)).append("\n");
        sb.append("    generated: ").append(toIndentedString(generated)).append("\n");
        sb.append("    periodEnd: ").append(toIndentedString(periodEnd)).append("\n");
        sb.append("    periodStart: ").append(toIndentedString(periodStart)).append("\n");
        sb.append("    sdaTokens: ").append(toIndentedString(sdaTokens)).append("\n");
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
