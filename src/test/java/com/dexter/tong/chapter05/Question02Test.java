package com.dexter.tong.chapter05;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question02Test {

    @Test
    public void should_print_result_when_number_is_decimalA() {
        assertEquals("11000000000000000000000000000000", Question02.binaryToString(0.75));
    }

    @Test
    public void should_print_result_when_number_is_decimalB() {
        assertEquals("00000001000000000000000000000000", Question02.binaryToString(0.00390625));
    }

    @Test
    public void should_print_error_when_number_is_not_representable() {
        assertEquals("ERROR.", Question02.binaryToString(0.12131));
    }

    @Test
    public void should_print_result_when_number_is_0() {
        assertEquals("00000000000000000000000000000000", Question02.binaryToString(0));
    }

    @Test
    public void should_print_error_when_number_is_1() {
        assertEquals("ERROR.", Question02.binaryToString(1));
    }
}