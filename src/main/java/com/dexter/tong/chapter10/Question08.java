package com.dexter.tong.chapter10;

import java.util.ArrayList;
import java.util.BitSet;

public class Question08 {
    /**
     * You have an array with all the numbers from 1 to N, where N is at most 32,000. The
     * array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory
     * available, how would you print all duplicate elements in the array?
     */
    /*
    In order to make this method more testable, we return an array of the duplicate integers. To make a solution
    that is fully compliant with the above problem statement, we would not store the dups at all; they would only be
    printed to stdout. Apart from this, the algorithm is exactly the same either way.
     */
    private static final int MAX_VALUE = 32000;

    public static Integer[] findDuplicates(int[] numbers) {
        // This takes up 32,000b, or about 3.9kB
        BitSet flags = new BitSet(MAX_VALUE);

        // This is only here to make the code more testable. Otherwise we'd just print the dups and not save them.
        ArrayList<Integer> duplicates = new ArrayList<>();

        for(int n : numbers) {
            if(flags.get(n - 1))
                duplicates.add(n);
            else
                flags.set(n - 1);
        }
        return duplicates.toArray(new Integer[]{});
    }
}
