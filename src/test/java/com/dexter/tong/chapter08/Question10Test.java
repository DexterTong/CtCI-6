package com.dexter.tong.chapter08;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question10Test {

    @Test
    public void should_fill_in_area() {
        int[][] input = new int[][] {
                {2, 1, 1, 1, 1, 1},
                {0, 1, 1, 2, 1, 1},
                {0, 0, 2, 2, 2, 2},
                {0, 0, 1, 2, 1, 2},
                {0, 0, 1, 1, 1, 2}
        };
        int[][] expected = new int[][] {
                {2, 1, 1, 1, 1, 1},
                {0, 1, 1, 4, 1, 1},
                {0, 0, 4, 4, 4, 4},
                {0, 0, 1, 4, 1, 4},
                {0, 0, 1, 1, 1, 4}
        };

        int[][] result = Question10.paintFill(3, 2, 4, input);

        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i]);
        }
    }

}