package com.dexter.tong.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question10Test {

    @Test
    public void test_ranked_int_store() {
        RankedIntStore store = new RankedIntStore();
        int[] numbers = new int[]{5, 1, 4, 4, 5, 9, 7, 13, 3};
        for(int n : numbers) {
            store.track(n);
        }

        assertEquals(0, store.getRankOfNumber(1));
        assertEquals(1, store.getRankOfNumber(3));
        assertEquals(3, store.getRankOfNumber(4));
    }

}