package com.dexter.tong.chapter10;

public class Question03 {

    /**
     * 10.3
     * Given a sorted array of n integers that has been rotated an unknown
     * number of times, write code to find an element in the array. You may assume that the array was
     * originally sorted in increasing order.
     */
    public static int searchRotated(int value, int[] numbers) {
        int startIndex = findStart(numbers);
        if(startIndex == -1)
            return binarySearch(numbers, value, 0, numbers.length - 1);
        if(numbers[startIndex] == value )
            return startIndex;
        if(numbers[0] < value)
            return binarySearch(numbers, value, 0, startIndex - 1);
        else
            return binarySearch(numbers, value, startIndex + 1, numbers.length - 1);
    }

    private static int binarySearch(int[] numbers, int value, int left, int right) {
        int middle = (left + right) / 2;
        if(numbers[middle] == value)
            return middle;
        if(numbers[middle] < value)
            return binarySearch(numbers, value, middle + 1, right);
        else
            return binarySearch(numbers, value, left, middle - 1);
    }

    private static int findStart(int[] numbers) {
        return findStart(numbers, 0, numbers.length - 1);
    }

    private static int findStart(int[] numbers, int left, int right) {
        if(left > right)
            return -1;
        if(left == right)
            return left;
        int middle = (left + right) / 2;
        if(middle < right && numbers[middle] > numbers[middle + 1])
            return middle + 1;
        if(middle > left && numbers[middle] < numbers[middle - 1])
            return middle;
        if(numbers[left] >= numbers[middle])
            return findStart(numbers, left, middle - 1);
        else
            return findStart(numbers, middle + 1, right);
    }
}
