package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;

public class Question10 {

    /**
     * 4.10
     * Tl and T2 are two very large binary trees, with T1 much bigger than T2. Create an
     * algorith m to determine if T2 is a subtree of T1 .
     * A tree T2 is a subtree ofTi if there exists a node n in Ti such that the subtree of n is identical to T2.
     * That is, if you cut off the tree at node n, the two trees would be identical.
     */
    public static boolean subtreeOfTree(BinaryTreeNode<Integer> treeRoot, BinaryTreeNode<Integer> subtreeRoot) {
        String treeTraversal = preOrderTraversal(treeRoot);
        String subtreeTraversal = preOrderTraversal(subtreeRoot);
        return treeTraversal.contains(subtreeTraversal);
    }

    private static String preOrderTraversal(BinaryTreeNode<Integer> root) {
        if(root == null)
            return Character.toString('\0');
        StringBuilder traversal = new StringBuilder();
        traversal.append(root.data);
        traversal.append(preOrderTraversal(root.left));
        traversal.append(preOrderTraversal(root.right));
        return traversal.toString();
    }
}
