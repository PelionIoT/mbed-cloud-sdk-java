// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated abstract class. Do not modify its contents.
// Code customisation should happen in the child class [DarkThemeImageDao]
package com.arm.mbed.cloud.sdk.branding.model;

import com.arm.mbed.cloud.sdk.Branding;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.CreateDao;
import com.arm.mbed.cloud.sdk.common.dao.DeleteDao;
import com.arm.mbed.cloud.sdk.common.dao.ReadDao;
import com.arm.mbed.cloud.sdk.common.model.DataFile;

/**
 * Data Access Object (DAO) for dark theme images.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for dark theme images.")
public abstract class AbstractDarkThemeImageDao extends AbstractModelDao<DarkThemeImage>
                                                implements CreateDao<DarkThemeImage>, DeleteDao<DarkThemeImage>,
                                                ReadDao<DarkThemeImage> {
    /**
     * Constructor.
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public AbstractDarkThemeImageDao() throws MbedCloudException {
        super();
    }

    /**
     * Constructor.
     * 
     * @param client
     *            an api client wrapper.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public AbstractDarkThemeImageDao(ApiClientWrapper client) throws MbedCloudException {
        super(client);
    }

    /**
     * Constructor.
     * 
     * @param options
     *            a connection options.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public AbstractDarkThemeImageDao(ConnectionOptions options) throws MbedCloudException {
        super(options);
    }

    /**
     * Constructor.
     * 
     * @param sdkContext
     *            an sdk context.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public AbstractDarkThemeImageDao(SdkContext sdkContext) throws MbedCloudException {
        super(sdkContext);
    }

    /**
     * Adds a dark theme image.
     *
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.branding.model.DarkThemeImageDao#create(String, com.arm.mbed.cloud.sdk.common.model.DataFile, com.arm.mbed.cloud.sdk.branding.model.DarkThemeImage)}
     * 
     * @param accountId
     *            Account ID.
     * @param image
     *            The image in PNG or JPEG format as multipart form data.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public DarkThemeImage create(@NonNull String accountId, @NonNull DataFile image) throws MbedCloudException {
        return create(accountId, image, getModel());
    }

    /**
     * Adds a dark theme image.
     *
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Branding#createDarkThemeImage(String, com.arm.mbed.cloud.sdk.common.model.DataFile, com.arm.mbed.cloud.sdk.branding.model.DarkThemeImage)}
     * 
     * @param accountId
     *            Account ID.
     * @param image
     *            The image in PNG or JPEG format as multipart form data.
     * @param darkThemeImage
     *            a dark theme image.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public DarkThemeImage create(@NonNull String accountId, @NonNull DataFile image,
                                 @NonNull DarkThemeImage darkThemeImage) throws MbedCloudException {
        return setAndGetModel(((Branding) getModuleOrThrow()).createDarkThemeImage(accountId, image, darkThemeImage));
    }

    /**
     * Adds a dark theme image.
     *
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Branding#createDarkThemeImage(String, com.arm.mbed.cloud.sdk.common.model.DataFile, com.arm.mbed.cloud.sdk.branding.model.DarkThemeImageReference)}
     * 
     * @param accountId
     *            Account ID.
     * @param image
     *            The image in PNG or JPEG format as multipart form data.
     * @param reference
     *            Name of the image.
     * @return an added dark theme image
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public DarkThemeImage create(@NonNull String accountId, @NonNull DataFile image,
                                 @NonNull DarkThemeImageReference reference) throws MbedCloudException {
        return setAndGetModel(((Branding) getModuleOrThrow()).createDarkThemeImage(accountId, image, reference));
    }

    /**
     * Deletes a dark theme image.
     *
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.branding.model.DarkThemeImageDao#delete(com.arm.mbed.cloud.sdk.branding.model.DarkThemeImage)}
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public void delete() throws MbedCloudException {
        delete(getModel());
    }

    /**
     * Deletes a dark theme image.
     *
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Branding#deleteDarkThemeImage(com.arm.mbed.cloud.sdk.branding.model.DarkThemeImageReference)}
     * 
     * @param reference
     *            Name of the branding images (icon or picture).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public void delete(@NonNull DarkThemeImageReference reference) throws MbedCloudException {
        ((Branding) getModuleOrThrow()).deleteDarkThemeImage(reference);
    }

    /**
     * Deletes a dark theme image.
     *
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Branding#deleteDarkThemeImage(com.arm.mbed.cloud.sdk.branding.model.DarkThemeImage)}
     * 
     * @param darkThemeImage
     *            a dark theme image.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public void delete(@NonNull DarkThemeImage darkThemeImage) throws MbedCloudException {
        ((Branding) getModuleOrThrow()).deleteDarkThemeImage(darkThemeImage);
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected DarkThemeImage instantiateModel() {
        return new DarkThemeImage();
    }

    /**
     * Instantiates modules.
     * 
     * @param client
     *            an api client wrapper.
     * @return instantiated module
     */
    @Override
    @Internal
    protected SdkContext instantiateModule(ApiClientWrapper client) {
        return new Branding(client);
    }

    /**
     * Instantiates modules.
     * 
     * @param options
     *            a connection options.
     * @return instantiated module
     */
    @Override
    @Internal
    protected SdkContext instantiateModule(ConnectionOptions options) {
        return new Branding(options);
    }

    /**
     * Instantiates modules.
     * 
     * @param context
     *            an sdk context.
     * @return instantiated module
     */
    @Override
    @Internal
    protected SdkContext instantiateModule(SdkContext context) {
        return new Branding(context);
    }

    /**
     * Gets a dark theme image.
     *
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.branding.model.DarkThemeImageDao#read(com.arm.mbed.cloud.sdk.branding.model.DarkThemeImage)}
     * 
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public DarkThemeImage read() throws MbedCloudException {
        return read(getModel());
    }

    /**
     * Gets a dark theme image.
     *
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Branding#readDarkThemeImage(com.arm.mbed.cloud.sdk.branding.model.DarkThemeImageReference)}
     * 
     * @param reference
     *            Name of the image.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public DarkThemeImage read(@NonNull DarkThemeImageReference reference) throws MbedCloudException {
        return setAndGetModel(((Branding) getModuleOrThrow()).readDarkThemeImage(reference));
    }

    /**
     * Gets a dark theme image.
     *
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Branding#readDarkThemeImage(com.arm.mbed.cloud.sdk.branding.model.DarkThemeImage)}
     * 
     * @param darkThemeImage
     *            a dark theme image.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public DarkThemeImage read(@NonNull DarkThemeImage darkThemeImage) throws MbedCloudException {
        return setAndGetModel(((Branding) getModuleOrThrow()).readDarkThemeImage(darkThemeImage));
    }
}