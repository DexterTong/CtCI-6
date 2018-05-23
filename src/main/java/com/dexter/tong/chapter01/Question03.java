package com.dexter.tong.chapter01;

import java.util.LinkedList;

public class Question03 {

    /**
     * 1.3
     * Write a method to replace all spaces in a string with '%20: You may assume that the string has sufficient space
     * at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If
     * implementing in Java, please use a character array so that you can perform this operation in place.)
     * Time: O(n)
     * Space: O(n)
     */
    public static String urlify(char[] str) {

        LinkedList<Character> queue = new LinkedList<Character>();

        for(int i = 0; i < str.length; i++) {

            if(str[i] == ' ') {
                queue.add('%');
                queue.add('2');
                queue.add('0');
            } else {
                queue.add(str[i]);
            }

            if(!queue.isEmpty()) {
                str[i] = queue.remove();
            }
        }

        return String.valueOf(str);
    }
}
