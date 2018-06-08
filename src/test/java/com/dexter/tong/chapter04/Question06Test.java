package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import com.dexter.tong.utils.Trees;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question06Test {

    @Test
    public void should_get_next_node_when_right_subtree_exists() {
        BinaryTreeNode<Integer> root = Trees.initializeBST(new Integer[]{11, 5, 17, 4, 8, 15, 18, 1, 5, 6, 9, 12, 16, 18, 20});
        BinaryTreeNode<Integer> node = Trees.getNodeFromBST(5, root);
        BinaryTreeNode<Integer> expected = Trees.getNodeFromBST(6, root);
        assertEquals(expected, Question06.getNextNodeInBST(node));
    }

    @Test
    public void should_get_next_node_when_no_right_subtree() {
        BinaryTreeNode<Integer> root = Trees.initializeBST(new Integer[]{11, 5, 17, 4, 8, 15, 18, 1, 5, 6, 9, 12, 16, 18, 20});
        BinaryTreeNode<Integer> node = Trees.getNodeFromBST(9, root);
        BinaryTreeNode<Integer> expected = Trees.getNodeFromBST(11, root);
        assertEquals(expected, Question06.getNextNodeInBST(node));
    }

    @Test
    public void should_be_null_when_rightmost_node() {
        BinaryTreeNode<Integer> root = Trees.initializeBST(new Integer[]{11, 5, 17, 4, 8, 15, 18, 1, 5, 6, 9, 12, 16, 18, 20});
        BinaryTreeNode<Integer> node = Trees.getNodeFromBST(20, root);
        assertNull(Question06.getNextNodeInBST(node));
    }
}