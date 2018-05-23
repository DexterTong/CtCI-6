package com.dexter.tong.chapter01;

import java.util.HashMap;

public class Question04 {

    /**
     * 1.4
     * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or
     * phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does
     * not need to be limited to just dictionary words.
     * Time: O(n)
     * Space: O(n)
     */
    public static boolean isPalindrome(String str) {

        // sum up the occurrences of each letter into a dictionary
        HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
        for(char letter : str.toCharArray()) {
            letter = Character.toLowerCase(letter);
            if('a' <= letter && letter <= 'z' || 'A' <= letter && letter <= 'Z') {
                if(letterCount.containsKey(letter)) {
                    letterCount.put(letter, letterCount.get(letter) + 1);
                } else {
                    letterCount.put(letter, 1);
                }
            }
        }

        // since a palindrome can only have 1 letter with an odd number of occurences (the middle letter)
        // use a flag to keep track of whether we have seen one yet
        boolean encounteredOddCount = false;
        for(Integer count : letterCount.values()) {
            if(count % 2 == 1) {
                if(encounteredOddCount) {
                    return false;
                }
                else {
                    encounteredOddCount = true;
                }
            }
        }

        return true;
    }

}
