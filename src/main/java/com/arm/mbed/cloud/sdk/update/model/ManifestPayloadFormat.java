package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "manifest payload formats")
public enum ManifestPayloadFormat implements SDKEnum {

    RAW_BINARY("raw-binary"), CBOR("cbor"), HEX_LOCATION_LENGTH_DATA("hex-location-length-data"), ELF("elf");
    private final String value;

    private ManifestPayloadFormat(String value) {
        this.value = value;
    }

    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    @Override
    public String getString() {
        return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

    public static ManifestPayloadFormat getDefault() {
        return ELF;
    }

}
