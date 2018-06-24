package com.dexter.tong.sorts;

public class MergeSort {

    public static int[] sort(int[] numbers) {
        int[] helper = new int[numbers.length];
        mergeSort(numbers, helper, 0, numbers.length-1);
        return numbers;
    }

    private static void mergeSort(int[] numbers, int[] helper, int min, int max) {
        if(min >= max)
            return;
        int middle = (max + min) / 2;
        mergeSort(numbers, helper, min, middle);
        mergeSort(numbers, helper, middle + 1, max);
        merge(numbers, helper, min, middle, max);
    }

    private static void merge(int[] numbers, int[] helper, int min, int middle, int max) {
        for(int i = min; i <= max; i++) {
            helper[i] = numbers[i];
        }

        int left = min;
        int right = middle + 1;
        int current = min;

        while(left <= middle && right <= max) {
            if(helper[left] <= helper[right]) {
                numbers[current] = helper[left];
                left++;
            } else {
                numbers[current] = helper[right];
                right++;
            }
            current++;
        }

        int remaining = middle - left;
        for(int i = 0; i <= remaining; i++) {
            numbers[current + i] = helper[left + i];
        }
    }
}
