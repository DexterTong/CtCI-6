package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question03 {

    /**
     * 4.3
     * Given a binary tree, design an algorithm which creates a linked list of all the nodes
     * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
     */

    public static ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepths(BinaryTreeNode<Integer> root) {
        if(root == null)
            return null;
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> depths = new ArrayList<>();
        LinkedList<BinaryTreeNode<Integer>> rootLevel = new LinkedList<>();
        rootLevel.add(root);
        depths.add(rootLevel);
        int i = 0;
        while(depths.get(i).size() > 0) {
            LinkedList<BinaryTreeNode<Integer>> nextDepth = new LinkedList<>();
            depths.add(nextDepth);
            for(BinaryTreeNode<Integer> btNode : depths.get(i)) {
                if(btNode.left != null)
                    nextDepth.add(btNode.left);
                if(btNode.right != null)
                    nextDepth.add(btNode.right);
            }
            i++;
        }
        // The last LL in depths will be empty, so remove it
        depths.remove(i);
        return depths;
    }
}
