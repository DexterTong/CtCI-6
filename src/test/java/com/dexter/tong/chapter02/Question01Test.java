package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
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

    @Test
    public void removeDuplicates_should_remove_one_duplicate_at_end() {
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6, 5};
        LinkedListNode<Integer> input = utils.createLinkedList(values);
        List<Integer> expected = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertEquals(expected, Question01.removeDuplicates(input).asList());
    }

    @Test
    public void removeDuplicates_should_remove_adjacent_duplicates() {
        Integer[] values = new Integer[]{6, 9, 3, 2, 2, 2, 1};
        LinkedListNode<Integer> input = utils.createLinkedList(values);
        List<Integer> expected = new LinkedList<>(Arrays.asList(6, 9, 3, 2, 1));

        assertEquals(expected, Question01.removeDuplicates(input).asList());
    }

    @Test
    public void removeDuplicates_should_remove_duplicates_at_end() {
        Integer[] values = new Integer[]{6, 9, 3, 2, 1, 6, 6};
        LinkedListNode<Integer> input = utils.createLinkedList(values);
        List<Integer> expected = new LinkedList<>(Arrays.asList(6, 9, 3, 2, 1));

        assertEquals(expected, Question01.removeDuplicates(input).asList());
    }

    @Test
    public void removeDuplicatesNoBuffer_should_return_identical_if_no_duplicates() {
        Integer[] values = new Integer[]{1, 7, 3, 5, 9, 6};
        LinkedListNode<Integer> input = utils.createLinkedList(values);
        List<Integer> expected = Arrays.asList(values);

        assertEquals(expected, Question01.removeDuplicatesNoBuffer(input).asList());
    }

    @Test
    public void removeDuplicatesNoBuffer_should_remove_one_duplicate_at_end() {
        Integer[] values = new Integer[]{1, 7, 3, 5, 9, 6, 5};
        LinkedListNode<Integer> input = utils.createLinkedList(values);
        List<Integer> expected = new LinkedList<>(Arrays.asList(1, 7, 3, 5, 9, 6));

        assertEquals(expected, Question01.removeDuplicatesNoBuffer(input).asList());
    }

    @Test
    public void removeDuplicatesNoBuffer_should_remove_adjacent_duplicates() {
        Integer[] values = new Integer[]{6, 9, 3, 2, 2, 2, 1};
        LinkedListNode<Integer> input = utils.createLinkedList(values);
        List<Integer> expected = new LinkedList<>(Arrays.asList(6, 9, 3, 2, 1));

        assertEquals(expected, Question01.removeDuplicatesNoBuffer(input).asList());
    }

    @Test
    public void removeDuplicatesNoBuffer_should_remove_duplicates_at_end() {
        Integer[] values = new Integer[]{6, 9, 3, 2, 1, 6, 6};
        LinkedListNode<Integer> input = utils.createLinkedList(values);
        List<Integer> expected = new LinkedList<>(Arrays.asList(6, 9, 3, 2, 1));

        assertEquals(expected, Question01.removeDuplicatesNoBuffer(input).asList());
    }
}