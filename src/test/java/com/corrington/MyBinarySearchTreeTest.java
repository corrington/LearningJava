package com.corrington;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class MyBinarySearchTreeTest {

    @Test
    void
    insert() {
        var tree = new MyBinarySearchTree<Integer>();

        assertTrue(tree.isEmpty());

        assertFalse(tree.contains(1));
        tree.insert(1);
        assertTrue(tree.contains(1));

        assertFalse(tree.contains(3));
        tree.insert(3);
        assertTrue(tree.contains(3));

        assertFalse(tree.contains(5));
        tree.insert(5);
        assertTrue(tree.contains(5));

        assertFalse(tree.contains(7));
        tree.insert(7);
        assertTrue(tree.contains(7));

        assertFalse(tree.isEmpty());

    } // insert()

    @Test
    void contains() {
        var tree = new MyBinarySearchTree<Integer>();

        assertTrue(tree.isEmpty());

        assertFalse(tree.contains(1));
        tree.insert(1);
        assertTrue(tree.contains(1));

        assertFalse(tree.contains(3));
        tree.insert(3);
        assertTrue(tree.contains(3));

        assertFalse(tree.contains(5));
        tree.insert(5);
        assertTrue(tree.contains(5));

        assertFalse(tree.contains(7));
        tree.insert(7);
        assertTrue(tree.contains(7));

        assertFalse(tree.isEmpty());
    } // contains()

    @Test
    void isEmpty() {
        var tree = new MyBinarySearchTree<Integer>();

        assertTrue(tree.isEmpty());
        tree.insert(7);
        assertTrue(tree.contains(7));

        assertFalse(tree.isEmpty());

    } // isEmpty()

    @Test
    void inorderDepthFirstTraversal() {
        var tree = new MyBinarySearchTree<Integer>();

        assertTrue(tree.isEmpty());
        tree.insert(5);
        tree.insert(9);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(9));

        int[] expectedArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> actualList = tree.inorderDepthFirstTraversal();
        //System.out.println("Inorder Depth First Traversal: " + actualList);
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], actualList.get(i));
        } // for i

    } // inorderDepthFirstTraversal()

    @Test
    void preorderDepthFirstTraversal() {
        var tree = new MyBinarySearchTree<Integer>();

        assertTrue(tree.isEmpty());
        tree.insert(5);
        tree.insert(9);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(9));

        int[] expectedArray = new int[] {5, 3, 2, 1, 4, 9, 7, 6, 8};
        List<Integer> actualList = tree.preorderDepthFirstTraversal();
        //System.out.println("Preorder Depth First Traversal: " + actualList);
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], actualList.get(i));
        } // for i

    } // preorderDepthFirstTraversal()

    @Test
    void postorderDepthFirstTraversal() {
        var tree = new MyBinarySearchTree<Integer>();

        assertTrue(tree.isEmpty());
        tree.insert(5);
        tree.insert(9);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(9));

        int[] expectedArray = new int[] {1, 2, 4, 3, 6, 8, 7, 9, 5};
        List<Integer> actualList = tree.postorderDepthFirstTraversal();
        //System.out.println("Postorder Depth First Traversal: " + actualList);
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], actualList.get(i));
        } // for i

    } // postorderDepthFirstTraversal()

} // class MyBinarySearchTreeTest