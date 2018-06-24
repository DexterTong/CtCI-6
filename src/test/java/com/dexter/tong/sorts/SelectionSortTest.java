package com.dexter.tong.sorts;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void should_sort_array() {
        int[] input = new int[]{3, 2, 7, 9, 8, 0, 1, 4, 6, 5, 3};
        int[] expected = new int[]{0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, SelectionSort.sort(input));
    }
}