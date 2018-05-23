package com.dexter.tong.chapter01;

import java.util.Collection;
import java.util.HashMap;

public class Question02 {

    /**
     * 1.2
     * Given two strings, write a method to decide if one is a permutation of the other.
     * Time: O(n)
     * Space: O(n)
     */
    public static boolean isPermutation(String a, String b) {
        // Obviously, Strings of different length cannot be perms of each other
        if(a.length() != b.length()) {
            return false;
        }

        HashMap<Character, Integer> letterCount = new HashMap<>();

        // For each letter in String a, Increment the dictionary counter
        for(int i = 0; i < a.length(); i++) {
            if(letterCount.containsKey(a.charAt(i))) {
                letterCount.put(a.charAt(i), letterCount.get(a.charAt(i)) + 1);
            } else {
                letterCount.put(a.charAt(i), 1);
            }
        }

        // For each letter in String b, Decrement the dictionary counter
        for(int i = 0; i < b.length(); i++) {
            if(letterCount.containsKey(b.charAt(i))) {
                letterCount.put(b.charAt(i), letterCount.get(b.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        Collection<Integer> values = letterCount.values();
        for(Integer count : values) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}
