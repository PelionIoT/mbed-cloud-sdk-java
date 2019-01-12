package pelion_cloud_sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.stream.StreamSupport;

import com.arm.mbed.cloud.sdk.Sdk;
import com.arm.mbed.cloud.sdk.accounts.model.AccountDao;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUser;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserDao;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.devices.model.DeviceDao;
import com.arm.mbed.cloud.sdk.devices.model.DeviceState;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerConfig;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class FoundationsExamples extends AbstractExample {

    /**
     * Creates and manages a sub-tenant account.
     */

    @Example
    public void manageSubtenants() {
        // an example: creating and managing a subtenant account
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Fetch my account
            AccountDao myAccountDao = sdk.daos().getAccountDao();
            myAccountDao.me(null, null);
            // Create a new User
            SubtenantUser user = new SubtenantUser();
            user.setAccountId(myAccountDao.getId());
            user.setFullName("tommi the wombat");
            user.setEmail("tommi_the_wombat@email.com");
            user.setUsername("tommi_wombat");
            user.setPhoneNumber("0800001066");
            SubtenantUserDao userDao = sdk.daos().getSubtenantUserDao();
            // cloak
            // Perform some account cleanup
            performAccountCleanup(myAccountDao, user, userDao);
            // uncloak
            userDao.create(user);
            // Find this added user in my account user list.
            String createdId = userDao.getId();
            // cloak
            assertNotNull(createdId);
            // uncloak
            // Fetch latest details of the current sub-tenant user.
            userDao.read();
            // Fetching a user from the list of account users
            SubtenantUser correspondingUser = StreamSupport.stream(myAccountDao.allUsers(null, null, null, null, null,
                                                                                         null)
                                                                               .spliterator(),
                                                                   false)
                                                           .filter(u -> u.getId().equals(createdId)).findFirst().get();
            // cloak
            assertEquals(userDao.getModel(), correspondingUser);
            // uncloak
            // Delete the created user.
            userDao.delete();

        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

    private void performAccountCleanup(AccountDao myAccountDao, SubtenantUser user,
                                       SubtenantUserDao userDao) throws MbedCloudException {
        StreamSupport.stream(myAccountDao.allUsers(null, null, null, null, null, null).spliterator(), false)
                     .filter(u -> user.getUsername().equals(u.getUsername())).forEach(u -> {
                         try {
                             userDao.delete(u);
                         } catch (MbedCloudException exception) {
                             exception.printStackTrace();
                         }
                     });
    }

    /**
     * Renews a device certificate
     */
    @Example
    public void renewCertificate() {
        // example: certificate renew
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Find the certificate issuers configuration in use. In this case, it is known that the reference is
            // "LWM2M".
            CertificateIssuerConfig myConfig = StreamSupport.stream(sdk.daos().getCertificateIssuerConfigListDao()
                                                                       .getPaginator().spliterator(),
                                                                    false)
                                                            .filter(c -> c.getCertificateReference().equals("LWM2M"))
                                                            .findFirst().get();
            // Get a device DAO
            final DeviceDao deviceDao = sdk.daos().getDeviceDao();
            // Renew the certificate of all connected devices
            StreamSupport.stream(sdk.daos().getDeviceListDao().paginator().spliterator(), false)
                         .filter(d -> d.getState() == DeviceState.REGISTERED).forEach(d -> {
                             // Configure the DAO with the model of interest
                             try {
                                 deviceDao.setModel(d);
                                 deviceDao.renewCertificate(myConfig.getCertificateReference());
                                 System.out.println(myConfig + " could not be renewed on " + d);
                             } catch (MbedCloudException exception) {
                                 // TODO do something with the exception
                                 System.out.println(myConfig + " could not be renewed on " + d);
                             }

                         });

        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }

    }

}
