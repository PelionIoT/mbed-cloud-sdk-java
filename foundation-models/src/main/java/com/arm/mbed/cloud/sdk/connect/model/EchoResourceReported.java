package com.arm.mbed.cloud.sdk.connect.model;

import java.util.Date;
import java.util.Objects;

import com.arm.mbed.cloud.sdk.common.SdkModel;

public class EchoResourceReported implements SdkModel {
    private static final long serialVersionUID = 1L;

    private String contentType;

    private Date expiresAt;

    private Date reportedAt;

    private String value;

    /**
     * 
     * @param contentType
     *            Content type of the reported resource value.
     * @param expiresAt
     *            The time after which the reported value is not valid, calculated based on the max-age of the resource
     *            value the device reported.
     * @param reportedAt
     *            The time the last value was reported.
     * @param value
     *            The reported value in base64 encoded format.
     * 
     */
    public EchoResourceReported(String contentType, Date expiresAt, Date reportedAt, String value) {
        super();
        this.contentType = contentType;
        this.expiresAt = expiresAt;
        this.reportedAt = reportedAt;
        this.value = value;
    }

    public EchoResourceReported() {
        this(null, null, null, null);
    }

    @Override
    public EchoResourceReported clone() {
        return new EchoResourceReported(contentType, expiresAt, reportedAt, value);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Date getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(Date reportedAt) {
        this.reportedAt = reportedAt;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentType, expiresAt, reportedAt, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EchoResourceReported other = (EchoResourceReported) obj;
        return Objects.equals(contentType, other.contentType) && Objects.equals(expiresAt, other.expiresAt)
               && Objects.equals(reportedAt, other.reportedAt) && Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "{\"EchoResourceReported\": {\"contentType\":\"" + contentType + "\", \"expiresAt\":\"" + expiresAt
               + "\", \"reportedAt\":\"" + reportedAt + "\", \"value\":\"" + value + "\"}}";
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub

    }

}
