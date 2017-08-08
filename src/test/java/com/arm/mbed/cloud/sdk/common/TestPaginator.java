package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Following tests create a fake server that supplies client with elements. They then verify that the paginator works as
 * intended by making multiple calls to the server
 */
public class TestPaginator {

    @Test
    public final void testOnePageIteration() {
        int elementNumber = 41;
        final FakeServer server = new FakeServer(1, elementNumber);
        try {
            Paginator<FakeElement> paginator = new Paginator<>(new PageRequester<FakeElement>() {

                @Override
                public ListResponse<FakeElement> requestNewPage() throws MbedCloudException {
                    return server.fetchPage();
                }

            });
            for (int i = 0; i < elementNumber; i++) {
                assertTrue(paginator.hasNext());
                FakeElement element = paginator.next();
                assertEquals(i, element.id);
                assertEquals(i * 4, element.value);
            }
            assertFalse(paginator.hasNext());
            assertNull(paginator.next());
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public final void testMultiplePagesIteration() {
        int elementNumber = 41;
        int pageNumber = 5;
        int totalNumberOfElements = elementNumber * pageNumber;
        long idSum = 0;
        long valueSum = 0;
        final FakeServer server = new FakeServer(pageNumber, elementNumber);
        try {
            Paginator<FakeElement> paginator = new Paginator<>(new PageRequester<FakeElement>() {

                @Override
                public ListResponse<FakeElement> requestNewPage() throws MbedCloudException {
                    return server.fetchPage();
                }

            });
            int i = 0;
            while (paginator.hasNext()) {
                FakeElement element = paginator.next();
                assertEquals(i, element.id);
                idSum += element.id;
                assertEquals(i * 4, element.value);
                valueSum += element.value;
                i++;
            }
            assertFalse(paginator.hasNext());
            assertNull(paginator.next());
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
        assertEquals((totalNumberOfElements - 1) * totalNumberOfElements / 2, idSum);
        assertEquals((totalNumberOfElements - 1) * totalNumberOfElements * 2, valueSum);
    }

    private class FakeServer {
        FakePages pages;
        Iterator<ListResponse<FakeElement>> iterator;

        public FakeServer(int pageNumber, int pageSize) {
            super();
            pages = new FakePages();
            pages.generateElements(pageNumber, pageSize);
            iterator = pages.getIterator();
        }

        ListResponse<FakeElement> fetchPage() {
            return (iterator.hasNext()) ? iterator.next() : null;
        }

    }

    private class FakeElement {
        int id;
        int value;

        public FakeElement(int id, int value) {
            super();
            this.id = id;
            this.value = value;
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

    }

    private class FakePage {

        List<FakeElement> elements = new LinkedList<FakeElement>();

        void generateElements(int size, int starting) {
            elements.clear();
            for (int i = 0; i < size; i++) {
                FakeElement element = new FakeElement(i + starting, (i + starting) * 4);
                elements.add(element);
            }
        }

        ListResponse<FakeElement> getPage(boolean hasMore) {
            ListResponse<FakeElement> page = new ListResponse<FakeElement>();
            page.setData(elements);
            page.setHasMore(hasMore);
            return page;
        }
    }

    private class FakePages {
        List<ListResponse<FakeElement>> pages = new LinkedList<ListResponse<FakeElement>>();

        void generateElements(int pageNumber, int pageSize) {
            pages.clear();
            for (int i = 0; i < pageNumber; i++) {
                FakePage page = new FakePage();
                page.generateElements(pageSize, i * pageSize);
                pages.add(page.getPage(i != (pageNumber - 1)));
            }
        }

        Iterator<ListResponse<FakeElement>> getIterator() {
            return pages.iterator();
        }
    }

}
