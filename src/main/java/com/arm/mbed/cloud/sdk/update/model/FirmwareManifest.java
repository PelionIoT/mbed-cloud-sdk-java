package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Firmware Manifest")
public class FirmwareManifest implements SdkModel {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -1294421103104004701L;
    /**
     * The ID of the firmware manifest.
     */
    private String id;
    /**
     * The URL of the firmware manifest.
     */
    private final URL url;
    /**
     * The class of device.
     */
    private final String deviceClass;
    /**
     * The time the object was created.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The time the object was updated.
     */
    @DefaultValue(value = "now()")
    private final Date updatedAt;
    /**
     * The version of the firmware manifest (as a timestamp).
     */
    @DefaultValue(value = "now()")
    private final Date timestamp;

    /**
     * The name of the object.
     */
    @Required
    private String name;
    /**
     * The description of the object.
     */
    private String description;
    /**
     * the size in bytes of the uploaded firmware manifest binary.
     */
    @DefaultValue(value = "0")
    private final long datafileSize;
    /**
     * Checksum generated for the datafile.
     */
    private final String datafileChecksum;
    /**
     * The binary file of the manifest.
     */
    @Required
    private DataFile dataFile;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #FirmwareManifest()} or {@link #FirmwareManifest(String, DataFile)} instead.
     * 
     * @param id
     *            id
     * @param url
     *            URL
     * @param deviceClass
     *            deviceClass
     * @param datafileChecksum
     *            file checksum
     * @param datafileSize
     *            file size
     * @param createdAt
     *            createdAt
     * @param updatedAt
     *            updatedAt
     * @param timestamp
     *            timestamp
     */
    @Internal
    public FirmwareManifest(String id, URL url, String deviceClass, String datafileChecksum, long datafileSize,
            Date createdAt, Date updatedAt, Date timestamp) {
        this(id, url, deviceClass, createdAt, updatedAt, timestamp, null, null, datafileSize, datafileChecksum, null);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #FirmwareManifest()} or {@link #FirmwareManifest(String, DataFile)} instead.
     * 
     * @param id
     *            id
     * @param url
     *            URL
     * @param deviceClass
     *            deviceClass
     * @param createdAt
     *            createdAt
     * @param updatedAt
     *            updatedAt
     * @param timestamp
     *            timestamp
     * @param name
     *            name
     * @param description
     *            description
     * @param datafileSize
     *            file size
     * @param datafileChecksum
     *            file checksum
     * @param dataFile
     *            file
     */
    @Internal
    public FirmwareManifest(String id, URL url, String deviceClass, Date createdAt, Date updatedAt, Date timestamp,
            String name, String description, long datafileSize, String datafileChecksum, DataFile dataFile) {
        super();
        setId(id);
        this.url = url;
        this.deviceClass = deviceClass;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.timestamp = timestamp;
        this.datafileSize = datafileSize;
        this.datafileChecksum = datafileChecksum;
        setName(name);
        setDescription(description);
        setDataFile(dataFile);
    }

    /**
     * Constructor.
     */
    public FirmwareManifest() {
        this(null, null, null, null, 0, new Date(), new Date(), new Date());
    }

    /**
     * Constructor.
     * 
     * @param name
     *            manifest name
     * @param dataFile
     *            manifest file
     */
    public FirmwareManifest(String name, DataFile dataFile) {
        this();
        setName(name);
        setDataFile(dataFile);
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set
     */
    @Required
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     * 
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets data file.
     * 
     * @return the dataFile
     */
    public DataFile getDataFile() {
        return dataFile;
    }

    /**
     * Sets data file.
     * 
     * @param dataFile
     *            the dataFile to set
     */
    @Required
    public void setDataFile(DataFile dataFile) {
        this.dataFile = dataFile;
    }

    /**
     * Sets datafile from a path.
     * 
     * @param datafile
     *            the path to the datafile
     */
    @Required
    public void setDatafile(String datafile) {
        setDataFile(new DataFile(datafile));
    }

    /**
     * Gets file size.
     * 
     * @return the datafileSize
     */
    public long getDatafileSize() {
        return datafileSize;
    }

    /**
     * Gets file checksum.
     * 
     * @return the datafileChecksum
     */
    public String getDatafileChecksum() {
        return datafileChecksum;
    }

    /**
     * Gets the URL.
     * 
     * @return the url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Gets the device class.
     * 
     * @return the deviceClass
     */
    public String getDeviceClass() {
        return deviceClass;
    }

    /**
     * Gets creation date.
     * 
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets last update date.
     * 
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Gets the timestamp.
     * 
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Gets a clone.
     * 
     * @return a clone
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public FirmwareManifest clone() throws CloneNotSupportedException {
        return new FirmwareManifest(id, url, deviceClass, createdAt, updatedAt, timestamp, name, description,
                datafileSize, datafileChecksum, dataFile);
    }

    /**
     * Determines whether the model instance is valid i.e. all required fields have been set.
     * 
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return name != null && dataFile != null;
    }
}
