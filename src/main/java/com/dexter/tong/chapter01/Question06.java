package com.dexter.tong.chapter01;

public class Question06 {

    /**
     * 1.6
     * Implement a method to perform basic string compression using the counts of repeated characters. For example, the
     * string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original
     * string, your method should return the original string. You can assume the string has only uppercase and lowercase
     * letters (a - z).
     * Time: O(n)
     * Space: O(1)
     */
    public static String compressor(String str) {

        StringBuilder sb = new StringBuilder();

        if(str.length() < 1) {
            return str;
        }

        char currentLetter = str.charAt(0);
        int currentLetterReps = 0;
        for(char c : str.toCharArray()) {
            if(currentLetter == c) {
                currentLetterReps++;
            } else {
                sb.append(currentLetter);
                sb.append(currentLetterReps);
                currentLetter = c;
                currentLetterReps = 1;
            }
        }
        sb.append(currentLetter);
        sb.append(currentLetterReps);

        String compressedString = sb.toString();
        if(compressedString.length() < str.length()) {
            return compressedString;
        }
        return str;
    }
}
