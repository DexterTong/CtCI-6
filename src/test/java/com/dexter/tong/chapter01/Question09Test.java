package com.dexter.tong.chapter01;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question09Test {

    @Test
    public void should_be_true_if_string_is_rotation() {
        assertTrue(Question09.isRotation("danquayle", "quayledan"));
    }

    @Test
    public void should_be_true_if_string_is_empty() {
        assertTrue(Question09.isRotation("", ""));
    }

    @Test
    public void should_be_false_if_string_is_not_rotation() {
        assertFalse(Question09.isRotation("potato", "tomato"));
    }

    @Test
    public void should_be_false_if_string_has_different_length() {
        assertFalse(Question09.isRotation("potato", "potatoe"));
    }
}