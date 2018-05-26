package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

public class Question03 {

    /**
     * 2.3
     * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the
     * exact middle) of a singly linked list, given only access to that node.
     * Time: O(1)
     * Space: O(1)
     */
    public static void deleteMiddle(LinkedListNode<Integer> current) {
        /*
        All of the corner cases have been handwaved away, so we just need to make the current node assume the identity
        of its next. But this isn't quite correct, since any references to current outside of the context of this linked
        list will still point to current, which has now assumed the values of current.next
        Likewise, anything outside of the LL pointing to the old current.next will now be pointing to something not part
        of the linked list afterwards
         */
        if(current == null)
             return;
        LinkedListNode<Integer> next = current.next;
        current.data = next.data;
        current.next = next.next;
    }
}
