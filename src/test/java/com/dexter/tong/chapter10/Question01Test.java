package com.dexter.tong.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question01Test {

    @Test
    public void should_merge_sorted_arrays() {
        int[] inputDest = new int[]{0, 1, 3, 4, 4, 5, 6, 9, 0, 0, 0, 0, 0};
        int[] inputSrc = new int[]{2, 6, 7, 8, 9};
        int[] expected = new int[]{0, 1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9};
        assertArrayEquals(expected, Question01.mergeSorted(inputDest, 8, inputSrc));
    }
}