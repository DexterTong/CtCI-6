package com.dexter.tong.chapter03;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Question05Test {

    @Test
    public void should_be_empty_when_stack_is_empty() {
        LinkedList<Integer> input = new LinkedList<>();
        LinkedList<Integer> expected = new LinkedList<>();
        Question05.sort(input);
        assertEquals(expected, input);
    }

    @Test
    public void should_be_sorted() {
        Integer[] values = new Integer[]{4, 3, 6, 7, 2, 0, 4};
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(values));
        Arrays.sort(values);
        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(values));
        Question05.sort(input);
        assertEquals(expected, input);
    }
}