package com.dexter.tong.chapter01;

public class Question07 {

    /**
     * 1.7a
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
     * the image by 90 degrees.
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public static int[][] rotateMatrix(int[][] matrix) {

        //Sanity check to verify the matrix is square
        int size = matrix.length;
        for(int[] col : matrix) {
            if(col.length != size) {
                return null;
            }
        }

        int[][] rotatedMatrix = new int[size][size];

        for(int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                rotatedMatrix[c][size - 1 - r] = matrix[r][c];
            }
        }

        return rotatedMatrix;
    }

    /**
     * 1.7b
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
     * the image by 90 degrees. Can you do this in place?
     * Time: O(n^2)
     * Space: O(1)
     */
    public static int[][] rotateMatrixInPlace(int[][] matrix) {

        //Sanity check to verify the matrix is square
        int size = matrix.length;
        for(int[] col : matrix) {
            if(col.length != size) {
                return null;
            }
        }

        int s = size - 1;
        for(int r = 0; r <= size / 2; r++) {
            for(int c = r; c < size - (r + 1); c++) {
                int temp = matrix[c][s-r];
                matrix[c][s-r] = matrix[r][c];
                matrix[r][c] = matrix[s-c][r];
                matrix[s-c][r] = matrix[s-r][s-c];
                matrix[s-r][s-c] = temp;
            }
        }

        return matrix;
    }
}
