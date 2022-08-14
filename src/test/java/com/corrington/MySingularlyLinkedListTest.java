package com.corrington;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySingularlyLinkedListTest {

    @Test
    void addFirst() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addFirst(34);
        assertEquals( list.peekFirst(), 34);
        assertEquals(1,list.size());

        list.addFirst(27);
        assertEquals( list.peekFirst(), 27);
        assertEquals(2,list.size());

        assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));

    } // addFirst()

    @Test
    void addLast() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addLast(34);
        assertEquals( list.peekLast(), 34);
        assertEquals(1,list.size());

        list.addLast(27);
        assertEquals( list.peekLast(), 27);
        assertEquals(2,list.size());

        assertThrows(IllegalArgumentException.class, () -> list.addLast(null));

    } // addLast()

    @Test
    void contains() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addLast(27);
        list.addLast(41);
        list.addLast(69);

        assertEquals(3,list.size());
        assertTrue(list.contains(41));
        assertFalse(list.contains(73));

        assertThrows(IllegalArgumentException.class, () -> list.contains(null));

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

    } // testToString()


    @Test
    void PeekLast() {
        var list = new MySingularlyLinkedList<Integer>();
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
    } // testToString()

    @Test
    void peekAt() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        assertEquals(4, list.peekAt(0));
        assertEquals(5, list.peekAt(1));
        assertEquals(6, list.peekAt(2));
        assertEquals(7, list.peekAt(3));

        assertNull(list.peekAt(-3));
        assertNull(list.peekAt(8));

    } // peekAt()


    @Test
    void removeFrom() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);


        var n = list.removeFrom(1);
        assertEquals(5, n);
        assertEquals(4,list.size());

        n = list.removeFrom(1);
        assertEquals(6, n);
        assertEquals(3,list.size());

        n = list.removeFrom(1);
        assertEquals(7, n);
        assertEquals(2,list.size());

        n = list.removeFrom(1);
        assertEquals(8, n);
        assertEquals(1,list.size());

        assertThrows(IllegalArgumentException.class, () -> list.removeFrom(99));
        assertThrows(IllegalArgumentException.class, () -> list.removeFrom(-99));

    } // removeFrom()

    @Test
    void addAt() {
        var list = new MySingularlyLinkedList<Integer>();
        list.addLast(4);
        list.addLast(5);
        //list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addAt(6, 2);
        assertEquals("[4,5,6,7,8]", list.toString());

        list.clear();
        list.addAt(4, 0);
        assertEquals("[4]", list.toString());

        list.clear();
        list.addLast(4);
        list.addLast(5);
        list.addAt(6, 2);
        assertEquals("[4,5,6]", list.toString());

        assertThrows(IllegalArgumentException.class, () -> list.addAt(6, 99));
        assertThrows(IllegalArgumentException.class, () -> list.addAt(6, -99));
        assertThrows(IllegalArgumentException.class, () -> list.addAt(null, 0));

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

} // MySingularlyLinkedListTest