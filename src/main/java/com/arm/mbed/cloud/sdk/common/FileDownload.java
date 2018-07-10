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
    private final URL source;
    private final File destination;
    private boolean downloaded;
    private SdkLogger logger;

    public enum Extension {
        JSON,
        TXT,
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
        this(generateTempFile(null, extension == Extension.DEFAULT ? null : "." + extension.toString().toLowerCase()));
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

    private static File generateTempFile(URL source, String extension) throws MbedCloudException {
        try {
            final String fileName = (source == null) ? "unknown.txt"
                                                     : Paths.get(source.toURI().getPath()).toFile().getName();
            return File.createTempFile(getFileNameWithoutExtension(fileName),
                                       extension == null ? "." + getFileExtension(fileName) : extension);
        } catch (IOException | URISyntaxException exception) {
            throw new MbedCloudException(exception);
        }
    }

    private static String getFileExtension(String fileName) {
        if (fileName == null) {
            return "";
        }
        final int i = fileName.lastIndexOf('.');
        return i > 0 ? fileName.substring(i + 1) : "";
    }

    private static String getFileNameWithoutExtension(String fileName) {
        if (fileName == null) {
            return "";
        }
        return fileName.replace("." + getFileExtension(fileName), "");
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
