package com.dexter.tong.chapter08;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question05Test {

    @Test
    public void should_be_1000_when_20_and_50() {
        assertEquals(1000, Question05.multiply(20, 50));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IAE_when_negative() {
        Question05.multiply(4, -1);
        fail("IllegalArgumentException should have been thrown");
    }

    @Test
    public void should_be_0_when_0_and_n() {
        assertEquals(0, Question05.multiply(0, 99));
    }

    @Test
    public void should_be_38173090_when_1178_and_32405() {
        assertEquals(38173090, Question05.multiply(1178, 32405));
    }
}