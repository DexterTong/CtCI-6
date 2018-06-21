package com.dexter.tong.chapter08;

import java.awt.*;
import java.util.LinkedList;

public class Question02 {
    /**
     * 8.2
     * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
     * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
     * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
     * the bottom right.
     */
    public static LinkedList<Point> findPath(int[][] grid) {
        LinkedList<Point> path = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        findPath(grid, 0, 0, path, visited);
        return path;
    }

    private static boolean findPath(int[][] grid, int x, int y, LinkedList<Point> path, boolean[][] visited) {

        if(!validMove(grid, x, y))
            return false;
        if(visited[x][y])
            return false;
        visited[x][y] = true;

        if(x == grid.length - 1 && y == grid[0].length - 1) {
            path.addFirst(new Point(x, y));
            return true;
        }

        boolean pathFound = findPath(grid, x+1, y, path, visited);
        if(!pathFound)
            pathFound = findPath(grid, x, y+1, path, visited);
        if(pathFound)
            path.addFirst(new Point(x, y));

        return pathFound;
    }

    private static boolean validMove(int[][] grid, int x, int y) {
        if( y < 0 || y >= grid.length)
            return false;
        if( x < 0 || x >= grid[0].length)
            return false;
        return grid[y][x] == 0;
    }
}
