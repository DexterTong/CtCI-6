package com.dexter.tong.chapter05;

public class Question02 {

    /**
     * 5.2
     * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
     * the binary representation. If the number cannot be represented accurately in binary with at most 32
     * characters, print "ERROR."
     */
    public static String binaryToString(double num) {
        if(num > 1 || num < 0)
            return "ERROR.";

        StringBuilder result = new StringBuilder();

        double remaining = num;
        double subtrahend = 0.5;

        for(int i = 0; i < 32; i++) {

            double temp = remaining - subtrahend;
            if(temp >= 0) {
                remaining = temp;
                result.append('1');
            } else {
                result.append('0');
            }

            subtrahend /= 2;
        }

        if(remaining != 0)
            return "ERROR.";
        return result.toString();
    }
}
