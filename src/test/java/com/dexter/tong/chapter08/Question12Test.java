package com.dexter.tong.chapter08;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question12Test {

    private Question12 question12;

    @Before
    public void initialize() {
        question12 = new Question12();
    }

    @Test
    public void should_be_92_when_board_size_is_8() {
        assertEquals(92, question12.eightQueens());
    }

}