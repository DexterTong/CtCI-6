package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import com.dexter.tong.utils.Trees;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Question09Test {

    private BinaryTreeNode<Integer> root;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void initialize() {
        root = Trees.initializeBST(new Integer[]{11, 5, 17, 3, 8/*, 15, 19, 1, 4, 6, 9, 12, 16, 18, 21*/});
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void should_print_out_ten_lines() {
        Question09.generateInsertionSequences(root);
        // Really just counting that there are 8 lines of output
        assertEquals(8, outputStream.toString().split("\\n").length);
    }

    @After
    public void teardown() {
        System.setOut(System.out);
    }
}