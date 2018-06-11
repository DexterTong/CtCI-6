package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import com.dexter.tong.utils.Trees;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question10Test {

    private BinaryTreeNode<Integer> root;

    @Before
    public void initialize() {
        root = Trees.initializeBST(new Integer[]{5, 7, 8, 3, 1, 2, 4, 0, 9, 8, 5, 6});
    }

    @Test
    public void should_be_true_when_subtree_is_contained_in_tree() {
        BinaryTreeNode<Integer> subroot = Trees.initializeBST(new Integer[]{1, 0, 2});
        assertTrue(Question10.subtreeOfTree(root, subroot));
    }

    @Test
    public void should_be_false_when_subtree_is__not_contained_in_tree() {
        BinaryTreeNode<Integer> subroot = Trees.initializeBST(new Integer[]{0, 1, 2});
        assertFalse(Question10.subtreeOfTree(root, subroot));
    }
}