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
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;

public class TestAbstractObserver {

    @SuppressWarnings("static-access")
    @Test
    public void testAddRemoveCallback() {
        SubscriptionTestManagerFixedInput manager = new SubscriptionTestManagerFixedInput(false);
        TestObserver obs = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                  BackpressureStrategy.BUFFER);
        assertFalse(obs.executedActionOnSubscription);
        assertEquals(0, obs.numberOfActionOnSubscription);
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
                evenValuesCallback1.add(((Integer) arg.getRawValue()));
            }
        }, onFailureCallback));
        assertTrue(obs.executedActionOnSubscription);
        assertEquals(1, obs.numberOfActionOnSubscription);
        assertEquals(1, obs.numberOfCallbacks());
        obs.addCallback(new NotificationCallback<>(new Callback<NotificationTestMessageValue>() {

            @Override
            public void execute(NotificationTestMessageValue arg) {
                if (((Integer) arg.getRawValue()).intValue() % 5 == 0) {
                    evenValuesCallback2.add(((Integer) arg.getRawValue()));
                }

            }
        }, onFailureCallback));
        assertEquals(2, obs.numberOfCallbacks());
        assertTrue(obs.executedActionOnSubscription);
        assertEquals(1, obs.numberOfActionOnSubscription);
        obs.flow().blockingSubscribe(System.out::println);
        // Waiting two seconds (sanity sleep)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        assertTrue(obs.executedActionOnSubscription);
        assertEquals(1, obs.numberOfActionOnSubscription);
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
        assertFalse(TestObserver.executedActionOnUnsubscription);
        try {
            obs.unsubscribe();
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
        assertTrue(TestObserver.executedActionOnUnsubscription);
        assertTrue(obs.isDisposed());
        assertEquals(0, obs.numberOfCallbacks());
    }

    /**
     * Tests that several observers receive the same notification.
     */
    @SuppressWarnings("null")
    @Test
    public void testNotifyToMultipleObservers() {
        Future<?> handle = null;
        ScheduledExecutorService executor = null;
        try {
            @SuppressWarnings("boxing")
            List<Integer> messages = Stream.iterate(0, n -> n + 1).limit(102).collect(Collectors.toList());
            SubscriptionTestManagerModifiableInput manager = new SubscriptionTestManagerModifiableInput(false);
            TestObserver obs1 = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                       BackpressureStrategy.BUFFER);
            TestObserver obs2 = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                       BackpressureStrategy.BUFFER);
            // Only storing even numbers.
            List<Integer> evenValues = new LinkedList<>();
            // Only storing multiple of 10.
            List<Integer> multiplesOfTenList = new LinkedList<>();

            obs1.flow().filter(new Predicate<NotificationTestMessageValue>() {

                @Override
                public boolean test(NotificationTestMessageValue t) throws Exception {
                    return ((Integer) t.getRawValue()).intValue() % 2 == 0;
                }
            }).subscribe(new Consumer<NotificationTestMessageValue>() {

                @Override
                public void accept(NotificationTestMessageValue t) throws Exception {
                    evenValues.add(((Integer) t.getRawValue()));

                }
            });

            obs2.flow().filter(new Predicate<NotificationTestMessageValue>() {

                @Override
                public boolean test(NotificationTestMessageValue t) throws Exception {
                    return ((Integer) t.getRawValue()).intValue() % 10 == 0;
                }
            }).subscribe(new Consumer<NotificationTestMessageValue>() {

                @Override
                public void accept(NotificationTestMessageValue t) throws Exception {
                    multiplesOfTenList.add(((Integer) t.getRawValue()));

                }
            });
            assertEquals(0, obs1.numberOfCallbacks());
            assertTrue(manager.hasObservers());
            executor = Executors.newScheduledThreadPool(1);
            int Interval = 400;
            handle = executor.scheduleWithFixedDelay(new Runnable() {

                private int i = 0;

                @Override
                public void run() {
                    if (i < messages.size()) {
                        @SuppressWarnings({ "unchecked", "boxing", "rawtypes" })
                        NotificationMessage<NotificationTestMessageValue> notification = new NotificationMessage(new NotificationTestMessageValue(messages.get(i)),
                                                                                                                 null);

                        try {
                            manager.notify(SubscriptionType.DEVICE_STATE_CHANGE, notification);
                        } catch (MbedCloudException e) {
                            System.out.println(e.getMessage());
                            // e.printStackTrace();
                        }
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            Thread.sleep((messages.size() + 1) * Interval);

            // the first list should only contain even numbers from 0 to 100 included.
            assertEquals(51, evenValues.size());
            // the second list should only contain multiples of 10 from 0 to 100 included.
            assertEquals(11, multiplesOfTenList.size());
            // the first list should only contain even numbers.
            for (int i = 0; i < evenValues.size(); i++) {
                assertEquals(i * 2, evenValues.get(i).intValue());
            }
            // the second list should only contain multiples of 10.
            for (int i = 0; i < multiplesOfTenList.size(); i++) {
                assertEquals(i * 10, multiplesOfTenList.get(i).intValue());
            }
            assertFalse(obs1.isDisposed());
            obs1.unsubscribe();
            assertTrue(obs1.isDisposed());
            manager.completeAll();
            if (handle != null) {
                handle.cancel(true);
            }
            if (executor != null) {
                executor.shutdownNow();
            }

        } catch (Exception e) {
            if (handle != null) {
                handle.cancel(true);
            }
            if (executor != null) {
                executor.shutdownNow();
            }
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testNotifyOnObserver() {
        Future<?> handle = null;
        ScheduledExecutorService executor = null;
        try {
            @SuppressWarnings("boxing")
            List<Integer> messages = Stream.iterate(0, n -> n + 1).limit(102).collect(Collectors.toList());
            SubscriptionTestManagerModifiableInput manager = new SubscriptionTestManagerModifiableInput(false);
            TestObserver obs = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                      BackpressureStrategy.BUFFER);
            // Only storing multiple of 10.
            List<Integer> MultiplesOfTenList = new LinkedList<>();

            obs.flow().filter(new Predicate<NotificationTestMessageValue>() {

                @Override
                public boolean test(NotificationTestMessageValue t) throws Exception {
                    return ((Integer) t.getRawValue()).intValue() % 10 == 0;
                }
            }).subscribe(new Consumer<NotificationTestMessageValue>() {

                @Override
                public void accept(NotificationTestMessageValue t) throws Exception {
                    MultiplesOfTenList.add(((Integer) t.getRawValue()));

                }
            });
            executor = Executors.newScheduledThreadPool(1);
            int Interval = 300;
            handle = executor.scheduleWithFixedDelay(new Runnable() {

                private int i = 0;

                @Override
                public void run() {
                    if (i < messages.size()) {
                        @SuppressWarnings({ "unchecked", "boxing", "rawtypes" })
                        NotificationMessage<NotificationTestMessageValue> notification = new NotificationMessage(new NotificationTestMessageValue(messages.get(i)),
                                                                                                                 null);

                        try {
                            obs.notify(notification);
                        } catch (MbedCloudException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            Thread.sleep((messages.size() + 1) * Interval);

            // the list should only contain multiples of 10 from 0 to 100 included.
            assertEquals(11, MultiplesOfTenList.size());
            // the list should only contain multiples of 10.
            for (int i = 0; i < MultiplesOfTenList.size(); i++) {
                assertEquals(i * 10, MultiplesOfTenList.get(i).intValue());
            }
            assertFalse(obs.isDisposed());
            obs.unsubscribe();
            assertTrue(obs.isDisposed());
            if (handle != null) {
                handle.cancel(true);
            }
            executor.shutdownNow();

        } catch (Exception e) {
            if (handle != null) {
                handle.cancel(true);
            }
            if (executor != null) {
                executor.shutdownNow();
            }
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testErrorNotification() {
        Future<?> handle = null;
        ScheduledExecutorService executor = null;
        try {
            @SuppressWarnings("boxing")
            List<Integer> messages = Stream.iterate(0, n -> n + 1).limit(102).collect(Collectors.toList());
            SubscriptionTestManagerModifiableInput manager = new SubscriptionTestManagerModifiableInput(false);
            TestObserver obs = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                      BackpressureStrategy.BUFFER);
            // Only storing multiple of 10.
            List<Integer> multiplesOfTenList = new LinkedList<>();
            List<String> errorList = new LinkedList<>();
            Callback<Throwable> onFailureCallback = new Callback<Throwable>() {

                @Override
                public void execute(Throwable arg) {
                    errorList.add(arg.getMessage());
                }
            };
            obs.addCallback(new NotificationCallback<>(new Callback<NotificationTestMessageValue>() {

                @Override
                public void execute(NotificationTestMessageValue arg) {
                    if (((Integer) arg.getRawValue()).intValue() % 5 == 0) {
                        multiplesOfTenList.add(((Integer) arg.getRawValue()));
                    }
                }
            }, onFailureCallback));
            executor = Executors.newScheduledThreadPool(1);
            int Interval = 50;
            handle = executor.scheduleWithFixedDelay(new Runnable() {

                private int i = 0;

                @SuppressWarnings({ "unchecked", "boxing", "rawtypes" })
                @Override
                public void run() {
                    if (i < messages.size()) {
                        NotificationMessage<NotificationTestMessageValue> notification = null;
                        if (i < 52) {
                            notification = new NotificationMessage(new NotificationTestMessageValue(messages.get(i)),
                                                                   null);
                        } else {
                            notification = new NotificationMessage(new NotificationTestMessageValue(messages.get(i)),
                                                                   new Exception("An error occurred"));
                        }

                        try {
                            obs.notify(notification);
                        } catch (MbedCloudException e) {
                            System.out.println(e.getMessage());
                            // e.printStackTrace();
                        }
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            Thread.sleep((messages.size() + 1) * Interval);

            // the list should only contain multiples of 10 from 0 to 50 included.
            assertEquals(6, multiplesOfTenList.size());
            // the list should only contain multiples of 10.
            for (int i = 0; i < multiplesOfTenList.size(); i++) {
                assertEquals(i * 10, multiplesOfTenList.get(i).intValue());
            }
            // Errors should have been raised
            assertFalse(errorList.isEmpty());
            assertEquals(1, errorList.size());
            assertEquals("An error occurred", errorList.get(0));

            assertFalse(obs.isDisposed());
            obs.unsubscribe();
            assertTrue(obs.isDisposed());
            if (handle != null) {
                handle.cancel(true);
            }
            if (executor != null) {
                executor.shutdownNow();
            }

        } catch (Exception e) {
            if (handle != null) {
                handle.cancel(true);
            }
            if (executor != null) {
                executor.shutdownNow();
            }
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testUnsubscribe() {
        SubscriptionTestManagerFixedInput manager = new SubscriptionTestManagerFixedInput(false);
        TestObserver obs1 = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                   BackpressureStrategy.BUFFER);
        TestObserver obs2 = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                   BackpressureStrategy.BUFFER);
        TestObserver obs3 = manager.createObserver(SubscriptionType.ASYNCHRONOUS_RESPONSE, null,
                                                   BackpressureStrategy.BUFFER);
        assertTrue(manager.hasObservers());
        assertTrue(manager.hasObservers(SubscriptionType.DEVICE_STATE_CHANGE));
        assertTrue(manager.hasObservers(SubscriptionType.ASYNCHRONOUS_RESPONSE));
        assertFalse(manager.hasObservers(SubscriptionType.NOTIFICATION));
        assertTrue(manager.hasObserver(obs1));
        assertTrue(manager.hasObserver(obs2));
        assertTrue(manager.hasObserver(obs3));
        try {
            obs1.unsubscribe();
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
        assertFalse(manager.hasObserver(obs1));
        assertTrue(manager.hasObserver(obs2));
        assertTrue(manager.hasObserver(obs3));
        manager.unsubscribeAll(SubscriptionType.DEVICE_STATE_CHANGE);
        assertFalse(manager.hasObserver(obs1));
        assertFalse(manager.hasObserver(obs2));
        assertTrue(manager.hasObserver(obs3));
        assertFalse(manager.hasObservers(SubscriptionType.DEVICE_STATE_CHANGE));
        assertTrue(manager.hasObservers(SubscriptionType.ASYNCHRONOUS_RESPONSE));
        manager.unsubscribeAll();
        assertFalse(manager.hasObserver(obs1));
        assertFalse(manager.hasObserver(obs2));
        assertFalse(manager.hasObserver(obs3));
    }

    @Test
    public void testFlow() {
        SubscriptionTestManagerFixedInput manager = new SubscriptionTestManagerFixedInput(false);
        TestObserver obs = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                  BackpressureStrategy.BUFFER);
        // Only storing multiple of 10.
        List<Integer> MultiplesOfTenList = new LinkedList<>();

        obs.flow().filter(new Predicate<NotificationTestMessageValue>() {

            @Override
            public boolean test(NotificationTestMessageValue t) throws Exception {
                return ((Integer) t.getRawValue()).intValue() % 5 == 0;
            }
        }).blockingSubscribe(new Consumer<NotificationTestMessageValue>() {

            @Override
            public void accept(NotificationTestMessageValue t) throws Exception {
                MultiplesOfTenList.add(((Integer) t.getRawValue()));

            }
        });
        assertEquals(0, obs.numberOfCallbacks());
        // the list should only contain multiples of 10 from 0 to 100 included.
        assertEquals(11, MultiplesOfTenList.size());
        // the list should only contain multiples of 10.
        for (int i = 0; i < MultiplesOfTenList.size(); i++) {
            assertEquals(i * 10, MultiplesOfTenList.get(i).intValue());
        }
        assertFalse(obs.isDisposed());
        try {
            obs.unsubscribe();
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
        assertTrue(obs.isDisposed());
        assertEquals(0, obs.numberOfCallbacks());
    }

    @Test
    public void testFutureOne() {
        SubscriptionTestManagerFixedInput manager = new SubscriptionTestManagerFixedInput(true);
        TestObserver obs = manager.createObserver(SubscriptionType.DEVICE_STATE_CHANGE, null,
                                                  BackpressureStrategy.BUFFER);
        try {
            obs.flow().subscribe();
            Future<NotificationTestMessageValue> future = obs.futureOne();
            NotificationTestMessageValue value = future.get(5, TimeUnit.SECONDS);
            // Value should be the first element received.
            assertEquals(0, value.i);
            // The observer should have been disposed
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
            // Value should be the first element received.
            assertEquals(0, value.i);
            // The observer should have been disposed
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

        @Override
        public Object getRawValue() {
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

        private final SubscriptionType type;
        public static volatile boolean executedActionOnUnsubscription;
        public static volatile boolean executedActionOnSubscription;
        public static volatile int numberOfActionOnSubscription;

        public TestObserver(SubscriptionManager manager, SubscriptionType type, String id,
                            Flowable<NotificationTestMessageValue> flow, FilterOptions filter,
                            boolean mustUnsubscribeOnCompletion) {
            super(manager, id, flow, filter, mustUnsubscribeOnCompletion, getActionOnSubscription(),
                  getActionOnUnsubscription());
            this.type = type;
            executedActionOnUnsubscription = false;
            numberOfActionOnSubscription = 0;
            executedActionOnSubscription = false;
        }

        private static CallbackWithException<FilterOptions, MbedCloudException> getActionOnUnsubscription() {
            return new CallbackWithException<FilterOptions, MbedCloudException>() {

                @Override
                public void execute(FilterOptions arg) {
                    executedActionOnUnsubscription = true;

                }
            };
        }

        private static CallbackWithException<FilterOptions, MbedCloudException> getActionOnSubscription() {
            return new CallbackWithException<FilterOptions, MbedCloudException>() {

                @Override
                public void execute(FilterOptions arg) {
                    numberOfActionOnSubscription++;
                    executedActionOnSubscription = true;
                }
            };
        }

        @Override
        public SubscriptionType getSubscriptionType() {
            return type;
        }

        @SuppressWarnings("boxing")
        @Override
        protected boolean verifiesFilter(NotificationTestMessageValue t) {
            // Only even numbers are observed
            return ((Integer) t.getRawValue()) % 2 == 0;
        }

    }

    private static abstract class AbstractTestSubscriptionManager implements SubscriptionManager {
        Map<String, Observer<?>> observers = new Hashtable<>(4);
        protected final boolean unsubscribeOnCompletion;

        protected AbstractTestSubscriptionManager(boolean unsubscribeOnCompletion) {
            super();
            this.unsubscribeOnCompletion = unsubscribeOnCompletion;
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#getTopManager()
         */
        @Override
        public SubscriptionManager getTopManager() {
            return null;
        }

        @Override
        public List<Observer<?>> listAll() {
            return new ArrayList<>(observers.values());
        }

        @Override
        public List<Observer<?>> listAll(SubscriptionType type) {
            List<Observer<?>> array = new LinkedList<>();
            for (Observer<?> obs : observers.values()) {
                if (obs.getSubscriptionType() == type) {
                    array.add(obs);
                }
            }
            return (array.isEmpty()) ? null : array;
        }

        @Override
        public void unsubscribeAll() {
            observers.clear();
        }

        @Override
        public void unsubscribeAll(SubscriptionType type) {
            List<Observer<?>> array = listAll(type);
            if (array != null) {
                for (Observer<?> obs : array) {
                    observers.remove(obs.getId());
                }
            }
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

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#hasObservers()
         */
        @Override
        public boolean hasObservers() {
            return !observers.isEmpty();
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#hasObservers(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType)
         */
        @Override
        public boolean hasObservers(SubscriptionType type) {
            List<Observer<?>> array = listAll(type);
            return (array == null) ? false : !array.isEmpty();
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#hasObserver(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType, java.lang.String)
         */
        @Override
        public boolean hasObserver(SubscriptionType type, String observerId) {
            return observers.containsKey(observerId);
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#hasObserver(com.arm.mbed.cloud.sdk.subscribe.Observer)
         */
        @Override
        public boolean hasObserver(Observer<?> observer) {
            return hasObserver(observer.getSubscriptionType(), observer.getId());
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#notify(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType, com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue)
         */
        @Override
        public <T extends NotificationMessageValue> void notify(SubscriptionType type,
                                                                T value) throws MbedCloudException {
            notify(type, new NotificationMessage<>(value, null));

        }

        @Override
        public TestObserver createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy) {
            return createObserver(type, filter, strategy, null, null);
        }

        @Override
        public TestObserver
               createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy,
                              CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                              CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription) {
            return (TestObserver) createObserver(type, filter, strategy, null, null, false, null);
        }

    }

    private static class SubscriptionTestManagerFixedInput extends AbstractTestSubscriptionManager {

        private SubscriptionTestManagerFixedInput(boolean unsubscribeOnCompletion) {
            super(unsubscribeOnCompletion);
        }

        @Override
        public Observer<?>
               createObserver(SubscriptionType subscriptionType, FilterOptions filter, BackpressureStrategy strategy,
                              CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                              CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription,
                              boolean notifyOtherObservers, Resource correspondingResource) {
            @SuppressWarnings("boxing")
            final Flowable<NotificationTestMessageValue> flow = Flowable.range(0, 102)
                                                                        .map(i -> new NotificationTestMessageValue(i));
            final String id = "testObserver_" + UuidGenerator.generate();
            final TestObserver obs = new TestObserver(this, subscriptionType, id, flow, null, unsubscribeOnCompletion);
            observers.put(id, obs);
            return obs;
        }

        @Override
        public <T extends NotificationMessageValue> void
               notify(SubscriptionType type, NotificationMessage<T> message) throws MbedCloudException {
            // No new notification can be added
        }

        @Override
        public <T extends NotificationMessageValue> void
               notify(SubscriptionType type, String channelId,
                      NotificationMessage<T> message) throws MbedCloudException {
            // No new notification can be added

        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#completeAll()
         */
        @Override
        public void completeAll() {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#completeAll(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType)
         */
        @Override
        public void completeAll(SubscriptionType type) {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#complete(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType, java.lang.String)
         */
        @Override
        public void complete(SubscriptionType type, String observerId) {
            // TODO Auto-generated method stub

        }
    }

    private static class SubscriptionTestManagerNeverInput extends AbstractTestSubscriptionManager {

        private SubscriptionTestManagerNeverInput(boolean unsubscribeOnCompletion) {
            super(unsubscribeOnCompletion);
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#createObserver(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType, com.arm.mbed.cloud.sdk.common.listing.FilterOptions, io.reactivex.BackpressureStrategy,
         * com.arm.mbed.cloud.sdk.common.CallbackWithException, com.arm.mbed.cloud.sdk.common.CallbackWithException,
         * boolean, com.arm.mbed.cloud.sdk.connect.model.Resource)
         */
        @Override
        public Observer<?>
               createObserver(SubscriptionType subscriptionType, FilterOptions filter, BackpressureStrategy strategy,
                              CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                              CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription,
                              boolean notifyOtherObservers, Resource correspondingResource) {
            final Flowable<NotificationTestMessageValue> flow = Flowable.never();
            final String id = "testObserver_" + UuidGenerator.generate();
            final TestObserver obs = new TestObserver(this, subscriptionType, id, flow, null, unsubscribeOnCompletion);
            observers.put(id, obs);
            return obs;
        }

        @Override
        public <T extends NotificationMessageValue> void
               notify(SubscriptionType type, NotificationMessage<T> message) throws MbedCloudException {
            // No new notification can be added
        }

        @Override
        public <T extends NotificationMessageValue> void
               notify(SubscriptionType type, String channelId,
                      NotificationMessage<T> message) throws MbedCloudException {
            // No new notification can be added

        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#completeAll()
         */
        @Override
        public void completeAll() {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#completeAll(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType)
         */
        @Override
        public void completeAll(SubscriptionType type) {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#complete(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType, java.lang.String)
         */
        @Override
        public void complete(SubscriptionType type, String observerId) {
            // TODO Auto-generated method stub

        }

    }

    private static class SubscriptionTestManagerModifiableInput extends AbstractTestSubscriptionManager {

        private final NotificationEmitter<NotificationTestMessageValue> emitter = new NotificationEmitter<>();

        private SubscriptionTestManagerModifiableInput(boolean unsubscribeOnCompletion) {
            super(unsubscribeOnCompletion);
        }

        @Override
        public Observer<?>
               createObserver(SubscriptionType subscriptionType, FilterOptions filter, BackpressureStrategy strategy,
                              CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                              CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription,
                              boolean notifyOtherObservers, Resource correspondingResource) {
            final String id = "testObserver_" + UuidGenerator.generate();
            final TestObserver obs = new TestObserver(this, subscriptionType, id, emitter.create(strategy), filter,
                                                      false);
            observers.put(id, obs);
            return obs;
        }

        @Override
        public <T extends NotificationMessageValue> void
               notify(SubscriptionType type, NotificationMessage<T> message) throws MbedCloudException {
            if (message == null) {
                emitter.emit(null, null);
            } else {
                emitter.emit((NotificationTestMessageValue) message.getValue(), message.getException());
            }
        }

        @Override
        public <T extends NotificationMessageValue> void
               notify(SubscriptionType type, String channelId,
                      NotificationMessage<T> message) throws MbedCloudException {
            if (message == null) {
                return;
            }
            notify(type, message);
        }

        @Override
        public void completeAll() {
            emitter.complete();
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#completeAll(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType)
         */
        @Override
        public void completeAll(SubscriptionType type) {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#complete(com.arm.mbed.cloud.sdk.subscribe.
         * SubscriptionType, java.lang.String)
         */
        @Override
        public void complete(SubscriptionType type, String observerId) {
            // TODO Auto-generated method stub

        }

    }
}
