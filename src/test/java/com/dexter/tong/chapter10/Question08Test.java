package com.dexter.tong.chapter10;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Question08Test {

    @Test
    public void should_find_singly_duplicated_ints() {
        int[] input = new int[]{1, 3, 4, 2, 4, 9, 300, 300, 299};
        Integer[] result = Question08.findDuplicates(input);
        Integer[] expected = new Integer[]{4, 300};
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_be_empty_when_no_duplicates() {
        int[] input = new int[]{1, 3, 4, 2, 9, 300, 299};
        Integer[] result = Question08.findDuplicates(input);
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_find_multiply_duplicated_ints() {
        int[] input = new int[]{1, 300, 4, 2, 4, 9, 300, 300, 299};
        Integer[] result = Question08.findDuplicates(input);
        Integer[] expected = new Integer[]{4, 300, 300};
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_find_duplicated_min() {
        int[] input = new int[]{1, 1, 299};
        Integer[] result = Question08.findDuplicates(input);
        Integer[] expected = new Integer[]{1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void should_find_duplicated_max() {
        int[] input = new int[]{11, 32000, 6, 32000};
        Integer[] result = Question08.findDuplicates(input);
        Integer[] expected = new Integer[]{32000};
        assertArrayEquals(expected, result);
    }
}