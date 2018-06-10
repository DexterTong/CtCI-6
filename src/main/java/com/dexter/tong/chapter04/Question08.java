package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Question08 {

    /**
     * 4.8
     * Design an algorithm and write code to find the first common ancestor
     * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
     * necessarily a binary search tree.
     */
    public BinaryTreeNode<Integer> getLowestCommonAncestor(
            BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> nodeA, BinaryTreeNode<Integer> nodeB) {

        if(root == null || nodeA == null || nodeB == null)
            throw new NoSuchElementException();

        if(nodeA == nodeB)
            return nodeA;

        Result result = getLCA(root, nodeA, nodeB);

        if(!(result.foundNodeA && result.foundNodeB))
            throw new NoSuchElementException();
        else
            return result.node;
    }

    private Result getLCA(
            BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> nodeA, BinaryTreeNode<Integer> nodeB) {

        ArrayList<BinaryTreeNode<Integer>> children = new ArrayList<>(2);
        children.add(root.left);
        children.add(root.right);

        boolean foundNodeA = (root == nodeA);
        boolean foundNodeB = (root == nodeB);

        for(BinaryTreeNode<Integer> child : children) {
            Result childResult;
            if(child == null)
                childResult = new Result(null, false, false);
            else
                childResult = getLCA(child, nodeA, nodeB);

            if(childResult.foundNodeA && childResult.foundNodeB)
                return childResult;

            foundNodeA = foundNodeA || childResult.foundNodeA;
            foundNodeB = foundNodeB || childResult.foundNodeB;
        }

        return new Result(root, foundNodeA, foundNodeB);
    }

    private class Result{
        private BinaryTreeNode<Integer> node;
        private boolean foundNodeA;
        private boolean foundNodeB;

        private Result(BinaryTreeNode<Integer> node, boolean foundNodeA, boolean foundNodeB) {
            this.node = node;
            this.foundNodeA = foundNodeA;
            this.foundNodeB = foundNodeB;
        }
    }
}
