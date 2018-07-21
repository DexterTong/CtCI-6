package com.dexter.tong.common;

import com.dexter.tong.sorts.utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] nodes;
    private int size;

    public MinHeap() {
        this(1000);
    }

    public MinHeap(int capacity) {
        size = 0;
        nodes = new int[capacity];
    }


    public int getMin() {
        if(size <= 0)
            throw new NoSuchElementException();
        return nodes[0];
    }

    public int extractMin() {
        if(size <= 0)
            throw new NoSuchElementException();

        int min = nodes[0];
        size--;

        if(size == 1)
            return min;

        nodes[0] = nodes[size - 1];
        minHeapify(0);

        return min;
    }

    public void insert(int value) {
        if(size >= nodes.length)
            throw new RuntimeException("Heap is full.");
        size++;
        int i = size - 1;
        nodes[i] = value;

        while(i != 0 && nodes[parent(i)] > nodes[i]) {
            utils.swap(parent(i), i, nodes);
            i = parent(i);
        }
    }

    public int delete(int i) {
        decrease(i, Integer.MIN_VALUE);
        return extractMin();
    }

    public void decrease(int i, int value) {
        nodes[i] = value;
        while(i != 0 && nodes[parent(i)] > nodes[i]) {
            utils.swap(parent(i), i, nodes);
            i = parent(i);
        }
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int min = i;
        if(left < size && nodes[left] < nodes[i])
            min = left;
        if(right < size && nodes[right] < nodes[min])
            min = right;
        if(min != i) {
            utils.swap(i, min, nodes);
            minHeapify(min);
        }
    }

    public int[] toArray() {
        return Arrays.copyOf(nodes, size);
    }
}
