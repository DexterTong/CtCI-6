package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

public class Question08 {

    /**
     * 2.8
     * Given a circular linked list, implement an algorithm that returns the node at the
     * beginning of the loop.
     * Time: O(n)
     * Space: O(1)
     */
    public static boolean isCircular(LinkedListNode<Integer> head) {
        /*
        We assume that the linked list has a finite number of elements, meaning that if the list contains a finite
        number of nodes (So if the linked list has a cycle, then there is a finite number of hops to enter the cycle,
        and a finite number of nodes in the cycle)
         */
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        while(fast != null) {
            fast = fast.next;
            if(fast == null)
                return false;
            fast = fast.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
