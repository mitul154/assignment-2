package tests;

import exceptions.EmptyQueueException;
import interfaces.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.MyQueue;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTests {

    private MyQueue<String> queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void testEnqueue() throws EmptyQueueException {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals(3, queue.size());
        assertEquals("A", queue.peek());
    }

    @Test
    public void testEnqueueNull() {
        assertThrows(NullPointerException.class, () -> queue.enqueue(null));
    }

    @Test
    public void testDequeue() throws EmptyQueueException {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeueEmpty() {
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
    }

    @Test
    public void testPeek() throws EmptyQueueException {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("A", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    public void testPeekEmpty() {
        assertThrows(EmptyQueueException.class, () -> queue.peek());
    }

    @Test
    public void testDequeueAll() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.dequeueAll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("A");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIterator() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        Iterator<String> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEquals() {
        queue.enqueue("A");
        queue.enqueue("B");
        MyQueue<String> otherQueue = new MyQueue<>();
        otherQueue.enqueue("A");
        otherQueue.enqueue("B");
        assertTrue(queue.equals(otherQueue));
        otherQueue.enqueue("C");
        assertFalse(queue.equals(otherQueue));
    }

    @Test
    public void testToArray() {
        queue.enqueue("A");
        queue.enqueue("B");
        Object[] array = queue.toArray();
        assertArrayEquals(new String[]{"A", "B"}, array);
    }

    @Test
    public void testToArrayWithParam() {
        queue.enqueue("A");
        queue.enqueue("B");
        String[] array = new String[2];
        String[] result = queue.toArray(array);
        assertArrayEquals(new String[]{"A", "B"}, result);
    }

    @Test
    public void testToArrayWithParamNull() {
        assertThrows(NullPointerException.class, () -> queue.toArray(null));
    }

    @Test
    public void testIsFull() {
        assertFalse(queue.isFull());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.size());
    }
}