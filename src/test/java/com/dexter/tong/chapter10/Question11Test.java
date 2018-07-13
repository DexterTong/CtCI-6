package com.dexter.tong.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question11Test {

    @Test
    public void when_odd_number_of_elements() {
        int[] input = new int[]{1, 4, 5, 8, 6, 9, 2};
        int[] expected = new int[]{1, 9, 2, 8, 4, 6, 5};
        assertArrayEquals(expected, Question11.makePeaksAndValleys(input));
    }

    @Test
    public void when_even_number_of_elements() {
        int[] input = new int[]{1, 5, 4, 8, 9, 2};
        int[] expected = new int[]{1, 9, 2, 8, 4, 5};
        assertArrayEquals(expected, Question11.makePeaksAndValleys(input));
    }

    @Test
    public void when_duplicate_elements() {
        int[] input = new int[]{1, 5, 4, 8, 9, 4, 4};
        int[] expected = new int[]{1, 9, 4, 8, 4, 5, 4};
        assertArrayEquals(expected, Question11.makePeaksAndValleys(input));

    }
}