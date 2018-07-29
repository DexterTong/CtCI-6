package com.dexter.tong.chapter16;

import java.awt.*;

public class Question01 {
    /**
     * 16.1
     * Write a function to swap a number in place (that is, without temporary variables).
     */
    public static Point swapNumbers(int a, int b) {
        // I'm going to ignore potential int under/overflow for now
        a += b;     // a == a + b
        b -= a;     // b == b - ( a + b ) == -a
        a += b;     // a == b
        b *= -1;    // b == a
        return new Point(a, b);
    }
}
