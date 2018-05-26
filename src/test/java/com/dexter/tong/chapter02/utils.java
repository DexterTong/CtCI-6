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

}
