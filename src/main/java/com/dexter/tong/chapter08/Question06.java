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
