package com.corrington;


public class MySingularlyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MySingularlyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    } // MySingularlyLinkedList() constructor

    public boolean isEmpty() {
        return (this.head == null);
    } // isEmpty()

    // add a new node to the start of the list
    public void addFirst(final E element) {
        if (element == null) {
            throw new IllegalArgumentException(EXCEPT_MSG_01);
        } // if

        var node = new Node<>(element);

        if (isEmpty()) {
            // add the first node
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        } // if

        this.size++;

    } // addFirst()

    public void addAll(final E[] elements) {
        for (var element : elements) {
            addLast(element);
        } // for element
    } // addAll()

    // remove the first node from the front of the list, and return the element
    public E removeFirst() {
        if (isEmpty()) return null;
        E element = this.head.element;
        if (this.size == 1) {
            clear();
        } else {
            var next = this.head.next;
            this.head.element = null;
            this.head.next = null;
            this.head = next;
            this.size--;
        } // if
        return element;
    } // removeFirst()

    // Inserts the specified element at the specified position in this list.
    // Shifts the element currently at that position (if any) and any subsequent elements
    // to the right (adds one to their indices).
    public void addAt(final E element, final int index) {
        if (element == null) {
            throw new IllegalArgumentException(EXCEPT_MSG_01);
        }
        if ((index < 0) || (index > this.size)) {
            throw new IllegalArgumentException(EXCEPT_MSG_02);
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
                currNodeIndex++;
            } // while

            // insert the new node
            Node<E> newNode = new Node<>(element);
            newNode.next = currNode;
            prevNode.next = newNode;
            this.size++;

        } // if

    } // addAt()


    public E peekAt(final int index) {
        if ((index < 0) || (index > this.size)) return null;
        if (isEmpty()) return null;

        if (index == 0) return this.head.element;
        if (index == this.size) return this.tail.element;

        Node<E> node = this.head;
        int nodeIndex = 0;
        while (nodeIndex != index) {
            node = node.next;
            nodeIndex++;
        } // while

        return node.element;

    } // peekAt()


    // removes and returns the element at the specified index in this list.
    public E removeFrom(final int index) {
        if ((index < 0) || (index > this.size)) {
            throw new IllegalArgumentException(EXCEPT_MSG_02);
        }
        if (isEmpty()) return null;

        if (index == 0) return removeFirst();
        if (index == this.size) return removeLast();

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


    // Add a new element to the end of the list
    public void addLast(final E element) {
        if (element == null) {
            throw new IllegalArgumentException(EXCEPT_MSG_01);
        } // if

        var node = new Node<>(element);

        if (isEmpty()) {
            // add first node to the list
            this.head = node;
        } else {
            // append to end of list
            this.tail.next = node;
        } // if

        this.tail = node;

        this.size++;

    } // addLast()


    // Removes and returns the last element from this list.
    public E removeLast() {
        if (isEmpty()) return null;

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


    // Returns true if this list contains the specified element. Otherwise, false.
    public boolean contains(final E element) {
        if (element == null) {
            throw new IllegalArgumentException(EXCEPT_MSG_01);
        } // if

        var node = this.head;
        while (node != null) {
            if (node.element.equals(element)) return true;
            node = node.next;
        } // while
        return false;
    } // contains()


    public void clear() {
        Node<E> node = this.head;
        while (node != null) {          // Ensure there are no dangly references
            node.element = null;        // null the reference to the data so it can be garbage collected
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
    }

    public void reverse() {
        if (isEmpty()) return;
        if (this.size == 1) return;

        Node<E> prevNode = null;
        Node<E> node = this.head;

        while (node != null) {
            Node<E> nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        } // while

        this.head = prevNode;

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
    // The number, order, and value of the elements must be the same.
    // Their locations in memory is ignored.
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

    private static final  String EXCEPT_MSG_01 = "element cannot be null";
    private static final  String EXCEPT_MSG_02 = "index is out of bounds";

} // class MySingularlyLinkedList
