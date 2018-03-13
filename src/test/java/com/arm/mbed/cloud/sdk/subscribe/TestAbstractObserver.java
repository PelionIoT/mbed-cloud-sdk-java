package com.arm.mbed.cloud.sdk.subscribe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class TestAbstractObserver {

    @Test
    public void testNotifyT() {
        fail("Not yet implemented");
    }

    @Test
    public void testNotifyNotificationMessageOfT() {
        fail("Not yet implemented");
    }

    @Test
    public void testAddRemoveCallback() {
        SubscriptionTestManagerFixedInput manager = new SubscriptionTestManagerFixedInput(false);
        TestObserver obs = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                BackpressureStrategy.BUFFER);
        // Only storing even numbers.
        List<Integer> evenValuesCallback1 = new LinkedList<>();
        // Only storing multiple of 10.
        List<Integer> evenValuesCallback2 = new LinkedList<>();
        Callback<Throwable> onFailureCallback = new Callback<Throwable>() {

            @Override
            public void execute(Throwable arg) {
                arg.printStackTrace();
                fail(arg.getMessage());
            }
        };
        obs.addCallback(new NotificationCallback<>(new Callback<NotificationTestMessageValue>() {

            @Override
            public void execute(NotificationTestMessageValue arg) {
                evenValuesCallback1.add(arg.getValue());
            }
        }, onFailureCallback));
        assertEquals(1, obs.numberOfCallbacks());
        obs.addCallback(new NotificationCallback<>(new Callback<NotificationTestMessageValue>() {

            @Override
            public void execute(NotificationTestMessageValue arg) {
                if (arg.getValue().intValue() % 5 == 0) {
                    evenValuesCallback2.add(arg.getValue());
                }

            }
        }, onFailureCallback));
        assertEquals(2, obs.numberOfCallbacks());
        obs.flow().blockingSubscribe();
        // the first list should only contain even numbers from 0 to 100 included.
        assertEquals(51, evenValuesCallback1.size());
        // the second list should only contain multiples of 10 from 0 to 100 included.
        assertEquals(11, evenValuesCallback2.size());
        // the first list should only contain even numbers.
        for (int i = 0; i < evenValuesCallback1.size(); i++) {
            assertEquals(i * 2, evenValuesCallback1.get(i).intValue());
        }
        // the second list should only contain multiples of 10.
        for (int i = 0; i < evenValuesCallback2.size(); i++) {
            assertEquals(i * 10, evenValuesCallback2.get(i).intValue());
        }
        assertFalse(obs.isDisposed());
        obs.unsubscribe();
        assertTrue(obs.isDisposed());
        assertEquals(0, obs.numberOfCallbacks());
    }

    @Test
    public void testUnsubscribe() {
        fail("Not yet implemented");
    }

    @Test
    public void testFlow() {
        fail("Not yet implemented");
    }

    @Test
    public void testFutureOne() {
        SubscriptionTestManagerFixedInput manager = new SubscriptionTestManagerFixedInput(true);
        TestObserver obs = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                BackpressureStrategy.BUFFER);
        try {
            Future<NotificationTestMessageValue> future = obs.futureOne();
            NotificationTestMessageValue value = future.get(5, TimeUnit.SECONDS);
            // Value should be the last element received.
            assertEquals(100, value.i);
            assertTrue(obs.isDisposed());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testOne() {
        SubscriptionTestManagerFixedInput manager = new SubscriptionTestManagerFixedInput(true);
        TestObserver obs = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                BackpressureStrategy.BUFFER);
        try {
            NotificationTestMessageValue value = obs.one(new TimePeriod(5));
            // Value should be the last element received.
            assertEquals(100, value.i);
            assertTrue(obs.isDisposed());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        // Checking that timeout works properly.
        SubscriptionTestManagerNeverInput manager2 = new SubscriptionTestManagerNeverInput(true);
        obs = manager2.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null, BackpressureStrategy.BUFFER);
        long start = 0;
        try {
            start = System.currentTimeMillis();
            NotificationTestMessageValue value = obs.one(new TimePeriod(2));
            assertNull(value);
            // Value should never be received.
        } catch (MbedCloudException e) {
            double time = (System.currentTimeMillis() - start) / 1000d;
            assertNotNull(e);
            assertEquals("The value could not be retrieved", e.getMessage());
            // Check that at least 2 seconds elapsed before the exception was thrown.
            assertTrue(time > 2);
            // Check that the timeout was of the right order of magnitude.
            assertTrue(time < 5);
        }
    }

    private static class NotificationTestMessageValue implements NotificationMessageValue {

        /**
         * 
         */
        private static final long serialVersionUID = 7830585451465562472L;

        private final int i;

        public NotificationTestMessageValue(int i) {
            super();
            this.i = i;
        }

        /**
         * @return the i
         */
        public Integer getValue() {
            return new Integer(i);
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#clone()
         */
        @Override
        public NotificationTestMessageValue clone() {
            return new NotificationTestMessageValue(i);
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "NotificationTestMessageValue [i=" + i + "]";
        }

    }

    private static class TestObserver extends AbstractObserver<NotificationTestMessageValue> {

        public TestObserver(SubscriptionManager manager, String id, Flowable<NotificationTestMessageValue> flow,
                FilterOptions filter, boolean mustUnsubscribeOnCompletion) {
            super(manager, id, flow, filter, mustUnsubscribeOnCompletion);
        }

        @Override
        public SubscriptionType getSubscriptionType() {
            return SubscriptionType.DEVICE_STATE_CHANGE;
        }

        @SuppressWarnings("boxing")
        @Override
        protected boolean verifiesFilter(NotificationTestMessageValue t) {
            // Only even numbers are observed
            return t.getValue() % 2 == 0;
        }

    }

    private static abstract class AbstractTestSubscriptionManager implements SubscriptionManager {
        Map<String, Observer<?>> observers = new Hashtable<>(4);
        protected final boolean unsubscribeOnCompletion;

        protected AbstractTestSubscriptionManager(boolean unsubscribeOnCompletion) {
            super();
            this.unsubscribeOnCompletion = unsubscribeOnCompletion;
        }

        @Override
        public List<Observer<?>> listAll() {
            return new ArrayList<>(observers.values());
        }

        @Override
        public List<Observer<?>> listAll(SubscriptionType type) {
            return listAll();
        }

        @Override
        public void unsubscribeAll() {
            observers.clear();
        }

        @Override
        public void unsubscribeAll(SubscriptionType type) {
            unsubscribeAll();
        }

        @Override
        public void unsubscribe(SubscriptionType type, String observerId) {
            observers.remove(observerId);
        }

        @Override
        public void unsubscribe(Observer<?> observer) {
            if (observer == null) {
                return;
            }
            unsubscribe(observer.getSubscriptionType(), observer.getId());

        }

        @Override
        public Scheduler getObservedOnExecutor() {
            return Schedulers.computation();
        }

    }

    private static class SubscriptionTestManagerFixedInput extends AbstractTestSubscriptionManager {

        private SubscriptionTestManagerFixedInput(boolean unsubscribeOnCompletion) {
            super(unsubscribeOnCompletion);
        }

        @Override
        public TestObserver createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy) {
            @SuppressWarnings("boxing")
            final Flowable<NotificationTestMessageValue> flow = Flowable.range(0, 102)
                    .map(i -> new NotificationTestMessageValue(i));
            final String id = "testObserver_" + UuidGenerator.generate();
            final TestObserver obs = new TestObserver(this, id, flow, null, unsubscribeOnCompletion);
            observers.put(id, obs);
            return obs;
        }

        @Override
        public <T extends NotificationMessageValue> void notify(SubscriptionType type, NotificationMessage<T> message)
                throws MbedCloudException {
            // No new notification can be added
        }

        @Override
        public <T extends NotificationMessageValue> void notify(SubscriptionType type, String channelId,
                NotificationMessage<T> message) throws MbedCloudException {
            // No new notification can be added

        }

    }

    private static class SubscriptionTestManagerNeverInput extends AbstractTestSubscriptionManager {

        private SubscriptionTestManagerNeverInput(boolean unsubscribeOnCompletion) {
            super(unsubscribeOnCompletion);
        }

        @Override
        public TestObserver createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy) {
            final Flowable<NotificationTestMessageValue> flow = Flowable.never();
            final String id = "testObserver_" + UuidGenerator.generate();
            final TestObserver obs = new TestObserver(this, id, flow, null, unsubscribeOnCompletion);
            observers.put(id, obs);
            return obs;
        }

        @Override
        public <T extends NotificationMessageValue> void notify(SubscriptionType type, NotificationMessage<T> message)
                throws MbedCloudException {
            // No new notification can be added
        }

        @Override
        public <T extends NotificationMessageValue> void notify(SubscriptionType type, String channelId,
                NotificationMessage<T> message) throws MbedCloudException {
            // No new notification can be added

        }

    }

}
