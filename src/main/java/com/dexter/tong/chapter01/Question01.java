package com.dexter.tong.chapter01;

import java.util.HashSet;

public class Question01 {

    /**
     * 1.1a
     * Implement an algorithm to determine if a string has all unique characters.
     * Time: O(n)
     * Space: O(n)
     */
    public static boolean isUniqueA(String str) {
        // Keep track of characters already found in string with a HashSet
        HashSet<Character> letters = new HashSet<Character>(str.length());
        for(int i = 0; i < str.length(); i++) {
            if(letters.contains((Character) str.charAt(i))) {
                return false;
            } else {
                letters.add((Character) str.charAt(i));
            }
        }
        return true;
    }

    /**
     * 1.1b
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     * Time: O(n^2)
     * Space: O(1)
     */
    public static boolean isUniqueB(String str) {
        // Since we cannot store any data, we will just search the remainder of the string
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.substring(i + 1).indexOf(str.charAt(i)) >= 0) {
                return false;
            }
        }
        return true;
    }
}