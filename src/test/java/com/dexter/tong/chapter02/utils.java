package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

public class utils {

    public static LinkedListNode<Integer> createLinkedList(Integer[] values) {
        if(values == null) {
            return new LinkedListNode<>(null);
        }
        LinkedListNode<Integer> head = new LinkedListNode<>(values[0]);
        LinkedListNode<Integer> current = head;
        for(int i = 1; i < values.length; i++) {
            current.next = new LinkedListNode<>(values[i]);
            current = current.next;
        }
        return head;
    }

    // Get the node that is index jumps down the linked list from head, i.e. index == 0 returns head and
    // index == 1 returns head.next
    public static LinkedListNode<Integer> get(LinkedListNode<Integer> head, int index) {

        if(index < 0) {
            return null;
        }

        LinkedListNode<Integer> current = head;
        for(int i = 0; i < index; i++) {
            if(current == null) {
                return null;
            }
            current = current.next;
        }

        return current;
    }
}
