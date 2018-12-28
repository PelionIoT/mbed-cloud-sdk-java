package com.arm.mbed.cloud.sdk.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "File on the disk resulting from a download or where some content will be downloaded")
public class FileDownload {
    private static final String EMPTY_STRING = "";
    private static final String EXTENSION_SEPARATOR = ".";
    private static final String UNDEFINED_DESTINATION_FILENAME = "unknown.txt";
    private final URL source;
    private final File destination;
    private transient volatile boolean downloaded;
    private transient SdkLogger logger;

    public enum Extension
    {
        JSON,
        TXT,
        GZ,
        CSV,
        DEFAULT
    }

    /**
     * Constructor.
     * <p>
     * The file will be downloaded from the source to the destination.
     *
     * @param source
     *            URL of the source.
     * @param destination
     *            destination file.
     */
    public FileDownload(URL source, File destination) {
        super();
        this.source = source;
        this.destination = destination;
        this.downloaded = false;
        this.logger = null;
    }

    /**
     * Constructor.
     * <p>
     * The file will be downloaded from the source to a temporary file on the disk.
     *
     * @param source
     *            URL of the source.
     * @throws MbedCloudException
     *             if a problem occurred during the process
     */
    public FileDownload(URL source) throws MbedCloudException {
        this(source, generateTempFile(source, null));
    }

    /**
     * Constructor.
     * <p>
     * The file will be downloaded from the source to the destination.
     *
     * @param sourceUrl
     *            URL of the source.
     * @param filePath
     *            directory on disk where the file should be downloaded or path to the end file.
     * @param fileName
     *            filename of the downloaded file if not specified in filePath
     * @throws MalformedURLException
     *             if a problem occurred during the process
     * @throws MbedCloudException
     *             if a problem occurred during the process
     */
    public FileDownload(String sourceUrl, String filePath, String fileName) throws MalformedURLException,
                                                                            MbedCloudException {
        this(new URL(sourceUrl), generateFileDestination(filePath, fileName));
    }

    /**
     * Constructor.
     * <p>
     * The file will be downloaded from the source to the destination.
     *
     * @param sourceUrl
     *            URL of the source.
     * @param destinationPath
     *            destination file path on the disk.
     * @throws MalformedURLException
     *             if a problem occurred during the process
     */
    public FileDownload(String sourceUrl, String destinationPath) throws MalformedURLException {
        this(new URL(sourceUrl), new File(destinationPath));
    }

    /**
     * Constructor.
     *
     * @param destination
     *            destination file on the disk.
     */
    public FileDownload(File destination) {
        this(null, destination);
    }

    /**
     * Constructor.
     *
     * @param destinationPath
     *            destination file path on the disk.
     */
    public FileDownload(String destinationPath) {
        this(new File(destinationPath));
    }

    /**
     * Constructor.
     * <p>
     * Note: the data will be saved to a temporary file on the disk.
     *
     * @param extension
     *            extension of the destination file on the disk.
     * @throws MbedCloudException
     *             if a problem occurred during the process
     */
    public FileDownload(Extension extension) throws MbedCloudException {
        this(generateTempFile((String) null,
                              extension == Extension.DEFAULT ? null : EXTENSION_SEPARATOR
                                                                      + extension.toString().toLowerCase()));
    }

    /**
     * Constructor.
     * <p>
     * Note: the data will be saved to a temporary file on the disk.
     *
     * @throws MbedCloudException
     *             if a problem occurred during the process
     *
     *
     */
    public FileDownload() throws MbedCloudException {
        this(Extension.DEFAULT);
    }

    /**
     * Gets download source.
     *
     * @return the source
     */
    public URL getSource() {
        return source;
    }

    /**
     * Gets file destination.
     *
     * @return the destination
     */
    public File getDestination() {
        return destination;
    }

    /**
     * Has the file been downloaded.
     *
     * @return the downloaded
     */
    public boolean isDownloaded() {
        return downloaded;
    }

    /**
     * Sets whether the file has been downloaded.
     *
     * @param downloaded
     *            the downloaded to set
     */
    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    /**
     * Sets the logger.
     *
     * @param logger
     *            the logger to set
     */
    public void setLogger(SdkLogger logger) {
        this.logger = logger;
    }

    /**
     * Downloading data to a file on the disk.
     *
     * @param content
     *            content to save
     * @throws MbedCloudException
     *             if a problem occurred during the process
     */
    public void download(String content) throws MbedCloudException {
        checkParameters();
        if (content == null) {
            throw new MbedCloudException("The file to download is empty");
        }
        if (logger != null) {
            logger.logInfo("Downloading data to [" + destination.getName() + "]");
        }
        try (PrintWriter out = new PrintWriter(destination, StandardCharsets.UTF_8.name())) {
            out.println(content);
        } catch (IOException exception) {
            throw new MbedCloudException("The file could not be downloaded", exception);
        }
        downloaded = true;
    }

    /**
     * Downloading a file to the disk.
     *
     * @throws MbedCloudException
     *             if a problem occurred during the process
     */
    public void download() throws MbedCloudException {
        checkParameters();
        if (source == null) {
            throw new MbedCloudException("The source of the file has not been specified");
        }
        if (logger != null) {
            logger.logInfo("Downloading File [" + source.toString() + "] to [" + destination.getName() + "]");
        }
        try (InputStream in = source.openStream()) {
            Files.copy(in, destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException exception) {
            throw new MbedCloudException("The file could not be downloaded", exception);
        }
        downloaded = true;
    }

    private void checkParameters() throws MbedCloudException {
        if (downloaded) {
            throw new MbedCloudException("The file has already been downloaded");
        }
        if (destination == null) {
            throw new MbedCloudException("The destination of the download has not been specified");
        }
        if (destination.exists()) {
            if (!destination.isFile()) {
                throw new MbedCloudException("The destination does not correspond to a file");
            }
            if (logger != null) {
                logger.logWarn("File [" + destination.getName() + "] will be overwritten");
            }
        }
    }

    private static File generateFileDestination(String destinationDirectory,
                                                String fileName) throws MbedCloudException {
        if (destinationDirectory == null || destinationDirectory.isEmpty()) {
            return generateTempFile(fileName, null);
        }
        final File directory = new File(destinationDirectory);
        final File destination = new File(directory, fileName);
        if (directory.exists()) {
            if (directory.isDirectory()) {
                return destination;
            }
            // In this case, the file path is complete.
            return directory;
        }
        return hasExtension(destinationDirectory) ? directory : destination;
    }

    private static File generateTempFile(URL source, String extension) throws MbedCloudException {
        try {
            final String fileName = source == null ? null : Paths.get(source.toURI().getPath()).toFile().getName();
            return generateTempFile(fileName, extension);
        } catch (URISyntaxException exception) {
            throw new MbedCloudException(exception);
        }
    }

    private static File generateTempFile(String fileName, String extension) throws MbedCloudException {
        final String finalFileName = fileName == null ? UNDEFINED_DESTINATION_FILENAME : fileName;
        try {
            return File.createTempFile(getFileNameWithoutExtension(finalFileName),
                                       extension == null ? EXTENSION_SEPARATOR + getFileExtension(finalFileName)
                                                         : extension);
        } catch (IOException exception) {
            throw new MbedCloudException(exception);
        }
    }

    protected static boolean hasExtension(String fileName) {
        return !getFileExtension(fileName).isEmpty();
    }

    protected static String getFileExtension(String fileName) {
        if (fileName == null || fileName.trim().endsWith(EXTENSION_SEPARATOR)) {
            return EMPTY_STRING;
        }
        final int i = fileName.lastIndexOf('.');
        if (i < 0) {
            return EMPTY_STRING;
        }
        final StringBuilder builder = new StringBuilder();
        final String shorterFilename = fileName.substring(0, i);
        final int j = shorterFilename.lastIndexOf('.');
        // This is an arbitrary constraint on the length of the extension.
        if (j > 0 && shorterFilename.length() - j < 5) {
            builder.append(shorterFilename.substring(j + 1)).append('.');
        }
        builder.append(fileName.substring(i + 1));
        return builder.toString().trim();
    }

    protected static String getFileNameWithoutExtension(String fileName) {
        if (fileName == null) {
            return EMPTY_STRING;
        }
        return fileName.trim().replace(EXTENSION_SEPARATOR + getFileExtension(fileName), EMPTY_STRING);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + SdkUtils.urlHashcode(source);
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FileDownload)) {
            return false;
        }
        final FileDownload other = (FileDownload) obj;
        if (destination == null) {
            if (other.destination != null) {
                return false;
            }
        } else if (!destination.equals(other.destination)) {
            return false;
        }
        if (!SdkUtils.urlEquals(source, other.getSource())) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FileDownload [source=" + source + ", destination=" + destination + ", downloaded=" + downloaded + "]";
    }

}
