package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Question01Test {

    @Test
    public void removeDuplicates_should_return_identical_if_no_duplicates() {
        Integer[] values = new Integer[]{1, 7, 3, 5, 9, 6};
        LinkedListNode<Integer> input = utils.createLinkedList(values);
        List<Integer> expected = Arrays.asList(values);

        assertEquals(expected, Question01.removeDuplicates(input).asList());
    }
}