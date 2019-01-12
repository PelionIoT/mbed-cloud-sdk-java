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
import com.arm.mbed.cloud.sdk.common.dao.CreateDao;
import com.arm.mbed.cloud.sdk.common.dao.DeleteDao;
import com.arm.mbed.cloud.sdk.common.dao.ReadDao;

/**
 * Data Access Object (DAO) for developer certificates.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for developer certificates.")
public class DeveloperCertificateDao extends AbstractModelDao<DeveloperCertificate>
                                     implements CreateDao<DeveloperCertificate>, DeleteDao<DeveloperCertificate>,
                                     ReadDao<DeveloperCertificate> {
    /**
     * Constructor.
     */
    public DeveloperCertificateDao() throws MbedCloudException {
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
    public DeveloperCertificateDao clone() {
        try {
            return new DeveloperCertificateDao().configureAndGet(module == null ? null : module.clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * Adds a developer certificate.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#createDeveloperCertificate(DeveloperCertificate)}
     */
    @Override
    public void create() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).createDeveloperCertificate(getModel()));
    }

    /**
     * Adds a developer certificate.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#createDeveloperCertificate(DeveloperCertificate)}
     * 
     * @param developerCertificate
     *            a developer certificate.
     */
    @Override
    public void create(@NonNull DeveloperCertificate developerCertificate) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(developerCertificate);
        create();
    }

    /**
     * Deletes a developer certificate.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#deleteDeveloperCertificate(DeveloperCertificate)}
     */
    @Override
    public void delete() throws MbedCloudException {
        checkDaoConfiguration();
        ((Security) module).deleteDeveloperCertificate(getModel());
    }

    /**
     * Deletes a developer certificate.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#deleteDeveloperCertificate(DeveloperCertificate)}
     * 
     * @param developerCertificate
     *            a developer certificate.
     */
    @Override
    public void delete(@NonNull DeveloperCertificate developerCertificate) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(developerCertificate);
        delete();
    }

    /**
     * Deletes a developer certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#deleteDeveloperCertificate(String)}
     * 
     * @param id
     *            The ID of the trusted certificate to be deleted.
     */
    @Override
    public void delete(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        ((Security) module).deleteDeveloperCertificate(id);
    }

    /**
     * Get trusted certificate by ID.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#getTrustedCertificateInfo(DeveloperCertificate)}
     * 
     * @return something
     */
    public TrustedCertificate getTrustedCertificateInfo() throws MbedCloudException {
        checkDaoConfiguration();
        return ((Security) module).getTrustedCertificateInfo(getModel());
    }

    /**
     * Get trusted certificate by ID.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#getTrustedCertificateInfo(String)}
     * 
     * @param id
     *            Entity ID.
     * @return something
     */
    public TrustedCertificate getTrustedCertificateInfo(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        return ((Security) module).getTrustedCertificateInfo(id);
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected DeveloperCertificate instantiateModel() {
        return new DeveloperCertificate();
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
     * Gets a developer certificate.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#getDeveloperCertificate(DeveloperCertificate)}
     */
    @Override
    public void read() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).getDeveloperCertificate(getModel()));
    }

    /**
     * Gets a developer certificate.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.security.model.DeveloperCertificate#getDeveloperCertificate(String)}
     * 
     * @param id
     *            mUUID that uniquely identifies the developer certificate.
     */
    @Override
    public void read(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).getDeveloperCertificate(id));
    }
}
