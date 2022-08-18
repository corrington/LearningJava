package com.corrington;

import java.util.Objects;

public class MyDoublyLinkedList<E> {

    static class Node<E> {
        private E element;
        private Node<E> prevNode;
        private Node<E> nextNode;


        Node(E element) {
            this.element = element;
            this.prevNode = null;
            this.nextNode = null;
        } // Node<E>()

        void clear() {
            this.element = null;
            this.prevNode = null;
            this.nextNode = null;
        } // clear()

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (this == obj) return true;
            if (!(obj instanceof Node))
                return false;

            @SuppressWarnings("unchecked") final Node<E> otherNode = (Node<E>)obj;

            if (!Objects.equals(this.element, otherNode.element)) return false;
            if (!Objects.equals(this.prevNode, otherNode.prevNode)) return false;
            return Objects.equals(this.nextNode, otherNode.nextNode);
        } // equals()

        @Override
        public int hashCode() {
            int result = this.element != null ? this.element.hashCode() : 0;
            result = 31 * result + (this.prevNode != null ? this.prevNode.hashCode() : 0);
            result = 31 * result + (this.nextNode != null ? this.nextNode.hashCode() : 0);
            return result;
        } // hashCode()

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + this.element +
                    ", prevNode=" + this.prevNode +
                    ", nextNode=" + this.nextNode +
                    '}';
        } // toString()

    } // class Node




    private Node<E> head;
    private Node<E> tail;
    private int size;


    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    } // constructor


    public void addFirst(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        Node<E> node = new Node<>(element);

        if (this.head == null) {
            // setting up the head and tail for the first time
            this.head = node;
            this.tail = node;
        } else {
            // replacing the current head with a new head
            this.head.prevNode = node;
            node.nextNode = this.head;
            this.head = node;
        } // if

        this.size++;

    } // addFirst()


    public void addLast(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        Node<E> node = new Node<>(element);

        if (this.tail == null) {
            // setting up the head for the first time
            this.head = node;
        } else {
            // replacing the current tail with a new tail
            this.tail.nextNode = node;
            node.prevNode = this.tail;
        } // if

        this.tail = node;
        this.size++;

    } // addLast


    // if 0 < i < index, insert
    public void addAt(E element, int index) {
        // add the new element to the front of the list
        if ((index == 0)){
            addFirst(element);
            return;
        } // if

        // add the new element to the back of the list
        if ((index == this.size)) {
            addLast(element);
            return;
        } // if

        if ((index < 0) || (index > this.size)) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds");
        }

        // add the new element somewhere in the middle of the list
        Node<E> prevNode = this.head;
        Node<E> newNode = new Node<>(element);

        // find the node that is before the insertion point
        for (int i = 0; i < (index - 1); i++) {
            prevNode = prevNode.nextNode;
        } // for i

        // set the next node to be one after the insertion point
        Node<E> nextNode = prevNode.nextNode;

        prevNode.nextNode = newNode;
        newNode.prevNode = prevNode;
        newNode.nextNode = nextNode;
        nextNode.prevNode = newNode;
        this.size++;

    } // addAt()


    public E peekAtFirst() {
        if (isEmpty()) return null;
        return this.head.element;
    } // peekAtFirst()


    public E peekAtLast() {
        if (isEmpty()) return null;
        return this.tail.element;
    } // peekAtLast()


    public E peekAt(int index) {
        if (isEmpty()) return null;
        if ((index < 0) || (index >= this.size)) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds");
        }
        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        } // for i
        return node.element;
    } // peelAt()


    public E removeFirst() {
        if (isEmpty()) return null;

        E element = this.head.element;

        if (this.size == 1) {
            clear();
        } else {
            Node<E> nextNode = this.head.nextNode;
            this.head.clear();
            this.head = nextNode;
            this.head.prevNode = null;
            this.size--;
        } // if
        return element;
    } // removeFirst()


    public E removeLast() {
        if (isEmpty()) return null;

        E element = this.tail.element;

        if (this.size == 1) {
            clear();
        } else {
            Node<E> prevNode = this.tail.prevNode;
            this.tail.clear();
            this.tail = prevNode;
            this.tail.nextNode = null;
            this.size--;
        } // if
        return element;
    } // removeLast()


    public E removeAt(int index) {
        if ((index < 0) || (index >= this.size)) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds");
        } // if

        // remove the first node?
        if (index == 0) {
            return removeFirst();
        }

        // remove the last node?
        if (index == (this.size - 1)) {
            return removeLast();
        }

        // walk thru the list until we find the node we're looking for
        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        } // for i

        // save a copy of the element
        E element = node.element;

        if (this.size() == 1) {
            clear();
        } else {
            Node<E> prevNode = node.prevNode;
            Node<E> nextNode = node.nextNode;
            prevNode.nextNode = nextNode;
            nextNode.prevNode = prevNode;
            node.clear();
            this.size--;
        } // if

        return element;
    } // removeAt()


    // Replaces the element at the specified position in this list with the specified element.
    // Returns the element previously at the specified position
    public E set(int index, E element) {
        if (isEmpty()) return null;

        if ((index < 0) || (index >= this.size)) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds");
        }

        Node<E> node = this.head;

        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        } // for i

        E savedElement = node.element;
        node.element = element;

        return savedElement;

    } // set()


    // Complexity: O(n)
    public void clear() {
        if (isEmpty()) return;

        Node<E> node = this.head;
        for (int i = 0; i < this.size; i++) {
            node.element = null;
            node.prevNode = null;
            Node<E> temp = node.nextNode;
            node.nextNode = null;
            node = temp;
        } // for i

        this.head = null;
        this.tail = null;
        this.size = 0;
    } // clear()


    public int size() {
        return this.size;
    } // size()


    // returns true if a matching element was found; otherwise false
    // Complexity: O(n)
    public boolean contains(E element) {
        if (isEmpty()) return false;
        Node<E> node = this.head;
        for (int i = 0; i < this.size; i++) {
            if (node.element.equals(element)) return true;
            node = node.nextNode;
        } // for i
        return false;
    } // contains()


    // returns the index of the matching element; otherwise returns -1 indicating element was not found
    // Complexity: O(n)
    public int indexOf(E element) {
        if (isEmpty()) return -1;
        Node<E> node = this.head;
        for (int i = 0; i < this.size; i++) {
            if (node.element.equals(element)) return i;
            node = node.nextNode;
        } // for i
        return -1; // indicating element was not found
    } // indexOf()


    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        Node<E> node = this.head;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.size; i++) {
            if (node != null) {
                if (node.element != null) {
                    sb.append(node.element);
                } else {
                    sb.append(" ");
                }
                node = node.nextNode;
            } // if
            if (i < (this.size - 1)) sb.append(",");
        } // for
        sb.append("]");
        return sb.toString();
    } // toString()

    public boolean isEmpty() {
        return (this.head == null);
    } // isEmpty()


} // class MyDoublyLinkedList
