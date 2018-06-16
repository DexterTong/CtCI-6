package com.dexter.tong.chapter05;

public class Question07 {

    /**
     * 5.7
     * Write a program to swap odd and even bits in an integer with as few instructions as
     * possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
     */
    public static int swapBitPairs(int num) {;
        /*
        What's happening in this one-liner:
            1.
                (num & 0xAAAAAAAA) >>> 1
                Get all the odd bits, then logical rshift by 1 to put them in the other bit index of the pair
                Note, 0xAAAAAAAA is equivalent to 0b10...10, i.e. 0s at the even bits and 1s at the odds (zero-indexed)
            2.
                (num & 0x55555555) << 1
                AND num with the mask to get the even bits of num
                Note, 0x55555555 is equivalent to 0b01...01, i.e. 1s at the even bits and 0s at the odds (zero-indexed)
                Finally, lshift the result by 1 bit to line it up with the other bit index of the pair
            3.
                OR the two results and then return it, as the flipped number
         */
        return ((num & 0xAAAAAAAA) >>> 1) | ((num & 0x55555555) << 1);

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
