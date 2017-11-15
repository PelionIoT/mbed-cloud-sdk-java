package com.arm.mbed.cloud.sdk.update.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Data file")
public class DataFile implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 2092096356697353992L;
    private static final String BINARY_FILE_MEDIA_TYPE = "application/octet-stream";
    @Required
    private String contentType;
    @Required
    private File file;

    /**
     * Constructor.
     */
    public DataFile() {
        this(null, null);
    }

    /**
     * Constructor.
     * 
     * @param contentType
     *            content type of the file e.g. application/octet-stream
     * @param file
     *            file to consider
     */
    public DataFile(String contentType, File file) {
        super();
        setContentType(contentType);
        setFile(file);
    }

    /**
     * Constructor.
     * 
     * <p>
     * Description of a binary file.
     * 
     * @param file
     *            binary file to consider
     */
    public DataFile(File file) {
        this(BINARY_FILE_MEDIA_TYPE, file);
    }

    /**
     * Constructor.
     * <p>
     * Description of a binary file.
     * 
     * @param filePath
     *            path to a binary file.
     */
    public DataFile(String filePath) {
        this((filePath == null) ? null : new File(filePath));
    }

    /**
     * Gets the content type.
     * 
     * @return the contentType.
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the content type.
     * 
     * @param contentType
     *            the contentType to set.
     */
    @Required
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Gets the file.
     * 
     * @return the file.
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the file.
     * 
     * @param file
     *            the file to set.
     */
    @Required
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Checks that the file exists.
     * 
     * @return whether the file exists or not.
     */
    public boolean exists() {
        return file != null && file.exists();
    }

    /**
     * Gets file md5.
     * 
     * @return md5 checksum or null is file does not exist.
     * @throws MbedCloudException
     *             if a problem happens during checksum calculation
     */
    public @Nullable String getMd5Checksum() throws MbedCloudException {
        return getChecksum(new ChecksumFunction() {

            @Override
            public String determineCheckSum(InputStream is) throws IOException {
                return DigestUtils.md5Hex(is);
            }
        });
    }

    /**
     * Gets file sha1.
     * 
     * @return sha1 checksum or null is file does not exist.
     * @throws MbedCloudException
     *             if a problem happens during checksum calculation
     */
    public @Nullable String getSha1Checksum() throws MbedCloudException {
        return getChecksum(new ChecksumFunction() {

            @Override
            public String determineCheckSum(InputStream is) throws IOException {
                return DigestUtils.sha1Hex(is);
            }
        });
    }

    /**
     * Gets file sha256.
     * 
     * @return sha256 checksum or null is file does not exist.
     * @throws MbedCloudException
     *             if a problem happens during checksum calculation
     */
    public @Nullable String getSha256Checksum() throws MbedCloudException {
        return getChecksum(new ChecksumFunction() {

            @Override
            public String determineCheckSum(InputStream is) throws IOException {
                return DigestUtils.sha256Hex(is);
            }
        });
    }

    /**
     * Gets file sha512.
     * 
     * @return sha512 checksum or null is file does not exist.
     * @throws MbedCloudException
     *             if a problem happens during checksum calculation
     */
    public @Nullable String getSha512Checksum() throws MbedCloudException {
        return getChecksum(new ChecksumFunction() {

            @Override
            public String determineCheckSum(InputStream is) throws IOException {
                return DigestUtils.sha512Hex(is);
            }
        });
    }

    /**
     * Gets a clone.
     * 
     * @return a clone
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public DataFile clone() throws CloneNotSupportedException {
        return new DataFile(contentType, file);
    }

    private interface ChecksumFunction {
        String determineCheckSum(InputStream is) throws IOException;
    }

    private String getChecksum(ChecksumFunction function) throws MbedCloudException {
        if (!exists() || function == null) {
            return null;
        }
        try (InputStream is = new FileInputStream(file)) {
            return function.determineCheckSum(is);
        } catch (IOException exception) {
            throw new MbedCloudException(exception);
        }
    }

    /**
     * Determines whether the model instance is valid i.e. all required fields have been set.
     * 
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return contentType != null && file != null;
    }
}
