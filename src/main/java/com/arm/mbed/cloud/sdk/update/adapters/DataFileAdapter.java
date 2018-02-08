package com.arm.mbed.cloud.sdk.update.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.update.model.DataFile;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@Preamble(description = "Adapter for data file model")
@Internal
public final class DataFileAdapter {

    private DataFileAdapter() {
        super();
    }

    /**
     * Reverses mapping of data file.
     * 
     * @param dataFile
     *            new data file
     * @return new data file request
     */
    public static MultipartBody.Part reverseMap(DataFile dataFile) {
        if (dataFile == null) {
            return null;
        }
        final MediaType contentType = MediaType.parse(dataFile.getContentType());
        final RequestBody body = RequestBody.create(contentType, dataFile.getFile());

        return MultipartBody.Part.createFormData("datafile", dataFile.getFileName(), body);
    }

}
