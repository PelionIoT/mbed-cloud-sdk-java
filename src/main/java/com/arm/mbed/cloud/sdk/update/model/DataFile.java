package com.arm.mbed.cloud.sdk.update.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Data file")
public class DataFile implements SDKModel {
    /**
     * 
     */
    private static final long serialVersionUID = 2092096356697353992L;
    private static final String BINARY_FILE_MEDIA_TYPE = "application/octet-stream";
    private String contentType;
    private File file;

    public DataFile() {
        this(null, null);
    }

    public DataFile(String contentType, File file) {
        super();
        setContentType(contentType);
        setFile(file);
    }

    /**
     * Description of a binary file
     * 
     * @param filePath
     *            path to a binary file
     */
    public DataFile(String filePath) {
        this(BINARY_FILE_MEDIA_TYPE, (filePath == null) ? null : new File(filePath));
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType
     *            the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file
     *            the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Checks that the file exists
     * 
     * @return whether the file exists or not
     */
    public boolean exists() {
        return file != null && file.exists();
    }

    @SuppressWarnings("resource")
    public @Nullable String getMd5Checksum() throws MbedCloudException {
        if (file == null) {
            return null;
        }
        InputStream is;
        try {
            is = new FileInputStream(file);
            return DigestUtils.md5Hex(is);
        } catch (IOException e) {
            throw new MbedCloudException(e);
        }
    }

    @SuppressWarnings("resource")
    public @Nullable String getSha1Checksum() throws MbedCloudException {
        if (file == null) {
            return null;
        }
        InputStream is;
        try {
            is = new FileInputStream(file);
            return DigestUtils.sha1Hex(is);
        } catch (IOException e) {
            throw new MbedCloudException(e);
        }
    }

    @SuppressWarnings("resource")
    public @Nullable String getSha256Checksum() throws MbedCloudException {
        if (file == null) {
            return null;
        }
        InputStream is;
        try {
            is = new FileInputStream(file);
            return DigestUtils.sha256Hex(is);
        } catch (IOException e) {
            throw new MbedCloudException(e);
        }
    }

    @SuppressWarnings("resource")
    public @Nullable String getSha512Checksum() throws MbedCloudException {
        if (file == null) {
            return null;
        }
        InputStream is;
        try {
            is = new FileInputStream(file);
            return DigestUtils.sha512Hex(is);
        } catch (IOException e) {
            throw new MbedCloudException(e);
        }
    }

}
