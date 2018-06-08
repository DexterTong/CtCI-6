package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

public class Question06 {
    /**
     * 4.6
     * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
     * binary search tree. You may assume that each node has a link to its parent.
     */
    public static BinaryTreeNode<Integer> getNextNodeInBST(BinaryTreeNode<Integer> node) {

        // If the node has a right subtree, then the next node is the leftmost node in the right subtree
        if(node.right != null) {
            BinaryTreeNode<Integer> current = node.right;
            while(current.left != null) {
                current = current.left;
            }
            return current;
        }

        // Else, the next node is the lowest (farthest from the root) ancestor such that node is a left child of the ancestor
        BinaryTreeNode<Integer> current = node.parent;
        BinaryTreeNode<Integer> previous = node;
        while(current.left != previous) {
            current = current.parent;
            previous = previous.parent;
            if (current == null) {
                /*If we enter this block, then we have traversed all the way to the tree root along "right" edges,
                so the node must have been the rightmost (last) node in the tree */
                return null;
            }
        }
        return current;
    }
}
