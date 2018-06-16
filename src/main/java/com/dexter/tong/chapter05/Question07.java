package com.dexter.tong.chapter05;

public class Question07 {

    /**
     * 5.7
     * Write a program to swap odd and even bits in an integer with as few instructions as
     * possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
     */
    public static int swapBitPairs(int num) {

        // To save some cycles, assume that an int has exactly 32 bits
        // This mask has 1's at all the odd bits and 0's at all the even bits (zero-indexing)
        final int mask = 0b10101010101010101010101010101010;

        /*
        What's happening in this one-liner:
            1.
                (num & mask) >>> 1
                Get all the odd bits, then logical rshift by 1 to put them in the other bit index of the pair
            2.
                (num & (mask >>> 1)) << 1
                Logical rshift the mask by 1 bit, so the 1's are in the even bit indices
                Then AND with num to get the even bits of num
                Finally, lshift the result by 1 bit to line it up with the other bit index of the pair
            3.
                OR the two results and then return it, as the flipped number
         */
        return ((num & mask) >>> 1) | ((num & (mask >>> 1)) << 1);

        /*
        In total, we have done this in 7 bitwise operations, if we count initializing the mask as 1 operation
        I think that this would be the minimum possible number of operations, since we need to do these distinct steps:
            1. Create a mask to get the odd bits
            2. Get the odd bits
            3. Move the odd bits to the even bit positions
            4-6. Repeat 1-3 for the even bits
            7. Combine the two bit patterns
        */
    }
}
