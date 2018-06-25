package com.dexter.tong.chapter10;

import java.util.Arrays;

public class Question04 {
    /**
     * 10.4
     * You are given an array-like data structure Listy which lacks a size
     * method. It does, however, have an elementAt (i) method that returns the element at index i in
     * 0(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
     * structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
     * find the index at which an element x occurs. If x occurs multiple times, you may return any index.
     */
    public static int findInListy(int value, Listy listy) {
        int length = findLength(listy);
        return binarySearch(listy, value, 0, length);
    }

    // Assumption: Listy cannot hold more than 2^31-1 elements
    private static int findLength(Listy listy) {

        int testLength = 1;
        while(listy.elementAt(testLength -1) != -1) {
            testLength *= 2;
        }

        return 1 + findLength(listy, testLength / 2 + 1, testLength - 1);
    }

    private static int findLength(Listy listy, int min, int max) {
        int middle = (min + max) / 2;
        if(listy.elementAt(middle) != -1) {
            if(listy.elementAt(middle + 1) == -1)
                return middle;
            return findLength(listy, middle + 1, max);
        } else
            return findLength(listy, min, middle - 1);
    }

    private static int binarySearch(Listy listy, int value, int min, int max) {
        if(min > max)
            return -1;
        int middle = (min + max) / 2;
        if(listy.elementAt(middle) == value)
            return middle;
        if(listy.elementAt(middle) > value)
            return binarySearch(listy, value, min, middle - 1);
        return binarySearch(listy, value, middle + 1, max);
    }

    public Listy createListy(int[] elements) {
        return new Listy(elements);
    }

    public class Listy {
        private int[] elements;

        public Listy(int[] elements) {
            this.elements = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] < 1)
                    throw new IllegalArgumentException("Listy cannot contain non-positive values");
                this.elements[i] = elements[i];
            }
            Arrays.sort(this.elements);
        }

        private int elementAt(int i) {
            if(i < 0 || i >= elements.length)
                return -1;
            return elements[i];
        }
    }

}
