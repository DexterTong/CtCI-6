package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Question05Test {

    @Test
    public void reverseSumList_should_sum_two_lists() {
        LinkedListNode<Integer> numberA = utils.createLinkedList(new Integer[]{2, 5, 3});   //    352
        LinkedListNode<Integer> numberB = utils.createLinkedList(new Integer[]{9, 1, 2});   // +  219
        List<Integer> expected = Arrays.asList(1, 7, 5);                                    // =  571
        assertEquals(expected, Question05.reverseSumList(numberA, numberB).asList());
    }

    @Test
    public void reverseSumList_should_sum_two_lists_with_carryover() {
        LinkedListNode<Integer> numberA = utils.createLinkedList(new Integer[]{2, 4, 6});   //    642
        LinkedListNode<Integer> numberB = utils.createLinkedList(new Integer[]{5, 1, 8});   // +  815
        List<Integer> expected = Arrays.asList(7, 5, 4, 1);                                 // = 1457
        assertEquals(expected, Question05.reverseSumList(numberA, numberB).asList());
    }

    @Test
    public void reverseSumList_should_sum_two_lists_with_different_lengths() {
        LinkedListNode<Integer> numberA = utils.createLinkedList(new Integer[]{0, 9, 1});   //    190
        LinkedListNode<Integer> numberB = utils.createLinkedList(new Integer[]{0, 4});      // +   40
        List<Integer> expected = Arrays.asList(0, 3, 2);                                    // =  230
        assertEquals(expected, Question05.reverseSumList(numberA, numberB).asList());
    }

    @Test
    public void forwardSumList_should_sum_two_lists() {
        LinkedListNode<Integer> numberA = utils.createLinkedList(new Integer[]{3, 5, 2});   //    352
        LinkedListNode<Integer> numberB = utils.createLinkedList(new Integer[]{2, 1, 9});   // +  219
        List<Integer> expected = Arrays.asList(5, 7, 1);                                    // =  571
        assertEquals(expected, Question05.forwardSumList(numberA, numberB).asList());
    }

    @Test
    public void forwardSumList_should_sum_two_lists_with_carryover() {
        LinkedListNode<Integer> numberA = utils.createLinkedList(new Integer[]{6, 4, 2});   //    642
        LinkedListNode<Integer> numberB = utils.createLinkedList(new Integer[]{8, 1, 5});   // +  815
        List<Integer> expected = Arrays.asList(1, 4, 5, 7);                                 // = 1457
        assertEquals(expected, Question05.forwardSumList(numberA, numberB).asList());
    }

    @Test
    public void forwardSumList_should_sum_two_lists_with_different_lengths() {
        LinkedListNode<Integer> numberA = utils.createLinkedList(new Integer[]{1, 9, 0});   //    190
        LinkedListNode<Integer> numberB = utils.createLinkedList(new Integer[]{4, 0});      // +   40
        List<Integer> expected = Arrays.asList(2, 3, 0);                                    // =  230
        assertEquals(expected, Question05.forwardSumList(numberA, numberB).asList());
    }
}