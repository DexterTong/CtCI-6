package com.dexter.tong.chapter01;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Question08Test {

    @Test
    public void should_return_equal_matrix_if_no_zeroes() {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6}
        };

        assertTrue(Arrays.deepEquals(Question08.zeroifyMatrix(input), expected));
    }

    @Test
    public void should_be_null_if_matrix_is_not_initialized() {
        int[][] input = new int[3][2];
        input[0] = new int[]{3, 4};
        input[1] = null;
        assertNull(Question08.zeroifyMatrix(input));
    }

    @Test
    public void should_be_null_if_matrix_is_jagged() {
        int[][] input = new int[2][];
        input[0] = new int[]{3, 4};
        input[1] = new int[]{6, 0, 2};
        assertNull(Question08.zeroifyMatrix(input));
    }

    @Test
    public void should_be_zeroified_if_matrix_contains_zero() {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 4}
        };

        int[][] expected = {
                {1, 0, 3},
                {4, 0, 6},
                {0, 0, 0}
        };
        assertTrue(Arrays.deepEquals(Question08.zeroifyMatrix(input), expected));
    }

    @Test
    public void should_be_zeroified_if_matrix_contains_multiple_zeroes() {
        int[][] input = {
                {1, 2, 3, 5},
                {4, 5, 6, 0},
                {7, 0, 4, 1},
                {7, 4, 3, 8}
        };

        int[][] expected = {
                {1, 0, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {7, 0, 3, 0}
        };

        assertTrue(Arrays.deepEquals(Question08.zeroifyMatrix(input), expected));
    }
}