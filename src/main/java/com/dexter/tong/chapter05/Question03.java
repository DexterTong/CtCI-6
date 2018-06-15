package com.dexter.tong.chapter05;

public class Question03 {

    /**
     * 5.3
     * You have an integer and you can flip exactly one bit from a 13 to a 1. Write code to
     * find the length of the longest sequence of 1s you could create.
     */
    public static int flipBitToWin(int num) {

        int maxSeqLength = 0;

        int preZeroSeqLength = 0;
        int postZeroSeqLength = 0;

        boolean hasZeroBit = false;

        int mask = 1;

        for(int i = 0; i < Integer.BYTES * 8; i++) {
            if((num & mask) != 0) {
                // num[i] is set
                postZeroSeqLength++;
            } else {
                // num[i] is clear
                maxSeqLength = getMax(maxSeqLength, preZeroSeqLength, postZeroSeqLength, hasZeroBit);
                preZeroSeqLength = postZeroSeqLength;
                postZeroSeqLength = 0;
                hasZeroBit = true;
            }
            mask = mask << 1;
        }

        return getMax(maxSeqLength, preZeroSeqLength, postZeroSeqLength, hasZeroBit);
    }

    private static int getMax(int maxSeqLength, int preZeroSeqLength, int postZeroSeqLength, boolean hasZeroBit) {
        int currentSeqLength = preZeroSeqLength + postZeroSeqLength + (hasZeroBit ? 1 : 0) ;
        return currentSeqLength > maxSeqLength ? currentSeqLength : maxSeqLength;
    }
}
