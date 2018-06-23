package com.dexter.tong.chapter08;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question09Test {

    private Question09 question09;

    @Before
    public void initialize() {
        question09 = new Question09();
    }

    @Test
    public void should_return_5_ways_to_combine_3_parentheses() {
        assertEquals(5, question09.parentheses(3).length);
    }

}