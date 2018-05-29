package com.dexter.tong.chapter03;

import java.util.LinkedList;

public class Question05 {

    /**
     * 3.5
     * Write a program to sort a stack such that the smallest items are on the top. You can use
     * an additional temporary stack, but you may not copy the elements into any other data structure
     * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
     */
    public static void sort(LinkedList<Integer> stack) {
        LinkedList<Integer> maxStack = new LinkedList<>();
        while(stack.size() > 0) {
            insertIntoMaxStack(maxStack, stack.pop(), stack);
        }
        while(maxStack.size() > 0) {
            stack.push(maxStack.pop());
        }
    }

    private static boolean isLessThanTop(Integer element, LinkedList<Integer> stack) {

        if(stack.size() < 1)
            return false;

        return element.compareTo(stack.peek()) < 0;
    }

    private static void insertIntoMaxStack(LinkedList<Integer> maxStack, Integer element, LinkedList<Integer> buffer) {
        int movedToBufferCount = 0;
        while(isLessThanTop(element, maxStack)) {
            buffer.push(maxStack.pop());
            movedToBufferCount++;
        }
        maxStack.push(element);
        for(int i = 0; i < movedToBufferCount; i++) {
            maxStack.push(buffer.pop());
        }
    }
}
