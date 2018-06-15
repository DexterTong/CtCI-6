package com.dexter.tong.chapter05;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question03Test {

    @Test
    public void should_return_8_when_0b11011101111() {
        assertEquals(8, Question03.flipBitToWin(0b11011101111));
    }

    @Test
    public void should_return_5_when_0b11011001111() {
        assertEquals(5, Question03.flipBitToWin(0b11011001111));
    }

    @Test
    public void should_return_32_when_negative_1() {
        assertEquals(32, Question03.flipBitToWin(-1));
    }

    @Test
    public void should_return_1_when_0() {
        assertEquals(1, Question03.flipBitToWin(0));
    }


}