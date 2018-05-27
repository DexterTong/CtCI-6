package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

public class Question07 {

    /**
     * 2.7
     * Given two (singly) linked lists, determine if the two lists intersect. Return the inter-
     * secting node. Note that the intersection is defined based on reference, not value. That is, if the kth
     * node of the first linked list is the exact same node (by reference) as the jth node of the second
     * linked list, then they are intersecting.
     * Time: O(m+n)
     * Space: O(1)
     */
    public static boolean doIntersect(LinkedListNode<Integer> headA, LinkedListNode<Integer> headB) {
        LinkedListNode<Integer> tailA = getTail(headA);
        LinkedListNode<Integer> tailB = getTail(headB);

        // If either tail is null, then the linked list is empty -> lists cannot intersect
        // We really only need to check one of the tails for nullness
        if(tailA == null || tailB == null)
            return false;
        return tailA == tailB;
    }

    private static LinkedListNode<Integer> getTail(LinkedListNode<Integer> head) {
        if(head == null)
            return null;
        LinkedListNode<Integer> current = head;
        while(current.next != null) {
            current = current.next;
        }
        return current;
    }
}
