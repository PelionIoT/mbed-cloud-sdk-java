package com.arm.mbed.cloud.sdk.common.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.SdkModel;

public class TestModelDao {

    @Test
    public void testModelManagement() {
        try (ModelDaoTest dao = new ModelDaoTest()) {
            assertNull(dao.getModel());
            assertNotNull(dao.getModelOrNew());
            assertNotNull(dao.getModel());
            assertNull(dao.getId());
            dao.setModel(null);
            assertFalse(dao.hasModel());
            assertNull(dao.getModel());
            String id = "AN ID";
            dao.setId(id);
            assertEquals(id, dao.getId());
            assertTrue(dao.hasModel());
            assertNotNull(dao.getModel());
            String value1 = "A value1";
            dao.getModel().setValue1(value1);
            assertEquals(value1, dao.getModel().getValue1());
        } catch (IOException | MbedCloudException exception) {
            exception.printStackTrace();
            fail(exception.getMessage());
        }
    }

    @Test
    public void testMultithreadingModelManagement() {
        try (ModelDaoTest dao = new ModelDaoTest()) {
            String id = "AN ID";
            String value1 = "value1";
            String value2 = "value2";
            String value3 = "value3";
            assertNull(dao.getModel());
            Thread t0 = new Thread(new Runnable() {

                @Override
                public void run() {
                    dao.setId(id);
                }
            });
            Thread t1 = new Thread(new Runnable() {

                @Override
                public void run() {
                    dao.setId(value1);
                    dao.getModel().setValue1(value1);
                }
            });
            Thread t2 = new Thread(new Runnable() {

                @Override
                public void run() {
                    dao.setId(value2);
                    dao.getModel().setValue2(value2);
                }
            });
            Thread t3 = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    dao.setId(value3);
                    dao.getModel().setValue3(value3);
                }
            });
            t0.start();
            t0.join();
            assertNotNull(dao.getModel());
            assertNotNull(dao.getId());
            assertEquals(id, dao.getId());
            t1.start();
            t2.start();
            t3.start();
            t3.join();
            t2.join();
            t1.join();
            assertEquals(value1, dao.getModel().getValue1());
            assertEquals(value2, dao.getModel().getValue2());
            assertEquals(value3, dao.getModel().getValue3());
            assertEquals(value3, dao.getId());

            AtomicBoolean failure = new AtomicBoolean(false);
            Thread t12 = new Thread(new Runnable() {

                @Override
                public void run() {
                    ModelTest test1 = new ModelTest();
                    test1.setValue1(value1);
                    ModelTest returnedModel = dao.setAndGetModel(test1);
                    if (returnedModel == null || !returnedModel.equals(test1)) {
                        failure.set(true);
                    }
                }
            });
            Thread t22 = new Thread(new Runnable() {

                @Override
                public void run() {
                    ModelTest test2 = new ModelTest();
                    test2.setValue2(value2);
                    ModelTest returnedModel = dao.setAndGetModel(test2);
                    if (returnedModel == null || !returnedModel.equals(test2)) {
                        failure.set(true);
                    }
                }
            });
            Thread t33 = new Thread(new Runnable() {

                @Override
                public void run() {
                    ModelTest test3 = new ModelTest();
                    test3.setValue3(value3);
                    ModelTest returnedModel = dao.setAndGetModel(test3);
                    if (returnedModel == null || !returnedModel.equals(test3)) {
                        failure.set(true);
                    }
                }
            });
            t12.start();
            t22.start();
            t33.start();
            t12.join();
            t22.join();
            t33.join();
            assertFalse(failure.get());

        } catch (IOException | MbedCloudException | InterruptedException exception) {
            exception.printStackTrace();
            fail(exception.getMessage());
        }
    }

    private static class ModelTest implements SdkModel {

        /**
         * 
         */
        private static final long serialVersionUID = -426608967333160891L;
        private String id;
        private String value1, value2, value3;

        public ModelTest(String id, String value1, String value2, String value3) {
            super();
            setId(id);
            setValue1(value1);
            setValue2(value2);
            setValue3(value3);
        }

        public ModelTest() {
            this(null, null, null, null);
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void setId(String id) {
            this.id = id;

        }

        @Override
        public ModelTest clone() {
            return new ModelTest(id, value1, value2, value3);
        }

        public String getValue1() {
            return value1;
        }

        public void setValue1(String value1) {
            this.value1 = value1;
        }

        public String getValue2() {
            return value2;
        }

        public void setValue2(String value2) {
            this.value2 = value2;
        }

        public String getValue3() {
            return value3;
        }

        public void setValue3(String value3) {
            this.value3 = value3;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((value1 == null) ? 0 : value1.hashCode());
            result = prime * result + ((value2 == null) ? 0 : value2.hashCode());
            result = prime * result + ((value3 == null) ? 0 : value3.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ModelTest other = (ModelTest) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            if (value1 == null) {
                if (other.value1 != null)
                    return false;
            } else if (!value1.equals(other.value1))
                return false;
            if (value2 == null) {
                if (other.value2 != null)
                    return false;
            } else if (!value2.equals(other.value2))
                return false;
            if (value3 == null) {
                if (other.value3 != null)
                    return false;
            } else if (!value3.equals(other.value3))
                return false;
            return true;
        }

    }

    private static class ModelDaoTest extends AbstractModelDao<ModelTest> {

        public ModelDaoTest() throws MbedCloudException {
            super();
        }

        @Override
        protected SdkContext instantiateModule(ConnectionOptions options) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        protected SdkContext instantiateModule(ApiClientWrapper client) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        protected SdkContext instantiateModule(SdkContext context) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public ModelDaoTest clone() {
            try {
                return new ModelDaoTest();
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
                return null;
            }
        }

    }
}
