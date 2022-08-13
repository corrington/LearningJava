package com.corrington;

import java.util.ArrayList;
import java.util.EmptyStackException;

//  a bounded stack data structure, the capacity is fixed to a certain size
public class MyStaticStack<E> {
    final private ArrayList<E> elements;
    final private int MAX_CAPACITY;

    public MyStaticStack(int capacity) throws EmptyStackException {
        if (capacity < 1) {
            throw new EmptyStackException();
        }
        this.MAX_CAPACITY = capacity;
        this.elements = new ArrayList<>(this.MAX_CAPACITY);
    } // MyStack() constructor

    public boolean isEmpty() {
        return this.elements.isEmpty();
    } // isEmpty()

    public boolean isFull() {
        return this.elements.size() == this.MAX_CAPACITY;
    } // isFull()

    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } // if
        return this.elements.get(0);
    } // peek()

    public void push(E item) throws FullStackException {
        if (isFull()) {
            throw new FullStackException("stack is full");
        } // if
        this.elements.add(item);
    } // push()

    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } // if
        var item = this.elements.remove(this.elements.size() - 1); // retrieve the last item
        return item;
    } // pop()

    // Returns:
    // The 1-based position from the top of the stack where the object is located.
    // the return value -1 indicates that the object is not on the stack.
    public int search(E item) {
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).equals(item)) return i + 1;
        } // for
        return -1;
    } // search()

    @Override
    public String toString() {
        return "MyStaticStack{" +
                "elements=" + this.elements +
                ", size=" + this.elements.size() +
                ", capacity=" + this.MAX_CAPACITY +
                '}';
    } // toString()

    public Object[] toArray() {
        Object[] items = this.elements.toArray();
        return items;
    } // toArray()

} // class MyStaticStack
