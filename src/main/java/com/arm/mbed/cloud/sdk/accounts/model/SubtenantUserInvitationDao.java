// This file was generated by the Pelion SDK foundation code generator.
// This model class was autogenerated on Wed Jan 23 19:22:16 GMT 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.NotImplementedException;

/**
 * Data Access Object (DAO) for subtenant user invitations.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for subtenant user invitations.")
public class SubtenantUserInvitationDao extends AbstractSubtenantUserInvitationDao {
    /**
     * Constructor.
     */
    public SubtenantUserInvitationDao() throws MbedCloudException {
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
    public SubtenantUserInvitationDao clone() {
        try {
            return new SubtenantUserInvitationDao().configureAndGet(getModuleOrThrow() == null ? null
                                                                                               : getModuleOrThrow().clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * Executes create.
     * 
     * @return something
     */
    @Override
    public SubtenantUserInvitation create() throws MbedCloudException, NotImplementedException {
        // TODO Auto-generated method stub.;
        throw new NotImplementedException();
    }

    /**
     * Executes create.
     * 
     * @param modelToCreate
     *            an sdk model.
     * @return something
     */
    @Override
    public SubtenantUserInvitation create(SubtenantUserInvitation modelToCreate) throws MbedCloudException,
                                                                                 NotImplementedException {
        // TODO Auto-generated method stub.;
        throw new NotImplementedException();
    }

    /**
     * Executes delete.
     * 
     * @param id
     *            a string.
     */
    @Override
    public void delete(String id) throws MbedCloudException, UnsupportedOperationException, NotImplementedException {
        // TODO Auto-generated method stub.;
        throw new NotImplementedException();
    }

    /**
     * Executes get.
     * 
     * @param id
     *            a string.
     * @return something
     */
    @Override
    public SubtenantUserInvitation read(String id) throws MbedCloudException, UnsupportedOperationException,
                                                   NotImplementedException {
        // TODO Auto-generated method stub.;
        throw new NotImplementedException();
    }
}
