package com.dexter.tong.chapter05;

public class Question05 {
    /**
     * 5.5
     * Explain what the following code does: ( (n & (n - 1) == 0)
     */
    /*
    If n > 0:
        This would be isPowerOf2(n)
        For the left side to equal 0, n and (n-1) must have no set bits in common
        For n equal to any power of 2, we have
        n  =  0b0...010...0
        n-1 = 0b0...001...1
        As they have no set bits in common, ANDing them gives 0
        For n not a power of 2, at least 1 bit will be in common between n and n-1

    If n == 0:
        Since 0 = 0b0...0 and -1 = 0b1...1, this will be true
        0 is not a power of 2, though

    If n < 0:
        This will always be false, since the sign bit is always set
     */
}
