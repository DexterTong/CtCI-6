package com.dexter.tong.chapter16;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Question01Test {

    @Test
    public void should_swap_a_and_b() {
        Point expected = new Point(5, 17);
        assertEquals(expected, Question01.swapNumbers(17, 5));
    }

}