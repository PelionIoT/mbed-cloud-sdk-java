package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Firmware Manifest")
public class FirmwareManifest {

    /**
     * The ID of the firmware manifest
     */
    private String id;
    /**
     * The URL of the firmware manifest
     */
    private final URL url;
    /**
     * The class of device
     */
    private final String deviceClass;
    /**
     * The contents of the manifest
     */
    private final ManifestContents contents;
    /**
     * The time the object was created
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The time the object was updated
     */
    @DefaultValue(value = "now()")
    private final Date updatedAt;
    /**
     * The version of the firmware manifest (as a timestamp)
     */
    @DefaultValue(value = "now()")
    private final Date timestamp;

    /**
     * The name of the object
     */
    private String name;
    /**
     * The description of the object
     */
    private String description;
    /**
     * The binary file of the manifest
     */
    private DataFile dataFile;

    @Internal
    public FirmwareManifest(String id, URL url, String deviceClass, ManifestContents contents, Date createdAt,
            Date updatedAt, Date timestamp) {
        super();
        setId(id);
        this.url = url;
        this.deviceClass = deviceClass;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.timestamp = timestamp;
        setName(null);
        setDescription(null);
        setDataFile(null);
    }

    public FirmwareManifest() {
        this(null, null, null, null, new Date(), new Date(), new Date());
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the dataFile
     */
    public DataFile getDataFile() {
        return dataFile;
    }

    /**
     * @param dataFile
     *            the dataFile to set
     */
    public void setDataFile(DataFile dataFile) {
        this.dataFile = dataFile;
    }

    /**
     * Sets datafile from a path
     * 
     * @param datafile
     *            the path to the datafile
     */
    public void setDatafile(String datafile) {
        setDataFile(new DataFile(datafile));
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * @return the deviceClass
     */
    public String getDeviceClass() {
        return deviceClass;
    }

    /**
     * @return the contents
     */
    public ManifestContents getContents() {
        return contents;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

}
