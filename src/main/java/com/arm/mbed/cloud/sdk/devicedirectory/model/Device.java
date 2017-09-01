package com.arm.mbed.cloud.sdk.devicedirectory.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Device model")
public class Device implements SDKModel {

    /**
     * 
     */
    private static final long serialVersionUID = -8965559644581108099L;
    /**
     * The ID of the device
     */
    private String id;

    /**
     * The owning IAM account ID
     */
    // private final String accountId;
    // /**
    // * The time the device was created
    // */
    // @DefaultValue(value = "now()")
    // private final Date createdAt;
    // /**
    // * The time the device was updated
    // */
    // @DefaultValue(value = "now()")
    // private final Date updatedAt;
    // /**
    // * The timestamp of the current manifest version
    // */
    // @DefaultValue(value = "now()")
    // private final Date manifestTimestamp;
    // /**
    // * ID of the issuer of the certificate
    // */
    // private String certificateIssuerId;
    // /**
    // * Fingerprint of the device certificate
    // */
    // private String certificateFingerprint;
    // /**
    // * The name of the device
    // */
    // private String name;
    // /**
    // * The alias of the device
    // */
    // private String alias;
    // /**
    // * The description of the device
    // */
    // private String description;
    // /**
    // * The type of the device - e.g. if the device is a gateway.
    // */
    // private String deviceType;
    // /**
    // * The device name of the host gateway, if appropriate.
    // */
    // private String hostGateway;
    // /**
    // * Up to 5 custom attributes
    // */
    // Map<String, String> customAttributes;

    public String getId() {
        return id;
    }

}
