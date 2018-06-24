package com.dexter.tong.sorts;

public class BubbleSort {

    public static int[] sort(int[] numbers) {
        for(int i = 0; i < numbers.length -1; i++) {
            for(int j = 0; j < numbers.length - 1; j++) {
                if(numbers[j] > numbers[j+1])
                    utils.swap(j, j+1, numbers);
            }
        }
        return numbers;
    }
}
