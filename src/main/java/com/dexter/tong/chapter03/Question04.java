package com.dexter.tong.chapter03;


import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Question04 {

    /**
     * 3.4
     * Implement a MyQueue class which implements a queue using two stacks.
     */
    public class MyQueue<T>{

        private Stack<T> removeFrom;
        private Stack<T> addTo;

        public MyQueue() {
            this(new LinkedList<>());
        }

        public MyQueue(Collection<T> collection) {
            removeFrom = new Stack<>();
            addTo = new Stack<>();
            for(T data : collection) {
                addTo.push(data);
            }
        }

        public boolean add(T data) {
            addTo.push(data);
            return true;
        }

        public Object remove() {
            if(removeFrom.empty())
                transferToRemoveFrom();
            if(removeFrom.empty())
                throw new NoSuchElementException();
            return removeFrom.pop();
        }

        public Object peek() {
            if(removeFrom.empty())
                transferToRemoveFrom();
            if(removeFrom.empty())
                throw new NoSuchElementException();
            return removeFrom.peek();
        }

        private void transferToRemoveFrom() {
            for(T data : addTo) {
                removeFrom.push(addTo.pop());
            }
        }
    }
}
