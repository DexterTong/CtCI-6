package com.dexter.tong.chapter05;

public class Question08 {

    /**
     * 5.8
     * A monochrome screen is stored as a single array of bytes, allowing eight consecutive
     * pixels to be stored in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will
     * be split across rows). The height of the screen, of course, can be derived from the length of the array
     * and t he width. Implement a function that draws a horizontal line from (xl, y) to (x2, y) .
     */
    public static byte[] drawLine(byte[] screen, int width, int x1, int x2, int y) {

        if(width % Byte.SIZE != 0 || width < 0)
            throw new IllegalArgumentException("width must be gte 0, and be a multiple of 8");

        int height = screen.length * Byte.SIZE / width;
        if(y > height || y < 0)
            throw new IllegalArgumentException("y must be between 0 and height, inclusive");

        if(x2 < x1) {
            int temp = x2;
            x2 = x1;
            x1 = temp;
        }

        if( x1 < 0 || x2 > width)
            throw new IllegalArgumentException("x1, x2 must be between 0 and width, inclusive");

        int x1Byte = x1 / Byte.SIZE;
        int x2Byte = x2 / Byte.SIZE;

        for(int i = x1Byte + 1; i < x2Byte; i++)
            screen[i + y * width / Byte.SIZE] = (byte) 0xFF;

        int x1ByteValue = -1;
        for(int i = 0; i < Byte.SIZE - (x1 % Byte.SIZE); i++)
            x1ByteValue = x1ByteValue << 1;
        x1ByteValue = ~x1ByteValue;
        screen[x1Byte + y * width / Byte.SIZE] = (byte) x1ByteValue;

        int x2ByteValue = -1;
        for(int i = 0; i < Byte.SIZE - x2 % Byte.SIZE; i++)
            x2ByteValue = x2ByteValue << 1;
        screen[x2Byte + y * width / Byte.SIZE] = (byte) x2ByteValue;

        return screen;
    }
}
