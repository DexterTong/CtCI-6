package com.dexter.tong.chapter10;

import java.awt.*;

public class Question09 {
    /**
     * 10.9
     * Given an M x N matrix in which each row and each column is sorted in
     * ascending order, write a method to find an element.
     */
    public static Point findInMatrix(int[][] matrix, int target) {
        return findInMatrix(matrix, target, new Point(0, 0), new Point(matrix.length-1, matrix[0].length-1));
    }
    /*
    1. Check top left and bottom right to see if target could be in matrix
    2. binary search for the 2 "main diagonal" elements bracketing target value, call them MDmin and MDmax
    3. exclude the submatrix from 0,0 to MDmin and the submatrix from MDmax to M,N
    4. Repeat this process on the two resultant matrices, the top right and bottom left
     */

    private static Point findInMatrix(int[][] matrix, int target, Point topLeft, Point bottomRight) {

        if(topLeft.x > bottomRight.x)
            return null;
        if(topLeft.y > bottomRight.y)
            return null;
        if(getValue(matrix, topLeft) > target)
            return null;
        if(getValue(matrix, bottomRight) < target)
            return null;

        if(topLeft.equals(bottomRight))
            return getValue(matrix, topLeft) == target ? topLeft : null;

        // If midpoint.equals(topLeft) then topLeft and bottomRight are either the same or dia/orthogonally adjacent
        Point midpoint = new Point((topLeft.x + bottomRight.x) / 2, (topLeft.y + bottomRight.y) / 2);

        int midpointValue = getValue(matrix, midpoint);

        if(midpointValue == target)
            return midpoint;

        Point topRight;
        Point bottomLeft;

        if(midpointValue > target) {
            Point upperLeftResult = findInMatrix(matrix, target, topLeft, new Point(midpoint.x-1, midpoint.y-1));
            if(upperLeftResult != null)
                return upperLeftResult;
            topRight = new Point(midpoint.x, midpoint.y-1);
            bottomLeft = new Point(midpoint.x-1, midpoint.y);
        } else {
            Point bottomRightResult = findInMatrix(matrix, target, new Point(midpoint.x+1, midpoint.y+1), bottomRight);
            if(bottomRightResult != null)
                return bottomRightResult;
            topRight = new Point(midpoint.x+1, midpoint.y);
            bottomLeft = new Point(midpoint.x, midpoint.y+1);
        }
        Point topRightResult = findInMatrix(matrix, target, new Point(topRight.x, topLeft.y), new Point(bottomRight.x, topRight.y));
        if(topRightResult != null)
            return topRightResult;
        Point bottomLeftResult = findInMatrix(matrix, target, new Point(topLeft.x, bottomLeft.y), new Point(bottomLeft.x, bottomRight.y));
        return bottomLeftResult;
    }

    private static int getValue(int[][] matrix, Point p) {
        return matrix[p.x][p.y];
    }
}
