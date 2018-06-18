package com.dexter.tong.chapter06;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question09Test {

    @Test
    public void should_be_10_when_100_lockers() {
        assertEquals(10, Question09.howManyLockersOpen(100));
    }

}