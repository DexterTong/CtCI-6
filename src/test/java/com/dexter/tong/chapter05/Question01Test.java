package com.dexter.tong.chapter05;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question01Test {

    @Test
    public void should_insert_smaller_number_into_bigger_numberA() {
        int dest = 0b10000000000;
        int source = 0b10011;
        int expected = 0b10001001100;
        assertEquals(expected, Question01.insertInto(source, dest, 6, 2));
    }

    @Test
    public void should_insert_smaller_number_into_bigger_numberB() {
        int dest = 0b10000011110;
        int source = 0b10011;
        int expected = 0b10001001110;
        assertEquals(expected, Question01.insertInto(source, dest, 6, 2));
    }
}