package com.dexter.tong.chapter05;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question04Test {

    @Test
    public void nextNumber1() {
        int[] result = Question04.nextNumber(0b01110);
        assertEquals(0b01101, result[0]);
        assertEquals(0b10011, result[1]);
    }

    @Test
    public void nextNumber2() {
        int[] result = Question04.nextNumber(0b011001);
        assertEquals(0b010110, result[0]);
        assertEquals(0b011010, result[1]);
    }

}