package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

import java.util.Iterator;
import java.util.LinkedList;

public class Question09 {

    /**
     * 4.9
     * A binary search tree was created by traversing through an array from left to right
     * and inserting each element. Given a binary search tree with distinct elements, print all possible
     * arrays that could have led to this tree.
     */
    public static void generateInsertionSequences(BinaryTreeNode<Integer> root) {

        LinkedList<Integer> sequence = new LinkedList<>();
        LinkedList<BinaryTreeNode<Integer>> roots = new LinkedList<>();
        roots.add(root);

        generateInsertionSequences(sequence, roots);
    }

    private static void generateInsertionSequences(LinkedList<Integer> sequence, LinkedList<BinaryTreeNode<Integer>> roots) {

        if(roots.size() < 1) {
            System.out.println(sequenceToString(sequence));
            return;
        }

        for(BinaryTreeNode<Integer> root : roots) {
            LinkedList<BinaryTreeNode<Integer>> childRoots = (LinkedList<BinaryTreeNode<Integer>>) roots.clone();
            LinkedList<Integer> childSequence = (LinkedList<Integer>) sequence.clone();
            childRoots.remove(root);
            if(root.left != null)
                childRoots.add(root.left);
            if(root.right != null)
                childRoots.add(root.right);
            childSequence.add(root.data);
            generateInsertionSequences(childSequence, childRoots);
        }
    }

    private static String sequenceToString(LinkedList<Integer> sequence) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator iterator = sequence.iterator();
        if(iterator.hasNext()) {
            stringBuilder.append(" ");
            stringBuilder.append(iterator.next());
        }
        while(iterator.hasNext()) {
            stringBuilder.append(", ");
            stringBuilder.append(iterator.next());
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
