package com.dexter.tong.sorts;

public class SelectionSort {

    public static int[] sort(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = -1;
            for(int j = i; j < numbers.length; j++) {
                if(numbers[j] < smallest) {
                    smallest = numbers[j];
                    smallestIndex = j;
                }
            }
            utils.swap(i, smallestIndex, numbers);
        }
        return numbers;
    }
}
