package com.dexter.tong.chapter08;

import java.util.HashMap;

public class Question05 {
    /**
     * 8.5
     * Write a recursive function to multiply two positive integers without using the
     * * operator. You can use addition, subtraction, and bit shifting, but you should minimize the number
     * of those operations.
     */
    public static int multiply(int a, int b) {
        if(a < 0 || b < 0)
            throw new IllegalArgumentException("Both factors must be non-negative");
        if(a == 0 || b == 0)
            return 0;

        int lg = a > b ? a : b;
        int sm = a > b ? b : a;

        return multiplyHelper(lg, sm);
    }

    private static int multiplyHelper(int lg, int sm) {

        if(sm == 1)
            return lg;

        // Compute lg * (sm/2)
        int product = multiplyHelper(lg, sm >> 1);

        // Double the half-product to get lg * sm
        product = product << 1;

        // Correction for the case where sm is odd
        if((sm & 1) != 0)
            product += lg;

        return product;
    }
}
