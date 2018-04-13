package com.arm.mbed.cloud.sdk.bootstrap.adapters;

import com.arm.mbed.cloud.sdk.bootstrap.model.PreSharedKey;

public class PreSharedKeyAdapter {
    /**
     * Reverses mapping.
     *
     * @param key
     * @return a preshared key
     */
    public static com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKey reverseMap(PreSharedKey key) {
        if (key == null) {
            return null;
        }
        final com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKey sharedKey = new com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKey();
        sharedKey.setEndpointName(key.getId());
        sharedKey.setSecretHex(key.getSecret());
        return sharedKey;
    }

}
