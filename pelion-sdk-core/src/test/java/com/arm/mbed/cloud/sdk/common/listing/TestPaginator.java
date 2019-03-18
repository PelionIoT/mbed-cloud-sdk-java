package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Following tests create a fake server that supplies client with elements. They then verify that the paginator works as
 * intended by making multiple calls to the server
 */
public class TestPaginator {
    @Test
    public void testOnePageIterationWithOnlyOneValueSent() {
        int pageSize = 1;
        final FakeServer server = new FakeServer(1, pageSize, null, false);

        try {
            Paginator<FakeElement> paginator = new Paginator<>(new ListOptions().pageSize(pageSize),
                                                               new PageRequester<FakeElement>() {

                                                                   @Override
                                                                   public ListResponse<FakeElement>
                                                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                                                       return server.fetchPage(opt);
                                                                   }

                                                               });
            assertNotNull(paginator.iterator());
            assertNotNull(paginator.getRequester());
            assertNull(paginator.previous());
            assertFalse(paginator.hasPrevious());
            assertFalse(paginator.hasPreviousPage());
            assertTrue(paginator.isFirstPage());
            assertTrue(paginator.isLastPage());
            assertNotNull(paginator.getLastPage());
            assertEquals(paginator.getFirstPage(), paginator.getLastPage());
            assertEquals(paginator.getCurrentPage(), paginator.getLastPage());
            assertNull(paginator.getNextPage());
            FakeElement testingElement = paginator.first();
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            assertEquals(paginator.first(), paginator.last());
            assertEquals(paginator.first(), paginator.current());
            assertEquals(server.numberOfSentElements(), paginator.getElementsTotal());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(1, paginator.getPagesNumber());
            assertEquals(0, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertNotNull(paginator.current());
            assertNull(paginator.previous());
            assertEquals(paginator.last(), paginator.current());
            assertFalse(paginator.hasNext());
            assertNull(paginator.next());
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testOnePageIteration() {
        int pageSize = 50;
        final FakeServer server = new FakeServer(1, pageSize, null, false);

        try {
            Paginator<FakeElement> paginator = new Paginator<>(new ListOptions().pageSize(pageSize),
                                                               new PageRequester<FakeElement>() {

                                                                   @Override
                                                                   public ListResponse<FakeElement>
                                                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                                                       return server.fetchPage(opt);
                                                                   }

                                                               });
            assertNotNull(paginator.iterator());
            assertNotNull(paginator.getRequester());
            assertNull(paginator.previous());
            assertFalse(paginator.hasPrevious());
            assertFalse(paginator.hasPreviousPage());
            assertTrue(paginator.isFirstPage());
            assertTrue(paginator.isLastPage());
            assertNotNull(paginator.getLastPage());
            assertEquals(paginator.getFirstPage(), paginator.getLastPage());
            assertEquals(paginator.getCurrentPage(), paginator.getLastPage());
            assertNull(paginator.getNextPage());
            FakeElement testingElement = paginator.first();
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertEquals(server.numberOfSentElements() - 1, testingElement.id);
            assertEquals((server.numberOfSentElements() - 1) * 4, testingElement.value);
            assertEquals(paginator.first(), paginator.current());
            assertEquals(server.numberOfSentElements(), paginator.getElementsTotal());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(1, paginator.getPagesNumber());
            assertEquals(0, paginator.getPageIndex());
            paginator.rewind();
            for (int i = 0; i < server.numberOfSentElements(); i++) {
                assertTrue(paginator.hasNext());
                FakeElement element = paginator.next();
                assertEquals(i, element.id);
                assertEquals(i * 4, element.value);
            }
            FakeElement previous = paginator.previous();
            if (server.numberOfSentElements() > 1) {
                assertEquals(server.numberOfSentElements() - 2, previous.id);
                assertEquals((server.numberOfSentElements() - 2) * 4, previous.value);
            } else {
                assertNotNull(paginator.previous());
                assertEquals(previous, paginator.previous());
                assertEquals(0, previous.id);
                assertEquals(0, previous.value);
            }
            assertEquals(paginator.last(), paginator.current());
            assertFalse(paginator.hasNext());
            assertNull(paginator.next());
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testOnePageIterationWithResultNumberLimit() {
        int pageSize = 41;
        int maxResult = 4;
        final FakeServer server = new FakeServer(1, pageSize, Integer.valueOf(maxResult), false);

        try {
            Paginator<FakeElement> paginator = new Paginator<>(new ListOptions().pageSize(pageSize)
                                                                                .maxResults(maxResult),
                                                               new PageRequester<FakeElement>() {

                                                                   @Override
                                                                   public ListResponse<FakeElement>
                                                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                                                       return server.fetchPage(opt);
                                                                   }

                                                               });
            assertNotNull(paginator.iterator());
            assertNotNull(paginator.getRequester());
            assertNull(paginator.previous());
            assertFalse(paginator.hasPrevious());
            assertFalse(paginator.hasPreviousPage());
            assertTrue(paginator.isFirstPage());
            assertTrue(paginator.isLastPage());
            assertNotNull(paginator.getLastPage());
            assertEquals(paginator.getFirstPage(), paginator.getLastPage());
            assertEquals(paginator.getCurrentPage(), paginator.getLastPage());
            assertNull(paginator.getNextPage());
            FakeElement testingElement = paginator.first();
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertEquals(maxResult - 1, testingElement.id);
            assertEquals((maxResult - 1) * 4, testingElement.value);
            assertEquals(paginator.first(), paginator.current());
            assertEquals(server.numberOfSentElements(), paginator.getElementsTotal());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(1, paginator.getPagesNumber());
            assertEquals(0, paginator.getPageIndex());
            paginator.rewind();
            for (int i = 0; i < maxResult; i++) {
                assertTrue(paginator.hasNext());
                FakeElement element = paginator.next();
                assertEquals(i, element.id);
                assertEquals(i * 4, element.value);
            }
            FakeElement previous = paginator.previous();
            if (maxResult > 1) {
                assertEquals(maxResult - 2, previous.id);
                assertEquals((maxResult - 2) * 4, previous.value);
            } else {
                assertNull(paginator.previous());
            }
            assertEquals(paginator.last(), paginator.current());
            assertFalse(paginator.hasNext());
            assertNull(paginator.next());
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMultiplePagesIteration() {
        int pageSize = 10;
        int pageNumber = 9;
        long idSum = 0;
        long valueSum = 0;
        final FakeServer server = new FakeServer(pageNumber, pageSize, null, false);
        try {
            Paginator<FakeElement> paginator = new Paginator<>(new ListOptions().pageSize(pageSize),
                                                               new PageRequester<FakeElement>() {

                                                                   @Override
                                                                   public ListResponse<FakeElement>
                                                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                                                       return server.fetchPage(opt);
                                                                   }

                                                               });
            assertNotNull(paginator.getRequester());
            assertNull(paginator.previous());
            assertFalse(paginator.hasPrevious());
            assertFalse(paginator.hasPreviousPage());
            assertTrue(paginator.isFirstPage());
            assertFalse(paginator.isLastPage());
            assertEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            assertEquals(paginator.getCurrentPage(), paginator.getFirstPage());
            assertTrue(paginator.hasNextPage());
            assertNotNull(paginator.getNextPage());
            assertNotEquals(paginator.getCurrentPage(), paginator.getFirstPage());
            assertNotNull(paginator.getLastPage());
            assertTrue(paginator.isLastPage());
            assertNotEquals(paginator.getFirstPage(), paginator.getLastPage());
            FakeElement testingElement = paginator.first();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertNotNull(testingElement);
            FakeElement lastElement = testingElement.clone();
            assertNotNull(lastElement);
            assertEquals(server.numberOfSentElements() - 1, testingElement.id);
            assertEquals((server.numberOfSentElements() - 1) * 4, testingElement.value);
            testingElement = paginator.first();
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertEquals(server.numberOfSentElements() - 1, testingElement.id);
            assertEquals((server.numberOfSentElements() - 1) * 4, testingElement.value);
            assertEquals(server.numberOfSentElements(), paginator.getElementsTotal());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(pageNumber, paginator.getPagesNumber());
            assertNotEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            paginator.rewind();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, paginator.getPageIndex());
            int i = 0;
            while (paginator.hasNext()) {
                FakeElement element = paginator.next();
                FakeElement previous = paginator.previous();
                assertEquals(i, element.id);
                assertEquals(i * 4, element.value);
                if (i == 0) {
                    assertEquals(i, previous.id);
                    assertEquals(i, previous.value);
                } else {
                    assertEquals(i - 1, previous.id);
                    assertEquals((i - 1) * 4, previous.value);
                }
                idSum += element.id;
                valueSum += element.value;
                i++;
            }
            assertTrue(paginator.hasPreviousPage());
            assertEquals((server.numberOfSentElements() - 1) * server.numberOfSentElements() / 2, idSum);
            assertEquals((server.numberOfSentElements() - 1) * server.numberOfSentElements() * 2, valueSum);
            assertEquals(pageNumber - 1, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPrevious());
            FakeElement previous = paginator.previous();
            if (server.numberOfSentElements() > 1) {
                assertEquals(server.numberOfSentElements() - 2, previous.id);
                assertEquals((server.numberOfSentElements() - 2) * 4, previous.value);
            } else {
                assertNull(paginator.previous());
            }
            // Current element should be the last one of the collection.
            assertNotNull(paginator.current());
            assertNull(paginator.next());
            assertNull(paginator.current());
            assertNotNull(paginator.previous());
            assertTrue(paginator.hasPreviousPage());
            assertNotNull(paginator.getPreviousPage());
            // Checks we are still in the last page and have not moved to previous page.
            assertTrue(paginator.isLastPage());
            // Moving to head of the collection and back to the tail. When jumping in the collection then previous page
            // information is not stored anymore.
            paginator.getFirstPage();
            paginator.getLastPage();
            assertFalse(paginator.hasPreviousPage());
            assertNull(paginator.getPreviousPage());

        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMultiplePagesIterationWithContinuationMarker() {
        int pageSize = 10;
        int pageNumber = 9;
        long idSum = 0;
        long valueSum = 0;
        final FakeServer server = new FakeServer(pageNumber, pageSize, null, true);
        try {
            Paginator<FakeElement> paginator = new Paginator<>(new ListOptions().pageSize(pageSize),
                                                               new PageRequester<FakeElement>() {

                                                                   @Override
                                                                   public ListResponse<FakeElement>
                                                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                                                       return server.fetchPage(opt);
                                                                   }

                                                               });
            assertNotNull(paginator.getRequester());
            assertNull(paginator.previous());
            assertFalse(paginator.hasPrevious());
            assertFalse(paginator.hasPreviousPage());
            assertTrue(paginator.isFirstPage());
            assertFalse(paginator.isLastPage());
            assertEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            assertEquals(paginator.getCurrentPage(), paginator.getFirstPage());
            assertTrue(paginator.hasNextPage());
            assertNotNull(paginator.getNextPage());
            assertNotEquals(paginator.getCurrentPage(), paginator.getFirstPage());
            assertNotNull(paginator.getLastPage());
            assertTrue(paginator.isLastPage());
            assertNotEquals(paginator.getFirstPage(), paginator.getLastPage());
            FakeElement testingElement = paginator.first();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertNotNull(testingElement);
            FakeElement lastElement = testingElement.clone();
            assertNotNull(lastElement);
            assertEquals(server.numberOfSentElements() - 1, testingElement.id);
            assertEquals((server.numberOfSentElements() - 1) * 4, testingElement.value);
            testingElement = paginator.first();
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertEquals(server.numberOfSentElements() - 1, testingElement.id);
            assertEquals((server.numberOfSentElements() - 1) * 4, testingElement.value);
            assertEquals(server.numberOfSentElements(), paginator.getElementsTotal());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(pageNumber, paginator.getPagesNumber());
            assertNotEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            paginator.rewind();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, paginator.getPageIndex());
            int i = 0;
            while (paginator.hasNext()) {
                FakeElement element = paginator.next();
                FakeElement previous = paginator.previous();
                assertEquals(i, element.id);
                assertEquals(i * 4, element.value);
                if (i == 0) {
                    assertEquals(i, previous.id);
                    assertEquals(i, previous.value);
                } else {
                    assertEquals(i - 1, previous.id);
                    assertEquals((i - 1) * 4, previous.value);
                }
                idSum += element.id;
                valueSum += element.value;
                i++;
            }
            assertTrue(paginator.hasPreviousPage());
            assertEquals((server.numberOfSentElements() - 1) * server.numberOfSentElements() / 2, idSum);
            assertEquals((server.numberOfSentElements() - 1) * server.numberOfSentElements() * 2, valueSum);
            assertEquals(pageNumber - 1, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPrevious());
            FakeElement previous = paginator.previous();
            if (server.numberOfSentElements() > 1) {
                assertEquals(server.numberOfSentElements() - 2, previous.id);
                assertEquals((server.numberOfSentElements() - 2) * 4, previous.value);
            } else {
                assertNull(paginator.previous());
            }
            // Current element should be the last one of the collection.
            assertNotNull(paginator.current());
            assertNull(paginator.next());
            assertNull(paginator.current());
            assertNotNull(paginator.previous());
            assertTrue(paginator.hasPreviousPage());
            assertNotNull(paginator.getPreviousPage());
            // Checks we are still in the last page and have not moved to previous page.
            assertTrue(paginator.isLastPage());
            // Moving to head of the collection and back to the tail. When jumping in the collection then previous page
            // information is not stored anymore.
            paginator.getFirstPage();
            paginator.getLastPage();
            assertFalse(paginator.hasPreviousPage());
            assertNull(paginator.getPreviousPage());

        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMultiplePagesIterationWithResultNumberLimit() {
        int pageSize = 5;
        int pageNumber = 8;
        int maxResult = 16;
        long idSum = 0;
        long valueSum = 0;
        final FakeServer server = new FakeServer(pageNumber, pageSize, Integer.valueOf(maxResult), false);
        try {
            Paginator<FakeElement> paginator = new Paginator<>(new ListOptions().pageSize(pageSize)
                                                                                .maxResults(maxResult),
                                                               new PageRequester<FakeElement>() {

                                                                   @Override
                                                                   public ListResponse<FakeElement>
                                                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                                                       return server.fetchPage(opt);
                                                                   }

                                                               });
            assertNotNull(paginator.getRequester());
            assertNull(paginator.previous());
            assertFalse(paginator.hasPrevious());
            assertFalse(paginator.hasPreviousPage());
            assertTrue(paginator.isFirstPage());
            assertFalse(paginator.isLastPage());
            assertEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            assertEquals(paginator.getCurrentPage(), paginator.getFirstPage());
            assertTrue(paginator.hasNextPage());
            assertNotNull(paginator.getNextPage());
            assertNotEquals(paginator.getCurrentPage(), paginator.getFirstPage());
            assertNotNull(paginator.getLastPage());
            assertTrue(paginator.isLastPage());
            assertNotEquals(paginator.getFirstPage(), paginator.getLastPage());
            FakeElement testingElement = paginator.first();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertTrue(paginator.isLastPage());
            assertNotNull(testingElement);
            FakeElement lastElement = testingElement.clone();
            assertNotNull(lastElement);
            assertEquals(maxResult - 1, testingElement.id);
            assertEquals((maxResult - 1) * 4, testingElement.value);
            testingElement = paginator.first();
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertEquals(maxResult - 1, testingElement.id);
            assertEquals((maxResult - 1) * 4, testingElement.value);
            assertEquals(server.numberOfSentElements(), paginator.getElementsTotal());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals((maxResult % pageSize > 0) ? (maxResult / pageSize) + 1 : maxResult / pageSize,
                         paginator.getPagesNumber());
            assertNotEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            paginator.rewind();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, paginator.getPageIndex());
            int i = 0;
            while (paginator.hasNext()) {
                FakeElement element = paginator.next();
                FakeElement previous = paginator.previous();
                assertEquals(i, element.id);
                assertEquals(i * 4, element.value);
                if (i == 0) {
                    assertEquals(i, previous.id);
                    assertEquals(i, previous.value);
                } else {
                    assertEquals(i - 1, previous.id);
                    assertEquals((i - 1) * 4, previous.value);
                }
                idSum += element.id;
                valueSum += element.value;
                i++;
            }
            assertEquals(maxResult, i);
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPreviousPage());
            assertEquals((maxResult - 1) * maxResult / 2, idSum);
            assertEquals((maxResult - 1) * maxResult * 2, valueSum);
            assertEquals(paginator.getPagesNumber() - 1, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPrevious());
            FakeElement previous = paginator.previous();
            if (maxResult > 1) {
                assertEquals(maxResult - 2, previous.id);
                assertEquals((maxResult - 2) * 4, previous.value);
            } else {
                assertNull(paginator.previous());
            }
            // Current element should be the last one of the collection.
            assertNotNull(paginator.current());
            assertNull(paginator.next());
            assertNull(paginator.current());
            assertNotNull(paginator.previous());
            assertTrue(paginator.hasPreviousPage());
            assertNotNull(paginator.getPreviousPage());
            // Checks we are still in the last page and have not moved to previous page.
            assertTrue(paginator.isLastPage());
            // Moving to head of the collection and back to the tail. When jumping in the collection then previous page
            // information is not stored anymore.
            paginator.getFirstPage();
            paginator.getLastPage();
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasPreviousPage());
            assertNull(paginator.getPreviousPage());

        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMultiplePagesIterationWithResultNumberLimitButNoPageSizeSet() {
        int pageSize = 5;
        int pageNumber = 8;
        int maxResult = 16;
        long idSum = 0;
        long valueSum = 0;
        final FakeServer server = new FakeServer(pageNumber, pageSize, Integer.valueOf(maxResult), false);
        try {
            Paginator<FakeElement> paginator = new Paginator<>(new ListOptions().maxResults(maxResult),
                                                               new PageRequester<FakeElement>() {

                                                                   @Override
                                                                   public ListResponse<FakeElement>
                                                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                                                       return server.fetchPage(opt);
                                                                   }

                                                               });
            assertNotNull(paginator.getRequester());
            assertNull(paginator.previous());
            assertFalse(paginator.hasPrevious());
            assertFalse(paginator.hasPreviousPage());
            assertTrue(paginator.isFirstPage());
            assertFalse(paginator.isLastPage());
            assertEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            assertEquals(paginator.getCurrentPage(), paginator.getFirstPage());
            assertTrue(paginator.hasNextPage());
            assertNotNull(paginator.getNextPage());
            assertNotEquals(paginator.getCurrentPage(), paginator.getFirstPage());
            assertNotNull(paginator.getLastPage());
            assertTrue(paginator.isLastPage());
            assertNotEquals(paginator.getFirstPage(), paginator.getLastPage());
            FakeElement testingElement = paginator.first();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertTrue(paginator.isLastPage());
            assertNotNull(testingElement);
            FakeElement lastElement = testingElement.clone();
            assertNotNull(lastElement);
            assertEquals(maxResult - 1, testingElement.id);
            assertEquals((maxResult - 1) * 4, testingElement.value);
            testingElement = paginator.first();
            assertEquals(0, testingElement.id);
            assertEquals(0, testingElement.value);
            testingElement = paginator.last();
            assertEquals(maxResult - 1, testingElement.id);
            assertEquals((maxResult - 1) * 4, testingElement.value);
            assertEquals(server.numberOfSentElements(), paginator.getElementsTotal());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals((maxResult % pageSize > 0) ? (maxResult / pageSize) + 1 : maxResult / pageSize,
                         paginator.getPagesNumber());
            assertNotEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            paginator.rewind();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, paginator.getPageIndex());
            int i = 0;
            while (paginator.hasNext()) {
                FakeElement element = paginator.next();
                FakeElement previous = paginator.previous();
                assertEquals(i, element.id);
                assertEquals(i * 4, element.value);
                if (i == 0) {
                    assertEquals(i, previous.id);
                    assertEquals(i, previous.value);
                } else {
                    assertEquals(i - 1, previous.id);
                    assertEquals((i - 1) * 4, previous.value);
                }
                idSum += element.id;
                valueSum += element.value;
                i++;
            }
            assertEquals(maxResult, i);
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPreviousPage());
            assertEquals((maxResult - 1) * maxResult / 2, idSum);
            assertEquals((maxResult - 1) * maxResult * 2, valueSum);
            assertEquals(paginator.getPagesNumber() - 1, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPrevious());
            FakeElement previous = paginator.previous();
            if (maxResult > 1) {
                assertEquals(maxResult - 2, previous.id);
                assertEquals((maxResult - 2) * 4, previous.value);
            } else {
                assertNull(paginator.previous());
            }
            // Current element should be the last one of the collection.
            assertNotNull(paginator.current());
            assertNull(paginator.next());
            assertNull(paginator.current());
            assertNotNull(paginator.previous());
            assertTrue(paginator.hasPreviousPage());
            assertNotNull(paginator.getPreviousPage());
            // Checks we are still in the last page and have not moved to previous page.
            assertTrue(paginator.isLastPage());
            // Moving to head of the collection and back to the tail. When jumping in the collection then previous page
            // information is not stored anymore.
            paginator.getFirstPage();
            paginator.getLastPage();
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasPreviousPage());
            assertNull(paginator.getPreviousPage());

        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAll() {
        int pageSize = 5;
        int pageNumber = 8;
        int maxResult = 16;
        final FakeServer server = new FakeServer(pageNumber, pageSize, Integer.valueOf(maxResult), false);
        try {
            Paginator<FakeElement> paginator = new Paginator<>(new ListOptions().maxResults(maxResult),
                                                               new PageRequester<FakeElement>() {

                                                                   @Override
                                                                   public ListResponse<FakeElement>
                                                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                                                       return server.fetchPage(opt);
                                                                   }

                                                               });
            assertNotNull(paginator.getRequester());
            List<FakeElement> elements = paginator.all();
            assertNotNull(elements);
            assertEquals(maxResult, elements.size());
            for (int i = 0; i < elements.size(); i++) {
                FakeElement e = elements.get(i);
                assertEquals(i, e.id);
                assertEquals(i * 4, e.value);
            }
            List<FakeElement> allAgain = paginator.all();
            assertNotNull(allAgain);
            assertEquals(maxResult, allAgain.size());
            assertEquals(elements, allAgain);
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    private static class FakeServer {
        FakePages pages;
        int callsNumber;

        public FakeServer(int pageNumber, int pageSize, Integer maxResults, boolean includeContinuationMarker) {
            super();
            pages = new FakePages(includeContinuationMarker);
            pages.generateElements(pageNumber, pageSize, maxResults);
            callsNumber = 0;
        }

        ListResponse<FakeElement> fetchPage(ListOptions opt) {
            callsNumber++;
            pages.moveToPage((opt == null) ? null : opt.getAfter());
            ListResponse<FakeElement> response = pages.nextPaginatedResponse();
            if (response == null) {
                return null;
            }
            if (opt != null && opt.constainsTotalCountInclude()) {
                response.setTotalCount(pages.totalCounts());
            }
            return response;

        }

        public int numberOfSentElements() {
            return pages.totalCounts();
        }

    }

    private static class FakeElement implements SdkModel {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        final int id;
        final int value;
        final FakePage relatedPage;

        public FakeElement(int id, int value, FakePage relatedPage) {
            super();
            this.id = id;
            this.value = value;
            this.relatedPage = relatedPage;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "FakeElement [id=" + id + ", value=" + value + "]";
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.common.SdkModel#isValid()
         */
        @Override
        public boolean isValid() {
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see com.arm.mbed.cloud.sdk.common.SdkModel#getId()
         */
        @Override
        public String getId() {
            return String.valueOf(id);
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#clone()
         */
        @Override
        public FakeElement clone() {
            return new FakeElement(id, value, relatedPage);
        }

        /**
         * @return the relatedPage
         */
        public FakePage getRelatedPage() {
            return relatedPage;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((relatedPage == null) ? 0 : relatedPage.hashCode());
            result = prime * result + value;
            return result;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            FakeElement other = (FakeElement) obj;
            if (id != other.id) {
                return false;
            }
            if (relatedPage == null) {
                if (other.relatedPage != null) {
                    return false;
                }
            } else if (!relatedPage.equals(other.relatedPage)) {
                return false;
            }
            if (value != other.value) {
                return false;
            }
            return true;
        }

        @Override
        public void setId(String id) {
            // Nothing to do.
        }

    }

    private static class FakePage {

        List<FakeElement> elements = new LinkedList<>();
        int pageSize;
        boolean hasMore;
        boolean includeContinuationMarker;

        public FakePage(int pageSize, boolean hasMore, boolean includeContinuationMarker) {
            super();
            this.pageSize = pageSize;
            this.hasMore = hasMore;
            this.includeContinuationMarker = includeContinuationMarker;
        }

        void generateElements(int size, int starting) {
            elements.clear();
            for (int i = 0; i < size; i++) {
                FakeElement element = new FakeElement(i + starting, (i + starting) * 4, this);
                elements.add(element);
            }
        }

        ListResponse<FakeElement> getPage() {
            ListResponse<FakeElement> page = new ListResponse<>();
            page.setPageSize(pageSize);
            page.setData(elements);
            if (includeContinuationMarker) {
                page.setContinuationMarker(page.last().getId());
            }
            // page.setPageSize(elements.size());
            page.setHasMore(hasMore);
            return page;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((elements == null) ? 0 : elements.hashCode());
            result = prime * result + (hasMore ? 1231 : 1237);
            result = prime * result + pageSize;
            return result;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            FakePage other = (FakePage) obj;
            if (elements == null) {
                if (other.elements != null) {
                    return false;
                }
            } else if (!elements.equals(other.elements)) {
                return false;
            }
            if (hasMore != other.hasMore) {
                return false;
            }
            if (pageSize != other.pageSize) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "FakePage [elements=" + elements + ", pageSize=" + pageSize + ", hasMore=" + hasMore + "]";
        }

    }

    private static class FakePages {
        List<FakePage> pages = new LinkedList<>();
        List<FakeElement> allElements = new LinkedList<>();
        Iterator<FakePage> iterator = pages.iterator();

        boolean includeContinuationMarker;

        public FakePages(boolean includeContinuationMarker) {
            super();
            this.includeContinuationMarker = includeContinuationMarker;
        }

        void generateElements(int pageNumber, int pageSize, Integer maxResult) {
            pages.clear();
            allElements.clear();
            for (int i = 0; i < pageNumber - 1; i++) {
                final FakePage page = new FakePage(pageSize, true, includeContinuationMarker);
                page.generateElements(pageSize, i * pageSize);
                pages.add(page);
                allElements.addAll(page.elements);
            }
            final FakePage lastpage = new FakePage(pageSize, false, includeContinuationMarker);
            int numberOfElementsInLastPage = (int) (pageSize * Math.random());
            // Enforcing that there is at least one element in the last page
            if (numberOfElementsInLastPage == 0 && pageSize > 0) {
                numberOfElementsInLastPage = 1;
            }
            // Ensure there is more results than maxResult when set
            if (maxResult != null
                && (maxResult.intValue() - (pageSize * (pageNumber - 1))) > numberOfElementsInLastPage) {
                numberOfElementsInLastPage = (maxResult.intValue() - (pageSize * (pageNumber - 1)));
            }
            lastpage.generateElements(numberOfElementsInLastPage, (pageNumber - 1) * pageSize);
            pages.add(lastpage);
            allElements.addAll(lastpage.elements);
        }

        private FakePage findPage(String id) {
            if (id == null) {
                return (pages.isEmpty()) ? null : pages.get(0);
            }
            int eid = Integer.parseInt(id);
            for (FakeElement element : allElements) {
                if (element.id == eid) {
                    return element.getRelatedPage();
                }
            }
            return null;
        }

        public void moveToPage(String id) {
            iterator = pages.iterator();
            if (id == null) {
                return;
            }
            FakePage page = findPage(id);

            if (page != null) {
                while (iterator.hasNext()) {
                    if (iterator.next().equals(page)) {
                        return;
                    }
                }
                iterator = pages.iterator();
            }
        }

        public int totalCounts() {
            return allElements.size();
        }

        public ListResponse<FakeElement> nextPaginatedResponse() {
            return (iterator.hasNext()) ? iterator.next().getPage() : null;
        }
    }

}
