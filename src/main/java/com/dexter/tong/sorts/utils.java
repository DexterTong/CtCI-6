package com.dexter.tong.sorts;

public class utils {

    public static void swap(int indexA, int indexB, int[] numbers) {
        if(indexA < 0 || indexA >= numbers.length)
            throw new IllegalArgumentException("indexA out of range");
        if(indexB < 0 || indexB >= numbers.length)
            throw new IllegalArgumentException("indexB out of range");

        if(indexA == indexB)
            return;

        int temp = numbers[indexA];
        numbers[indexA] = numbers[indexB];
        numbers[indexB] = temp;
    }
}
