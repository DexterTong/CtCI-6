package com.dexter.tong.chapter08;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Question06Test {

    @Test
    public void should_move_disks_to_tower_2() {
        // We want the number of disks to be small, since the towers of Hanoi takes O(2^n) moves
        final int diskCount = 5;
        ArrayList<LinkedList<Integer>> expected = Question06.initializeTowers(diskCount, 2);
        ArrayList<LinkedList<Integer>> result = Question06.towerOfHanoi(Question06.initializeTowers(diskCount, 0));

        for(int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(i), result.get(i));
    }
}