package com.dexter.tong.common;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MinHeapTest {

    private MinHeap minHeap;

    @Before
    public void initialize() {
        minHeap = new MinHeap();
    }


    @Test(expected = NoSuchElementException.class)
    public void getMin_empty_heap() {
        minHeap.getMin();
        fail("NoSuchElementException was not thrown");
    }

    @Test
    public void getMin_nonempty_heap() {
        int[] numbers = new int[]{4, 7, 3, 5, 9, 9};
        Arrays.stream(numbers).forEach(number -> minHeap.insert(number));
        assertEquals(3, minHeap.getMin());
    }

}