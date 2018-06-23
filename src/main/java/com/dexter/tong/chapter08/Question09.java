package com.dexter.tong.chapter08;

import java.util.ArrayList;
import java.util.HashMap;

public class Question09 {
    /**
     * 8.9
     * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
     * of n pairs of parentheses.
     */
    public String[] parentheses(int count) {
        if(count < 1)
            throw new IllegalArgumentException("count must be positive");

        HashMap<String, ParenthesesGroup> parents = new HashMap<>();
        ParenthesesGroup initial = new ParenthesesGroup("()");
        parents.put("()", initial);

        for(int i = 2; i <= count; i++) {

            HashMap<String, ParenthesesGroup> children = new HashMap<>();

            parents.forEach((key, parent) -> {

                ParenthesesGroup childBefore = new ParenthesesGroup(parent.str);
                childBefore.insertBefore();
                children.put(childBefore.toString(), childBefore);

                ParenthesesGroup childAround = new ParenthesesGroup(parent.str);
                childAround.insertAround();
                children.put(childAround.toString(), childAround);

                ParenthesesGroup childAfter = new ParenthesesGroup(parent.str);
                childAfter.insertAfter();
                children.put(childAfter.toString(), childAfter);
            });

            parents = children;
        }

        ArrayList<String> result = new ArrayList<>(parents.size());
        parents.forEach((key, parent) -> result.add(key));
        return result.toArray(new String[]{});
    }

    private class ParenthesesGroup {
        private StringBuilder str;

        private ParenthesesGroup(CharSequence str) {
            this.str = new StringBuilder(str);
        }

        private void insertBefore() {
            str.insert(0, "()");
        }

        private void insertAround() {
            str.insert(0, '(');
            str.append(')');
        }

        private void insertAfter() {
            str.append("()");
        }

        public String toString() {
            return str.toString();
        }
    }
}
