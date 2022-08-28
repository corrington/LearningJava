package com.corrington;

public class MySingularlyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static final String INDEX_OUT_OF_BOUNDS = "index is out of bounds";

    public MySingularlyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    } // MySingularlyLinkedList() constructor


    // add a new node to the start of the list
    public void addFirst(final E element) {

        var newNode = new Node<>(element);
        this.size++;

        if (isEmpty()) {            // if the list is empty, we have to
            this.tail = newNode;    // set the tail too.
        } // if

        newNode.next = this.head;   // make the new node point to the old head
        this.head = newNode;        // make the new node the head of the list


    } // addFirst()


    // Add a new element to the end of the list
    public void addLast(final E element) {

        var newNode = new Node<>(element);
        this.size++;

        if (isEmpty()) {
            // add first node to the list
            this.head = newNode;
        } else {
            // make the current last node point to the new last node
            this.tail.next = newNode;
        } // if

        this.tail = newNode;

    } // addLast()


    // Inserts the specified element at the specified position in this list.
    // Shifts the element currently at that position (if any) and any subsequent elements
    // to the right (adds one to their indices).
    // You can add a new node to the start of an empty list: list.addAt(7, 0);
    // And you can add a new node to the end of list: list.addAt(7, list.size());
    // But not beyond that.
    public void addAt(final E element, final int index) {
        if ((index < 0) || (index > this.size)) {
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS);
        }

        if (index == 0) {
            // adding a new first node
            this.addFirst(element);
        } else if (index == this.size) {
            // adding a new last node
            this.addLast(element);
        } else {
            // somewhere in the middle then
            Node<E> prevNode = this.head;
            Node<E> currNode = this.head.next;
            int currNodeIndex = 1;

            // walk thru the list until we find the proper position for the insertion
            while (currNodeIndex != index) {
                prevNode = currNode;
                currNode = currNode.next;
                currNodeIndex ++;
            } // while

            // insert the new node
            Node<E> newNode = new Node<>(element);
            newNode.next = currNode;
            prevNode.next = newNode;
            this.size++;

        } // if

    } // addAt()


    // adds all of the elements in an array into the linked list
    public void addAll(final E[] elements) {
        for (var element : elements) {
            addLast(element);
        } // for element
    } // addAll()


    // Retrieves, but does not remove, the first element in the list.
    // Returns: the first element in the list, or null if this list is empty
    public E peekFirst() {
        if (isEmpty()) return null;
        return this.head.element;
    } // peekFirst()


    // Retrieves, but does not remove, the last element in the list.
    // Returns: the last element in the list, or null if this list is empty
    public E peekLast() {
        if (isEmpty()) return null;
        return this.tail.element;
    } // peekLast()


    // just like an array, you can peek at the elements that are within the boundaries list,
    // but not outside (e.g., less than or greater than).
    public E peekAt(final int index) {
        if (isEmpty()) return null;     // just like the other peeks

        // if we have a list, just like an array, the index must be within bounds.
        if ((index < 0) || (index >= this.size)) {
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS);
        }

        if (index == 0) return this.head.element;
        if (index == (this.size - 1)) return this.tail.element;

        Node<E> node = this.head;
        int nodeIndex = 0;
        while (nodeIndex != index) {
            node = node.next;
            nodeIndex++;
        } // while

        return node.element;

    } // peekAt()


    // remove the first node from the front of the list, and return the element
    public E removeFirst() {
        if (this.head == null) return null;
        E element = this.head.element;
        if (this.size == 1) {
            clear();
        } else {
            var next = this.head.next;
            this.head.element = null;               // to ensure the element is garbage collected
            this.head.next = null;
            this.head = next;
            this.size--;
        } // if
        return element;
    } // removeFirst()


    // Removes and returns the last element from this list.
    public E removeLast() {
        if (this.size == 0) return null;

        E element = this.tail.element;

        if (this.size == 1) {
            clear();
        } else {
            // since we have multiple elements in the list,
            // first, find the second to last node (n-1)
            var node = this.head;
            while (node.next != this.tail) {
                node = node.next;
            } // while
            // then we lop-off the tail
            this.tail.element = null;
            this.tail = node;
            this.tail.next = null;
            this.size--;
        } // if

        return element;

    } // removeLast()


    // removes and returns the element at the specified index in this list.
    public E removeFrom(final int index) {
        if ((index < 0) || (index >= this.size)) {
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS);
        }
        if (this.head == null) return null;

        if (index == 0) return removeFirst();
        if (index == (this.size - 1)) return removeLast();

        // walk thru the list to find the correct position
        Node<E> prevNode = this.head;
        Node<E> currNode = this.head.next;
        int currNodeIndex = 1;
        while (currNodeIndex != index) {
            prevNode = currNode;
            currNode = currNode.next;
            currNodeIndex++;
        } // while

        // save the element
        E element = currNode.element;
        currNode.element = null;

        // "bypass" the current node
        prevNode.next = currNode.next;
        this.size--;

        return element;

    } // removeFrom()


    // Returns true if this list contains the specified element. Otherwise, false.
    public boolean contains(final E element) {

        var node = this.head;
        while (node != null) {
            if (node.element.equals(element)) return true;
            node = node.next;
        } // while
        return false;
    } // contains()


    public void clear() {
        Node<E> node = this.head;       // Walk through the list nulling the elements
        while (node != null) {          // to ensure there are no dangly references.
            node.element = null;        // null the reference to the data to ensure it can be garbage collected
            Node<E> next = node.next;
            node.next = null;           // null the reference to the next node so it can be garbage collected too
            node = next;
        } // while
        this.head = null;
        this.tail = null;
        this.size = 0;
    } // clear()


    public int size() {
        return this.size;
    } // size()


    public boolean isEmpty() {
        return this.head == null;
    } // isEmpty()


    // simply reverses the nodes in the list
    public void reverse() {
        if (isEmpty()) return;
        if (this.size == 1) return;

        Node<E> oldHeadNode = this.head;

        Node<E> prevNode = null;
        Node<E> currNode = this.head;

        while (currNode != null) {
            Node<E> nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        } // while

        this.head = prevNode;
        this.tail = oldHeadNode;

    } // reverse()


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        Node<E> node = this.head;
        while (node != null) {
            if (node != this.head) sb.append(",");
            sb.append(node.element);
            node = node.next;
        } // while
        sb.append("]");

        return sb.toString();
    } // toString()


    // Compares the elements of the two lists.
    // The number, order, and value of elements must be the same.
    // Their specific locations in memory are ignored
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MySingularlyLinkedList<?> otherList = (MySingularlyLinkedList<?>) obj;

        if (this.size != otherList.size) return false;

        Node<E> node = this.head;
        MySingularlyLinkedList.Node<?> otherNode = otherList.head;

        while (node != null) {
            if (!node.element.equals(otherNode.element)) return false;
            node = node.next;
            otherNode = otherNode.next;
        } // while

        return true;

    } // equals()

    @Override
    public int hashCode() {
        int result = this.head.hashCode();
        result = 31 * result + this.tail.hashCode();
        result = 31 * result + this.size;
        return result;
    } // hashCode()


    /*
     *
     */
    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T t) {
            this.element = t;
            this.next = null;
        } // Node() constructor

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + this.element +
                    ", next=" + this.next +
                    '}';
        } // toString()

    } // class Node



} // class MySingularlyLinkedList
