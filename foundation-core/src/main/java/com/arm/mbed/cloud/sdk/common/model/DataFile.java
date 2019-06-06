package com.arm.mbed.cloud.sdk.common.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import org.apache.commons.codec.digest.DigestUtils;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.PerformsNoOperation;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.SdkUtils;

@Preamble(description = "Data file")
public class DataFile implements SdkModel {
    private static final String CSV_EXTENSION = "csv";
    private static final String TEXT_EXTENSION = "txt";
    private static final String PNG_EXTENSION = "png";
    private static final String JPEG_EXTENSION = "jpeg";
    private static final String JPEG_EXTENSION2 = "jpg";
    private static final String GIF_EXTENSION = "gif";
    private static final String BMP_EXTENSION = "bmp";
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 2092096356697353992L;
    public static final String BINARY_FILE_MEDIA_TYPE = "application/octet-stream";
    public static final String CSV_FILE_MEDIA_TYPE = "application/vnd.ms-excel";
    public static final String TEXT_FILE_MEDIA_TYPE = "text/plain";
    public static final String GIF_IMAGE_FILE_MEDIA_TYPE = "image/gif";
    public static final String PNG_IMAGE_FILE_MEDIA_TYPE = "image/png";
    public static final String JPEG_IMAGE_FILE_MEDIA_TYPE = "image/jpeg";
    public static final String BMP_IMAGE_FILE_MEDIA_TYPE = "image/bmp";

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
        this(determineContentType(file), file);
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
     * Gets file Id.
     *
     * @return file Id (file path).
     */
    @Override
    public String getId() {
        return hasFile() ? getFile().toString() : null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.SdkModel#setId(java.lang.String)
     */
    @PerformsNoOperation
    @Internal
    @Override
    public void setId(String id) {
        // Nothing to do
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
     * Gets the file name.
     *
     * @return the file name.
     */
    public @Nullable String getFileName() {
        return hasFile() ? getFile().getName() : null;
    }

    /**
     * States whether a file has been specified.
     *
     * @return True if a file has been specified. False otherwise.
     */
    public boolean hasFile() {
        return getFile() != null;
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
    public DataFile clone() {
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
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return contentType != null && file != null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
        result = prime * result + ((file == null) ? 0 : file.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DataFile)) {
            return false;
        }
        final DataFile other = (DataFile) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        if (contentType == null) {
            if (other.contentType != null) {
                return false;
            }
        } else if (!contentType.equals(other.contentType)) {
            return false;
        }
        if (file == null) {
            if (other.file != null) {
                return false;
            }
        } else if (!file.equals(other.file)) {
            return false;
        }
        return true;
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     *
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise
     */
    protected boolean canEqual(Object other) {
        return other instanceof DataFile;
    }

    private static String determineContentType(File file) {
        if (file == null) {
            return BINARY_FILE_MEDIA_TYPE;
        }
        final String fileName = file.getName();
        final String extension = SdkUtils.getFileExtension(fileName).toLowerCase(Locale.UK);
        switch (extension) {
            case CSV_EXTENSION:
                return CSV_FILE_MEDIA_TYPE;
            case TEXT_EXTENSION:
                return TEXT_FILE_MEDIA_TYPE;
            case GIF_EXTENSION:
                return GIF_IMAGE_FILE_MEDIA_TYPE;
            case PNG_EXTENSION:
                return PNG_IMAGE_FILE_MEDIA_TYPE;
            case JPEG_EXTENSION:
            case JPEG_EXTENSION2:
                return JPEG_IMAGE_FILE_MEDIA_TYPE;
            case BMP_EXTENSION:
                return BMP_IMAGE_FILE_MEDIA_TYPE;
            default:
                return BINARY_FILE_MEDIA_TYPE;
        }
    }

    @Override
    public String toString() {
        return "DataFile [contentType=" + contentType + ", file=" + file + "]";
    }

}
