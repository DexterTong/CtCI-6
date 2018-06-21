package com.dexter.tong.chapter08;

import org.junit.Test;

import java.awt.*;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Question02Test {

    @Test
    public void should_find_path_when_no_obstacles() {
        int[][] grid = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        LinkedList<Point> expected = new LinkedList<>();
        expected.add(new Point(0,0));
        expected.add(new Point(1,0));
        expected.add(new Point(2,0));
        expected.add(new Point(3,0));
        expected.add(new Point(3,1));
        expected.add(new Point(3,2));
        expected.add(new Point(3,3));

        assertEquals(expected, Question02.findPath(grid));
    }

    @Test
    public void should_find_path_when_some_obstacles() {
        int[][] grid = new int[][]{
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        LinkedList<Point> expected = new LinkedList<>();
        expected.add(new Point(0,0));
        expected.add(new Point(1,0));
        expected.add(new Point(1,1));
        expected.add(new Point(1,2));
        expected.add(new Point(1,3));
        expected.add(new Point(2,3));
        expected.add(new Point(3,3));

        assertEquals(expected, Question02.findPath(grid));
    }

    @Test
    public void should_find_path_when_backtracking_needed() {
        int[][] grid = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        };

        LinkedList<Point> expected = new LinkedList<>();
        expected.add(new Point(0,0));
        expected.add(new Point(0,1));
        expected.add(new Point(0,2));
        expected.add(new Point(0,3));
        expected.add(new Point(1,3));
        expected.add(new Point(2,3));
        expected.add(new Point(3,3));

        assertEquals(expected, Question02.findPath(grid));
    }
}