package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Device event model")
public class DeviceEvent implements SDKModel {

    /**
     * 
     */
    private static final long serialVersionUID = 2307075354040045693L;

    /**
     * ID of the event
     */
    private String id;
    /**
     * ID of device the event is for
     */
    private String deviceId;
    /**
     * Date and time of the event
     */
    private Date eventDate;
    /**
     * Whether the event changed state
     */
    private boolean stateChanged;
    /**
     * Description of the event
     */
    private String description;
    /**
     * Changes made
     */
    // readonly changes?: {};
    /**
     * Description of the event type
     */
    private String typeDescription;
    /**
     * Type of the event
     */
    private String type;

    /**
     * Data pertaining to the event
     */
    // readonly data?: {};
    public String getId() {
        return id;
    }

}
