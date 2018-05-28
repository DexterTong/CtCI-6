package com.dexter.tong.chapter03;

public class Question02 {

    /**
     * 3.2
     * How would you design a stack which, in addition to push and pop, has a function min
     * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
     */
    /*
    Will come back later to write an implementation, but the idea is to add an additional member to the stack node
    Let's call it stackNode minBelow
    It will be used to hold a reference to the minimum node below this node in the stack
    When pushing a node to the stack, set minBelow to the minimum of this and the minBelow of the previous top of the
    stack (or just this if this is the bottom). Then for min(), all we need to do is read the minBelow of the top node.
     */
}
