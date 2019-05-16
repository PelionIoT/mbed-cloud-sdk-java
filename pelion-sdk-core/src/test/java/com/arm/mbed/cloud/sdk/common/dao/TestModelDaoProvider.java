package com.arm.mbed.cloud.sdk.common.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ApiMetadata;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.SdkLogger;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.common.listing.IdListResponse;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

public class TestModelDaoProvider {

    @Test
    public void testGetCorrespondingDaoClassOfT() {
        Class<?> foundClass = DaoProvider.getCorrespondingDao(ModelTest.class);
        assertNotNull(foundClass);
        assertEquals(ModelTestDao.class, foundClass);
    }

    @Test
    public void testGetCorrespondingDaoT() {
        try {
            ModelTest aModel = new ModelTest();
            @SuppressWarnings("resource")
            ModelDao<?> foundDao = DaoProvider.getCorrespondingGlobalDao(aModel);
            assertNotNull(foundDao);
            assertEquals(ModelTestDao.class, foundDao.getClass());
            assertEquals(aModel, foundDao.getModel());
            String anId = "An Id";
            foundDao.setId(anId);
            assertEquals(anId, foundDao.getId());
            String cloudHost = "http://testHost/";
            String anApiKey = "testApiKey";
            foundDao.configure(ConnectionOptions.newConfiguration(anApiKey).host(cloudHost));
            assertEquals(anApiKey, foundDao.getContext().getClient().getConnectionOptions().getApiKey());
            assertEquals(cloudHost, foundDao.getContext().getClient().getConnectionOptions().getHost());
            @SuppressWarnings("resource")
            ModelDao<?> daoWithContext = foundDao.getDaoProvider().getCorrespondingDao(aModel);
            assertEquals(anApiKey, daoWithContext.getContext().getClient().getConnectionOptions().getApiKey());
            assertEquals(cloudHost, daoWithContext.getContext().getClient().getConnectionOptions().getHost());

        } catch (MbedCloudException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    public void testGetCorrespondingListDaoClassOfT() {
        Class<?> foundClass = DaoProvider.getCorrespondingListDao(ModelTest.class);
        assertNotNull(foundClass);
        assertEquals(ModelTestListDao.class, foundClass);
    }

    @Test
    public void testGetCorrespondingListDaoClassOfTU() {
        try {
            ListOptions someOptions = new ListOptions().maxResults(454);
            @SuppressWarnings("resource")
            ModelTestListDao foundDao = DaoProvider.getCorrespondingGlobalListDao(ModelTest.class, someOptions);
            assertNotNull(foundDao);
            assertEquals(ModelTestListDao.class, foundDao.getClass());
            assertEquals(someOptions, foundDao.getListOptions());
            String cloudHost = "http://testHost/";
            String anApiKey = "testApiKey";
            foundDao.configure(ConnectionOptions.newConfiguration(anApiKey).host(cloudHost));
            @SuppressWarnings("resource")
            ModelTestListDao daoWithContext = foundDao.getDaoProvider().getCorrespondingListDao(ModelTest.class,
                                                                                                someOptions);
            assertEquals(anApiKey, daoWithContext.getContext().getClient().getConnectionOptions().getApiKey());
            assertEquals(cloudHost, daoWithContext.getContext().getClient().getConnectionOptions().getHost());
            assertEquals(someOptions, daoWithContext.getListOptions());
        } catch (MbedCloudException exception) {
            fail(exception.getMessage());
        }
    }

    public static class ModelTest implements SdkModel {
        /**
         *
         */
        private static final long serialVersionUID = 756856185376432103L;
        String id;

        public ModelTest() {
            super();
            id = null;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public void setId(String id) {
            this.id = id;
        }

        @Override
        public ModelTest clone() {
            return this;
        }
    }

    public static class ModelTestDao extends AbstractModelDao<ModelTest> {

        public ModelTestDao() throws MbedCloudException {
            super();
        }

        @Override
        protected SdkContext instantiateModule(ConnectionOptions options) {
            return generateApiModule(new ApiClientWrapper(options));
        }

        @Override
        protected SdkContext instantiateModule(ApiClientWrapper client) {
            return generateApiModule(client);
        }

        @Override
        protected SdkContext instantiateModule(SdkContext context) {
            return generateApiModule(context.getClient());
        }

        public static SdkContext generateApiModule(final ApiClientWrapper client) {
            return new SdkContext() {

                @Override
                public String getModuleName() {
                    return "Test Module";
                }

                @Override
                public SdkLogger getLogger() {
                    return SdkLogger.getLogger();
                }

                @Override
                public ApiMetadata getLastApiMetadata() {
                    return null;
                }

                @Override
                public ApiClientWrapper getClient() {
                    return client;
                }

                @Override
                public ServiceRegistry getServiceRegistry() {
                    return null;
                }

                @Override
                public SdkContext clone() {
                    return this;
                }

                @Override
                public ConnectionOptions getConnectionOption() {
                    return null;
                }

                @Override
                public void close() throws IOException {
                    // Nothing to do
                }
            };
        }

        @Override
        public CloudDao clone() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public static class ModelTestListDao extends AbstractModelListDao<ModelTest, ListOptions> {

        public ModelTestListDao() throws MbedCloudException {
            super();
        }

        @Override
        protected ListResponse<ModelTest> requestOnePage(ListOptions listOptions) {
            return null;
        }

        @Override
        protected SdkContext instantiateModule(ConnectionOptions options) {
            return ModelTestDao.generateApiModule(new ApiClientWrapper(options));
        }

        @Override
        protected IdListResponse requestOnePageOfIds(ListOptions listOptions) {
            return null;
        }

        @Override
        protected SdkContext instantiateModule(ApiClientWrapper client) {
            return ModelTestDao.generateApiModule(client);
        }

        @Override
        protected SdkContext instantiateModule(SdkContext context) {
            return ModelTestDao.generateApiModule(context.getClient());
        }

        @SuppressWarnings("unchecked")
        @Override
        public <V extends ModelDao<ModelTest>> Class<V> getModelDaoClass() {
            return (Class<V>) ModelTestDao.class;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <V extends ModelDao<ModelTest>> V getNewModelDao() {
            try {
                return (V) new ModelTestDao();
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
                return null;
            }
        }

        @Override
        public CloudDao clone() {
            // TODO Auto-generated method stub
            return null;
        }

    }
}
