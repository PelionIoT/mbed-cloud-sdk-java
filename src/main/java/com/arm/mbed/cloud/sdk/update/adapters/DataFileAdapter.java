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

    private static final String DEFAULT_PART_NAME = "datafile";

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
        return reverseMap(DEFAULT_PART_NAME, dataFile);
    }

    /**
     * Reverses mapping of data file.
     *
     * @param partName
     *            name of the part to send
     * @param dataFile
     *            new data file
     * @return new data file request
     */
    public static MultipartBody.Part reverseMap(String partName, DataFile dataFile) {
        if (dataFile == null) {
            return null;
        }
        final MediaType contentType = MediaType.parse(dataFile.getContentType());
        final RequestBody body = RequestBody.create(contentType, dataFile.getFile());

        return MultipartBody.Part.createFormData(partName, dataFile.getFileName(), body);
    }

}
