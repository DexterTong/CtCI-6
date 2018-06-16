package com.dexter.tong.chapter05;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question06Test {

    @Test
    public void should_be_2_when_29_and_15() {
        assertEquals(2, Question06.bitFlipsNeeded(0b11101, 0b01111));
    }

    @Test
    public void should_be_6_when_305222_and_23565() {
        assertEquals(6, Question06.bitFlipsNeeded(0b101010, 0b010101));
    }

    @Test
    public void should_be_0_when_numbers_equal() {
        assertEquals(0, Question06.bitFlipsNeeded(-45, -45));
    }
}