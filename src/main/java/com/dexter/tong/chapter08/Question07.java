package com.dexter.tong.chapter08;

import java.util.LinkedList;

public class Question07 {

    /**
     * 8.7
     * Write a method to compute all permutations of a string of unique characters.
     */
    public LinkedList<String> generatePermutations(String str) {
        LinkedList<Permutation> init = new LinkedList<>();
        init.add(new Permutation("", str));
        LinkedList<Permutation> permutations = generatePermutations(init);

        LinkedList<String> result = new LinkedList<>();
        permutations.forEach(permutation -> result.add(permutation.permutation.toString()));
        return result;
    }

    private LinkedList<Permutation> generatePermutations(LinkedList<Permutation> parents) {

        LinkedList<Permutation> children = new LinkedList<>();
        for(Permutation permutation : parents) {
            for(int i = 0; i < permutation.remaining.length(); i++) {
                StringBuilder p = new StringBuilder(permutation.permutation);
                StringBuilder r = new StringBuilder(permutation.remaining);
                p.append(r.charAt(i));
                r.deleteCharAt(i);
                children.add(new Permutation(p.toString(), r.toString()));
            }
        }

        if(children.size() == 0)
            return parents;
        return generatePermutations(children);
    }

    public class Permutation {
        private StringBuilder permutation;
        private StringBuilder remaining;

        public Permutation(String permutation, String remaining) {
            this.permutation = new StringBuilder(permutation);
            this.remaining = new StringBuilder(remaining);
        }

        public String toString() {
            return String.format("p: %s\tr: %s", permutation.toString(), remaining.toString());
        }
    }
}
