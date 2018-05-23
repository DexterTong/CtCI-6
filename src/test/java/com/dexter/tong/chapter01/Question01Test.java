package com.dexter.tong.chapter01;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Question01Test {

    @Test
    public void should_return_true_if_string_is_empty_A() {
        assertTrue(Question01.isUniqueA(""));
    }

    @Test
    public void should_return_true_if_string_only_has_unique_characters_A() {
        assertTrue(Question01.isUniqueA("uncopyrightable"));
    }

    @Test
    public void should_return_true_if_string_has_repeating_characters_A() {
        assertFalse(Question01.isUniqueA("tangerine"));
    }

    @Test
    public void should_return_true_if_string_is_empty_B() {
        assertTrue(Question01.isUniqueB(""));
    }

    @Test
    public void should_return_true_if_string_only_has_unique_characters_B() {
        assertTrue(Question01.isUniqueB("uncopyrightable"));
    }

    @Test
    public void should_return_true_if_string_has_repeating_characters_B() {
        assertFalse(Question01.isUniqueB("tangerine"));
    }
}