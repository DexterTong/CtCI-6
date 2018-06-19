package com.dexter.tong.chapter08;

public class Question01 {
    /**
     * 8.1
     * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
     * steps at a time. Implement a method to count how many possible ways the child can run up the
     * stairs.
     */
    public static int waysToHop(int stepCount) {
        if(stepCount < 0)
            throw new IllegalArgumentException("stepCount must be non-negative");
        if(stepCount == 0 || stepCount == 1)
            return 1;
        int nMinus3val;
        int nMinus2val = 0;
        int nMinus1val = 1;
        int nVal = 1;
        for(int i = 1; i < stepCount; i++) {
            nMinus3val = nMinus2val;
            nMinus2val = nMinus1val;
            nMinus1val = nVal;
            nVal = nMinus3val + nMinus2val + nMinus1val;
        }
        return nVal;
    }
    /*
    To get a sense of what's going on, we do the first couple cases by hand:
        Step Count  Ways
        0           1
        1           1
        2           2
        3           4
        4           7
        5           13

    It looks like the number of ways to hop up N steps is the sum of the ways to hop up N-1, N-2, and N-3 steps
    When you write out the possible ways, it checks out:
        To go up 5 steps, we can choose any way to go up 2 steps, then hop up 3
        We can also choose any way to go up 3 steps, then hop up 2
        Finally, we can choose any way to go up 4 steps, then hop up 1
        We don't need to worry about the ways to go up 1 step, because it has already been counted (can't directly hop
        from 1 to 5)

    This kind of looks like finding the Nth fibonacci number: the Nth number in the sequence is based on the numbers
    before it.

    The above solution operates in O(n) time and O(1) space.
    It looks like there may be a faster way to do it?
        Each number is getting added to the sum 3 times
        And we could save a few operations by using the 3 nMinus values in a circular fashion rather than bubbling down
     */
}
