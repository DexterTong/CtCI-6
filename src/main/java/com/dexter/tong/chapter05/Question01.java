package com.dexter.tong.chapter05;

public class Question01 {

    /**
     * 5.1
     * You are given two 32-bit numbers, N and M, and two bit positions, i and
     * j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
     * can assume that the bits j through i have enough space to fit all of M. That is, if
     * M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
     * example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
     */
    public static int insertInto(int source, int dest, int endBit, int startBit) {

        /*
        Create the mask 1...10...01...1 by the following:
        Start with 1...1, then left shift in j-i 0's
        Flip the bits, then left shift in i more 0's
        Finally, flip the bits again
         */
        int clearMask = ~((~(-1 << (endBit - startBit))) << startBit);

        // Now, result is source except bits j through i have been cleared
        int result = dest & clearMask;

        // Pad source with the proper number of 0's
        int toInsert = source << startBit;

        return result | toInsert;
    }
}
