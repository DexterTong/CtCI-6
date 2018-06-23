package com.dexter.tong.chapter08;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Question04Test {

    @Test
    public void should_return_power_set_of_a_set() {
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(9, 6, 7, 3, 5));
        assertEquals(32, Question04.powerSet(input).size());
    }
}