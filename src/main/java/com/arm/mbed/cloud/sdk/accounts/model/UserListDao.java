// This file was generated by the Pelion SDK foundation code generator.
// This model class was autogenerated on Fri Jan 11 01:52:39 GMT 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.NotImplementedException;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

/**
 * Data Access Object (DAO) for listing users.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for listing users.")
public class UserListDao extends AbstractUserListDao {
    /**
     * Constructor.
     */
    public UserListDao() throws MbedCloudException {
        super();
    }

    /**
     * Lists users matching filter options.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.User#listUsers(String,String,String,String,String,UserListOptions)}
     * 
     * @param options
     *            list options.
     * @return one page of users
     */
    @Override
    protected ListResponse<User> requestOnePage(UserListOptions options) throws MbedCloudException,
                                                                         NotImplementedException {
        // TODO Auto-generated method stub.;
        throw new NotImplementedException();
        // The following code is auto-generated and can be used if carrying out what requestOnePage() intends/is meant
        // to do.

        /*
         * checkDaoConfiguration(); return ((Accounts)module).listUsers(null, null, null, null, null, options);
         */
    }

    /**
     * Clones this instance.
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public UserListDao clone() {
        try {
            return new UserListDao().configureAndGet(module == null ? null : module.clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }
}
