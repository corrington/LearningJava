package com.corrington;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStaticStackTest {

    @Test
    void isEmpty() {
        var stack = new MyStaticStack<Integer>( 5);

        stack.push(27);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    } //  isEmpty()

    @Test
    void isFull() {
        var stack = new MyStaticStack<Integer>( 1);

        assertFalse(stack.isFull());

        stack.push(27);
        assertTrue(stack.isFull());
    } // isFull()

    @Test
    void peek() {
        var stack = new MyStaticStack<Integer>( 2);
        stack.push(27);
        stack.push(41);
        assertEquals(stack.peek(), 27);

        // attempt to peek into an empty stack
        var stack2 = new MyStaticStack<Integer>( 2);
        assertThrows(EmptyStackException.class, stack2::peek);
    } // peek()

    @Test
    void push() {
        var stack = new MyStaticStack<Integer>( 2);
        stack.push(27);
        assertEquals(stack.peek(), 27);
        var item = stack.pop();
        assertEquals(item, 27);

        // attempt to push too many items onto the stack
        var stack2 = new MyStaticStack<Integer>( 1);
        stack2.push(47);
        assertThrows(FullStackException.class, () -> stack2.push(78));
    } // push()

    @Test
    void pop() {
        var stack = new MyStaticStack<Integer>( 2);
        stack.push(27);
        assertEquals(stack.peek(), 27);
        var item = stack.pop();
        assertEquals(item, 27);

        // attempt to pop too many items from the stack
        var stack2 = new MyStaticStack<Integer>( 1);
        stack2.push(47);
        stack2.pop();
        assertThrows(EmptyStackException.class, stack2::pop);
    } // pop()

    @Test
    void search() {
        var stack = new MyStaticStack<Integer>( 2);
        stack.push(27);
        assertEquals(stack.search(27), 1);
        assertEquals(stack.search(45), -1);
        var item = stack.pop();
        assertEquals(item, 27);
        assertEquals(stack.search(27), -1);
    } // search()

    @Test
    void testToString() {
        var stack = new MyStaticStack<Integer>( 2);
        stack.push(27);
        String expected = "MyStaticStack{" +
                "elements=" + "[27]" +
                ", size=" + 1 +
                ", capacity=" + 2 +
                "}";
        assertEquals(expected, stack.toString());
    } // testToString()

    @Test
    void testToArray() {
        var stack = new MyStaticStack<Integer>( 3);
        stack.push(27);
        stack.push(51);
        stack.push(84);
        Object[] objs = stack.toArray();
        // convert an array of objects (Integer) into an array of primitive ints
        int[] ints = Arrays.stream(objs).mapToInt(o -> (int)o).toArray();

        assertEquals(3, ints.length);
        assertEquals(27, ints[0]);
        assertEquals(51, ints[1]);
        assertEquals(84, ints[2]);

    } // testToArray()

} // class MyStaticStackTest