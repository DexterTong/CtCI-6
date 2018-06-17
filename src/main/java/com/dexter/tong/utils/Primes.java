package com.dexter.tong.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Primes {

    /**
     * Generates an int array containing all of the primes between 0 and max, sorted in increasing order
     * @param max The value for which all of the generated primes should be less than or equal to.
     * @return An array of all the primes in the range [0, max]
     */
    public static int[] getPrimes(int max) {
        if(max < 0)
            throw new IllegalArgumentException("max must be greater than or equal to 0");
        if(max < 2)
            return new int[]{};

        /*
        Whether or not a particular odd integer is prime.
        For any int i in [0, flags.length), flags[i] corresponds to 2*i+1
        For example, flags[0] corresponds to 3, and flags[flags.length-1] corresponds to max, or max-1 depending on arity
        Since 2 is the only even prime, we will handle it statically to save space and time
         */
        boolean[] flags = new boolean[(max - 1) / 2];

        int rootOfMaxIndex = ((int) Math.sqrt(max)) / 2 - 1;
        for(int i = 0; i <= rootOfMaxIndex; i++) {
            if(!flags[i])
                markMultiples(flags, i);
        }

        // Find all the unflagged (prime) ints
        LinkedList<Integer> primesList = new LinkedList<>();
        primesList.add(2);

        for(int i = 0; i < flags.length; i++) {
            if(!flags[i])
                primesList.add(2 * (i+1) + 1);
        }

        return listToIntArray(primesList);
    }

    private static void markMultiples(boolean[] flags, int primeIndex) {
        int prime = (primeIndex+1) * 2 + 1;
        int primeMultiple = prime * prime;
        while(primeMultiple <= flags.length * 2 + 1) {
            flags[primeMultiple / 2 - 1] = true;
            primeMultiple += prime + prime;
        }
    }

    private static int[] listToIntArray(List<Integer> integers) {
        int[] ints = new int[integers.size()];
        Iterator iterator = integers.iterator();
        for(int i = 0; i < ints.length; i++) {
            ints[i] = (int) iterator.next();
        }

        return ints;
    }

}
