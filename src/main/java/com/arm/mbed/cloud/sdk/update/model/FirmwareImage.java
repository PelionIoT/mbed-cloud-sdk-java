package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Firmware Image")
public class FirmwareImage implements SDKModel {
    /**
     * 
     */
    private static final long serialVersionUID = 4822611919285826743L;
    /**
     * The ID of the firmware image
     */
    private String id;
    /**
     * The name of the object
     */
    private String name;
    /**
     * The description of the object
     */
    private String description;
    /**
     * The binary file of firmware image
     */
    private DataFile dataFile;
    /**
     * the size in bytes of the uploaded firmware image binary
     */
    @DefaultValue(value = "0")
    private final long datafileSize;
    /**
     * Checksum generated for the datafile
     */
    private final String datafileChecksum;
    /**
     * The URL of the firmware image
     */
    private final URL url;
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

    @Internal
    public FirmwareImage(String id, URL url, String datafileChecksum, long datafileSize, Date createdAt,
            Date updatedAt) {
        this(id, null, null, null, datafileSize, datafileChecksum, url, createdAt, updatedAt);
    }

    @Internal
    public FirmwareImage(String id, String name, String description, DataFile dataFile, long datafileSize,
            String datafileChecksum, URL url, Date createdAt, Date updatedAt) {
        super();
        setId(id);
        this.datafileSize = datafileSize;
        this.datafileChecksum = datafileChecksum;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        setDataFile(dataFile);
        setDescription(description);
        setName(name);
    }

    public FirmwareImage() {
        this(null, null, null, 0, new Date(), new Date());
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
     * @return the datafileSize
     */
    public long getDatafileSize() {
        return datafileSize;
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
     * @return the datafileChecksum
     */
    public String getDatafileChecksum() {
        return datafileChecksum;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public FirmwareImage clone() throws CloneNotSupportedException {
        return new FirmwareImage(id, name, description, dataFile, datafileSize, datafileChecksum, url, createdAt,
                updatedAt);
    }

}
