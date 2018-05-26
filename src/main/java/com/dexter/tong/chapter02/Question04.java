package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

public class Question04 {

    /**
     * 2.4
     * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than 
     * or equal to x . lf x is contained within the list, the values of x only need to be after the elements less than x 
     * (see below) . The partition element x can appear anywhere in the "right partition"; it does not need to appear between 
     * the left and right partitions.
     * Time: O(n)
     * Space: O(1)
     */
    public static LinkedListNode<Integer> partition(Integer partValue, LinkedListNode<Integer> head) {

        if(head == null) {
            return null;
        }
        /*
         If head != null, then the list has >=1 element, so at least one of {ltHead, ltTail} and {gteHead, gteTail}
         is guaranteed to be non-null
         */

        LinkedListNode<Integer> ltHead = null;
        LinkedListNode<Integer> ltTail = null;
        LinkedListNode<Integer> gteHead = null;
        LinkedListNode<Integer> gteTail = null;

        LinkedListNode<Integer> curr = head;
        while(curr != null) {
            if( curr.data < partValue) {
                //i.e. the lt linked list is empty
                if(ltHead == null) {
                    ltHead = curr;
                    ltTail = curr;
                } else {
                    ltTail.next = curr;
                    ltTail = curr;
                }
            } else {
                //i.e. the gte linked list is empty
                if(gteHead == null) {
                    gteHead = curr;
                    gteTail = curr;
                } else {
                    gteTail.next = curr;
                    gteTail = curr;
                }
            }
            curr = curr.next;
        }

        // Stitch the lt and gte lists together, or terminate the lt list if the gte list is empty
        if(ltHead != null)
            ltTail.next = gteHead;

        // Terminate the list properly to prevent a cycle
        if(gteHead != null)
            gteTail.next = null;

        // If ltHead is null, then all the original list elements are in the gte list
        if(ltHead != null)
            return ltHead;
        else
            return gteHead;
    }
}
