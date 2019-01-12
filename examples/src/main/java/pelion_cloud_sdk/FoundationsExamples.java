package pelion_cloud_sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.stream.StreamSupport;

import com.arm.mbed.cloud.sdk.Sdk;
import com.arm.mbed.cloud.sdk.accounts.model.AccountDao;
import com.arm.mbed.cloud.sdk.accounts.model.AccountStatus;
import com.arm.mbed.cloud.sdk.accounts.model.ApiKey;
import com.arm.mbed.cloud.sdk.accounts.model.ApiKeyListDao;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUser;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserDao;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.devices.model.DeviceDao;
import com.arm.mbed.cloud.sdk.devices.model.DeviceState;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerConfig;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class FoundationsExamples extends AbstractExample {
    /**
     * Checks my account status.
     */
    @Example
    public void checkAccountStatus() {
        // example: checking account status
        try {
            // Fetch my account
            AccountDao myAccountDao = new AccountDao().configureAndGet(Configuration.get());
            myAccountDao.me(null, null);
            // Print my account detail
            System.out.println(myAccountDao.getModel());
            boolean isActive = myAccountDao.getModel().getStatus() == AccountStatus.ACTIVE;
            // cloack
            assertTrue(isActive);
            // uncloack
        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

    /**
     * Lists API keys.
     */
    @Example
    public void listApiKeys() {
        // example: listing api keys
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Iterate over all API keys and print their value
            // In case you do not know the name/class of the DAO to use, you can use the DAO provider which will fetch
            // the corresponding DAO using reflection.
            sdk.daos().getDaoProvider().getCorrespondingListDao(ApiKey.class, null).paginator()
               .forEach(System.out::println);
        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

    /**
     * Uses multiple API keys.
     */
    @Example
    public void useMultipleApiKeys() {
        // example: using multiple api keys
        // Configure the SDK to use a specific host.
        try {
            ApiKeyListDao dao1 = new ApiKeyListDao();
            dao1.configure(ConnectionOptions.newConfiguration("API Key 1 xxxxxx"));
            ApiKeyListDao dao2 = dao1.clone();
            // cloak
            assertEquals(dao1, dao2);
            assertNotSame(dao1, dao2);
            assertEquals(dao1.getContext().getConnectionOption(), dao2.getContext().getConnectionOption());
            // uncloak
            dao2.configure(ConnectionOptions.newConfiguration("API Key 2 xxxxxx"));
            // cloak
            assertNotEquals(dao1, dao2);
            assertNotEquals(dao1.getContext().getConnectionOption(), dao2.getContext().getConnectionOption());
            // uncloak
            dao1.paginator().forEach(System.out::println);
            dao2.paginator().forEach(System.out::println);
            // cloak
            fail("The host is fake");
            // uncloak
        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
        }
        // end of example
    }

    /**
     * Uses a custom host.
     */
    @Example
    public void useCustomHost() {
        // example: using custom hosts
        // Configure the SDK to use a specific host.
        try (Sdk sdk = Sdk.createSdk(ConnectionOptions.newConfiguration("an API key xxxxxx", "https://example.host"))) {
            // cloack
            sdk.getClient().setRequestTimeout(new TimePeriod(1));
            // uncloack
            // TODO some action
            sdk.daos().getDaoProvider().getCorrespondingListDao(ApiKey.class, null).paginator()
               .forEach(System.out::println);
            // cloak
            fail("The host is fake");
            // uncloak
        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
        }
        // end of example
    }

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
        // end of example
    }

}
