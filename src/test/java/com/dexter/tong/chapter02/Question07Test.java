package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question07Test {

    @Test
    public void should_be_true_when_lists_intersect() {
        LinkedListNode<Integer> headA = utils.createLinkedList(new Integer[]{3, 5, 9, 3, 1});
        LinkedListNode<Integer> headB = utils.createLinkedList(new Integer[]{0, 2, 4, 6, 8, 2, 4});
        LinkedListNode<Integer> tailA = utils.get(headA, 4);
        LinkedListNode<Integer> tailB = utils.get(headB, 6);
        if(tailB != null)
            tailB.next = tailA;
        LinkedListNode<Integer> headC = utils.createLinkedList(new Integer[]{9, 1, 2});
        if(tailA != null)
            tailA.next = headC;
        assertTrue(Question07.doIntersect(headA, headB));
    }

    @Test
    public void should_be_false_when_lists_do_not_intersect() {
        LinkedListNode<Integer> headA = utils.createLinkedList(new Integer[]{3, 5, 9, 3, 1});
        LinkedListNode<Integer> headB = utils.createLinkedList(new Integer[]{0, 2, 4, 6, 8, 2, 4});
        assertFalse(Question07.doIntersect(headA, headB));
    }

    @Test
    public void should_be_true_when_lists_trivially_intersect() {
        LinkedListNode<Integer> headA = new LinkedListNode<>(8);
        LinkedListNode<Integer> headB = headA;
        assertTrue(Question07.doIntersect(headA, headB));
    }

    @Test
    public void should_be_false_when_one_list_is_null() {
        LinkedListNode<Integer> headA = utils.createLinkedList(new Integer[]{3, 5, 9, 3, 1});
        assertFalse(Question07.doIntersect(headA, null));
    }

    @Test
    public void should_be_false_when_both_lists_are_null() {
        assertFalse(Question07.doIntersect(null, null));
    }
}