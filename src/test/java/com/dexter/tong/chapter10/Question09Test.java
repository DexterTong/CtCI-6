package com.dexter.tong.chapter10;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Question09Test {

    private int[][] input;

    @Before
    public void initialize() {
        // Read this as a column-major matrix, i.e. input[0] is actually the 0th column
        input = new int[][]{
                {  1,  14,  22,  25,  63,  87, 100, 143},
                { 30,  31,  49,  50,  67,  99, 154, 161},
                { 57,  60,  60,  63,  72, 120, 184, 185},
                { 70, 100, 111, 111, 137, 144, 195, 200},
                {105, 119, 153, 170, 172, 180, 201, 219},
                {160, 175, 178, 179, 206, 222, 240, 261},
                {202, 204, 217, 233, 249, 278, 287, 305},
        };
    }

    @Test
    public void should_find_target_when_exists() {
        assertEquals(new Point(1,4), Question09.findInMatrix(input, 67));
    }

    @Test
    public void should_find_target_when_exists_and_duplicate() {

        assertEquals(new Point(3, 3), Question09.findInMatrix(input, 111));
    }

    @Test
    public void should_be_null_when_target_dne() {
        assertNull(Question09.findInMatrix(input, 138));
    }

    @Test
    public void should_be_null_when_target_is_out_of_bounds() {
        assertNull(Question09.findInMatrix(input, 338));
    }
}