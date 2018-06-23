package com.dexter.tong.chapter08;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question07Test {

    private Question07 question07;

    @Before
    public void initialize() {
        question07 = new Question07();
    }

    @Test
    public void should_return_permutations_of_unique_string() {
        assertEquals(120, question07.generatePermutations("abcde").size());
    }

}