package com.dexter.tong.chapter08;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question11Test {

    private Question11 question11;

    @Before
    public void initialize() {
        question11 = new Question11();
    }

    @Test
    public void should_be_4_when_10_cents() {
        assertEquals(4, question11.waysToHaveCents(10));
    }

    @Test
    public void should_be_1_when_4_cents() {
        assertEquals(1, question11.waysToHaveCents(4));
    }

    @Test
    public void should_be_13_when_25_cents() {
        assertEquals(13, question11.waysToHaveCents(26));
    }

}