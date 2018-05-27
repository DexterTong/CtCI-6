package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question08Test {

    @Test
    public void should_be_true_when_list_is_cyclic() {
        LinkedListNode<Integer> head = createCyclicLinkedList(new Integer[]{1, 2, 3, 4, 5});
        assertTrue(Question08.isCircular(head));
    }

    @Test
    public void should_be_true_when_list_has_cycle() {
        LinkedListNode<Integer> second = createCyclicLinkedList(new Integer[]{1, 2, 3, 4, 5});
        LinkedListNode<Integer> first = utils.createLinkedList(new Integer[]{9, 8, 7, 6});
        LinkedListNode<Integer> firstTail = utils.get(first, 3);
        if(firstTail != null)
        firstTail.next = second;
        assertTrue(Question08.isCircular(first));
    }

    @Test
    public void should_be_false_when_list_is_acyclic() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{2, 4, 6, 8});
        assertFalse(Question08.isCircular(head));
    }

    @Test
    public void should_be_false_when_list_is_empty() {
        assertFalse(Question08.isCircular(null));
    }

    private LinkedListNode<Integer> createCyclicLinkedList(Integer[] values){
        LinkedListNode<Integer> head = utils.createLinkedList(values);
        LinkedListNode<Integer> tail = utils.get(head, values.length - 1);
        if(tail != null)
            tail.next = head;
        return head;
    }
}