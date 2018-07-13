package com.dexter.tong.chapter10;

import com.dexter.tong.sorts.QuickSort;

public class Question11 {
    /**
     * 10.11
     * In an array of integers, a "peak" is an element which is greater than or equal to
     * the adjacent integers and a "valley" is an element which is less than or equal to the adjacent inte-
     * gers. For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {S, 2} are valleys. Given an array
     * of integers, sort the array into an alternating sequence of peaks and valleys.
     */
    public static int[] makePeaksAndValleys(int[] numbers) {
        int[] sorted = QuickSort.sort(numbers);
        int[] result = new int[numbers.length];
        int left = 0;
        int right = sorted.length - 1;
        int i = 0;
        while(left < right) {
            result[i] = sorted[left];
            result[i+1] = sorted[right];
            left++;
            right--;
            i+=2;
        }
        if(left == right)
            result[i] = sorted[left];
        return result;
    }
}
