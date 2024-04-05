package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.Iterator;
import utils.MyArrayList;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
    }

    @Test
    void testClear() {
        list.add("A");
        list.add("B");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void testAddAtIndex() {
        list.add(0, "A");
        list.add(1, "C");
        list.add(1, "B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testAddAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "A"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "A"));
    }

    @Test
    void testAddAtIndexNull() {
        assertThrows(NullPointerException.class, () -> list.add(0, null));
    }

    @Test
    void testAdd() {
        assertTrue(list.add("A"));
        assertTrue(list.add("B"));
        assertEquals(2, list.size());
    }

    @Test
    void testAddNull() {
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    void testAddAll() {
        MyArrayList<String> otherList = new MyArrayList<>();
        otherList.add("A");
        otherList.add("B");
        list.addAll(otherList);
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    void testAddAllNull() {
        assertThrows(NullPointerException.class, () -> list.addAll(null));
    }

    @Test
    void testGet() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testRemoveAtIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testRemoveElement() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove("B"));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveElementNull() {
        assertThrows(NullPointerException.class, () -> list.remove(null));
    }

    @Test
    void testSet() {
        list.add("A");
        list.add("B");
        assertEquals("B", list.set(1, "C"));
        assertEquals("C", list.get(1));
    }

    @Test
    void testSetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, "A"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "A"));
    }

    @Test
    void testSetNull() {
        list.add("A");
        assertThrows(NullPointerException.class, () -> list.set(0, null));
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    void testContains() {
        list.add("A");
        list.add("B");
        assertTrue(list.contains("A"));
        assertTrue(list.contains("B"));
        assertFalse(list.contains("C"));
    }

    @Test
    void testContainsNull() {
        assertThrows(NullPointerException.class, () -> list.contains(null));
    }

    @Test
    void testToArrayWithParam() {
        list.add("A");
        list.add("B");
        String[] array = new String[2];
        String[] result = list.toArray(array);
        assertArrayEquals(new String[]{"A", "B"}, result);
    }

    @Test
    void testToArrayWithParamNull() {
        assertThrows(NullPointerException.class, () -> list.toArray(null));
    }

    @Test
    void testToArray() {
        list.add("A");
        list.add("B");
        Object[] result = list.toArray();
        assertArrayEquals(new String[]{"A", "B"}, result);
    }

    @Test
    void testIterator() {
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