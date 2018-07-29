package com.dexter.tong.chapter16;

import java.util.HashMap;

public class Question02 {
    /**
     * 16.2
     * Design a method to find the frequency of occurrences of any given word in a
     * book. What if we were running this algorithm multiple times?
     */

    private HashMap<String, Integer> dictionary;
    private int wordCount;

    public Question02(String[] book) {
        dictionary = new HashMap<>();
        wordCount = 0;
        for(String word : book) {
            insert(word);
            wordCount++;
        }
    }

    private void insert(String word) {
        if(dictionary.containsKey(word))
            dictionary.put(word, dictionary.get(word) + 1);
        else
            dictionary.put(word, 1);
    }

    public double getFrequency(String word) {
        if(dictionary.containsKey(word))
            return ((double) dictionary.get(word)) / wordCount;
        else
            return 0;
    }
}
