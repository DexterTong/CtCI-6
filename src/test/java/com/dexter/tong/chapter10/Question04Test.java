package com.dexter.tong.chapter10;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question04Test {

    Question04 question04;

    @Before
    public void initialize() {
        question04 = new Question04();
    }

    @Test
    public void should_return_neg_1_when_element_dne() {
        Question04.Listy input = question04.createListy(new int[]{1, 1, 1, 2, 3, 4, 5, 5, 7, 7, 8, 9});
        assertEquals(-1, Question04.findInListy(6, input));
    }

    @Test
    public void should_return_index_when_element_exists() {
        Question04.Listy input = question04.createListy(new int[]{1, 1, 1, 2, 3, 4, 5, 6, 7, 7, 8, 9});
        assertEquals(4, Question04.findInListy(3, input));
    }

}