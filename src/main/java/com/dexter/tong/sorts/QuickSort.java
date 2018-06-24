package com.dexter.tong.sorts;

public class QuickSort {

    public static int[] sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    private static void quickSort(int[] numbers, int min, int max) {
        int partition = partition(numbers, min, max);
        if(min < partition - 1) {
            quickSort(numbers, min, partition - 1);
        }
        if(max > partition) {
            quickSort(numbers, partition, max);
        }
    }

    private static int partition(int[] numbers, int left, int right) {
        int pivot = findPivot(numbers, left, right);
        while(left <= right) {
            while(numbers[left] < pivot) {
                left++;
            }
            while(numbers[right] > pivot) {
                right--;
            }

            if(left <= right) {
                utils.swap(left, right, numbers);
                left++;
                right--;
            }
        }
        return left;
    }

    private static int findPivot(int[] numbers, int min, int max) {
        // Use the middle number as the pivot
        // Another popular choice is to select the median of a few randomly picked indices
        return numbers[(min + max) / 2];
    }
}
