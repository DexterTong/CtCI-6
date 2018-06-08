package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import com.dexter.tong.utils.Trees;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question05Test {

    @Test
    public void should_be_true_when_given_a_BST() {
        BinaryTreeNode<Integer> root = Trees.initializeBST(new Integer[]{11, 5, 17, 4, 8, 15, 18, 1, 5, 6, 9});
        assertTrue(Question05.validateBST(root));
    }

    @Test
    public void should_be_false_when_given_a_non_BST() {
        BinaryTreeNode<Integer> root = Trees.initializeBST(new Integer[]{11, 5, 17, 4, 8, 15, 18, 1, 5, 6, 9});
        BinaryTreeNode<Integer> temp = root.left;
        root.left = new BinaryTreeNode<>(13);
        root.left.left = temp;
        root.left.right = new BinaryTreeNode<>(14);
        assertFalse(Question05.validateBST(root));
    }
}