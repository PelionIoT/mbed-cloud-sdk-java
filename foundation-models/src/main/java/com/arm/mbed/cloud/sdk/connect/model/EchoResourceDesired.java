package com.arm.mbed.cloud.sdk.connect.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Resource value written, or queued to be written to the device.
 */
@Preamble(description = "EchoResource")
public class EchoResourceDesired implements SdkModel {
    private static final long serialVersionUID = 1L;

    private Date desiredAt;

    private BigDecimal status;

    private Date statusUpdatedAt;

    private String value;

    /**
     * @param desiredAt
     *            The time of the latest value write was initiated.
     * @param status
     *            The status of the desired value. 0 &#x3D; &#39;pending write&#39;, 1 &#x3D; &#39;success&#39;, 2
     *            &#x3D; &#39;failed&#39;.
     * @param statusUpdatedAt
     *            The time of the last status update.
     * @param value
     *            The desired value in base64 encoded format.
     * 
     */
    public EchoResourceDesired(Date desiredAt, BigDecimal status, Date statusUpdatedAt, String value) {
        super();
        this.desiredAt = desiredAt;
        this.status = status;
        this.statusUpdatedAt = statusUpdatedAt;
        this.value = value;
    }

    public EchoResourceDesired() {
        this(null, null, null, null);
    }

    @Override
    public EchoResourceDesired clone() {
        return new EchoResourceDesired(desiredAt, status, statusUpdatedAt, value);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public Date getDesiredAt() {
        return desiredAt;
    }

    public void setDesiredAt(Date desiredAt) {
        this.desiredAt = desiredAt;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public Date getStatusUpdatedAt() {
        return statusUpdatedAt;
    }

    public void setStatusUpdatedAt(Date statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
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
        return Objects.hash(desiredAt, status, statusUpdatedAt, value);
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
        final EchoResourceDesired other = (EchoResourceDesired) obj;
        return Objects.equals(desiredAt, other.desiredAt) && Objects.equals(status, other.status)
               && Objects.equals(statusUpdatedAt, other.statusUpdatedAt) && Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "{\"EchoResourceDesired\": {\"desiredAt\":\"" + desiredAt + "\", \"status\":\"" + status
               + "\", \"statusUpdatedAt\":\"" + statusUpdatedAt + "\", \"value\":\"" + value + "\"}}";
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
