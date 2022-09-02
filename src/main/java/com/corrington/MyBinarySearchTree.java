package com.corrington;

import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;


    // Binary Search Tree is a variation on the standard tree which has three restrictions:
    // * A node can have at most two children
    // * For any given parent node, the child to the left has a value less than or equal to the parent,
    //      and the child to the right has a value greater than or equal to the parent
    // * No two nodes can contain the same value
    public MyBinarySearchTree() {
        this.root = null;
        this.size = 0;
    } // MyBinarySearchTree() constructor


    // We'll follow these rules starting from the root node:
    // * If the new node's value is lower than the current node's, we go to the left child.
    // * If the new node's value is greater than the current node's, we go to the right child.
    // * When the current node is null, we've reached a leaf node. We can insert the new node in that position.
    // Return true if value was added to the tree. Otherwise, return false indicating value was already in the tree.
    private Node<E> insertRecursive(Node<E> node, E value) {
        if (node == null) {
            return new Node<>(value);
        } // if

        if (node.value.compareTo(value) > 0) {
            node.left = insertRecursive(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = insertRecursive(node.right, value);
        } else {
            // value already exists
            return node;
        } // if

        return node;

    } // insertRecursive()


    public void insert( E value ) {
        this.root = insertRecursive(this.root, value);
        this.size++;
    } // insert()


    private boolean containsRecursive(Node<E> node, E value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        return node.value.compareTo(value) > 0
                ? containsRecursive(node.left, value)
                : containsRecursive(node.right, value);
    } // containsRecursive()


    private boolean containsNonRecursive(Node<E> node, E value) {
        if (node == null) return false;

        while (node != null) {
            if (node.value.compareTo(value) > 0) {
                node = node.left;
            } else if (node.value.compareTo(value) < 0) {
                node = node.right;
            } else {
                // value found
                return true;
            } // if
        } // while
        return false;
    }

    // Returns true if value is in the tree
    public boolean contains( E value ) {
        return containsRecursive(this.root, value);
    } // contains()


    public boolean isEmpty() {
        return (this.size == 0);
    } // isEmpty()


    private void inorderDepthFirstTraversal(Node<E> node, ArrayList<E> list) {
        if (node == null) return;
        inorderDepthFirstTraversal(node.left, list);
        list.add(node.value);
        inorderDepthFirstTraversal(node.right, list);
    } // inorderDepthFirstTraversal()


    public List<E> inorderDepthFirstTraversal() {
        var list = new ArrayList<E>(this.size);
        inorderDepthFirstTraversal(this.root, list);
        return list;
    } // inorderDepthFirstTraversal()


    private void preorderDepthFirstTraversal(Node<E> node, ArrayList<E> list) {
        if (node == null) return;
        list.add(node.value);
        preorderDepthFirstTraversal(node.left, list);
        preorderDepthFirstTraversal(node.right, list);
    } // preorderDepthFirstTraversal()


    public List<E> preorderDepthFirstTraversal() {
        var list = new ArrayList<E>(this.size);
        preorderDepthFirstTraversal(this.root, list);
        return list;
    } // preorderDepthFirstTraversal()


    private void postorderDepthFirstTraversal(Node<E> node, ArrayList<E> list) {
        if (node == null) return;
        postorderDepthFirstTraversal(node.left, list);
        postorderDepthFirstTraversal(node.right, list);
        list.add(node.value);

    } // postorderDepthFirstTraversal()


    public List<E> postorderDepthFirstTraversal() {
        var list = new ArrayList<E>(this.size);
        postorderDepthFirstTraversal(this.root, list);
        return list;
    } // postorderDepthFirstTraversal()


    @Override
    public String toString() {
        return "MyBinarySearchTree{" +
                "root=" + this.root +
                ", size=" + this.size +
                '}';
    } // toString()


    /*
     * class Node
     */
    private static class Node<E  extends Comparable<E>> {
        E value;
        Node<E> left;
        Node<E> right;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        } // Node() constructor

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + this.value +
                    ", left=" + this.left +
                    ", right=" + this.right +
                    '}';
        } // toString()

    } // class Node

} // class MyBinarySearchTree
