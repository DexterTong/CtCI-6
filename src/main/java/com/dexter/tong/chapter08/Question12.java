package com.dexter.tong.chapter08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Question12 {

    final static int BOARD_SIZE = 8;

    /**
     * 8.12
     * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board
     * so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all
     * diagonals, not just the two that bisect the board.
     */
    /*
    There are 64!/(56!*8!), or 64C8 possible arrangements, in a pure brute force method. Clearly, that is a bad idea.
    We can do better, noting that for any row, there will be exactly 1 queen.
    So if instead, for each row, we place just 1 queen, we have 8^8 arrangements to try. Still too many.
    We note that for any row, and for any column, there will be exactly 1 queen.
    So we can put queen 1 anywhere in row 1. Queen 2 can be put anywhere in row 2, except for the column occupied by queen 1
    Etc, giving us 8! arrangements to test. This is manageable.
    In fact, we can generate the possible arrangements from all possible permutations of 0, 1, ..., 7

    I also don't want to actually print out all of the solutions, so I count them instead
     */
    public int eightQueens() {

        LinkedList<Integer[]> permutations = generatePermutations();
        int count = 0;

        for(Integer[] p : permutations) {
            if(checkArrangement(p))
                count++;
        }

        return count;
    }

    private boolean checkArrangement(Integer[] permutation) {
        for(int i = 0; i < permutation.length - 1; i++) {
            if(!checkDiagonal(i, permutation))
                return false;
        }

        return true;
    }

    private boolean checkDiagonal(int startRow, Integer[] permutation) {
        int startCol = permutation[startRow];

        for(int i = 1; i < permutation.length - startRow && i < BOARD_SIZE - startCol; i++) {
            if(permutation[i + startRow] == startCol + i)
                return false;
        }

        for(int i = 1; i < permutation.length - startRow && i <= startCol; i++) {
            if(permutation[i + startRow] == startCol - i)
                return false;
        }

        return true;
    }

    private LinkedList<Integer[]> generatePermutations() {
        ArrayList<Integer> initRemaining = new ArrayList<Integer>();
        IntStream.range(0, BOARD_SIZE).forEach(initRemaining::add);  //Equivalent to i -> init.add(i)
        Permutation initial = new Permutation(new ArrayList<>(), initRemaining);

        LinkedList<Permutation> parents = new LinkedList<>();
        parents.add(initial);

        LinkedList<Permutation> permutations = generatePermutations(parents);
        LinkedList<Integer[]> result = new LinkedList<>();
        permutations.forEach(p -> result.add(p.permutation.toArray(new Integer[]{})));
        return result;
    }

    private LinkedList<Permutation> generatePermutations(LinkedList<Permutation> parents) {

        while(true) {
            LinkedList<Permutation> children = new LinkedList<>();
            parents.forEach(parent -> {
                for (int i = 0; i < parent.remaining.size(); i++) {
                    Permutation child = new Permutation(parent.permutation, parent.remaining);
                    child.permutation.add(child.remaining.remove(i));
                    children.add(child);
                }
            });

            if (children.size() == 0)
                return parents;
            parents = children;
        }
    }

    private class Permutation {
        private ArrayList<Integer> permutation;
        private ArrayList<Integer> remaining;

        private Permutation(ArrayList<Integer> permutation, ArrayList<Integer> remaining) {
            this.permutation = new ArrayList<>(permutation);
            this.remaining = new ArrayList<>(remaining);
        }

        public String toString() {
            return String.format("p: %s\tr: %s", permutation.toString(), remaining.toString());
        }
    }
}
