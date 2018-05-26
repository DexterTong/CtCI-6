package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

import java.util.LinkedList;

public class Question06 {

    /**
     * 2.6
     * Implement a function to check if a linked list is a palindrome.
     * Time: O(n)
     * Space: O(n)
     */
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        /*
        The idea here is to traverse the first half of the list in-order, adding elements to a stack
        We use a fast pointer than jumps 2 nodes ahead on each iteration, and a slow that jumps 1 node ahead
        So when the fast pointer reaches the end, then the slow pointer is pointing to the middle
        Then we pop elements off the stack as we traverse the back half of the list, comparing each pair as we go along
         */

        // I guess an empty list would be a trivial palindrome
        if(head == null)
            return true;

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        boolean hasEvenLength = false;
        LinkedList<LinkedListNode<Integer>> stack = new LinkedList<LinkedListNode<Integer>>();

        while(true) {
            stack.push(slow);
            slow = slow.next;
            if(fast.next == null) {
                // i.e. the fast pointer has reached the end and the list has an odd element count
                stack.pop();        // Need to pop the middle element, since it is paired with itself
                break;
            } else {
                fast = fast.next;
                if(fast.next == null)
                    break;
                else
                    fast = fast.next;
            }
        }

        while(slow != null) {
            if( slow.data.equals(stack.pop().data)) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
