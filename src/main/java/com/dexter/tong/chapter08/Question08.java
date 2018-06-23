package com.dexter.tong.chapter08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Question08 {

    /**
     * 8.8
     * Write a method to compute all permutations of a string whose characters are not necessarily unique. The list of
     * permutations should not have duplicates.
     */
    public LinkedList<String> generatePermutations(String str) {
        LinkedList<Permutation> init = new LinkedList<>();
        init.add(new Permutation("", countCharacters(str)));
        LinkedList<Permutation> permutations = generatePermutations(init);

        LinkedList<String> result = new LinkedList<>();
        permutations.forEach(permutation -> result.add(permutation.permutation.toString()));
        return result;
    }

    private LinkedList<Permutation> generatePermutations(LinkedList<Permutation> parents) {

        LinkedList<Permutation> children = new LinkedList<>();
        parents.forEach(permutation -> {
            permutation.remaining.forEach( (c, i) -> {
                Permutation child = new Permutation(permutation.permutation, permutation.remaining);
                child.addToPermutation(c);
                children.add(child);
            });
        });

        if(children.size() == 0)
            return parents;
        return generatePermutations(children);
    }

    private HashMap<Character, Integer> countCharacters(String str) {

        HashMap<Character, Integer> counts =  new HashMap<>(str.length());

        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(counts.containsKey(c))
                counts.put(c, counts.get(c) + 1);
            else
                counts.put(c, 1);
        }

        return counts;
    }

    public class Permutation {
        private StringBuilder permutation;
        private HashMap<Character, Integer> remaining;

        public Permutation(CharSequence permutation, HashMap<Character, Integer> remaining) {
            this.permutation = new StringBuilder(permutation);
            this.remaining = new HashMap<>(remaining);
        }

        public void addToPermutation(Character c) {

            if(!remaining.containsKey(c))
                throw new NoSuchElementException("Character " + c.toString() + " is not available");

            int count = remaining.get(c);
            if(count < 1) {
                remaining.remove(c);
                throw new NoSuchElementException("Character " + c.toString() + " is not available");
            }

            if(count == 1)
                remaining.remove(c);
            else
                remaining.put(c, count-1);

            permutation.append(c);
        }
    }
}
