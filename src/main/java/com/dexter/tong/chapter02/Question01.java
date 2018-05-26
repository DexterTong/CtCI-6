package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

import java.util.HashSet;

public class Question01 {

    /**
     * 2.1a
     * Write code to remove duplicates from an unsorted linked list.
     * Time: O(n)
     * Space: O(n)
     */
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        HashSet<Integer> foundData = new HashSet<>();

        LinkedListNode<Integer> current = head;
        foundData.add(current.data);

        while(current.next != null) {
            if(foundData.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                foundData.add(current.next.data);
                current = current.next;
            }
        }

        return head;
    }

    /**
     * 2.1b
     * Write code to remove duplicates from an unsorted linked list. How would you solve this problem if a temporary buffer is not
     * allowed?
     * Time: O(n^2)
     * Space: O(1)
     */
    public static LinkedListNode<Integer> removeDuplicatesNoBuffer(LinkedListNode<Integer> head) {
        // Maybe there is a way to do a sub-O(n^2) sort here in constant space
        // Bubble/insertion sort will give O(n^2) runtime
        // Searching after the ith node for dups will also yield O(n^2) runtime, so I'll do that

        LinkedListNode<Integer> current = head;
        while(current != null) {
            LinkedListNode<Integer> before = current;
            LinkedListNode<Integer> after = before.next;
            while(after != null) {
                if(current.data.equals(after.data)) {
                    before.next = after.next;
                } else {
                    before = before.next;
                }
                after = before.next;
            }
            current = current.next;
        }

        return head;
    }
}
