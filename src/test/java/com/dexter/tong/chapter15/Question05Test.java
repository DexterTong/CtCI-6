package com.dexter.tong.chapter15;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Question05Test {

    private Question05 question05;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    //@Before
    public void initialize() {
        question05 = new Question05();
        System.setOut(new PrintStream(outputStream));
    }

    //@Test
    public void should_call_first_second_third_in_order() {
        question05.run();
        String[] expected = new String[] {
                "Foo.first() called",
                "Foo.second() called",
                "Foo.third() called"
        };
        assertArrayEquals(expected, outputStream.toString().split("\n"));
    }

}