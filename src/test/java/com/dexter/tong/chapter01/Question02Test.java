package com.dexter.tong.chapter01;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question02Test {

    @Test
    public void should_return_false_if_strings_have_different_lengths() {
        assertFalse(Question02.isPermutation("abcdef", "abcd"));
    }

    @Test
    public void should_return_false_if_strings_have_different_lengths_and_one_is_empty() {
        assertFalse(Question02.isPermutation("", "abcd"));
    }

    @Test
    public void should_return_true_if_strings_are_permutations() {
        assertTrue(Question02.isPermutation("tacocat", "catocat"));
    }

    @Test
    public void should_return_false_if_strings_are_not_permutations() {
        assertFalse(Question02.isPermutation("maple", "plane"));
    }
}