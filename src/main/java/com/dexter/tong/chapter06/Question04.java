package com.dexter.tong.chapter06;

public class Question04 {
    /**
     * 6.4
     * There are three ants on different vertices of a triangle. What is the probability of
     * collision (between any two or all of them) if they start walking on the sides of the triangle? Assume
     * that each ant randomly picks a direction, with either direction being equally likely to be chosen, and
     * that they walk at the same speed.
     * Similarly, find the probability of collision with n ants on an n-vertex polygon.
     */
    /*
    For nomenclature, let's suppose that each ant starts facing away from the inside of the polygon
    When they start walking, they must choose a direction by either going clockwise. or counterclockwise
    If an ant turns clockwise, they have to turn right to start moving clockwise, so denote that choice right, or R
    Similarly, denote moving counterclockwise to be left, or L

    For any two ants to collide, one must have picked L, and the other R
        (by walking around the perimeter in different directions, they will eventually meet)
    The only way for the ants to not collide is if they all pick the same direction
        This is the probability that all pick L (0.5^3) or all pick R (0.5^3)
    So P(collision) = 1 - 2 * 0.5^3

    Similarly, the only way for N ants on an N-gon to not collide is if they all pick R, or all pick L:
    P(collision) = 1 - 2 * (0.5^N)
     */
}
