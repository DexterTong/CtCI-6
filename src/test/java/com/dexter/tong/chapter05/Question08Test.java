package com.dexter.tong.chapter05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question08Test {

    private byte[] expected;

    @Before
    public void initialize() {
        expected = new byte[15];
        expected[6] = (byte) 0x1F;
        expected[7] = (byte) 0xFF;
        expected[8] = (byte) 0xFE;
    }

    @Test
    public void should_draw_line() {
        byte[] screen = new byte[15];
        assertArrayEquals( expected, Question08.drawLine(screen, 5 * Byte.SIZE, 11, 31,1));
    }

}