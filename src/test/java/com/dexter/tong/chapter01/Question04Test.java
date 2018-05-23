package com.dexter.tong.chapter01;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question04Test {

    @Test
    public void should_be_true_when_string_is_even_palindrome() {
        assertTrue(Question04.isPalindrome("fdggdf"));
    }

    @Test
    public void should_be_true_when_string_is_odd_palindrone() {
        assertTrue(Question04.isPalindrome("tacocat"));
    }

    @Test
    public void should_be_true_when_string_is_single_character() {
        assertTrue(Question04.isPalindrome("q"));
    }

    @Test
    public void should_be_true_when_string_is_empty() {
        assertTrue(Question04.isPalindrome(""));
    }

    @Test
    public void should_be_false_when_string_is_not_palindrome() {
        assertFalse(Question04.isPalindrome("apple"));
    }

    @Test
    public void should_be_true_when_string_is_palindrome_and_has_nonletters() {
        assertTrue(Question04.isPalindrome("pan. nap"));
    }

    @Test
    public void should_be_true_when_string_is_palindrome_and_has_capitals() {
        assertTrue(Question04.isPalindrome("Pottop"));
    }
}