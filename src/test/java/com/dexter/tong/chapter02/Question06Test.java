package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question06Test {

    @Test
    public void should_be_true_when_even_sized_palindrome() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{4, 5, 6, 6, 5, 4});
        assertTrue(Question06.isPalindrome(head));
    }

    @Test
    public void should_be_true_when_odd_sized_palindrome() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{4, 5, 6, 7, 6, 5, 4});
        assertTrue(Question06.isPalindrome(head));
    }

    @Test
    public void should_be_true_when_list_has_1_element() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{4});
        assertTrue(Question06.isPalindrome(head));
    }

    @Test
    public void should_be_false_when_odd_sized_and_not_palindrome() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{4, 1, 6, 7, 6, 2, 4});
        assertFalse(Question06.isPalindrome(head));
    }

    @Test
    public void should_be_false_when_even_sized_and_not_palindrome() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{3, 6, 0, 0, 6, 4});
        assertFalse(Question06.isPalindrome(head));
    }
}