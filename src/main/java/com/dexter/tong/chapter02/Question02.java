package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

public class Question02 {

    /**
     * 2.2
     * Implement an algorithm to find the kth to last element of a singly linked list.
     * Time: O(n)
     * Space: O(1)
     */
    public static LinkedListNode<Integer> rGet(int rIndex, LinkedListNode<Integer> head) {
        // Based on the wording of the problem, I interpret rIndex to be 1-indexed
        // i.e. rIndex == 1 means "the first to last element", equivalent to "the last element"
        // likewise, if the linked list has N elements, then rIndex == N implies the first element
        // that also means that rIndex == 0 does not make sense

        if(rIndex < 1) {
            return null;
        }

        // Advance a leading pointer by rIndex-1 nodes
        LinkedListNode<Integer> leader = head;
        for(int i = 0; i < rIndex; i++) {
            if(leader == null) {
                return null;
            }
            leader = leader.next;
        }

        // Now, the head is exactly rIndex-1 nodes behind the leader, so start a trailing pointer off from head
        LinkedListNode<Integer> trailer = head;

        // Then just advance the leader and trailer together until we reach the end
        while(leader != null) {
            leader = leader.next;
            trailer = trailer.next;
        }

        return trailer;
    }
}
