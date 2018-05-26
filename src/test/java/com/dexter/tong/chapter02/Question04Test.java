package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Question04Test {
    /*
    For these tests, we assume that ordering is preserved wrt the partition value, as in the ordering of elements less
    than the partition is preserved, and likewise for the elements greater than or equal to
    For example, partitioning {3, 6, 5, 8, 1} about 5 should return {3, 1, 5, 6, 8}
     */


    @Test
    public void should_partition_list_by_lt_and_gte_partition_value() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{2, 6, 7, 3, 0, 8, 2});
        List<Integer> expected = Arrays.asList(2, 3, 0, 2, 6, 7, 8);
        assertEquals(expected, Question04.partition(5, head).asList());
    }

    @Test
    public void should_return_identical_when_all_elements_lt_partition() {
        Integer[] values = new Integer[]{4, 1, 4, 3, 0, 2, 1};
        LinkedListNode<Integer> head = utils.createLinkedList(values);
        List<Integer> expected = Arrays.asList(values);
        assertEquals(expected, Question04.partition(5, head).asList());
    }

    @Test
    public void should_return_identical_when_all_elements_gte_partition() {
        Integer[] values = new Integer[]{4, 9, 6, 3, 5, 4, 8};
        LinkedListNode<Integer> head = utils.createLinkedList(values);
        List<Integer> expected = Arrays.asList(values);
        assertEquals(expected, Question04.partition(3, head).asList());
    }
}