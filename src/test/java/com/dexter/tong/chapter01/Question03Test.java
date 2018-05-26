package com.dexter.tong.chapter01;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Question03Test {

    @Test
    public void should_replace_when_there_is_one_space() {
        String preInput = "good day!";
        char[] input = StringToCharArray(preInput);
        String expected = preInput.replace(" ", "%20");

        assertEquals(expected, Question03.urlify(input));
    }

    @Test
    public void should_replace_when_there_are_multiple_spaces() {
        String preInput = "good day today";
        char[] input = StringToCharArray(preInput);
        String expected = preInput.replace(" ", "%20");

        assertEquals(expected, Question03.urlify(input));
    }

    @Test
    public void should_replace_when_there_are_contiguous_spaces() {
        String preInput = "four    spaces";
        char[] input = StringToCharArray(preInput);
        String expected = preInput.replace(" ", "%20");

        assertEquals(expected, Question03.urlify(input));
    }

    @Test
    public void should_be_equal_when_there_are_no_spaces() {
        String preInput = "selamat";
        char[] input = StringToCharArray(preInput);
        String expected = preInput.replace(" ", "%20");

        assertEquals(expected, Question03.urlify(input));
    }

    private char[] StringToCharArray(String str) {

        int spaceCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ')
                spaceCount++;
        }

        char[] strArray = str.toCharArray();
        int finalLength = strArray.length + spaceCount * 2;

        return Arrays.copyOf(strArray, finalLength);
    }
}