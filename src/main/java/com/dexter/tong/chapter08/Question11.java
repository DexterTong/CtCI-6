package com.dexter.tong.chapter08;

import java.util.LinkedList;

public class Question11 {
    /**
     * 8.11
     * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
     * pennies (1 cent), write code to calculate the number of ways of representing n cents.
     */
    public int waysToHaveCents(int cents) {

        if(cents < 0)
            throw new IllegalArgumentException("cents must be a non-negative number");
        if(cents == 0)
            return 1;

        LinkedList<Coinpurse> parents = new LinkedList<>();
        parents.add(new Coinpurse());

        parents = addCoins(Coinpurse.QUARTER, parents, cents);
        parents = addCoins(Coinpurse.DIME, parents, cents);
        parents = addCoins(Coinpurse.NICKEL, parents, cents);
        //parents = addCoins(Coinpurse.PENNY, parents, cents);

        return parents.size();
    }

    private LinkedList<Coinpurse> addCoins(int COIN, LinkedList<Coinpurse> parents, int target) {

        LinkedList<Coinpurse> children = new LinkedList<>();

        parents.forEach(parent -> {
            int maxToAdd = (target - parent.value) / COIN;
            for(int i = 0; i <= maxToAdd; i++) {
                Coinpurse child = new Coinpurse(parent);
                child.addCoins(i, COIN);
                children.add(child);
            }
        });

        return children;
    }

    private class Coinpurse {

        final static int QUARTER = 25;
        final static int DIME = 10;
        final static int NICKEL = 5;
        final static int PENNY = 1;

        private int quarters;
        private int dimes;
        private int nickels;
        private int pennies;

        private int value;

        private Coinpurse() {
            this(0, 0, 0, 0);
        }

        private Coinpurse(int quarters, int dimes, int nickels, int pennies) {
            this.quarters = quarters;
            this.dimes = dimes;
            this.nickels = nickels;
            this.pennies = pennies;
            updateValue();
        }

        private Coinpurse(Coinpurse cp) {
            this.quarters = cp.quarters;
            this.dimes = cp.dimes;
            this.nickels = cp.nickels;
            this.pennies = cp.pennies;
            this.value = cp.value;
        }

        private void addCoins(int count, int COIN) {
            switch(COIN) {
                case QUARTER:
                    addQuarters(count);
                    break;
                case DIME:
                    addDimes(count);
                    break;
                case NICKEL:
                    addNickels(count);
                    break;
                case PENNY:
                    addPennies(count);
                    break;
                default:
                    throw new IllegalArgumentException("COIN should be one of the coin constants");
            }
        }

        private void addQuarters(int count) {
            quarters += count;
            value += count * QUARTER;
        }

        private void addDimes(int count) {
            dimes += count;
            value += count * DIME;
        }

        private void addNickels(int count) {
            nickels += count;
            value += count * NICKEL;
        }

        private void addPennies(int count) {
            pennies += count;
            value += count * PENNY;
        }

        private void updateValue() {
            value = quarters * QUARTER
                    + dimes * DIME
                    + nickels * NICKEL
                    + pennies * PENNY;
        }

        @Override
        public String toString() {
            return String.format("{Q: %d},{D: %d},{N: %d},{P: %d}", quarters, dimes, nickels, pennies);
        }
    }
}
