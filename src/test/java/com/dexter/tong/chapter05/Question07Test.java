package com.dexter.tong.chapter05;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question07Test {

    @Test
    public void should_swap_bit_pairs1() {
        assertEquals(0b10101010101010101010101010101010, Question07.swapBitPairs(0b01010101010101010101010101010101));
    }

    @Test
    public void should_swap_bit_pairs2() {
        assertEquals(0b11100101, Question07.swapBitPairs(0b11011010));
    }
}