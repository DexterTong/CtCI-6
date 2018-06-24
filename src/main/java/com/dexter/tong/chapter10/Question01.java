package com.dexter.tong.chapter10;

public class Question01 {
    /**
     * 10.1
     * You are given two sorted arrays, A and B, where A has a large enough buffer at the
     * end to hold B. Write a method to merge B into A in sorted order.
     */
    // I am assuming that dest is just big enough to hold all elements
    public static int[] mergeSorted(int[] dest, int destLength, int[] src) {
        if(dest.length - destLength != src.length)
            throw new IllegalArgumentException("dest array is not right size to hold merged array");

        // Find the first index of dest that is greater than src
        int current = 0;
        while(dest[current] <= src[0]) {
            current++;
        }

        // Copy the rest of dest to the back of dest
        int shiftIndex = dest.length;
        for(int i = 1; i <= destLength - current; i++) {
            shiftIndex = dest.length - i;
            dest[shiftIndex] = dest[destLength - i];
        }

        // Merge src and the shifted part of dest back in
        int srcIndex = 0;
        while(srcIndex < src.length && shiftIndex < dest.length) {
            if(dest[shiftIndex] <= src[srcIndex]) {
                dest[current] = dest[shiftIndex];
                shiftIndex++;
            } else {
                dest[current] = src[srcIndex];
                srcIndex++;
            }
            current++;
        }

        // Copy any remaining elements from src into dest
        while(current < destLength) {
            dest[current] = src[srcIndex];
            srcIndex++;
            current++;
        }

        return dest;
    }
}
