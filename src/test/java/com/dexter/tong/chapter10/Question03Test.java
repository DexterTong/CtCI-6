package com.dexter.tong.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question03Test {

    @Test
    public void should_find_value_when_in_right_half_and_array_not_rotated() {
        int[] input = new int[]{0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(5, Question03.searchRotated(4, input));
    }

    @Test
    public void should_find_value_when_in_left_half_and_array_not_rotated() {
        int[] input = new int[]{0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(3, Question03.searchRotated(2, input));
    }

    @Test
    public void should_find_value_when_in_left_half_and_pivot_in_left_half() {
        int[] input = new int[]{8, 9, 0, 1, 1, 2, 3, 4, 5, 6, 7};
        assertEquals(2, Question03.searchRotated(0, input));
    }

    @Test
    public void should_find_value_when_in_left_half_and_pivot_in_right_half() {
        int[] input = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 1};
        assertEquals(3, Question03.searchRotated(5, input));
    }

    @Test
    public void should_find_value_when_in_right_half_and_pivot_in_left_half() {
        int[] input = new int[]{8, 9, 0, 1, 1, 2, 3, 4, 5, 6, 7};
        assertEquals(9, Question03.searchRotated(6, input));
    }

    @Test
    public void should_find_value_when_in_right_half_and_pivot_in_right_half() {
        int[] input = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 1};
        assertEquals(8, Question03.searchRotated(0, input));
    }
}