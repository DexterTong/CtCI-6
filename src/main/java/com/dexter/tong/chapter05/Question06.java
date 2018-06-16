package com.dexter.tong.chapter05;

public class Question06 {

    /**
     * 5.6
     * Write a function to determine the number of bits you would need to flip to convert
     * integer A to integer B.
     */
    /*
    We need to for each bit position, compare numA and numB, and count up how many positions they differ at
    So one way to do it is to XOR numA and numB, and then count how many bits are set
     */
    public static int bitFlipsNeeded(int numA, int numB) {
        int diff = numA ^ numB;
        int count = 0;
        int mask = 1;
        for(int i = 0; i < Integer.SIZE; i++) {
            if((diff & mask) != 0)
                count++;
            mask = mask << 1;
        }
        return count;
    }
}
