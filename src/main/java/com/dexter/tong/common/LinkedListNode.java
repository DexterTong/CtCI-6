package com.dexter.tong.common;

import java.util.LinkedList;
import java.util.List;

public class LinkedListNode<T> {

    public LinkedListNode<T> next;
    public LinkedListNode<T> previous;
    public T data;

    public LinkedListNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public String printLinkedList() {
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        LinkedListNode<T> currentNode = this;
        while(currentNode != null) {
            result.append(currentNode.toString());
            if(currentNode.next != null) {
                result.append(", ");
            }
            currentNode = currentNode.next;
        }
        result.append(" }");
        return result.toString();
    }

    public List<T> asList() {
        List<T> result = new LinkedList<T>();
        LinkedListNode<T> current = this;
        while(current != null) {
            result.add(current.data);
            current = current.next;
        }
        return result;
    }
}