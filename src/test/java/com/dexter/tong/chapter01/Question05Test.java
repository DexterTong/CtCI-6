package com.dexter.tong.chapter01;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question05Test {

    @Test
    public void should_return_true_when_arrays_differ_by_one_replacement() {
        int[] arrayA = {4, 5, 7, 8};
        int[] arrayB = {4, 0, 7, 8};
        assertTrue(Question05.oneAway(arrayA, arrayB));
    }

    @Test
    public void should_return_true_when_arrays_are_empty() {
        int[] arrayA = {};
        int[] arrayB = {};
        assertTrue(Question05.oneAway(arrayA, arrayB));
    }

    @Test
    public void should_return_true_when_arrays_are_equal() {
        int[] arrayA = {4, 0, 4};
        int[] arrayB = {4, 0, 4};
        assertTrue(Question05.oneAway(arrayA, arrayB));
    }

    @Test
    public void should_return_true_when_arrays_differ_by_one_insertion() {
        int[] arrayA = {1, 3, 5};
        int[] arrayB = {1, 3, 5, 7};
        assertTrue(Question05.oneAway(arrayA, arrayB));
    }

    @Test
    public void should_return_true_when_arrays_differ_by_one_deletion() {
        int[] arrayA = {2, 4, 6, 8};
        int[] arrayB = {4, 6, 8};
        assertTrue(Question05.oneAway(arrayA, arrayB));
    }

    @Test
    public void should_return_false_when_arrays_are_not_one_away() {
        int[] arrayA = {2, 4, 6, 8};
        int[] arrayB = {1, 3, 6, 8};
        assertFalse(Question05.oneAway(arrayA, arrayB));
    }
}