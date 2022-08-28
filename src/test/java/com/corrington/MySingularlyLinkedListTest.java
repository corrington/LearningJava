package com.corrington;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySingularlyLinkedListTest {

    @Test
    void addFirst() {
        var list = new MySingularlyLinkedList<Integer>();
        assertEquals(0, list.size());

        list.addFirst(34);
        assertEquals( 34, list.peekFirst() );
        assertEquals(1, list.size());

        list.addFirst(27);
        assertEquals( 27, list.peekFirst());
        assertEquals(2, list.size());

    } // addFirst()


    @Test
    void addLast() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addLast(34);
        assertEquals( 34, list.peekLast() );
        assertEquals(1,list.size());

        list.addLast(27);
        assertEquals( 27, list.peekLast() );
        assertEquals(2,list.size());

    } // addLast()

    @Test
    void addAll() {
        var list = new MySingularlyLinkedList<Integer>();

        list.addAll(new Integer[] {});
        assertEquals(0, list.size());

        list.clear();
        list.addAll(new Integer[] {35});
        assertEquals(1, list.size());
        assertEquals(35, list.peekFirst());

        list.clear();
        list.addAll(new Integer[] {30,41,52,63,74});
        assertEquals(5, list.size());
        assertEquals(30, list.peekFirst());
        assertEquals(41, list.peekAt(1));
        assertEquals(52, list.peekAt(2));
        assertEquals(63, list.peekAt(3));
        assertEquals(74, list.peekLast());
    } // addAll()


    @Test
    void reverse() {
        var list = new MySingularlyLinkedList<Integer>();

        list.addAll(new Integer[] {30,41,52,63,74});
        assertEquals(5, list.size());
        assertEquals(30, list.peekFirst());
        assertEquals(74, list.peekLast());

        list.reverse();

        assertEquals(5, list.size());

        assertEquals(74, list.peekFirst());
        assertEquals(63, list.peekAt(1));
        assertEquals(52, list.peekAt(2));
        assertEquals(41, list.peekAt(3));
        assertEquals(30, list.peekLast());

    } // reverse()


    @Test
    void contains() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addLast(27);
        list.addLast(41);
        list.addLast(69);
        assertEquals(3,list.size());

        assertTrue(list.contains(41));
        assertFalse(list.contains(73));

    } // contains()


    @Test
    void clear() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addLast(27);
        list.addLast(41);
        list.addLast(69);
        assertEquals(3,list.size());

        list.clear();
        assertEquals(0,list.size());
        assertNull(list.peekFirst());
        assertNull(list.peekLast());

    } // clear()


    @Test
    void removeFirst() {
        var list = new MySingularlyLinkedList<Integer>();
        Integer n = list.removeFirst();
        assertNull(n);

        list.addLast(4);
        n = list.removeFirst();
        assertEquals(4, n);
        assertEquals(0,list.size());

        list.addLast(7);
        list.addLast(23);
        n = list.removeFirst();
        assertEquals(7, n);
        assertEquals(1,list.size());

    } // removeFirst()


    @Test
    void removeLast() {
        var list = new MySingularlyLinkedList<Integer>();
        Integer n = list.removeLast();
        assertNull(n);


        list.addLast(7);
        n = list.removeLast();
        assertEquals(7, n);
        assertEquals(0,list.size());

        list.addLast(14);
        list.addLast(21);
        n = list.removeLast();
        assertEquals(21, n);
        assertEquals(1,list.size());


        n = list.removeLast();
        assertEquals(14, n);
        assertEquals(0,list.size());

        n = list.removeLast();
        assertNull(n);

    } // removeLast()


    @Test
    void size() {
        var list = new MySingularlyLinkedList<Integer>();
        int n = list.size();
        assertEquals(0, n);

        list.addLast(4);
        n = list.size();
        assertEquals(1, n);

        list.addLast(9);
        list.addLast(78);
        n = list.size();
        assertEquals(3, n);

        list.removeFirst();
        n = list.size();
        assertEquals(2, n);

        list.removeLast();
        list.removeLast();
        n = list.size();
        assertEquals(0, n);

    } // size()


    @Test
    void testToString() {
        var list = new MySingularlyLinkedList<Integer>();
        assertEquals("[]", list.toString());

        list.addLast(4);
        assertEquals("[4]", list.toString());

        list.addLast(5);
        assertEquals("[4,5]", list.toString());

        list.addLast(6);
        assertEquals("[4,5,6]", list.toString());

    } // testToString()


    @Test
    void PeekFirst() {
        var list = new MySingularlyLinkedList<Integer>();
        assertNull(list.peekFirst());

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        assertEquals(4, list.peekFirst());

        list.removeFirst();
        assertEquals(5, list.peekFirst());

        list.removeFirst();
        assertEquals(6, list.peekFirst());

        list.removeFirst();
        assertNull(list.peekFirst());

    } // PeekFirst()


    @Test
    void PeekLast() {
        var list = new MySingularlyLinkedList<Integer>();
        assertNull(list.peekLast());

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        assertEquals(6, list.peekLast());

        list.removeLast();
        assertEquals(5, list.peekLast());

        list.removeLast();
        assertEquals(4, list.peekLast());

        list.removeLast();
        assertNull(list.peekLast());
    } // PeekLast()


    @Test
    void peekAt() {
        var list = new MySingularlyLinkedList<Integer>();
        assertTrue(list.isEmpty());
        assertNull(list.peekAt(0));

        list.addLast(4);
        assertFalse(list.isEmpty());
        assertEquals(4, list.peekAt(0));

        list.addLast(5);
        assertEquals(5, list.peekAt(1));

        list.addLast(6);
        assertEquals(6, list.peekAt(list.size() - 1));

        assertEquals(3, list.size());

        // making sure there is no "off by one" bug
        assertThrows(IllegalArgumentException.class, () -> list.peekAt(3));

        // just like an array, you can use a negative index to access an element
        assertThrows(IllegalArgumentException.class, () -> list.peekAt(-1));

        // and you can't access an element that isn't there
        assertThrows(IllegalArgumentException.class, () -> list.peekAt(4));

    } // peekAt()


    @Test
    void removeFrom() {
        var list = new MySingularlyLinkedList<Integer>();
        // ensure you can't remove something from an empty list
        assertThrows(IllegalArgumentException.class, () -> list.removeFrom(0));

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        assertEquals(4, list.size());

        // remove from the front of the list
        var n = list.removeFrom(0);
        assertEquals(4, n);
        assertEquals(3,list.size());

        // remove from the middle of the list
        n = list.removeFrom(1);
        assertEquals(6, n);
        assertEquals(2, list.size());

        // remove from the end of the list
        n = list.removeFrom(list.size() - 1);
        assertEquals(7, n);
        assertEquals(1, list.size());

        // checking the boundaries
        assertThrows(IllegalArgumentException.class, () -> list.removeFrom(-1));
        assertThrows(IllegalArgumentException.class, () -> list.removeFrom(1));

    } // removeFrom()


    @Test
    void addAt() {
        var list = new MySingularlyLinkedList<Integer>();

        // add a value to the start of an empty list
        assertTrue(list.isEmpty());
        list.addAt(4, 0);
        assertEquals(4, list.peekAt(0));

        // insert a value into the middle of a populated list
        list.clear();
        assertEquals(0, list.size());
        list.addLast(4);
        assertEquals(4, list.peekAt(0));
        list.addLast(6);
        assertEquals(6, list.peekAt(1));
        assertEquals(2, list.size());
        list.addAt(5, 1);
        assertEquals(5, list.peekAt(1));
        assertEquals(6, list.peekAt(2));
        assertEquals("[4,5,6]", list.toString());
        assertEquals(3, list.size());

        // add a value to the end of a populated list
        list.clear();
        assertEquals(0, list.size());
        list.addLast(4);
        assertEquals(4, list.peekAt(0));
        assertEquals(1, list.size());
        list.addAt(5, list.size());
        assertEquals(5, list.peekAt(1));
        assertEquals(2, list.size());


        // ensure there is no "off by one" bug
        assertThrows(IllegalArgumentException.class, () -> list.addAt(6, -1));
        assertThrows(IllegalArgumentException.class, () -> list.addAt(6, 3));
        // and confirm the outer boundaries
        assertThrows(IllegalArgumentException.class, () -> list.addAt(6, -99));
        assertThrows(IllegalArgumentException.class, () -> list.addAt(6, 99));

    } // addAt()


    @Test
    void equals() {
        var list1 = new MySingularlyLinkedList<Integer>();
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);

        var list2 = new MySingularlyLinkedList<Integer>();
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        assertEquals(list1, list2);

        var list3 = new MySingularlyLinkedList<Integer>();
        list3.addLast(4);
        list3.addLast(5);
        list3.addLast(88);
        list3.addLast(7);
        list3.addLast(8);
        assertNotEquals(list1, list3);

        var list4 = new MySingularlyLinkedList<Integer>();
        list4.addLast(4);
        list4.addLast(5);
        assertNotEquals(list1, list4);

        var list5 = new MySingularlyLinkedList<Character>();
        list5.addLast('4');
        list5.addLast('5');
        list5.addLast('6');
        list5.addLast('7');
        list5.addLast('8');
        assertNotEquals(list1, list5);

    } // equals


    @Test
    void isEmpty() {
        var list = new MySingularlyLinkedList<Integer>();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        list.addLast(7);
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    } // isEmpty()


} // MySingularlyLinkedListTest