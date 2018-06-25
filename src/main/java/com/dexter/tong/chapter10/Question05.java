package com.dexter.tong.chapter10;

public class Question05 {
    /**
     * 10.5
     * Given a sorted array of strings that is interspersed with empty strings, write a
     * method to find the location of a given string.
     */
    public static int sparseSearch(String value, String[] words) {
        int min = 0;
        int max = words.length - 1;

        while(words[min].equals("")) {
            min++;
        }
        while(words[max].equals("")) {
            max--;
        }
        return sparseSearch(value, words, min, max);
    }

    private static int sparseSearch(String value, String[] words, int min, int max) {
        if(min > max)
            return -1;

        int middle = (min + max) / 2;
        while(words[middle].equals("")) {
            middle--;
        }
        if(words[middle].equals(value))
            return middle;

        if(words[middle].compareTo(value) < 0) {
            int nextMin = middle + 1;
            while(words[nextMin].equals("")) {
                nextMin++;
                if(nextMin >= words.length)
                    return -1;
            }
            return sparseSearch(value, words, nextMin, max);
        }
        int nextMax = middle - 1;
        while(words[nextMax].equals("")) {
            nextMax--;
            if(nextMax < 0)
                return -1;
        }
        return sparseSearch(value, words, min, nextMax);
    }
}
