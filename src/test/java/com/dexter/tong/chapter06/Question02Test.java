package com.dexter.tong.chapter06;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question02Test {

    @Test
    public void A_should_return_2_when_p_greater_than_half() {
        assertEquals(2, Question02.whichGameToPlayA(0.7));
    }

    @Test
    public void A_should_return_1_when_p_less_than_half() {
        assertEquals(1, Question02.whichGameToPlayA(0.1));
    }

    @Test
    public void B_should_return_2_when_p_greater_than_half() {
        assertEquals(2, Question02.whichGameToPlayB(0.7));
    }

    @Test
    public void B_should_return_1_when_p_less_than_half() {
        assertEquals(1, Question02.whichGameToPlayB(0.1));
    }
}