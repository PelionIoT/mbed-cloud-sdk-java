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
import com.arm.mbed.cloud.sdk.common.dao.ReadDao;

/**
 * Data Access Object (DAO) for certificate enrollments.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for certificate enrollments.")
public class CertificateEnrollmentDao extends AbstractModelDao<CertificateEnrollment>
                                      implements ReadDao<CertificateEnrollment> {
    /**
     * Constructor.
     */
    public CertificateEnrollmentDao() throws MbedCloudException {
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
    public CertificateEnrollmentDao clone() {
        try {
            return new CertificateEnrollmentDao().configureAndGet(getModuleOrThrow() == null ? null
                                                                                             : getModuleOrThrow().clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * Gets a certificate enrollment.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.CertificateEnrollment#getCertificateEnrollment(CertificateEnrollment)}
     * 
     * @return something
     */
    @Override
    public CertificateEnrollment get() throws MbedCloudException {
        setModel(((Security) getModuleOrThrow()).getCertificateEnrollment(getModel()));
        return getModel();
    }

    /**
     * Gets a certificate enrollment.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.security.model.CertificateEnrollment#getCertificateEnrollment(String)}
     * 
     * @param id
     *            The ID of the certificate enrollment.
     * @return something
     */
    @Override
    public CertificateEnrollment get(@NonNull String id) throws MbedCloudException {
        setModel(((Security) getModuleOrThrow()).getCertificateEnrollment(id));
        return getModel();
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected CertificateEnrollment instantiateModel() {
        return new CertificateEnrollment();
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
     * Gets a certificate enrollment.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#getCertificateEnrollment(CertificateEnrollment)}
     */
    @Override
    public void read() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).getCertificateEnrollment(getModel()));
    }

    /**
     * Gets a certificate enrollment.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Security#getCertificateEnrollment(String)}
     * 
     * @param id
     *            The ID of the certificate enrollment.
     */
    @Override
    public void read(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).getCertificateEnrollment(id));
    }
}
