package com.dexter.tong.chapter16;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question02Test {

    private Question02 question02;

    @Before
    public void initialize() {
        String text = "here is a collection of words there are twenty words here they are lowercase so it is easy " +
                "to use";
        String[] book = text.split("\\s");
        question02 = new Question02(book);
    }

    @Test
    public void should_return_frequency_of_word() {
        assertEquals(0.1, question02.getFrequency("are"), 0.0001);
    }
}