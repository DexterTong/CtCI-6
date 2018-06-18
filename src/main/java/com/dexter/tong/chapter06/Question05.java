package com.dexter.tong.chapter06;

public class Question05 {
    /**
     * 6.5
     * You have a five-quart jug, a three-quart jug, and an unlimited supply of water (but
     * no measuring cups). How would you come up with exactly four quarts of water? Note that the jugs
     * are oddly shaped, such that filling up exactly "half" of the jug would be impossible.
     */
    /*
        Let's call the jugs J5 and J3, for their capacities in quarts
        1. Fill up J3
        2. Pour J3 into J5
        3. Fill up J3 again
        4. Pour J3 into J5 until J5 is full. Now J3 contains 1 quart
        5. Empty J5
        6. Pour J3 into J5. Now J5 contains 1 quart
        7. Fill J3
        8. Pour J3 into J5. Now J5 contains 4 quarts
     */
}
