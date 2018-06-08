package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

import java.util.NoSuchElementException;

public class Question05 {

    /**
     * 4.5
     * Implement a function to check if a binary tree is a binary search tree.
     */
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        if(root == null)
            throw new NoSuchElementException();
        return validateBST(root.left, Integer.MIN_VALUE, root.data) && validateBST(root.right, root.data, Integer.MAX_VALUE);
    }

    private static boolean validateBST(BinaryTreeNode<Integer> node, Integer min, Integer max) {
        if(node == null)
            return true;
        if(node.data <= min || node.data > max)
            return false;
        return validateBST(node.left, min, node.data) && validateBST(node.right, node.data, max);
    }
}
