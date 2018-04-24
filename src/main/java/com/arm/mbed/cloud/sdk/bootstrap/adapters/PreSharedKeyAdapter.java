package com.arm.mbed.cloud.sdk.bootstrap.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.bootstrap.model.PreSharedKey;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKeyWithoutSecret;

@Preamble(description = "Adapter for psk model")
@Internal
public final class PreSharedKeyAdapter {

    private PreSharedKeyAdapter() {
        super();

    }

    /**
     * Maps a pre-shared key without secrets into a psk.
     *
     * @param key
     *            key
     * @return corresponding psk
     */
    public static PreSharedKey map(PreSharedKeyWithoutSecret key) {
        if (key == null) {
            return null;
        }
        return new PreSharedKey(key.getEndpointName());
    }

    /**
     * Get PSK mapper.
     *
     * @return the psk mapper.
     */
    public static Mapper<PreSharedKeyWithoutSecret, PreSharedKey> getMapper() {
        return new Mapper<PreSharedKeyWithoutSecret, PreSharedKey>() {

            @Override
            public PreSharedKey map(PreSharedKeyWithoutSecret toBeMapped) {
                return PreSharedKeyAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Reverses mapping.
     *
     * @param key
     *            key.
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
