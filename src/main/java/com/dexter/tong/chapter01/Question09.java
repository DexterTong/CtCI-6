package com.dexter.tong.chapter01;

public class Question09 {

    /**
     * 1.9
     * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, S1
     * and S2 write code to check if S2 is a rotation of S1 using only one call to isSubstring (e.g., "waterbottle" is
     * a rotation of "erbottlewat").
     * Time: O(m+n)
     * Space: O(m+n)
     */
    public static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return isSubstring(str1 + str1, str2);
    }

    /**
     * This is an "implementation" of the isSubstring method mentioned above. Since implementing this method is not in
     * the scope of the problem, I just used the built-in String.contains()
     */
    private static boolean isSubstring(String str, String substr) {
        return str.contains(substr);
    }
}
