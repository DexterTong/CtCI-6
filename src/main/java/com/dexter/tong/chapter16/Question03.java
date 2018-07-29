package com.dexter.tong.chapter16;

import java.awt.geom.Point2D;

public class Question03 {
    /**
     * 16.3
     * Given two straight line segments (represented as a start point and an end point),
     * compute the point of intersection, if any.
     */
    private static final double EPSILON = 1E-6;

    public static Point2D.Double calculateIntersection(Point2D.Double a1, Point2D.Double a2, Point2D.Double b1, Point2D.Double b2) {
        double slopeA = calculateSlope(a1, a2);
        double slopeB = calculateSlope(b1, b2);

        double interceptA = calculateIntercept(slopeA, a1);
        double interceptB = calculateIntercept(slopeB, b1);

        // If 2 lines have the same slope, then they are parallel, and...
        //      if they also have the same y-intercept, they are the same line
        //      if they have different y-intercepts, they cannot intersect
        if(areEqual(slopeA, slopeB))
            if(areEqual(interceptA, interceptB)) {
                return new Point2D.Double(0, interceptA);
            } else
                return null;

        return calculateIntersection(slopeA, interceptA, slopeB, interceptB);
    }

    private static double calculateSlope(Point2D.Double p1, Point2D.Double p2) {
        if(p1 == null || p2 == null)
            throw new IllegalArgumentException("Points cannot be null.");
        if(areEqual(p1.x, p2.x))
            throw new IllegalArgumentException("Points cannot have the same x value.");
        return (p2.y - p1.y) / (p2.x - p1.x);
    }

    // Given a point on a line and its slope, calculate the y-intercept
    private static double calculateIntercept(double slope, Point2D.Double p) {
        return p.y - slope * p.x;
    }

    private static Point2D.Double calculateIntersection(double slopeA, double interceptA, double slopeB, double interceptB) {
        double intersectionX = (interceptB - interceptA) / (slopeA - slopeB);
        double intersectionY = slopeA * intersectionX + interceptA;
        return new Point2D.Double(intersectionX, intersectionY);
    }

    public static boolean areEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }
}
