package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question02Test {

    @Test
    public void should_return_last_element_when_rIndex_is_1() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{1, 2, 3, 4, 5, 6});
        LinkedListNode<Integer> expected = utils.get(head, 5);
        assertSame(expected, Question02.rGet(1, head));
    }

    @Test
    public void should_return_correct_element_when_rIndex_is_greater_than_1_and_less_than_length() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{1, 2, 3, 4, 5, 6});
        LinkedListNode<Integer> expected = utils.get(head, 4);
        assertSame(expected, Question02.rGet(2, head));
    }

    @Test
    public void should_return_null_when_rIndex_is_less_than_1() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{1, 2, 3, 4, 5});
        assertNull(Question02.rGet(0, head));
        assertNull(Question02.rGet(-1, head));
    }

    @Test
    public void should_return_null_when_rIndex_is_greater_than_length() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{3, 4, 5, 6});
        assertNull(Question02.rGet(10, head));
    }
}