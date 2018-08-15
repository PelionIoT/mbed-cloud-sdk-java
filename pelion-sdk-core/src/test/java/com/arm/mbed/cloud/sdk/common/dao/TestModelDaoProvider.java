package com.arm.mbed.cloud.sdk.common.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ApiMetadata;
import com.arm.mbed.cloud.sdk.common.ApiModule;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkLogger;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

public class TestModelDaoProvider {

    @Test
    public void testGetCorrespondingDaoClassOfT() {
        Class<?> foundClass = ModelDaoProvider.getCorrespondingDao(ModelTest.class);
        assertNotNull(foundClass);
        assertEquals(ModelTestDao.class, foundClass);
    }

    @Test
    public void testGetCorrespondingDaoT() {
        ModelDao<?> foundDao;
        try {
            ModelTest aModel = new ModelTest();
            foundDao = ModelDaoProvider.getCorrespondingDao(aModel);
            assertNotNull(foundDao);
            assertEquals(ModelTestDao.class, foundDao.getClass());
            assertEquals(aModel, foundDao.getModel());
            String anId = "An Id";
            foundDao.setId(anId);
            assertEquals(anId, foundDao.getId());
            String cloudHost = "http://testHost/";
            String anApiKey = "testApiKey";
            foundDao.configure(ConnectionOptions.newConfiguration(anApiKey).host(cloudHost));
            assertEquals(anApiKey, foundDao.getModule().getClient().getConnectionOptions().getApiKey());
            assertEquals(cloudHost, foundDao.getModule().getClient().getConnectionOptions().getHost());
        } catch (MbedCloudException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    public void testGetCorrespondingListDaoClassOfT() {
        Class<?> foundClass = ModelDaoProvider.getCorrespondingListDao(ModelTest.class);
        assertNotNull(foundClass);
        assertEquals(ModelTestListDao.class, foundClass);
    }

    @Test
    public void testGetCorrespondingListDaoClassOfTU() {
        ModelTestListDao foundDao;
        try {
            ListOptions someOptions = new ListOptions().maxResults(454);
            foundDao = ModelDaoProvider.getCorrespondingListDao(ModelTest.class, someOptions);
            assertNotNull(foundDao);
            assertEquals(ModelTestListDao.class, foundDao.getClass());
            assertEquals(someOptions, foundDao.getListOptions());
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
        protected ApiModule instantiateModule(ConnectionOptions options) {
            final ConnectionOptions finalOptions = options;
            return new ApiModule() {

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
                    return new ApiClientWrapper(finalOptions);
                }
            };
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
        protected ApiModule instantiateModule(ConnectionOptions options) {
            return null;
        }

    }
}
