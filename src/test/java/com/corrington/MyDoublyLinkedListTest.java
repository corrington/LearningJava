package com.corrington;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {

    @Test
    void addFirst() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());

        list.addFirst(12);
        assertEquals("[12]", list.toString());
        assertEquals(1, list.size());

        list.addFirst(27);
        assertEquals("[27,12]", list.toString());
        assertEquals(2, list.size());

        list.addFirst(35);
        assertEquals("[35,27,12]", list.toString());
        assertEquals(3, list.size());

        list.addFirst(43);
        assertEquals("[43,35,27,12]", list.toString());
        assertEquals(4, list.size());
    } // addFirst()

    @Test
    void addLast() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());

        list.addLast(12);
        assertEquals("[12]", list.toString());
        assertEquals(1, list.size());

        list.addLast(27);
        assertEquals("[12,27]", list.toString());
        assertEquals(2, list.size());

        list.addLast(35);
        assertEquals("[12,27,35]", list.toString());
        assertEquals(3, list.size());

        list.addLast(43);
        assertEquals("[12,27,35,43]", list.toString());
        assertEquals(4, list.size());
    } // addLast()

    @Test
    void addAt() {
        var list = new MyDoublyLinkedList<Integer>();
        assertEquals(0, list.size());

        list.addAt(12, 0);                      // add first item in the list
        assertEquals(12, list.peekAt(0));
        assertEquals(1, list.size());

        list.addAt(23, 1);                      // add last item in the list
        assertEquals(12, list.peekAt(0));
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
    } // addAt()

    @Test
    void peekAtFirst() {
        var list = new MyDoublyLinkedList<Integer>();
        assertNull(list.peekAtLast());
        assertEquals(0, list.size());

        list.addLast(12);
        assertEquals(12, list.peekAtFirst());
        assertEquals(1, list.size());

        list.addLast(25);
        assertEquals(12, list.peekAtFirst());
        assertEquals(2, list.size());

        list.addFirst(8);
        assertEquals(8, list.peekAtFirst());
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.peekAt(list.size()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.peekAt(-666));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.peekAt(666));
    } // peekAt()


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

        list.clear();
        list.addLast(12);
        list.addLast(25);
        list.addLast(37);
        assertEquals(12, list.removeFirst());
        assertEquals(2, list.size());

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

        list.clear();
        list.addLast(12);
        list.addLast(25);
        list.addLast(37);
        assertEquals(37, list.removeLast());
        assertEquals(2, list.size());
    } // removeLast()
/*
    @Test
    void removeAt() {
        var list = new MyDoublyLinkedList<Integer>();
        list.addLast(12);
        assertEquals(12, list.removeAt(0));
        assertEquals(0, list.size());

        list.clear();
        list.addLast(12);
        list.addLast(25);
        assertEquals(25, list.removeLast());
        assertEquals(1, list.size());

        list.clear();
        list.addLast(12);
        list.addLast(25);
        list.addLast(37);
        assertEquals(37, list.removeLast());
        assertEquals(2, list.size());
    } // removeAt()
*/
    @Test
    void contains() {
        // TODO: Implement
    } // contains()

    @Test
    void indexOf() {
        // TODO: Implement
    } // indexOf()
} // class MyDoublyLinkedListTest