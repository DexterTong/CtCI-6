package com.dexter.tong.chapter08;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question01Test {

    @Test
    public void should_be_13_when_5_steps() {
        assertEquals(13, Question01.waysToHop(5));
    }

    @Test
    public void should_be_1_when_1_step() {
        assertEquals(1, Question01.waysToHop(1));
    }
}