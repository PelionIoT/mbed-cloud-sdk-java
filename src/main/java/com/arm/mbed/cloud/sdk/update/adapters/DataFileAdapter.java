package com.arm.mbed.cloud.sdk.update.adapters;

import com.arm.mbed.cloud.sdk.update.model.DataFile;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class DataFileAdapter {

    public static RequestBody map(DataFile dataFile) {
        if (dataFile == null) {
            return null;
        }
        MediaType contentType = MediaType.parse(dataFile.getContentType());
        RequestBody body = RequestBody.create(contentType, dataFile.getFile());
        return body;
    }

}
