package com.arm.mbed.cloud.sdk.update.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.update.model.DataFile;

import okhttp3.MediaType;
import okhttp3.RequestBody;

@Preamble(description = "Adapter for data file model")
@Internal
public class DataFileAdapter {

    public static RequestBody reverseMap(DataFile dataFile) {
        if (dataFile == null) {
            return null;
        }
        MediaType contentType = MediaType.parse(dataFile.getContentType());
        RequestBody body = RequestBody.create(contentType, dataFile.getFile());
        return body;
    }

}
