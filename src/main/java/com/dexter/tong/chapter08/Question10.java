package com.dexter.tong.chapter08;

public class Question10 {
    /**
     * 8.10
     * Implement the "paint fill" function that one might see on many image editing programs.
     * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
     * fill in the surrounding area until the color changes from the original color.
     */
    public static int[][] paintFill(int x, int y, int color, int[][] canvas) {

        if(x < 0 || x >= canvas[0].length)
            throw new IllegalArgumentException("x must be between 0 and canvas width");
        if(y < 0 || y >= canvas.length)
            throw new IllegalArgumentException("y must be between 0 and canvas height");

        paintFill(x, y, color, canvas[y][x], canvas);
        return canvas;
    }

    private static void paintFill(int x, int y, int newColor, int oldColor, int[][] canvas) {

        if(x < 0 || x >= canvas[0].length)
            return;
        if(y < 0 || y >= canvas.length)
            return;
        if(canvas[y][x] != oldColor)
            return;

        canvas[y][x] = newColor;

        paintFill(x-1, y, newColor, oldColor, canvas);
        paintFill(x+1, y, newColor, oldColor, canvas);
        paintFill(x, y-1, newColor, oldColor, canvas);
        paintFill(x, y+1, newColor, oldColor, canvas);
    }
}
