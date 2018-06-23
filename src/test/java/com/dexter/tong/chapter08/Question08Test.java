package com.dexter.tong.chapter08;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question08Test {

    private Question08 question08;

    @Before
    public void initialize() {
        question08 = new Question08();
    }

    @Test
    public void should_return_permutations_of_unique_string() {
        assertEquals(120, question08.generatePermutations("abcde").size());
    }

    @Test
    public void should_return_permutations_of_duplicate_string() {
        assertEquals(840, question08.generatePermutations("aabbbbcd").size());
    }
}