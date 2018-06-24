package com.dexter.tong.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Question02 {
    /**
     * 10.2
     * Write a method to sort an array of strings so that all the anagrams are next to each other
     */
    public static String[] groupAnagrams(String[] words) {
        HashMap<String, LinkedList<String>> anagramDictionary = new HashMap<>();
        for(String word : words) {
            String key = sortCharacters(word);
            if(anagramDictionary.containsKey(key))
                anagramDictionary.get(key).add(word);
            else {
                LinkedList<String> wordList = new LinkedList<>();
                wordList.add(word);
                anagramDictionary.put(key, wordList);
            }
        }

        ArrayList<String> resultList = new ArrayList<>();

        anagramDictionary.forEach((key, wordList) -> {
            wordList.forEach(word -> {
                resultList.add(word);
            });
        });

        return resultList.toArray(new String[]{});
    }

    private static String sortCharacters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
