package com.arm.mbed.cloud.sdk.update.adapters;

import java.util.concurrent.TimeUnit;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.ManifestContentsEncryptionMode;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.ManifestContentsPayload;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.ManifestContentsPayloadFormat;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.ManifestContentsPayloadReference;
import com.arm.mbed.cloud.sdk.update.model.ManifestContents;
import com.arm.mbed.cloud.sdk.update.model.ManifestEncryptionMode;
import com.arm.mbed.cloud.sdk.update.model.ManifestPayloadFormat;

@Preamble(description = "Adapter for manifest contents object")
@Internal
public final class ManifestContentsAdapter {

    private ManifestContentsAdapter() {
        super();
    }

    public static ManifestContents map(com.arm.mbed.cloud.sdk.internal.updateservice.model.ManifestContents contents) {
        if (contents == null) {
            return null;
        }
        final ManifestContentsPayload payload = contents.getPayload();

        ManifestPayloadFormat payloadFormat = ManifestPayloadFormat.getDefault();
        String payloadStorageIdentifier = null;
        String payloadHash = null;
        String payloadUri = null;
        long payloadSize = 0;
        if (payload != null) {
            payloadFormat = toPayloadFormat(payload.getFormat());
            payloadStorageIdentifier = payload.getStorageIdentifier();
            final ManifestContentsPayloadReference ref = payload.getReference();
            if (ref != null) {
                payloadSize = TranslationUtils.toLong(ref.getSize());
                payloadUri = ref.getUri();
                payloadHash = ref.getHash();
            }
        }

        return new ManifestContents(contents.getClassId(), contents.getVendorId(),
                TranslationUtils.toInt(contents.getManifestVersion()), contents.getDescription(), contents.getNonce(),
                TranslationUtils.toDate(contents.getTimestamp(), TimeUnit.SECONDS),
                toEncryptionMode(contents.getEncryptionMode()),
                TranslationUtils.toBool(contents.getApplyImmediately(), false), contents.getDeviceId(), payloadFormat,
                payloadStorageIdentifier, payloadHash, payloadUri, payloadSize);

    }

    @SuppressWarnings("boxing")
    private static ManifestPayloadFormat toPayloadFormat(ManifestContentsPayloadFormat format) {
        if (format == null) {
            return ManifestPayloadFormat.getDefault();
        }
        switch (format.getEnum()) {
            case 1:
                return ManifestPayloadFormat.RAW_BINARY;
            case 2:
                return ManifestPayloadFormat.CBOR;
            case 3:
                return ManifestPayloadFormat.HEX_LOCATION_LENGTH_DATA;
            case 4:
                return ManifestPayloadFormat.ELF;
            default:
                break;

        }
        return ManifestPayloadFormat.getDefault();
    }

    @SuppressWarnings("boxing")
    private static ManifestEncryptionMode toEncryptionMode(ManifestContentsEncryptionMode encryptionMode) {
        if (encryptionMode == null) {
            return ManifestEncryptionMode.getDefault();
        }
        switch (encryptionMode.getEnum()) {
            case 1:
                return ManifestEncryptionMode.NONE_ECC_SHA256;
            case 2:
                return ManifestEncryptionMode.AES128_CTR_SHA256;
            case 3:
                return ManifestEncryptionMode.NONE_NONE_SHA256;
            default:
                break;

        }
        return ManifestEncryptionMode.getDefault();
    }

}
