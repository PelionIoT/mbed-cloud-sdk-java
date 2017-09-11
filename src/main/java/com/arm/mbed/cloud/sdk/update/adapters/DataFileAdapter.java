package com.arm.mbed.cloud.sdk.update.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.update.model.DataFile;

import okhttp3.MediaType;
import okhttp3.RequestBody;

@Preamble(description = "Adapter for data file model")
@Internal
public final class DataFileAdapter {

    private DataFileAdapter() {
        super();
    }

    public static RequestBody reverseMap(DataFile dataFile) {
        if (dataFile == null) {
            return null;
        }
        final MediaType contentType = MediaType.parse(dataFile.getContentType());
        return RequestBody.create(contentType, dataFile.getFile());
    }

}
