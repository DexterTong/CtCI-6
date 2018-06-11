package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

import java.util.Arrays;

public class Question12 {

    /**
     * 4.12
     * You are given a binary tree in which each node contains an integer value (which
     * might be positive or negative). Design an algorithm to count the number of paths that sum to a
     * given value. The path does not need to start or end at the root or a leaf, but it must go downwards
     * (traveling only from parent nodes to child nodes).
     */
    public static int pathsWithSum(BinaryTreeNode<Integer> root, int sum) {
        /*  This is pretty much a simulation of countPathsWithSum() on the root node
            The other option is to give the root node a temporary parent so that countPathsWithSum() will work on it
        */
        if (root == null)
            return 0;

        root.pathSums = new int[]{root.data};
        int pathCount = root.data == sum ? 1 : 0;

        pathCount += countPathsWithSum(root.left, sum) + countPathsWithSum(root.right, sum);
        return pathCount;
    }

    private static int countPathsWithSum(BinaryTreeNode<Integer> node, int sum) {
        if (node == null)
            return 0;

        int pathCount = 0;
        node.pathSums = Arrays.copyOf(node.parent.pathSums, node.parent.pathSums.length + 1);
        for (int i = 0; i < node.pathSums.length; i++) {
            node.pathSums[i] += node.data;
            if (node.pathSums[i] == sum)
                pathCount++;
        }

        pathCount += countPathsWithSum(node.left, sum) + countPathsWithSum(node.right, sum);
        return pathCount;
    }
}
