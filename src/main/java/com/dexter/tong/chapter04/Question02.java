package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

public class Question02 {

    /**
     * 4.2
     * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary
     * search tree with minimal height.
     */
    public static BinaryTreeNode<Integer> arrayToBST(Integer[] sortedValues) {
        return arrayToBST(sortedValues, 0, sortedValues.length - 1);
    }

    private static BinaryTreeNode<Integer> arrayToBST(Integer[] sortedValues, int minIndex, int maxIndex) {
        if(maxIndex < minIndex)
            return null;
        int rootIndex = (minIndex + maxIndex) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(sortedValues[rootIndex]);
        root.left = arrayToBST(sortedValues, minIndex, rootIndex - 1);
        root.right = arrayToBST(sortedValues, rootIndex + 1, maxIndex);
        return root;
    }
}
