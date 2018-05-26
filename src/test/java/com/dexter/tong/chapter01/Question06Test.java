package com.dexter.tong.chapter01;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question06Test {

    @Test
    public void should_compress_string_if_compression_is_shorter() {
        String input = "aabcccccaaa";
        String expected = "a2b1c5a3";
        assertEquals(expected, Question06.compressor(input));
    }

    @Test
    public void should_not_compress_string_if_compression_is_longer() {
        String input = "qwertyy";
        String expected = "qwertyy";
        assertEquals(expected, Question06.compressor(input));
    }
}