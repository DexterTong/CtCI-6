package com.dexter.tong.chapter01;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Question07Test {

    private int[][] squareMatrixOne;
    private int[][] squareMatrixTwo;
    private int[][] squareMatrixThree;
    private int[][] squareMatrixFour;

    private int[][] expectedMatrixOne;
    private int[][] expectedMatrixTwo;
    private int[][] expectedMatrixThree;
    private int[][] expectedMatrixFour;

    private int[][] nonSquareMatrix;

    public Question07Test() {

        expectedMatrixOne = new int[][] {
                {1}
        };

        expectedMatrixTwo = new int[][]{
                {5, 1},
                {0, 6}
        };

        expectedMatrixThree = new int[][]{
                {1, 5, 9},
                {2, 4, 8},
                {3, 3, 7}
        };

        expectedMatrixFour = new int[][]{
                {5, 4, 5, 1},
                {5, 8, 0, 3},
                {6, 7, 1, 8},
                {6, 1, 2, 0}
        };
    }

    @Test
    public void should_rotate_1_by_1_matrix_A() {
        assertTrue(Arrays.deepEquals(Question07.rotateMatrix(squareMatrixOne), expectedMatrixOne));
    }

    @Test
    public void should_rotate_2_by_2_matrix_A() {
        assertTrue(Arrays.deepEquals(Question07.rotateMatrix(squareMatrixTwo), expectedMatrixTwo));
    }

    @Test
    public void should_rotate_3_by_3_matrix_A() {
        assertTrue(Arrays.deepEquals(Question07.rotateMatrix(squareMatrixThree), expectedMatrixThree));
    }

    @Test
    public void should_rotate_4_by_4_matrix_A() {
        assertTrue(Arrays.deepEquals(Question07.rotateMatrix(squareMatrixFour), expectedMatrixFour));
    }

    @Test
    public void should_return_null_when_non_square_matrix_A() {
        assertNull(Question07.rotateMatrix(nonSquareMatrix));
    }

    @Test
    public void should_rotate_1_by_1_matrix_B() {
        assertTrue(Arrays.deepEquals(Question07.rotateMatrixInPlace(squareMatrixOne), expectedMatrixOne));
    }

    @Test
    public void should_rotate_2_by_2_matrix_B() {
        assertTrue(Arrays.deepEquals(Question07.rotateMatrixInPlace(squareMatrixTwo), expectedMatrixTwo));
    }

    @Test
    public void should_rotate_3_by_3_matrix_B() {
        assertTrue(Arrays.deepEquals(Question07.rotateMatrixInPlace(squareMatrixThree), expectedMatrixThree));
    }

    @Test
    public void should_rotate_4_by_4_matrix_B() {
        assertTrue(Arrays.deepEquals(Question07.rotateMatrixInPlace(squareMatrixFour), expectedMatrixFour));
    }

    @Test
    public void should_return_null_when_non_square_matrix_B() {
        assertNull(Question07.rotateMatrixInPlace(nonSquareMatrix));
    }

    @Before
    public void initializeMatrices() {
        squareMatrixOne = new int[][]{
                {1}
        };

        squareMatrixTwo = new int[][]{
                {1, 6},
                {5, 0}
        };

        squareMatrixThree = new int[][]{
                {9, 8, 7},
                {5, 4, 3},
                {1, 2, 3}
        };

        squareMatrixFour = new int[][]{
                {1, 3, 8, 0},
                {5, 0, 1, 2},
                {4, 8, 7, 1},
                {5, 5, 6, 6}
        };

        nonSquareMatrix = new int[][]{
                {3, 5}
        };
    }
}