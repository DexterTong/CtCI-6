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

        LinkedListNode<Integer> currentNode = head;
        foundData.add(currentNode.data);

        while(currentNode.next != null) {
            if(foundData.contains(currentNode.next.data)) {
                currentNode.next = currentNode.next.next;
            } else {
                foundData.add(currentNode.next.data);
            }
            currentNode = currentNode.next;
        }

        return head;
    }
}
