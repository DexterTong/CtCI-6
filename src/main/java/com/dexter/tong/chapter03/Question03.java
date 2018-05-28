package com.dexter.tong.chapter03;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Question03 {

    /**
     * 3.3
     * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
     * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
     * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
     * composed of several stacks and should create a new stack once the previous one exceeds capacity.
     * SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
     * (that is, pop() should return the same values as it would if there were just a single stack).
     * FOLLOW UP
     * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
     */
    public class SetOfStacks<T> {

        private List<Stack<T>> stacks;
        private int stackCapacity;

        // Keep track of the stack that contains the top of the "set of stacks"
        private Stack<T> topStack;

        public SetOfStacks(int stackCapacity) {
            this.stacks = new ArrayList<>();
            this.stackCapacity = stackCapacity;
            this.topStack = null;
        }

        public T push(T data) {
            if (topStack == null || topStack.size() >= stackCapacity)
                addTopStack();
            return topStack.push(data);
        }

        public T pop() {

            if (topStack == null)
                throw new EmptyStackException();

            while (topStack.empty()) {
                deleteTopStack();
                if (topStack == null)
                    throw new EmptyStackException();
            }
            return topStack.pop();
        }

        public T popAt(int index) {
            if (index >= stacks.size())
                throw new IndexOutOfBoundsException();
            Stack<T> stack = stacks.get(index);
            if (stack.empty())
                throw new EmptyStackException();
            T data = stack.pop();
            if (stack.empty())
                deleteStack(index);
            return data;
        }

        public T peek() {
            if (topStack == null)
                throw new EmptyStackException();
            return topStack.peek();
        }

        public boolean empty() {
            if (topStack == null)
                return true;
            return topStack.size() > 0;
        }

        private void addTopStack() {
            Stack<T> newTopStack = new Stack<>();
            stacks.add(newTopStack);
            topStack = newTopStack;
        }

        private void deleteTopStack() {
            deleteStack(stacks.size() - 1);
        }

        private void deleteStack(int index) {
            Stack<T> toRemove = stacks.remove(index);
            if (toRemove == topStack)
                if (stacks.size() > 0)
                    topStack = stacks.get(stacks.size() - 1);
                else
                    topStack = null;
        }
    }
}
