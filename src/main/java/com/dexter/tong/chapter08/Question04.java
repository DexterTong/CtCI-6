package com.dexter.tong.chapter08;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question04 {
    /**
     * 8.4
     * Write a method to return all subsets of a set.
     */
    /*
    We use lists instead of sets to get a well-defined ordering of the elements
    Conceptually, we can use lists and sets interchangeably here, as long as we do not violate the uniqueness of
    each element in the "set." Also, the lack of well-ordering in a java set makes the coding unecessarily complex
    There are 2^n possible subsets of an n-element set
     */
    public static LinkedList<LinkedList<Integer>> powerSet(LinkedList<Integer> set) {
        return powerSet(new LinkedList<>(), 0, set);
    }

    private static LinkedList<LinkedList<Integer>> powerSet(LinkedList<Integer> prefix, int index, LinkedList<Integer> set) {

        LinkedList<LinkedList<Integer>> subsets = new LinkedList<>();

        if(index >= set.size()) {
            subsets.add(prefix);
            return subsets;
        }

        LinkedList<Integer> subset = new LinkedList<>(prefix);
        subsets.addAll(powerSet(subset, index+1, set));
        subset.add(set.get(index));
        subsets.addAll(powerSet(subset, index+1, set));

        return subsets;
    }
}
