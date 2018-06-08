package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

public class Question04 {

    /**
     * 4.4
     * Implement a function to check if a binary tree is balanced. For the purposes of
     * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
     * node never differ by more than one.
     */
    public static boolean treeBalanced(BinaryTreeNode<Integer> root) {
        return getTreeHeightIfBalanced(root) >= 0;
    }

    private static int getTreeHeightIfBalanced(BinaryTreeNode<Integer> node) {
        if(node == null)
            return 0;

        int leftSubtreeHeight = getTreeHeightIfBalanced(node.left);
        if(leftSubtreeHeight < 0)
            return -1;

        int rightSubtreeHeight = getTreeHeightIfBalanced(node.right);
        if(rightSubtreeHeight < 0)
            return -1;

        if(Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
            return -1;

        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }
}
