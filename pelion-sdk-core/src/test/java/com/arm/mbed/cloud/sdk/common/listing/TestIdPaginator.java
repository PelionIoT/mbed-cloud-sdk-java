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

/**
 * Following tests create a fake server that supplies client with elements. They then verify that the paginator works as
 * intended by making multiple calls to the server
 */
public class TestIdPaginator {
    @Test
    public void testOnePageIterationWithOnlyOneValueSent() {
        int pageSize = 1;
        final FakeServer server = new FakeServer(1, pageSize, null, false);

        try {
            IdPaginator paginator = new IdPaginator(new ListOptions().pageSize(pageSize), new IdPageRequester() {

                @Override
                public IdListResponse requestNewPage(ListOptions options) throws MbedCloudException {
                    return server.fetchPage(options);
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
            String testingElement = paginator.first();
            assertEquals(String.valueOf(0), testingElement);
            assertEquals(paginator.first(), paginator.last());
            assertEquals(paginator.first(), paginator.current());
            assertEquals(server.numberOfSentElements(), paginator.count());
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
            IdPaginator paginator = new IdPaginator(new ListOptions().pageSize(pageSize), new IdPageRequester() {

                @Override
                public IdListResponse requestNewPage(ListOptions options) throws MbedCloudException {
                    return server.fetchPage(options);
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
            String testingElement = paginator.first();
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertEquals(String.valueOf(server.numberOfSentElements() - 1), testingElement);
            assertEquals(paginator.first(), paginator.current());
            assertEquals(server.numberOfSentElements(), paginator.count());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(1, paginator.getPagesNumber());
            assertEquals(0, paginator.getPageIndex());
            paginator.rewind();
            for (int i = 0; i < server.numberOfSentElements(); i++) {
                assertTrue(paginator.hasNext());
                String element = paginator.next();
                assertEquals(String.valueOf(i), element);
            }
            String previous = paginator.previous();
            if (server.numberOfSentElements() > 1) {
                assertEquals(String.valueOf(server.numberOfSentElements() - 2), previous);
            } else {
                assertNotNull(paginator.previous());
                assertEquals(previous, paginator.previous());
                assertEquals(String.valueOf(0), previous);
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
            IdPaginator paginator = new IdPaginator(new ListOptions().pageSize(pageSize).maxResults(maxResult),
                                                    new IdPageRequester() {

                                                        @Override
                                                        public IdListResponse
                                                               requestNewPage(ListOptions options) throws MbedCloudException {
                                                            return server.fetchPage(options);
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
            String testingElement = paginator.first();
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertEquals(String.valueOf(maxResult - 1), testingElement);
            assertEquals(paginator.first(), paginator.current());
            assertEquals(server.numberOfSentElements(), paginator.count());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(1, paginator.getPagesNumber());
            assertEquals(0, paginator.getPageIndex());
            paginator.rewind();
            for (int i = 0; i < maxResult; i++) {
                assertTrue(paginator.hasNext());
                String element = paginator.next();
                assertEquals(String.valueOf(i), element);
            }
            String previous = paginator.previous();
            if (maxResult > 1) {
                assertEquals(String.valueOf(maxResult - 2), previous);
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
        final FakeServer server = new FakeServer(pageNumber, pageSize, null, false);
        try {
            IdPaginator paginator = new IdPaginator(new ListOptions().pageSize(pageSize), new IdPageRequester() {

                @Override
                public IdListResponse requestNewPage(ListOptions options) throws MbedCloudException {
                    return server.fetchPage(options);
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
            String testingElement = paginator.first();
            assertTrue(paginator.isFirstPage());
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertNotNull(testingElement);
            String lastElement = new String(testingElement);
            assertNotNull(lastElement);
            assertEquals(String.valueOf(server.numberOfSentElements() - 1), testingElement);
            testingElement = paginator.first();
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertEquals(String.valueOf(server.numberOfSentElements() - 1), testingElement);
            assertEquals(server.numberOfSentElements(), paginator.count());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(pageNumber, paginator.getPagesNumber());
            assertNotEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            paginator.rewind();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, paginator.getPageIndex());
            int i = 0;
            while (paginator.hasNext()) {
                String element = paginator.next();
                String previous = paginator.previous();
                assertEquals(String.valueOf(i), element);
                if (i == 0) {
                    assertEquals(String.valueOf(i), previous);
                } else {
                    assertEquals(String.valueOf(i - 1), previous);
                }
                idSum += Integer.parseInt(element);
                i++;
            }
            assertTrue(paginator.hasPreviousPage());
            assertEquals((server.numberOfSentElements() - 1) * server.numberOfSentElements() / 2, idSum);
            assertEquals(pageNumber - 1, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPrevious());
            String previous = paginator.previous();
            if (server.numberOfSentElements() > 1) {
                assertEquals(String.valueOf(server.numberOfSentElements() - 2), previous);
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
        final FakeServer server = new FakeServer(pageNumber, pageSize, null, true);
        try {
            IdPaginator paginator = new IdPaginator(new ListOptions().pageSize(pageSize), new IdPageRequester() {

                @Override
                public IdListResponse requestNewPage(ListOptions options) throws MbedCloudException {
                    return server.fetchPage(options);
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
            String testingElement = paginator.first();
            assertTrue(paginator.isFirstPage());
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertNotNull(testingElement);
            String lastElement = new String(testingElement);
            assertNotNull(lastElement);
            assertEquals(String.valueOf(server.numberOfSentElements() - 1), testingElement);
            testingElement = paginator.first();
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertEquals(String.valueOf(server.numberOfSentElements() - 1), testingElement);
            assertEquals(server.numberOfSentElements(), paginator.count());
            assertEquals(pageSize, paginator.getNumberOfPageElements());
            assertEquals(pageNumber, paginator.getPagesNumber());
            assertNotEquals(0, paginator.getPageIndex());
            assertNotNull(paginator.getCurrentPage());
            paginator.rewind();
            assertTrue(paginator.isFirstPage());
            assertEquals(0, paginator.getPageIndex());
            int i = 0;
            while (paginator.hasNext()) {
                String element = paginator.next();
                String previous = paginator.previous();
                assertEquals(String.valueOf(i), element);
                if (i == 0) {
                    assertEquals(String.valueOf(i), previous);
                } else {
                    assertEquals(String.valueOf(i - 1), previous);
                }
                idSum += Integer.parseInt(element);
                i++;
            }
            assertTrue(paginator.hasPreviousPage());
            assertEquals((server.numberOfSentElements() - 1) * server.numberOfSentElements() / 2, idSum);
            assertEquals(pageNumber - 1, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPrevious());
            String previous = paginator.previous();
            if (server.numberOfSentElements() > 1) {
                assertEquals(String.valueOf(server.numberOfSentElements() - 2), previous);
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
        final FakeServer server = new FakeServer(pageNumber, pageSize, Integer.valueOf(maxResult), false);
        try {
            IdPaginator paginator = new IdPaginator(new ListOptions().pageSize(pageSize).maxResults(maxResult),
                                                    new IdPageRequester() {

                                                        @Override
                                                        public IdListResponse
                                                               requestNewPage(ListOptions options) throws MbedCloudException {
                                                            return server.fetchPage(options);
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
            String testingElement = paginator.first();
            assertTrue(paginator.isFirstPage());
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertTrue(paginator.isLastPage());
            assertNotNull(testingElement);
            String lastElement = new String(testingElement);
            assertNotNull(lastElement);
            assertEquals(String.valueOf(maxResult - 1), testingElement);
            testingElement = paginator.first();
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertEquals(String.valueOf(maxResult - 1), testingElement);
            assertEquals(server.numberOfSentElements(), paginator.count());
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
                String element = paginator.next();
                String previous = paginator.previous();
                assertEquals(String.valueOf(i), element);
                if (i == 0) {
                    assertEquals(String.valueOf(i), previous);
                } else {
                    assertEquals(String.valueOf(i - 1), previous);
                }
                idSum += Integer.parseInt(element);
                i++;
            }
            assertEquals(maxResult, i);
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPreviousPage());
            assertEquals((maxResult - 1) * maxResult / 2, idSum);
            assertEquals(paginator.getPagesNumber() - 1, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPrevious());
            String previous = paginator.previous();
            if (maxResult > 1) {
                assertEquals(String.valueOf(maxResult - 2), previous);
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
        final FakeServer server = new FakeServer(pageNumber, pageSize, Integer.valueOf(maxResult), false);
        try {
            IdPaginator paginator = new IdPaginator(new ListOptions().maxResults(maxResult), new IdPageRequester() {

                @Override
                public IdListResponse requestNewPage(ListOptions options) throws MbedCloudException {
                    return server.fetchPage(options);
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
            String testingElement = paginator.first();
            assertTrue(paginator.isFirstPage());
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertTrue(paginator.isLastPage());
            assertNotNull(testingElement);
            String lastElement = new String(testingElement);
            assertNotNull(lastElement);
            assertEquals(String.valueOf(maxResult - 1), testingElement);
            testingElement = paginator.first();
            assertEquals(String.valueOf(0), testingElement);
            testingElement = paginator.last();
            assertEquals(String.valueOf(maxResult - 1), testingElement);
            assertEquals(server.numberOfSentElements(), paginator.count());
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
                String element = paginator.next();
                String previous = paginator.previous();
                assertEquals(String.valueOf(i), element);
                if (i == 0) {
                    assertEquals(String.valueOf(i), previous);
                } else {
                    assertEquals(String.valueOf(i - 1), previous);
                }
                idSum += Integer.parseInt(element);
                i++;
            }
            assertEquals(maxResult, i);
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPreviousPage());
            assertEquals((maxResult - 1) * maxResult / 2, idSum);
            assertEquals(paginator.getPagesNumber() - 1, paginator.getPageIndex());
            assertFalse(paginator.hasNext());
            assertTrue(paginator.isLastPage());
            assertFalse(paginator.hasNextPage());
            assertEquals(lastElement, paginator.current());
            assertTrue(paginator.hasPrevious());
            String previous = paginator.previous();
            if (maxResult > 1) {
                assertEquals(String.valueOf(maxResult - 2), previous);
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
            IdPaginator paginator = new IdPaginator(new ListOptions().maxResults(maxResult), new IdPageRequester() {

                @Override
                public IdListResponse requestNewPage(ListOptions options) throws MbedCloudException {
                    return server.fetchPage(options);
                }
            });
            assertNotNull(paginator.getRequester());
            List<String> elements = paginator.all();
            assertNotNull(elements);
            assertEquals(maxResult, elements.size());
            for (int i = 0; i < elements.size(); i++) {
                String e = elements.get(i);
                assertEquals(String.valueOf(i), e);

            }

        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    private static class FakeServer {
        FakePages pages;

        public FakeServer(int pageNumber, int pageSize, Integer maxResults, boolean includeContinuationMarker) {
            super();
            pages = new FakePages(includeContinuationMarker);
            pages.generateElements(pageNumber, pageSize, maxResults);
        }

        IdListResponse fetchPage(ListOptions opt) {
            pages.moveToPage((opt == null) ? null : opt.getAfter());
            IdListResponse response = pages.nextPaginatedResponse();
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

    private static class FakePage {

        List<String> elements = new LinkedList<>();
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
                elements.add(String.valueOf(i + starting));
            }
        }

        boolean contains(String id) {
            return id == null ? false : elements.contains(id);
        }

        IdListResponse getPage() {
            IdListResponse page = new IdListResponse();
            page.setPageSize(pageSize);
            page.setData(elements);
            if (includeContinuationMarker) {
                page.setContinuationMarker(page.last());
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
        List<String> allElements = new LinkedList<>();
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
            for (FakePage page : pages) {
                if (page.contains(id)) {
                    return page;
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

        public IdListResponse nextPaginatedResponse() {
            return (iterator.hasNext()) ? iterator.next().getPage() : null;
        }
    }

}
