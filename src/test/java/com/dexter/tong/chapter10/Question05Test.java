package com.dexter.tong.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question05Test {

    @Test
    public void should_find_string_when_exists() {
        String[] input = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        assertEquals(4, Question05.sparseSearch("ball", input));
    }

    @Test
    public void should_return_neg_1_when_dne() {
        String[] input = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        assertEquals(-1, Question05.sparseSearch("flop", input));
    }

}