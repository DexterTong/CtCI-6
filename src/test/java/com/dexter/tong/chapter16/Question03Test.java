package com.dexter.tong.chapter16;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class Question03Test {

    @Test
    public void should_find_intersection_when_lines_intersect() {
        Point2D.Double a1 = new Point2D.Double(0, 2);
        Point2D.Double a2 = new Point2D.Double(3.5, 16);
        Point2D.Double b1 = new Point2D.Double(-3, -7);
        Point2D.Double b2 = new Point2D.Double(5.1, -15.1);
        Point2D.Double expected = new Point2D.Double(-2.4, -7.6);
        assertEquals(expected, Question03.calculateIntersection(a1, a2, b1, b2));
    }

    @Test
    public void should_find_intersection_when_lines_intersect_and_points_reversed() {
        Point2D.Double a1 = new Point2D.Double(3.5, 16);
        Point2D.Double a2 = new Point2D.Double(0, 2);
        Point2D.Double b1 = new Point2D.Double(-3, -7);
        Point2D.Double b2 = new Point2D.Double(5.1, -15.1);
        Point2D.Double expected = new Point2D.Double(-2.4, -7.6);
        assertEquals(expected, Question03.calculateIntersection(a1, a2, b1, b2));
    }

    @Test
    public void should_find_intersection_when_lines_identical() {
        Point2D.Double a1 = new Point2D.Double(1, 3);
        Point2D.Double a2 = new Point2D.Double(7, 15);
        Point2D.Double b1 = new Point2D.Double(2, 5);
        Point2D.Double b2 = new Point2D.Double(3, 7);
        Point2D.Double expected = new Point2D.Double(0, 1);
        assertEquals(expected, Question03.calculateIntersection(a1, a2, b1, b2));
    }

    @Test
    public void should_be_null_when_lines_parallel_and_non_identical() {
        Point2D.Double a1 = new Point2D.Double(1, 3);
        Point2D.Double a2 = new Point2D.Double(7, 15);
        Point2D.Double b1 = new Point2D.Double(0, -4);
        Point2D.Double b2 = new Point2D.Double(2, 0);
        assertNull(Question03.calculateIntersection(a1, a2, b1, b2));
    }
}