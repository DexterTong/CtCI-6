package com.dexter.tong.chapter01;

import java.util.HashMap;

public class Question05 {

    /**
     * 1.5 [Modified for int arrays instead]
     * There are three types of edits that can be performed on strings: insert a character, remove a character, or
     * replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
     * Time: O(n)
     * Space: O(n)
     */
    public static boolean oneAway(int[] a, int[] b) {
        HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();

        for(int x : a) {
            if(lookup.containsKey(x)) {
                lookup.put(x, lookup.get(x) + 1);
            } else {
                lookup.put(x, 1);
            }
        }

        for(int x : b) {
            if(lookup.containsKey(x)) {
                lookup.put(x, lookup.get(x) - 1);
            } else {
                lookup.put(x, -1);
            }
        }

        // whether we have found a number only in a, or only in b, respectively
        boolean aExclusive = false;
        boolean bExclusive = false;

        for(int count : lookup.values()) {
            // i.e. if one array has 2+ extra occurences of a number that the other doesn't
            if(Math.abs(count) > 1) {
                return false;
            }

            if(count == -1) {
                if(bExclusive) {
                    return false;
                }
                bExclusive = true;
            }

            if(count == 1) {
                if(aExclusive) {
                    return false;
                }
                aExclusive = true;
            }
        }

        return true;
    }
}
