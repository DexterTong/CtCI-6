package com.dexter.tong.chapter10;

import java.util.BitSet;

public class Question07 {
    /**
     * 10.7
     * Given an input file with four billion non-negative integers, provide an algorithm to
     * generate an integer that is not contained in the file. Assume you have 1 GB of memory available for
     * this task.
     * FOLLOW UP
     * What if you have only 10MB of memory? Assume that all the values are distinct and we now have
     * no more than one billion non-negative integers.
     */
    // Let's pretend that the ints are being read as a stream, so we aren't actually loading the whole set to memory
    public static int missingInt(int[] numbers) {
        // A BitSet takes ~1 bit per index, so for 4bn ints, we need 4bn bits, or ~500MB
        BitSet flags = new BitSet(numbers.length);
        for(int n : numbers) {
            flags.set(n);
        }
        for(int i = 0; i < flags.length(); i++) {
            if(!flags.get(i))
                return i;
        }
        return -1;
    }
}
