package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import com.dexter.tong.utils.Trees;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question12Test {

    private BinaryTreeNode<Integer> root;

    @Before
    public void initialize() {
        root = Trees.initializeBST(new Integer[]{0, 5, 12, 9, -4, 5, 2, -8, 7, -5, -11, 3, -8, -7, 9, 4, 5, -1});
    }

    // Will come back to this when I have paper to draw the tree
    @Test
    public void should_return_number_of_paths_with_sum() {
        assertEquals(3, Question12.pathsWithSum(root, -5));
        assertEquals(4, Question12.pathsWithSum(root, 12));
    }

    @Test
    public void should_return_zero_when_no_paths_with_sum() {
        assertEquals(0, Question12.pathsWithSum(root, 40));
    }
}