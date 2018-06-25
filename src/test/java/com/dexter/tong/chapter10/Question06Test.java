package com.dexter.tong.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question06Test {

    @Test
    public void should_return_a_missing_int() {
        int[] input = new int[]{0, 1, 3, 2, 4, 7, 8, 9, 5};
        assertEquals(6, Question06.missingInt(input));
    }

}