package com.dexter.tong.chapter08;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question06 {
    /**
     * 8.6
     * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
     * different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
     * of size from top to bottom (Le., each disk sits on top of an even larger one). You have the following
     * constraints:
     * (1) Only one disk can be moved at a time.
     * (2) A disk is slid off the top of one tower onto another tower.
     * (3) A disk cannot be placed on top of a smaller disk.
     * Write a program to move the disks from the first tower to the last using stacks.
     */
    public static ArrayList<LinkedList<Integer>> towerOfHanoi(ArrayList<LinkedList<Integer>> towers) {
        int disk = towers.get(0).size();
        towerOfHanoi(disk,0, 2, towers);
        return towers;
    }

    private static void towerOfHanoi(int disk, int src, int dest, ArrayList<LinkedList<Integer>> towers) {

        if(disk < 1)
            return;
        int staging = 3 - (src + dest);

        towerOfHanoi(disk-1, src, staging, towers);
        towers.get(dest).push(towers.get(src).pop());
        towerOfHanoi(disk-1, staging, dest, towers);
    }
    /*
    To move n disks from tower 0 to tower 2, we must do:
        1. Move disks 1 to n-1 from tower 0 to tower 1
        2. Move disk n from tower 0 to tower 2
        3. Move disks 1 to n-1 from tower 1 to tower 2
    Note that step 1 is solving the towers of Hanoi for n-1 disks, except we move the tower to tower 1 instead of tower 2
    Likewise, step 3 is solving it for n-1 disks, except we move from tower 1 (instead of tower 0)
    This gives us a natural recursive solution where we keep reducing the problem until it is trivial (where n == 1)
    We just need to make sure that the source, "staging", and destination towers are shuffled correctly
     */



    public static ArrayList<LinkedList<Integer>> initializeTowers(int size, int dest) {
        final int towerCount = 3;
        ArrayList<LinkedList<Integer>> towers = new ArrayList<>(towerCount);
        for(int i = 0; i < towerCount; i++)
            towers.add(new LinkedList<>());
        LinkedList<Integer> towerToInit = towers.get(dest);
        for(Integer i = 1; i <= size; i++)
            towerToInit.add(i);
        return towers;
    }
}
