package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question02Test {

    @Test
    public void should_create_BST_with_minimal_height() {
        Integer[] input = new Integer[]{1, 4, 5, 5, 6, 8, 9, 11, 12, 15, 16, 17, 18, 18, 20};
        BinaryTreeNode<Integer> result = Question02.arrayToBST(input);
        assertEquals(4, getMaxTreeDepth(result));
    }

    private int getMaxTreeDepth(BinaryTreeNode<Integer> root) {
        if(root == null)
            return 0;
        return 1 + Math.max(getMaxTreeDepth(root.left), getMaxTreeDepth(root.right));
    }
}