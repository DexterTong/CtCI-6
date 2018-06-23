package com.dexter.tong.chapter08;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question03Test {

    @Test
    public void test_distinctMagicIndex_when_magic_index_exists(){
        int[] input = new int[]{-10, -9, -8, 3, 4, 5, 7};
        assertEquals(3, Question03.distinctMagicIndex(input));
    }

    @Test
    public void test_distinctMagicIndex_when_magic_index_dne(){
        int[] input = new int[]{-10, -9, -8, 1, 2, 3, 7};
        assertEquals(-1, Question03.distinctMagicIndex(input));
    }

    @Test
    public void test_distinctMagicIndex_when_skip_ahead(){
        int[] input = new int[]{-1, 0, 1, 4, 5, 6};
        assertEquals(-1, Question03.distinctMagicIndex(input));
    }

    @Test
    public void test_indistinctMagicIndex_when_magic_index_exists(){
        int[] input = new int[]{-10, -9, -8, 3, 4, 5, 7};
        assertEquals(3, Question03.indistinctMagicIndex(input));
    }

    @Test
    public void test_indistinctMagicIndex_when_magic_index_dne(){
        int[] input = new int[]{-10, -9, -8, 1, 2, 3, 7};
        assertEquals(-1, Question03.indistinctMagicIndex(input));
    }

    @Test
    public void test_indistinctMagicIndex_when_skip_ahead(){
        int[] input = new int[]{-1, 0, 1, 4, 5, 6};
        assertEquals(-1, Question03.indistinctMagicIndex(input));
    }

    @Test
    public void test_indistinctMagicIndex_when_duplicates(){
        int[] input = new int[]{-1, 0, 4, 4, 4, 6};
        assertEquals(4, Question03.indistinctMagicIndex(input));
    }
}