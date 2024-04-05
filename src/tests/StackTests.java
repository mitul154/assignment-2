package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.MyStack;

import java.util.EmptyStackException;
import interfaces.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests {
    private MyStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void testPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPushNull() {
        assertThrows(NullPointerException.class, () -> stack.push(null));
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopEmpty() {
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testPeekEmpty() {
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void testClear() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.clear();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @Test
    public void testToArray() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Object[] array = stack.toArray();

        assertArrayEquals(new Object[]{1, 2, 3}, array);
    }

    @Test
    public void testToArrayWithHolder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer[] holder = new Integer[3];
        Integer[] array = stack.toArray(holder);

        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void testToArrayWithHolderNull() {
        assertThrows(NullPointerException.class, () -> stack.toArray(null));
    }

    @Test
    public void testContains() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.contains(2));
        assertFalse(stack.contains(4));
    }

    @Test
    public void testContainsNull() {
        assertThrows(NullPointerException.class, () -> stack.contains(null));
    }

    @Test
    public void testSearch() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(2, stack.search(2));
        assertEquals(-1, stack.search(4));
    }

    @Test
    public void testIterator() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Iterator<Integer> iterator = stack.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEquals() {
        MyStack<Integer> otherStack = new MyStack<>();

        assertFalse(stack.equals(otherStack));
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.size());
    }
}