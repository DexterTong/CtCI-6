package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import com.dexter.tong.utils.Trees;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question04Test {

    @Test
    public void should_be_true_when_tree_is_perfect() {
        BinaryTreeNode<Integer> root = Trees.initializeBST(new Integer[]{11, 5, 17, 4, 8, 15, 18, 1, 5, 6, 9, 12, 16, 18, 20});
        assertTrue(Question04.treeBalanced(root));
    }

    @Test
    public void should_be_true_when_tree_is_balanced() {
        BinaryTreeNode<Integer> root = Trees.initializeBST(new Integer[]{11, 5, 17, 4, 8, 15, 18, 1, 5, 6, 9, 12, 16, 18, 0});
        assertTrue(Question04.treeBalanced(root));
    }

    @Test
    public void should_be_false_when_tree_is_imbalanced() {
        BinaryTreeNode<Integer> root = Trees.initializeBST(new Integer[]{11, 5, 17, 4, 8, 15, 18, 1, 5, 6, 9, 12, 16, 18, 0, 0});
        assertFalse(Question04.treeBalanced(root));
    }
}