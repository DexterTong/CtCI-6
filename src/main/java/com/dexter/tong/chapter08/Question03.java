package com.dexter.tong.chapter08;

public class Question03 {
    /**
     * 8.3
     * A magic index in an array A [e ... n -1] is defined to be an index such that A[ i] =
     * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
     * array A.
     * FOLLOW UP
     * What if the values are not distinct?
     */
    public static int distinctMagicIndex(int[] numbers) {
        int i = 0;

        while(i < numbers.length) {
            if(numbers[i] > i)
                return -1;
            if(numbers[i] == i)
                return i;
            i++;
        }

        return -1;
    }
    /*
    We search through the array from index 0 towards the end
    If for some i, numbers[i] == i, we are done
    If numbers[i] > i, then there cannot be a magic index after i
        Let's say numbers[i] == i + c, for some c > 1
        Then for any j >= 0, we have that numbers[i+j] >= i + j + c
        Clearly, this is not going to work
    Finally, if numbers[i] < i, we increment i by 1
     */

    public static int indistinctMagicIndex(int[] numbers) {
        int i = 0;

        while(i < numbers.length) {

            if(numbers[i] > i) {
                i = numbers[i];
                continue;
            }

            if(numbers[i] == i)
                return i;

            i++;
        }

        return -1;
    }
}
