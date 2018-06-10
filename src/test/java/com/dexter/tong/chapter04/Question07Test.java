package com.dexter.tong.chapter04;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Question07Test {

    private Question07 question07;

    @Before
    public void initialize() {
        question07 = new Question07();
    }

    @Test
    public void should_return_build_orderA() {
        Character[] projectNames = {'a', 'b', 'c', 'd', 'e', 'f'};
        Character[][] dependencyList = {{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}};
        LinkedList<Character> expected = new LinkedList<>(Arrays.asList('e', 'f', 'a', 'b', 'd', 'c'));

        assertEquals(expected, question07.getBuildOrder(projectNames, dependencyList));
    }

    @Test
    public void should_return_build_orderB() {
        Character[] projectNames = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        Character[][] dependencyList = {{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'h', 'g'}, {'f', 'a'}, {'d', 'c'}, {'g', 'd'}};
        LinkedList<Character> expected = new LinkedList<>(Arrays.asList('e', 'f', 'h', 'a', 'b', 'g', 'd', 'c'));

        assertEquals(expected, question07.getBuildOrder(projectNames, dependencyList));
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_no_build_order_exists() {
        Character[] projectNames = {'a', 'b', 'c', 'd', 'e', 'f'};
        Character[][] dependencyList = {{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}, {'c', 'b'}};

        question07.getBuildOrder(projectNames, dependencyList);
    }
}