package com.dexter.tong.chapter01;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Question01Test {

    @Test
    public void emptyStringShouldReturnTrueA() {
        assertTrue(Question01.isUniqueA(""));
    }

    @Test
    public void uniqueStringShouldReturnTrueA() {
        assertTrue(Question01.isUniqueA("uncopyrightable"));
    }

    @Test
    public void nonuniqueStringShouldReturnFalseA() {
        assertFalse(Question01.isUniqueA("tangerine"));
    }

    @Test
    public void emptyStringShouldReturnTrueB() {
        assertTrue(Question01.isUniqueB(""));
    }

    @Test
    public void uniqueStringShouldReturnTrueB() {
        assertTrue(Question01.isUniqueB("uncopyrightable"));
    }

    @Test
    public void nonuniqueStringShouldReturnFalseB() {
        assertFalse(Question01.isUniqueB("tangerine"));
    }
}