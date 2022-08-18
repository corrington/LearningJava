package com.corrington;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {

    @Test
    void addFirst() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());

        list.addFirst(12); // after [12]
        assertEquals("[12]", list.toString());
        assertEquals(12, list.peekAtLast());
        assertEquals(1, list.size());

        list.addFirst(27); // after [27,12]
        assertEquals("[27,12]", list.toString());
        assertEquals(27, list.peekAtFirst());
        assertEquals(12, list.peekAtLast());
        assertEquals(2, list.size());

        list.addFirst(35); // after [35,27,12]
        assertEquals("[35,27,12]", list.toString());
        assertEquals(35, list.peekAtFirst());
        assertEquals(27, list.peekAt(1));
        assertEquals(12, list.peekAtLast());

        assertEquals(3, list.size());

        list.addFirst(43); // [43,35,27,12]
        assertEquals("[43,35,27,12]", list.toString());
        assertEquals(43, list.peekAtFirst());
        assertEquals(35, list.peekAt(1));
        assertEquals(27, list.peekAt(2));
        assertEquals(12, list.peekAtLast());
        assertEquals(4, list.size());
    } // addFirst()


    @Test
    void addLast() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());

        list.addLast(12); // [12]
        assertEquals(12, list.peekAtLast());
        assertEquals(1, list.size());

        list.addLast(27); // [12,27]
        assertEquals("[12,27]", list.toString());
        assertEquals(12, list.peekAtFirst());
        assertEquals(27, list.peekAtLast());
        assertEquals(2, list.size());

        list.addLast(35); // after [12,27,35]
        assertEquals("[12,27,35]", list.toString());
        assertEquals(12, list.peekAtFirst());
        assertEquals(27, list.peekAt(1));
        assertEquals(35, list.peekAtLast());
        assertEquals(3, list.size());

        list.addLast(43);  // after [12,27,35,43]
        assertEquals("[12,27,35,43]", list.toString());
        assertEquals(12, list.peekAtFirst());
        assertEquals(27, list.peekAt(1));
        assertEquals(35, list.peekAt(2));
        assertEquals(43, list.peekAtLast());
        assertEquals(4, list.size());
    } // addLast()


    // addAt(n,list.size()) appends value to end of list
    @Test
    void addAt() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());

        list.addAt(12, 0);                      // add first item in the list
        assertEquals(12, list.peekAt(0));
        assertEquals(1, list.size());
        assertEquals(12, list.peekAtFirst());

        list.addAt(23, 1);                      // add last item in the list
        assertEquals(12, list.peekAtFirst());
        assertEquals(23, list.peekAt(1));
        assertEquals(2, list.size());

        list.addAt(5, 0);                      // add new first item in the list
        assertEquals(5, list.peekAt(0));
        assertEquals(12, list.peekAt(1));
        assertEquals(23, list.peekAt(2));
        assertEquals(3, list.size());

        list.addAt(9, 1);                      // add in the middle of the list
        assertEquals(5, list.peekAt(0));
        assertEquals(9, list.peekAt(1));
        assertEquals(12, list.peekAt(2));
        assertEquals(23, list.peekAt(3));
        assertEquals(4, list.size());

        list.addAt(17, 3);                      // add in the middle of the list
        assertEquals(5, list.peekAt(0));
        assertEquals(9, list.peekAt(1));
        assertEquals(12, list.peekAt(2));
        assertEquals(17, list.peekAt(3));
        assertEquals(23, list.peekAt(4));
        assertEquals(5, list.size());

        // check for out of bounds exception throwing
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(0xDEADBEEF, -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(0xDEADBEEF, list.size() + 1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(0xDEADBEEF, 666));
    } // addAt()


    @Test
    void peekAtFirst() {
        var list = new MyDoublyLinkedList<Integer>();
        assertNull(list.peekAtLast());
        assertEquals(0, list.size());

        list.addLast(12); // after [12]
        assertEquals(12, list.peekAtFirst());
        assertEquals(1, list.size());

        list.addLast(25); // after [12,25]
        assertEquals(12, list.peekAtFirst());
        assertEquals(25, list.peekAtLast());
        assertEquals(2, list.size());

        list.addFirst(8); // after [8,12,25]
        assertEquals(8, list.peekAtFirst());
        assertEquals(25, list.peekAtLast());
        assertEquals(3, list.size());
    } // peekAtFirst()


    @Test
    void peekAtLast() {
        var list = new MyDoublyLinkedList<Integer>();
        assertNull(list.peekAtLast());
        assertEquals(0, list.size());

        list.addLast(12);
        assertEquals(12, list.peekAtLast());
        assertEquals(1, list.size());

        list.addLast(25);
        assertEquals(25, list.peekAtLast());
        assertEquals(2, list.size());

        list.addFirst(8);
        assertEquals(25, list.peekAtLast());
        assertEquals(3, list.size());
    } // peekAtLast()


    @Test
    void peekAt() {
        var list = new MyDoublyLinkedList<Integer>();
        assertNull(list.peekAt(0));
        assertEquals(0, list.size());

        list.addLast(12);
        assertEquals(12, list.peekAt(0));
        assertEquals(1, list.size());

        list.addLast(25);
        assertEquals(25, list.peekAt(1));
        assertEquals(2, list.size());

        list.addLast(37);
        assertEquals(37, list.peekAt(2));
        assertEquals(3, list.size());

        // check for out of bounds exception throwing
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.peekAt(list.size()));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.peekAt(-666));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.peekAt(666));
    } // peekAt()


    @Test
    void set() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());
        list.addFirst(12);
        assertEquals(1, list.size());
        assertEquals(12, list.peekAt(0));
        assertEquals(12, list.set(0, 14));  // was [12], after [14]
        assertEquals(1, list.size());
        assertEquals(14, list.peekAt(0));

        list.addLast(16);
        assertEquals(2, list.size());
        assertEquals(16, list.peekAt(1));
        assertEquals(16, list.set(1, 18)); // was [14,16], after [14,18]
        assertEquals(2, list.size());
        assertEquals(14, list.peekAtFirst());
        assertEquals(18, list.peekAt(1));

        // check for out of bounds exception throwing
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 0xDEADBEEF));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(list.size(), 0xDEADBEEF));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(666, 0xDEADBEEF));
    } // set()


    @Test
    void clear() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());
        list.clear();
        assertEquals(0, list.size());

        list.addLast(12);
        assertEquals(1, list.size());
        list.addLast(25);
        assertEquals(2, list.size());
        list.addLast(37);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    } // clear()


    @Test
    void size() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());
        list.addLast(12);
        assertEquals(1, list.size());
        list.addLast(25);
        assertEquals(2, list.size());
        list.addLast(37);
        assertEquals(3, list.size());
    } // size()


    @Test
    void toStringTest() {
        var list = new MyDoublyLinkedList<Integer>();
        list.addLast(12);
        assertEquals("[12]", list.toString());
        list.addLast(27);
        assertEquals("[12,27]", list.toString());
        list.addLast(35);
        assertEquals("[12,27,35]", list.toString());
        list.addLast(43);
        assertEquals("[12,27,35,43]", list.toString());
    } // toStringTest()


    @Test
    void removeFirst() {
        var list = new MyDoublyLinkedList<Integer>();
        list.addLast(12);
        assertEquals(12, list.removeFirst());
        assertEquals(0, list.size());

        list.clear();
        list.addLast(12);
        list.addLast(25);
        assertEquals(12, list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(25, list.peekAtFirst());

        list.clear();
        list.addLast(12);
        list.addLast(25);
        list.addLast(37);
        assertEquals(12, list.removeFirst());
        assertEquals(2, list.size());
        assertEquals(25, list.peekAtFirst());
        assertEquals(37, list.peekAt(1));
    } // removeFirst()


    @Test
    void removeLast() {
        var list = new MyDoublyLinkedList<Integer>();
        list.addLast(12);
        assertEquals(12, list.removeLast());
        assertEquals(0, list.size());

        list.clear();
        list.addLast(12);
        list.addLast(25);
        assertEquals(25, list.removeLast());
        assertEquals(1, list.size());
        assertEquals(12, list.peekAtFirst());

        list.clear();
        list.addLast(12);
        list.addLast(25);
        list.addLast(37);
        assertEquals(37, list.removeLast());
        assertEquals(2, list.size());
        assertEquals(12, list.peekAtFirst());
        assertEquals(25, list.peekAt(1));
    } // removeLast()


    @Test
    void removeAt() {
        var list = new MyDoublyLinkedList<Integer>();
        list.addLast(12);
        assertEquals(12, list.removeAt(0));
        assertEquals(0, list.size());

        //list.clear();
        list.addLast(12);
        list.addLast(25);
        assertEquals(12, list.removeAt(0));
        assertEquals(25, list.peekAtFirst());
        assertEquals(1, list.size());
        assertEquals(25, list.removeAt(0));
        assertEquals(0, list.size());

        //list.clear();
        list.addLast(12);
        list.addLast(25);
        list.addLast(37);
        assertEquals(37, list.removeAt(2)); // after [12,25]
        assertEquals(12, list.peekAtFirst());
        assertEquals(25, list.peekAt(1));
        assertEquals(2, list.size());
        assertEquals(12, list.removeAt(0)); // after [25]
        assertEquals(25, list.peekAtFirst());
        assertEquals(1, list.size());

        list.clear();
        list.addLast(12); // [0]
        list.addLast(25); // [1]
        list.addLast(37); // [2]
        list.addLast(48); // [3]
        assertEquals(37, list.removeAt(2)); // after [12,25,48]
        assertEquals(3, list.size());
        assertEquals(12, list.peekAtFirst());
        assertEquals(25, list.peekAt(1));
        assertEquals(48, list.peekAt(2));
        assertEquals(25, list.removeAt(1)); // after [12,48]
        assertEquals(2, list.size());
        assertEquals(12, list.peekAtFirst());
        assertEquals(48, list.peekAt(1));
        assertEquals(12, list.removeAt(0)); // after [48]
        assertEquals(48, list.peekAtFirst());
        assertEquals(1, list.size());

        // check for out of bounds exception throwing
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(list.size()));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(666));
    } // removeAt()


    @Test
    void contains() {
        var list = new MyDoublyLinkedList<Integer>();
        assertFalse(list.contains(13));

        list.addLast(12);
        assertEquals(1, list.size());
        assertTrue(list.contains(12));
        assertFalse(list.contains(13));

        list.addLast(27);
        assertEquals(2, list.size());
        //System.out.println(list + " size=" + list.size());
        assertTrue(list.contains(12));
        assertTrue(list.contains(27));
        assertFalse(list.contains(37));

        list.addLast(34);
        assertEquals(3, list.size());
        //System.out.println(list + " size=" + list.size());
        assertTrue(list.contains(12));
        assertTrue(list.contains(27));
        assertTrue(list.contains(34));
        assertFalse(list.contains(48));
    } // contains()


    @Test
    void indexOf() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals( -1, list.indexOf(13));

        list.addLast(12);
        assertEquals( 1, list.size());
        assertEquals( 0, list.indexOf(12));
        assertEquals(-1, list.indexOf(13));

        list.addLast(27);
        assertEquals(2, list.size());
        //System.out.println(list + " size=" + list.size());
        assertEquals( 0, list.indexOf(12));
        assertEquals( 1, list.indexOf(27));
        assertEquals(-1, list.indexOf(37));

        list.addLast(34);
        assertEquals(3, list.size());
        //System.out.println(list + " size=" + list.size());
        assertEquals( 0, list.indexOf(12));
        assertEquals( 1, list.indexOf(27));
        assertEquals( 2, list.indexOf(34));
        assertEquals(-1, list.indexOf(48));
    } // indexOf()


    @Test
    void isEmpty() {
        var list = new MyDoublyLinkedList<Integer>();

        assertTrue( list.isEmpty());
        assertEquals(0, list.size());

        list.addLast(34);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    } // isEmpty()

} // class MyDoublyLinkedListTest