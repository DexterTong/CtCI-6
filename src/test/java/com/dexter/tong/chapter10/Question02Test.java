package com.dexter.tong.chapter10;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Question02Test {

    @Test
    public void should_group_strings_by_anagram() {
        String[] input = new String[]{"dad", "cat", "add", "pot", "eel", "top", "ele", "lee", "moo", "zoo"};
        String[] expected = new String[]{"dad", "add", "pot", "top", "cat", "zoo", "moo", "eel", "ele", "lee"};
        assertArrayEquals(expected, Question02.groupAnagrams(input));
    }

}