package com.dexter.tong.chapter04;

public class Question11 {
    /**
     * 4.11
     * You are implementing a binary tree class from scratch which, in addition to
     * insert, find, and delete, has a method getRandomNode() which returns a random node
     * from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
     * for getRandomNode, and explain how you would implement the rest of the methods.
     */
    public class BinaryRandomTree {

        BinaryRandomTreeNode root;

        public void insert(int n) {
            /*
            Implementation:
                1. Visit the root node
                2. Increment root.subtreeSize by 1
                3. Decide where to insert the new node, either as a left or right child of root (algorithm tbd)
                4a. If the decided location (root.left or root.right) is null, insert it there, then return
                4b. Else, goto 1, repeating the process on either root.left or root.right
             */
        }

        public BinaryRandomTreeNode find(int n) {
            /*
            If the insertion algorithm in insert() makes this a binary tree, this is a simple binary search
            Else, we have to do a tree traversal to find the node corresponding to int n, if it exists
             */
            return null;
        }

        public boolean delete(int n) {
            /*
            If this is a binary tree, there's a little work involved here
            Else,
                1. Traverse down the tree to find the node
                2. Replace whichever of node.parent's children points to node with node.left
                3. Find a suitable place to insert node.right under node.left's subtree.
                4. Traverse back up the tree from the former node.right to update subtree sizes
             */
            return false;
        }

        public BinaryRandomTreeNode getRandomNode() {
            /*
            Implementation:
                1. Pick a random int from [0, root.subtreeSize)
                2a. If the int is 0, return root
                2b. If the int is on the range [1, root.left.subtreeSize], recurse (go to 1, replacing root with root.left)
                2c. Else, recurse (go to 1, replacing root with root.right)
             */
            return null;
        }

        private class BinaryRandomTreeNode {
            private int value;
            private int subtreeSize;
            private BinaryRandomTreeNode left;
            private BinaryRandomTreeNode right;
            private BinaryRandomTreeNode parent;
        }
    }
}
