package com.dexter.tong.utils;

public class Bytes {

    /**
     * For some int, get the ith bit from the right (0th bit is LSB)
     */
    public static boolean getBit(int num, int i) {

        // Generate the mask, which will be 0...010...0 where there are i 0's the right of the 1
        int mask = 1 << i;

        // By ANDing the num and mask, result will have 0's at all positions except the ith one
        // If num[i] is 1, then result[i] is 1, else, result[i] = 0
        int result = num & mask;

        // If the ith bit of result is set (the only bit that could be set), then this is true
        return result != 0;
    }

    /**
     * For some int num, we want to set the ith bit of num to 1, regardless of the original value
     */
    public static int setBit(int num, int i) {

        // Again, create the mask
        int mask = 1 << i;

        // The non-ith bits of num are unaffected, since we are doing OR with 0
        // The ith bit of num is set to 1 always, since mask[i] is 1
        return num | mask;
    }

    /**
     * Opposite of setBit(), want to set the ith bit to 0
     */
    public static int clearBit(int num, int i) {

        // Create the mask and flip all the bits, so mask[i] is 0, all others are 1
        int mask = 1 << i;
        mask = ~mask;

        // On the non-ith bits, ANDing with 1 is the identity function
        // On the ith bit, ANDing with 0 always clears the bit
        return num & mask;
    }

    /**
     * Clear the most significant (leftmost) through ith bits, inclusive
     * So for example, clearBitsMSBthroughI(01101110, 3) == 00000110
     */
    public static int clearBitsMSBthroughI(int num, int i) {

        // As usual, create the mask 0...010...0
        int mask = 1 << i;

        // Then, convert it to 0...001...1 where the most significant 1 is at the (i-1)th bit
        mask -= 1;

        return num & mask;
    }

    /**
     * Opposite of the previous, clear the bits i through the least significant (rightmost) bit, inclusive
     */
    public static int clearBitsIthrough0(int num, int i) {

        // We start with the bit sequence 1...1
        int mask = -1;

        // Now mask is 1...10...0 where the leftmost 0 is at the ith bit
        mask = mask << (i + 1);

        return num & mask;
    }

    /**
     * Set the ith bit of num to the specified value
     */
    public static int updateBit(int num, int i, boolean value) {

        // Create the mask 1...101...1
        int maskA = ~(1 << i);

        int v = value ? 1 : 0;

        // Create the mask 0...0v0...0
        int maskB = v << i;

        // Clear the ith bit of num
        int temp = num & maskA;

        // Set the ith bit of num to whatever value is
        return temp | maskB;
    }
}
