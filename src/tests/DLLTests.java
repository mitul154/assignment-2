package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.Iterator;
import utils.MyDLL;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DLLTests {

    private MyDLL<String> list;

    @BeforeEach
    public void setUp() {
        list = new MyDLL<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
    }

    @Test
    public void testClear() {
        list.add("A");
        list.add("B");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testAddAtIndex() {
        list.add(0, "A");
        list.add(1, "C");
        list.add(2, "B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(2));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testAddAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "A"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "A"));
    }

    @Test
    public void testAddAtIndexNull() {
        assertThrows(NullPointerException.class, () -> list.add(0, null));
    }

    @Test
    public void testAdd() {
        assertTrue(list.add("A"));
        assertTrue(list.add("B"));
        assertEquals(2, list.size());
    }

    @Test
    public void testAddNull() {
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    public void testAddAll() {
        MyDLL<String> otherList = new MyDLL<>();
        otherList.add("A");
        otherList.add("B");
        list.addAll(otherList);
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testAddAllNull() {
        assertThrows(NullPointerException.class, () -> list.addAll(null));
    }

    @Test
    public void testGet() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testRemoveAtIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testRemoveElement() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove("B"));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveElementNull() {
        assertThrows(NullPointerException.class, () -> list.remove(null));
    }

    @Test
    public void testSet() {
        list.add("A");
        list.add("B");
        assertEquals("B", list.set(1, "C"));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testSetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, "A"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "A"));
    }

    @Test
    public void testSetNull() {
        list.add("A");
        assertThrows(NullPointerException.class, () -> list.set(0, null));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testContains() {
        list.add("A");
        list.add("B");
        assertTrue(list.contains("A"));
        assertTrue(list.contains("B"));
        assertFalse(list.contains("C"));
    }

    @Test
    public void testContainsNull() {
        assertThrows(NullPointerException.class, () -> list.contains(null));
    }

    @Test
    public void testToArrayWithParam() {
        list.add("A");
        list.add("B");
        String[] array = new String[2];
        String[] result = list.toArray(array);
        assertArrayEquals(new String[]{"A", "B"}, result);
    }

    @Test
    public void testToArrayWithParamNull() {
        assertThrows(NullPointerException.class, () -> list.toArray(null));
    }

    @Test
    public void testToArray() {
        list.add("A");
        list.add("B");
        Object[] result = list.toArray();
        assertArrayEquals(new String[]{"A", "B"}, result);
    }

    @Test
    public void testIterator() {
        list.add("A");
        list.add("B");
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}