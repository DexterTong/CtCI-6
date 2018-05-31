package com.dexter.tong.utils;

import com.dexter.tong.common.BSTNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TreesTest {

    private BSTNode<Integer> root;

    @Before
    public void initialize() {
        root = new BSTNode<>(10);
        for (Integer n : new Integer[]{14, 7, 8, 3, 20, 13, 9, 12}) {
            insertIntoBST(n, root);
        }
    }

    @Test
    public void inOrderTraversal_should_return_a_list_of_node_values_in_order() {
        assertEquals(Arrays.asList(3, 7, 8, 9, 10, 12, 13, 14, 20), Trees.inOrderTraversal(root));
    }

    @Test
    public void preOrderTraversal_should_return_a_list_of_node_values_pre_order() {
        assertEquals(Arrays.asList(10, 7, 3, 8, 9, 14, 13, 12, 20), Trees.preOrderTraversal(root));
    }

    @Test
    public void postOrderTraversal_should_return_a_list_of_node_values_post_order() {
        assertEquals(Arrays.asList(3, 9, 8, 7, 12, 13, 20, 14, 10), Trees.postOrderTraversal(root));
    }

    private static void insertIntoBST(Integer value, BSTNode<Integer> root) {
        if (value <= root.data) {
            if (root.left == null)
                root.left = new BSTNode<>(value);
            else
                insertIntoBST(value, root.left);
        } else {
            if (root.right == null)
                root.right = new BSTNode<>(value);
            else
                insertIntoBST(value, root.right);
        }
    }
}