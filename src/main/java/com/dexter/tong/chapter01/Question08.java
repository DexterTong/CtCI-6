package com.dexter.tong.chapter01;

public class Question08 {

    /**
     * 1.8
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to O.
     * Time: O(m*n)
     * Space: O(m+n)
     */
    public static int[][] zeroifyMatrix(int[][] matrix) {

        //Sanity checks to see if row/col exist and non-null
        if(matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return null;
        }

        //Check that 2d array is not "jagged"
        int colSize = matrix[0].length;
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i].length != colSize) {
                return null;
            }
        }

        //Find cols and rows that should be zeroed out
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];

        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == 0) {
                    zeroRows[r] = true;
                    zeroCols[c] = true;
                }
            }
        }

        //Zero out rows
        for(int r = 0; r < zeroRows.length; r++) {
            if(zeroRows[r]) {
                for(int c = 0; c < matrix[r].length; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        //Zero out cols
        for(int c = 0; c < zeroCols.length; c++) {
            if(zeroCols[c]) {
                for(int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        return matrix;
    }
}
