// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.Security;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.CrudDao;

/**
 * Data Access Object (DAO) for trusted certificates.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for trusted certificates.")
public class TrustedCertificateDao extends AbstractModelDao<TrustedCertificate> implements CrudDao<TrustedCertificate> {
    /**
     * Constructor.
     */
    public TrustedCertificateDao() throws MbedCloudException {
        super();
    }

    /**
     * Clones this instance.
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public TrustedCertificateDao clone() {
        try {
            return new TrustedCertificateDao().configureAndGet(getModuleOrThrow() == null ? null
                                                                                          : getModuleOrThrow().clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * Adds a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#createTrustedCertificate(TrustedCertificate)}
     */
    @Override
    public TrustedCertificate create() throws MbedCloudException {
        setModel(((Security) getModuleOrThrow()).createTrustedCertificate(getModel()));
        return getModel();
    }

    /**
     * Adds a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#createTrustedCertificate(TrustedCertificate)}
     * 
     * @param trustedCertificate
     *            a trusted certificate.
     * @return an added trusted certificate
     */
    @Override
    public TrustedCertificate create(@NonNull TrustedCertificate trustedCertificate) throws MbedCloudException {
        setModel(trustedCertificate);
        return create();
    }

    /**
     * Deletes a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#deleteTrustedCertificate(TrustedCertificate)}
     */
    @Override
    public void delete() throws MbedCloudException {
        ((Security) getModuleOrThrow()).deleteTrustedCertificate(getModel());
    }

    /**
     * Deletes a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#deleteTrustedCertificate(TrustedCertificate)}
     * 
     * @param trustedCertificate
     *            a trusted certificate.
     */
    @Override
    public void delete(@NonNull TrustedCertificate trustedCertificate) throws MbedCloudException {
        setModel(trustedCertificate);
        delete();
    }

    /**
     * Deletes a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#deleteTrustedCertificate(String)}
     * 
     * @param id
     *            The ID of the trusted certificate to be deleted.
     */
    @Override
    public void delete(@NonNull String id) throws MbedCloudException {
        ((Security) getModuleOrThrow()).deleteTrustedCertificate(id);
    }

    /**
     * Gets a trusted certificate.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.TrustedCertificate#getTrustedCertificate(TrustedCertificate)}
     * 
     * @return something
     */
    @Override
    public TrustedCertificate get() throws MbedCloudException {
        setModel(((Security) getModuleOrThrow()).getTrustedCertificate(getModel()));
        return getModel();
    }

    /**
     * Gets a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.security.model.TrustedCertificate#getTrustedCertificate(String)}
     * 
     * @param id
     *            Entity ID.
     * @return something
     */
    @Override
    public TrustedCertificate get(@NonNull String id) throws MbedCloudException {
        setModel(((Security) getModuleOrThrow()).getTrustedCertificate(id));
        return getModel();
    }

    /**
     * Fetch an existing developer certificate to connect to the bootstrap server.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#getDeveloperCertificateInfo(TrustedCertificate)}
     * 
     * @return something
     */
    public DeveloperCertificate getDeveloperCertificateInfo() throws MbedCloudException {
        return ((Security) getModuleOrThrow()).getDeveloperCertificateInfo(getModel());
    }

    /**
     * Fetch an existing developer certificate to connect to the bootstrap server.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#getDeveloperCertificateInfo(String)}
     * 
     * @param id
     *            mUUID that uniquely identifies the developer certificate.
     * @return something
     */
    public DeveloperCertificate getDeveloperCertificateInfo(@NonNull String id) throws MbedCloudException {
        return ((Security) getModuleOrThrow()).getDeveloperCertificateInfo(id);
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected TrustedCertificate instantiateModel() {
        return new TrustedCertificate();
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
        return new Security(context);
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
        return new Security(client);
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
        return new Security(options);
    }

    /**
     * Gets a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#getTrustedCertificate(TrustedCertificate)}
     */
    @Override
    public void read() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).getTrustedCertificate(getModel()));
    }

    /**
     * Gets a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#getTrustedCertificate(String)}
     * 
     * @param id
     *            Entity ID.
     */
    @Override
    public void read(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).getTrustedCertificate(id));
    }

    /**
     * Modifies a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#updateTrustedCertificate(TrustedCertificate)}
     */
    @Override
    public TrustedCertificate update() throws MbedCloudException {
        setModel(((Security) getModuleOrThrow()).updateTrustedCertificate(getModel()));
        return getModel();
    }

    /**
     * Modifies a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#updateTrustedCertificate(TrustedCertificate)}
     * 
     * @param trustedCertificate
     *            a trusted certificate.
     * @return something
     */
    @Override
    public TrustedCertificate update(@NonNull TrustedCertificate trustedCertificate) throws MbedCloudException {
        setModel(trustedCertificate);
        return update();
    }

    /**
     * Modifies a trusted certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#updateTrustedCertificate(String,TrustedCertificate)}
     * 
     * @param id
     *            Entity ID.
     * @return an updated trusted certificate
     */
    public TrustedCertificate update(@NonNull String id) throws MbedCloudException {
        setModel(((Security) getModuleOrThrow()).updateTrustedCertificate(id, getModel()));
        return getModel();
    }
}
