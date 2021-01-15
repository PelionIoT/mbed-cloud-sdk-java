package com.arm.mbed.cloud.sdk.connect.model;

import java.util.Objects;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "EchoResource")
public class EchoResource implements SdkModel {
    private static final long serialVersionUID = 1L;

    private EchoResourceDesired desired;

    private EchoResourceReported reported;

    private String resourcePath;

    private Boolean subscribed;

    /**
     * @param desired
     *            desired
     * @param reported
     *            reported
     * @param resourcePath
     *            The path of the resource.
     * @param subscribed
     *            System-level subscription status of the resource. If any of the applications has placed a
     *            subscription, the status is true. Overlapping subscriptions from multiple applications do not increase
     *            the load on the device as the server handles the multiplexing.
     */
    public EchoResource(EchoResourceDesired desired, EchoResourceReported reported, String resourcePath,
                        Boolean subscribed) {
        super();
        this.desired = desired;
        this.reported = reported;
        this.resourcePath = resourcePath;
        this.subscribed = subscribed;
    }

    public EchoResource() {
        this(null, null, null, null);
    }

    @Override
    public EchoResource clone() {
        return new EchoResource(desired, reported, resourcePath, subscribed);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public EchoResourceDesired getDesired() {
        return desired;
    }

    public void setDesired(EchoResourceDesired desired) {
        this.desired = desired;
    }

    public EchoResourceReported getReported() {
        return reported;
    }

    public void setReported(EchoResourceReported reported) {
        this.reported = reported;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(desired, reported, resourcePath, subscribed);
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
        final EchoResource other = (EchoResource) obj;
        return Objects.equals(desired, other.desired) && Objects.equals(reported, other.reported)
               && Objects.equals(resourcePath, other.resourcePath) && Objects.equals(subscribed, other.subscribed);
    }

    @Override
    public String toString() {
        return "{\"desired\":\"" + desired + "\", \"reported\":\"" + reported + "\", \"resourcePath\":\"" + resourcePath
               + "\", \"subscribed\":\"" + subscribed + "\"}";
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
