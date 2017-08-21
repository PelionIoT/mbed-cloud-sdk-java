package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "manifest encryption modes")
public enum ManifestEncryptionMode implements SDKEnum {

    NONE_ECC_SHA256("none-ecc-secp256r1-sha256"), AES128_CTR_SHA256(
            "aes-128-ctr-ecc-secp256r1-sha256"), NONE_NONE_SHA256("none-none-sha256");
    private final String value;

    private ManifestEncryptionMode(String value) {
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

    public static ManifestEncryptionMode getDefault() {
        return NONE_NONE_SHA256;
    }

}
